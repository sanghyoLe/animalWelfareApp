package com.example.animal_project.Farm_Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.example.animal_project.R;
import com.example.animal_project.getStrawScore;


public class Fatten_2 extends AppCompatActivity {
    private View view;
    private String result;
    private Button btn_move;
    private EditText ed_8_outward_Hygiene;
    Integer straw_Feed_Tank = 0, straw_Normal = 0, straw_Resting_Place = 0, outward_Hygiene = 0, shade = 0, summer_Ventilating = 0, mist_Spary = 0,
    wind_Block = 0, winter_Ventilating = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fatten_2);

        RadioGroup rdiog_5_straw_feed_tank = (RadioGroup) findViewById(R.id.fatten_straw_Feed_Tank_rdogrp5);
        RadioGroup rdiog_6_straw_normal = (RadioGroup) findViewById(R.id.fatten_straw_Normal_rdogrp6);
        RadioGroup rdiog_7_straw_resting_place = (RadioGroup) findViewById(R.id.fatten_straw_Resting_Place_rdogrp7);
        RadioGroup rdiog_9_shade = (RadioGroup) findViewById(R.id.fatten_shade_rdogrp9);
        RadioGroup rdiog_10_summer_ventilating = (RadioGroup) findViewById(R.id.fatten_summer_Ventilating_rdogrp10); //10번 문항
        RadioGroup rdiog_11_mist_spary = (RadioGroup) findViewById(R.id.fatten_mist_Spary_rdogrp11); //11번 문항
        RadioGroup rdiog_12_wind_block = (RadioGroup) findViewById(R.id.fatten_wind_Block_rdogrp12); //12번 문항
        RadioGroup rdiog_13_winter_ventilating = (RadioGroup) findViewById(R.id.fatten_winter_Ventilating_rdogrp13); //13번 문항
        ed_8_outward_Hygiene = (EditText) findViewById(R.id.fatten_outward_Hygiene_a8);
        TextView fatten_summer_rest_score = (TextView) findViewById(R.id.fatten_summer_rest_score);
        TextView fatten_winter_rest_score = (TextView) findViewById(R.id.fatten_winter_rest_score);
        //---------------
        Button exBtn = (Button) findViewById(R.id.exampleButton);
        EditText exText = (EditText) findViewById(R.id.examplesize);

        exBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String exString = exText.getText().toString();
                int exInt = Integer.parseInt(exString);
                Intent intent = new Intent(Fatten_2.this, getStrawScore.class);
                intent.putExtra("exSize",exInt); /*송신*/
                startActivity(intent);
            }
        });
        //---------------

        rdiog_5_straw_feed_tank.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.fatten_straw_Feed_Tank_a5_1) {
                    straw_Feed_Tank = 1;
                } else if (checkedId == R.id.fatten_straw_Feed_Tank_a5_2) {
                    straw_Feed_Tank = 2;
                } else if (checkedId == R.id.fatten_straw_Feed_Tank_a5_3) {
                    straw_Feed_Tank = 3;
                }
            }
        });

        rdiog_6_straw_normal.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.fatten_straw_Normal_a6_1) {
                    straw_Normal = 1;
                } else if (checkedId == R.id.fatten_straw_Normal_a6_2) {
                    straw_Normal = 2;
                } else if (checkedId == R.id.fatten_straw_Normal_a6_3) {
                    straw_Normal = 3;
                } else if (checkedId == R.id.fatten_straw_Normal_a6_4) {
                    straw_Normal = 4;
                }
            }
        });

        rdiog_7_straw_resting_place.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.fatten_straw_Resting_Place_a7_1) {
                    straw_Resting_Place = 1;
                } else if (checkedId == R.id.fatten_straw_Resting_Place_a7_2) {
                    straw_Resting_Place = 2;
                } else if (checkedId == R.id.fatten_straw_Resting_Place_a7_3) {
                    straw_Resting_Place = 3;
                } else if (checkedId == R.id.fatten_straw_Resting_Place_a7_4) {
                    straw_Resting_Place = 4;
                }
            }
        });

        rdiog_9_shade.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.fatten_shade_a9_1) {
                    shade = 1;
                } else if (checkedId == R.id.fatten_shade_a9_2) {
                    shade = 2;
                }

                fatten_summer_rest_score.setText(Integer.toString(getSummerRestScore(shade,summer_Ventilating,mist_Spary)));

            }
        });

        rdiog_10_summer_ventilating.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.fatten_summer_Ventilating_a10_1) {
                    summer_Ventilating = 1;
                } else if (checkedId == R.id.fatten_summer_Ventilating_a10_2) {
                    summer_Ventilating = 2;
                }

                fatten_summer_rest_score.setText(Integer.toString(getSummerRestScore(shade,summer_Ventilating,mist_Spary)));

            }
        });

        rdiog_11_mist_spary.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.fatten_mist_Spary_a11_1) {
                    mist_Spary = 1;
                } else if (checkedId == R.id.fatten_mist_Spary_a11_2) {
                    mist_Spary = 2;
                }
                fatten_summer_rest_score.setText(Integer.toString(getSummerRestScore(shade,summer_Ventilating,mist_Spary)));
            }
        });

        rdiog_12_wind_block.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.fatten_wind_Block_a12_1) {
                    wind_Block = 1;
                } else if (checkedId == R.id.fatten_wind_Block_a12_2) {
                    wind_Block = 2;
                }
                fatten_winter_rest_score.setText(Integer.toString(getWinterRestScore(wind_Block,winter_Ventilating)));
            }
        });

        rdiog_13_winter_ventilating.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.fatten_winter_Ventilating_a13_1) {
                    winter_Ventilating = 1;
                } else if (checkedId == R.id.fatten_winter_Ventilating_a13_2) {
                    winter_Ventilating = 2;
                }
                fatten_winter_rest_score.setText(Integer.toString(getWinterRestScore(wind_Block,winter_Ventilating)));
            }
        });

        Button fatten_pre_2_btn = (Button) findViewById(R.id.fatten_pre_2_btn);
        Button fatten_next_2_btn = (Button) findViewById(R.id.fatten_next_2_btn);

        fatten_pre_2_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        fatten_next_2_btn.setOnClickListener(new View.OnClickListener() { //fragment1로 이동
            @Override
            public void onClick(View v) {
                String straw_feed_tank = Integer.toString(straw_Feed_Tank);
                String straw_normal = Integer.toString(straw_Normal);
                String straw_resting_place = Integer.toString(straw_Resting_Place);
                String outward_hygiene = ed_8_outward_Hygiene.getText().toString();
                String shade_1 = Integer.toString(shade);
                String summer_ventilating = Integer.toString(summer_Ventilating);
                String mist_spary = Integer.toString(mist_Spary);
                String wind_block = Integer.toString(wind_Block);
                String winter_ventilating = Integer.toString(winter_Ventilating);

                String[] protocol2 = { straw_feed_tank, straw_normal, straw_resting_place, outward_hygiene, shade_1, summer_ventilating,
                        mist_spary, wind_block, winter_ventilating };

                Intent intent_Fatten_3 = new Intent(Fatten_2.this, Fatten_3.class);
                startActivity(intent_Fatten_3);
            }
        });
    }

     // 혹서기 - 그늘, 환기팬, 안개분무 시설 점수 계산
     public int getSummerRestScore(int shade,int summerVentilating, int mistSpary)
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
    public int getWinterRestScore(int windBlock, int winterVentilating)
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

}
