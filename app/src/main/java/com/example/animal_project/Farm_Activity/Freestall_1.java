package com.example.animal_project.Farm_Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.animal_project.Input_userinfo;
import com.example.animal_project.MainActivity;
import com.example.animal_project.Milk_cow;
import com.example.animal_project.R;
import com.example.animal_project.MilkCow_Question.Freestall_q4;

public class Freestall_1 extends AppCompatActivity {
    private View view;
    private EditText ed_1_poorRate;
    String result, water_Tank_Clean_Num;
    Integer water_Tank_Num = 0, water_Tank_Clean = 0, water_Tank_Time = 0;

    public String total_cow_count = ((Input_userinfo)Input_userinfo.context_userinfo).total_cow_count;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.freestall_1);

        ScrollView scrollview_freestall_1 = findViewById(R.id.scrollview_freestall_1);

        RadioGroup rdiog_2_water_tank_num = (RadioGroup) findViewById(R.id.freestall_water_Tank_Num_rdogrp2_1);//2번 문항 급수기 선택
        RadioGroup rdiog_2_water_tank_num_1 = (RadioGroup) findViewById(R.id.freestall_water_Tank_Num_rdogrp2_1);//2번 문항 개별 급수기 선택
        RadioGroup rdiog_2_water_tank_num_2 = (RadioGroup) findViewById(R.id.freestall_water_Tank_Num_rdogrp2_2);//2번 문항 대형 급수기 선택
        RadioGroup rdiog_3_water_tank_clean = (RadioGroup) findViewById(R.id.freestall_water_Tank_Clean_rdogrp3); //3번 문항
        Spinner spinner_4_water_clean_num = (Spinner) findViewById(R.id.freestall_spinner_a4);//4번 문항

        //fragment에서는 findById가 바로 동작하지 않아서 view를 사용해 써야함.
        ed_1_poorRate = (EditText) findViewById(R.id.freestall_poorRate_a1); //1번 문항

        TextView freestall_water_Tank_Num_q2 = (TextView) findViewById(R.id.freestall_water_Tank_Num_q2_1);
        TextView freestall_water_Tank_Clean_q3 = (TextView) findViewById(R.id.freestall_water_Tank_Clean_q3);
        TextView freestall_water_Tank_Time_q4 = (TextView) findViewById(R.id.freestall_water_Tank_Time_q4);

        TextView freestall_poor_Rate_ratio = (TextView) findViewById(R.id.freestall_poor_Rate_ratio);
        TextView freestall_poor_Rate_score = (TextView) findViewById(R.id.freestall_poor_Rate_score);

        Button freestall_poorRate_btn = findViewById(R.id.freestall_poorRate_btn);

        // 1번문항 버튼 생기고, 다음 화면으로 넘어가는 동작
//        ((MainActivity)MainActivity.mContext).addButtonScroll(ed_1_poorRate,freestall_poorRate_btn,scrollview_freestall_1,freestall_water_Tank_Num_q2);

        RadioButton freestall_water_Tank_Num_a2_1 = findViewById(R.id.freestall_water_Tank_Num_a2_1_1); //개별 급수기 1번 버튼(개별 급수 10두 이하)
        RadioButton freestall_water_Tank_Num_a2_2 = findViewById(R.id.freestall_water_Tank_Num_a2_2_1); //개별 급수기 2번 버튼(개별 급수 11두 이상)
