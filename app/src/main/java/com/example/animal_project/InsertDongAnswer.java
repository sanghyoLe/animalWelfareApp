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

public class InsertDongAnswer extends AsyncTask<Object, Void,String> {
    private final Context context;
    private String IP_ADDRESS = "218.151.112.65";
    ProgressDialog progressDialog = null;

    public InsertDongAnswer(Context context){
        this.context = context;

    }
    @Override
    protected String doInBackground(Object... objects) {

        String serverURL = "http://" + IP_ADDRESS + "/insertBeefDongAnswer.php";
        Object waterTimeQuestion = objects[0];
        Object coughQuestion = objects[1];
        Object struggleQuestion = objects[2];
        Object harmonyQuestion = objects[3];




        int farmId = ((QuestionTemplateViewModel.WaterTimeQuestion)waterTimeQuestion).getFarmId();
        String[] waterTimePenLocation = ((QuestionTemplateViewModel.WaterTimeQuestion)waterTimeQuestion).getPenLocation();
        int[] waterTimeAnswer = ((QuestionTemplateViewModel.WaterTimeQuestion)waterTimeQuestion).getDrinkTime();
        int[] waterTimeTotalCowSize = ((QuestionTemplateViewModel.WaterTimeQuestion)waterTimeQuestion).getCowSize();
        int[] waterTimeAnswerCowSize = ((QuestionTemplateViewModel.WaterTimeQuestion)waterTimeQuestion).getWaitingCowSize();
        int[] waterTimeScore = ((QuestionTemplateViewModel.WaterTimeQuestion)waterTimeQuestion).getWaterTimeScore();
        float[] waterTimeRatio = ((QuestionTemplateViewModel.WaterTimeQuestion)waterTimeQuestion).getWaitingRatio();
        int waterTimeDongSize = ((QuestionTemplateViewModel.WaterTimeQuestion)waterTimeQuestion).getDongSize();



        int coughDongSize = ((QuestionTemplateViewModel.CoughQuestion)coughQuestion).getDongSize();
        String[] coughPenLocation = ((QuestionTemplateViewModel.CoughQuestion)coughQuestion).getPenLocation();
        int[] coughAnswer = ((QuestionTemplateViewModel.CoughQuestion)coughQuestion).getCoughCount();
        int[] coughCowSize = ((QuestionTemplateViewModel.CoughQuestion)coughQuestion).getCowSize();
        float[] coughPerOne = ((QuestionTemplateViewModel.CoughQuestion)coughQuestion).getCoughPerOne();

        int struggleDongSize = ((QuestionTemplateViewModel.BehaviorQuestion)struggleQuestion).getDongSize();
        String[] strugglePenLocation = ((QuestionTemplateViewModel.BehaviorQuestion)struggleQuestion).getPenLocation();
        int[] struggleAnswer = ((QuestionTemplateViewModel.BehaviorQuestion)struggleQuestion).getBehaviorCount();
        int[] struggleCowSize = ((QuestionTemplateViewModel.BehaviorQuestion)struggleQuestion).getCowSize();
        float[] strugglePerOne = ((QuestionTemplateViewModel.BehaviorQuestion)struggleQuestion).getBehaviorPerOne();


        int harmonyDongSize = ((QuestionTemplateViewModel.BehaviorQuestion)harmonyQuestion).getDongSize();
        String[] harmonyPenLocation = ((QuestionTemplateViewModel.BehaviorQuestion)harmonyQuestion).getPenLocation();
        int[] harmonyAnswer = ((QuestionTemplateViewModel.BehaviorQuestion)harmonyQuestion).getBehaviorCount();
        int[] harmonyCowSize = ((QuestionTemplateViewModel.BehaviorQuestion)harmonyQuestion).getCowSize();
        float[] harmonyPerOne = ((QuestionTemplateViewModel.BehaviorQuestion)harmonyQuestion).getBehaviorPerOne();






        String postParameters ="farmId=" + farmId
                +"&waterTimeDongSize=" + waterTimeDongSize
                +"&coughDongSize=" + coughDongSize
                +"&struggleDongSize=" + struggleDongSize
                +"&harmonyDongSize=" +  harmonyDongSize;

        for(int i = 0 ; i < waterTimeDongSize ; i++){
            postParameters = postParameters.concat("&waterTimePenLocation_" + (i+1) +"="+ waterTimePenLocation[i]);
            postParameters = postParameters.concat("&waterTimeAnswer" + (i+1) +"="+ waterTimeAnswer[i]);
            postParameters = postParameters.concat("&waterTimeTotalCowSize" + (i+1) +"="+ waterTimeTotalCowSize[i]);
            postParameters = postParameters.concat("&waterTimeAnswerCowSize" + (i+1) +"="+ waterTimeAnswerCowSize[i]);
            postParameters = postParameters.concat("&waterTimeScore" + (i+1) +"="+ waterTimeScore[i]);
            postParameters = postParameters.concat("&waterTimeRatio" + (i+1) +"="+ waterTimeRatio[i]);
        }
        for(int i = 0 ; i < coughDongSize ; i++){
            postParameters = postParameters.concat("&coughPenLocation" + (i+1) +"="+ coughPenLocation[i]);
            postParameters = postParameters.concat("&coughAnswer" + (i+1) +"="+ coughAnswer[i]);
            postParameters = postParameters.concat("&coughCowSize" + (i+1) +"="+ coughCowSize[i]);
            postParameters = postParameters.concat("&coughPerOne" + (i+1) +"="+ coughPerOne[i]);
        }
        for(int i = 0 ; i < struggleDongSize ; i++){
            postParameters = postParameters.concat("&strugglePenLocation" + (i+1) +"="+ strugglePenLocation[i]);
            postParameters = postParameters.concat("&struggleAnswer" + (i+1) +"="+ struggleAnswer[i]);
            postParameters = postParameters.concat("&struggleCowSize" + (i+1) +"="+ struggleCowSize[i]);
            postParameters = postParameters.concat("&strugglePerOne" + (i+1) +"="+ strugglePerOne[i]);
        }
        for(int i = 0 ; i < harmonyDongSize ; i++){
            postParameters = postParameters.concat("&harmonyPenLocation" + (i+1) +"="+ harmonyPenLocation[i]);
            postParameters = postParameters.concat("&harmonyAnswer" + (i+1) +"="+ harmonyAnswer[i]);
            postParameters = postParameters.concat("&harmonyCowSize" + (i+1) +"="+ harmonyCowSize[i]);
            postParameters = postParameters.concat("&harmonyPerOne" + (i+1) +"="+ harmonyPerOne[i]);
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
