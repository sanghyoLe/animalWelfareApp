package com.example.animal_project;

import android.util.Log;
import android.widget.EditText;

import androidx.lifecycle.ViewModel;

import java.util.HashMap;
import java.util.Map;

public class MilkCowViewModel extends ViewModel {
    private int totalCowSize = 0;
    private int areaOutCollision = -1;
    private int appearance_Q1 = -1;
    private int appearance_Q2 = -1;
    private int appearance_Q3 = -1;
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

    public void setAreaOutCollision(int areaOutCollision) {
        this.areaOutCollision = areaOutCollision;
    }

    public int getareaOutCollision() {
        return this.areaOutCollision;
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
