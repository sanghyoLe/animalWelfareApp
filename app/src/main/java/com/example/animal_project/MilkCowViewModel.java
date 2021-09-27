package com.example.animal_project;

import androidx.lifecycle.ViewModel;

import java.util.HashMap;
import java.util.Map;

public class MilkCowViewModel extends ViewModel {
    private int totalCowSize = 0;
    private int sitCollision = -1;
    private int sitCollisionScore = -1;
    private int areaOutCollision = -1;
    private int sitTimeScore = -1;
    private double countRatio = -1;
    private int countScore = -1;
    private int appearance_Q1 = -1;
    private int appearance_Q2 = -1;
    private int appearance_Q3 = -1;
    private double freestallRestScore = -1;
    private double restScore = -1;
    private float slightLimp = -1;
    private float criticalLimp = -1;
    private int LimpScore = -1;
    private float slightHairLoss = -1;
    private float criticalHairLoss = -1;
    private int hairLossScore = -1;
    private long minInjuryScore = -1;
    private float runnyNoseRatio = -1;
    private float ophthalmicRatio = -1;
    private float respiratoryRatio = -1;
    private float diarrheaRatio = -1;
    private float outGenitalsRatio = -1;
    private float breastRatio = -1;
    private float fallDeadRatio = -1;
    private float dystociaRatio = -1;
    private float astasiaRatio = -1;
    private double diseaseScore = -1;
    private double minPainScore = -1;
    private double struggle = -1;
    private int socialBehaviorScore = -1;
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
    public void setTotalCowSize(int totalCowSize) {
        this.totalCowSize = totalCowSize;
    }

    public int getTotalCowSize() {
        return this.totalCowSize;
    }
    public void setCountRatio(double countRatio) {
        this.countRatio = countRatio;
    }

    public double getCountRatio() {
        return this.countRatio;
    }
    public void setCountScore(int countScore) {
        this.countScore = countScore;
    }

    public int getCountScore() {
        return this.countScore;
    }
    public void setSitCollision(int sitCollision) {
        this.sitCollision = sitCollision;
    }

    public int getSitCollision() {
        return this.sitCollision;
    }
    public void setSitCollisionScore(int sitCollisionScore) {
        this.sitCollisionScore = sitCollisionScore;
    }

    public int getSitCollisionScore() {
        return this.sitCollisionScore;
    }
    public void setAreaOutCollision(int areaOutCollision) {
        this.areaOutCollision = areaOutCollision;
    }

    public int getAreaOutCollision() {
        return this.areaOutCollision;
    }
    public void setSitTimeScore(int sitTimeScore) {
        this.sitTimeScore = sitTimeScore;
    }

    public int getSitTimeScore() {
        return this.sitTimeScore;
    }

    public void setAppearanceQ1Score(int appearance_Q1) {
        this.appearance_Q1 = appearance_Q1;
    }

    public int getAppearanceQ1Score() {
        return this.appearance_Q1;
    }

    public void setAppearanceQ2Score(int appearance_Q2) {
        this.appearance_Q2 = appearance_Q2;
    }

    public int getAppearanceQ2Score() {
        return this.appearance_Q2;
    }

    public void setAppearanceQ3Score(int appearance_Q3) {
        this.appearance_Q3 = appearance_Q3;
    }

    public int getAppearanceQ3Score() {
        return this.appearance_Q3;
    }
    public void setFreestallRestScore(double freestallRestScore) {
        this.freestallRestScore = freestallRestScore;
    }

    public double getFreestallRestScore() {
        return this.freestallRestScore;
    }
    public void setRestScore(double restScore) {
        this.restScore = restScore;
    }

    public double getRestScore() {
        return this.restScore;
    }

    public void setSlightLimp(float slightLimp) {
        this.slightLimp = slightLimp;
    }

    public float getSlightLimp() {
        return this.slightLimp;
    }

    public void setCriticalLimp(float criticalLimp) {
        this.criticalLimp = criticalLimp;
    }

