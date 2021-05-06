package com.example.animal_project.Farm_Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.animal_project.MainActivity;
import com.example.animal_project.R;

public class MilkCow_2 extends AppCompatActivity {
    private View view;
    private String result;
    private Button btn_move;
    Integer sit_Action_Time = 0, outward_Hygiene_Leg = 0, outward_Hygiene_Back = 0, outward_Hygiene_Breast = 0, shade = 0, summer_Ventilating = 0, mist_Spary = 0,
            wind_Block_Adult = 0, winter_Ventilating = 0, straw = 0, warm = 0, wind_Block_Child = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.milkcow_2);

        ScrollView scrollview_milk_2 = findViewById(R.id.scrollview_milk_2);
        TextView milk_outward_Hygiene_Leg_q6 = (TextView) findViewById(R.id.milk_outward_Hygiene_Leg_q6);
        TextView milk_outward_Hygiene_Back_q7 = (TextView) findViewById(R.id.milk_outward_Hygiene_Back_q7);
        TextView milk_outward_Hygiene_Breast_q8 = (TextView) findViewById(R.id.milk_outward_Hygiene_Breast_q8);
        TextView milk_shade_q9 = (TextView) findViewById(R.id.milk_shade_q9);
        TextView milk_summer_Ventilating_q10 = (TextView) findViewById(R.id.milk_summer_Ventilating_q10);
        TextView milk_mist_Spary_q11 = (TextView) findViewById(R.id.milk_mist_Spary_q11);
        TextView milk_wind_Block_q12 = (TextView) findViewById(R.id.milk_wind_Block_q12);
        TextView milk_winter_Ventilating_q13 = (TextView) findViewById(R.id.milk_winter_Ventilating_q13);
        TextView milk_straw_q14 = (TextView) findViewById(R.id.milk_straw_q14);
        TextView milk_warm_q15 = (TextView) findViewById(R.id.milk_warm_q15);
        TextView milk_wind_Block_q16 = (TextView) findViewById(R.id.milk_wind_Block_q16);

        RadioGroup rdiog_5_sit_action_time = (RadioGroup) findViewById(R.id.milk_sit_Action_Time_rdogrp5); //5번 문항
        RadioGroup rdiog_6_outward_hygiene_leg = (RadioGroup) findViewById(R.id.milk_outward_Hygiene_Leg_rdogrp6); //6번 문항
        RadioGroup rdiog_7_outward_hygiene_back = (RadioGroup) findViewById(R.id.milk_outward_Hygiene_Back_rdogrp7); //7번 문항
        RadioGroup rdiog_8_outward_hygiene_breast = (RadioGroup) findViewById(R.id.milk_outward_Hygiene_Breast_rdogrp8); //8번 문항
        RadioGroup rdiog_9_shade = (RadioGroup) findViewById(R.id.milk_shade_rdogrp9); //9번 문항
        RadioGroup rdiog_10_summer_ventilating = (RadioGroup) findViewById(R.id.milk_summer_Ventilating_rdogrp10); //10번 문항
        RadioGroup rdiog_11_mist_spary = (RadioGroup) findViewById(R.id.milk_mist_Spary_rdogrp11); //11번 문항
        RadioGroup rdiog_12_wind_block_adult = (RadioGroup) findViewById(R.id.milk_wind_Block_rdogrp12); //12번 문항
        RadioGroup rdiog_13_winter_ventilating = (RadioGroup) findViewById(R.id.milk_winter_Ventilating_rdogrp13); //13번 문항
        RadioGroup rdiog_14_straw = (RadioGroup) findViewById(R.id.milk_straw_rdogrp14); //14번 문항
        RadioGroup rdiog_15_warm = (RadioGroup) findViewById(R.id.milk_warm_rdogrp15); //15번 문항
        RadioGroup rdiog_16_wind_block_child = (RadioGroup) findViewById(R.id.milk_wind_Block_rdogrp16); //16번 문항

        rdiog_5_sit_action_time.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ((MainActivity)MainActivity.mContext).scrollToView(milk_outward_Hygiene_Leg_q6,scrollview_milk_2,0);
                if (checkedId == R.id.milk_sit_Action_Time_a5_1) {
                    sit_Action_Time = 1;
                } else if (checkedId == R.id.milk_sit_Action_Time_a5_2) {
                    sit_Action_Time = 2;
                } else if (checkedId == R.id.milk_sit_Action_Time_a5_3) {
                    sit_Action_Time = 3;
                }
            }
        });

        rdiog_6_outward_hygiene_leg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override

            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ((MainActivity)MainActivity.mContext).scrollToView(milk_outward_Hygiene_Back_q7,scrollview_milk_2,0);
                if (checkedId == R.id.milk_outward_Hygiene_Leg_a6_1) {
                    outward_Hygiene_Leg = 1;
                } else if (checkedId == R.id.milk_outward_Hygiene_Leg_a6_2) {
                    outward_Hygiene_Leg = 2;
                } else if (checkedId == R.id.milk_outward_Hygiene_Leg_a6_3) {
                    outward_Hygiene_Leg = 3;
                }
            }
        });

        rdiog_7_outward_hygiene_back.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ((MainActivity)MainActivity.mContext).scrollToView(milk_outward_Hygiene_Breast_q8,scrollview_milk_2,0);
                if (checkedId == R.id.milk_outward_Hygiene_Back_a7_1) {
                    outward_Hygiene_Back = 1;
                } else if (checkedId == R.id.milk_outward_Hygiene_Back_a7_2) {
                    outward_Hygiene_Back = 2;
                } else if (checkedId == R.id.milk_outward_Hygiene_Back_a7_3) {
                    outward_Hygiene_Back = 3;
                }
            }
        });

        rdiog_8_outward_hygiene_breast.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ((MainActivity)MainActivity.mContext).scrollToView(milk_shade_q9,scrollview_milk_2,0);
                if (checkedId == R.id.milk_outward_Hygiene_Breast_a8_1) {
                    outward_Hygiene_Breast = 1;
                } else if (checkedId == R.id.milk_outward_Hygiene_Breast_a8_2) {
                    outward_Hygiene_Breast = 2;
                } else if (checkedId == R.id.milk_outward_Hygiene_Breast_a8_3) {
                    outward_Hygiene_Breast = 3;
                }
            }
        });

        rdiog_9_shade.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ((MainActivity)MainActivity.mContext).scrollToView(milk_summer_Ventilating_q10,scrollview_milk_2,0);
                if (checkedId == R.id.milk_shade_a9_1) {
                    shade = 1;
                } else if (checkedId == R.id.milk_shade_a9_2) {
                    shade = 2;
                }
            }
        });

        rdiog_10_summer_ventilating.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ((MainActivity)MainActivity.mContext).scrollToView(milk_mist_Spary_q11,scrollview_milk_2,0);
                if (checkedId == R.id.milk_summer_Ventilating_a10_1) {
                    summer_Ventilating = 1;
                } else if (checkedId == R.id.milk_summer_Ventilating_a10_2) {
                    summer_Ventilating = 2;
                }
            }
        });

        rdiog_11_mist_spary.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ((MainActivity)MainActivity.mContext).scrollToView(milk_wind_Block_q12,scrollview_milk_2,0);
                if (checkedId == R.id.milk_mist_Spary_a11_1) {
                    mist_Spary = 1;
                } else if (checkedId == R.id.milk_mist_Spary_a11_2) {
                    mist_Spary = 2;
                }
            }
        });

        rdiog_12_wind_block_adult.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ((MainActivity)MainActivity.mContext).scrollToView(milk_winter_Ventilating_q13,scrollview_milk_2,0);
                if (checkedId == R.id.milk_wind_Block_a12_1) {
                    wind_Block_Adult = 1;
                } else if (checkedId == R.id.milk_wind_Block_a12_2) {
                    wind_Block_Adult = 2;
                }
            }
        });

        rdiog_13_winter_ventilating.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ((MainActivity)MainActivity.mContext).scrollToView(milk_straw_q14,scrollview_milk_2,0);
                if (checkedId == R.id.milk_winter_Ventilating_a13_1) {
                    winter_Ventilating = 1;
                } else if (checkedId == R.id.milk_winter_Ventilating_a13_2) {
                    winter_Ventilating = 2;
                }
            }
        });

        rdiog_14_straw.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ((MainActivity)MainActivity.mContext).scrollToView(milk_warm_q15,scrollview_milk_2,0);
                if (checkedId == R.id.milk_straw_a14_1) {
                    straw = 1;
                } else if (checkedId == R.id.milk_straw_a14_2) {
                    straw = 2;
                }
            }
        });

        rdiog_15_warm.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ((MainActivity)MainActivity.mContext).scrollToView(milk_wind_Block_q16,scrollview_milk_2,0);
                if (checkedId == R.id.milk_warm_a15_1) {
                    warm = 1;
                } else if (checkedId == R.id.milk_warm_a15_2) {
                    warm = 2;
                }
            }
        });

        rdiog_16_wind_block_child.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.milk_wind_Block_a16_1) {
                    wind_Block_Child = 1;
                } else if (checkedId == R.id.milk_wind_Block_a16_2) {
                    wind_Block_Child = 2;
                }
            }
        });

        Button milkcow_pre_2_btn = (Button) findViewById(R.id.milkcow_pre_2_btn);
        Button milkcow_next_2_btn = (Button) findViewById(R.id.milkcow_next_2_btn);

        milkcow_pre_2_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        milkcow_next_2_btn.setOnClickListener(new View.OnClickListener() { //fragment1로 이동
            @Override
            public void onClick(View v) {
                String sit_action_time = Integer.toString(sit_Action_Time);
                String outward_hygiene_leg = Integer.toString(outward_Hygiene_Leg);
                String outward_hygiene_back = Integer.toString(outward_Hygiene_Back);
                String outward_hygiene_breast = Integer.toString(outward_Hygiene_Breast);
                String shade_1 = Integer.toString(shade);
                String summer_ventilating = Integer.toString(summer_Ventilating);
                String mist_spary = Integer.toString(mist_Spary);
                String wind_block_adult = Integer.toString(wind_Block_Adult);
                String winter_ventilating = Integer.toString(winter_Ventilating);
                String straw_1 = Integer.toString(straw);
                String warm_1 = Integer.toString(warm);
                String wind_block_child = Integer.toString(wind_Block_Child);

                String[] protocol2 = {sit_action_time, outward_hygiene_leg, outward_hygiene_back, outward_hygiene_breast, shade_1,
                        summer_ventilating, mist_spary, wind_block_adult, winter_ventilating, straw_1, warm_1, wind_block_child};

                Intent intent_MilkCow_3 = new Intent(MilkCow_2.this, MilkCow_3.class);
                startActivity(intent_MilkCow_3);
            }
        });
    }
}
