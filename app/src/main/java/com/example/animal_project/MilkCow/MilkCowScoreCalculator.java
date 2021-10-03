package com.example.animal_project.MilkCow;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

public class MilkCowScoreCalculator {
    public double calculatorProtocolTwoScore(double restScore, double totalWarmVentilatingScore, double movementStabilityScore){
        double protocolTwoScore = 0;
        protocolTwoScore = (restScore * 0.4) + (totalWarmVentilatingScore * 0.3) + (movementStabilityScore * 0.3);
        return Math.round(protocolTwoScore);
    }
    public int calculatorAppearanceQ1Score(float appearanceQ1Ratio) {
        int free_stall_back_score = 0;
        if (appearanceQ1Ratio <= 10) {
            free_stall_back_score = 100;
        } else if (appearanceQ1Ratio <= 19) {
            free_stall_back_score = 70;
        } else {
            free_stall_back_score = 40;
        }
        return free_stall_back_score;
    }

    public int calculatorAppearanceQ2Score(float appearanceQ2Ratio) {
        int free_stall_back_score = 0;
        if (appearanceQ2Ratio <= 10) {
            free_stall_back_score = 100;
        } else if (appearanceQ2Ratio <= 19) {
            free_stall_back_score = 70;
        } else {
            free_stall_back_score = 40;
        }
        return free_stall_back_score;
    }

    public int calculatorAppearanceQ3Score(float appearanceQ3Ratio) {
        int free_stall_breast_score = 0;
        if (appearanceQ3Ratio <= 10) {
            free_stall_breast_score = 100;
        } else if (appearanceQ3Ratio <= 19) {
            free_stall_breast_score = 70;
        } else {
            free_stall_breast_score = 40;
        }
        return free_stall_breast_score;
    }
    // ap == appearance
    public float calculatorRestScore(float sitTimeScore, float apBottomRegScore,
                                            float apBack, float apBreast){
        return (float) (sitTimeScore * 0.3 + apBottomRegScore * 0.15 + apBack * 0.20 + apBreast * 0.35);
    }
    public float calculatorFreeStallRestScore(
            float freeStallCountScore, float sitCollisionScore, float areaOutCollisionScore, float sitTimeScore,
            float appearanceBackRegScore, float appearanceBackScore, float appearanceBreastScore
    ){
        return (float) ((freeStallCountScore * 0.15) + (sitCollisionScore * 0.1) + (areaOutCollisionScore * 0.1) +
                (sitTimeScore * 0.25) + (appearanceBackRegScore * 0.15) + (appearanceBackScore * 0.1) + (appearanceBreastScore * 0.15));
    }

    public float calculatorTotalLimpRatio(float limp, float criticalLimp){
        return (float) (((limp + 3.45) * criticalLimp) / 3.45);

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
    public Map calculatorDiseaseSectionSix(float hardBirth)
    {
        Map <String, Integer> sectionScores = new HashMap<String, Integer>();
        sectionScores.put("care",0);
        sectionScores.put("warning",0);
        // 난산 상태 좋음 => "0"
        if(hardBirth < 2.75) {
            return sectionScores;
        }
        // 난산(주의) => "주의"
        else if(hardBirth < 5.5) {
            sectionScores.put("care",1);
        }
        // 난산(경보) => "경보"
        else if(5.5 <= hardBirth) {
            sectionScores.put("warning",1);
        }
        return sectionScores;
    }
    public Map calculatorDiseaseSectionSeven(float unableStand)
    {
        Map <String, Integer> sectionScores = new HashMap<String, Integer>();
        sectionScores.put("care",0);
        sectionScores.put("warning",0);
        // 기립불능 상태 좋음 => "0"
        if(unableStand < 2.75) {
            return sectionScores;
        }
        // 기립불능(주의) => "주의"
        else if(unableStand < 5.5) {
            sectionScores.put("care",1);
        }
        // 기립불능(경보) => "경보"
        else if(5.5 <= unableStand) {
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
        float careScore = (int)careWarningScore.get("care");
        float warningScore = (int)careWarningScore.get("warning");

        diseaseScore = ((float)(100)/(float)8) * (8 - ((careScore) + 3 * (warningScore)) / 3);


        return Math.round(diseaseScore);
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

}