    public float getCriticalLimp() {
        return this.criticalLimp;
    }

    public void setLimpScore(int LimpScore) {
        this.LimpScore = LimpScore;
    }

    public int getLimpScore() {
        return this.LimpScore;
    }

    public void setSlightHairLoss(float slightHairLoss) {
        this.slightHairLoss = slightHairLoss;
    }

    public float getSlightHairLoss() {
        return this.slightHairLoss;
    }

    public void setCriticalHairLoss(float criticalHairLoss) {
        this.criticalHairLoss = criticalHairLoss;
    }

    public float getCriticalHairLoss() {
        return this.criticalHairLoss;
    }

    public void setHairLossScore(int hairLossScore) {
        this.hairLossScore = hairLossScore;
    }

    public int getHairLossScore() {
        return this.hairLossScore;
    }

    public void setMinInjuryScore(long minInjuryScore) {
        this.minInjuryScore = minInjuryScore;
    }

    public long getMinInjuryScore() {
        return this.minInjuryScore;
    }
    public void setRunnyNoseRatio(float runnyNoseRatio) {
        this.runnyNoseRatio = runnyNoseRatio;
    }

    public float getRunnyNoseRatio() {
        return this.runnyNoseRatio;
    }

    public void setOphthalmicRatio(float ophthalmicRatio) {
        this.ophthalmicRatio = ophthalmicRatio;
    }

    public float getOphthalmicRatio() {
        return this.ophthalmicRatio;
    }

    public void setRespiratoryRatio(float respiratoryRatio) {
        this.respiratoryRatio = respiratoryRatio;
    }


    public float getRespiratoryRatio() {
        return this.respiratoryRatio;
    }

    public void setDiarrheaRatio(float diarrheaRatio) {
        this.diarrheaRatio = diarrheaRatio;
    }

    public float getDiarrheaRatio() {
        return this.diarrheaRatio;
    }

    public void setOutGenitalsRatio(float outGenitalsRatio) {
        this.outGenitalsRatio = outGenitalsRatio;
    }

    public float getOutGenitalsRatio() {
        return this.outGenitalsRatio;
    }

    public void setBreastRatio(float breastRatio) {
        this.breastRatio = breastRatio;
    }

    public float getBreastRatio() {
        return this.breastRatio;
    }

    public void setFallDeadRatio(float fallDeadRatio) {
        this.fallDeadRatio = fallDeadRatio;
    }

    public float getFallDeadRatio() {
        return this.fallDeadRatio;
    }

    public void setDystociaRatio(float dystociaRatio) {
        this.dystociaRatio = dystociaRatio;
    }

    public float getDystociaRatio() {
        return this.dystociaRatio;
    }

    public void setAstasiaRatio(float astasiaRatio) {
        this.astasiaRatio = astasiaRatio;
    }

