package com.example.animal_project.Insert;

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

    private static String TAG = "InsertAnswer";
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




    }
    @Override
    protected String doInBackground(String... params) {
        int index = 0;
        String serverURL = (String)params[index++];
        String farmId = (String)params[index++];
        String breedPoorNumberOfCow = (String)params[index++];
        String breedPoorScore = (String)params[index++];
        String breedPoorRatio = (String)params[index++];
        String breedWaterTankNum = (String)params[index++];
        String breedWaterTankClean = (String)params[index++];
        String breedOutwardPenLocation = (String)params[index++];
        String breedOutwardNumberOfCow = (String)params[index++];
        String breedOutwardScore  = (String)params[index++];
        String breedOutwardRatio = (String)params[index++];
        String breedShadeAnswer = (String)params[index++];
        String breedSummerVentilatingAnswer = (String)params[index++];
        String breedMistSprayAnswer = (String)params[index++];
        String breedSummerRestScore = (String)params[index++];
        String breedWindBlockAnswer = (String)params[index++];
        String breedWinterVentilatingAnswer = (String)params[index++];
        String breedWinterRestScore = (String)params[index++];
        String calfShadeAnswer = (String)params[index++];
        String calfSummerVentilatingAnswer = (String)params[index++];
        String calfMistSprayAnswer = (String)params[index++];
        String calfSummerRestScore = (String)params[index++];
        String calfStrawAnswer = (String)params[index++];
        String calfWarmAnswer = (String)params[index++];
        String calfWindBlock = (String)params[index++];
        String calfWinterRestScore = (String)params[index++];
        String breedLimpNumberOfCow = (String)params[index++];
        String breedLimpScore = (String)params[index++];
        String breedLimpRatio = (String)params[index++];
        String breedSlightHairLossNumberOfCow = (String)params[index++];
        String breedSlightHairPenLocation = (String)params[index++];
        String breedSlightHairLossRatio = (String)params[index++];
        String breedCriticalHairLossNumberOfCow = (String)params[index++];
        String breedCriticalHairLossScore = (String)params[index++];
        String breedCriticalHairLossRatio = (String)params[index++];
        String breedRunnyNosePenLocation = (String)params[index++];
        String breedRunnyNoseNumberOfCow = (String)params[index++];
        String breedRunnyNoseRatio = (String)params[index++];
        String breedOphthalmicPenLocation = (String)params[index++];
        String breedOphthalmicNumberOfCow = (String)params[index++];
        String breedOphthalmicRatio = (String)params[index++];
        String breedBreathPenLocation = (String)params[index++];
        String breedBreathNumberOfCow = (String)params[index++];
        String breedBreathRatio = (String)params[index++];
        String breedDiarrheaPenLocation = (String)params[index++];
        String breedDiarrheaNumberOfCow = (String)params[index++];
        String breedDiarrheaRatio = (String)params[index++];
        String breedRuminantPenLocation = (String)params[index++];
        String breedRuminantNumberOfCow = (String)params[index++];
        String breedRuminantRatio = (String)params[index++];
        String breedFallDeadPenLocation = (String)params[index++];
        String breedFallDeadNumberOfCow = (String)params[index++];
        String breedFallDeadRatio = (String)params[index++];
        String breedHornAnswer = (String)params[index++];
        String breedHornAnesthesiaAnswer = (String)params[index++];
        String breedHornPainkillerAnswer = (String)params[index++];
        String breedHornRemovalScore = (String)params[index++];
        String breedCastrationAnswer = (String)params[index++];
        String breedCastrationAnesthesiaAnswer = (String)params[index++];
        String breedCastrationPainkillerAnswer = (String)params[index++];
        String breedCastrationScore = (String)params[index++];
        String breedWaterTimeDongSize = (String)params[index++];
        String breedWaterTimeMaxScore = (String)params[index++];
        String coughDongSize = (String)params[index++];
        String coughPerOneAvg = (String)params[index++];
        String coughRatio = (String)params[index++];
        String struggleDongSize = (String)params[index++];
        String strugglePerOneAvg = (String)params[index++];
        String harmonyDongSize = (String)params[index++];
        String harmonyPerOneAvg = (String)params[index++];
        String avoidDistancePenSize = (String)params[index++];
        String avoidDistanceScore = (String)params[index++];
        String breedWaterScore = (String)params[index++];
        String protocolOneScore = (String)params[index++];
        String protocolTwoScore = (String)params[index++];
        String restScore = (String)params[index++];
        String TotalWarmVentilatingScore = (String)params[index++];
        String hairLossScore = (String)params[index++];
        String minPainScore = (String)params[index++];
        String BehaviorScore = (String)params[index++];
        String protocolFourScore = (String)params[index++];
        String protocolThreeScore = (String)params[index++];
        String minInjuryScore = (String)params[index++];
        String minDiseaseScore = (String)params[index++];
        String breedStrawAvgScore = (String)params[index++];
        String breedStrawDongSize = (String)params[index++];
        String breedTotalHairLossRatio = (String)params[index++];
        String farmType = (String)params[index++];

        // 착유우
        String waterTankForm = (String)params[index++];
        String sitCowCount = (String)params[index++];
        String sitAreaOutCowCount = (String)params[index++];
        String outwardBackRegNumberOfCow = (String)params[index++];
        String outwardBackNumberOfCow = (String)params[index++];
        String outwardBreastNumberOfCow = (String)params[index++];
        String criticalLimpNumberOfCow = (String)params[index++];
        String outGenitalsPenLocation = (String)params[index++];
        String outGenitalsNumberOfCow = (String)params[index++];
        String milkInCellPenLocation = (String)params[index++];
        String milkInCellNumberOfCow = (String)params[index++];
        String hardBirthYearAnswer = (String)params[index++];
        String hardBirthYearSubAnswer = (String)params[index++];
        String unAbleStandYearAnswer = (String)params[index++];
        String unAbleStandYearSubAnswer = (String)params[index++];
        String milkCowStruggleDongSize =(String)params[index++];
        String freeStallCountDongSize = (String)params[index++];
        String sitCollisionSitCount = (String)params[index++];
        String sitTimeSitCount = (String)params[index++];
        String accessTroubleCowCount = (String)params[index++];
        String exitTroubleCowCount = (String)params[index++];

        // 착유우 점수
        String freeStallCountScore = (String)params[index++];
        String sitCollisionScore = (String)params[index++];
        String areaOutCollisionScore = (String)params[index++];
        String sitTimeScore = (String)params[index++];
        String outwardBackRegScore = (String)params[index++];
        String outwardBackScore = (String)params[index++];
        String outwardBreastScore = (String)params[index++];
        String movementStabilityScore = (String)params[index++];
        String milkCowLimpScore = (String)params[index++];
        String milkCowStruggleScore = (String)params[index++];

        // 착유우 비율
        String freeStallCountRatio= (String)params[index++];
        String sitCollisionRatio= (String)params[index++];
        String areaOutSitCollisionRatio= (String)params[index++];
        String sitTimeAvgTime= (String)params[index++];
        String outwardBackRegRatio= (String)params[index++];
        String outwardBackRatio= (String)params[index++];
        String outwardBreastRatio= (String)params[index++];
        String accessTroubleRatio= (String)params[index++];
        String exitTroubleRatio= (String)params[index++];
        String totalAccessTroubleRatio = (String)params[index++];
        String milkCowLimpRatio= (String)params[index++];
        String milkCowCriticalLimpRatio= (String)params[index++];
        String milkCowTotalLimpRatio= (String)params[index++];
        String outGenitalsRatio= (String)params[index++];
        String milkInCellRatio= (String)params[index++];
        String hardBirthRatio= (String)params[index++];
        String unAbleStandRatio= (String)params[index++];
        String milkCowStruggleIndexAvg= (String)params[index++];
        String milkCowAvoidDistanceRatio= (String)params[index++];
        String totalProtocolString= (String)params[index++];


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
                        +"&breedWaterTimeDongSize=" + breedWaterTimeDongSize
                        +"&breedWaterTimeMaxScore=" + breedWaterTimeMaxScore
                        +"&coughDongSize=" + coughDongSize
                        +"&coughPerOneAvg=" + coughPerOneAvg
                        +"&coughRatio=" + coughRatio
                        +"&struggleDongSize=" + struggleDongSize
                        +"&strugglePerOneAvg=" + strugglePerOneAvg
                        +"&harmonyDongSize=" + harmonyDongSize
                        +"&harmonyPerOneAvg=" + harmonyPerOneAvg
                        +"&avoidDistancePenSize=" + avoidDistancePenSize
                        +"&avoidDistanceScore=" + avoidDistanceScore
                        +"&breedFallDeadRatio=" + breedFallDeadRatio
                        +"&breedWaterScore=" + breedWaterScore
                        +"&protocolOneScore=" + protocolOneScore
                        +"&protocolTwoScore=" + protocolTwoScore
                        +"&restScore=" + restScore
                        +"&TotalWarmVentilatingScore=" + TotalWarmVentilatingScore
                        +"&hairLossScore=" +  hairLossScore
                        +"&minPainScore=" + minPainScore
                        +"&BehaviorScore=" + BehaviorScore
                        +"&protocolFourScore=" + protocolFourScore
                        +"&protocolThreeScore=" + protocolThreeScore
                        +"&minInjuryScore=" + minInjuryScore
                        +"&minDiseaseScore=" + minDiseaseScore
                        +"&breedStrawAvgScore=" + breedStrawAvgScore
                        +"&breedStrawDongSize=" + breedStrawDongSize
                        +"&breedTotalHairLossRatio=" +breedTotalHairLossRatio
                        +"&farmType=" + farmType
                        +"&waterTankForm=" + waterTankForm
                        +"&sitCowCount=" + sitCowCount
                        +"&sitAreaOutCowCount=" + sitAreaOutCowCount
                        +"&outwardBackRegNumberOfCow=" + outwardBackRegNumberOfCow
                        +"&outwardBackNumberOfCow=" + outwardBackNumberOfCow
                        +"&outwardBreastNumberOfCow=" + outwardBreastNumberOfCow
                        +"&criticalLimpNumberOfCow=" + criticalLimpNumberOfCow
                        +"&outGenitalsPenLocation=" + outGenitalsPenLocation
                        +"&outGenitalsNumberOfCow=" + outGenitalsNumberOfCow
                        +"&milkInCellPenLocation=" + milkInCellPenLocation
                        +"&milkInCellNumberOfCow=" + milkInCellNumberOfCow
                        +"&hardBirthYearAnswer=" + hardBirthYearAnswer
                        +"&hardBirthYearSubAnswer=" + hardBirthYearSubAnswer
                        +"&unAbleStandYearAnswer=" + unAbleStandYearAnswer
                        +"&unAbleStandYearSubAnswer=" + unAbleStandYearSubAnswer
                        +"&milkCowStruggleDongSize=" + milkCowStruggleDongSize
                        +"&freeStallCountDongSize=" + freeStallCountDongSize
                        +"&sitCollisionSitCount=" + sitCollisionSitCount
                        +"&sitTimeSitCount=" + sitTimeSitCount
                        +"&accessTroubleCowCount=" + accessTroubleCowCount
                        +"&exitTroubleCowCount=" + exitTroubleCowCount
                        +"&freeStallCountScore=" + freeStallCountScore
                        +"&sitCollisionScore=" + sitCollisionScore
                        +"&areaOutCollisionScore=" + areaOutCollisionScore
                        +"&sitTimeScore=" + sitTimeScore
                        +"&outwardBackRegScore=" + outwardBackRegScore
                        +"&outwardBackScore=" + outwardBackScore
                        +"&outwardBreastScore=" + outwardBreastScore
                        +"&movementStabilityScore=" + movementStabilityScore
                        +"&milkCowLimpScore=" + milkCowLimpScore
                        +"&milkCowStruggleScore=" + milkCowStruggleScore
                        +"&freeStallCountRatio=" + freeStallCountRatio
                        +"&sitCollisionRatio=" + sitCollisionRatio
                        +"&areaOutSitCollisionRatio=" + areaOutSitCollisionRatio
                        +"&sitTimeAvgTime=" + sitTimeAvgTime
                        +"&outwardBackRegRatio=" + outwardBackRegRatio
                        +"&outwardBackRatio=" + outwardBackRatio
                        +"&outwardBreastRatio=" + outwardBreastRatio
                        +"&accessTroubleRatio=" + accessTroubleRatio
                        +"&exitTroubleRatio=" + exitTroubleRatio
                        +"&totalAccessTroubleRatio=" + totalAccessTroubleRatio
                        +"&milkCowLimpRatio=" + milkCowLimpRatio
                        +"&milkCowCriticalLimpRatio=" + milkCowCriticalLimpRatio
                        +"&milkCowTotalLimpRatio=" + milkCowTotalLimpRatio
                        +"&outGenitalsRatio=" + outGenitalsRatio
                        +"&milkInCellRatio=" + milkInCellRatio
                        +"&hardBirthRatio=" + hardBirthRatio
                        +"&unAbleStandRatio=" + unAbleStandRatio
                        +"&milkCowStruggleIndexAvg=" + milkCowStruggleIndexAvg
                        +"&milkCowAvoidDistanceRatio=" + milkCowAvoidDistanceRatio
                        +"&totalProtocolString=" + totalProtocolString
                ;




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
