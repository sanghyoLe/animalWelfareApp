package com.example.animal_project;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


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
    private ImageButton searchBtn;
    private EditText searchEd;
    private String mJsonString;
    private String searchFilterString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_main);

        Intent intent = getIntent();
        String searchCowKind = intent.getStringExtra("searchCowKind");

        Spinner searchFilterSpinner = findViewById(R.id.search_filter_spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.search_filter_string_array,android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        searchFilterSpinner.setAdapter(adapter);

        String searchFilter = "";
        searchFilterSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getSelectedItem().toString();
                searchFilterString = selectedItem;

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        mRecyclerView = (RecyclerView) findViewById(R.id.eva_info_list_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));



        mArrayList = new ArrayList<>();

        mAdapter = new EvaInfoAdapter(this, mArrayList);
        mRecyclerView.setAdapter(mAdapter);

        searchBtn = findViewById(R.id.search_btn);
        searchEd = findViewById(R.id.search_ed);

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(searchEd.getText().toString())){
                    Toast.makeText(SearchActivity.this, "검색어를 입력하세요", Toast.LENGTH_SHORT).show();
                }else {
                    String searchWord = searchEd.getText().toString();

                    mArrayList.clear();
                    mAdapter.notifyDataSetChanged();

                    GetData task = new GetData();
                    task.execute("http://" + IP_ADDRESS + "/getjson.php",searchWord,searchFilterString,searchCowKind);

                }
            }
        });
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

            if (result.equals("searchNothing")){
                Toast.makeText(SearchActivity.this, "검색결과가 없습니다", Toast.LENGTH_SHORT).show();
            }
            else {

                mJsonString = result;
                showResult();
            }
        }


        @Override
        protected String doInBackground(String... params) {

            String serverURL = params[0];
            String searchWord = params[1];
            String searchFilterString = params[2];
            String searchCowKind = params[3];
            String postParameters =
                    "searchWord=" + searchWord
                    +"&searchFilterString=" + searchFilterString
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


                EvaInfoData evaInfoData = new EvaInfoData();

                evaInfoData.setEvaInfoId(id);
                evaInfoData.setFarmName(farmName);
                evaInfoData.setRepName(repName);
                evaInfoData.setFarmType(farmType);
                evaInfoData.setEvaName(evaName);

                mArrayList.add(evaInfoData);
                mAdapter.notifyDataSetChanged();
            }



        } catch (JSONException e) {

            Log.d(TAG, "showResult : ", e);
        }

    }

}
