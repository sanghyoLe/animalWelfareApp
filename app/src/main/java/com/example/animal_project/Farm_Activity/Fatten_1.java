package com.example.animal_project.Farm_Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.animal_project.Input_userinfo;
import com.example.animal_project.MainActivity;
import com.example.animal_project.R;

public class Fatten_1 extends AppCompatActivity {
    private View view;
    private String result;
    private Button btn_move;
    private EditText ed_1_poorRate;
    Integer water_Tank_Num = 0, water_Tank_Clean = 0, water_Tank_Time = 0;

    public String total_cow_count = ((Input_userinfo)Input_userinfo.context_userinfo).total_cow_count;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fatten_1);

        ScrollView scrollview_freestall_1 = findViewById(R.id.scrollview_freestall_1); //fatten으로
        RadioGroup rdiog_2_water_tank_num = (RadioGroup) findViewById(R.id.fatten_water_Tank_Num_rdogrp2);//2번 문항
        RadioGroup rdiog_3_water_tank_clean = (RadioGroup) findViewById(R.id.fatten_water_Tank_Clean_rdogrp3); //3번 문항
        RadioGroup rdiog_4_water_tank_time = (RadioGroup) findViewById(R.id.fatten_water_Tank_Time_rdogrp4); //4번 문항
        ed_1_poorRate = (EditText) findViewById(R.id.fatten_poor_Rate_a1); //1번 문항
        TextView fatten_poor_Rate_ratio = (TextView)findViewById(R.id.fatten_poor_Rate_ratio);
        TextView fatten_poor_Rate_score = (TextView)findViewById(R.id.fatten_poor_Rate_score);
        TextView freestall_water_Tank_Num_q2 = (TextView) findViewById(R.id.freestall_water_Tank_Num_q2);
        TextView freestall_water_Tank_Clean_q3 = (TextView) findViewById(R.id.freestall_water_Tank_Clean_q3);
        TextView freestall_water_Tank_Time_q4 = (TextView) findViewById(R.id.freestall_water_Tank_Time_q4);

        rdiog_2_water_tank_num.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ((MainActivity)MainActivity.mContext).scrollToView(freestall_water_Tank_Clean_q3,scrollview_freestall_1,0);
                if (checkedId == R.id.fatten_water_Tank_Num_a2_1) {
                    water_Tank_Num = 1;
                } else if (checkedId == R.id.fatten_water_Tank_Num_a2_2) {
                    water_Tank_Num = 2;
                }
            }
        });

        rdiog_3_water_tank_clean.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ((MainActivity)MainActivity.mContext).scrollToView(freestall_water_Tank_Time_q4,scrollview_freestall_1,0);
                if (checkedId == R.id.fatten_water_Tank_Clean_a3_1) {
                    water_Tank_Clean = 1;
                } else if (checkedId == R.id.fatten_water_Tank_Clean_a3_2) {
                    water_Tank_Clean = 2;
                } else if (checkedId == R.id.fatten_water_Tank_Clean_a3_3) {
                    water_Tank_Clean = 3;
                }
            }
        });

        rdiog_4_water_tank_time.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.fatten_water_Tank_Time_a4_1) {
                    water_Tank_Time = 1;
                } else if (checkedId == R.id.fatten_water_Tank_Time_a4_2) {
                    water_Tank_Time = 2;
                } else if (checkedId == R.id.fatten_water_Tank_Time_a4_3) {
                    water_Tank_Time = 3;
                }
            }
        });

        Button fatten_pre_1_btn = (Button) findViewById(R.id.fatten_pre_1_btn);
        Button fatten_next_1_btn = (Button) findViewById(R.id.fatten_next_1_btn);

        fatten_pre_1_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        fatten_next_1_btn.setOnClickListener(new View.OnClickListener() { //fragment1로 이동
            @Override
            public void onClick(View v) {
                String poorRate = ed_1_poorRate.getText().toString();
                String water_tank_num = Integer.toString(water_Tank_Num);
                String water_tank_clean = Integer.toString(water_Tank_Clean);
                String water_tank_time = Integer.toString(water_Tank_Time);

                String[] protocol1 = {poorRate, water_tank_num, water_tank_clean, water_tank_time};

                Intent intent_Fatten_2 = new Intent(Fatten_1.this, Fatten_2.class);
                startActivity(intent_Fatten_2);
            }
        });

        ed_1_poorRate.addTextChangedListener(new TextWatcher(){
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable arg0) {
                if(TextUtils.isEmpty(ed_1_poorRate.getText().toString())) {
                    fatten_poor_Rate_ratio.setText("값을 입력해주세요");
                    // 총 두수 보다 입력한 값이 클 때
                } else if(Integer.parseInt(total_cow_count) < Integer.parseInt(ed_1_poorRate.getText().toString())){
                    fatten_poor_Rate_ratio.setText("총 두수보다 큰 값을 입력할 수 없습니다.");
                } else {
                    String total_cow = fattenPoorRateRatio(total_cow_count, ed_1_poorRate.getText().toString());
                    fatten_poor_Rate_ratio.setText(total_cow + "%");

                    fatten_poor_Rate_score.setText(fattenPoorRateScore(total_cow));
                }
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
        });
    }

    public String fattenPoorRateRatio(String total, String rate){
        Float totalFloat = Float.parseFloat(total);
        Float rateFloat = Float.parseFloat(rate);

        double result = (rateFloat / totalFloat) * 100;

            return String.format("%.2f",result);
    }

    public String fattenPoorRateScore(String ratio){
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
}
