package com.example.animal_project;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


public class QuestionTemplateViewModel extends ViewModel {

    private int sampleCowSize = 0;
    private int totalCowSize = 0;
    private int poorScore = 0;
    private int waterTankNum = 0;
    private int waterTankClean = 0;
    private int waterDrink = 0;
    private int waterScore = 0;
    private int strawScore = 0;
    private int outwardScore = 0;
    private double restScore = 0;
    private int shadeScore = 0;
    private int summerVentilatingScore = 0;
    private int mistSprayScore =0;
    private int summerRestScore = 0;
    private int windBlockScore =0;
    private int winterVentilatingScore = 0;
    private int winterRestScore = 0;
    private int calfShadeScore = 0;
    private int calfSummerVentilatingScore = 0;
    private int calfMistSprayScore = 0;
    private int calfSummerRestScore =0;
    private int calfStrawScore =0;
    private int calfWarmScore =0;
    private int calfWindBlockScore = 0;
    private int calfWinterRestScore =0;
    private double totalWarmVentilatingScore = 0;
    private int limpScore = -1;
    private float slightHairLoss = -1;
    private float criticalHairLoss = 0;
    private int hairLossScore = 0;
    private long minInjuryScore = 0;
    private int cough = 0;
    private float runnyNoseRatio = 0;
    private float ophthalmicRatio = 0;
    private float breathRatio = 0;



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
    public void setCough(int cough){
        this.cough = cough;
    }
    public int getCough(){
        return this.cough;
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




    public void clickDongHandler(ImageButton nextBtn, ImageButton prevBtn, Button endButton, LinearLayout[] dongArr, TextView currentDongTv, int dong_size){

        final int[] currentDong = {0};
            nextBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(currentDong[0] == 0) {
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
    public float setDiseaseSectionRatio(EditText ed, TextView RatioTv, TextView sampleSizeTv){
        final float[] ratio = new float[1];
        ratio[0] = -1;
        ed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(TextUtils.isEmpty(ed.getText().toString())){
                    ratio[0] = -1;
                    RatioTv.setText("값을 입력하세요");
                } else if(getRatio(ed) > 100){
                    ratio[0] = -1;
                    RatioTv.setText("표본 규모보다 큰 값 입력 불가");
                    sampleSizeTv.setVisibility(View.VISIBLE);
                    sampleSizeTv.setText("표본 규모 : " + String.valueOf(getSampleCowSize()));
                } else {
                    RatioTv.setText(String.valueOf(getRatio(ed)));
                    ratio[0] = getRatio(ed);
                }
            }
        });
        if(ratio[0] == -1){
            return -1;
        } else {
            return ratio[0];
        }
    }


}

