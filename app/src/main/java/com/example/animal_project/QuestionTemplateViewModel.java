package com.example.animal_project;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.lifecycle.ViewModel;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class QuestionTemplateViewModel extends ViewModel {
    public static class Question{
        int numberOfCow = -1;
        float ratio = -1;
        float score = -1;
        public void setNumberOfCow(int numberOfCow) {this.numberOfCow = numberOfCow;}
        public int getNumberOfCow(){ return this.numberOfCow;}
        public void setRatio(float ratio){ this.ratio = ratio;}
        public float getRatio(){return this.ratio;}
        public void setScore(float score) { this.score = score;}
        public float getScore(){return this.score;}
    }
    public static class PenQuestion extends Question {
        String penLocation;
        public PenQuestion(String penLocation, int numberOfCow, float ratio){
            this.penLocation = penLocation;
            this.numberOfCow = numberOfCow;
            this.ratio = ratio;
        }
        public void setPenLocation(String penLocation){ this.penLocation = penLocation; }
        public String getPenLocation() {return this.penLocation;}
    }
    public static class RadioQuestion {
        int selectedItem = -1;
        String answer;
        public RadioQuestion(int selectedItem){
            this.selectedItem = selectedItem;
        }
        public void setSelectedItem(int selectedItem) {
            this.selectedItem = selectedItem;
        }
        public int getSelectedItem() {
            return selectedItem;
        }
        public void setAnswer(RadioGroup radioGroup, int selectedItem){
            this.answer = (String)((RadioButton) radioGroup.getChildAt(selectedItem-1)).getText();;
        }
        public String getAnswer() { return answer; }


    }
    public static class DongQuestion implements Serializable {
        String[] penLocation;
        int[] cowSize;
        int dongSize;

        public void setDongSize(int dongSize){this.dongSize = dongSize;}
        public int getDongSize(){ return dongSize;}
        public void setPenLocation(String[] penLocation){ this.penLocation = penLocation;}
        public String[] getPenLocation() { return this.penLocation;}
        public void setCowSize(int[] cowSize) {this.cowSize = cowSize;}
        public int[] getCowSize(){ return this.cowSize;}

    }


    public static class avoidDistance implements Serializable {
        int penNumber;
        String penLocation;
        int cowSize = -1;
        int[] cowCount;
        int[] cowNumber;
        int[] avoidDistance;
        int penSize;
        int farmId;

        public avoidDistance(int penNumber, String penLocation, int cowSize){
            this.penNumber = penNumber;
            this.penLocation = penLocation;
            this.cowSize = cowSize;
        }
        public void setPenSize(int penSize){
            this.penSize = penSize;
        }
        public int getPenSize(){
            return this.penSize;
        }
        public void setFarmId(int farmId){
            this.farmId = farmId;
        }
        public int getFarmId(){
            return this.farmId;
        }
        public int getPenNumber(){
            return this.penNumber;
        }
        public String getPenLocation(){
            return this.penLocation;
        }
        public int getCowSize(){
            return this.cowSize;
        }
        public void setCowFieldSize(int cowSize){
            this.cowCount = new int[cowSize];
            this.cowNumber = new int[cowSize];
            this.avoidDistance = new int[cowSize];
        }
        public void setCowCount(int cowSize){
            for(int i = 0 ;i < cowSize ;i ++){
                this.cowCount[i] = i;
            }
        }
        public void setCowNumber(int[] cowNumber){
            this.cowNumber = cowNumber;
        }
        public void setAvoidDistance(int[] avoidDistance){
            this.avoidDistance = avoidDistance;
        }
        public int[] getCowNumber(){
            return this.cowNumber;
        }
        public int[] getAvoidDistance(){
            return this.avoidDistance;
        }

    }
    public void setAvoidDistances(){
        for(int i = 1 ; i < 51 ; i++){
            this.avoidDistances[i] = new avoidDistance(i,"0",-1);
        }
    }
    public avoidDistance[] getAvoidDistances(){ return this.avoidDistances; }
    public void setAvoidDistance(int penNumber, avoidDistance avoidDistance) {
        this.avoidDistances[penNumber] = avoidDistance;
    }
    public avoidDistance getAvoidDistance(int penNumber){
        return this.avoidDistances[penNumber];
    }
    public static class WaterTimeQuestion extends DongQuestion implements Serializable {

        int[] waitingCowSize;
        int[] drinkTime;
        int[] waterTimeScore;
        float[] waitingRatio;
        int farmId;
        int maxWaterTimeScore = -1;
        int farmType;
        public WaterTimeQuestion(int dongSize){
            this.penLocation = new String[dongSize];
            this.cowSize = new int[dongSize];
            this.waitingCowSize = new int[dongSize];
            this.drinkTime = new int[dongSize];
            this.waterTimeScore = new int[dongSize];
            this.waitingRatio = new float[dongSize];
        }
        public void setFarmType(int farmType){
            this.farmType = farmType;
        }
        public int getFarmType(){
            return this.farmType;
        }
        public void setFarmId(int farmId){
            this.farmId = farmId;
        }
        public int getFarmId(){return this.farmId;}
        public void setWaitingCowSize(int[] waitingCowSize){
            this.waitingCowSize = waitingCowSize;
        }
        public int[] getWaitingCowSize(){
            return this.waitingCowSize;
        }
        public void setDrinkTime(int[] drinkTime){
            this.drinkTime = drinkTime;
        }
        public int[] getDrinkTime(){
            return this.drinkTime;
        }
        public void setWaitingRatio(float[] waitingRatio){
            this.waitingRatio = waitingRatio;
        }
        public float[] getWaitingRatio(){
            return this.waitingRatio;
        }
        public void setWaterTimeScore(int[] waterTimeScore){
            this.waterTimeScore = waterTimeScore;
        }
        public int[] getWaterTimeScore(){
            return this.waterTimeScore;
        }
        public void setMaxWaterTimeScore(int maxWaterTimeScore){
            this.maxWaterTimeScore = maxWaterTimeScore;
        }
        public int getMaxWaterTimeScore(){
            return this.maxWaterTimeScore;
        }

    }
    public void setWaterTimeQuestion(WaterTimeQuestion waterTimeQuestion){
        this.WaterTimeQuestion = waterTimeQuestion;
    }
    public WaterTimeQuestion getWaterTimeQuestion(){
        return (QuestionTemplateViewModel.WaterTimeQuestion) this.WaterTimeQuestion;
    }
    public static class StrawQuestion extends DongQuestion implements Serializable{
        int[] strawOne;
        int[] strawTwo;
        int[] strawThree;
        int[] strawScore;
        float strawAvgScore = -1;

        public StrawQuestion(int dongSize){
            this.penLocation = new String[dongSize];
            this.strawOne = new int[dongSize];
            this.strawTwo = new int[dongSize];
            this.strawThree = new int[dongSize];
            this.strawScore = new int[dongSize];
        }

        public void setStrawOne(int strawOne,int i) {
            this.strawOne[i] = strawOne;
        }

        public void setStrawTwo(int strawTwo,int i) {
            this.strawTwo[i] = strawTwo;
        }

        public void setStrawThree(int strawThree,int i) {
            this.strawThree[i] = strawThree;
        }

        public void setStrawScore(int strawScore,int i) {
            this.strawScore[i] = strawScore;
        }

        public int getStrawOne(int i) {
            return strawOne[i];
        }
        public int getStrawTwo(int i) {
            return strawTwo[i];
        }
        public int getStrawThree(int i) {
            return strawThree[i];
        }
        public int[] getStrawScore() {
            return strawScore;
        }
        public void setStrawAvgScore(int strawScore[], int dongSize){
            float avgScore = 0;
            for(int i = 0 ;i < dongSize ; i++){
                avgScore += strawScore[i];
            }
            avgScore = (avgScore / dongSize);
            avgScore = Math.round(avgScore*100)/100;
            this.strawAvgScore = avgScore;
        }
        public int[] getStrawOneArr(){
            return this.strawOne;
        }
        public int[] getStrawTwoArr(){
            return this.strawTwo;
        }
        public int[] getStrawThreeArr(){
            return this.strawThree;
        }
        public float getStrawAvgScore(){
            return this.strawAvgScore;
        }

    }
    public static class CoughQuestion extends DongQuestion implements Serializable {

        int[] coughCount;
        float[] coughPerOne;
        float CoughPerOneAvg = -1;
        float coughRatio = -1;
        public CoughQuestion(int dongSize){
            this.penLocation = new String[dongSize];
            this.cowSize = new int[dongSize];
            this.coughCount = new int[dongSize];
            this.coughPerOne = new float[dongSize];
        }
        public void setCoughCount(int[] coughCount){ this.coughCount = coughCount; }
        public int[] getCoughCount() {return this.coughCount; }
        public void setCoughPerOne(float[] coughPerOne){ this.coughPerOne = coughPerOne;}
        public float[] getCoughPerOne(){return this.coughPerOne;}
        public void setCoughPerOneAvg(float CoughPerOneAvg){this.CoughPerOneAvg = CoughPerOneAvg;}
        public float getCoughPerOneAvg(){ return this.CoughPerOneAvg;}
        public void setCoughRatio(float coughRatio){this.coughRatio = coughRatio;}
        public float getCoughRatio(){return this.coughRatio;}
    }
    public void setCoughQuestion(CoughQuestion coughQuestion){this.CoughQuestion = coughQuestion;}
    public CoughQuestion getCoughQuestion(){return (QuestionTemplateViewModel.CoughQuestion) this.CoughQuestion;}
    public static class BehaviorQuestion extends DongQuestion implements Serializable{
        int[] behaviorCount;
        float[] behaviorPerOne;
        float behaviorPerOneAvg;
        public BehaviorQuestion(int dongSize){
            this.penLocation = new String[dongSize];
            this.cowSize = new int[dongSize];
            this.behaviorCount = new int[dongSize];
            this.behaviorPerOne = new float[dongSize];
            this.behaviorPerOneAvg = -1;

        }

        public void setBehaviorCount(int[] behaviorCount) {
            this.behaviorCount = behaviorCount;
        }

        public int[] getBehaviorCount() {
            return behaviorCount;
        }

        public void setBehaviorPerOne(float[] behaviorPerOne) {
            this.behaviorPerOne = behaviorPerOne;
        }

        public float[] getBehaviorPerOne() {
            return behaviorPerOne;
        }

        public void setBehaviorPerOneAvg(float BehaviorPerOneAvg) {
            this.behaviorPerOneAvg = BehaviorPerOneAvg;
        }

        public float getBehaviorPerOneAvg() {
            return behaviorPerOneAvg;
        }
    }
    public void setStruggleQuestion(Object StruggleQuestion){
        this.StruggleQuestion = StruggleQuestion;
    }
    public Object getStruggleQuestion(){
        return this.StruggleQuestion;
    }
    public void setHarmonyQuestion(Object harmonyQuestion){
        this.HarmonyQuestion = harmonyQuestion;
    }
    public Object getHarmonyQuestion(){
        return this.HarmonyQuestion;
    }


    // 착유우 Class
    public static class SitTimeQuestion extends Question{
        int sitCount;
        int[] sitTime;
        float sitTimeAvg;
        public SitTimeQuestion(int sitCount){
            this.sitCount = sitCount;
            this.sitTime = new int[sitCount];
            for(int i = 0; i < sitCount; i++){
                sitTime[i] = -1;
            }
        }
        public void setSitCount(int sitCount){
            this.sitCount = sitCount;
        }
        public int getSitCount(){
            return this.sitCount;
        }

        public void setSitTime(String sitTime,int index) {
            this.sitTime[index] = Integer.parseInt(sitTime);
        }
        public int[] getSitTime(){
            return this.sitTime;
        }
        public void setSitTimeAvg(float sitTimeAvg){
            this.sitTimeAvg = sitTimeAvg;
        }
        public float getSitTimeAvg(){
            return this.sitTimeAvg;
        }
    }
    public class YearAvgQuestion extends Question{
        int yearAvgCount;

        public void setYearAvgCount(int yearAvgCount){
            this.yearAvgCount = yearAvgCount;
        }
        public int getYearAvgCount(){
            return this.yearAvgCount;
        }
    }
    public static class MilkCowStruggleQuestion extends DongQuestion implements Serializable{
        int[] headBangCount;
        float[] headBangPerOne;
        float headBangPerOneAvg;
        int[] headBangExceptStruggleCount;
        float[] headBangExceptStrugglePerOne;
        float headBangExceptStrugglePerOneAvg;
        float struggleIndex;
        float score;
        public void setHeadBangCount(int[] headBangCount) {
            this.headBangCount = headBangCount;
        }

        public int[] getHeadBangCount() {
            return headBangCount;
        }

        public void setHeadBangPerOne(float[] headBangPerOne) {
            this.headBangPerOne = headBangPerOne;
        }

        public float[] getHeadBangPerOne() {
            return headBangPerOne;
        }

        public void setHeadBangPerOneAvg(float headBangPerOneAvg) {
            this.headBangPerOneAvg = headBangPerOneAvg;
        }

        public float getHeadBangPerOneAvg() {
            return headBangPerOneAvg;
        }
        public void setHeadBangExceptStruggleCount(int[] headBangExceptStruggleCount) {
            this.headBangExceptStruggleCount = headBangExceptStruggleCount;
        }

        public int[] getHeadBangExceptStruggleCount() {
            return headBangExceptStruggleCount;
        }

        public void setHeadBangExceptStrugglePerOne(float[] headBangExceptStrugglePerOne) {
            this.headBangExceptStrugglePerOne = headBangExceptStrugglePerOne;
        }

        public float[] getHeadBangExceptStrugglePerOne() {
            return headBangExceptStrugglePerOne;
        }
        public void setHeadBangExceptStrugglePerOneAvg(float headBangExceptStrugglePerOneAvg) {
            this.headBangExceptStrugglePerOneAvg = headBangExceptStrugglePerOneAvg;
        }

        public float getHeadBangExceptStrugglePerOneAvg() {
            return headBangExceptStrugglePerOneAvg;
        }
        public void setStruggleIndex(float struggleIndex){
            this.struggleIndex = struggleIndex;
        }
        public float getStruggleIndex(){
            return this.struggleIndex;
        }

        public float calculatorStruggleIndex(float headBangPerOneAvg,float headBangExceptStrugglePerOneAvg){
            return  Math.round((float)(100 - (100 * (43.8 - (4 * headBangPerOneAvg + 11 * headBangExceptStrugglePerOneAvg)) / 43.8)));
        }


        public MilkCowStruggleQuestion(int dongSize) {
            this.headBangCount = new int[dongSize];
            this.headBangPerOne = new float[dongSize];
            this.headBangPerOneAvg = -1;
            this.headBangExceptStruggleCount = new int[dongSize];
            this.headBangExceptStrugglePerOne = new float[dongSize];
            this.headBangExceptStrugglePerOneAvg = -1;
            this.struggleIndex = -1;
            this.score = -1;

        }
        public float getScore(){
            return this.score;
        }
        public void setScore(float score){
            this.score = score;
        }

        public float calculatorScore(float struggleIndex){
            float socialBehaviorScore = 0;
            if (struggleIndex > 100) {
                return socialBehaviorScore = -1;
            }
            if(struggleIndex == 0) {
                socialBehaviorScore = 100;
            } else if(struggleIndex <= 4 ) {
                socialBehaviorScore = 90;
            } else if(struggleIndex <= 9 ) {
                socialBehaviorScore = 80;
            } else if(struggleIndex <= 14 ) {
                socialBehaviorScore = 70;
            } else if(struggleIndex <= 19 ) {
                socialBehaviorScore = 60;
            } else if(struggleIndex <= 25 ) {
                socialBehaviorScore = 50;
            } else if(struggleIndex <= 32 ) {
                socialBehaviorScore = 40;
            } else if(struggleIndex <= 41 ) {
                socialBehaviorScore = 30;
            } else if(struggleIndex <= 53 ) {
                socialBehaviorScore = 20;
            } else if(struggleIndex <= 71 ) {
                socialBehaviorScore = 10;
            } else if(struggleIndex <= 100 ) {
                socialBehaviorScore = 0;
            }
            return socialBehaviorScore;
        }
    }
    public void setMilkCowStruggle(Object milkCowStruggle) {
        MilkCowStruggle = milkCowStruggle;
    }
    public Object getMilkCowStruggle(){
        return MilkCowStruggle;
    }

    // 프리스톨 Class
    public static class FreeStallCountQuestion extends DongQuestion{
        int[] freeStallCount;
        double[] freeStallCountRatio;
        int[] freeStallCountScore;
        int lowestScore = -1;
        double lowestRatio;
        public FreeStallCountQuestion(int dongSize){
            freeStallCount = new int[dongSize];
            freeStallCountRatio = new double[dongSize];
            freeStallCountScore = new int[dongSize];

        }

        public void setFreeStallCount(int[] freeStallCount) {
            this.freeStallCount = freeStallCount;
        }
        public int[] getFreeStallCount() {
            return freeStallCount;
        }
        public void setFreeStallCountRatio(double[] freeStallCountRatio){
            this.freeStallCountRatio = freeStallCountRatio;
        }
        public double[] getFreeStallCountRatio(){
            return this.freeStallCountRatio;
        }
        public void setFreeStallCountScore(int[] freeStallCountScore){
            this.freeStallCountScore = freeStallCountScore;
        }
        public int[] getFreeStallCountScore(){
            return this.freeStallCountScore;
        }
        public void setLowestScore(int lowestScore) {
            this.lowestScore = lowestScore;
        }
        public int getLowestScore(){
            return this.lowestScore;
        }
        public void setLowestRatio(double lowestRatio) { this.lowestRatio = lowestRatio;}
        public double getLowestRatio() { return this.lowestRatio;}


        public double[] calculatorRatio(int[] cowSize, int[] freeStallCount,int dongSize){
            double[] freeStallCountRatio = new double[dongSize];
            for(int i = 0 ; i < dongSize ; i++){
                freeStallCountRatio[i] = (double)Math.round((((double)cowSize[i] / (double)freeStallCount[i]) *100)) / 100.0;
            }
            return freeStallCountRatio;
        }
        public int[] calculatorScore(double[] freeStallCountRatio, int dongSize){
            int score[] = new int[dongSize];
            for(int i = 0 ; i < dongSize ;i++){
                if(freeStallCountRatio[i] >= 1){
                    score[i] = 100;
                } else if(freeStallCountRatio[i] >= 0.95){
                    score[i] = 70;
                } else {
                    score[i] = 40;
                }
            }
            return score;
        }
        public int calculatorLowestScore(int[] freeStallCountScore, int dongSize){
            int lowestScore = 101;
            for(int i = 0 ; i < dongSize ; i++)
                lowestScore = lowestScore > freeStallCountScore[i] ? freeStallCountScore[i] :  lowestScore ;

            return lowestScore;
        }
        public double calculatorLowestRatio(double[] freeStallCountRatio, int dongSize){
            double lowestScore = 101;
            for(int i = 0 ; i < dongSize ; i++)
                lowestScore = lowestScore > freeStallCountRatio[i] ? freeStallCountRatio[i] :  lowestScore ;

            return lowestScore;
        }
    }
    public void setFreeStallCountQuestion(Object freeStallCountQuestion){ this.freeStallCountQuestion  = freeStallCountQuestion; }
    public Object getFreeStallCountQuestion(){return this.freeStallCountQuestion; }
    public static class FreeStallAreaOutCollision extends Question{
        int sitCowCount;
        int areaOutCollisionCowCount;
        public void setSitCowCount(int sitCowCount){
            this.sitCowCount = sitCowCount;
        }
        public int getSitCowCount(){
            return this.sitCowCount;
        }
        public void setAreaOutCollisionCowCount(int areaOutCollisionCowCount){
            this.areaOutCollisionCowCount = areaOutCollisionCowCount;
        }
        public int getAreaOutCollisionCowCount(){
            return this.areaOutCollisionCowCount;
        }
        public int calculatorScore(float ratio){
            int score = 0;
         if(ratio <= 3){
             score = 100;
         } else if(ratio <= 5){
             score = 70;
         } else {
             score = 40;
         }
         return score;
        }
    }

    public static class SitCollisionQuestion extends Question{
        int sitCount;
        boolean[]  sitCollision;

        public SitCollisionQuestion(int sitCount){
            this.sitCount = sitCount;
            this.sitCollision = new boolean[sitCount];
            for(int i = 0; i < sitCount; i++){
                this.sitCollision[i] = false;
            }
        }
        public void setSitCount(int sitCount){
            this.sitCount = sitCount;
        }
        public int getSitCount(){
            return this.sitCount;
        }
        public void setSitCollision(boolean sitCollision,int index) {
            this.sitCollision[index] = sitCollision;
        }
        public boolean[] getSitCollision (){
            return this.sitCollision;
        }
        public float calculatorRatio(boolean[] sitCollision, int sitCount){
            float ratio = 0;
            int sitCollisionCount = 0;
            for(int i = 0 ;  i < sitCount ; i++){
                if(sitCollision[i] == true) {
                    sitCollisionCount += 1;
                }
            }
            ratio = ((float) (Math.round( ((float)sitCollisionCount / (float)sitCount) * 100)));

            return ratio;
        }
        public int calculatorScore(float ratio){
            int score;
            if(ratio >= 31){
                score = 40;
            } else if(ratio >= 21){
                score = 70;
            } else{
                score = 100;
            }
            return score;
        }



    }
    // 한육우 Objects
    public Object WaterTimeQuestion = new WaterTimeQuestion(20);
    public Object CoughQuestion = new CoughQuestion(20);
    public Object StrawQuestion = new StrawQuestion(20);
    public Object StruggleQuestion = new BehaviorQuestion(20);
    public Object HarmonyQuestion = new BehaviorQuestion(20);
    public avoidDistance[] avoidDistances = new avoidDistance[51];
    public Object BreedPoor = new Question();
    public Object BreedLimp = new Question();

    // PenQuestions

    public Object BreedOutward = new PenQuestion("",-1,-1);
    public Object BreedSlightHairLoss = new PenQuestion("",-1,-1);
    public Object BreedCriticalHairLoss = new PenQuestion("",-1,-1);
    public Object BreedRunnyNose = new PenQuestion("",-1,-1);
    public Object BreedOphthalmic = new PenQuestion("",-1,-1);
    public Object BreedBreath = new PenQuestion("",-1,-1);
    public Object BreedDiarrhea = new PenQuestion("",-1,-1);
    public Object BreedRuminant = new PenQuestion("",-1,-1);
    public Object BreedFallDead = new PenQuestion("",-1,-1);

    public Object[] penQuestionArr = {
            BreedOutward,BreedSlightHairLoss,BreedCriticalHairLoss,BreedRunnyNose,BreedOphthalmic,
            BreedBreath,BreedDiarrhea,BreedRuminant,BreedFallDead};

    // RadioQuestions
    public Object BreedWaterTankNum = new RadioQuestion(-1);
    public Object BreedWaterTankClean = new RadioQuestion(-1);
    public Object BreedShade = new RadioQuestion(-1);
    public Object BreedSummerVentilating = new RadioQuestion(-1);
    public Object BreedMistSpray = new RadioQuestion(-1);
    public Object BreedWindBlock = new RadioQuestion(-1);
    public Object BreedWinterVentilating = new RadioQuestion(-1);
    public Object CalfShade = new RadioQuestion(-1);
    public Object CalfSummerVentilating = new RadioQuestion(-1);
    public Object CalfMistSpray = new RadioQuestion(-1);
    public Object CalfStraw = new RadioQuestion(-1);
    public Object CalfWarm = new RadioQuestion(-1);
    public Object CalfWindBlock = new RadioQuestion(-1);
    public Object BreedHornRemoval = new RadioQuestion(-1);
    public Object BreedHornAnesthesia = new RadioQuestion(-1);
    public Object BreedHornPainkiller = new RadioQuestion(-1);
    public Object BreedCastration = new RadioQuestion(-1);
    public Object BreedCastrationAnesthesia = new RadioQuestion(-1);
    public Object BreedCastrationPainkiller = new RadioQuestion(-1);
    public Object[] radioQuestionArr = {
                BreedWaterTankNum,BreedWaterTankClean,BreedShade,BreedSummerVentilating, BreedMistSpray,
                BreedWindBlock,BreedWinterVentilating,CalfShade, CalfSummerVentilating,CalfMistSpray,
                CalfStraw,CalfWarm,CalfWindBlock, BreedHornRemoval,BreedHornAnesthesia,
                BreedHornPainkiller, BreedCastration,BreedCastrationAnesthesia,BreedCastrationPainkiller};


    // 착유우
    public Object SitTimeQuestion = new SitTimeQuestion(50);
    public Object AppearanceBottomLeg = new Question();
    public Object AppearanceBack = new Question();
    public Object AppearanceBreast = new Question();
    public Object CriticalLimp = new Question();
    public Object OutGenitals = new PenQuestion("-1",-1,-1);
    public Object MilkInCell = new PenQuestion("-1",-1,-1);
    public Object hardBirth = new YearAvgQuestion();
    public Object unableStand = new YearAvgQuestion();
    public Object MilkCowStruggle = new MilkCowStruggleQuestion(12);
    public Object[] milkCowPenQuestionArr = {
            BreedSlightHairLoss,BreedRunnyNose,BreedOphthalmic,BreedBreath, BreedDiarrhea,
            OutGenitals,MilkInCell,BreedFallDead
    };
    
    // 프리스톨
    public Object freeStallCountQuestion = new FreeStallCountQuestion(20);
    public Object sitCollision = new SitCollisionQuestion(50);
    public Object freeStallAreaOutCollision = new FreeStallAreaOutCollision();






    private int farmType = 0;
    private int milkCowSize = 0;
    private int sampleCowSize = 0;
    private int totalCowSize = 0;
    private int poorScore = -1;


    // 착유우 음수조 형태
    private String waterTankForm = "";
    private int waterTankNum = -1;
    private int waterTankClean = -1;
    private int waterDrink = -1;
    private int waterScore = -1;
    // 깔짚 수분 프로토콜 재 정의 필요
    private float strawScore = -1;
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

    private int calfSummerRestScore = -1;
    private int calfStrawScore = -1;
    private int calfWarmScore = -1;
    private int calfWindBlockScore = -1;
    private int calfWinterRestScore = -1;
    private double totalWarmVentilatingScore = -1;



    private int limpScore = -1;
    private float slightHairLoss = -1;
    private float criticalHairLoss = -1;
    private int hairLossScore = -1;
    private float hairLossTotalRatio = -1;
    private long minInjuryScore = -1;
    private double cough = -1;

    private double diseaseScore = -1;

    private int hornRemovalScore = -1;

    private int castrationScore = -1;
    private double minPainScore = -1;
    private double struggle = -1;
    private double harmony = -1;
    private int socialBehaviorScore = -1;
    private int avoidDistanceScore = -1;
    private float avoidDistanceRatio = -1;
    private int avoidDistanceLevelOneTotal = 0;
    private int avoidDistanceLevelTwoTotal = 0;
    private int avoidDistanceLevelThreeTotal = 0;
    private int avoidDistanceLevelFourTotal = 0;
    private double protocolOneScore = -1;
    private double protocolTwoScore = -1;
    private double protocolThreeScore = -1;
    private double protocolFourScore = -1;

    private float totalLimpRatio = -1;

    public void setFarmType(int farmType){
        this.farmType = farmType;
    }
    public int getFarmType(){
        return this.farmType;
    }
    public void setMilkCowSize(int milkCowSize) { this.milkCowSize = milkCowSize; }
    public int getMilkCowSize(){return this.milkCowSize; }
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

    public void setTotalLimpRatio(float totalLimpRatio){
        this.totalLimpRatio = totalLimpRatio;
    }
    public float getTotalLimpRatio(){
        return this.totalLimpRatio;
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
    public void setStrawScore(float strawScore) {
        this.strawScore = strawScore;
    }
    public float getStrawScore() { return this.strawScore; };
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
    public void setHairLossTotalRatio(float totalHairLossRatio){
        this.hairLossTotalRatio = totalHairLossRatio;
    }
    public float getHairLossTotalRatio(){
        return this.hairLossTotalRatio;
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

    public void setDiseaseScore(double diseaseScore){
        this.diseaseScore = diseaseScore;
    }
    public double getDiseaseScore(){
        return this.diseaseScore;
    }

    public void setHornRemovalScore(int hornRemovalScore){
        this.hornRemovalScore = hornRemovalScore;
    }
    public int getHornRemovalScore(){
        return this.hornRemovalScore;
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

    public void setSocialBehaviorScore(int socialBehaviorScore){
        this.socialBehaviorScore = socialBehaviorScore;
    }
    public int getSocialBehaviorScore(){
        return this.socialBehaviorScore;
    }
    public void setAvoidDistanceLevelOneTotal(int avoidDistanceLevelOne) {
        this.avoidDistanceLevelOneTotal += 1;
    }
    public void setAvoidDistanceLevelTwoTotal(int avoidDistanceLevelTwo) {
        this.avoidDistanceLevelTwoTotal += 1;
    }
    public void setAvoidDistanceLevelThreeTotal(int avoidDistanceLevelThree){
        this.avoidDistanceLevelThreeTotal += 1;
    }
    public void setAvoidDistanceLevelFourTotal(int avoidDistanceLevelFour){
        this.avoidDistanceLevelFourTotal += 1;
    }
    public int getAvoidDistanceLevelOneTotal(){
        return this.avoidDistanceLevelOneTotal;
    }
    public int getAvoidDistanceLevelTwoTotal(){
        return this.avoidDistanceLevelTwoTotal;
    }
    public int getAvoidDistanceLevelThreeTotal(){
        return this.avoidDistanceLevelThreeTotal;
    }
    public int getAvoidDistanceLevelFourTotal(){
        return this.avoidDistanceLevelFourTotal;
    }

    public void setAvoidDistanceRatio(float avoidDistanceRatio){
        this.avoidDistanceRatio = avoidDistanceRatio;
    }
    public float getAvoidDistanceRatio(){
        return this.avoidDistanceRatio;
    }
    public void setAvoidDistanceScore(int avoidDistanceScore){
        this.avoidDistanceScore = avoidDistanceScore;
    }
    public int getAvoidDistanceScore(){
        return this.avoidDistanceScore;
    }


    public int calculatorWaterScore(int waterTankNum, int waterTankClean, int waterTankTime)
    {
        int waterScore = 0;
        // 음수조 수 기준 합격
        if (waterTankNum == 1) {
            // 음수조 위생 청결 or 보통
            if (waterTankClean <= 2) {
                // 음수 행동 매우 양호 or 보통
                if (waterTankTime < 2) {
                    waterScore = 100;
                } else {
                    waterScore = 80;
                }
            }
            // 음수조 위생 더러움
            else {
                if (waterTankTime < 2) {
                    waterScore = 60;
                } else {
                    waterScore = 45;
                }
            }
        }
        // 음수조 수 기준 초과
        else {
            // 음수조 위생 청결 or 보통
            if (waterTankClean <= 2) {
                if (waterTankTime < 2) {
                    waterScore = 55;
                } else {
                    waterScore = 40;
                }
            }
            // 음수조 위생 더러움
            else {
                if (waterTankTime < 2) {
                    waterScore = 35;
                } else {
                    waterScore = 20;
                }
            }
        }
        return waterScore;
    }
    public int calculatorBreedStrawScore(int feedTank, int normal, int restingPlace){
        int StrawScore = 100;
        int checkCount = 0;
        if(feedTank == 1){
            checkCount++;
        }
        if(normal == 1){
            checkCount++;
        }
                                                                                                                                                                                                                        if(restingPlace == 1){
            checkCount++;
        }

        if(checkCount == 0){
            StrawScore = 100;
        } else if( checkCount == 1){
            StrawScore = 70;
        } else if( checkCount == 2){
            StrawScore = 30;
        } else {
            StrawScore = 0;
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
    public double calculatorProtocolOneResult(int farmType, int PoorScore, int WaterScore){
        if(isBeef(farmType)){
            return (PoorScore * 0.7) + (WaterScore * 0.3);
        }
        return (PoorScore * 0.65) + (WaterScore * 0.35);
    }

    public double calculatorBreedRestScore(float strawScore, int outwardScore)
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

    public double calculatorTotalWarmVentilationScore(int farmType, int breedSummerScore, int breedWinterScore, int calfSummerScore, int calfWinterScore) {
        double warmVenScore = 0;
        if(farmType == 2 || farmType == 3){
            warmVenScore = ((breedSummerScore * 0.35) + (breedWinterScore * 0.15)) + ((calfSummerScore * 0.25) + (calfWinterScore * 0.25));
        } else if (farmType == 4 || farmType == 5){
            warmVenScore = ((breedSummerScore * 0.4) + (breedWinterScore * 0.2)) + ((calfSummerScore * 0.2) + (calfWinterScore * 0.2));
        }

        return warmVenScore;
    }
    public double calculatorProtocolTwoScore(double restScore, double totalWarmVentilatingScore){

        double protocolTwoScore = (restScore * 0.6) + (totalWarmVentilatingScore * 0.4);

        return Math.round(protocolTwoScore);
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
    public long calculatorMinInjuryScore(int farmType, int limpScore, int hairLossScore){
        long minInjuryScore = 0;
        if(isBeef(farmType)){
            minInjuryScore = Math.round((limpScore * 0.6) + (hairLossScore *0.4));
            minInjuryScore = Math.round(minInjuryScore);
        } else {
            minInjuryScore = Math.round((limpScore * 0.5) + (hairLossScore *0.5));
            minInjuryScore = Math.round(minInjuryScore);
        }


        return minInjuryScore;
    }
    public float getRatio(EditText editText){
        float ratio = (Float.parseFloat(editText.getText().toString()) / getSampleCowSize()) * 100;
        ratio = (float) (Math.round(ratio*100)/100.0);

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
    public double calculatorProtocolThreeResult(int farmType, double minInjuryScore, double minPainScore, double diseaseScore){
        if(isBeef(farmType)){
            return Math.round((minInjuryScore * 0.35) + (diseaseScore * 0.4) + (minPainScore * 0.25));
        }
        return Math.round((minInjuryScore * 0.3) + (diseaseScore * 0.5) + (minPainScore * 0.2));

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
        return Math.round((socialBehaviorScore * 0.65) + (avoidDistanceScore * 0.35));
    }
    public int calculatorAvoidDistanceScore(double avoidDistanceRatio){
        int avoidDistanceScore = 0;
        if(avoidDistanceRatio == 0){
            avoidDistanceScore = 100;
        } else if(avoidDistanceRatio <= 7){
           avoidDistanceScore = 95;
        }else if(avoidDistanceRatio <= 13){
            avoidDistanceScore = 90;
        }else if(avoidDistanceRatio <= 18){
            avoidDistanceScore = 85;
        }else if(avoidDistanceRatio <= 22){
            avoidDistanceScore = 80;
        }else if(avoidDistanceRatio <= 26){
            avoidDistanceScore = 75;
        }else if(avoidDistanceRatio <= 29){
            avoidDistanceScore = 70;
        }else if(avoidDistanceRatio <= 32){
            avoidDistanceScore = 65;
        }else if(avoidDistanceRatio <= 35){
            avoidDistanceScore = 60;
        }else if(avoidDistanceRatio <= 38){
            avoidDistanceScore = 55;
        }else if(avoidDistanceRatio <= 41){
            avoidDistanceScore = 50;
        }else if(avoidDistanceRatio <= 45){
            avoidDistanceScore = 45;
        }else if(avoidDistanceRatio <= 49){
            avoidDistanceScore = 40;
        }else if(avoidDistanceRatio <= 54){
            avoidDistanceScore = 35;
        } else if(avoidDistanceRatio <= 59){
            avoidDistanceScore = 30;
        }else if(avoidDistanceRatio <= 66){
            avoidDistanceScore = 25;
        }else if(avoidDistanceRatio <= 73){
            avoidDistanceScore = 20;
        }else if(avoidDistanceRatio <= 80){
            avoidDistanceScore = 15;
        }else if(avoidDistanceRatio <= 86){
            avoidDistanceScore = 10;
        }else if(avoidDistanceRatio <= 93){
            avoidDistanceScore = 5;
        }else if(avoidDistanceRatio <= 100){
            avoidDistanceScore = 0;
        }
        return avoidDistanceScore;
    }
    public double calculatorAvoidDistanceRatio(int levelOne, int levelTwo, int levelThree,int levelFour){
        double avoidDistanceRatio;
        double total = levelOne + levelTwo + levelThree + levelFour;
        double levelTwoRatio = Math.round((levelTwo / total) * 100);
        double levelThreeRatio = Math.round((levelThree / total) * 100);
        double levelFourRatio = Math.round((levelFour / total ) * 100);


        avoidDistanceRatio = (levelTwoRatio + (3 * levelThreeRatio)  + (5 * levelFourRatio));
        avoidDistanceRatio = avoidDistanceRatio / 5;
        avoidDistanceRatio = Math.round(avoidDistanceRatio);
        return avoidDistanceRatio;
    }
    // Progressbar 점수 설정
    public void setProgressBar(double protocolScore, ProgressBar progressBar, TextView progressBarTv){
        progressBar.setProgress(Math.round((float)protocolScore));
        progressBarTv.setText(String.valueOf(protocolScore));
    }

    public double cutDecimal(double value){
        return (double)Math.round(value*100)/100;
    }
    public void showQuestionView(View[] QuestionViewArr, int dongSize) {
        TextView[] tvArr = new TextView[dongSize];
        for (int i = 0; i < dongSize; i++) {
            tvArr[i] = QuestionViewArr[i].findViewById(R.id.dong_count_tv);
            QuestionViewArr[i].setVisibility(View.GONE);
            tvArr[i].setText(String.valueOf(i + 1) + "동");
        }
        for (int i = 0; i < dongSize; i++) {
            QuestionViewArr[i].setVisibility(View.VISIBLE);
        }
    }
    public EditText[] makeEditText(View[] QuestionViewArr, int dongSize, int id){
        EditText[] newEditText = new EditText[dongSize];
        for(int i = 0 ; i < dongSize ; i++){
            newEditText[i] = QuestionViewArr[i].findViewById(id);
        }
        return newEditText;
    }
    public int checkEmptyEditText(EditText[] editTexts, int dongSize){
        for(int i = 0 ; i < dongSize ; i++){
            if(TextUtils.isEmpty(editTexts[i].getText())){
                return i+1;
            }
        }
        return -1;
    }

    public String makePenLocation(EditText penLocationOne, EditText penLocationTwo){
        if(TextUtils.isEmpty(penLocationOne.getText())){
            return "입력 값 없음";
        }else if(TextUtils.isEmpty(penLocationTwo.getText())){
            return "입력 값 없음";
        } else{
            return penLocationOne.getText() + "-" + penLocationTwo.getText();
        }
    }
    public int makeNumberOfCow(EditText numberOfCow){
        if(TextUtils.isEmpty(numberOfCow.getText())){
            return -1;
        } else {
            return Integer.parseInt(String.valueOf(numberOfCow.getText()));
        }
    }

    public String[] makePenLocationArr(EditText[] penLocationOne, EditText[] penLocationTwo, int dongSize){
        String[] penLocation = new String[dongSize];
        for(int i = 0 ; i < dongSize ; i++){
            penLocation[i] = penLocationOne[i].getText() + "-" + penLocationTwo[i].getText();
        }
        return penLocation;
    }
    public int[] getIntEditTextValues(EditText[] editTexts, int dongSize){
        int[] newIntArr = new int[dongSize];
        for(int i = 0 ; i < dongSize ; i++){
            newIntArr[i] = Integer.parseInt(String.valueOf(editTexts[i].getText()));
        }
        return newIntArr;
    }

    public void penQuestionAfterTextChanged(EditText questionEd, TextView questionTv,
                                            TextView sampleSizeTv,EditText locationOneEd, EditText locationTwoEd,
                                            PenQuestion penQuestion){
        if(TextUtils.isEmpty(questionEd.getText().toString())){
            questionTv.setText("값을 입력하세요");
            penQuestion.setRatio(-1);
            penQuestion.setNumberOfCow(-1);
            penQuestion.setScore(-1);
        } else if(getRatio(questionEd) > 100) {
            penQuestion.setRatio(-1);
            questionTv.setText("표본 규모보다 큰 값 입력 불가");
            penQuestion.setNumberOfCow(-1);
            penQuestion.setScore(-1);
            sampleSizeTv.setVisibility(View.VISIBLE);
            sampleSizeTv.setText("표본 규모 : " + String.valueOf(getSampleCowSize()));
        } else {
            penQuestion.setPenLocation(
                    makePenLocation(locationOneEd,locationTwoEd)
            );
            penQuestion.setRatio(getRatio(questionEd));

            penQuestion.setNumberOfCow(Integer.parseInt(String.valueOf(questionEd.getText())));
            questionTv.setText(String.valueOf(getRatio(questionEd)));
        }
    }
    public boolean isBeef(int farmType){
        if(farmType == 1 || farmType == 2 || farmType == 3){
            return true;
        } 
        return false;
    }
    public void setWaterTankForm(String waterTankForm){
        this.waterTankForm = waterTankForm;
    }
    public String getWaterTankForm(){
        return this.waterTankForm;
    }
}


