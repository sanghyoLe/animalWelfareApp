package com.example.animal_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DetailSearchNormalMemberActivity extends AppCompatActivity {
    QuestionTemplateViewModel viewModel;

    private View resultTotalView;


    private String evaInfoId;
    private String searchCowKind;
    private Integer farmType;
    private String mJsonString;
    private String grade;
    private ImageButton backBtn;

    private TextView totalScoreTitleTv;
    private TextView totalScoreExplainTv;

    private TextView searchFindNothingView;
    private LinearLayout searchFindOkView;
    private ImageView totalScoreImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_search_normal_member);
        viewModel = new ViewModelProvider(this).get(QuestionTemplateViewModel.class);


        Intent beforeIntent = getIntent();

        evaInfoId = beforeIntent.getStringExtra("evaInfoId");
        searchCowKind = beforeIntent.getStringExtra("searchCowKind");

        searchFindNothingView = findViewById(R.id.search_find_nothing);
        searchFindOkView = findViewById(R.id.search_find_ok);

        resultTotalView = findViewById(R.id.detail_search_result_total);
        totalScoreImageView = resultTotalView.findViewById(R.id.total_score_image_view);
        totalScoreTitleTv = resultTotalView.findViewById(R.id.total_score_title_tv);
        totalScoreExplainTv = resultTotalView.findViewById(R.id.total_score_explain_tv);

        backBtn = findViewById(R.id.back_btn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        GetScoreData task = new GetScoreData();
        task.execute("http://218.151.112.65/getNormalSearchResultJson.php",
                searchCowKind,
                evaInfoId
        );



    }





    private class GetScoreData extends AsyncTask<String, Void, String> {

        ProgressDialog progressDialog;
        String errorString = null;

        private String mJsonString;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(DetailSearchNormalMemberActivity.this,
                    "Please Wait", null, true, true);
        }


        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            progressDialog.dismiss();


            if(result.equals("searchNothing")){
                searchFindNothingView.setVisibility(View.VISIBLE);
            }else {
                searchFindOkView.setVisibility(View.VISIBLE);
                mJsonString = result;
                showResult();
            }


        }


        @Override
        protected String doInBackground(String... params) {

            String serverURL = params[0];
            String searchCowKind = params[1];
            String farmId = params[2];
            String postParameters =
                    "searchCowKind=" + searchCowKind
                            +"&farmId=" + farmId;


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
                Log.d("GetScoreData", "response code - " + responseStatusCode);


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

                Log.d("GetScoreData", "GetData : Error ", e);
                errorString = e.toString();

                return null;
            }

        }

        private void showResult(){

            String TAG_JSON = "evaTotalScore";
//            String TAG_FEED_WATER = "feedWater";
//            String TAG_STOCK_ENV = "stockEnvironment";
//            String TAG_HEALTH ="healthStatus";
//            String TAG_BEHAVIOR = "behavior";
//            String TAG_NUTRITION = "nutrition";
//            String TAG_DRINK_WATER ="drinkWater";
//            String TAG_REST = "rest";
//            String TAG_HEAT_VEN =  "heatVentilation";
//            String TAG_WOUND = "wound";
//            String TAG_DISEASE = "disease";
//            String TAG_PAIN = "pain";
//            String TAG_SOCIAL_BEHAVIOR = "socialBehavior";
//            String TAG_HUMAN_LIVE_STOCK=  "humanLiveStock";
            String TAG_GRADE = "grade";

            try{
                JSONObject jsonObject = new JSONObject(mJsonString);
                JSONArray jsonArray = jsonObject.getJSONArray(TAG_JSON);

                JSONObject item = jsonArray.getJSONObject(0);

                grade = item.getString(TAG_GRADE);
//                feedWaterScore = item.getString(TAG_FEED_WATER);
//                nutritionScore = item.getString(TAG_NUTRITION);
//                waterScore = item.getString(TAG_DRINK_WATER);
//
//                stockEnvScore = item.getString(TAG_STOCK_ENV);
//                restScore = item.getString(TAG_REST);
//                headVenScore = item.getString(TAG_HEAT_VEN);
//





                setTextViewText();
                
            } catch (JSONException e){
                Log.d("DetailSearch","showResult : ", e);
            }
        }
    }
    private void setTextViewText(){
        // Result Total View
        if(grade.equals("Excellent")){
            totalScoreImageView.setImageResource(R.drawable.outline_sentiment_very_satisfied_24);
            totalScoreTitleTv.setText("우수");
            totalScoreTitleTv.setTextColor(Color.parseColor("#0000FF"));
            totalScoreExplainTv.setText(R.string.total_score_explain_excellent);
        }else if(grade.equals("Enhanced")){
            totalScoreImageView.setImageResource(R.drawable.outline_sentiment_satisfied_alt_24);
            totalScoreTitleTv.setText("양호");
            totalScoreTitleTv.setTextColor(Color.parseColor("#32CD32"));
            totalScoreExplainTv.setText(R.string.total_score_explain_enhance);
        }else if(grade.equals("Acceptable")){
            totalScoreImageView.setImageResource(R.drawable.outline_sentiment_dissatisfied_24);
            totalScoreTitleTv.setText("허용");
            totalScoreTitleTv.setTextColor(Color.parseColor("#D2691E"));
            totalScoreExplainTv.setText(R.string.total_score_explain_acceptable);
        } else {
            totalScoreImageView.setImageResource(R.drawable.outline_sick_24);
            totalScoreTitleTv.setText("분류불가");
            totalScoreTitleTv.setTextColor(Color.parseColor("#FF0000"));
            totalScoreExplainTv.setText(R.string.total_score_explain_not_classified);
        }






    }
}