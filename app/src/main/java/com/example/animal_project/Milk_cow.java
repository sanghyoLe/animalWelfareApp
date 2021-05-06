package com.example.animal_project;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Milk_cow extends AppCompatActivity {
    public static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
    }
    //표본 마릿 수 계산
    public static String getPoorRateRatio(String total, String rate){
        Float totalFloat = Float.parseFloat(total);
        Float rateFloat = Float.parseFloat(rate);
        double result = ((rateFloat / totalFloat) * 100);
        return String.format("%.2f",result);
    }

    //여윈 개체 비율 계산
    public static String getPoorRateScore(String ratio){
        Float RatioFloat = Float.parseFloat(ratio);
        int poorScore = 0;
        if (RatioFloat == 0) {
            poorScore = 100;
        } else if (RatioFloat < 1) {
            poorScore = 90;
        } else if (RatioFloat < 2) {
            poorScore = 80;
        } else if (RatioFloat < 3) {
            poorScore = 70;
        } else if (RatioFloat < 4) {
            poorScore = 60;
        } else if (RatioFloat < 5) {
            poorScore = 50;
        } else if (RatioFloat < 6) {
            poorScore = 40;
        } else if (RatioFloat <= 7) {
            poorScore = 30;
        } else if (RatioFloat <= 9) {
            poorScore = 20;
        } else if (RatioFloat < 11) {
            poorScore = 10;
        } else  poorScore = 0;

        return Integer.toString(poorScore);
    }

    //음수조 계산
    //프로토콜 수정으로 구현되지 않음

    //프로토콜1 계산(음수조 계산이 구현되지 않음)

    // 편한 축사 환경
    // 편안한 축사 환경(프리스톨만)
    public static double getFreeStallScore(double freestallNum, double sitCollision, double freestallAreaOutCollision, double sitActionTime, double outwardHygieneLeg, double outwardHygieneBack, double outwardHygieneBreast) {

        double freestallNumScore = 0, sitCollisionScore = 0, freestallAreaOutCollisionScore = 0,
                sitActionTimeScore = 0, outwardHygieneLegScore = 0, outwardHygieneBackScore = 0, outwardHygieneBreastScore = 0;
        double freeStallActionScore;
        // 프리스톨 수 점수 계산
        if (freestallNum == 1) {
            freestallNumScore = 100;
        }
        else if (freestallNum == 2) {
            freestallNumScore = 70;
        }
        else {
            freestallNumScore = 40;
        }

        // 앉기 시 충돌 계산
        if (sitCollision == 1) {
            sitCollisionScore = 100;
        }
        else if (sitCollision == 2) {
            sitCollisionScore = 70;
        }
        else {
            sitCollisionScore = 40;
        }

        // 프리스톨 영역 외 앉기
        if (freestallAreaOutCollision == 1) {
            freestallAreaOutCollisionScore = 100;
        }
        else if (freestallAreaOutCollision == 2) {
            freestallAreaOutCollisionScore = 70;
        }
        else {
            freestallAreaOutCollisionScore = 40;
        }

        // 앉기동작 소요시간
        if (sitActionTime == 1) {
            sitActionTimeScore = 100;
        }
        else if (sitActionTime == 2) {
            sitActionTimeScore = 70;
        }
        else {
            sitActionTimeScore = 40;
        }

        // 가축외형(뒤쪽 아랫다리) 위생
        if (outwardHygieneLeg == 1) {
            outwardHygieneLegScore = 100;
        }
        else if (outwardHygieneLeg == 2) {
            outwardHygieneLegScore = 70;
        }
        else {
            outwardHygieneLegScore = 40;
        }

        // 가축외형(뒷부분) 위생
        if (outwardHygieneBack == 1) {
            outwardHygieneBackScore = 100;
        }
        else if (outwardHygieneBack == 2) {
            outwardHygieneBackScore = 70;
        }
        else {
            outwardHygieneBackScore = 40;
        }

        // 가축외형(유방) 위생
        if (outwardHygieneBreast == 1) {
            outwardHygieneBreastScore = 100;
        }
        else if (outwardHygieneBreast == 2) {
            outwardHygieneBreastScore = 70;
        }
        else {
            outwardHygieneBreastScore = 40;
        }

        freeStallActionScore = (freestallNumScore * 0.15) + (sitCollisionScore * 0.10) + (freestallAreaOutCollisionScore * 0.10) +
                (sitActionTimeScore * 0.25) + (outwardHygieneLegScore * 0.15) + (outwardHygieneBackScore * 0.10) + (outwardHygieneBreastScore * 0.15);
        return freeStallActionScore;
    }

    // 편안한 축사 환경(일반 우사)
    public static double getNormalRestScore(double sitActionTime, double outwardHygieneLeg, double outwardHygieneBack, double outwardHygieneBreast) {

        double sitActionTimeScore = 0, outwardHygieneLegScore = 0, outwardHygieneBackScore = 0, outwardHygieneBreastScore = 0;
        double normalActionScore;

        // 앉기동작 소요시간
        if (sitActionTime == 1) {
            sitActionTimeScore = 100;
        }
        else if (sitActionTime == 2) {
            sitActionTimeScore = 70;
        }
        else {
            sitActionTimeScore = 40;
        }

        // 가축외형(뒤쪽 아랫다리) 위생
        if (outwardHygieneLeg == 1) {
            outwardHygieneLegScore = 100;
        }
        else if (outwardHygieneLeg == 2) {
            outwardHygieneLegScore = 70;
        }
        else {
            outwardHygieneLegScore = 40;
        }

        // 가축외형(뒷부분) 위생
        if (outwardHygieneBack == 1) {
            outwardHygieneBackScore = 100;
        }
        else if (outwardHygieneBack == 2) {
            outwardHygieneBackScore = 70;
        }
        else {
            outwardHygieneBackScore = 40;
        }

        // 가축외형(유방) 위생
        if (outwardHygieneBreast == 1) {
            outwardHygieneBreastScore = 100;
        }
        else if (outwardHygieneBreast == 2) {
            outwardHygieneBreastScore = 70;
        }
        else {
            outwardHygieneBreastScore = 40;
        }

        normalActionScore = (sitActionTimeScore * 0.6) + (outwardHygieneLegScore * 0.15) + (outwardHygieneBackScore * 0.10) + (outwardHygieneBreastScore * 0.15);
        return normalActionScore;
    }

    // 혹서기(성우, 송아지 둘 다 포함)
    public static int getSummerRestScore(int shade, int summerVentilating, int mistSpary)
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
            if(summerVentilating == 1){
                if(mistSpary == 1){
                    summerRestScore = 55;
                }else {
                    summerRestScore = 40;
                }
            } else {
                if(mistSpary == 1) {
                    summerRestScore = 20;
                }else {
                    summerRestScore = 0;
                }
            }
        }
        return summerRestScore;
    }

    // 혹한기 (포유 송아지 제외: 성우만)
    public static int getWinterAdultRestScore(int windBlock, int winterVentilating)
    {
        int windRestScore = 0;
        // 바람차단시설 항목 "예"인 경우
        if(windBlock == 1){
            // 최소 풍속시설 항목 "예"인 경우
            if(winterVentilating == 1){
                windRestScore = 100;
            }else {
                windRestScore = 70;
            }
            // 바람차단시설 항목 "아니오 "인 경우
        } else {
            if(winterVentilating == 1) {
                windRestScore = 40;
            }else {
                windRestScore = 20;
            }
        }
        return windRestScore;
    }
    // 혹한기 (포유 송아지 전용)
    public static int getWinterChildRestScore(int straw, int warm, int windBlock)
    {
        int winterCalfRestScore = 0;
        // 충분한 깔짚 항목 "예"
        if(straw == 1){
            // 충분한 보온 항목 "예"
            if(warm == 1){
                // 바람 차단 시설 "예"
                if(windBlock == 1) {
                    winterCalfRestScore = 100;
                } else {
                    winterCalfRestScore = 80;
                }
            }
            // 충분한 보온 항목 "아니오"
            else {
                if(windBlock == 1) {
                    winterCalfRestScore = 60;
                } else {
                    winterCalfRestScore = 45;
                }
            }
        }
        // 충분한 깔짚 항목 "아니오"
        else {
            if(warm == 1){
                if(windBlock == 1){
                    winterCalfRestScore = 55;
                }else {
                    winterCalfRestScore = 40;
                }
            }else {
                if(windBlock == 1){
                    winterCalfRestScore = 20;
                }else {
                    winterCalfRestScore = 0;
                }
            }
        }
        return winterCalfRestScore;
    }

    //편안한 열환경과 환기(혹서기 + 혹한기) 점수 계산
    //성우 축사 점수 + 송아지 축사 점수
    //

    //프로토콜2 구현되지 않음

    // 상해의 최소화
    // 다리절음 점수 계산(경미한 다리절음, 심각한 다리절음)
    public static String getLimpScore(String slightLimp, String criticalLimp)
    {
        Double slightLimpDouble = Double.parseDouble(slightLimp);
        Double criticalLimpDouble = Double.parseDouble(criticalLimp);
        double totalLimp = (slightLimpDouble / 3.45 * criticalLimpDouble) / 3.45;
        int limpScore = 0;
        if (totalLimp == 0) {
            limpScore = 100;
        } else if (totalLimp <= 1.5) {
            limpScore = 90;
        } else if (totalLimp <= 3) {
            limpScore = 80;
        } else if (totalLimp <= 5) {
            limpScore = 70;
        } else if (totalLimp <= 7) {
            limpScore = 60;
        } else if (totalLimp <= 10) {
            limpScore = 50;
        } else if (totalLimp <= 13) {
            limpScore = 40;
        } else if (totalLimp <= 20) {
            limpScore = 30;
        } else if (totalLimp <= 31) {
            limpScore = 20;
        } else if (totalLimp <= 48) { // 젖소 48%, 한육우 49%
            limpScore = 10;
        } else {
            limpScore = 0;
        }
        return Integer.toString(limpScore);
    }

    // 외피 변형 계산(경미한 외피변형, 심각한 외피변형)
    public static String getHairlossScore(String slightHairloss, String criticalHairloss)
    {
        int slightHairlossInteger = Integer.parseInt(slightHairloss);
        int criticalHairlossInteger = Integer.parseInt(criticalHairloss);
        int totalHairlossScore = (slightHairlossInteger + 5 * criticalHairlossInteger) / 5;
        int hairlossScore = 0;
        if (totalHairlossScore == 0) {
            hairlossScore = 100;
        } else if (totalHairlossScore <= 4) {
            hairlossScore = 90;
        } else if (totalHairlossScore <= 8) {
            hairlossScore = 80;
        } else if (totalHairlossScore <= 13) {
            hairlossScore = 70;
        } else if (totalHairlossScore <= 18) {
            hairlossScore = 60;
        } else if (totalHairlossScore <= 24) {
            hairlossScore = 50;
        } else if (totalHairlossScore <= 31) {
            hairlossScore = 40;
        } else if (totalHairlossScore <= 40) {
            hairlossScore = 30;
        } else if (totalHairlossScore <= 52) {
            hairlossScore = 20;
        } else if (totalHairlossScore <= 72) {
            hairlossScore = 10;
        } else {
            hairlossScore = 0;
        }
        return Integer.toString(hairlossScore);
    }

    // 질병의 최소화
    // 질병 영역 1 계산(비강분비물, 안구분비물)
    public static int[] getDiseaseSectionOne(String runnyNose, String ophthalmicSecretion)
    {
        double runnyNoseDouble = Double.parseDouble(runnyNose);
        double ophthalmicSecretionDouble = Double.parseDouble(ophthalmicSecretion);
        int[] sectionOneScore = new int[2]; //care, warning
        // 비강분비물 상태 좋음, 안구분비물 상태 좋음 => "0"
        if (runnyNoseDouble < 5 && ophthalmicSecretionDouble < 3) {
            return sectionOneScore;
        }
        // 비강분비물 상태 좋음, 안구분비물(주의) => "주의"
        else if (runnyNoseDouble < 5 && 3 <= ophthalmicSecretionDouble && ophthalmicSecretionDouble < 6) {
            sectionOneScore[0] = sectionOneScore[0] + 1;
        }
        // 비강분비물(주의), 안구분비물 상태 좋음 => "주의"
        else if (5 <= runnyNoseDouble && runnyNoseDouble < 10 && ophthalmicSecretionDouble < 3) {
            sectionOneScore[0] = sectionOneScore[0] + 1;
        }
        // 비강분비물(주의), 안구분비물(주의) => "주의"
        else if (5 <= runnyNoseDouble && runnyNoseDouble < 10 && 3 <= ophthalmicSecretionDouble && ophthalmicSecretionDouble < 6) {
            sectionOneScore[0] = sectionOneScore[0] + 1;
        }
        // 비강, 안구분비물 중 1개라도 "경보" => "경보"
        else if (10 <= runnyNoseDouble || 6 <= ophthalmicSecretionDouble) {
            sectionOneScore[1] = sectionOneScore[1] + 1;
        }
        return sectionOneScore;
    }

    //질병 영역 2 계산(기침, 호흡장애)
    public static int[] getDiseaseSectionTwo(String cough, int numOfSample, String respiratoryFailure)
    {
        Double coughDouble = Double.parseDouble(cough);
        Double respiratoryFailureDouble = Double.parseDouble(respiratoryFailure);

        //영역 2 기침 측정 값 상세
        double diseaseTwoCough = (coughDouble / (double)numOfSample) * 100;

        int[] sectionTwoScore = new int[2]; //care, warning

        // 기침 상태 좋음, 호흡장애 상태 좋음 => "0"
        if(diseaseTwoCough < 3 && respiratoryFailureDouble < 3.25) {
            return sectionTwoScore;
        }
        // 기침 상태 좋음, 호흡장애(주의) => "주의"
        else if(diseaseTwoCough < 3 && 3.25 <= respiratoryFailureDouble && respiratoryFailureDouble < 6.5) {
            sectionTwoScore[0] = sectionTwoScore[0] + 1;
        }
        // 기침(주의), 호흡장애 상태 좋음 => "주의"
        else if(3 <= diseaseTwoCough && diseaseTwoCough < 6 && respiratoryFailureDouble < 3.25) {
            sectionTwoScore[0] = sectionTwoScore[0] + 1;
        }
        // 기침(주의), 호흡장애(주의) => "주의"
        else if(3 <= diseaseTwoCough && diseaseTwoCough < 6 && 3.25 <= respiratoryFailureDouble && respiratoryFailureDouble < 6.5) {
            sectionTwoScore[0] = sectionTwoScore[0] + 1;
        }
        // 기침, 호흡장애 중 1개라도 "경보" =>
        else if(6 <= diseaseTwoCough || 6.5 <= respiratoryFailureDouble) {
            sectionTwoScore[1] = sectionTwoScore[1] + 1;
        }

        return sectionTwoScore;
    }

    //질병 영역 3 계산(설사)
    public static int[] getDiseaseSectionThree(String diarrhea)
    {
        Double diarrheaDouble = Double.parseDouble(diarrhea);
        int[] sectionThreeScore = new int[2]; //care, warning
        //설사 상태 좋음 => "0"
        if(diarrheaDouble < 3.25) {
            return sectionThreeScore;
        }
        //설사(주의) => "주의"
        else if(diarrheaDouble < 6.5) {
            sectionThreeScore[0] = sectionThreeScore[0] + 1;
        }
        //설사(경보) => "경보"
        else if(6.5 <= diarrheaDouble) {
            sectionThreeScore[1] = sectionThreeScore[1] + 1;
        }
        return sectionThreeScore;
    }

    //질병 영역 4 계산(유방염)
    public static int[] getDiseaseSectionFour(String breastInflammation)
    {
        Double breastInflammationDouble = Double.parseDouble(breastInflammation);
        int[] sectionFourScore = new int[2]; //care, warning
        // 유방염 상태 좋음 => "0"
        if(breastInflammationDouble < 8.75) {
            return sectionFourScore;
        }
        // 유방염(주의) => "주의"
        else if(breastInflammationDouble < 17.5) {
            sectionFourScore[0] = sectionFourScore[0] + 1;
        }
        // 유방염(경보) => "경보"
        else if(17.5 <= breastInflammationDouble) {
            sectionFourScore[1] = sectionFourScore[1] + 1;
        }
        return sectionFourScore;
    }

    //질병 영역 5 계산(외음부분비물)
    public static int[] getDiseaseSectionFive(String outGenitalsSecretion)
    {
        Double outGenitalsSecretionDouble = Double.parseDouble(outGenitalsSecretion);
        int[] sectionFiveScore = new int[2]; //care, warning
        // 외음부분비물 상태 좋음 => "0"
        if(outGenitalsSecretionDouble < 2.25) {
            return sectionFiveScore;
        }
        // 외음부분비물(주의) => "주의"
        else if(outGenitalsSecretionDouble < 4.5) {
            sectionFiveScore[0] = sectionFiveScore[0] + 1;
        }
        // 외음부분비물(경보) => "경보"
        else if(4.5 <= outGenitalsSecretionDouble) {
            sectionFiveScore[1] = sectionFiveScore[1] + 1;
        }
        return sectionFiveScore;
    }

    //질병 영역 6 계산(난산)
    public static int[] getDiseaseSectionSix(String dystocia)
    {
        Double dystociaDouble = Double.parseDouble(dystocia);
        int[] sectionSixScore = new int[2]; //care, warning
        // 난산 상태 좋음 => "0"
        if(dystociaDouble < 2.75) {
            return sectionSixScore;
        }
        // 난산(주의) => "주의"
        else if(dystociaDouble < 5.5) {
            sectionSixScore[0] = sectionSixScore[0] + 1;
        }
        // 난산(경보) => "경보"
        else if(5.5 <= dystociaDouble) {
            sectionSixScore[1] = sectionSixScore[1] + 1;
        }
        return sectionSixScore;
    }

    //질병 영역 7 계산(기립불능)
    public static int[] getDiseaseSectionSeven(String astasia, int numOfTotal)
    {
        Double astasiaDouble = Double.parseDouble(astasia);

        // 영역 7 측정 값 상세
        double diseaseSenvenAstasia = (astasiaDouble / (double)numOfTotal) * 100;
        int[] sectionSevenScore = new int[2]; //care, warning
        // 기립불능 상태 좋음 => "0"
        if(diseaseSenvenAstasia < 2.75) {
            return sectionSevenScore;
        }
        // 기립불능(주의) => "주의"
        else if(diseaseSenvenAstasia < 5.5) {
            sectionSevenScore[0] = sectionSevenScore[0] + 1;
        }
        // 기립불능(경보) => "경보"
        else if(5.5 <= diseaseSenvenAstasia) {
            sectionSevenScore[1] = sectionSevenScore[1] + 1;
        }
        return sectionSevenScore;
    }

    //질병 영역 8 계산(폐사율)
    public static int[] getDiseaseSectionEight(String fallDead, int numOfTotal)
    {
        Double fallDeadDouble = Double.parseDouble(fallDead);

        // 영억 8 측정 값 상세
        double diseaseEightfallDead = (fallDeadDouble / (double)numOfTotal) * 100;
        int[] sectionEightScore = new int[2]; //care, warning
        // 폐사율(주의) => "주의"
        if (2.25 < diseaseEightfallDead && diseaseEightfallDead < 4.5) {
            sectionEightScore[0] = sectionEightScore[0] + 1;
        }
        // 폐사율(경보) => "경보"
        else if (4.5 <= diseaseEightfallDead) {
            sectionEightScore[1] = sectionEightScore[1] + 1;
        }
        return sectionEightScore;
    }

    //section 1,2,3,4,5,6,7,8의 care, warning 점수 합산
    public static int[] getCareWarningScore(int[] sectionOneScore, int[] sectionTwoScore, int[] sectionThreeScore, int[] sectionFourScore, int[] sectionFiveScore, int[] sectionSixScore, int[] sectionSevenScore, int[] sectionEightScore)
    {
        int[] careWarningScore = new int[2]; //care, warning
        // "주의" 합산(care)
        careWarningScore[0] = sectionOneScore[0] + sectionTwoScore[0] + sectionThreeScore[0] + sectionFourScore[0] + sectionFiveScore[0] + sectionSixScore[0] + sectionSevenScore[0] + sectionEightScore[0];

        // "경보" 합산(warning)
        careWarningScore[1] = sectionOneScore[1] + sectionTwoScore[1] + sectionThreeScore[1] + sectionFourScore[1] + sectionFiveScore[1] + sectionSixScore[1] + sectionSevenScore[1] + sectionEightScore[1];
        return careWarningScore;
    }

    //질병 종합 점수 계산
    public static String getDiseaseScore(int[] careWarningScore)
    {
        int care = careWarningScore[0];
        int warning = careWarningScore[1];
        int diseaseScore = (100 / 8) * (8 - (care + 3 * warning) / 3);
        String diseaseTotalScore = Integer.toString(diseaseScore);
        return diseaseTotalScore;
    }

    //해당관리로 인한 고통
    //제각 점수 계산
    public static int getHornRemovalScore(int horn, int hornAnesthesia, int hornPainkiller)
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
                    hornRemovalScore = 75; //마취, 진통 둘다
                } else {
                    hornRemovalScore = 52; //마취
                }
            }
            // 마취제 미사용
            else {
                if (hornPainkiller == 1) {
                    // 사후 진통제만 사용했을 경우 (누락 부분)
                    hornRemovalScore = 49; //사후 진통제
                }
                // 처치 없음
                else {
                    hornRemovalScore = 28; //처치 없음
                }
            }
        }
        // 송아지 제각 화학적 방식
        else if (horn == 3) {
            // 마취제 사용
            if (hornAnesthesia == 1) {
                // 사후진통제 사용
                if (hornPainkiller == 1) {
                    hornRemovalScore = 58; //마취, 진통 둘다
                } else {
                    hornRemovalScore = 39; //마취
                }
            }
            // 마취제 미사용
            else {
                // 사후 진통제만 사용했을 경우 (누락 부분)
                if (hornPainkiller == 1) {
                    hornRemovalScore = 41; //사후 진통제
                } else {
                    hornRemovalScore = 20; //처치 없음
                }
            }
        }
        // 성우 제각
        // 송아지는 사후진통제만 했을 때 점수가 마취제 점수보다 높은데 왜 성우는 더 높지 마취제가
        else {
            if (hornAnesthesia == 1) {
                if (hornPainkiller == 1) {
                    hornRemovalScore = 27; //마취, 진통 둘다
                } else {
                    hornRemovalScore = 17; //마취
                }
            } else {
                if (hornPainkiller == 1) {
                    hornRemovalScore = 16; //사후 진통제
                } else {
                    hornRemovalScore = 2; //처치 없음
                }
            }
        }
        return hornRemovalScore;
    }

    //적절한 행동(정신적 건강상태)
    //사회적 행동의 표현(투쟁행동)
    //투쟁 행동(머리박치기, 투쟁행동빈도(머리박치기 제외))
    public static String getStruggleScore(String headButt, String struggle)
    {
        Double headButtDouble = Double.parseDouble(headButt);
        Double struggleDouble = Double.parseDouble(struggle);

        // 사회적행동 지수
        double socialBehavior = 100 * ((43.8) - (4 * headButtDouble + 11 * struggleDouble)) / 43.8;

        // 투쟁행동 비율 계산
        // 투쟁행동 지수: 100 - [100 X [{43.8} - (4 X (머리박치기) + 11 X (머리박치기 제외 투쟁행동))] / 43.8
        // 100 - 사회적행동 지수
        double struggleRatio = 100 - socialBehavior;
        int struggleScore = 0;

        if(struggleRatio == 0) {
            struggleScore = 100;
        }
        else if(struggleRatio <= 4 ) {
            struggleScore = 90;
        }
        else if(struggleRatio <= 9 ) {
            struggleScore = 80;
        }
        else if(struggleRatio <= 14 ) {
            struggleScore = 70;
        }
        else if(struggleRatio <= 19 ) {
            struggleScore = 60;
        }
        else if(struggleRatio <= 25 ) {
            struggleScore = 50;
        }
        else if(struggleRatio <= 32 ) {
            struggleScore = 40;
        }
        else if(struggleRatio <= 41 ) {
            struggleScore = 30;
        }
        else if(struggleRatio <= 53 ) {
            struggleScore = 20;
        }
        else if(struggleRatio <= 71 ) {
            struggleScore = 10;
        }
        else if(struggleRatio <= 100 ) {
            struggleScore = 0;
        }
        return Integer.toString(struggleScore);
    }

    // 편안한 사람-가축 관계(회피거리) 종합 점수 계산
    public static String getUntouchableCowScore(String touchNear, String touchFar, String touchImpossibility)
    {
        int touchNearInteger = Integer.parseInt(touchNear);
        int touchFarInteger = Integer.parseInt(touchFar);
        int touchImpossibilityInteger = Integer.parseInt(touchImpossibility);

        // 만질 수 없는 소의 비율
        int untouchableCow = ((3 * touchNearInteger) + (11 * touchFarInteger) + (26 * touchImpossibilityInteger)) / 26;
        int untouchableCowScore = 0;
        if (untouchableCow < 0) {
            untouchableCowScore = 100;
        } else if (1 <= untouchableCow && untouchableCow <= 2) {
            untouchableCowScore = 95;
        } else if (3 <= untouchableCow && untouchableCow <= 5) {
            untouchableCowScore = 90;
        } else if (6 <= untouchableCow && untouchableCow <= 7) {
            untouchableCowScore = 85;
        } else if (8 <= untouchableCow && untouchableCow <= 9) {
            untouchableCowScore = 80;
        } else if (10 <= untouchableCow && untouchableCow <= 11) {
            untouchableCowScore = 75;
        } else if (12 <= untouchableCow && untouchableCow <= 14) {
            untouchableCowScore = 70;
        } else if (15 <= untouchableCow && untouchableCow <= 17) {
            untouchableCowScore = 65;
        } else if (18 <= untouchableCow && untouchableCow <= 19) {
            untouchableCowScore = 60;
        } else if (20 <= untouchableCow && untouchableCow <= 22) {
            untouchableCowScore = 55;
        } else if (23 <= untouchableCow && untouchableCow <= 25) {
            untouchableCowScore = 50;
        } else if (26 <= untouchableCow && untouchableCow <= 28) {
            untouchableCowScore = 45;
        } else if (29 <= untouchableCow && untouchableCow <= 32) {
            untouchableCowScore = 40;
        } else if (33 <= untouchableCow && untouchableCow <= 36) {
            untouchableCowScore = 35;
        } else if (37 <= untouchableCow && untouchableCow <= 41) {
            untouchableCowScore = 30;
        } else if (42 <= untouchableCow && untouchableCow <= 46) {
            untouchableCowScore = 25;
        } else if (47 <= untouchableCow && untouchableCow <= 52) {
            untouchableCowScore = 20;
        } else if (53 <= untouchableCow && untouchableCow <= 60) {
            untouchableCowScore = 15;
        } else if (61 <= untouchableCow && untouchableCow <= 71) {
            untouchableCowScore = 10;
        } else if (72 <= untouchableCow && untouchableCow <= 86) {
            untouchableCowScore = 5;
        } else if (87 <= untouchableCow && untouchableCow <= 100) {
            untouchableCowScore = 0;
        }
        return Integer.toString(untouchableCowScore);
    }
}
