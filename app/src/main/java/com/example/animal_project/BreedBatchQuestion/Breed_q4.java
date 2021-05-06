package com.example.animal_project.BreedBatchQuestion;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.animal_project.R;

public class Breed_q4 extends AppCompatActivity {
    private int dong_size;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_breed_q4);


        Intent intent = getIntent();
        dong_size = intent.getExtras().getInt("dong_count");

        TextView breed_Drink_Water_Score = findViewById(R.id.breed_Drink_Water_Score);

        Button breed_q4_button = findViewById(R.id.breed_q4_button);
        LinearLayout dong_1 = findViewById(R.id.breed_dong_q4_1);
        LinearLayout dong_2 = findViewById(R.id.breed_dong_q4_2);
        LinearLayout dong_3 = findViewById(R.id.breed_dong_q4_3);
        LinearLayout dong_4 = findViewById(R.id.breed_dong_q4_4);
        LinearLayout dong_5 = findViewById(R.id.breed_dong_q4_5);
        LinearLayout dong_6 = findViewById(R.id.breed_dong_q4_6);
        LinearLayout dong_7 = findViewById(R.id.breed_dong_q4_7);
        LinearLayout dong_8 = findViewById(R.id.breed_dong_q4_8);
        LinearLayout dong_9 = findViewById(R.id.breed_dong_q4_9);
        LinearLayout dong_10 = findViewById(R.id.breed_dong_q4_10);
        LinearLayout dong_11 = findViewById(R.id.breed_dong_q4_11);
        LinearLayout dong_12 = findViewById(R.id.breed_dong_q4_12);
        LinearLayout dong_13 = findViewById(R.id.breed_dong_q4_13);
        LinearLayout dong_14 = findViewById(R.id.breed_dong_q4_14);
        LinearLayout dong_15 = findViewById(R.id.breed_dong_q4_15);
        LinearLayout dong_16 = findViewById(R.id.breed_dong_q4_16);
        LinearLayout dong_17 = findViewById(R.id.breed_dong_q4_17);
        LinearLayout dong_18 = findViewById(R.id.breed_dong_q4_18);
        LinearLayout dong_19 = findViewById(R.id.breed_dong_q4_19);
        LinearLayout dong_20 = findViewById(R.id.breed_dong_q4_20);
        // 1동
        EditText totalCowEt_1 = findViewById(R.id.breed_total_cow_1);
        EditText waitngCowEt_1 = findViewById(R.id.breed_wating_cow_1);
        EditText drinkTimeEt_1 = findViewById(R.id.breed_drink_time_1);
        TextView waitngRatioTv_1 = findViewById(R.id.breed_wating_ratio_1);
        TextView drinkScoreTv_1 = findViewById(R.id.breed_drink_water_score_1);
        // 2동
        EditText totalCowEt_2 = findViewById(R.id.breed_total_cow_2);
        EditText waitngCowEt_2 = findViewById(R.id.breed_wating_cow_2);
        EditText drinkTimeEt_2 = findViewById(R.id.breed_drink_time_2);
        TextView waitngRatioTv_2 = findViewById(R.id.breed_wating_ratio_2);
        TextView drinkScoreTv_2 = findViewById(R.id.breed_drink_water_score_2);

        EditText totalCowEt_3 = findViewById(R.id.breed_total_cow_3);
        EditText waitngCowEt_3 = findViewById(R.id.breed_wating_cow_3);
        EditText drinkTimeEt_3 = findViewById(R.id.breed_drink_time_3);
        TextView waitngRatioTv_3 = findViewById(R.id.breed_wating_ratio_3);
        TextView drinkScoreTv_3 = findViewById(R.id.breed_drink_water_score_3);

        EditText totalCowEt_4 = findViewById(R.id.breed_total_cow_4);
        EditText waitngCowEt_4 = findViewById(R.id.breed_wating_cow_4);
        EditText drinkTimeEt_4 = findViewById(R.id.breed_drink_time_4);
        TextView waitngRatioTv_4 = findViewById(R.id.breed_wating_ratio_4);
        TextView drinkScoreTv_4 = findViewById(R.id.breed_drink_water_score_4);

        EditText totalCowEt_5 = findViewById(R.id.breed_total_cow_5);
        EditText waitngCowEt_5 = findViewById(R.id.breed_wating_cow_5);
        EditText drinkTimeEt_5 = findViewById(R.id.breed_drink_time_5);
        TextView waitngRatioTv_5 = findViewById(R.id.breed_wating_ratio_5);
        TextView drinkScoreTv_5 = findViewById(R.id.breed_drink_water_score_5);

        EditText totalCowEt_6 = findViewById(R.id.breed_total_cow_6);
        EditText waitngCowEt_6 = findViewById(R.id.breed_wating_cow_6);
        EditText drinkTimeEt_6 = findViewById(R.id.breed_drink_time_6);
        TextView waitngRatioTv_6 = findViewById(R.id.breed_wating_ratio_6);
        TextView drinkScoreTv_6 = findViewById(R.id.breed_drink_water_score_6);

        EditText totalCowEt_7 = findViewById(R.id.breed_total_cow_7);
        EditText waitngCowEt_7 = findViewById(R.id.breed_wating_cow_7);
        EditText drinkTimeEt_7 = findViewById(R.id.breed_drink_time_7);
        TextView waitngRatioTv_7 = findViewById(R.id.breed_wating_ratio_7);
        TextView drinkScoreTv_7 = findViewById(R.id.breed_drink_water_score_7);

        EditText totalCowEt_8 = findViewById(R.id.breed_total_cow_8);
        EditText waitngCowEt_8 = findViewById(R.id.breed_wating_cow_8);
        EditText drinkTimeEt_8 = findViewById(R.id.breed_drink_time_8);
        TextView waitngRatioTv_8 = findViewById(R.id.breed_wating_ratio_8);
        TextView drinkScoreTv_8 = findViewById(R.id.breed_drink_water_score_8);

        EditText totalCowEt_9 = findViewById(R.id.breed_total_cow_9);
        EditText waitngCowEt_9 = findViewById(R.id.breed_wating_cow_9);
        EditText drinkTimeEt_9 = findViewById(R.id.breed_drink_time_9);
        TextView waitngRatioTv_9 = findViewById(R.id.breed_wating_ratio_9);
        TextView drinkScoreTv_9 = findViewById(R.id.breed_drink_water_score_9);

        EditText totalCowEt_10 = findViewById(R.id.breed_total_cow_10);
        EditText waitngCowEt_10 = findViewById(R.id.breed_wating_cow_10);
        EditText drinkTimeEt_10 = findViewById(R.id.breed_drink_time_10);
        TextView waitngRatioTv_10 = findViewById(R.id.breed_wating_ratio_10);
        TextView drinkScoreTv_10 = findViewById(R.id.breed_drink_water_score_10);

        EditText totalCowEt_11 = findViewById(R.id.breed_total_cow_11);
        EditText waitngCowEt_11 = findViewById(R.id.breed_wating_cow_11);
        EditText drinkTimeEt_11 = findViewById(R.id.breed_drink_time_11);
        TextView waitngRatioTv_11 = findViewById(R.id.breed_wating_ratio_11);
        TextView drinkScoreTv_11 = findViewById(R.id.breed_drink_water_score_11);

        EditText totalCowEt_12 = findViewById(R.id.breed_total_cow_12);
        EditText waitngCowEt_12 = findViewById(R.id.breed_wating_cow_12);
        EditText drinkTimeEt_12 = findViewById(R.id.breed_drink_time_12);
        TextView waitngRatioTv_12 = findViewById(R.id.breed_wating_ratio_12);
        TextView drinkScoreTv_12 = findViewById(R.id.breed_drink_water_score_12);

        EditText totalCowEt_13 = findViewById(R.id.breed_total_cow_13);
        EditText waitngCowEt_13 = findViewById(R.id.breed_wating_cow_13);
        EditText drinkTimeEt_13 = findViewById(R.id.breed_drink_time_13);
        TextView waitngRatioTv_13 = findViewById(R.id.breed_wating_ratio_13);
        TextView drinkScoreTv_13 = findViewById(R.id.breed_drink_water_score_13);

        EditText totalCowEt_14 = findViewById(R.id.breed_total_cow_14);
        EditText waitngCowEt_14 = findViewById(R.id.breed_wating_cow_14);
        EditText drinkTimeEt_14 = findViewById(R.id.breed_drink_time_14);
        TextView waitngRatioTv_14 = findViewById(R.id.breed_wating_ratio_14);
        TextView drinkScoreTv_14 = findViewById(R.id.breed_drink_water_score_14);

        EditText totalCowEt_15 = findViewById(R.id.breed_total_cow_15);
        EditText waitngCowEt_15 = findViewById(R.id.breed_wating_cow_15);
        EditText drinkTimeEt_15 = findViewById(R.id.breed_drink_time_15);
        TextView waitngRatioTv_15 = findViewById(R.id.breed_wating_ratio_15);
        TextView drinkScoreTv_15 = findViewById(R.id.breed_drink_water_score_15);

        EditText totalCowEt_16 = findViewById(R.id.breed_total_cow_16);
        EditText waitngCowEt_16 = findViewById(R.id.breed_wating_cow_16);
        EditText drinkTimeEt_16 = findViewById(R.id.breed_drink_time_16);
        TextView waitngRatioTv_16 = findViewById(R.id.breed_wating_ratio_16);
        TextView drinkScoreTv_16 = findViewById(R.id.breed_drink_water_score_16);

        EditText totalCowEt_17 = findViewById(R.id.breed_total_cow_17);
        EditText waitngCowEt_17 = findViewById(R.id.breed_wating_cow_17);
        EditText drinkTimeEt_17 = findViewById(R.id.breed_drink_time_17);
        TextView waitngRatioTv_17 = findViewById(R.id.breed_wating_ratio_17);
        TextView drinkScoreTv_17 = findViewById(R.id.breed_drink_water_score_17);

        EditText totalCowEt_18 = findViewById(R.id.breed_total_cow_18);
        EditText waitngCowEt_18 = findViewById(R.id.breed_wating_cow_18);
        EditText drinkTimeEt_18 = findViewById(R.id.breed_drink_time_18);
        TextView waitngRatioTv_18 = findViewById(R.id.breed_wating_ratio_18);
        TextView drinkScoreTv_18 = findViewById(R.id.breed_drink_water_score_18);

        EditText totalCowEt_19 = findViewById(R.id.breed_total_cow_19);
        EditText waitngCowEt_19 = findViewById(R.id.breed_wating_cow_19);
        EditText drinkTimeEt_19 = findViewById(R.id.breed_drink_time_19);
        TextView waitngRatioTv_19 = findViewById(R.id.breed_wating_ratio_19);
        TextView drinkScoreTv_19 = findViewById(R.id.breed_drink_water_score_19);

        EditText totalCowEt_20 = findViewById(R.id.breed_total_cow_20);
        EditText waitngCowEt_20 = findViewById(R.id.breed_wating_cow_20);
        EditText drinkTimeEt_20 = findViewById(R.id.breed_drink_time_20);
        TextView waitngRatioTv_20 = findViewById(R.id.breed_wating_ratio_20);
        TextView drinkScoreTv_20 = findViewById(R.id.breed_drink_water_score_20);





        // 동 개수 만큼 화면 띄우기 ------------------------------------------------------------------------
        LinearLayout[] dong = {dong_1,dong_2,dong_3,dong_4,dong_5,dong_6,dong_7,dong_8,dong_9,dong_10,dong_11
                ,dong_12,dong_13,dong_14,dong_15,dong_16,dong_17,dong_18,dong_19,dong_20};


        for(int idx = 0 ; idx < dong_size ; idx++)
        {
            dong[idx].setVisibility(View.VISIBLE);
        }
        // --------------------------------------------------------------------------------------------------


        setTextView(totalCowEt_1,drinkTimeEt_1,waitngCowEt_1,waitngRatioTv_1,drinkScoreTv_1);
        setTextView(totalCowEt_2,drinkTimeEt_2,waitngCowEt_2,waitngRatioTv_2,drinkScoreTv_2);
        setTextView(totalCowEt_3,drinkTimeEt_3,waitngCowEt_3,waitngRatioTv_3,drinkScoreTv_3);
        setTextView(totalCowEt_4,drinkTimeEt_4,waitngCowEt_4,waitngRatioTv_4,drinkScoreTv_4);
        setTextView(totalCowEt_5,drinkTimeEt_5,waitngCowEt_5,waitngRatioTv_5,drinkScoreTv_5);
        setTextView(totalCowEt_6,drinkTimeEt_6,waitngCowEt_6,waitngRatioTv_6,drinkScoreTv_6);
        setTextView(totalCowEt_7,drinkTimeEt_7,waitngCowEt_7,waitngRatioTv_7,drinkScoreTv_7);
        setTextView(totalCowEt_8,drinkTimeEt_8,waitngCowEt_8,waitngRatioTv_8,drinkScoreTv_8);
        setTextView(totalCowEt_9,drinkTimeEt_9,waitngCowEt_9,waitngRatioTv_9,drinkScoreTv_9);
        setTextView(totalCowEt_10,drinkTimeEt_10,waitngCowEt_10,waitngRatioTv_10,drinkScoreTv_10);
        setTextView(totalCowEt_11,drinkTimeEt_11,waitngCowEt_11,waitngRatioTv_11,drinkScoreTv_11);
        setTextView(totalCowEt_12,drinkTimeEt_12,waitngCowEt_12,waitngRatioTv_12,drinkScoreTv_12);
        setTextView(totalCowEt_13,drinkTimeEt_13,waitngCowEt_13,waitngRatioTv_13,drinkScoreTv_13);
        setTextView(totalCowEt_14,drinkTimeEt_14,waitngCowEt_14,waitngRatioTv_14,drinkScoreTv_14);
        setTextView(totalCowEt_15,drinkTimeEt_15,waitngCowEt_15,waitngRatioTv_15,drinkScoreTv_15);
        setTextView(totalCowEt_16,drinkTimeEt_16,waitngCowEt_16,waitngRatioTv_16,drinkScoreTv_16);
        setTextView(totalCowEt_17,drinkTimeEt_17,waitngCowEt_17,waitngRatioTv_17,drinkScoreTv_17);
        setTextView(totalCowEt_18,drinkTimeEt_18,waitngCowEt_18,waitngRatioTv_18,drinkScoreTv_18);
        setTextView(totalCowEt_19,drinkTimeEt_19,waitngCowEt_19,waitngRatioTv_19,drinkScoreTv_19);
        setTextView(totalCowEt_20,drinkTimeEt_20,waitngCowEt_20,waitngRatioTv_20,drinkScoreTv_20);
        // -------------------------------------------------------------------------------------------------------

        // 완료 버튼
