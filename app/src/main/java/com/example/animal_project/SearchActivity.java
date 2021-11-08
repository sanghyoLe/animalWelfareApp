package com.example.animal_project;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;


import com.example.animal_project.Result.EvaInfoAdapter;
import com.example.animal_project.Result.EvaInfoData;

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


public class SearchActivity extends AppCompatActivity {
    private static String IP_ADDRESS = "218.151.112.65";
    private static String TAG = "searchPHP";



    private ArrayList<EvaInfoData> mArrayList;
    private EvaInfoAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private Button searchBtn;
    private ImageButton backBtn;
    private EditText searchEd;
    private String mJsonString;
    private String searchWord;
    private String searchCowKind;
    private String searchFilterString;
    private String searchBeforeDate;
    private String searchAfterDate;
    private Boolean isAdminMember;
    private TextView searchTitleTv;
    private TextView detailSearchTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_main);


        detailSearchTitle = findViewById(R.id.detail_search_title);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        searchWord = bundle.getString("searchWord");
        searchCowKind = bundle.getString("searchCowKind");
        searchFilterString = bundle.getString("searchFilterString");
        if(searchFilterString.equals("평가일")){
            searchBeforeDate = bundle.getString("searchBeforeDate");
            searchAfterDate = bundle.getString("searchAfterDate");
        }
        isAdminMember = bundle.getBoolean("isAdminMember");




        if(isAdminMember == true){
            detailSearchTitle.setText("상세조회");
        }

        backBtn = findViewById(R.id.back_btn);
        searchTitleTv = findViewById(R.id.search_title);
        if(searchCowKind.equals("beef")){
            searchTitleTv.setText("조회하기 - 한육우");
        } else {
            searchTitleTv.setText("조회하기 - 착유우");
        }
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                onBackPressed();
            }
        });




        mRecyclerView = (RecyclerView) findViewById(R.id.eva_info_list_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));



        mArrayList = new ArrayList<>();

        mAdapter = new EvaInfoAdapter(this, mArrayList,isAdminMember,searchCowKind);
        mRecyclerView.setAdapter(mAdapter);

        searchBtn = findViewById(R.id.search_btn);
        searchEd = findViewById(R.id.search_ed);
        mArrayList.clear();
        mAdapter.notifyDataSetChanged();


        GetData task = new GetData();
        task.execute("http://" + IP_ADDRESS + "/getSearchResultJson.php",searchWord,searchFilterString,searchCowKind,searchBeforeDate,searchAfterDate);

    }
    private class GetData extends AsyncTask<String, Void, String>{

        ProgressDialog progressDialog;
        String errorString = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(SearchActivity.this,
                    "Please Wait", null, true, true);
        }


        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            progressDialog.dismiss();

//            Log.d(TAG, "response - " + result);



                mJsonString = result;
                showResult();

        }


        @Override
        protected String doInBackground(String... params) {

            String serverURL = params[0];
            String searchWord = params[1];
            String searchFilterString = params[2];
            String searchCowKind = params[3];
            String searchBeforeDate = params[4];
            String searchAfterDate = params[5];

            String postParameters =
                    "searchWord=" + searchWord
                            +"&searchFilterString=" + searchFilterString
                            +"&searchCowKind=" + searchCowKind
                            +"&searchBeforeDate=" + searchBeforeDate
                            +"&searchAfterDate=" + searchAfterDate;


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
                Log.d(TAG, "response code - " + responseStatusCode);

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

                Log.d(TAG, "GetData : Error ", e);
                errorString = e.toString();

                return null;
            }

        }
    }
    private void showResult(){

        String TAG_JSON="evaInfo";
        String TAG_ID = "id";
        String TAG_FARM_NAME = "farmName";
        String TAG_REP_NAME ="repName";
        String TAG_FARM_TYPE ="farmType";
        String TAG_EVA_NAME ="evaluatorName";
        String TAG_EVA_DATE = "evaluatorDate";




        try {
            JSONObject jsonObject = new JSONObject(mJsonString);
            JSONArray jsonArray = jsonObject.getJSONArray(TAG_JSON);

            for(int i=0;i<jsonArray.length();i++){

                JSONObject item = jsonArray.getJSONObject(i);

                String id = item.getString(TAG_ID);
                String farmName = item.getString(TAG_FARM_NAME);
                String repName = item.getString(TAG_REP_NAME);
                String farmType = item.getString(TAG_FARM_TYPE);
                String evaName = item.getString(TAG_EVA_NAME);
                String evaDate = item.getString(TAG_EVA_DATE);


                EvaInfoData evaInfoData = new EvaInfoData();

                evaInfoData.setEvaInfoId(id);
                evaInfoData.setFarmName(farmName);
                evaInfoData.setRepName(repName);
                evaInfoData.setFarmType(farmType);
                evaInfoData.setEvaName(evaName);
                evaInfoData.setEvaDay(evaDate);
                evaInfoData.setSearchCowKind(searchCowKind);

                mArrayList.add(evaInfoData);
                mAdapter.notifyDataSetChanged();
            }



        } catch (JSONException e) {

            Log.d(TAG, "showResult : ", e);
        }

    }

}
