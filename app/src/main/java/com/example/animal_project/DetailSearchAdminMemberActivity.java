package com.example.animal_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
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
import java.util.ArrayList;

public class DetailSearchAdminMemberActivity extends AppCompatActivity {


    private ArrayList<EvaAnswerData> mArrayList;
    private EvaAnswerAdapter evaAnswerAdapter;
    private RecyclerView mRecyclerView;


    private ArrayList<EvaPenLocationData> penLocationArrayList;
    private EvaPenLocationAdapter evaPenLocationAdapter;
    private RecyclerView penLocationRecyclerView;


    private String evaInfoId;
    private String searchCowKind;
    private View basicInformationView;
    private ImageButton basicInformationBtn;
    private View evaAnswerView;
    private View haveFoundAnswerView;
    private View haveNotFoundAnswerView;
    private ImageButton evaAnswerBtn;
    private View penLocationView;
    private View haveFoundPenLocationView;
    private View haveNotFoundPenLocationView;
    private ImageButton penLocationBtn;
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




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_search_admin_member);
        basicInformationView = findViewById(R.id.basic_information_table);
        basicInformationBtn = findViewById(R.id.basic_information_btn);
        evaAnswerBtn = findViewById(R.id.eva_answer_btn);
        evaAnswerView = findViewById(R.id.eva_answer_list_layout);
        haveFoundAnswerView = findViewById(R.id.have_found_eva_answer_layout);
        haveNotFoundAnswerView = findViewById(R.id.have_not_found_eva_answer_layout);
        penLocationView = findViewById(R.id.pen_location_layout);
        penLocationBtn = findViewById(R.id.pen_location_btn);
        haveFoundPenLocationView = findViewById(R.id.have_found_pen_location_layout);
        haveNotFoundPenLocationView = findViewById(R.id.have_not_found_pen_location_layout);
        backBtn = findViewById(R.id.back_btn);

        // 평가 정보 RecyclerView
        mRecyclerView = (RecyclerView) findViewById(R.id.eva_answer_list_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mArrayList = new ArrayList<>();
        evaAnswerAdapter = new EvaAnswerAdapter(this, mArrayList);
        mRecyclerView.setAdapter(evaAnswerAdapter);
        mArrayList.clear();
        evaAnswerAdapter.notifyDataSetChanged();

        // 표본펜 위치 RecyclerView
        penLocationRecyclerView = (RecyclerView) findViewById(R.id.pen_location_list_view);
        penLocationRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        penLocationArrayList = new ArrayList<>();
        evaPenLocationAdapter = new EvaPenLocationAdapter(this, penLocationArrayList);
        penLocationRecyclerView.setAdapter(evaPenLocationAdapter);
        penLocationArrayList.clear();
        evaPenLocationAdapter.notifyDataSetChanged();

        Intent beforeIntent = getIntent();
        evaInfoId = beforeIntent.getStringExtra("evaInfoId");
        searchCowKind = beforeIntent.getStringExtra("searchCowKind");
        
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
//            adult_cow_tv.setText(inputMessage.get(inputMessageIndex));

        } else if(searchCowKind.equals("milkCow")) {
            milk_cow_dialog_layout.setVisibility(View.VISIBLE);
            beef_dialog_layout.setVisibility(View.GONE);
//            milk_cow_tv.setText(inputMessage.get(inputMessageIndex++));
//            dry_milk_cow_tv.setText(inputMessage.get(inputMessageIndex++));
//            pregnant_cow_tv.setText(inputMessage.get(inputMessageIndex));
        }
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        setListBtnOnClick(basicInformationView,basicInformationBtn);
        setListBtnOnClick(evaAnswerView,evaAnswerBtn);
        setListBtnOnClick(penLocationView,penLocationBtn);

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
                Log.d("adminMemberSearchResult", "response code - " + responseStatusCode);


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

                Log.d("adminMemberSearchResult", "adminMemberSearchResult : Error ", e);
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
                if(searchCowKind.equals("milkCow")){
                    milkCowSize = item.getString("milkCowSize");
                    dryMilkCowSize = item.getString("dryMilkCowSize");
                    pregnantCowSize = item.getString("pregnantCowSize");
                }
                evaName = item.getString("evaluatorName");
                evaDate = item.getString("evaluatorYear") + "-"
                        + item.getString("evaluatorMonth") + "-"
                        + item.getString("evaluatorDay");




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

                if(jsonObject.has("penLocation")){
                    haveFoundPenLocationView.setVisibility(View.VISIBLE);
                    JSONArray penLocationArray = jsonObject.getJSONArray("penLocation");
                    for(int i = 0 ; i <penLocationArray.length(); i++){
                        JSONObject penLocationItem = penLocationArray.getJSONObject(i);

                        String penLocation = penLocationItem.optString("penlocation","결과 없음");
                        String questionName = penLocationItem.getString("questionTitle");
                        String questionNumber = penLocationItem.optString("questionNumber");

                        EvaPenLocationData penLocationData = new EvaPenLocationData();

                        penLocationData.setPenLocation(penLocation);
                        penLocationData.setQuestionName(questionName);
                        penLocationData.setQuestionNumber(questionNumber);

                        penLocationArrayList.add(penLocationData);
                        evaPenLocationAdapter.notifyDataSetChanged();;

                    }
                } else {
                    haveNotFoundPenLocationView.setVisibility(View.VISIBLE);
                }


            } catch (JSONException e){
                Log.d("evaInfoData","showResult : ", e);
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
    private void setListBtnOnClick(View view, ImageButton btn){
        Animation slide_down = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_down);

        Animation slide_up = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_up);

        slide_down.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                view.setVisibility(View.VISIBLE);
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                btn.setImageResource(R.drawable.outline_arrow_drop_up_24);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        slide_up.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(View.GONE);
                btn.setImageResource(R.drawable.outline_arrow_drop_down_24);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(view.getVisibility() == View.GONE){
                    btn.startAnimation(slide_down);
                }else {
                    btn.startAnimation(slide_up);
                }



            }
        });
    }
}
