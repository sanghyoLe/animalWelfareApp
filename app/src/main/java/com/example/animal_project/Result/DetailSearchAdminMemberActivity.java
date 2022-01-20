package com.example.animal_project.Result;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ThemedSpinnerAdapter;

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

public class DetailSearchAdminMemberActivity extends AppCompatActivity {





    private ArrayList<EvaAnswerData> mArrayList;
    private EvaAnswerAdapter evaAnswerAdapter;
    private RecyclerView mRecyclerView;

    private ArrayList<EvaAnswerData> detailArrayList;
    private EvaDetailAnswerAdapter evaDetailAnswerAdapter;
    private RecyclerView detailAnswerRecyclerView;

    private ArrayList<EvaAnswerData> scoreDataList;
    private EvaAnswerAdapter evaScoreAdapter;
    private RecyclerView scoreRecyclerView;

    private ArrayList<EvaAnswerData> ratioDataList;
    private EvaAnswerAdapter evaRatioAdapter;
    private RecyclerView ratioRecyclerView;


    private String evaInfoId;
    private String searchCowKind;

    private View basicInformationView;


    private View evaAnswerView;
    private View haveFoundAnswerView;
    private View haveNotFoundAnswerView;



    private View evaDetailAnswerView;
    private View haveFoundDetailAnswerView;
    private View haveNotFoundDetailAnswerView;


    private View evaScoreView;
    private View evaRatioView;
    private View haveFoundScoreView;
    private View haveFoundRatioView;
    private View haveNotFoundScoreView;
    private View haveNotFoundRatioView;

    // totalScore view
    private View totalScoreView;
    private TextView feedWaterScoreTv;
    private TextView stockEnvScoreTv;
    private TextView healthStatusScoreTv;
    private TextView behaviorScoreTv;
    private TextView nutritionScoreTv;
    private TextView drinkWaterScoreTv;
    private TextView restScoreTv;
    private TextView heatVentilatingScoreTv;
    private TextView woundScoreTv;
    private TextView diseaseScoreTv;
    private TextView painScoreTv;
    private TextView socialBehaviorScoreTv;
    private TextView humanLiveStockScoreTv;

    private TextView gradeTv;



    private String farmName;
    private String zipCode;
    private String address;
    private String addressDetail;
    private String repName;
    private String farmType;
    private String totalCowSize;
    private String adultCowSize;
    private String childCowSize;
    private String sampleCowSize;
    private String milkCowSize;
    private String dryMilkCowSize;
    private String pregnantCowSize;
    private String evaName;
    private String evaDate;


    private ImageButton backBtn;
    private TextView farmNameTv;
    private TextView zipCodeTv;
    private TextView addressTv;
    private TextView addressDetailTv;
    private TextView repNameTv;
    private TextView farmTypeTv;
    private TextView totalCowTv;
    private TextView adultCowTv;
    private TextView childCowTv;
    private TextView sampleCowTv;
    private TextView evaNameTv;
    private TextView evaDateTv;
    private TextView milkCowTv;
    private TextView dryMilkCowTv;
    private TextView pregnantCowTv;


    private TextView basicInfoTv;
    private TextView evaAnswerTv;
    private TextView evaDetailAnswerTv;
    private TextView detailSearchTitleTv;
    private TextView evaScoreTv;
    private TextView evaRatioTv;

    private View detailSearchListMenuView;
    private ImageButton listBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_search_admin_member);


        Intent beforeIntent = getIntent();
        evaInfoId = beforeIntent.getStringExtra("evaInfoId");
        searchCowKind = beforeIntent.getStringExtra("searchCowKind");

        detailSearchTitleTv = findViewById(R.id.detail_search_title);
        detailSearchListMenuView = findViewById(R.id.detail_search_list_view);
        basicInfoTv = detailSearchListMenuView.findViewById(R.id.basic_info_tv);
        evaAnswerTv = detailSearchListMenuView.findViewById(R.id.eva_answer_tv);
        evaDetailAnswerTv = detailSearchListMenuView.findViewById(R.id.eva_detail_answer_tv);
        evaScoreTv = detailSearchListMenuView.findViewById(R.id.eva_score_tv);
        evaRatioTv = detailSearchListMenuView.findViewById(R.id.eva_ratio_tv);




        basicInformationView = findViewById(R.id.basic_information_table);

        listBtn = findViewById(R.id.detail_search_list_btn);
        backBtn = findViewById(R.id.back_btn);


        listBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerHandler();
            }
        });

        // 목록에 있는 TextView 클릭시 화면 전환
        changeSearchResultView();

