package com.example.animal_project;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

public class InsertDongAnswer extends AsyncTask<Object, Void,String> {
    private final Context context;
    private String IP_ADDRESS = "218.151.112.65";
    ProgressDialog progressDialog = null;

    public InsertDongAnswer(Context context){
        this.context = context;

    }
    @Override
    protected String doInBackground(Object... objects) {

        String serverURL = "http://" + IP_ADDRESS + "/insertBeefAnswer.php";
        Object waterTimeQuestion = objects[0];
        String[] waterTimePenLocation = ((QuestionTemplateViewModel.WaterTimeQuestion)waterTimeQuestion).getPenLocation();
        int waterTimeDongSize = ((QuestionTemplateViewModel.WaterTimeQuestion)waterTimeQuestion).getDongSize();


        String postParameters = "waterTimePenLocation_1=" + waterTimePenLocation[0];

        for(int i = 1 ; i < waterTimeDongSize ; i++){
            postParameters.concat("&waterTimePenLocation_=" + i+1 + waterTimePenLocation[i]);
        }
        Log.d("postpar",postParameters);
        try {

            URL url = new URL(serverURL);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();


            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.connect();


            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(postParameters.getBytes("UTF-8"));
            outputStream.flush();
            outputStream.close();


            int responseStatusCode = httpURLConnection.getResponseCode();
            Log.d("PHP", "POST response code - " + responseStatusCode);

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
            String line = null;

            while((line = bufferedReader.readLine()) != null){
                sb.append(line);
            }

            bufferedReader.close();

            return sb.toString();

        } catch (Exception e) {
            Log.d("PHP", "InsertData: Error ", e);
            return new String("Error: " + e.getMessage());
        }
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = ProgressDialog.show(context, "Please Wait", null, true, true);
    }
    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        progressDialog.dismiss();

        Log.d("PHP", "POST response  - " + result);


    }

}
