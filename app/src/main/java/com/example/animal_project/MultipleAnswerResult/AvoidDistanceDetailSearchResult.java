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
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.animal_project.R;

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

public class AvoidDistanceDetailSearchResult extends AppCompatActivity {
    private TextView penLocationTv;
    private TextView cowSizeTv;
    private String id;
    private String searchCowKind;
    private final String IP_ADDRESS = "218.151.112.65";

    private ImageButton backBtn;
    private ArrayList<AvoidDistanceData> avoidDistanceDetailDataList;
    private AvoidDistanceDetailAdapter avoidDistanceDetailAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avoid_distance_detail_search_result);
        Intent intent = getIntent();

        id = intent.getStringExtra("id");
        String penLocation = intent.getStringExtra("penLocation");
        String cowSize = intent.getStringExtra("cowSize");
        searchCowKind = intent.getStringExtra("searchCowKind");

        backBtn = findViewById(R.id.back_btn);
        penLocationTv = findViewById(R.id.pen_location_tv);
        cowSizeTv = findViewById(R.id.cow_size_tv);



        avoidDistanceDetailDataList = new ArrayList<>();
        avoidDistanceDetailAdapter = new AvoidDistanceDetailAdapter(this,avoidDistanceDetailDataList);


        recyclerView = (RecyclerView) findViewById(R.id.avoid_distance_detail_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        penLocationTv.setText(penLocation);
        cowSizeTv.setText(cowSize);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        recyclerView.setAdapter(avoidDistanceDetailAdapter);
        avoidDistanceDetailDataList.clear();
        avoidDistanceDetailAdapter.notifyDataSetChanged();



        GetAvoidDistanceDetail  task =  new GetAvoidDistanceDetail();
        task.execute("http://" + IP_ADDRESS + "/getAvoidDistanceDetailJson.php",
                id,
                searchCowKind);


    }
    private class GetAvoidDistanceDetail extends AsyncTask<String, Void, String> {

        ProgressDialog progressDialog;
        String errorString = null;

        private String mJsonString;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(AvoidDistanceDetailSearchResult.this,
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
            String avoidDistanceId = params[1];
            String searchCowKind = params[2];
            String postParameters =
                    "avoidDistanceId=" + avoidDistanceId
                    +"&searchCowKind=" + searchCowKind;



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
                Log.d("GetAvoidDistanceDetail", "response code - " + responseStatusCode);


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

                Log.d("GetAvoidDistanceDetail", "adminMemberSearchResult : Error ", e);
                errorString = e.toString();

                return null;
            }

        }

        private void getResult(){
            try{
                JSONObject jsonObject = new JSONObject(mJsonString);
                if(jsonObject.has("avoidDistanceDetail")){


                    JSONArray jsonArray = jsonObject.getJSONArray("avoidDistanceDetail");
                    for(int i = 0 ; i < jsonArray.length() ; i++){
                        JSONObject item = jsonArray.getJSONObject(i);

                        String cowNumber = item.getString("cowNumber");
                        String avoidDistanceLevel = item.getString("avoidDistanceLevel");

                        AvoidDistanceData avoidDistanceDetailData = new AvoidDistanceData();

                        avoidDistanceDetailData.setCowNumber(cowNumber);
                        avoidDistanceDetailData.setAvoidDistanceLevel(avoidDistanceLevel);

                        avoidDistanceDetailDataList.add(avoidDistanceDetailData);
                        avoidDistanceDetailAdapter.notifyDataSetChanged();
                    }
                }
            } catch (JSONException e){
                Log.d("GetAvoidDistanceDetail","showResult : ", e);
            }

        }
    }
}