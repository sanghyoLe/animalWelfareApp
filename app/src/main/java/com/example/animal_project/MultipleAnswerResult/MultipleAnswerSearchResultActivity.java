package com.example.animal_project.MultipleAnswerResult;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.animal_project.R;
import com.example.animal_project.Result.EvaAnswerAdapter;
import com.example.animal_project.Result.EvaAnswerData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MultipleAnswerSearchResultActivity extends AppCompatActivity {
    private String questionName;
    private String searchCowKind;
    private String evaInfoId;

    private ArrayList<WaterTimeData> waterTimeList;
    private WaterTimeAdapter waterTimeAdapter;
    private RecyclerView mRecyclerView;

    private ImageButton backBtn;
    private TextView titleTv;
    private View identifiersView;
    private View waterTimeIdentifierView;
    private final String IP_ADDRESS = "218.151.112.65";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_answer_search_result);
        Intent beforeIntent = getIntent();

        titleTv = findViewById(R.id.multiple_answer_title);
        identifiersView = findViewById(R.id.multiple_answer_identifiers);
        waterTimeIdentifierView = identifiersView.findViewById(R.id.water_time_identifier);
        backBtn = findViewById(R.id.back_btn);


        mRecyclerView = (RecyclerView) findViewById(R.id.multiple_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        waterTimeList = new ArrayList<>();
        waterTimeAdapter = new WaterTimeAdapter(this, waterTimeList);


       questionName =  beforeIntent.getStringExtra("questionName");
       searchCowKind = beforeIntent.getStringExtra("searchCowKind");
       evaInfoId = beforeIntent.getStringExtra("evaInfoId");

       backBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               finish();
           }
       });

        GetMultipleAnswerJson task = new GetMultipleAnswerJson();
        task.execute("http://" + IP_ADDRESS + "/getMultipleAnswerResultJson.php",
                searchCowKind,
                evaInfoId,
                questionName
        );



    }
    private class GetMultipleAnswerJson extends AsyncTask<String, Void, String> {

        ProgressDialog progressDialog;
        String errorString = null;

        private String mJsonString;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(MultipleAnswerSearchResultActivity.this,
                    "Please Wait", null, true, true);
        }


        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            progressDialog.dismiss();

            mJsonString = result;

            getResult();

        }


        @Override
        protected String doInBackground(String... params) {

            String serverURL = params[0];
            String searchCowKind = params[1];
            String farmId = params[2];
            String questionName = params[3];
            String postParameters =
                                "searchCowKind=" + searchCowKind
                                +"&farmId=" + farmId
                                +"&questionName=" + questionName;



            try {

                URL url = new URL(serverURL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();


                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.connect();


                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(postParameters.getBytes("UTF-8"));
                outputStream.flush();
                outputStream.close();


                int responseStatusCode = httpURLConnection.getResponseCode();
                Log.d("MultipleAnswerQuestion", "response code - " + responseStatusCode);


                InputStream inputStream;
                if(responseStatusCode == HttpURLConnection.HTTP_OK) {
                    inputStream = httpURLConnection.getInputStream();
                }
                else{
                    inputStream = httpURLConnection.getErrorStream();
                }


                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                StringBuilder sb = new StringBuilder();
                String line;

                while((line = bufferedReader.readLine()) != null){
                    sb.append(line);
                }

                bufferedReader.close();

                return sb.toString().trim();


            } catch (Exception e) {

                Log.d("MultipleAnswerQuestion", "adminMemberSearchResult : Error ", e);
                errorString = e.toString();

                return null;
            }

        }

        private void getResult(){






            try{
                JSONObject jsonObject = new JSONObject(mJsonString);
                if(jsonObject.has("waterTime")){
                    titleTv.setText("음수 대기 우 여부 및 음수 시간");
                    waterTimeIdentifierView.setVisibility(View.VISIBLE);
                    mRecyclerView.setAdapter(waterTimeAdapter);
                    waterTimeList.clear();
                    waterTimeAdapter.notifyDataSetChanged();

                    JSONArray jsonArray = jsonObject.getJSONArray("waterTime");
                    for(int i = 0 ; i < jsonArray.length() ; i++){
                        JSONObject item = jsonArray.getJSONObject(i);
                        String penLocation = item.getString("penLocation");
                        String dongTotalCowSize = item.getString("dongTotalcowSize");
                        String answerCowSize = item.getString("answerCowSize");
                        String answer = item.getString("answer");
                        String score = item.getString("score");
                        String ratio = item.getString("ratio");
                        if(answer.equals("0")){
                            answer = "양호";
                        }else if(answer.equals("1")){
                            answer = "보통";
                        }else {
                            answer = "미흡";
                        }
                        WaterTimeData waterTimeData = new WaterTimeData();

                        waterTimeData.setPenLocation(penLocation);
                        waterTimeData.setDongTotalCowSize(dongTotalCowSize);
                        waterTimeData.setAnswerCowSize(answerCowSize);
                        waterTimeData.setAnswer(answer);
                        waterTimeData.setScore(score);
                        waterTimeData.setRatio(ratio);

                        waterTimeList.add(waterTimeData);
                        waterTimeAdapter.notifyDataSetChanged();;
                    }
                }

            } catch (JSONException e){
                Log.d("MultipleAnswerQuestion","showResult : ", e);
            }

        }
        }
    }