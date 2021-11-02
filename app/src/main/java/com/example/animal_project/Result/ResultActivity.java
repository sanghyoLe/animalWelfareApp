package com.example.animal_project.Result;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;
import com.example.animal_project.Result.ResultTotal;
import com.example.animal_project.Result.ResultProtocolOne;
import com.example.animal_project.Result.ResultProtocolTwo;
import com.example.animal_project.Result.ResultProtocolThree;
import com.example.animal_project.Result.ResultProtocolFour;
import com.google.android.material.tabs.TabLayout;

public class ResultActivity extends AppCompatActivity {
    private long backKeyPressedTime = 0;
    QuestionTemplateViewModel viewModel;
    private Toast toast;
    @Override
    public void onBackPressed() {


        // 마지막으로 뒤로가기 버튼을 눌렀던 시간에 2초를 더해 현재시간과 비교 후
        // 마지막으로 뒤로가기 버튼을 눌렀던 시간이 2초가 지났으면 Toast Show
        // 2000 milliseconds = 2 seconds
        if (System.currentTimeMillis() > backKeyPressedTime + 2000) {
            backKeyPressedTime = System.currentTimeMillis();
            toast = Toast.makeText(this, "\'뒤로\' 버튼을 한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        // 마지막으로 뒤로가기 버튼을 눌렀던 시간에 2초를 더해 현재시간과 비교 후
        // 마지막으로 뒤로가기 버튼을 눌렀던 시간이 2초가 지나지 않았으면 종료
        // 현재 표시된 Toast 취소
        if (System.currentTimeMillis() <= backKeyPressedTime + 2000) {
            finish();
            toast.cancel();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ResultTotal resultTotal;
        ResultProtocolOne resultOne;
        ResultProtocolTwo resultTwo;
        ResultProtocolThree resultThree;
        ResultProtocolFour resultFour;
        TabLayout tabs;

            viewModel = new ViewModelProvider(this).get(QuestionTemplateViewModel.class);
            setContentView(R.layout.activity_result);

            resultTotal = new ResultTotal();
            resultOne = new ResultProtocolOne();
            resultTwo = new ResultProtocolTwo();
            resultThree = new ResultProtocolThree();
            resultFour = new ResultProtocolFour();

            getSupportFragmentManager().beginTransaction().add(R.id.container, resultTotal).commit();
            tabs = findViewById(R.id.tab_layout);
            tabs.addTab(tabs.newTab().setText("종합"));
            tabs.addTab(tabs.newTab().setText("사료"));
            tabs.addTab(tabs.newTab().setText("환경"));
            tabs.addTab(tabs.newTab().setText("건강"));
            tabs.addTab(tabs.newTab().setText("행동"));


            Intent intent = getIntent();
            Bundle resultBundle = intent.getExtras();
            viewModel.setTotalProtocolScoreString(resultBundle.getString("protocolTotalScoreString"));
            viewModel.setFarmType(resultBundle.getInt("farmType"));
            viewModel.setPoorScore(resultBundle.getInt("nutritionScore"));
            viewModel.setWaterScore(resultBundle.getInt("waterScore"));

            viewModel.setRestScore(resultBundle.getDouble("restScore"));
            viewModel.setStrawScore(resultBundle.getFloat("strawScore"));
            viewModel.setOutwardScore((int) resultBundle.getFloat("outwardScore"));
            viewModel.setSummerRestScore((int) resultBundle.getFloat("summerScore"));
            viewModel.setWinterRestScore((int) resultBundle.getFloat("winterScore"));
            viewModel.setCalfSummerRestScore((int) resultBundle.getFloat("calfSummerScore"));
            viewModel.setCalfWinterRestScore((int) resultBundle.getFloat("calfWinterScore"));
            viewModel.setTotalWarmVentilatingScore(resultBundle.getDouble("totalWarmVentilatingScore"));

            ((QuestionTemplateViewModel.FreeStallCountQuestion)viewModel.FreeStallCountQuestion).setLowestScore(resultBundle.getInt("freeStallCountScore"));
            ((QuestionTemplateViewModel.SitCollisionQuestion)viewModel.SitCollision).setScore(resultBundle.getInt("sitCollisionScore"));
            ((QuestionTemplateViewModel.FreeStallAreaOutCollision)viewModel.FreeStallAreaOutCollision).setScore(resultBundle.getInt("areaOutSitCollision"));
            ((QuestionTemplateViewModel.SitTimeQuestion)viewModel.SitTimeQuestion).setScore(resultBundle.getInt("sitTimeScore"));
            ((QuestionTemplateViewModel.Question)viewModel.OutwardBackReg).setScore(resultBundle.getInt("outwardBackRegScore"));
            ((QuestionTemplateViewModel.Question)viewModel.OutwardBack).setScore(resultBundle.getInt("outwardBackScore"));
            ((QuestionTemplateViewModel.Question)viewModel.OutwardBreast).setScore(resultBundle.getInt("outwardBackRegScore"));


            viewModel.setMinInjuryScore(resultBundle.getLong("minInjuryScore"));
            viewModel.setDiseaseScore(resultBundle.getDouble("diseaseScore"));
            viewModel.setMinPainScore(resultBundle.getDouble("minPainScore"));

            ((QuestionTemplateViewModel.Question)viewModel.BreedLimp).setScore(resultBundle.getInt("breedLimpScore"));
            ((QuestionTemplateViewModel.Question)viewModel.CriticalLimp).setScore(resultBundle.getInt("milkCowLimpScore"));
            viewModel.setHairLossScore(resultBundle.getInt("hairLossScore"));
            viewModel.setHornRemovalScore(resultBundle.getInt("hornRemoveScore"));
            viewModel.setCastrationScore(resultBundle.getInt("castrationScore"));
            viewModel.setSocialBehaviorScore(resultBundle.getInt("socialBehaviorScore"));
            viewModel.setAvoidDistanceScore(resultBundle.getInt("avoidDistanceScore"));





            viewModel.setProtocolOneScore(resultBundle.getDouble("protocolOneScore"));
            viewModel.setProtocolTwoScore(resultBundle.getDouble("protocolTwoScore"));
            viewModel.setProtocolThreeScore(resultBundle.getDouble("protocolThreeScore"));
            viewModel.setProtocolFourScore(resultBundle.getDouble("protocolFourScore"));


            Log.d("totalScoreString",viewModel.getTotalProtocolScoreString());






            tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    int position = tab.getPosition();
                    Fragment selected = null;
                    if(position == 0)
                        selected = resultTotal;
                    else if(position == 1)
                        selected = resultOne;
                    else if(position == 2)
                        selected = resultTwo;
                    else if(position == 3)
                        selected = resultThree;
                    else if(position == 4)
                        selected = resultFour;
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, selected).commit();
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });

        }

    }
