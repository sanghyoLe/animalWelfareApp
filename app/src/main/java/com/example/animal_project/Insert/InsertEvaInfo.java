package com.example.animal_project.Insert;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class InsertEvaInfo extends AsyncTask<String, Void, String> {
    public interface AsyncResponse {
        void processFinish(String output);
    }
    public AsyncResponse delegate = null;
    private static String TAG = "InsertUserData";
    private final Context context;
    private String farmId;
    ProgressDialog progressDialog = null;

    public InsertEvaInfo(Context context, AsyncResponse delegate){
        this.context = context;
        this.delegate = delegate;
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
        delegate.processFinish(result);



    }
    @Override
    protected String doInBackground(String... params) {
        String farmName = (String)params[1];
        String address = (String)params[2];
        String addressDetail = (String)params[3];
        String repName = (String)params[4];
        String farmType = (String)params[5];
        String totalCow = (String)params[6];
        String adultCow = (String)params[7];
        String childCow = (String)params[8];
        String sampleCow = (String)params[9];
        String evaName = (String)params[10];
        String evaYear = (String)params[11];
        String evaMonth = (String)params[12];
        String evaDay = (String)params[13];
        String zipCode = (String)params[14];
        String farmTypeNumber = (String)params[15];
        String milkCow = (String)params[16];
        String dryMilkCow = (String)params[17];
        String pregnantCow = (String)params[18];

        String serverURL = (String)params[0];
        String postParameters =
                "farmName=" + farmName +
                        "&address=" + address +
                        "&addressDetail=" + addressDetail +
                        "&repName=" + repName +
                        "&farmType=" + farmType +
                        "&totalCowSize=" + totalCow +
                        "&adultCowSize=" + adultCow +
                        "&childCowSize=" + childCow +
                        "&sampleCowSize=" + sampleCow +
                        "&evaluatorName=" + evaName +
                        "&evaluatorYear=" + evaYear +
                        "&evaluatorMonth=" + evaMonth +
                        "&evaluatorDay=" + evaDay +
                        "&zipCode=" + zipCode +
                        "&farmTypeNumber=" + farmTypeNumber +
                        "&milkCowSize=" + milkCow +
                        "&dryMilkCowSize=" + dryMilkCow +
                        "&pregnantCowSize=" + pregnantCow;


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


            return new String("Error: " + e.getMessage());
        }

    }
}