    public float getAstasiaRatio() {
        return this.astasiaRatio;
    }
    public void setDiseaseScore(double diseaseScore){
        this.diseaseScore = diseaseScore;
    }
    public double getDiseaseScore(){
        return this.diseaseScore;
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

    public int calculatorSitCollisionScore(float sitCollisionRatio) {
        int sitCollisionScore = 0;
        if (sitCollisionRatio >= 31) {
            sitCollisionScore = 40;
        } else if (sitCollisionRatio >= 21) {
            sitCollisionScore = 70;
        } else
            sitCollisionScore = 100;
        return sitCollisionScore;
    }

    public int calculatorAreaOutCollisionScore(float areaOutCollisionRatio) {
        int outAreaSittingScore = 0;
        if (areaOutCollisionRatio >= 6) {
            outAreaSittingScore = 40;
        } else if (areaOutCollisionRatio >= 4) {
            outAreaSittingScore = 70;
        } else
            outAreaSittingScore = 100;
        return outAreaSittingScore;
    }

    public int calculatorSitTimeScore(float sitTimeAvg) {
        int sitTimeScore = 0;
        if(sitTimeAvg < 5.2) {
            sitTimeScore = 100;
        } else if(sitTimeAvg <= 6.3) {
            sitTimeScore = 70;
        } else {
            sitTimeScore = 40;
        }
        return sitTimeScore;
    }

    public int calculatorAppearanceQ1Score(float appearanceQ1Ratio) {
        int freestall_back_score = 0;
        if (appearanceQ1Ratio <= 10) {
            freestall_back_score = 100;
        } else if (appearanceQ1Ratio <= 19) {
            freestall_back_score = 70;
        } else {
            freestall_back_score = 40;
        }
        return freestall_back_score;
    }

    public int calculatorAppearanceQ2Score(float appearanceQ2Ratio) {
        int freestall_back_score = 0;
        if (appearanceQ2Ratio <= 10) {
            freestall_back_score = 100;
        } else if (appearanceQ2Ratio <= 19) {
            freestall_back_score = 70;
        } else {
            freestall_back_score = 40;
        }
        return freestall_back_score;
    }

    public int calculatorAppearanceQ3Score(float appearanceQ3Ratio) {
        int freestall_breast_score = 0;
        if (appearanceQ3Ratio <= 10) {
            freestall_breast_score = 100;
        } else if (appearanceQ3Ratio <= 19) {
            freestall_breast_score = 70;
        } else {
            freestall_breast_score = 40;
        }
        return freestall_breast_score;
    }

    public int calculatorLimpScore(double limpTotalRatio) {
        int limpScore = 0;
        if (limpTotalRatio >= 49) {
            limpScore = 0;
        } else if (limpTotalRatio >= 32) {
            limpScore = 10;
        } else if (limpTotalRatio >= 21) {
            limpScore = 20;
        } else if (limpTotalRatio >= 14) {
            limpScore = 30;
        } else if (limpTotalRatio >= 11) {
            limpScore = 40;
        } else if (limpTotalRatio >= 8) {
            limpScore = 50;
        } else if (limpTotalRatio >= 6) {
            limpScore = 60;
        } else if (limpTotalRatio >= 4) {
            limpScore = 70;
        } else if (limpTotalRatio >= 1.6) {
            limpScore = 80;
        } else if (limpTotalRatio >= 0.1) {
            limpScore = 90;
        } else
            limpScore = 100;
        return limpScore;
    }

    public int calculatorHairLossScore(double hairLossTotalRatio) {
        int hairlossScore = 0;
        if (hairLossTotalRatio >= 73) {
            hairlossScore = 0;
        } else if (hairLossTotalRatio >= 53) {
            hairlossScore = 10;
        } else if (hairLossTotalRatio >= 41) {
            hairlossScore = 20;
        } else if (hairLossTotalRatio >= 32) {
            hairlossScore = 30;
        } else if (hairLossTotalRatio >= 25) {
            hairlossScore = 40;
        } else if (hairLossTotalRatio >= 19) {
            hairlossScore = 50;
        } else if (hairLossTotalRatio >= 14) {
            hairlossScore = 60;
        } else if (hairLossTotalRatio >= 9) {
            hairlossScore = 70;
        } else if (hairLossTotalRatio >= 5) {
            hairlossScore = 80;
        } else if (hairLossTotalRatio >= 1) {
            hairlossScore = 90;
        } else
            hairlossScore = 10;
        return hairlossScore;
    }

    public long calculatorFrestallMinInjuryScore(int limpScore, int hairLossScore) {
        long minInjuryScore = 0;
        minInjuryScore = Math.round((limpScore * 0.5) + (hairLossScore * 0.5));
        minInjuryScore = Math.round(minInjuryScore);

        return minInjuryScore;
    }

    public Map calculatorDiseaseSectionOne(float runnyNose, float ophthalmic) {
        Map<String, Integer> sectionScores = new HashMap<String, Integer>();
        sectionScores.put("care", 0);
        sectionScores.put("warning", 0);
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
    public Map calculatorDiseaseSectionTwo(double cough,float respiratory)
    {
        Map <String, Integer> sectionScores = new HashMap<String, Integer>();
        sectionScores.put("care",0);
        sectionScores.put("warning",0);

        // 기침 상태 좋음, 호흡장애 상태 좋음 => "0"
        if(cough < 3 && respiratory < 3.25) {
            return sectionScores;
        }
        // 기침 상태 좋음, 호흡장애(주의) => "주의"
        else if(cough < 3 && 3.25 <= respiratory && respiratory < 6.5) {
            sectionScores.put("care",1);
        }
        // 기침(주의), 호흡장애 상태 좋음 => "주의"
        else if(3 <= cough && cough < 6 && respiratory < 3.25) {
            sectionScores.put("care",1);
        }
        // 기침(주의), 호흡장애(주의) => "주의"
        else if(3 <= cough && cough < 6 && 3.25 <= respiratory && respiratory < 6.5) {
            sectionScores.put("care",1);
        }
        // 기침, 호흡장애 중 1개라도 "경보" =>
        else if(6 <= cough || 6.5 <= respiratory) {
            sectionScores.put("warning",1);
        }
        return sectionScores;
    }
    public Map calculatorDiseaseSectionThree(float diarrhea)
    {
        Map <String, Integer> sectionScores = new HashMap<String, Integer>();
        sectionScores.put("care",0);
        sectionScores.put("warning",0);
        //설사 상태 좋음 => "0"
        if(diarrhea < 3.25) {
            return sectionScores;
        }
        //설사(주의) => "주의"
        else if(diarrhea < 6.5) {
            sectionScores.put("care",1);
        }
        //설사(경보) => "경보"
        else if(6.5 <= diarrhea) {
            sectionScores.put("warning",1);
        }
        return sectionScores;
    }
    public Map calculatorDiseaseSectionFour(float breast)
    {
        Map <String, Integer> sectionScores = new HashMap<String, Integer>();
        sectionScores.put("care",0);
        sectionScores.put("warning",0);
        // 유방염 상태 좋음 => "0"
        if(breast < 8.75) {
            return sectionScores;
        }
        // 유방염(주의) => "주의"
        else if(breast < 17.5) {
            sectionScores.put("care",1);
        }
        // 유방염(경보) => "경보"
        else if(17.5 <= breast) {
            sectionScores.put("warning",1);
        }
        return sectionScores;
    }
    public Map calculatorDiseaseSectionFive(float outGenitals)
    {
        Map <String, Integer> sectionScores = new HashMap<String, Integer>();
        sectionScores.put("care",0);
        sectionScores.put("warning",0);
        // 외음부분비물 상태 좋음 => "0"
        if(outGenitals < 2.25) {
            return sectionScores;
        }
        // 외음부분비물(주의) => "주의"
        else if(outGenitals < 4.5) {
            sectionScores.put("care",1);
        }
        // 외음부분비물(경보) => "경보"
        else if(4.5 <= outGenitals) {
            sectionScores.put("warning",1);
        }
        return sectionScores;
    }
    public Map calculatorDiseaseSectionSix(float dystocia)
    {
        Map <String, Integer> sectionScores = new HashMap<String, Integer>();
        sectionScores.put("care",0);
        sectionScores.put("warning",0);
        // 난산 상태 좋음 => "0"
        if(dystocia < 2.75) {
            return sectionScores;
        }
        // 난산(주의) => "주의"
        else if(dystocia < 5.5) {
            sectionScores.put("care",1);
        }
        // 난산(경보) => "경보"
        else if(5.5 <= dystocia) {
            sectionScores.put("warning",1);
        }
        return sectionScores;
    }
    public Map calculatorDiseaseSectionSeven(float astasia)
    {
        Map <String, Integer> sectionScores = new HashMap<String, Integer>();
        sectionScores.put("care",0);
        sectionScores.put("warning",0);
        // 기립불능 상태 좋음 => "0"
        if(astasia < 2.75) {
            return sectionScores;
        }
        // 기립불능(주의) => "주의"
        else if(astasia < 5.5) {
            sectionScores.put("care",1);
        }
        // 기립불능(경보) => "경보"
        else if(5.5 <= astasia) {
            sectionScores.put("warning",1);
        }
        return sectionScores;
    }
    public Map calculatorDiseaseSectionEight(float fallDead)
    {
        Map <String, Integer> sectionScores = new HashMap<String, Integer>();
        sectionScores.put("care",0);
        sectionScores.put("warning",0);
        // 폐사율 상태 좋음 => "0"
        if(fallDead < 2.25) {
            return sectionScores;
        }
        // 폐사율(주의) => "주의"
        else if(fallDead < 4.5) {
            sectionScores.put("care",1);
        }
        // 폐사율(경보) => "경보"
        else if(4.5 <= fallDead) {
            sectionScores.put("warning",1);
        }
        return sectionScores;
    }
    public Map calculatorCareWarningScore(Map sectionOneScore, Map sectionTwoScore, Map sectionThreeScore, Map sectionFourScore,
                                          Map sectionFiveScore, Map sectionSixScore, Map sectionSevenScore, Map sectionEightScore)
    {
        Map <String, Integer> careWarningScore = new HashMap<String, Integer>();
        int totalCareScore = (int) sectionOneScore.get("care")
                + (int) sectionTwoScore.get("care")
                + (int) sectionThreeScore.get("care")
                + (int) sectionFourScore.get("care")
                + (int) sectionFiveScore.get("care")
                + (int) sectionSixScore.get("care")
                + (int) sectionSevenScore.get("care")
                + (int) sectionEightScore.get("care");
        careWarningScore.put("care",totalCareScore);
        int totalWarningScore = (int) sectionOneScore.get("warning")
                + (int) sectionTwoScore.get("warning")
                + (int) sectionThreeScore.get("warning")
                + (int) sectionFourScore.get("warning")
                + (int) sectionFiveScore.get("warning")
                + (int) sectionSixScore.get("warning")
                + (int) sectionSevenScore.get("warning")
                + (int) sectionEightScore.get("warning");
        careWarningScore.put("warning",totalWarningScore);

        return careWarningScore;
    }
    public double calculatorDiseaseScore(Map careWarningScore)
    {
        float diseaseScore = 0;
        int careScore = (int)careWarningScore.get("care");
        int warningScore = (int)careWarningScore.get("warning");
        diseaseScore = (100 / 8) * (8 - ((careScore) + 3 * (warningScore)) / 3);

        return Math.round(diseaseScore);
    }
    public double calculatorMinPainScore(int hornRemovalScore){
        return hornRemovalScore;
    }
    public int calculatorSocialBehaviorScore(double struggle)
    {
        int socialBehaviorScore = 0;
        if (struggle > 100) {
            return socialBehaviorScore = -1;
        }
        if(struggle == 0) {
            socialBehaviorScore = 100;
        } else if(struggle <= 4 ) {
            socialBehaviorScore = 90;
        } else if(struggle <= 9 ) {
            socialBehaviorScore = 80;
        } else if(struggle <= 14 ) {
            socialBehaviorScore = 70;
        } else if(struggle <= 19 ) {
            socialBehaviorScore = 60;
        } else if(struggle <= 25 ) {
            socialBehaviorScore = 50;
        } else if(struggle <= 32 ) {
            socialBehaviorScore = 40;
        } else if(struggle <= 41 ) {
            socialBehaviorScore = 30;
        } else if(struggle <= 53 ) {
            socialBehaviorScore = 20;
        } else if(struggle <= 71 ) {
            socialBehaviorScore = 10;
        } else if(struggle <= 100 ) {
            socialBehaviorScore = 0;
        }
        return socialBehaviorScore;
    }
    public int calculatorAvoidDistanceScore(double avoidDistanceRatio){
        int avoidDistanceScore = 0;
        if(avoidDistanceRatio == 0){
            avoidDistanceScore = 100;
        } else if(avoidDistanceRatio <= 2){
            avoidDistanceScore = 95;
        }else if(avoidDistanceRatio <= 5){
            avoidDistanceScore = 90;
        }else if(avoidDistanceRatio <= 7){
            avoidDistanceScore = 85;
        }else if(avoidDistanceRatio <= 9){
            avoidDistanceScore = 80;
        }else if(avoidDistanceRatio <= 11){
            avoidDistanceScore = 75;
        }else if(avoidDistanceRatio <= 14){
            avoidDistanceScore = 70;
        }else if(avoidDistanceRatio <= 17){
            avoidDistanceScore = 65;
        }else if(avoidDistanceRatio <= 19){
            avoidDistanceScore = 60;
        }else if(avoidDistanceRatio <= 22){
            avoidDistanceScore = 55;
        }else if(avoidDistanceRatio <= 25){
            avoidDistanceScore = 50;
        }else if(avoidDistanceRatio <= 28){
            avoidDistanceScore = 45;
        }else if(avoidDistanceRatio <= 32){
            avoidDistanceScore = 40;
        }else if(avoidDistanceRatio <= 36){
            avoidDistanceScore = 35;
        } else if(avoidDistanceRatio <= 41){
            avoidDistanceScore = 30;
        }else if(avoidDistanceRatio <= 46){
            avoidDistanceScore = 25;
        }else if(avoidDistanceRatio <= 52){
            avoidDistanceScore = 20;
        }else if(avoidDistanceRatio <= 60){
            avoidDistanceScore = 15;
        }else if(avoidDistanceRatio <= 71){
            avoidDistanceScore = 10;
        }else if(avoidDistanceRatio <= 86){
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
        avoidDistanceRatio = (3 * levelTwoRatio + (11 * levelThreeRatio)  + (26 * levelFourRatio));
        avoidDistanceRatio = avoidDistanceRatio / 26;
        avoidDistanceRatio = Math.round(avoidDistanceRatio);
        return avoidDistanceRatio;
    }
    public double calculatorProtocolOneScore(double PoorScore, double WaterScore){
        return Math.round((PoorScore * 0.65) + (WaterScore * 0.35));
    }
    public double calculatorProtocolTwoScore(double restScore, double totalWarmVentilatingScore){
        return Math.round((restScore * 0.6) + (totalWarmVentilatingScore * 0.4));
    }
    public double calculatorProtocolThreeScore(double minInjuryScore, double minPainScore, double diseaseScore){
        return Math.round((minInjuryScore * 0.3) + (diseaseScore * 0.5) + (minPainScore * 0.2));
    }
    public double calculatorProtocolFourScore(double socialBehaviorScore, double avoidDistanceScore){
        return Math.round((socialBehaviorScore * 0.55) + (avoidDistanceScore * 0.45));
    }
    public double calculatorFreestallRestScore(int sitActionScore, int sitCollisionScore, int areaOutCollisionScore, int sitTimeScore, int appearanceOneScore, int appearanceTwoScore, int appearanceThreeScore)
    {
        return (sitActionScore * 0.15) + (sitCollisionScore * 0.1) + (areaOutCollisionScore * 0.1) + (sitTimeScore * 0.25) + (appearanceOneScore * 0.15) + (appearanceTwoScore * 0.1) + (appearanceThreeScore * 0.15);
    }
    public double calculatorRestScore(int sitTimeScore, int appearanceOneScore, int appearanceTwoScore, int appearanceThreeScore)
    {
        return (sitTimeScore * 0.6) + (appearanceOneScore * 0.15) + (appearanceTwoScore * 0.1) + (appearanceThreeScore * 0.15);
    }
    public double calculatorTotalWarmVentilationScore(int freestallSummerScore, int freestallWinterScore, int freestallCalfSummerScore, int freestallCalfWinterScore) {

        double warmVenScore = (freestallSummerScore * 0.4) + (freestallWinterScore * 0.2) + (freestallCalfSummerScore * 0.2) + (freestallCalfWinterScore * 0.2);

        return warmVenScore;
    }
}