//        // 평가 정보 Layout, RecyclerView
        evaAnswerView = findViewById(R.id.eva_answer_list_layout);
        haveFoundAnswerView = findViewById(R.id.have_found_eva_answer_layout);
        haveNotFoundAnswerView = findViewById(R.id.have_not_found_eva_answer_layout);

        evaScoreView = findViewById(R.id.eva_score_list_layout);
        evaRatioView = findViewById(R.id.eva_ratio_list_layout);
        haveFoundScoreView = findViewById(R.id.have_found_eva_score_layout);
        haveFoundRatioView = findViewById(R.id.have_found_eva_ratio_layout);
        haveNotFoundScoreView = findViewById(R.id.have_not_found_eva_score_layout);
        haveNotFoundRatioView = findViewById(R.id.have_not_found_eva_ratio_layout);




        mRecyclerView = (RecyclerView) findViewById(R.id.eva_answer_list_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mArrayList = new ArrayList<>();
        evaAnswerAdapter = new EvaAnswerAdapter(this, mArrayList);

        mArrayList.clear();
        mRecyclerView.setAdapter(evaAnswerAdapter);
        evaAnswerAdapter.notifyDataSetChanged();



        scoreRecyclerView = findViewById(R.id.eva_score_list_view);
        scoreRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        scoreDataList = new ArrayList<>();
        evaScoreAdapter = new EvaAnswerAdapter(this, scoreDataList);

        scoreDataList.clear();
        scoreRecyclerView.setAdapter(evaScoreAdapter);
        evaScoreAdapter.notifyDataSetChanged();

        ratioRecyclerView = findViewById(R.id.eva_ratio_list_view);
        ratioRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        ratioDataList = new ArrayList<>();
        evaRatioAdapter = new EvaAnswerAdapter(this, ratioDataList);

        ratioDataList.clear();
        ratioRecyclerView.setAdapter(evaRatioAdapter);
        evaRatioAdapter.notifyDataSetChanged();


        evaDetailAnswerView = findViewById(R.id.eva_detail_answer_list_layout);
        haveFoundDetailAnswerView = findViewById(R.id.have_found_eva_detail_answer_layout);
        haveNotFoundDetailAnswerView = findViewById(R.id.have_not_found_eva_detail_answer_layout);
        detailAnswerRecyclerView = (RecyclerView) findViewById(R.id.eva_detail_answer_list_view);



        detailAnswerRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        detailArrayList = new ArrayList<>();
        evaDetailAnswerAdapter = new EvaDetailAnswerAdapter(this, detailArrayList,evaInfoId,searchCowKind);
        detailAnswerRecyclerView.setAdapter(evaDetailAnswerAdapter);
        detailArrayList.clear();
        evaDetailAnswerAdapter.notifyDataSetChanged();



        // totalScoreView
        totalScoreView = findViewById(R.id.total_score_layout);
        feedWaterScoreTv = findViewById(R.id.feed_water_tv);
        stockEnvScoreTv = findViewById(R.id.stock_env_tv);
        healthStatusScoreTv = findViewById(R.id.health_status_tv);
        behaviorScoreTv = findViewById(R.id.behavior_tv);
        nutritionScoreTv = findViewById(R.id.nutrition_tv);
        drinkWaterScoreTv = findViewById(R.id.water_tv);
        restScoreTv = findViewById(R.id.rest_tv);
        heatVentilatingScoreTv = findViewById(R.id.heat_ventilating_tv);
        woundScoreTv = findViewById(R.id.wound_tv);
        diseaseScoreTv = findViewById(R.id.disease_tv);
        painScoreTv = findViewById(R.id.pain_tv);
        socialBehaviorScoreTv = findViewById(R.id.social_behavior_tv);
        humanLiveStockScoreTv = findViewById(R.id.human_live_stock_tv);
        gradeTv = findViewById(R.id.grade_tv);

        
        farmNameTv = (TextView) basicInformationView.findViewById(R.id.farm_name_tv);
        zipCodeTv = (TextView) basicInformationView.findViewById(R.id.zip_code_tv);
        addressTv = (TextView) basicInformationView.findViewById(R.id.address_tv);
        addressDetailTv = (TextView) basicInformationView.findViewById(R.id.address_detail_tv);
        repNameTv = (TextView) basicInformationView.findViewById(R.id.rep_name_tv);
        farmTypeTv = (TextView) basicInformationView.findViewById(R.id.farm_type_tv);
        totalCowTv = (TextView) basicInformationView.findViewById(R.id.total_cow_tv);
        adultCowTv = (TextView) basicInformationView.findViewById(R.id.adult_cow_tv);
        childCowTv = (TextView) basicInformationView.findViewById(R.id.child_cow_tv);
        sampleCowTv = (TextView) basicInformationView.findViewById(R.id.sample_cow_tv);
        evaNameTv = (TextView) basicInformationView.findViewById(R.id.eva_name_tv);
        evaDateTv = (TextView) basicInformationView.findViewById(R.id.eva_date_tv);
        milkCowTv = (TextView) basicInformationView.findViewById(R.id.milk_cow_tv);
        dryMilkCowTv = (TextView) basicInformationView.findViewById(R.id.dry_milk_cow_tv);
        pregnantCowTv = (TextView) basicInformationView.findViewById(R.id.pregnant_cow_tv);
        final LinearLayout beef_dialog_layout = (LinearLayout) basicInformationView.findViewById(R.id.beef_cow_dialog_layout);
        final LinearLayout milk_cow_dialog_layout = (LinearLayout) basicInformationView.findViewById(R.id.milk_cow_dialog_layout);

        if(searchCowKind.equals("beef")){
            beef_dialog_layout.setVisibility(View.VISIBLE);
            milk_cow_dialog_layout.setVisibility(View.GONE);

        } else {
            milk_cow_dialog_layout.setVisibility(View.VISIBLE);
            beef_dialog_layout.setVisibility(View.GONE);


        }
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



        GetSearchResultJson task = new GetSearchResultJson();
        task.execute("http://218.151.112.65/getAdminSearchResultJson.php",
                searchCowKind,
                evaInfoId);
    }
    private class GetSearchResultJson extends AsyncTask<String, Void, String> {

        ProgressDialog progressDialog;
        String errorString = null;

        private String mJsonString;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(DetailSearchAdminMemberActivity.this,
                    "Please Wait", null, true, true);
        }


        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            progressDialog.dismiss();

                mJsonString = result;

                getResult();
                showResult();
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


                errorString = e.toString();

                return null;
            }

        }

        private void getResult(){

            String TAG_JSON = "evaInfo";




            try{
                JSONObject jsonObject = new JSONObject(mJsonString);

                JSONArray jsonArray = jsonObject.getJSONArray(TAG_JSON);
                JSONObject item = jsonArray.getJSONObject(0);
                farmName = item.getString("farmName");
                zipCode = item.getString("zipCode");
                address = item.getString("address");
                addressDetail = item.getString("addressDetail");
                repName = item.getString("repName");
                farmType = item.getString("farmType");
                totalCowSize = item.getString("totalCowSize");
                if(searchCowKind.equals("beef")){
                    adultCowSize = item.getString("adultCowSize");
                }
                childCowSize = item.getString("childCowSize");
                sampleCowSize = item.getString("sampleCowSize");
                if(searchCowKind.equals("playGround") || searchCowKind.equals("freeStall")){
                    milkCowSize = item.getString("milkCowSize");
                    dryMilkCowSize = item.getString("dryMilkCowSize");
                    pregnantCowSize = item.getString("pregnantCowSize");
                }
                evaName = item.getString("evaluatorName");
                evaDate = item.getString("evaluatorDate");




                if(jsonObject.has("evaAnswer")){

                    haveFoundAnswerView.setVisibility(View.VISIBLE);
                    JSONArray jsonAnswerArray = jsonObject.getJSONArray("evaAnswer");
                    for(int i = 0 ; i <jsonAnswerArray.length(); i++){
                        JSONObject answerItem = jsonAnswerArray.getJSONObject(i);

                        String answer = answerItem.optString("answer","결과 없음");
                        String questionName = answerItem.getString("questionName");

                        EvaAnswerData evaAnswerData = new EvaAnswerData();

                        evaAnswerData.setAnswer(answer);
                        evaAnswerData.setQuestionName(questionName);

                        mArrayList.add(evaAnswerData);
                        evaAnswerAdapter.notifyDataSetChanged();;

                    }
                } else {
                    haveNotFoundAnswerView.setVisibility(View.VISIBLE);
                }

                if(jsonObject.has("evaDetailAnswer")){
                    haveFoundDetailAnswerView.setVisibility(View.VISIBLE);
                    JSONArray jsonAnswerArray = jsonObject.getJSONArray("evaDetailAnswer");
                    for(int i = 0 ; i <jsonAnswerArray.length(); i++){
                        JSONObject answerItem = jsonAnswerArray.getJSONObject(i);

                        String answer = answerItem.optString("answer","결과 없음");
                        String questionName = answerItem.getString("questionName");

                        EvaAnswerData evaAnswerData = new EvaAnswerData();
                        evaAnswerData.setAnswer(answer);
                        evaAnswerData.setQuestionName(questionName);

                        detailArrayList.add(evaAnswerData);
                        evaDetailAnswerAdapter.notifyDataSetChanged();;

                    }
                } else {
                    haveNotFoundDetailAnswerView.setVisibility(View.VISIBLE);
                }


                if(jsonObject.has("evaScore")){


                    haveFoundScoreView.setVisibility(View.VISIBLE);
                    JSONArray jsonAnswerArray = jsonObject.getJSONArray("evaScore");
                    for(int i = 0 ; i <jsonAnswerArray.length(); i++){
                        JSONObject answerItem = jsonAnswerArray.getJSONObject(i);

                        String answer = answerItem.optString("score","결과 없음");
                        String questionName = answerItem.getString("titleName");

                        EvaAnswerData evaScoreData = new EvaAnswerData();

                        evaScoreData.setAnswer(answer);
                        evaScoreData.setQuestionName(questionName);

                        scoreDataList.add(evaScoreData);
                        evaScoreAdapter.notifyDataSetChanged();;

                    }
                } else {
                    haveNotFoundScoreView.setVisibility(View.VISIBLE);
                }

                if(jsonObject.has("evaRatio")){
                    haveFoundRatioView.setVisibility(View.VISIBLE);

                    JSONArray jsonAnswerArray = jsonObject.getJSONArray("evaRatio");
                    for(int i = 0 ; i <jsonAnswerArray.length(); i++){
                        JSONObject answerItem = jsonAnswerArray.getJSONObject(i);

                        String answer = answerItem.optString("ratio","결과 없음");
                        String questionName = answerItem.getString("titleName");

                        EvaAnswerData evaRatioData = new EvaAnswerData();

                        evaRatioData.setAnswer(answer);
                        evaRatioData.setQuestionName(questionName);

                        ratioDataList.add(evaRatioData);
                        evaRatioAdapter.notifyDataSetChanged();

                    }
                } else {
                    haveNotFoundRatioView.setVisibility(View.VISIBLE);
                }

                if(jsonObject.has("totalScore")){
                    totalScoreView.setVisibility(View.VISIBLE);
                    JSONArray jsonAnswerArray = jsonObject.getJSONArray("totalScore");
                        JSONObject totalScoreItem = jsonAnswerArray.getJSONObject(0);

                        feedWaterScoreTv.setText(totalScoreItem.getString("feedWater"));
                        stockEnvScoreTv.setText(totalScoreItem.getString("stockEnvironment"));
                        healthStatusScoreTv.setText(totalScoreItem.getString("healthStatus"));
                        behaviorScoreTv.setText(totalScoreItem.getString("behavior"));
                        nutritionScoreTv.setText(totalScoreItem.getString("nutrition"));
                        drinkWaterScoreTv.setText(totalScoreItem.getString("drinkWater"));
                        restScoreTv.setText(totalScoreItem.getString("rest"));
                        heatVentilatingScoreTv.setText(totalScoreItem.getString("heatVentilation"));
                        woundScoreTv.setText(totalScoreItem.getString("wound"));
                        diseaseScoreTv.setText(totalScoreItem.getString("disease"));
                        painScoreTv.setText(totalScoreItem.getString("pain"));
                        socialBehaviorScoreTv.setText(totalScoreItem.getString("socialBehavior"));
                        humanLiveStockScoreTv.setText(totalScoreItem.getString("humanLiveStock"));

                        String grade  = totalScoreItem.getString("grade");
                        if(grade.equals("Excellent")) {
                            grade = "우수";
                            gradeTv.setTextColor(Color.parseColor("#0000FF"));
                        }
                        else if(grade.equals("Enhanced")) {
                            grade = "양호";
                            gradeTv.setTextColor(Color.parseColor("#32CD32"));
                        }
                        else if(grade.equals("Acceptable")) {
                            grade = "허용";
                            gradeTv.setTextColor(Color.parseColor("#D2691E"));
                        }
                        else if(grade.equals("NotClassified")) {
                            grade = "분류불가";
                            gradeTv.setTextColor(Color.parseColor("#FF0000"));
                        }
                        else grade ="결과 없음";

                        gradeTv.setText(grade);
                } else {
                    totalScoreView.setVisibility(View.GONE);
                }


            } catch (JSONException e){

            }

        }
    }
    private void showResult(){
        farmNameTv.setText(farmName);
        zipCodeTv.setText(zipCode);
        addressTv.setText(address);
        addressDetailTv.setText(addressDetail);
        repNameTv.setText(repName);
        farmTypeTv.setText(farmType);
        totalCowTv.setText(totalCowSize);
        adultCowTv.setText(adultCowSize);
        childCowTv.setText(childCowSize);
        sampleCowTv.setText(sampleCowSize);
        milkCowTv.setText(milkCowSize);
        dryMilkCowTv.setText(dryMilkCowSize);
        pregnantCowTv.setText(pregnantCowSize);
        evaNameTv.setText(evaName);
        evaDateTv.setText(evaDate);

    }


    private void drawerHandler(){
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.detail_search_drawer);
        if(!drawer.isDrawerOpen(Gravity.LEFT)){
            drawer.openDrawer(Gravity.LEFT);
        } else if(drawer.isDrawerOpen(Gravity.LEFT)){
            drawer.closeDrawer(Gravity.LEFT);
        }
    }
    private void closeDrawer(){
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.detail_search_drawer);
        drawer.closeDrawer(Gravity.LEFT);
    }
    private void changeSearchResultView(){
        basicInfoTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                basicInformationView.setVisibility(View.VISIBLE);
                evaAnswerView.setVisibility(View.GONE);
                evaDetailAnswerView.setVisibility(View.GONE);
                evaRatioView.setVisibility(View.GONE);
                evaScoreView.setVisibility(View.GONE);

                setStyleTextView(basicInfoTv);
                setNoneStyleTextView(evaAnswerTv);
                setNoneStyleTextView(evaDetailAnswerTv);
                setNoneStyleTextView(evaScoreTv);
                setNoneStyleTextView(evaRatioTv);
                detailSearchTitleTv.setText("기본 정보");
                closeDrawer();
            }
        });

        evaAnswerTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                evaAnswerView.setVisibility(View.VISIBLE);
                basicInformationView.setVisibility(View.GONE);
                evaDetailAnswerView.setVisibility(View.GONE);
                evaRatioView.setVisibility(View.GONE);
                evaScoreView.setVisibility(View.GONE);

                setStyleTextView(evaAnswerTv);
                setNoneStyleTextView(basicInfoTv);
                setNoneStyleTextView(evaDetailAnswerTv);
                setNoneStyleTextView(evaScoreTv);
                setNoneStyleTextView(evaRatioTv);

                detailSearchTitleTv.setText("평가 정보");
                closeDrawer();
            }
        });

        evaDetailAnswerTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                evaDetailAnswerView.setVisibility(View.VISIBLE);
                basicInformationView.setVisibility(View.GONE);
                evaAnswerView.setVisibility(View.GONE);
                evaRatioView.setVisibility(View.GONE);
                evaScoreView.setVisibility(View.GONE);


                setStyleTextView(evaDetailAnswerTv);
                setNoneStyleTextView(basicInfoTv);
                setNoneStyleTextView(evaAnswerTv);
                setNoneStyleTextView(evaScoreTv);
                setNoneStyleTextView(evaRatioTv);
                detailSearchTitleTv.setText("세부평가 정보");
                closeDrawer();
            }
        });
        evaScoreTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                evaScoreView.setVisibility(View.VISIBLE);
                evaAnswerView.setVisibility(View.GONE);
                basicInformationView.setVisibility(View.GONE);
                evaDetailAnswerView.setVisibility(View.GONE);
                evaRatioView.setVisibility(View.GONE);


                setStyleTextView(evaScoreTv);
                setNoneStyleTextView(basicInfoTv);
                setNoneStyleTextView(evaDetailAnswerTv);
                setNoneStyleTextView(evaAnswerTv);
                setNoneStyleTextView(evaRatioTv);
                detailSearchTitleTv.setText("점수 정보");
                closeDrawer();
            }
        });
        evaRatioTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                evaRatioView.setVisibility(View.VISIBLE);
                evaAnswerView.setVisibility(View.GONE);
                basicInformationView.setVisibility(View.GONE);
                evaDetailAnswerView.setVisibility(View.GONE);
                evaScoreView.setVisibility(View.GONE);


                setStyleTextView(evaRatioTv);
                setNoneStyleTextView(basicInfoTv);
                setNoneStyleTextView(evaDetailAnswerTv);
                setNoneStyleTextView(evaAnswerTv);
                setNoneStyleTextView(evaScoreTv);
                detailSearchTitleTv.setText("비율 정보");
                closeDrawer();
            }
        });
    }
    private void setNoneStyleTextView(TextView tv){
        tv.setBackground(null);
        tv.setTypeface(Typeface.DEFAULT);
    }
    private void setStyleTextView(TextView tv){
        tv.setBackgroundResource(R.drawable.edge_bottom);
        tv.setTypeface(Typeface.DEFAULT_BOLD);
    }

}

