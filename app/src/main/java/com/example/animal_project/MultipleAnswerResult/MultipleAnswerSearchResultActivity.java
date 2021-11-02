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

    private ArrayList<CoughStruggleHarmonyData> coughStruggleHarmonyDataList;
    private CoughStruggleHarmonyAdapter coughStruggleHarmonyAdapter;

    private ArrayList<StrawData> strawDataList;
    private StrawAdapter strawAdapter;

    private ArrayList<AvoidDistanceData> avoidDistanceDataList;
    private AvoidDistanceAdapter avoidDistanceAdapter;

    private ArrayList<FreeStallCountData> freeStallCountDataList;
    private FreeStallCountAdapter freeStallCountAdapter;

    private ArrayList<SitQuestionData> sitQuestionDataList;
    private SitQuestionAdapter sitQuestionAdapter;

    private ArrayList<MilkCowStruggleData> milkCowStruggleDataList;
    private MilkCowStruggleAdapter milkCowStruggleAdapter;

    private RecyclerView mRecyclerView;

    private ImageButton backBtn;
    private TextView titleTv;
    private View identifiersView;
    private View waterTimeIdentifierView;
    private View coughIdentifierView;
    private View beefBehaviorIdentifierView;
    private View strawIdentifierView;
    private View avoidDistanceIdentifierView;
    private View freeStallCountIdentifierView;
    private View sitCollisionIdentifierView;
    private View sitTimeIdentifierView;
    private View milkCowIdentifierView;
    private final String IP_ADDRESS = "218.151.112.65";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_answer_search_result);
        Intent beforeIntent = getIntent();
        questionName =  beforeIntent.getStringExtra("questionName");
        searchCowKind = beforeIntent.getStringExtra("searchCowKind");
        evaInfoId = beforeIntent.getStringExtra("evaInfoId");


        titleTv = findViewById(R.id.multiple_answer_title);
        identifiersView = findViewById(R.id.multiple_answer_identifiers);
        waterTimeIdentifierView = identifiersView.findViewById(R.id.water_time_identifier);
        coughIdentifierView = identifiersView.findViewById(R.id.cough_identifier);
        beefBehaviorIdentifierView = identifiersView.findViewById(R.id.beef_behavior_identifier);
        strawIdentifierView = identifiersView.findViewById(R.id.straw_identifier);
        avoidDistanceIdentifierView = identifiersView.findViewById(R.id.avoid_distance_identifier);
        freeStallCountIdentifierView = identifiersView.findViewById(R.id.free_stall_identifier);
        sitCollisionIdentifierView = identifiersView.findViewById(R.id.sit_collision_identifier);
        sitTimeIdentifierView = identifiersView.findViewById(R.id.sit_time_identifier);
        milkCowIdentifierView = identifiersView.findViewById(R.id.milk_cow_struggle_identifier);


        backBtn = findViewById(R.id.back_btn);



        mRecyclerView = (RecyclerView) findViewById(R.id.multiple_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        waterTimeList = new ArrayList<>();
        waterTimeAdapter = new WaterTimeAdapter(this, waterTimeList);

        coughStruggleHarmonyDataList = new ArrayList<>();
        coughStruggleHarmonyAdapter = new CoughStruggleHarmonyAdapter(this, coughStruggleHarmonyDataList);

        strawDataList = new ArrayList<>();
        strawAdapter = new StrawAdapter(this, strawDataList);

        avoidDistanceDataList = new ArrayList<>();
        avoidDistanceAdapter = new AvoidDistanceAdapter(this, avoidDistanceDataList,searchCowKind);

        freeStallCountDataList = new ArrayList<>();
        freeStallCountAdapter = new FreeStallCountAdapter(this, freeStallCountDataList);

        sitQuestionDataList = new ArrayList<>();
        sitQuestionAdapter = new SitQuestionAdapter(this,sitQuestionDataList);

        milkCowStruggleDataList = new ArrayList<>();
        milkCowStruggleAdapter = new MilkCowStruggleAdapter(this, milkCowStruggleDataList);



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
                        waterTimeAdapter.notifyDataSetChanged();
                    }
                }
                else if(jsonObject.has("cough")){
                    titleTv.setText("기침");
                    coughIdentifierView.setVisibility(View.VISIBLE);
                    mRecyclerView.setAdapter(coughStruggleHarmonyAdapter);
                    coughStruggleHarmonyDataList.clear();
                    coughStruggleHarmonyAdapter.notifyDataSetChanged();

                    JSONArray jsonArray = jsonObject.getJSONArray("cough");
                    for(int i = 0 ; i < jsonArray.length() ; i++){
                        JSONObject item = jsonArray.getJSONObject(i);
                        String penLocation = item.getString("penLocation");
                        String dongTotalCowSize = item.getString("dongTotalCowSize");
                        String answer = item.getString("answer");
                        String answerPerOne = item.getString("answerPerOne");


                        CoughStruggleHarmonyData coughData = new CoughStruggleHarmonyData();

                        coughData.setPenLocation(penLocation);
                        coughData.setDongTotalCowSize(dongTotalCowSize);
                        coughData.setAnswer(answer);
                        coughData.setAnswerPenOne(answerPerOne);

                        coughStruggleHarmonyDataList.add(coughData);
                        coughStruggleHarmonyAdapter.notifyDataSetChanged();
                    }
                }
                else if(jsonObject.has("struggle")){
                    titleTv.setText("투쟁(서열) 행동 - 한육우");
                    beefBehaviorIdentifierView.setVisibility(View.VISIBLE);
                    mRecyclerView.setAdapter(coughStruggleHarmonyAdapter);
                    coughStruggleHarmonyDataList.clear();
                    coughStruggleHarmonyAdapter.notifyDataSetChanged();

                    JSONArray jsonArray = jsonObject.getJSONArray("struggle");
                    for(int i = 0 ; i < jsonArray.length() ; i++){
                        JSONObject item = jsonArray.getJSONObject(i);
                        String penLocation = item.getString("penLocation");
                        String dongTotalCowSize = item.getString("dongTotalCowSize");
                        String answer = item.getString("answer");
                        String answerPerOne = item.getString("answerPerOne");


                        CoughStruggleHarmonyData struggleData = new CoughStruggleHarmonyData();

                        struggleData.setPenLocation(penLocation);
                        struggleData.setDongTotalCowSize(dongTotalCowSize);
                        struggleData.setAnswer(answer);
                        struggleData.setAnswerPenOne(answerPerOne);

                        coughStruggleHarmonyDataList.add(struggleData);
                        coughStruggleHarmonyAdapter.notifyDataSetChanged();
                    }
                }
                else if(jsonObject.has("harmony")){
                    titleTv.setText("화합 행동");
                    beefBehaviorIdentifierView.setVisibility(View.VISIBLE);
                    mRecyclerView.setAdapter(coughStruggleHarmonyAdapter);
                    coughStruggleHarmonyDataList.clear();
                    coughStruggleHarmonyAdapter.notifyDataSetChanged();

                    JSONArray jsonArray = jsonObject.getJSONArray("harmony");
                    for(int i = 0 ; i < jsonArray.length() ; i++){
                        JSONObject item = jsonArray.getJSONObject(i);
                        String penLocation = item.getString("penLocation");
                        String dongTotalCowSize = item.getString("dongTotalCowSize");
                        String answer = item.getString("answer");
                        String answerPerOne = item.getString("answerPerOne");


                        CoughStruggleHarmonyData coughData = new CoughStruggleHarmonyData();

                        coughData.setPenLocation(penLocation);
                        coughData.setDongTotalCowSize(dongTotalCowSize);
                        coughData.setAnswer(answer);
                        coughData.setAnswerPenOne(answerPerOne);

                        coughStruggleHarmonyDataList.add(coughData);
                        coughStruggleHarmonyAdapter.notifyDataSetChanged();
                    }


                }
                else if(jsonObject.has("straw")){
                    titleTv.setText("깔짚 수분");
                    strawIdentifierView.setVisibility(View.VISIBLE);
                    mRecyclerView.setAdapter(strawAdapter);
                    strawDataList.clear();
                    strawAdapter.notifyDataSetChanged();

                    JSONArray jsonArray = jsonObject.getJSONArray("straw");
                    for(int i = 0 ; i < jsonArray.length() ; i++){
                        JSONObject item = jsonArray.getJSONObject(i);
                        String penLocation = item.getString("penLocation");
                        String answerOne = item.getString("answerOne");
                        String answerTwo = item.getString("answerTwo");
                        String answerThree = item.getString("answerThree");
                        String score = item.getString("score");
                        if(answerOne.equals("0")) {
                            answerOne = "X";
                        } else {
                            answerOne = "O";
                        }
                        if(answerTwo.equals("0")){
                            answerTwo = "X";
                        }else {
                            answerTwo = "O";
                        }
                        if(answerThree.equals("0")){
                            answerThree = "X";
                        } else {
                            answerThree = "O";
                        }

                        StrawData strawData = new StrawData();

                        strawData.setPenLocation(penLocation);
                        strawData.setAnswerOne(answerOne);
                        strawData.setAnswerTwo(answerTwo);
                        strawData.setAnswerThree(answerThree);
                        strawData.setScore(score);

                        strawDataList.add(strawData);
                        strawAdapter.notifyDataSetChanged();
                    }
                }
                else if(jsonObject.has("avoidDistance")){
                    titleTv.setText("회피 거리");
                    avoidDistanceIdentifierView.setVisibility(View.VISIBLE);
                    mRecyclerView.setAdapter(avoidDistanceAdapter);
                    avoidDistanceDataList.clear();
                    avoidDistanceAdapter.notifyDataSetChanged();

                    JSONArray jsonArray = jsonObject.getJSONArray("avoidDistance");
                    for(int i = 0 ; i < jsonArray.length() ; i++){
                        JSONObject item = jsonArray.getJSONObject(i);
                        String penLocation = item.getString("penLocation");
                        String cowSize = item.getString("cowSize");
                        String id = item.getString("id");


                        AvoidDistanceData avoidDistanceData = new AvoidDistanceData();

                        avoidDistanceData.setId(id);
                        avoidDistanceData.setCowSize(cowSize);
                        avoidDistanceData.setPenLocation(penLocation);

                        avoidDistanceDataList.add(avoidDistanceData);
                        avoidDistanceAdapter.notifyDataSetChanged();
                    }
                }
                else if(jsonObject.has("freeStallCount")){
                    titleTv.setText("프리스톨 수");
                    freeStallCountIdentifierView.setVisibility(View.VISIBLE);
                    mRecyclerView.setAdapter(freeStallCountAdapter);
                    freeStallCountDataList.clear();
                    freeStallCountAdapter.notifyDataSetChanged();

                    JSONArray jsonArray = jsonObject.getJSONArray("freeStallCount");
                    for(int i = 0 ; i < jsonArray.length() ; i++){
                        JSONObject item = jsonArray.getJSONObject(i);
                        String cowSize = item.getString("cowSize");
                        String freeStallCount = item.getString("freeStallCount");
                        String score = item.getString("score");
                        String ratio = item.getString("ratio");



                        FreeStallCountData freeStallCountData = new FreeStallCountData();

                        freeStallCountData.setCowSize(cowSize);
                        freeStallCountData.setFreeStallCount(freeStallCount);
                        freeStallCountData.setScore(score);
                        freeStallCountData.setRatio(ratio);


                        freeStallCountDataList.add(freeStallCountData);
                        freeStallCountAdapter.notifyDataSetChanged();
                    }
                }
                else if(jsonObject.has("sitCollision")){
                    titleTv.setText("앉기 시 충돌");
                    sitCollisionIdentifierView.setVisibility(View.VISIBLE);
                    mRecyclerView.setAdapter(sitQuestionAdapter);
                    sitQuestionDataList.clear();
                    sitQuestionAdapter.notifyDataSetChanged();

                    JSONArray jsonArray = jsonObject.getJSONArray("sitCollision");
                    for(int i = 0 ; i < jsonArray.length() ; i++)
                    {
                        JSONObject item = jsonArray.getJSONObject(i);

                        String answer = item.getString("answer");
                        if(answer.equals("true")){
                            answer = "예";
                        } else{
                            answer = "아니오";
                        }

                        SitQuestionData sitQuestionData = new SitQuestionData();

                        sitQuestionData.setAnswer(answer);


                        sitQuestionDataList.add(sitQuestionData);
                        sitQuestionAdapter.notifyDataSetChanged();
                    }
                }
                else if(jsonObject.has("sitTime")){
                    titleTv.setText("앉기 동작 소요시간");
                    sitTimeIdentifierView.setVisibility(View.VISIBLE);
                    mRecyclerView.setAdapter(sitQuestionAdapter);
                    sitQuestionDataList.clear();
                    sitQuestionAdapter.notifyDataSetChanged();

                    JSONArray jsonArray = jsonObject.getJSONArray("sitTime");
                    for(int i = 0 ; i < jsonArray.length() ; i++){
                        JSONObject item = jsonArray.getJSONObject(i);

                        String answer = item.getString("answer");

                        SitQuestionData sitQuestionData = new SitQuestionData();

                        sitQuestionData.setAnswer(answer);


                        sitQuestionDataList.add(sitQuestionData);
                        sitQuestionAdapter.notifyDataSetChanged();
                    }
                }
                else if(jsonObject.has("milkCowStruggle")){
                    titleTv.setText("투쟁(서열) 행동 - 착유우");
                    milkCowIdentifierView.setVisibility(View.VISIBLE);
                    mRecyclerView.setAdapter(milkCowStruggleAdapter);
                    milkCowStruggleDataList.clear();
                    milkCowStruggleAdapter.notifyDataSetChanged();

                    JSONArray jsonArray = jsonObject.getJSONArray("milkCowStruggle");
                    for(int i = 0 ; i < jsonArray.length() ; i++){
                        JSONObject item = jsonArray.getJSONObject(i);

                        String cowSize = item.getString("cowSize");
                        String penLocation = item.getString("penLocation");
                        String headBangCount = item.getString("headBangCount");
                        String headBangPerOne = item.getString("headBangPerOne");
                        String headBangExceptStruggleCount = item.getString("headBangExceptStruggleCount");
                        String headBangExceptStrugglePerOne = item.getString("headBangExceptStrugglePerOne");
                        String struggleIndex = item.getString("struggleIndex");
                        String score = item.getString("score");



                        MilkCowStruggleData milkCowStruggleData = new MilkCowStruggleData();
                        milkCowStruggleData.setCowSize(cowSize);
                        milkCowStruggleData.setPenLocation(penLocation);
                        milkCowStruggleData.setHeadBangCount(headBangCount);
                        milkCowStruggleData.setHeadBangPerOne(headBangPerOne);
                        milkCowStruggleData.setHeadBandExceptStruggleCount(headBangExceptStruggleCount);
                        milkCowStruggleData.setHeadBangExceptStringPerOne(headBangExceptStrugglePerOne);
                        milkCowStruggleData.setStruggleIndex(struggleIndex);
                        milkCowStruggleData.setScore(score);






                        milkCowStruggleDataList.add(milkCowStruggleData);
                        milkCowStruggleAdapter.notifyDataSetChanged();
                    }
                }
                else {
                    titleTv.setText("평가 결과를 찾을 수 없습니다.");

                }
            } catch (JSONException e){
                Log.d("MultipleAnswerQuestion","showResult : ", e);
            }

        }
    }
}