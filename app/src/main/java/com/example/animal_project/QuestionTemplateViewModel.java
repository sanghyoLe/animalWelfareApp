package com.example.animal_project;

import android.icu.text.CaseMap;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.lifecycle.ViewModel;

import java.util.HashMap;
import java.util.Map;


public class QuestionTemplateViewModel extends ViewModel {

    private int sampleCowSize = 0;
    private int totalCowSize = 0;
    private int poorScore = -1;
    private int waterTankNum = -1;
    private int waterTankClean = -1;
    private int waterDrink = -1;
    private int waterScore = -1;
    private int strawScore = -1;
    private int outwardScore = -1;
    private double restScore = -1;
    private int shadeScore = -1;
    private int summerVentilatingScore = -1;
    private int mistSprayScore =-1;
    private int summerRestScore = -1;
    private int windBlockScore =-1;
    private int winterVentilatingScore = -1;
    private int winterRestScore = -1;
    private int calfShadeScore = -1;
    private int calfSummerVentilatingScore = -1;
    private int calfMistSprayScore = -1;
    private int calfSummerRestScore =-1;
    private int calfStrawScore =-1;
    private int calfWarmScore =-1;
    private int calfWindBlockScore = -1;
    private int calfWinterRestScore =-1;
    private double totalWarmVentilatingScore = -1;
    private int limpScore = -1;
    private float slightHairLoss = -1;
    private float criticalHairLoss = -1;
    private int hairLossScore = 0;
    private long minInjuryScore = -1;
    private double cough = -1;
    private float coughRatio = -1;
    private float runnyNoseRatio = -1;
    private float ophthalmicRatio = -1;
    private float breathRatio = -1;
    private float diarrheaRatio = -1;
    private float ruminantRatio = -1;
    private float fallDeadRatio = -1;
    private double diseaseScore = -1;
    private int hornRemoval = -1;
    private int anesthesia = -1;
    private int painkiller = -1;
    private int hornRemovalScore = -1;
    private int castration = -1;
    private int castrationAnesthesia = -1;
    private int castrationPainkiller = -1;
    private int castrationScore = -1;
    private double minPainScore = -1;
    private double struggle = -1;
    private double harmony = -1;
    private int socialBehaviorScore = -1;
    private int avoidDistanceScore = -1;
    private double protocolOneScore = -1;
    private double protocolTwoScore = -1;
    private double protocolThreeScore = -1;
    private double protocolFourScore = -1;


    public void setProtocolOneScore(double protocolOneScore){
        this.protocolOneScore = protocolOneScore;
    }
    public double getProtocolOneScore(){
        return this.protocolOneScore;
    }
    public void setProtocolTwoScore(double protocolTwoScore){
        this.protocolTwoScore = protocolTwoScore;
    }

    public double getProtocolTwoScore() {
        return protocolTwoScore;
    }

    public void setProtocolThreeScore(double protocolThreeScore){
        this.protocolThreeScore = protocolThreeScore;
    }
    public double getProtocolThreeScore(){
        return protocolThreeScore;
    }
    public void setProtocolFourScore(double protocolFourScore){
        this.protocolFourScore = protocolFourScore;
    }
    public double getProtocolFourScore(){
        return protocolFourScore;
    }

