package com.example.animal_project.Insert;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.animal_project.QuestionTemplateViewModel;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class InsertAvoidDistance extends AsyncTask<Object[], Void, String> {
    private String IP_ADDRESS = "218.151.112.65";
    private final Context context;

    public InsertAvoidDistance(Context context){
        this.context = context;

    }
    @Override
    protected String doInBackground(Object[]... object) {
        String postParameters;
        Object[] avoidDistances = object[0];
        String serverURL = "http://" + IP_ADDRESS + "/insertAvoidDistance.php";
        int penSize = ((QuestionTemplateViewModel.avoidDistance)avoidDistances[1]).getPenSize();
        int farmId = ((QuestionTemplateViewModel.avoidDistance)avoidDistances[1]).getFarmId();
        int farmType = ((QuestionTemplateViewModel.avoidDistance)avoidDistances[1]).getFarmType();
        String[] penLocationArr = new String[51];
        int[] cowSizeArr = new int[51];
        int[][] cowNumberArr = new int[50][50];
        int[][] avoidDistanceLevel = new int[50][50];
        for(int i = 0 ; i < penSize ; i++){
            penLocationArr[i] = ((QuestionTemplateViewModel.avoidDistance)avoidDistances[i+1]).getPenLocation();
            cowSizeArr[i]  = ((QuestionTemplateViewModel.avoidDistance)avoidDistances[i+1]).getCowSize();
            cowNumberArr[i] = ((QuestionTemplateViewModel.avoidDistance)avoidDistances[i+1]).getCowNumber();
            avoidDistanceLevel[i] = ((QuestionTemplateViewModel.avoidDistance)avoidDistances[i+1]).getAvoidDistance();
        }

        postParameters =
                "farmId=" + farmId
                +"&penSize=" + penSize
                +"&farmType=" + farmType;


        for(int i = 0 ; i < penSize; i++){
            postParameters = postParameters.concat("&penLocation" + (i+1) +"=" + penLocationArr[i]);
            postParameters = postParameters.concat("&cowSize" +(i+1) +"=" + cowSizeArr[i]);
            for(int j = 0 ; j < cowSizeArr[i] ; j++){
                postParameters = postParameters.concat("&cowNumber" + (j+1) +"=" + cowNumberArr[i][j]);
                postParameters = postParameters.concat("&avoidDistanceLevel" + (j+1) +"=" + avoidDistanceLevel[i][j]);
            }
        }



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
            Log.d("avoidDistance", "POST response code - " + responseStatusCode);

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
            Log.d("InsertAvoidDistance", "InsertData: Error ", e);
            return new String("Error: " + e.getMessage());
        }

    }

}
