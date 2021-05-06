package com.example.animal_project.MilkCow_Question;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.animal_project.R;

import java.util.Arrays;

public class Freestall_q4 extends AppCompatActivity {
    private View view;
    int stable_dong;
    String result;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.freestall_q4);

        //축사동 수 spinner 입력 받아 데이터 값 받아옴
        Intent intent = getIntent();
        result = intent.getStringExtra("water_Tank_Clean_Num");
        stable_dong = Integer.parseInt(result);

        Button freestall_q4_btn = findViewById(R.id.freestall_q4_btn);
        TextView freestall_Drink_Water_Score = findViewById(R.id.freestall_Drink_Water_Score);

        LinearLayout stable1 = findViewById(R.id.freestall_dong_q4_1);
        LinearLayout stable2 = findViewById(R.id.freestall_dong_q4_2);
        LinearLayout stable3 = findViewById(R.id.freestall_dong_q4_3);
        LinearLayout stable4 = findViewById(R.id.freestall_dong_q4_4);
        LinearLayout stable5 = findViewById(R.id.freestall_dong_q4_5);
        LinearLayout stable6 = findViewById(R.id.freestall_dong_q4_6);
        LinearLayout stable7 = findViewById(R.id.freestall_dong_q4_7);
        LinearLayout stable8 = findViewById(R.id.freestall_dong_q4_8);
        LinearLayout stable9 = findViewById(R.id.freestall_dong_q4_9);
        LinearLayout stable10 = findViewById(R.id.freestall_dong_q4_10);
        LinearLayout stable11 = findViewById(R.id.freestall_dong_q4_11);
        LinearLayout stable12 = findViewById(R.id.freestall_dong_q4_12);
        LinearLayout stable13 = findViewById(R.id.freestall_dong_q4_13);
        LinearLayout stable14 = findViewById(R.id.freestall_dong_q4_14);
        LinearLayout stable15 = findViewById(R.id.freestall_dong_q4_15);
        LinearLayout stable16 = findViewById(R.id.freestall_dong_q4_16);
        LinearLayout stable17 = findViewById(R.id.freestall_dong_q4_17);
        LinearLayout stable18 = findViewById(R.id.freestall_dong_q4_18);
        LinearLayout stable19 = findViewById(R.id.freestall_dong_q4_19);
        LinearLayout stable20 = findViewById(R.id.freestall_dong_q4_20);

        // 1동
        EditText totalCowEt_1 = findViewById(R.id.freestall_total_cow_1);
        EditText waitngCowEt_1 = findViewById(R.id.freestall_wating_cow_1);
        EditText drinkTimeEt_1 = findViewById(R.id.freestall_drink_time_1);
        TextView waitngRatioTv_1 = findViewById(R.id.freestall_wating_ratio_1);
        TextView drinkScoreTv_1 = findViewById(R.id.freestall_drink_water_score_1);
        // 2동
        EditText totalCowEt_2 = findViewById(R.id.freestall_total_cow_2);
        EditText waitngCowEt_2 = findViewById(R.id.freestall_wating_cow_2);
        EditText drinkTimeEt_2 = findViewById(R.id.freestall_drink_time_2);
        TextView waitngRatioTv_2 = findViewById(R.id.freestall_wating_ratio_2);
        TextView drinkScoreTv_2 = findViewById(R.id.freestall_drink_water_score_2);

        EditText totalCowEt_3 = findViewById(R.id.freestall_total_cow_3);
        EditText waitngCowEt_3 = findViewById(R.id.freestall_wating_cow_3);
        EditText drinkTimeEt_3 = findViewById(R.id.freestall_drink_time_3);
        TextView waitngRatioTv_3 = findViewById(R.id.freestall_wating_ratio_3);
        TextView drinkScoreTv_3 = findViewById(R.id.freestall_drink_water_score_3);

        EditText totalCowEt_4 = findViewById(R.id.freestall_total_cow_4);
        EditText waitngCowEt_4 = findViewById(R.id.freestall_wating_cow_4);
        EditText drinkTimeEt_4 = findViewById(R.id.freestall_drink_time_4);
        TextView waitngRatioTv_4 = findViewById(R.id.freestall_wating_ratio_4);
        TextView drinkScoreTv_4 = findViewById(R.id.freestall_drink_water_score_4);

        EditText totalCowEt_5 = findViewById(R.id.freestall_total_cow_5);
        EditText waitngCowEt_5 = findViewById(R.id.freestall_wating_cow_5);
        EditText drinkTimeEt_5 = findViewById(R.id.freestall_drink_time_5);
        TextView waitngRatioTv_5 = findViewById(R.id.freestall_wating_ratio_5);
        TextView drinkScoreTv_5 = findViewById(R.id.freestall_drink_water_score_5);

        EditText totalCowEt_6 = findViewById(R.id.freestall_total_cow_6);
        EditText waitngCowEt_6 = findViewById(R.id.freestall_wating_cow_6);
        EditText drinkTimeEt_6 = findViewById(R.id.freestall_drink_time_6);
        TextView waitngRatioTv_6 = findViewById(R.id.freestall_wating_ratio_6);
        TextView drinkScoreTv_6 = findViewById(R.id.freestall_drink_water_score_6);

        EditText totalCowEt_7 = findViewById(R.id.freestall_total_cow_7);
        EditText waitngCowEt_7 = findViewById(R.id.freestall_wating_cow_7);
        EditText drinkTimeEt_7 = findViewById(R.id.freestall_drink_time_7);
        TextView waitngRatioTv_7 = findViewById(R.id.freestall_wating_ratio_7);
        TextView drinkScoreTv_7 = findViewById(R.id.freestall_drink_water_score_7);

        EditText totalCowEt_8 = findViewById(R.id.freestall_total_cow_8);
        EditText waitngCowEt_8 = findViewById(R.id.freestall_wating_cow_8);
        EditText drinkTimeEt_8 = findViewById(R.id.freestall_drink_time_8);
        TextView waitngRatioTv_8 = findViewById(R.id.freestall_wating_ratio_8);
        TextView drinkScoreTv_8 = findViewById(R.id.freestall_drink_water_score_8);

        EditText totalCowEt_9 = findViewById(R.id.freestall_total_cow_9);
        EditText waitngCowEt_9 = findViewById(R.id.freestall_wating_cow_9);
        EditText drinkTimeEt_9 = findViewById(R.id.freestall_drink_time_9);
        TextView waitngRatioTv_9 = findViewById(R.id.freestall_wating_ratio_9);
        TextView drinkScoreTv_9 = findViewById(R.id.freestall_drink_water_score_9);

        EditText totalCowEt_10 = findViewById(R.id.freestall_total_cow_10);
        EditText waitngCowEt_10 = findViewById(R.id.freestall_wating_cow_10);
        EditText drinkTimeEt_10 = findViewById(R.id.freestall_drink_time_10);
        TextView waitngRatioTv_10 = findViewById(R.id.freestall_wating_ratio_10);
        TextView drinkScoreTv_10 = findViewById(R.id.freestall_drink_water_score_10);

        EditText totalCowEt_11 = findViewById(R.id.freestall_total_cow_11);
        EditText waitngCowEt_11 = findViewById(R.id.freestall_wating_cow_11);
        EditText drinkTimeEt_11 = findViewById(R.id.freestall_drink_time_11);
        TextView waitngRatioTv_11 = findViewById(R.id.freestall_wating_ratio_11);
        TextView drinkScoreTv_11 = findViewById(R.id.freestall_drink_water_score_11);

        EditText totalCowEt_12 = findViewById(R.id.freestall_total_cow_12);
        EditText waitngCowEt_12 = findViewById(R.id.freestall_wating_cow_12);
        EditText drinkTimeEt_12 = findViewById(R.id.freestall_drink_time_12);
        TextView waitngRatioTv_12 = findViewById(R.id.freestall_wating_ratio_12);
        TextView drinkScoreTv_12 = findViewById(R.id.freestall_drink_water_score_12);

        EditText totalCowEt_13 = findViewById(R.id.freestall_total_cow_13);
        EditText waitngCowEt_13 = findViewById(R.id.freestall_wating_cow_13);
        EditText drinkTimeEt_13 = findViewById(R.id.freestall_drink_time_13);
        TextView waitngRatioTv_13 = findViewById(R.id.freestall_wating_ratio_13);
        TextView drinkScoreTv_13 = findViewById(R.id.freestall_drink_water_score_13);

        EditText totalCowEt_14 = findViewById(R.id.freestall_total_cow_14);
        EditText waitngCowEt_14 = findViewById(R.id.freestall_wating_cow_14);
        EditText drinkTimeEt_14 = findViewById(R.id.freestall_drink_time_14);
        TextView waitngRatioTv_14 = findViewById(R.id.freestall_wating_ratio_14);
        TextView drinkScoreTv_14 = findViewById(R.id.freestall_drink_water_score_14);

        EditText totalCowEt_15 = findViewById(R.id.freestall_total_cow_15);
        EditText waitngCowEt_15 = findViewById(R.id.freestall_wating_cow_15);
        EditText drinkTimeEt_15 = findViewById(R.id.freestall_drink_time_15);
        TextView waitngRatioTv_15 = findViewById(R.id.freestall_wating_ratio_15);
        TextView drinkScoreTv_15 = findViewById(R.id.freestall_drink_water_score_15);

        EditText totalCowEt_16 = findViewById(R.id.freestall_total_cow_16);
        EditText waitngCowEt_16 = findViewById(R.id.freestall_wating_cow_16);
        EditText drinkTimeEt_16 = findViewById(R.id.freestall_drink_time_16);
        TextView waitngRatioTv_16 = findViewById(R.id.freestall_wating_ratio_16);
        TextView drinkScoreTv_16 = findViewById(R.id.freestall_drink_water_score_16);

        EditText totalCowEt_17 = findViewById(R.id.freestall_total_cow_17);
        EditText waitngCowEt_17 = findViewById(R.id.freestall_wating_cow_17);
        EditText drinkTimeEt_17 = findViewById(R.id.freestall_drink_time_17);
        TextView waitngRatioTv_17 = findViewById(R.id.freestall_wating_ratio_17);
        TextView drinkScoreTv_17 = findViewById(R.id.freestall_drink_water_score_17);

        EditText totalCowEt_18 = findViewById(R.id.freestall_total_cow_18);
        EditText waitngCowEt_18 = findViewById(R.id.freestall_wating_cow_18);
        EditText drinkTimeEt_18 = findViewById(R.id.freestall_drink_time_18);
        TextView waitngRatioTv_18 = findViewById(R.id.freestall_wating_ratio_18);
        TextView drinkScoreTv_18 = findViewById(R.id.freestall_drink_water_score_18);

        EditText totalCowEt_19 = findViewById(R.id.freestall_total_cow_19);
        EditText waitngCowEt_19 = findViewById(R.id.freestall_wating_cow_19);
        EditText drinkTimeEt_19 = findViewById(R.id.freestall_drink_time_19);
        TextView waitngRatioTv_19 = findViewById(R.id.freestall_wating_ratio_19);
        TextView drinkScoreTv_19 = findViewById(R.id.freestall_drink_water_score_19);

        EditText totalCowEt_20 = findViewById(R.id.freestall_total_cow_20);
        EditText waitngCowEt_20 = findViewById(R.id.freestall_wating_cow_20);
        EditText drinkTimeEt_20 = findViewById(R.id.freestall_drink_time_20);
        TextView waitngRatioTv_20 = findViewById(R.id.freestall_wating_ratio_20);
        TextView drinkScoreTv_20 = findViewById(R.id.freestall_drink_water_score_20);

        LinearLayout[] stable = {stable1, stable2, stable3, stable4, stable5, stable6, stable7, stable8, stable9, stable10, stable11, stable12, stable13, stable14, stable15, stable16, stable17, stable18, stable19, stable20};
        //----------------------축사동 수에 따라 setVisibility.ViSIBLE-------------------------
        for(int i=0; i<stable_dong; i++) {
            stable[i].setVisibility(view.VISIBLE);
        }
        //------------------------------------------------------------------------------------

        int[] drinkScoreArray = new int[20];

        // 1동 음수 행동 간이 측정 점수 계산  -----------------------------------------------------------------
        waitngCowEt_1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                setWaitingCowEt(totalCowEt_1,waitngCowEt_1,waitngRatioTv_1);
            }});
        drinkTimeEt_1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                if (TextUtils.isEmpty(waitngCowEt_1.getText().toString()) || TextUtils.isEmpty(drinkTimeEt_1.getText().toString()))   {
                    drinkScoreTv_1.setText("값을 입력해주세요");
                } else{
                    drinkScoreArray[0] = setDrinkWaterScore(totalCowEt_1,waitngCowEt_1,drinkTimeEt_1,waitngRatioTv_1,drinkScoreTv_1);
                }

            }});
        // -------------------------------------------------------------------------------------------------------
        waitngCowEt_2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                setWaitingCowEt(totalCowEt_2,waitngCowEt_2,waitngRatioTv_2);
            }});
        drinkTimeEt_2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                if (TextUtils.isEmpty(waitngCowEt_2.getText().toString()) || TextUtils.isEmpty(drinkTimeEt_2.getText().toString()))   {
                    drinkScoreTv_2.setText("값을 입력해주세요");
                } else{
                    drinkScoreArray[1] =setDrinkWaterScore(totalCowEt_2,waitngCowEt_2,drinkTimeEt_2,waitngRatioTv_2,drinkScoreTv_2);
                }

            }});

        // -------------------------------------------------------------------------------------------------------
        waitngCowEt_3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i3) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                setWaitingCowEt(totalCowEt_3,waitngCowEt_3,waitngRatioTv_3);
            }});
        drinkTimeEt_3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i3) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                if (TextUtils.isEmpty(waitngCowEt_3.getText().toString()) || TextUtils.isEmpty(drinkTimeEt_3.getText().toString()))   {
                    drinkScoreTv_3.setText("값을 입력해주세요");
                } else{
                    drinkScoreArray[2] =setDrinkWaterScore(totalCowEt_3,waitngCowEt_3,drinkTimeEt_3,waitngRatioTv_3,drinkScoreTv_3);
                }

            }});

        // -------------------------------------------------------------------------------------------------------
        waitngCowEt_4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i4) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                setWaitingCowEt(totalCowEt_4,waitngCowEt_4,waitngRatioTv_4);
            }});
        drinkTimeEt_4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i4) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                if (TextUtils.isEmpty(waitngCowEt_4.getText().toString()) || TextUtils.isEmpty(drinkTimeEt_4.getText().toString()))   {
                    drinkScoreTv_4.setText("값을 입력해주세요");
                } else{
                    drinkScoreArray[3] =setDrinkWaterScore(totalCowEt_4,waitngCowEt_4,drinkTimeEt_4,waitngRatioTv_4,drinkScoreTv_4);
                }

            }});

        // -------------------------------------------------------------------------------------------------------
        waitngCowEt_5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i5) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                setWaitingCowEt(totalCowEt_5,waitngCowEt_5,waitngRatioTv_5);
            }});
        drinkTimeEt_5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i5) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                if (TextUtils.isEmpty(waitngCowEt_5.getText().toString()) || TextUtils.isEmpty(drinkTimeEt_5.getText().toString()))   {
                    drinkScoreTv_5.setText("값을 입력해주세요");
                } else{
                    drinkScoreArray[4] =setDrinkWaterScore(totalCowEt_5,waitngCowEt_5,drinkTimeEt_5,waitngRatioTv_5,drinkScoreTv_5);
                }

            }});

        // -------------------------------------------------------------------------------------------------------
        waitngCowEt_6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i6) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                setWaitingCowEt(totalCowEt_6,waitngCowEt_6,waitngRatioTv_6);
            }});
        drinkTimeEt_6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i6) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                if (TextUtils.isEmpty(waitngCowEt_6.getText().toString()) || TextUtils.isEmpty(drinkTimeEt_6.getText().toString()))   {
                    drinkScoreTv_6.setText("값을 입력해주세요");
                } else{
                    drinkScoreArray[5] =setDrinkWaterScore(totalCowEt_6,waitngCowEt_6,drinkTimeEt_6,waitngRatioTv_6,drinkScoreTv_6);
                }

            }});

        // -------------------------------------------------------------------------------------------------------
        waitngCowEt_7.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i7) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                setWaitingCowEt(totalCowEt_7,waitngCowEt_7,waitngRatioTv_7);
            }});
        drinkTimeEt_7.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i7) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                if (TextUtils.isEmpty(waitngCowEt_7.getText().toString()) || TextUtils.isEmpty(drinkTimeEt_7.getText().toString()))   {
                    drinkScoreTv_7.setText("값을 입력해주세요");
                } else{
                    drinkScoreArray[6] =setDrinkWaterScore(totalCowEt_7,waitngCowEt_7,drinkTimeEt_7,waitngRatioTv_7,drinkScoreTv_7);
                }

            }});

        // -------------------------------------------------------------------------------------------------------
        waitngCowEt_8.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i8) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                setWaitingCowEt(totalCowEt_8,waitngCowEt_8,waitngRatioTv_8);
            }});
        drinkTimeEt_8.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i8) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                if (TextUtils.isEmpty(waitngCowEt_8.getText().toString()) || TextUtils.isEmpty(drinkTimeEt_8.getText().toString()))   {
                    drinkScoreTv_8.setText("값을 입력해주세요");
                } else{
                    drinkScoreArray[7] =setDrinkWaterScore(totalCowEt_8,waitngCowEt_8,drinkTimeEt_8,waitngRatioTv_8,drinkScoreTv_8);
                }

            }});

        // -------------------------------------------------------------------------------------------------------
        waitngCowEt_9.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i9) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                setWaitingCowEt(totalCowEt_9,waitngCowEt_9,waitngRatioTv_9);
            }});
        drinkTimeEt_9.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i9) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                if (TextUtils.isEmpty(waitngCowEt_9.getText().toString()) || TextUtils.isEmpty(drinkTimeEt_9.getText().toString()))   {
                    drinkScoreTv_9.setText("값을 입력해주세요");
                } else{
                    drinkScoreArray[8] =setDrinkWaterScore(totalCowEt_9,waitngCowEt_9,drinkTimeEt_9,waitngRatioTv_9,drinkScoreTv_9);
                }

            }});

        // -------------------------------------------------------------------------------------------------------
        waitngCowEt_10.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i10) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                setWaitingCowEt(totalCowEt_10,waitngCowEt_10,waitngRatioTv_10);
            }});
        drinkTimeEt_10.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i10) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                if (TextUtils.isEmpty(waitngCowEt_10.getText().toString()) || TextUtils.isEmpty(drinkTimeEt_10.getText().toString()))   {
                    drinkScoreTv_10.setText("값을 입력해주세요");
                } else{
                    drinkScoreArray[9] =setDrinkWaterScore(totalCowEt_10,waitngCowEt_10,drinkTimeEt_10,waitngRatioTv_10,drinkScoreTv_10);
                }

            }});

        // -------------------------------------------------------------------------------------------------------
        waitngCowEt_11.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i11) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                setWaitingCowEt(totalCowEt_11,waitngCowEt_11,waitngRatioTv_11);
            }});
        drinkTimeEt_11.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i11) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                if (TextUtils.isEmpty(waitngCowEt_11.getText().toString()) || TextUtils.isEmpty(drinkTimeEt_11.getText().toString()))   {
                    drinkScoreTv_11.setText("값을 입력해주세요");
                } else{
                    drinkScoreArray[10] =setDrinkWaterScore(totalCowEt_11,waitngCowEt_11,drinkTimeEt_11,waitngRatioTv_11,drinkScoreTv_11);
                }

            }});

        // -------------------------------------------------------------------------------------------------------
        waitngCowEt_12.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i12) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                setWaitingCowEt(totalCowEt_12,waitngCowEt_12,waitngRatioTv_12);
            }});
        drinkTimeEt_12.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i12) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                if (TextUtils.isEmpty(waitngCowEt_12.getText().toString()) || TextUtils.isEmpty(drinkTimeEt_12.getText().toString()))   {
                    drinkScoreTv_12.setText("값을 입력해주세요");
                } else{
                    drinkScoreArray[11] =setDrinkWaterScore(totalCowEt_12,waitngCowEt_12,drinkTimeEt_12,waitngRatioTv_12,drinkScoreTv_12);
                }

            }});

        // -------------------------------------------------------------------------------------------------------
        waitngCowEt_13.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i13) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                setWaitingCowEt(totalCowEt_13,waitngCowEt_13,waitngRatioTv_13);
            }});
        drinkTimeEt_13.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i13) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                if (TextUtils.isEmpty(waitngCowEt_13.getText().toString()) || TextUtils.isEmpty(drinkTimeEt_13.getText().toString()))   {
                    drinkScoreTv_13.setText("값을 입력해주세요");
                } else{
                    drinkScoreArray[12] =setDrinkWaterScore(totalCowEt_13,waitngCowEt_13,drinkTimeEt_13,waitngRatioTv_13,drinkScoreTv_13);
                }

            }});

        // -------------------------------------------------------------------------------------------------------
        waitngCowEt_14.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i14) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                setWaitingCowEt(totalCowEt_14,waitngCowEt_14,waitngRatioTv_14);
            }});
        drinkTimeEt_14.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i14) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                if (TextUtils.isEmpty(waitngCowEt_14.getText().toString()) || TextUtils.isEmpty(drinkTimeEt_14.getText().toString()))   {
                    drinkScoreTv_14.setText("값을 입력해주세요");
                } else{
                    drinkScoreArray[13] =setDrinkWaterScore(totalCowEt_14,waitngCowEt_14,drinkTimeEt_14,waitngRatioTv_14,drinkScoreTv_14);
                }

            }});

        // -------------------------------------------------------------------------------------------------------
        waitngCowEt_15.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i15) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                setWaitingCowEt(totalCowEt_15,waitngCowEt_15,waitngRatioTv_15);
            }});
        drinkTimeEt_15.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i15) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                if (TextUtils.isEmpty(waitngCowEt_15.getText().toString()) || TextUtils.isEmpty(drinkTimeEt_15.getText().toString()))   {
                    drinkScoreTv_15.setText("값을 입력해주세요");
                } else{
                    drinkScoreArray[14] =setDrinkWaterScore(totalCowEt_15,waitngCowEt_15,drinkTimeEt_15,waitngRatioTv_15,drinkScoreTv_15);
                }

            }});

        // -------------------------------------------------------------------------------------------------------
        waitngCowEt_16.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i16) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                setWaitingCowEt(totalCowEt_16,waitngCowEt_16,waitngRatioTv_16);
            }});
        drinkTimeEt_16.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i16) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                if (TextUtils.isEmpty(waitngCowEt_16.getText().toString()) || TextUtils.isEmpty(drinkTimeEt_16.getText().toString()))   {
                    drinkScoreTv_16.setText("값을 입력해주세요");
                } else{
                    drinkScoreArray[15] =setDrinkWaterScore(totalCowEt_16,waitngCowEt_16,drinkTimeEt_16,waitngRatioTv_16,drinkScoreTv_16);
                }

            }});

        // -------------------------------------------------------------------------------------------------------
        waitngCowEt_17.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i17) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                setWaitingCowEt(totalCowEt_17,waitngCowEt_17,waitngRatioTv_17);
            }});
        drinkTimeEt_17.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i17) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                if (TextUtils.isEmpty(waitngCowEt_17.getText().toString()) || TextUtils.isEmpty(drinkTimeEt_17.getText().toString()))   {
                    drinkScoreTv_17.setText("값을 입력해주세요");
                } else{
                    drinkScoreArray[16] =setDrinkWaterScore(totalCowEt_17,waitngCowEt_17,drinkTimeEt_17,waitngRatioTv_17,drinkScoreTv_17);
                }

            }});

        // -------------------------------------------------------------------------------------------------------
        waitngCowEt_18.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i18) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                setWaitingCowEt(totalCowEt_18,waitngCowEt_18,waitngRatioTv_18);
            }});
        drinkTimeEt_18.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i18) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                if (TextUtils.isEmpty(waitngCowEt_18.getText().toString()) || TextUtils.isEmpty(drinkTimeEt_18.getText().toString()))   {
                    drinkScoreTv_18.setText("값을 입력해주세요");
                } else{
                    drinkScoreArray[17] =setDrinkWaterScore(totalCowEt_18,waitngCowEt_18,drinkTimeEt_18,waitngRatioTv_18,drinkScoreTv_18);
                }

            }});

        // -------------------------------------------------------------------------------------------------------
        waitngCowEt_19.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i19) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                setWaitingCowEt(totalCowEt_19,waitngCowEt_19,waitngRatioTv_19);
            }});
        drinkTimeEt_19.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i19) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                if (TextUtils.isEmpty(waitngCowEt_19.getText().toString()) || TextUtils.isEmpty(drinkTimeEt_19.getText().toString()))   {
                    drinkScoreTv_19.setText("값을 입력해주세요");
                } else{
                    drinkScoreArray[18] =setDrinkWaterScore(totalCowEt_19,waitngCowEt_19,drinkTimeEt_19,waitngRatioTv_19,drinkScoreTv_19);
                }

            }});


        waitngCowEt_20.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i20) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                setWaitingCowEt(totalCowEt_20,waitngCowEt_20,waitngRatioTv_20);
            }});
        drinkTimeEt_20.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i20) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                if (TextUtils.isEmpty(waitngCowEt_20.getText().toString()) || TextUtils.isEmpty(drinkTimeEt_20.getText().toString()))   {
                    drinkScoreTv_20.setText("값을 입력해주세요");
                } else{
                    drinkScoreArray[19] =setDrinkWaterScore(totalCowEt_20,waitngCowEt_20,drinkTimeEt_20,waitngRatioTv_20,drinkScoreTv_20);
                }
            }});

        // 완료 버튼
        freestall_q4_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Arrays.sort(drinkScoreArray);
                int max = drinkScoreArray[drinkScoreArray.length-1];

                freestall_Drink_Water_Score.setText(String.valueOf(max));
                // 이전 화면으로 돌아가기
            }
        });
        Log.d("파라미터값: ", result);
    }
    public int getWatingRatio(float total_cow, float wating_cow){
        float waitng_ratio = (wating_cow / total_cow) * 100;
        return Math.round((waitng_ratio));
    }
    public int getDrinkWaterScore(int waitng_ratio, int drink_time)
    {
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
    public void setWatingRatio(EditText totalCowEt, EditText waitngCowEt, TextView watingRatioTv){
        int totalCow = Integer.parseInt(totalCowEt.getText().toString());
        int waitngCow = Integer.parseInt(waitngCowEt.getText().toString());
        int waitngRatio = getWatingRatio(totalCow,waitngCow);
        watingRatioTv.setText(String.valueOf(waitngRatio));
    }
    public int setDrinkWaterScore(EditText totalCowEt, EditText waitngCowEt, EditText drinkTimeEt, TextView watingRatioTv,TextView drinkScoreTv){
        int totalCow = Integer.parseInt(totalCowEt.getText().toString());
        int waitngCow = Integer.parseInt(waitngCowEt.getText().toString());
        int drinkTime = Integer.parseInt(drinkTimeEt.getText().toString());
        int waitngRatio = getWatingRatio(totalCow,waitngCow);
        int drinkScore = getDrinkWaterScore(waitngRatio,drinkTime);
        drinkScoreTv.setText(String.valueOf(drinkScore));

        return drinkScore;
    }
    public void setWaitingCowEt(EditText totalCowEt,EditText waitngCowEt,TextView waitngRatioTv){
        if (TextUtils.isEmpty(waitngCowEt.getText().toString()) || TextUtils.isEmpty(waitngCowEt.getText().toString())) {
            waitngRatioTv.setText("값을 입력해주세요");
        } else{
            setWatingRatio(totalCowEt,waitngCowEt,waitngRatioTv);
        }
    }
}