    public void setTotalCowSize(int totalCowSize){
        this.totalCowSize = totalCowSize;
    }
    public int getTotalCowSize(){
        return this.totalCowSize;
    }
    public void setSampleCowSize(int sampleCowSize) {
        this.sampleCowSize = sampleCowSize;
    }
    public int getSampleCowSize() {
        return this.sampleCowSize;
    }
    public void setPoorScore(int poorScore){
        this.poorScore = poorScore;
    }
    public int getPoorScore(){
        return this.poorScore;
    }
    public void setWaterTankNum(int waterTankNum){
        this.waterTankNum = waterTankNum;
    }
    public int getWaterTankNum(){
        return this.waterTankNum;
    }
    public void setWaterTankClean(int waterTankClean){
        this.waterTankClean = waterTankClean;
    }
    public int getWaterTankClean(){
        return this.waterTankClean;
    }
    public void setWaterDrink(int waterDrink){
        this.waterDrink = waterDrink;
    }
    public int getWaterDrink(){
        return this.waterDrink;
    }
    public void setWaterScore(int waterScore){
        this.waterScore = waterScore;
    }
    public int getWaterScore(){
        return this.waterScore;
    }
    public void setStrawScore(int strawScore) {
        this.strawScore = strawScore;
    }
    public int getStrawScore() { return this.strawScore; };
    public void setOutwardScore(int outWardScore){
        this.outwardScore = outWardScore;
    }
    public int getOutWardScore(){
        return this.outwardScore;
    }
    public void setRestScore(double restScore){
        this.restScore = restScore;
    }
    public double getRestScore(){
        return this.restScore;
    }
    public void setShadeScore(int shadeScore){
        this.shadeScore = shadeScore;
    }
    public int getShadeScore(){
        return this.shadeScore;
    }
    public void setSummerVentilatingScore(int summerVentilatingScore) {
        this.summerVentilatingScore = summerVentilatingScore;
    }
    public int getSummerVentilatingScore(){
        return this.summerVentilatingScore;
    }
    public void setMistSprayScore(int mistSprayScore)
    {
        this.mistSprayScore = mistSprayScore;
    }
    public int getMistSprayScore(){
        return this.mistSprayScore;
    }
    public void setSummerRestScore(int summerRestScore){
        this.summerRestScore = summerRestScore;
    }
    public int getSummerRestScore(){
        return this.summerRestScore;
    }
    public void setWindBlockScore(int windBlockScore){
        this.windBlockScore = windBlockScore;
    }
    public int getWindBlockScore(){
        return this.windBlockScore;
    }
    public void setWinterVentilatingScore(int winterVentilatingScore){
        this.winterVentilatingScore = winterVentilatingScore;
    }
    public int getWinterVentilatingScore(){
        return this.winterVentilatingScore;
    }
    public void setWinterRestScore(int winterRestScore){
        this.winterRestScore = winterRestScore;
    }
    public int getWinterRestScore(){
        return this.winterRestScore;
    }
    public void setCalfShadeScore(int calfShadeScore){
        this.calfShadeScore = calfShadeScore;
    }
    public int getCalfShadeScore(){
        return this.calfShadeScore;
    }
    public void setCalfSummerVentilatingScore(int calfSummerVentilatingScore) {
        this.calfSummerVentilatingScore = calfSummerVentilatingScore;
    }
    public int getCalfSummerVentilatingScore(){
        return this.calfSummerVentilatingScore;
    }
    public void setCalfMistSprayScore(int calfMistSprayScore)
    {
        this.calfMistSprayScore = calfMistSprayScore;
    }
    public int getCalfMistSprayScore(){
        return this.calfMistSprayScore;
    }
    public void setCalfSummerRestScore(int calfSummerRestScore){
        this.calfSummerRestScore = calfSummerRestScore;
    }
    public int getCalfSummerRestScore(){
        return this.calfSummerRestScore;
    }
    public void setCalfStrawScore(int calfStrawScore){
        this.calfStrawScore = calfStrawScore;
    }
    public int getCalfStrawScore(){
        return this.calfStrawScore;
    }
    public void setCalfWarmScore(int calfWarmScore){
        this.calfWarmScore = calfWarmScore;
    }
    public int getCalfWarmScore(){
        return this.calfWarmScore;
    }
    public void setCalfWindBlockScore(int calfWindBlockScore){
        this.calfWindBlockScore = calfWindBlockScore;
    }
    public int getCalfWindBlockScore(){
        return this.calfWindBlockScore;
    }
    public void setCalfWinterRestScore(int calfWinterRestScore){
        this.calfWinterRestScore = calfWinterRestScore;
    }
    public int getCalfWinterRestScore(){
        return this.calfWinterRestScore;
    }
    public void setTotalWarmVentilatingScore(double totalWarmVentilatingScore){
        this.totalWarmVentilatingScore = totalWarmVentilatingScore;
    }
    public double getTotalWarmVentilatingScore()
    {
        return this.totalWarmVentilatingScore;
    }
    public void setLimpScore(int limpScore){
        this.limpScore = limpScore;
    }
    public int getLimpScore(){
        return this.limpScore;
    }
    public void setSlightHairLoss(float slightHairLoss){
        this.slightHairLoss = slightHairLoss;
    }
    public float getSlightHairLoss(){
        return this.slightHairLoss;
    }
    public void setCriticalHairLoss(float criticalHairLoss){
        this.criticalHairLoss = criticalHairLoss;
    }
    public float getCriticalHairLoss(){
        return this.criticalHairLoss;
    }
    public void setHairLossScore(int hairLossScore){
        this.hairLossScore = hairLossScore;
    }
    public int getHairLossScore(){
        return this.hairLossScore;
    }
    public void setMinInjuryScore(long minInjuryScore){
        this.minInjuryScore = minInjuryScore;
    }
    public long getMinInjuryScore(){
        return this.minInjuryScore;
    }
    public void setCough(double cough){
        this.cough = cough;
    }
    public double getCough(){
        return this.cough;
    }
    public void setCoughRatio(float coughRatio){
        this.coughRatio = coughRatio;
    }
    public float getCoughRatio(){
        return this.coughRatio;
    }
    public void setRunnyNoseRatio(float runnyNoseRatio){
        this.runnyNoseRatio = runnyNoseRatio;
    }
    public float getRunnyNoseRatio(){
        return this.runnyNoseRatio;
    }
    public void setOphthalmicRatio(float ophthalmicRatio){
        this.ophthalmicRatio = ophthalmicRatio;
    }
    public float getOphthalmicRatio(){
        return this.ophthalmicRatio;
    }
    public void setBreathRatio(float breathRatio){
        this.breathRatio = breathRatio;
    }
    public float getBreathRatio(){
        return this.breathRatio;
    }
    public void setDiarrheaRatio(float diarrheaRatio){ this.diarrheaRatio = diarrheaRatio;}
    public float getDiarrheaRatio(){return this.diarrheaRatio;}
    public void setRuminantRatio(float ruminantRatio) { this.ruminantRatio = ruminantRatio;}
    public float getRuminantRatio(){return this.ruminantRatio;}
    public void setFallDeadRatio(float fallDeadRatio){
        this.fallDeadRatio = fallDeadRatio;
    }
    public float getFallDeadRatio(){
        return this.fallDeadRatio;
    }
    public void setDiseaseScore(double diseaseScore){
        this.diseaseScore = diseaseScore;
    }
    public double getDiseaseScore(){
        return this.diseaseScore;
    }
    public void setHornRemoval(int hornRemoval){
        this.hornRemoval = hornRemoval;
    }
    public int getHornRemoval(){
        return this.hornRemoval;
    }
    public void setAnesthesia(int anesthesia){
        this.anesthesia = anesthesia;
    }
    public int getAnesthesia(){
        return this.anesthesia;
    }
    public void setPainkiller(int painkiller){
        this.painkiller = painkiller;
    }
    public int getPainkiller(){
        return  this.painkiller;
    }
    public void setHornRemovalScore(int hornRemovalScore){
        this.hornRemovalScore = hornRemovalScore;
    }
    public int getHornRemovalScore(){
        return this.hornRemovalScore;
    }
    public void setCastration(int castration){
        this.castration = castration;
    }
    public int getCastration(){
        return this.castration;
    }
    public void setCastrationAnesthesia(int castrationAnesthesia){
        this.castrationAnesthesia = castrationAnesthesia;
    }
    public int getCastrationAnesthesia(){
        return this.castrationAnesthesia;
    }
    public void setCastrationPainkiller(int castrationPainkiller){
        this.castrationPainkiller = castrationPainkiller;
    }
    public int getCastrationPainkiller(){
        return this.castrationPainkiller;
    }
    public void setCastrationScore(int castrationScore){
        this. castrationScore = castrationScore;
    }
    public int getCastrationScore(){
        return this.castrationScore;
    }
    public void setMinPainScore(double minPainScore){this.minPainScore = minPainScore;}
    public double getMinPainScore() { return this.minPainScore; }
    public void setStruggle(double struggle){
        this.struggle = struggle;
    }
    public double getStruggle(){
        return this.struggle;
    }
    public void setHarmony(double harmony){
        this.harmony = harmony;
    }
    public double getHarmony(){
        return this.harmony;
    }
    public void setSocialBehaviorScore(int socialBehaviorScore){
        this.socialBehaviorScore = socialBehaviorScore;
    }
    public int getSocialBehaviorScore(){
        return this.socialBehaviorScore;
    }
    public void setAvoidDistanceScore(int avoidDistanceScore){
        this.avoidDistanceScore = avoidDistanceScore;
    }
    public int getAvoidDistanceScore(){
        return this.avoidDistanceScore;
    }

