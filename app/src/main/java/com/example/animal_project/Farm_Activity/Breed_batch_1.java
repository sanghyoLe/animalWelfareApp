package com.example.animal_project.Farm_Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.animal_project.Input_userinfo;
import com.example.animal_project.R;

public class Breed_batch_1 extends AppCompatActivity {
    private View view;
    private String result;
    private Button btn_move;
    private EditText ed_1_poorRate;
    Integer water_Tank_Clean = 0, water_Tank_Time = 0;
    public String total_cow_count = ((Input_userinfo) Input_userinfo.context_userinfo).total_cow_count;
    int breed_poor_rate_score = 0;
    private double protocolOneScore;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.breed_batch_1);

        Intent intent = getIntent();
        Bundle BeforeBundle = intent.getExtras();
        int inputCheck = BeforeBundle.getInt("inputChecked");


        ScrollView scrollview_freestall_1 = findViewById(R.id.scrollview_freestall_1); //fatten으로
        ed_1_poorRate = (EditText) findViewById(R.id.breed_batch_poor_Rate_a1); //1번 문항
        RadioGroup rdiog_2_water_tank_num = (RadioGroup) findViewById(R.id.breed_batch_water_Tank_Num_rdogrp2);//2번 문항



        TextView breed_poor_Rate_ratio = (TextView) findViewById(R.id.breed_poor_Rate_ratio);
        TextView breed_poor_Rate_score = (TextView) findViewById(R.id.breed_poor_Rate_score);
        TextView freestall_water_Tank_Num_q2 = (TextView) findViewById(R.id.freestall_water_Tank_Num_q2);
        TextView freestall_water_Tank_Clean_q3 = (TextView) findViewById(R.id.freestall_water_Tank_Clean_q3);
        TextView freestall_water_Tank_Time_q4 = (TextView) findViewById(R.id.freestall_water_Tank_Time_q4);






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

                Intent intent_Breed_batch_2 = new Intent(Breed_batch_1.this, Breed_batch_2.class);
                Bundle AfterBundle = new Bundle();
                AfterBundle.putDouble("protocolOneScore",protocolOneScore);
                AfterBundle.putInt("inputChecked",inputCheck);
                intent_Breed_batch_2.putExtras(AfterBundle);
                startActivity(intent_Breed_batch_2);
            }
        });



    }
    /*protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        TextView breed_Drink_Water_Score = findViewById(R.id.breed_Drink_Water_Score);
        TextView breed_total_water_score = findViewById(R.id.breed_total_water_score);
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case 1:
                int key = data.getExtras().getInt("key");
                breed_Drink_Water_Score.setText(String.valueOf(key));
                // 프로토콜 1 점수
                breed_total_water_score.setText(String.valueOf(getWaterScore(water_Tank_Num,water_Tank_Clean,key)));
                protocolOneScore = setProtocolOneResult(breed_poor_rate_score,getWaterScore(water_Tank_Num,water_Tank_Clean,key));
                Log.d("1",String.valueOf(protocolOneScore));
                break;
            default:
                break;
        }
*/    //}

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
    private double setProtocolOneResult(int PoorScore, int WaterScore){
        return (PoorScore * 0.7) + (WaterScore * 0.3);
    }

}