//        RadioButton freestall_water_Tank_Num_a2_2 = findViewById(R.id.freestall_water_Tank_Num_a2_2_1); //대형 급수기 1번 버튼(개별 급수 20두 이하)
//        RadioButton freestall_water_Tank_Num_a2_2 = findViewById(R.id.freestall_water_Tank_Num_a2_2_1); //대형 급수기 2번 버튼(개별 급수 21두 이상)

        freestall_water_Tank_Num_a2_1.setChecked(RadioUpdate("freestall_water_Tank_Num_a2_1")); //sharedprefs 저장되어 있던 라디오 버튼 호출(개별 급수 10두 이하)
        freestall_water_Tank_Num_a2_2.setChecked(RadioUpdate("freestall_water_Tank_Num_a2_2")); //sharedprefs 저장되어 있던 라디오 버튼 호출(개별 급수 11두 이상)

        freestall_water_Tank_Num_a2_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SaveIntoSharedPrefsRadio("freestall_water_Tank_Num_a2_1", isChecked);
            }
        });
        freestall_water_Tank_Num_a2_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SaveIntoSharedPrefsRadio("freestall_water_Tank_Num_a2_2", isChecked);
            }
        });

        //2번 문항 상위 문항(급수기 선택)
        rdiog_2_water_tank_num.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.freestall_water_Tank_Num_a2_1) { //개별 급수기 선택
                    LinearLayout L1 = findViewById(R.id.freestall_water_Tank_Num_L1);
                    L1.setVisibility(view.GONE);
                } else if (checkedId == R.id.freestall_water_Tank_Num_a2_2) { //대형 급수기 선택
                    LinearLayout L2 = findViewById(R.id.freestall_water_Tank_Num_L2);
                    L2.setVisibility(view.GONE);
                }
            }
        });

        //2번 문항 하위 문항(개별 급수기)
        rdiog_2_water_tank_num_1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ((MainActivity) MainActivity.mContext).scrollToView(freestall_water_Tank_Clean_q3, scrollview_freestall_1, 0);
                if (checkedId == R.id.freestall_water_Tank_Num_a2_1_1) {
                    water_Tank_Num = 1;
                } else if (checkedId == R.id.freestall_water_Tank_Num_a2_2_1) {
                    water_Tank_Num = 2;
                }
            }
        });

        RadioButton freestall_water_Tank_Num_a3_1 = findViewById(R.id.freestall_water_Tank_Clean_a3_1);
        RadioButton freestall_water_Tank_Num_a3_2 = findViewById(R.id.freestall_water_Tank_Clean_a3_2);
        RadioButton freestall_water_Tank_Num_a3_3 = findViewById(R.id.freestall_water_Tank_Clean_a3_3);

        freestall_water_Tank_Num_a3_1.setChecked(RadioUpdate("freestall_water_Tank_Num_a3_1"));
        freestall_water_Tank_Num_a3_2.setChecked(RadioUpdate("freestall_water_Tank_Num_a3_2"));
        freestall_water_Tank_Num_a3_3.setChecked(RadioUpdate("freestall_water_Tank_Num_a3_3"));

        freestall_water_Tank_Num_a3_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SaveIntoSharedPrefsRadio("freestall_water_Tank_Num_a3_1", isChecked);
            }
        });
        freestall_water_Tank_Num_a3_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SaveIntoSharedPrefsRadio("freestall_water_Tank_Num_a3_2", isChecked);
            }
        });
        freestall_water_Tank_Num_a3_3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SaveIntoSharedPrefsRadio("freestall_water_Tank_Num_a3_3", isChecked);
            }
        });

        rdiog_3_water_tank_clean.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ((MainActivity) MainActivity.mContext).scrollToView(freestall_water_Tank_Time_q4, scrollview_freestall_1, 0);
                if (checkedId == R.id.freestall_water_Tank_Clean_a3_1) {
                    water_Tank_Clean = 1;
                } else if (checkedId == R.id.freestall_water_Tank_Clean_a3_2) {
                    water_Tank_Clean = 2;
                } else if (checkedId == R.id.freestall_water_Tank_Clean_a3_3) {
                    water_Tank_Clean = 3;
                }
            }
        });

        Button water_tank_clean_btn = (Button) findViewById(R.id.freestall_water_Tank_Clean_btn);
        water_tank_clean_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                water_Tank_Clean_Num = spinner_4_water_clean_num.getSelectedItem().toString();
                Intent intent = new Intent(Freestall_1.this, Freestall_q4.class);
                intent.putExtra("water_Tank_Clean_Num", water_Tank_Clean_Num);
                startActivity(intent);
            }
        });

        Button freestall_pre_1_btn = ((Button) findViewById(R.id.freestall_pre_1_btn));
        Button freestall_next_1_btn = ((Button) findViewById(R.id.freestall_next_1_btn));

        freestall_pre_1_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        freestall_next_1_btn.setOnClickListener(new View.OnClickListener() { //fragment1로 이동
            @Override
            public void onClick(View v) {
                String poorRate = ed_1_poorRate.getText().toString();
                String water_tank_num = Integer.toString(water_Tank_Num);
                String water_tank_clean = Integer.toString(water_Tank_Clean);
                String water_tank_time = Integer.toString(water_Tank_Time);

                String[] protocol1 = {poorRate, water_tank_num, water_tank_clean, water_tank_time};

                Intent intent_Freestall_2 = new Intent(Freestall_1.this, Freestall_2.class);
                startActivity(intent_Freestall_2);
            }
        });

        ed_1_poorRate.addTextChangedListener(new TextWatcher(){
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable arg0) {
                if(TextUtils.isEmpty(ed_1_poorRate.getText().toString())) {
                    freestall_poor_Rate_ratio.setText("값을 입력해주세요");
                    // 총 두수 보다 입력한 값이 클 때
                } else if(Integer.parseInt(total_cow_count) < Integer.parseInt(ed_1_poorRate.getText().toString())){
                    freestall_poor_Rate_ratio.setText("총 두수보다 큰 값을 입력할 수 없습니다.");
                } else {
                    String total_cow = ((Milk_cow)Milk_cow.context).getPoorRateRatio(total_cow_count, ed_1_poorRate.getText().toString());
                    freestall_poor_Rate_ratio.setText(total_cow + "%");

                    freestall_poor_Rate_score.setText(((Milk_cow)Milk_cow.context).getPoorRateScore(total_cow));
                }
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
        });
    }


    private void SaveIntoSharedPrefsString(String key) {
        SharedPreferences sharedPreferences = getSharedPreferences("value", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("value", key);
        editor.commit();
    }
    private String StringUpdate() {
        SharedPreferences sharedPreferences = getSharedPreferences("value", Context.MODE_PRIVATE);
        return sharedPreferences.getString("value", "");

    }

    // 라디오 버튼 값 저장
    private void SaveIntoSharedPrefsRadio(String key, boolean value) {
        SharedPreferences sharedPreferences = getSharedPreferences("value", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }
    // 라디오 버튼 값 업데이트
    private boolean RadioUpdate(String key) {
        SharedPreferences sharedPreferences = getSharedPreferences("value", Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key, false);
    }
    // 값 전체 삭제
    private void ClearPreferences(){
        SharedPreferences sharedPreferences = getSharedPreferences("value", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        SaveIntoSharedPrefsString(ed_1_poorRate.getText().toString());
    }
}