    public void clickDongHandler(ImageButton nextBtn, ImageButton prevBtn, Button endButton, LinearLayout[] dongArr, TextView currentDongTv, int dong_size){

        final int[] currentDong = {0};
            nextBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(currentDong[-1] == 0) {
                        prevBtn.setVisibility(View.VISIBLE);
                    }
                    // 마지막 전 페이지
                    if(currentDong[0] + 2 == dong_size){
                        endButton.setVisibility(View.VISIBLE);
                        dongArr[currentDong[0]].setVisibility(View.GONE);
                        dongArr[++currentDong[0]].setVisibility(View.VISIBLE);
                        currentDongTv.setText(String.valueOf(currentDong[0] +1));
                        nextBtn.setVisibility(View.INVISIBLE);
                    }
                    else {
                        dongArr[currentDong[0]].setVisibility(View.GONE);
                        dongArr[++currentDong[0]].setVisibility(View.VISIBLE);
                        currentDongTv.setText(String.valueOf(currentDong[0] +1));
                    }

                }
            });
            prevBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 마지막 페이지에서 이전 버튼 눌렀을 때
                    if(currentDong[0] + 1 == dong_size){
                        nextBtn.setVisibility(View.VISIBLE);
                        endButton.setVisibility(View.INVISIBLE);
                    }
                    dongArr[currentDong[0]].setVisibility(View.GONE);
                    dongArr[--currentDong[0]].setVisibility(View.VISIBLE);
                    currentDongTv.setText(String.valueOf(currentDong[0] +1));

                    if(currentDong[0] == 0){
                        prevBtn.setVisibility(View.INVISIBLE);
                    }

                }


            });



    }
    public void setDongStrawScore(RadioGroup group1, RadioGroup group2, RadioGroup group3, TextView view){
        final int[] straw_feed_tank = {0};
        final int[] straw_normal = {0};
        final int[] straw_resting_place = {0};
        final int[] totalScore = {0};
        group1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override

            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View radioButton = group.findViewById(checkedId);
                int index = group.indexOfChild(radioButton);
                switch (index) {
                    case 0:
                        straw_feed_tank[0] = 1;
                        totalScore[0] = calculatorBreedStrawScore(straw_feed_tank[0],straw_normal[0],straw_resting_place[0]);
                        view.setText(String.valueOf(totalScore[0]));
                        break;
                    case 1:
                        straw_feed_tank[0] = 2;
                        totalScore[0] = calculatorBreedStrawScore(straw_feed_tank[0],straw_normal[0],straw_resting_place[0]);
                        view.setText(String.valueOf(totalScore[0]));
                        break;
                    case 2:
                        straw_feed_tank[0] = 3;
                        totalScore[0] = calculatorBreedStrawScore(straw_feed_tank[0],straw_normal[0],straw_resting_place[0]);
                        view.setText(String.valueOf(totalScore[0]));
                        break;
                    case 3:
                        straw_feed_tank[0] = 4;
                        totalScore[0] = calculatorBreedStrawScore(straw_feed_tank[0],straw_normal[0],straw_resting_place[0]);
                        view.setText(String.valueOf(totalScore[0]));
                        break;
                }
            }
        });
        group2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View radioButton = group.findViewById(checkedId);
                int index = group.indexOfChild(radioButton);
                switch (index) {
                    case 0:
                        straw_normal[0] = 1;
                        totalScore[0] = calculatorBreedStrawScore(straw_feed_tank[0],straw_normal[0],straw_resting_place[0]);
                        view.setText(String.valueOf(totalScore[0]));
                        break;
                    case 1:
                        straw_normal[0] = 2;
                        totalScore[0] = calculatorBreedStrawScore(straw_feed_tank[0],straw_normal[0],straw_resting_place[0]);
                        view.setText(String.valueOf(totalScore[0]));
                        break;
                    case 2:
                        straw_normal[0] = 3;
                        totalScore[0] = calculatorBreedStrawScore(straw_feed_tank[0],straw_normal[0],straw_resting_place[0]);
                        view.setText(String.valueOf(totalScore[0]));
                        break;
                    case 3:
                        straw_normal[0] = 4;
                        totalScore[0] = calculatorBreedStrawScore(straw_feed_tank[0],straw_normal[0],straw_resting_place[0]);
                        view.setText(String.valueOf(totalScore[0]));
                        break;
                }
            }
        });
        group3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View radioButton = group.findViewById(checkedId);
                int index = group.indexOfChild(radioButton);
                switch (index) {
                    case 0:
                        straw_resting_place[0] = 1;
                        totalScore[0] = calculatorBreedStrawScore(straw_feed_tank[0],straw_normal[0],straw_resting_place[0]);
                        view.setText(String.valueOf(totalScore[0]));
                        break;
                    case 1:
                        straw_resting_place[0] = 2;
                        totalScore[0] = calculatorBreedStrawScore(straw_feed_tank[0],straw_normal[0],straw_resting_place[0]);
                        view.setText(String.valueOf(totalScore[0]));
                        break;
                    case 2:
                        straw_resting_place[0] = 3;
                        totalScore[0] = calculatorBreedStrawScore(straw_feed_tank[0],straw_normal[0],straw_resting_place[0]);
                        view.setText(String.valueOf(totalScore[0]));
                        break;
                    case 3:
                        straw_resting_place[0] = 4;
                        totalScore[0] = calculatorBreedStrawScore(straw_feed_tank[0],straw_normal[0],straw_resting_place[0]);
                        view.setText(String.valueOf(totalScore[0]));
                        break;
                }
            }
        });

    }
    public int calculatorBreedStrawScore(int feedTank, int normal, int restingPlace){
        int StrawScore = 0;
        if(feedTank <= 2  && normal < 2 && restingPlace <  2) {
            StrawScore = 100;
        } else if(feedTank <= 2 && feedTank <= 2 && restingPlace < 2){
            StrawScore = 80;
        } else if(feedTank <= 3 && feedTank <= 3 && restingPlace <= 2){
            StrawScore = 60;
        } else if(feedTank <= 4 && feedTank <= 4 && restingPlace <= 3){
            StrawScore = 40;
        } else if(feedTank <= 4 && feedTank <= 4 && restingPlace <= 4) {
            StrawScore = 20;
        }
        return StrawScore;
    }
    public int calculatorBreedOutwardScore(float ratio)
    {
        int outwardHygieneScore = 0;
        if (ratio == 0) {
            outwardHygieneScore = 100;
        } else if (ratio <= 3) {
            outwardHygieneScore = 90;
        } else if (ratio <= 6) {
            outwardHygieneScore = 80;
        } else if (ratio <= 9) {
            outwardHygieneScore = 70;
        } else if (ratio <= 13) {
            outwardHygieneScore = 60;
        } else if (ratio <= 18) {
            outwardHygieneScore = 50;
        } else if (ratio <= 23) {
            outwardHygieneScore = 40;
        } else if (ratio <= 29) {
            outwardHygieneScore = 30;
        } else if (ratio <= 37) {
            outwardHygieneScore = 20;
        } else if (ratio <= 52) {
            outwardHygieneScore = 10;
        } else {
            outwardHygieneScore = 0;
        }
        return outwardHygieneScore;
    }
    public double calculatorProtocolOneResult(int PoorScore, int WaterScore){
        return (PoorScore * 0.7) + (WaterScore * 0.3);
    }

    public double calculatorBreedRestScore(int strawScore, int outwardScore)
    {
        return (strawScore * 0.5) + (outwardScore * 0.5);
    }
    public int calculatorBreedSummerRestScore(int shade,int summerVentilating, int mistSpary)
    {
        int summerRestScore = 0;
        // 충분한 그늘 항목 "예"인 경우
        if (shade == 1) {
            // 충분한 풍속 항목 "예"인 경우
            if (summerVentilating  == 1) {
                //안개분무 풍속 "예"인 경우
                if (mistSpary == 1) {
                    summerRestScore = 100;
                } else {
                    summerRestScore = 80;
                }
            } else {
                if (mistSpary == 1) {
                    summerRestScore = 60;
                } else {
                    summerRestScore = 45;
                }
            }
        } else {
            if (summerVentilating == 1) {
                if (mistSpary == 1) {
                    summerRestScore = 55;
                } else {
                    summerRestScore = 40;
                }
            } else {
                if (mistSpary == 1) {
                    summerRestScore = 20;
                } else {
                    summerRestScore = 0;
                }
            }
        }
        return summerRestScore;
    }
    public int calculatorBreedWinterRestScore(int windBlock, int winterVentilating)
    {
        int windRestScore = 0;
        // 바람차단시설 항목 "예"인 경우
        if (windBlock == 1) {
            // 최소 풍속시설 항목 "예"인 경우
            if (winterVentilating == 1) {
                windRestScore = 100;
            } else {
                windRestScore = 70;
            }
            // 바람차단시설 항목 "아니오 "인 경우
        } else {
            if (winterVentilating == 1) {
                windRestScore = 40;
            } else {
                windRestScore = 20;
            }
        }
        return windRestScore;
    }
    public int calculatorCalfWinterRestScore(int straw, int warm, int windBlock)
    {
        int winterCalfRestScore = 0;
        // 충분한 깔짚 항목 "예"
        if (straw == 1) {
            // 충분한 보온 항목 "예"
            if (warm == 1) {
                // 바람 차단 시설 "예"
                if (windBlock == 1) {
                    winterCalfRestScore = 100;
                } else {
                    winterCalfRestScore = 80;
                }
            }
            // 충분한 보온 항목 "아니오"
            else {
                if (windBlock == 1) {
                    winterCalfRestScore = 60;
                } else {
                    winterCalfRestScore = 45;
                }
            }
        }
        // 충분한 깔짚 항목 "아니오"
        else {
            if (warm == 1) {
                if (windBlock == 1) {
                    winterCalfRestScore = 55;
                } else {
                    winterCalfRestScore = 40;
                }
            } else {
                if (windBlock == 1) {
                    winterCalfRestScore = 20;
                } else {
                    winterCalfRestScore = 0;
                }
            }
        }
        return winterCalfRestScore;
    }

    public double calculatorTotalWarmVentilationScore(int breedSummerScore, int breedWinterScore, int calfSummerScore, int calfWinterScore) {

        double warmVenScore = (breedSummerScore * 0.35) + (breedWinterScore * 0.15) + (calfSummerScore * 0.25) + (calfWinterScore * 0.25);

        return warmVenScore;
    }
    public int calculatorLimpScore(float limp)
    {
        int limpScore = 0;
        if (limp == 0) {
            limpScore = 100;
        } else if (limp <= 1.5) {
            limpScore = 90;
        } else if (limp <= 3) {
            limpScore = 80;
        } else if (limp <= 5) {
            limpScore = 70;
        } else if (limp <= 7) {
            limpScore = 60;
        } else if (limp <= 10) {
            limpScore = 50;
        } else if (limp <= 13) {
            limpScore = 40;
        } else if (limp <= 20) {
            limpScore = 30;
        } else if (limp <= 31) {
            limpScore = 20;
        } else if (limp <= 49) {
            limpScore = 10;
        } else {
            limpScore = 0;
        }
        return limpScore;
    }
    public int calculatorHairLossScore(float hairLoss)
    {
        int hairLossScore = 0;
        if (hairLoss == 0) {
            hairLossScore = 100;
        } else if (hairLoss <= 4) {
            hairLossScore = 90;
        } else if (hairLoss <= 8) {
            hairLossScore = 80;
        } else if (hairLoss <= 13) {
            hairLossScore = 70;
        } else if (hairLoss <= 18) {
            hairLossScore = 60;
        } else if (hairLoss <= 24) {
            hairLossScore = 50;
        } else if (hairLoss <= 31) {
            hairLossScore = 40;
        } else if (hairLoss <= 40) {
            hairLossScore = 30;
        } else if (hairLoss <= 52) {
            hairLossScore = 20;
        } else if (hairLoss <= 72) {
            hairLossScore = 10;
        } else {
            hairLossScore = 0;
        }
        return hairLossScore;
    }
    public long calculatorMinInjuryScore(int limpScore, int hairLossScore){
        long minInjuryScore = 0;
        minInjuryScore = Math.round((limpScore * 0.6) + (hairLossScore *0.4));
        minInjuryScore = Math.round(minInjuryScore);

        return minInjuryScore;
    }
    public float getRatio(EditText editText){
        float ratio = (Float.parseFloat(editText.getText().toString()) / getSampleCowSize()) * 100;
        ratio = Math.round(ratio);
        return ratio;
    }
    public Map calculatorDiseaseSectionOne(float runnyNose,float ophthalmic)
    {
        Map <String, Integer> sectionScores = new HashMap<String, Integer>();
        sectionScores.put("care",0);
        sectionScores.put("warning",0);
        // 비강분비물 상태 좋음, 안구분비물 상태 좋음 => "0"
        if (runnyNose < 5 && ophthalmic < 3) {
            return sectionScores;
        }
        // 비강분비물 상태 좋음, 안구분비물(주의) => "주의"
        else if (runnyNose < 5 && 3 <= ophthalmic && ophthalmic < 6) {
            sectionScores.put("care",1);
        }
        // 비강분비물(주의), 안구분비물 상태 좋음 => "주의"
        else if (5 <= runnyNose && runnyNose < 10 && ophthalmic < 3) {
            sectionScores.put("care",1);
        }
        // 비강분비물(주의), 안구분비물(주의) => "주의"
        else if (5 <= runnyNose && runnyNose < 10 && 3 <= ophthalmic && ophthalmic < 6) {
            sectionScores.put("care",1);
        }
        // 비강, 안구분비물 중 1개라도 "경보" => "경보"
        else if (10 <= runnyNose || 6 <= ophthalmic) {
            sectionScores.put("warning",1);
        }
        return sectionScores;
    }
    public Map calculatorDiseaseSectionTwo(double cough,float breath)
    {
        Map <String, Integer> sectionScores = new HashMap<String, Integer>();
        sectionScores.put("care",0);
        sectionScores.put("warning",0);

        // 비강분비물 상태 좋음, 안구분비물 상태 좋음 => "0"
        if (cough < 4 && breath < 5) {
            return sectionScores;
        }
        // 기침 상태 좋음, 호흡장애(주의) => "주의"
        else if (cough < 4 && 5 <= breath && breath < 10) {
            sectionScores.put("care",1);
        }
        // 기침(주의), 호흡장애 상태 좋음 => "주의"
        else if (4 <= cough && cough < 8 && breath < 4) {
            sectionScores.put("care",1);
        }
        // 기침(주의), 호흡장애(주의) => "주의"
        else if (4 <= cough && cough < 8 && 5 <= breath && breath < 10) {
            sectionScores.put("care",1);
        }
        // 기침, 호흡장애 중 1개라도 "경보" => "경보"
        else if (8 <= cough || 10 <= breath) {
            sectionScores.put("warning",1);
        }
        return sectionScores;
    }
    public Map calculatorDiseaseSectionThree(float ruminant,float diarrhea)
    {
        Map <String, Integer> sectionScores = new HashMap<String, Integer>();
        sectionScores.put("care",0);
        sectionScores.put("warning",0);
        // 비강분비물 상태 좋음, 안구분비물 상태 좋음 => "0"
        if (ruminant < 5 && diarrhea < 3) {
            return sectionScores;
        }
        // 반추위 팽창 상태 좋음, 설사(주의) => "주의"
        else if (ruminant < 5 && 3 <= diarrhea && diarrhea < 6) {
            sectionScores.put("care",1);
        }
        // 반추위 팽창(주의), 설사 좋음 => "주의"
        else if (5 <= ruminant && ruminant < 10 && diarrhea < 3) {
            sectionScores.put("care",1);
        }
        // 반추위 팽창(주의), 설사(주의) => "주의"
        else if (5 <= ruminant && ruminant < 10 && 3 <= diarrhea && diarrhea < 6) {
            sectionScores.put("care",1);
        }
        // 반추위 팽창 ,설사 중 1개라도 "경보" => "경보"
        else if (10 <= ruminant || 6 <= diarrhea) {
            sectionScores.put("warning",1);
        }
        return sectionScores;
    }

    public Map calculatorDiseaseSectionFour(float fallDead)
    {
        Map <String, Integer> sectionScores = new HashMap<String, Integer>();
        sectionScores.put("care",0);
        sectionScores.put("warning",0);

        if (fallDead < 2)
            return sectionScores;
        // 폐사율 상태 주의
        if (2 <= fallDead && fallDead < 4) {
            sectionScores.put("care",1);
            // 폐사율 상태 경보
        } else if (4 <= fallDead) {
            sectionScores.put("warning",1);
        }
        return sectionScores;
    }

    public Map calculatorCareWarningScore(Map sectionOneScore, Map sectionTwoScore, Map sectionThreeScore, Map sectionFourScore)
    {
        Map <String, Integer> careWarningScore = new HashMap<String, Integer>();
        int totalCareScore = (int) sectionOneScore.get("care")
                + (int) sectionTwoScore.get("care")
                + (int) sectionThreeScore.get("care")
                + (int) sectionFourScore.get("care");
        careWarningScore.put("care",totalCareScore);
        int totalWarningScore = (int) sectionOneScore.get("warning")
                + (int) sectionTwoScore.get("warning")
                + (int) sectionThreeScore.get("warning")
                + (int) sectionFourScore.get("warning");
        careWarningScore.put("warning",totalWarningScore);

        return careWarningScore;
    }
    public double calculatorDiseaseScore(Map careWarningScore)
    {
        float diseaseScore = 0;
        int careScore = (int)careWarningScore.get("care");
        int warningScore = (int)careWarningScore.get("warning");
        diseaseScore = (100 / 4) * (4 - ((careScore) + 3 * (warningScore)) / 3);

        return Math.round(diseaseScore);
    }

    public int calculatorHornRemovalScore(int horn, int hornAnesthesia, int hornPainkiller)
    {
        int hornRemovalScore = 0;
        // 제각안함
        if (horn == 1) {
            hornRemovalScore = 100;
        } // 송아지 제각 가열 방식
        else if (horn == 2) {
            // 마취제 사용
            if (hornAnesthesia == 1) {
                // 사후진통제 사용
                if (hornPainkiller == 1) {
                    hornRemovalScore = 75;
                } else {
                    hornRemovalScore = 52;
                }
            }
            // 마취제 미사용
            else {
                if (hornPainkiller == 1) {
                    // 사후 진통제만 사용했을 경우 (누락 부분)
                    hornRemovalScore = 49;
                }
                // 처치 없음
                else {
                    hornRemovalScore = 28;
                }
            }
        }
        // 송아지 제각 화학적 방식
        else if (horn == 3) {
            // 마취제 사용
            if (hornAnesthesia == 1) {
                // 사후진통제 사용
                if (hornPainkiller == 1) {
                    hornRemovalScore = 58;
                } else {
                    hornRemovalScore = 39;
                }
            }
            // 마취제 미사용
            else {
                // 사후 진통제만 사용했을 경우 (누락 부분)
                if (hornPainkiller == 1) {
                    hornRemovalScore = 41;
                } else {
                    hornRemovalScore = 20;
                }
            }
        }
        // 성우 제각
        // 송아지는 사후진통제만 했을 때 점수가 마취제 점수보다 높은데 왜 성우는 더 높지 마취제가
        else {
            if (hornAnesthesia == 1) {
                if (hornPainkiller == 1) {
                    hornRemovalScore = 27;
                } else {
                    hornRemovalScore = 17;
                }
            } else {
                if (hornPainkiller == 1) {
                    hornRemovalScore = 16;
                } else {
                    hornRemovalScore = 2;
                }
            }
        }
        return hornRemovalScore;
    }
    public int calculatorCastrationScore(int castration, int castrationAnesthesia, int castrationPainkiller)
    {
        int castrationScore = 0;
        // 거세 안함
        if (castration == 1) {
            castrationScore  = 100;
        }
        // 외과적 수술
        else if (castration == 2) {
            if (castrationAnesthesia == 1) {
                if (castrationPainkiller == 1) {
                    castrationScore = 34;
                } else {
                    castrationScore = 21;
                }
            } else {
                //"사후진통제"만 사용했을 경우 (누락 부분)
                if (castrationPainkiller == 1) {
                    castrationScore = 20;
                } else {
                    castrationScore = 0;
                }
            }
        }
        // 고무링
        else if (castration == 3) {
            if (castrationAnesthesia == 1) {
                if (castrationPainkiller == 1) {
                    castrationScore = 21;
                } else {
                    castrationScore = 17;
                }
            } else {
                //"사후진통제"만 사용했을 경우 (누락 부분)
                if (castrationPainkiller == 1) {
                    castrationScore = 17;
                } else {
                    castrationScore = 2;
                }
            }
        }
        // Burdizzo
        else if (castration == 4) {
            if (castrationAnesthesia == 1) {
                if (castrationPainkiller == 1) {
                    castrationScore = 35;
                } else {
                    castrationScore = 21;
                }
            } else {
                //"사후진통제"만 사용했을 경우 (누락 부분)
                if (castrationPainkiller == 1) {
                    castrationScore = 19;
                } else {
                    castrationScore = 0;
                }
            }
        }
        return castrationScore;
    }
    public double calculatorMinPainScore(int hornRemovalScore, int castrationScore){
        return (hornRemovalScore  * 0.7) + (castrationScore * 0.3);
    }
    public double calculatorProtocolThreeResult(double minInjuryScore, double minPainScore, double diseaseScore){
        return Math.round((minInjuryScore * 0.35) + (diseaseScore * 0.4) + (minPainScore * 0.25));
    }
    // 사회적 행동의 표현(투쟁행동, 화합행동)" 종합 기준점수
    public int calculatorSocialBehaviorScore(double struggle, double harmony)
    {
        // 투쟁행동 비율 계산
        double struggleRatio = struggle / (struggle + harmony) * 100;

        int socialBehaviorScore = 0;
        // 투쟁행동빈도 0.5 이하일때
        if (struggle <= 0.5) {
            if (struggleRatio > 100) {
                return socialBehaviorScore = -1;
            }
            if (struggleRatio == 100) {
                socialBehaviorScore = 58;
            } else if (struggleRatio >= 90) {
                socialBehaviorScore = 62;
            } else if (struggleRatio >= 80) {
                socialBehaviorScore = 67;
            } else if (struggleRatio >= 70) {
                socialBehaviorScore = 73;
            } else if (struggleRatio >= 60) {
                socialBehaviorScore = 78;
            } else if (struggleRatio >= 50) {
                socialBehaviorScore = 83;
            } else if (struggleRatio >= 40) {
                socialBehaviorScore = 87;
            } else if (struggleRatio >= 30) {
                socialBehaviorScore = 91;
            } else if (struggleRatio >= 20) {
                socialBehaviorScore = 93;
            } else if (struggleRatio >= 10) {
                socialBehaviorScore = 95;
            } else {
                socialBehaviorScore = 100;
            }
            return socialBehaviorScore;
        } // 투쟁행동빈도 0.5 초과, 1.5 이하일때
        else if (0.5 < struggle && struggle <= 1.5) {
            if (struggleRatio > 100) {
                return socialBehaviorScore = -1;
            }
            if (struggleRatio == 100) {
                socialBehaviorScore = 34;
            } else if (struggleRatio >= 90) {
                socialBehaviorScore = 41;
            } else if (struggleRatio >= 80) {
                socialBehaviorScore = 47;
            } else if (struggleRatio >= 70) {
                socialBehaviorScore = 52;
            } else if (struggleRatio >= 60) {
                socialBehaviorScore = 57;
            } else if (struggleRatio >= 50) {
                socialBehaviorScore = 61;
            } else if (struggleRatio >= 40) {
                socialBehaviorScore = 65;
            } else if (struggleRatio >= 30) {
                socialBehaviorScore = 67;
            } else if (struggleRatio >= 20) {
                socialBehaviorScore = 69;
            } else if (struggleRatio >= 10) {
                socialBehaviorScore = 72;
            } else {
                socialBehaviorScore = 100;
            }
        } // 투쟁행동빈도 1.5 초과, 3 이하일때
        else if (1.5 < struggle && struggle <= 3) {
            if (struggleRatio > 100) {
                return socialBehaviorScore = -1;
            }
            if (struggleRatio == 100) {
                socialBehaviorScore = 25;
            } else if (struggleRatio >= 90) {
                socialBehaviorScore = 30;
            } else if (struggleRatio >= 80) {
                socialBehaviorScore = 35;
            } else if (struggleRatio >= 70) {
                socialBehaviorScore = 39;
            } else if (struggleRatio >= 60) {
                socialBehaviorScore = 42;
            } else if (struggleRatio >= 50) {
                socialBehaviorScore = 45;
            } else if (struggleRatio >= 40) {
                socialBehaviorScore = 47;
            } else if (struggleRatio >= 30) {
                socialBehaviorScore = 48;
            } else if (struggleRatio >= 20) {
                socialBehaviorScore = 49;
            } else if (struggleRatio >= 10) {
                socialBehaviorScore = 52;
            } else {
                socialBehaviorScore = 100;
            }
            // 40 % 점수에서 왜 내려가는 지?
        } // 투쟁행동빈도 3 초과, 8 이하일때
        else if (3 < struggle && struggle <= 8) {
            if (struggleRatio > 100) {
                return socialBehaviorScore = -1;
            }
            if (struggleRatio == 100) {
                socialBehaviorScore = 8;
            } else if (struggleRatio >= 90) {
                socialBehaviorScore = 13;
            } else if (struggleRatio >= 80) {
                socialBehaviorScore = 16;
            } else if (struggleRatio >= 70) {
                socialBehaviorScore = 19;
            } else if (struggleRatio >= 60) {
                socialBehaviorScore = 22;
            } else if (struggleRatio >= 50) {
                socialBehaviorScore = 24;
            } else if (struggleRatio >= 40) {
                // 왜 여기서 점수가 내려가는지?
                socialBehaviorScore = 20;
            } else if (struggleRatio >= 30) {
                socialBehaviorScore = 27;
            } else if (struggleRatio >= 20) {
                socialBehaviorScore = 28;
            } else if (struggleRatio >= 10) {
                socialBehaviorScore = 30;
            } else {
                socialBehaviorScore = 100;
            }
        } // 투쟁행동빈도 8 초과일때
        else if (8 < struggle) {
            if (struggleRatio > 100) {
                return socialBehaviorScore = -1;
            }
            if (struggleRatio == 100) {
                socialBehaviorScore = 0;
            } else if (struggleRatio >= 90) {
                socialBehaviorScore = 3;
            } else if (struggleRatio >= 80) {
                socialBehaviorScore = 3;
            } else if (struggleRatio >= 70) {
                socialBehaviorScore = 4;
            } else if (struggleRatio >= 60) {
                socialBehaviorScore = 5;
            } else if (struggleRatio >= 50) {
                socialBehaviorScore = 6;
            } else if (struggleRatio >= 40) {
                socialBehaviorScore = 6;
            } else if (struggleRatio >= 30) {
                socialBehaviorScore = 6;
            } else if (struggleRatio >= 20) {
                socialBehaviorScore = 7;
            } else if (struggleRatio >= 10) {
                socialBehaviorScore = 8;
            } else {
                socialBehaviorScore = 100;
            }
        }

        return socialBehaviorScore;
    }
    public double calculatorProtocolFourScore(double socialBehaviorScore, double avoidDistanceScore){
        return (socialBehaviorScore * 0.65) + (avoidDistanceScore * 0.35);
    }


    // Progressbar 점수 설정
    public void setProgressBar(double protocolScore, ProgressBar progressBar, TextView progressBarTv){
        progressBar.setProgress(Math.round((float)protocolScore));
        progressBarTv.setText(String.valueOf(protocolScore));
    }


}


