package com.example.animal_project;

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

    private int poorScore = 0;
    private int waterTankNum = 0;
    private int waterTankClean = 0;
    private int waterDrink = 0;
    private int waterScore = 0;
    private int strawScore = 0;



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
                        totalScore[0] = getTotalStrawScore(straw_feed_tank[0],straw_normal[0],straw_resting_place[0]);
                        view.setText(String.valueOf(totalScore[0]));
                        break;
                    case 1:
                        straw_feed_tank[0] = 2;
                        totalScore[0] = getTotalStrawScore(straw_feed_tank[0],straw_normal[0],straw_resting_place[0]);
                        view.setText(String.valueOf(totalScore[0]));
                        break;
                    case 2:
                        straw_feed_tank[0] = 3;
                        totalScore[0] = getTotalStrawScore(straw_feed_tank[0],straw_normal[0],straw_resting_place[0]);
                        view.setText(String.valueOf(totalScore[0]));
                        break;
                    case 3:
                        straw_feed_tank[0] = 4;
                        totalScore[0] = getTotalStrawScore(straw_feed_tank[0],straw_normal[0],straw_resting_place[0]);
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
                        totalScore[0] = getTotalStrawScore(straw_feed_tank[0],straw_normal[0],straw_resting_place[0]);
                        view.setText(String.valueOf(totalScore[0]));
                        break;
                    case 1:
                        straw_normal[0] = 2;
                        totalScore[0] = getTotalStrawScore(straw_feed_tank[0],straw_normal[0],straw_resting_place[0]);
                        view.setText(String.valueOf(totalScore[0]));
                        break;
                    case 2:
                        straw_normal[0] = 3;
                        totalScore[0] = getTotalStrawScore(straw_feed_tank[0],straw_normal[0],straw_resting_place[0]);
                        view.setText(String.valueOf(totalScore[0]));
                        break;
                    case 3:
                        straw_normal[0] = 4;
                        totalScore[0] = getTotalStrawScore(straw_feed_tank[0],straw_normal[0],straw_resting_place[0]);
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
                        totalScore[0] = getTotalStrawScore(straw_feed_tank[0],straw_normal[0],straw_resting_place[0]);
                        view.setText(String.valueOf(totalScore[0]));
                        break;
                    case 1:
                        straw_resting_place[0] = 2;
                        totalScore[0] = getTotalStrawScore(straw_feed_tank[0],straw_normal[0],straw_resting_place[0]);
                        view.setText(String.valueOf(totalScore[0]));
                        break;
                    case 2:
                        straw_resting_place[0] = 3;
                        totalScore[0] = getTotalStrawScore(straw_feed_tank[0],straw_normal[0],straw_resting_place[0]);
                        view.setText(String.valueOf(totalScore[0]));
                        break;
                    case 3:
                        straw_resting_place[0] = 4;
                        totalScore[0] = getTotalStrawScore(straw_feed_tank[0],straw_normal[0],straw_resting_place[0]);
                        view.setText(String.valueOf(totalScore[0]));
                        break;
                }
            }
        });

    }
    public int getTotalStrawScore(int feedTank, int normal, int restingPlace){
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
}

