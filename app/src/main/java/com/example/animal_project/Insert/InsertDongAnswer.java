package com.example.animal_project.Insert;

import android.app.ProgressDialog;
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
        Object strawQuestion = objects[4];
        Object freeStallCount =  objects[5];
        freeStallCount = (QuestionTemplateViewModel.FreeStallCountQuestion) freeStallCount;
        Object sitCollision = objects[6];
        sitCollision = (QuestionTemplateViewModel.SitCollisionQuestion) sitCollision;
        Object sitAreaOut  = objects[7];
        sitAreaOut = (QuestionTemplateViewModel.FreeStallAreaOutCollision) sitAreaOut;
        Object sitTime =  objects[8];
        sitTime =  (QuestionTemplateViewModel.SitTimeQuestion) sitTime;
        Object milkCowStruggle = objects[9];
        milkCowStruggle = (QuestionTemplateViewModel.MilkCowStruggleQuestion) milkCowStruggle;




        int farmId = ((QuestionTemplateViewModel.WaterTimeQuestion)waterTimeQuestion).getFarmId();
        int farmType = ((QuestionTemplateViewModel.WaterTimeQuestion)waterTimeQuestion).getFarmType();

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

        int strawDongSize = ((QuestionTemplateViewModel.StrawQuestion)strawQuestion).getDongSize();
        String[] strawPenLocation =  ((QuestionTemplateViewModel.StrawQuestion)strawQuestion).getPenLocation();
        int[] strawOneAnswer = ((QuestionTemplateViewModel.StrawQuestion)strawQuestion).getStrawOneArr();
        int[] strawTwoAnswer = ((QuestionTemplateViewModel.StrawQuestion)strawQuestion).getStrawTwoArr();
        int[] strawThreeAnswer = ((QuestionTemplateViewModel.StrawQuestion)strawQuestion).getStrawThreeArr();
        int[] strawScore = ((QuestionTemplateViewModel.StrawQuestion)strawQuestion).getStrawScore();
        float strawAvgScore =  ((QuestionTemplateViewModel.StrawQuestion)strawQuestion).getStrawAvgScore();

        int  freeStallDongSize = ((QuestionTemplateViewModel.FreeStallCountQuestion) freeStallCount).getDongSize();
        int[] freeStallCountCowSize = ((QuestionTemplateViewModel.FreeStallCountQuestion) freeStallCount).getCowSize();
        int[] freeStallCountSize  = ((QuestionTemplateViewModel.FreeStallCountQuestion) freeStallCount).getFreeStallCount();
        double[] freeStallCountRatio = ((QuestionTemplateViewModel.FreeStallCountQuestion) freeStallCount).getFreeStallCountRatio();
        int[] freeStallCountScore = ((QuestionTemplateViewModel.FreeStallCountQuestion) freeStallCount).getFreeStallCountScore();
        int freeStallLowestScore = ((QuestionTemplateViewModel.FreeStallCountQuestion) freeStallCount).getLowestScore();

        int sitCollisionSitCount = ((QuestionTemplateViewModel.SitCollisionQuestion)sitCollision).getSitCount();
        boolean[] sitCollisionCheck = ((QuestionTemplateViewModel.SitCollisionQuestion) sitCollision).getSitCollision();

        int sitTimeSitCount = ((QuestionTemplateViewModel.SitTimeQuestion)sitTime).getSitCount();
        int[] sitTimeCount =  ((QuestionTemplateViewModel.SitTimeQuestion)sitTime).getSitTime();

        int milkCowStruggleDongSize = ((QuestionTemplateViewModel.MilkCowStruggleQuestion) milkCowStruggle).getDongSize();
        String[] milkCowStrugglePenLocation = ((QuestionTemplateViewModel.MilkCowStruggleQuestion) milkCowStruggle).getPenLocation();
        int[] milkCowStruggleCowSize =((QuestionTemplateViewModel.MilkCowStruggleQuestion) milkCowStruggle).getCowSize();
        int[] headBangCount = ((QuestionTemplateViewModel.MilkCowStruggleQuestion) milkCowStruggle).getHeadBangCount();
        int[] headBangExceptStruggleCount = ((QuestionTemplateViewModel.MilkCowStruggleQuestion) milkCowStruggle).getHeadBangExceptStruggleCount();
        float[] headBangPerOne = ((QuestionTemplateViewModel.MilkCowStruggleQuestion) milkCowStruggle).getHeadBangPerOne();
        float[] headBangExceptStrugglePerOne = ((QuestionTemplateViewModel.MilkCowStruggleQuestion) milkCowStruggle).getHeadBangExceptStrugglePerOne();
        float[] struggleIndex = ((QuestionTemplateViewModel.MilkCowStruggleQuestion) milkCowStruggle).getStruggleIndex();
        float[] dongScores = ((QuestionTemplateViewModel.MilkCowStruggleQuestion) milkCowStruggle).getScore();







        String postParameters ="farmId=" + farmId
                +"&waterTimeDongSize=" + waterTimeDongSize
                +"&coughDongSize=" + coughDongSize
                +"&struggleDongSize=" + struggleDongSize
                +"&harmonyDongSize=" +  harmonyDongSize
                +"&strawDongSize=" + strawDongSize
                +"&freeStallCountDongSize=" + freeStallDongSize
                +"&freeStallLowestScore=" + freeStallLowestScore
                +"&farmType=" +farmType
                +"&sitCollisionSitCount=" + sitCollisionSitCount
                +"&sitTimeSitCount=" + sitTimeSitCount
                +"&milkCowStruggleDongSize=" + milkCowStruggleDongSize;

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

        for(int i = 0 ; i < strawDongSize ; i++){
            postParameters = postParameters.concat("&strawPenLocation" + (i+1) +"="+ strawPenLocation[i]);
            postParameters = postParameters.concat("&strawOneAnswer" + (i+1) +"="+ strawOneAnswer[i]);
            postParameters = postParameters.concat("&strawTwoAnswer" + (i+1) +"="+ strawTwoAnswer[i]);
            postParameters = postParameters.concat("&strawThreeAnswer" + (i+1) +"="+ strawThreeAnswer[i]);
            postParameters = postParameters.concat("&strawScore" + (i+1) +"="+ strawScore[i]);
        }
        // 착유우

        for(int i = 0 ; i < freeStallDongSize ; i++){
            postParameters = postParameters.concat("&freeStallCountCowSize" + (i+1) +"="+ freeStallCountCowSize[i]);
            postParameters = postParameters.concat("&freeStallCountSize" + (i+1) +"="+ freeStallCountSize[i]);
            postParameters = postParameters.concat("&freeStallCountRatio" + (i+1) +"="+ freeStallCountRatio[i]);
            postParameters = postParameters.concat("&freeStallCountScore" + (i+1) +"="+ freeStallCountScore[i]);

        }
        for(int i = 0 ; i < sitCollisionSitCount ; i++){
            postParameters = postParameters.concat("&sitCollisionCheck" + (i+1) +"="+ sitCollisionCheck[i]);

        }
        for(int i = 0 ; i < sitTimeSitCount ; i++){
            postParameters = postParameters.concat("&sitTimeCount" + (i+1) +"="+ sitTimeCount[i]);

        }
        for(int i = 0 ; i < milkCowStruggleDongSize ; i++){
            postParameters = postParameters.concat("&milkCowStrugglePenLocation" + (i+1) +"="+ milkCowStrugglePenLocation[i]);
            postParameters = postParameters.concat("&headBangCount" + (i+1) +"="+ headBangCount[i]);
            postParameters = postParameters.concat("&headBangExceptStruggleCount" + (i+1) +"="+ headBangExceptStruggleCount[i]);
            postParameters = postParameters.concat("&headBangPerOne" + (i+1) +"="+ headBangPerOne[i]);
            postParameters = postParameters.concat("&headBangExceptStrugglePerOne" + (i+1) +"="+ headBangExceptStrugglePerOne[i]);
            postParameters = postParameters.concat("&struggleIndex" + (i+1) +"="+ struggleIndex[i]);
            postParameters = postParameters.concat("&dongScore" + (i+1) +"="+ dongScores[i]);
            postParameters = postParameters.concat("&milkCowStruggleCowSize" + (i+1) +"="+ milkCowStruggleCowSize[i]);

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
            Log.d("InsertDongAnswer", "POST response code - " + responseStatusCode);

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
