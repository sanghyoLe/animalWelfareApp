package com.example.animal_project;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


public class QuestionTemplateViewModel extends ViewModel {

    private int poorScore = 0;
    private int waterTankNum = 0;
    private int waterTankClean = 0;
    private int waterScore = 0;
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
    public void setWaterScore(int waterScore){
        this.waterScore = waterScore;
    }
    public int getWaterScore(){
        return this.waterScore;
    }


}

