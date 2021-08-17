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


public class InsertAnswer extends AsyncTask<String, Void, String> {

    public interface AsyncResponse {
        void processFinish(String output);
    }

    private static String TAG = "phpTest";
    private final Context context;

    ProgressDialog progressDialog = null;

    public InsertAnswer(Context context){
        this.context = context;

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

        Log.d(TAG, "POST response  - " + result);


    }
    @Override
    protected String doInBackground(String... params) {
        String serverURL = (String)params[0];
        String farmId = (String)params[1];
        String breedPoorNumberOfCow = (String)params[2];
        String breedPoorScore = (String)params[3];
        String breedPoorRatio = (String)params[4];
        String breedWaterTankNum = (String)params[5];
        String breedWaterTankClean = (String)params[6];
        String breedOutwardPenLocation = (String)params[7];
        String breedOutwardNumberOfCow = (String)params[8];
        String breedOutwardScore  = (String)params[9];
        String breedOutwardRatio = (String)params[10];
        String breedShadeAnswer = (String)params[11];
        String breedSummerVentilatingAnswer = (String)params[12];
        String breedMistSprayAnswer = (String)params[13];
        String breedSummerRestScore = (String)params[14];
        String breedWindBlockAnswer = (String)params[15];
        String breedWinterVentilatingAnswer = (String)params[16];
        String breedWinterRestScore = (String)params[17];
        String calfShadeAnswer = (String)params[18];
        String calfSummerVentilatingAnswer = (String)params[19];
        String calfMistSprayAnswer = (String)params[20];
        String calfSummerRestScore = (String)params[21];
        String calfStrawAnswer = (String)params[22];
        String calfWarmAnswer = (String)params[23];
        String calfWindBlock = (String)params[24];
        String calfWinterRestScore = (String)params[25];
        String breedLimpNumberOfCow = (String)params[26];
        String breedLimpScore = (String)params[27];
        String breedLimpRatio = (String)params[28];
        String breedSlightHairLossNumberOfCow = (String)params[29];
        String breedSlightHairPenLocation = (String)params[30];
        String breedSlightHairLossRatio = (String)params[31];
        String breedCriticalHairLossNumberOfCow = (String)params[32];
        String breedCriticalHairLossScore = (String)params[33];
        String breedCriticalHairLossRatio = (String)params[34];
        String breedRunnyNosePenLocation = (String)params[35];
        String breedRunnyNoseNumberOfCow = (String)params[36];
        String breedRunnyNoseRatio = (String)params[37];
        String breedOphthalmicPenLocation = (String)params[38];
        String breedOphthalmicNumberOfCow = (String)params[39];
        String breedOphthalmicRatio = (String)params[40];
        String breedBreathPenLocation = (String)params[41];
        String breedBreathNumberOfCow = (String)params[42];
        String breedBreathRatio = (String)params[43];
        String breedDiarrheaPenLocation = (String)params[44];
        String breedDiarrheaNumberOfCow = (String)params[45];
        String breedDiarrheaRatio = (String)params[46];
        String breedRuminantPenLocation = (String)params[47];
        String breedRuminantNumberOfCow = (String)params[48];
        String breedRuminantRatio = (String)params[49];
        String breedFallDeadPenLocation = (String)params[50];
        String breedFallDeadNumberOfCow = (String)params[51];
        String breedFallDeadRatio = (String)params[52];
        String breedHornAnswer = (String)params[53];
        String breedHornAnesthesiaAnswer = (String)params[54];
        String breedHornPainkillerAnswer = (String)params[55];
        String breedHornRemovalScore = (String)params[56];
        String breedCastrationAnswer = (String)params[57];
        String breedCastrationAnesthesiaAnswer = (String)params[58];
        String breedCastrationPainkillerAnswer = (String)params[59];
        String breedCastrationScore = (String)params[60];

        String postParameters =
                "farmId=" + farmId +
                "&breedPoorNumberOfCow=" + breedPoorNumberOfCow +
                "&breedPoorScore=" + breedPoorScore +
                "&breedPoorRatio=" + breedPoorRatio +
                "&breedWaterTankNum=" + breedWaterTankNum +
                "&breedWaterTankClean=" + breedWaterTankClean +
                "&breedOutwardPenLocation=" + breedOutwardPenLocation
                +"&breedOutwardNumberOfCow=" + breedOutwardNumberOfCow
                +"&breedOutwardScore=" + breedOutwardScore
                +"&breedOutwardRatio=" + breedOutwardRatio
                +"&breedShadeAnswer=" + breedShadeAnswer
                +"&breedSummerVentilatingAnswer=" + breedSummerVentilatingAnswer
                +"&breedMistSprayAnswer=" + breedMistSprayAnswer
                +"&breedSummerRestScore=" + breedSummerRestScore
                +"&breedWindBlockAnswer=" + breedWindBlockAnswer
                +"&breedWinterVentilatingAnswer=" + breedWinterVentilatingAnswer
                +"&breedWinterRestScore=" + breedWinterRestScore
                +"&calfShadeAnswer=" + calfShadeAnswer
                +"&calfSummerVentilatingAnswer=" + calfSummerVentilatingAnswer
                +"&calfMistSprayAnswer=" + calfMistSprayAnswer
                +"&calfSummerRestScore=" + calfSummerRestScore
                +"&calfStrawAnswer=" + calfStrawAnswer
                +"&calfWarmAnswer=" + calfWarmAnswer
                +"&calfWindBlock=" + calfWindBlock
                        +"&calfWinterRestScore=" + calfWinterRestScore
                +"&breedLimpNumberOfCow=" + breedLimpNumberOfCow
                        +"&breedLimpScore=" + breedLimpScore
                        +"&breedLimpRatio=" + breedLimpRatio
                        +"&breedSlightHairLossNumberOfCow=" + breedSlightHairLossNumberOfCow
                        +"&breedSlightHairPenLocation=" + breedSlightHairPenLocation
                        +"&breedSlightHairLossRatio=" + breedSlightHairLossRatio
                        +"&breedCriticalHairLossNumberOfCow=" + breedCriticalHairLossNumberOfCow
                        +"&breedCriticalHairLossScore=" + breedCriticalHairLossScore
                        +"&breedCriticalHairLossRatio=" + breedCriticalHairLossRatio
                        +"&breedRunnyNosePenLocation=" + breedRunnyNosePenLocation
                        +"&breedRunnyNoseNumberOfCow=" + breedRunnyNoseNumberOfCow
                        +"&breedRunnyNoseRatio=" + breedRunnyNoseRatio
                        +"&breedOphthalmicPenLocation=" + breedOphthalmicPenLocation
                        +"&breedOphthalmicNumberOfCow=" + breedOphthalmicNumberOfCow
                        +"&breedOphthalmicRatio=" + breedOphthalmicRatio
                        +"&breedBreathPenLocation=" + breedBreathPenLocation
                        +"&breedBreathNumberOfCow=" + breedBreathNumberOfCow
                        +"&breedBreathRatio=" + breedBreathRatio
                        +"&breedDiarrheaPenLocation=" + breedDiarrheaPenLocation
                        +"&breedDiarrheaNumberOfCow=" + breedDiarrheaNumberOfCow
                        +"&breedDiarrheaRatio=" + breedDiarrheaRatio
                        +"&breedRuminantPenLocation=" + breedRuminantPenLocation
                        +"&breedRuminantNumberOfCow=" + breedRuminantNumberOfCow
                        +"&breedRuminantRatio=" + breedRuminantRatio
                        +"&breedFallDeadPenLocation=" + breedFallDeadPenLocation
                        +"&breedFallDeadNumberOfCow=" + breedFallDeadNumberOfCow
                        +"&breedHornAnswer=" + breedHornAnswer
                        +"&breedHornAnesthesiaAnswer=" + breedHornAnesthesiaAnswer
                        +"&breedHornPainkillerAnswer=" + breedHornPainkillerAnswer
                        +"&breedHornRemovalScore=" + breedHornRemovalScore
                        +"&breedCastrationAnswer=" + breedCastrationAnswer
                        +"&breedCastrationAnesthesiaAnswer=" + breedCastrationAnesthesiaAnswer
                        +"&breedCastrationPainkillerAnswer=" + breedCastrationPainkillerAnswer
                        +"&breedCastrationScore=" + breedCastrationScore




                ;

            Log.d("farmId",String.valueOf(farmId));

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
            Log.d(TAG, "POST response code - " + responseStatusCode);

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
            Log.d(TAG, "InsertData: Error ", e);
            return new String("Error: " + e.getMessage());
        }

    }
}