/*        breed_q4_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Arrays.sort(drinkScoreArray);
                int max = drinkScoreArray[drinkScoreArray.length-1];
                breed_Drink_Water_Score.setText(String.valueOf(max));
              // 이전 화면으로 돌아가기
            }
        });*/
    }

    public int getWaitingRatio(float total_cow, float wating_cow){
        float waitng_ratio = (wating_cow / total_cow) * 100;
        return Math.round((waitng_ratio));
    }
    public int getDrinkWaterScore(int waitng_ratio, int drink_time) {
        int drinkWaterScore = 0;
        if(waitng_ratio == 0 && drink_time <= 5){
            drinkWaterScore = 0;
        } else if(waitng_ratio <= 20 && drink_time <= 10) {
            drinkWaterScore = 1;
        } else {
            drinkWaterScore = 2;
        }
        return drinkWaterScore;
    }
    public void setWaitingRatio(EditText totalCowEt, EditText waitngCowEt, TextView watingRatioTv){
        int totalCow = Integer.parseInt(totalCowEt.getText().toString());
        int waitngCow = Integer.parseInt(waitngCowEt.getText().toString());
        int waitngRatio = getWaitingRatio(totalCow,waitngCow);
        watingRatioTv.setText(String.valueOf(waitngRatio));
    }
    public void setWaitingCowTv(EditText totalCowEt,EditText waitngCowEt,TextView waitngRatioTv){
        if (TextUtils.isEmpty(totalCowEt.getText().toString()) || TextUtils.isEmpty(waitngCowEt.getText().toString())) {
            waitngRatioTv.setText("값을 입력해주세요");
        } else{
            setWaitingRatio(totalCowEt,waitngCowEt,waitngRatioTv);
        }
    }
    public void setDrinkTimeTv(EditText waitingCowEt, EditText drinkTimeEt, EditText totalCowEt, TextView drinkScoreTv){
        int totalCow = 0;
        int waitingCow = 0;
        int drinkTime = 0;
        int drinkScore = 0;
        int waitingRatio = 0;

        if(!TextUtils.isEmpty(totalCowEt.getText())){
            totalCow = Integer.parseInt(totalCowEt.getText().toString());
        }
        if(!TextUtils.isEmpty(waitingCowEt.getText())){
            waitingCow = Integer.parseInt(waitingCowEt.getText().toString());
        }
        if(!TextUtils.isEmpty(drinkTimeEt.getText())){
            drinkTime = Integer.parseInt(drinkTimeEt.getText().toString());
        }

        if (TextUtils.isEmpty(waitingCowEt.getText().toString()) || TextUtils.isEmpty(drinkTimeEt.getText().toString()))   {
            drinkScoreTv.setText("값을 입력해주세요");
        } else{
            waitingRatio  = getWaitingRatio(totalCow,waitingCow);
            drinkScore = getDrinkWaterScore(waitingRatio, drinkTime);
            drinkScoreTv.setText(String.valueOf(drinkScore));
        }
    }
    public void setTextView(EditText totalCowEt, EditText drinkTimeEt, EditText waitingCowEt,
                            TextView waitingRatioTv, TextView drinkScoreTv){
        totalCowEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                setWaitingCowTv(totalCowEt,waitingCowEt,waitingRatioTv);
                setDrinkTimeTv(waitingCowEt, drinkTimeEt, totalCowEt,drinkScoreTv);
            }});
        waitingCowEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                setWaitingCowTv(totalCowEt,waitingCowEt,waitingRatioTv);
                setDrinkTimeTv(waitingCowEt, drinkTimeEt, totalCowEt,drinkScoreTv);
            }});

        drinkTimeEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                setDrinkTimeTv(waitingCowEt, drinkTimeEt, totalCowEt,drinkScoreTv);
            }});
    }

}



