package com.example.animal_project.Farm_Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.animal_project.BreedBatchQuestion.Breed_q4;
import com.example.animal_project.Input_userinfo;
import com.example.animal_project.MainActivity;
import com.example.animal_project.R;

public class Breed_batch_1 extends AppCompatActivity {
    private View view;
    private String result;
    private Button btn_move;
    private EditText ed_1_poorRate;
    Integer water_Tank_Num = 0, water_Tank_Clean = 0, water_Tank_Time = 0;
    public String total_cow_count = ((Input_userinfo) Input_userinfo.context_userinfo).total_cow_count;
    int breed_poor_rate_score = 0;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.breed_batch_1);

        ScrollView scrollview_freestall_1 = findViewById(R.id.scrollview_freestall_1); //fatten으로
        ed_1_poorRate = (EditText) findViewById(R.id.breed_batch_poor_Rate_a1); //1번 문항
        RadioGroup rdiog_2_water_tank_num = (RadioGroup) findViewById(R.id.breed_batch_water_Tank_Num_rdogrp2);//2번 문항
        RadioGroup rdiog_3_water_tank_clean = (RadioGroup) findViewById(R.id.breed_batch_water_Tank_Clean_rdogrp3); //3번 문항


        TextView breed_poor_Rate_ratio = (TextView) findViewById(R.id.breed_poor_Rate_ratio);
        TextView breed_poor_Rate_score = (TextView) findViewById(R.id.breed_poor_Rate_score);
        TextView freestall_water_Tank_Num_q2 = (TextView) findViewById(R.id.freestall_water_Tank_Num_q2);
        TextView freestall_water_Tank_Clean_q3 = (TextView) findViewById(R.id.freestall_water_Tank_Clean_q3);
        TextView freestall_water_Tank_Time_q4 = (TextView) findViewById(R.id.freestall_water_Tank_Time_q4);


        rdiog_2_water_tank_num.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ((MainActivity) MainActivity.mContext).scrollToView(freestall_water_Tank_Clean_q3, scrollview_freestall_1, 0);
                if (checkedId == R.id.breed_batch_water_Tank_Num_a2_1) {
                    water_Tank_Num = 1;
                } else if (checkedId == R.id.breed_batch_water_Tank_Num_a2_2) {
                    water_Tank_Num = 2;
                }
            }
        });

        rdiog_3_water_tank_clean.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ((MainActivity) MainActivity.mContext).scrollToView(freestall_water_Tank_Time_q4, scrollview_freestall_1, 0);
                if (checkedId == R.id.breed_batch_water_Tank_Clean_a3_1) {
                    water_Tank_Clean = 1;
                } else if (checkedId == R.id.breed_batch_water_Tank_Clean_a3_2) {
                    water_Tank_Clean = 2;
                } else if (checkedId == R.id.breed_batch_water_Tank_Clean_a3_3) {
                    water_Tank_Clean = 3;
                }
            }
        });

        ArrayAdapter spinnerAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                R.array.dong_size,
                android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner mSpinner = findViewById(R.id.spinner_breed_q4);
        mSpinner.setAdapter( spinnerAdapter );
        final int[] selectedItemIndex = new int[1];
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // 선택된 데이터 값
                String selectedItem = parent.getSelectedItem().toString();

                // 선택된 데이터 위치( 0 부터 )
                selectedItemIndex[0] = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        Button breed_btn_q4 = findViewById(R.id.breed_btn_q4);


        breed_btn_q4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String dong_count = Integer.toString(selectedItemIndex[0]);
                if(Integer.parseInt(dong_count) == 0){
                    String msg = "축사 동 수를 선택해주세요";
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                }else{
                    int dong_size = Integer.parseInt(dong_count);

                    Intent intent = new Intent(Breed_batch_1.this, Breed_q4.class);
                    intent.putExtra("dong_count",dong_size); /*송신*/

                    startActivityForResult(intent, 0);


                }

            }
        });
        Button breed_batch_pre_1_btn = (Button) findViewById(R.id.breed_batch_pre_1_btn);
        Button breed_batch_next_1_btn = (Button) findViewById(R.id.breed_batch_next_1_btn);

        breed_batch_pre_1_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        breed_batch_next_1_btn.setOnClickListener(new View.OnClickListener() { //fragment1로 이동
            @Override
            public void onClick(View v) {
                String poorRate = ed_1_poorRate.getText().toString();
                String water_tank_num = Integer.toString(water_Tank_Num);
                String water_tank_clean = Integer.toString(water_Tank_Clean);
                String water_tank_time = Integer.toString(water_Tank_Time);

                String[] protocol1 = {poorRate, water_tank_num, water_tank_clean, water_tank_time};

                Intent intent_Breed_batch_2 = new Intent(Breed_batch_1.this, Breed_batch_2.class);
                startActivity(intent_Breed_batch_2);
            }
        });
        ed_1_poorRate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                if (TextUtils.isEmpty(ed_1_poorRate.getText().toString())) {
                    breed_poor_Rate_ratio.setText("값을 입력해주세요");
                    // 총 두수 보다 입력한 값이 클 때
                } else if (Integer.parseInt(total_cow_count) < Integer.parseInt(ed_1_poorRate.getText().toString())) {
                    breed_poor_Rate_ratio.setText("총 두수보다 큰 값을 입력할 수 없습니다.");
                } else {
                    String total_cow = breedPoorRateRatio(total_cow_count, ed_1_poorRate.getText().toString());
                    breed_poor_Rate_ratio.setText(total_cow + "%");
                    breed_poor_Rate_score.setText(breedPoorRateScore(total_cow));
                    breed_poor_rate_score = Integer.parseInt(breedPoorRateScore(total_cow));
                }
            }});


    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        TextView breed_Drink_Water_Score = findViewById(R.id.breed_Drink_Water_Score);
        TextView breed_total_water_score = findViewById(R.id.breed_total_water_score);
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case 0:
                int key = data.getExtras().getInt("key");
                breed_Drink_Water_Score.setText(String.valueOf(key));
                // 프로토콜 1 점수
                breed_total_water_score.setText(String.valueOf(getWaterScore(water_Tank_Num,water_Tank_Clean,key)));
                double score = getProtocolOneResult(breed_poor_rate_score,getWaterScore(water_Tank_Num,water_Tank_Clean,key));

                break;
            default:
                break;
        }
    }

    public String breedPoorRateRatio(String total, String rate){
        Float totalFloat = Float.parseFloat(total);
        Float rateFloat = Float.parseFloat(rate);
        double result = (rateFloat / totalFloat) * 100;
        return String.format("%.2f",result);
    }

    public String breedPoorRateScore(String ratio){
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
    public int getWaterScore(int waterTankNum, int waterTankClean, int waterTankTime)
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
    public double getProtocolOneResult(int PoorScore, int WaterScore){

        return (PoorScore * 0.7) + (WaterScore * 0.3);
    }
}
