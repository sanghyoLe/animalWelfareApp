package com.example.animal_project.BreedBatch;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.animal_project.R;

import org.w3c.dom.Text;

import java.util.Arrays;

public class BreedWaterDongQ3 extends AppCompatActivity {
    private int dong_size;
    private ImageButton prev_dong_btn;
    private ImageButton next_dong_btn;
    private LinearLayout[] dong = new LinearLayout[20];
    private TextView breed_water_dong_current;
    private TextView breed_water_dong_total;
    private Button breed_dong_q3_btn;

    private int currentDong = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breed_water_dong_q3);

        Intent intent = getIntent();
        dong_size = intent.getExtras().getInt("dong_count");
        prev_dong_btn = findViewById(R.id.prev_dong_btn);
        next_dong_btn = findViewById(R.id.next_dong_btn);
        breed_dong_q3_btn = findViewById(R.id.breed_dong_q3_btn);

        breed_water_dong_current = findViewById(R.id.breed_water_dong_current);
        breed_water_dong_total = findViewById(R.id.breed_water_dong_total);


        LinearLayout dong_1 = findViewById(R.id.breed_dong_q3_1);
        LinearLayout dong_2 = findViewById(R.id.breed_dong_q3_2);
        LinearLayout dong_3 = findViewById(R.id.breed_dong_q3_3);
        LinearLayout dong_4 = findViewById(R.id.breed_dong_q3_4);
        LinearLayout dong_5 = findViewById(R.id.breed_dong_q3_5);
        LinearLayout dong_6 = findViewById(R.id.breed_dong_q3_6);
        LinearLayout dong_7 = findViewById(R.id.breed_dong_q3_7);
        LinearLayout dong_8 = findViewById(R.id.breed_dong_q3_8);
        LinearLayout dong_9 = findViewById(R.id.breed_dong_q3_9);
        LinearLayout dong_10 = findViewById(R.id.breed_dong_q3_10);
        LinearLayout dong_11 = findViewById(R.id.breed_dong_q3_11);
        LinearLayout dong_12 = findViewById(R.id.breed_dong_q3_12);
        LinearLayout dong_13 = findViewById(R.id.breed_dong_q3_13);
        LinearLayout dong_14 = findViewById(R.id.breed_dong_q3_14);
        LinearLayout dong_15 = findViewById(R.id.breed_dong_q3_15);
        LinearLayout dong_16 = findViewById(R.id.breed_dong_q3_16);
        LinearLayout dong_17 = findViewById(R.id.breed_dong_q3_17);
        LinearLayout dong_18 = findViewById(R.id.breed_dong_q3_18);
        LinearLayout dong_19 = findViewById(R.id.breed_dong_q3_19);
        LinearLayout dong_20 = findViewById(R.id.breed_dong_q3_20);
        // 1동
        EditText totalCowEt_1 = findViewById(R.id.breed_total_cow_1);
        EditText waitingCowEt_1 = findViewById(R.id.breed_waiting_cow_1);
        EditText drinkTimeEt_1 = findViewById(R.id.breed_drink_time_1);
        TextView waitingRatioTv_1 = findViewById(R.id.breed_waiting_ratio_1);
        TextView drinkScoreTv_1 = findViewById(R.id.breed_drink_water_score_1);
        // 
        EditText totalCowEt_2 = findViewById(R.id.breed_total_cow_2);
        EditText waitingCowEt_2 = findViewById(R.id.breed_waiting_cow_2);
        EditText drinkTimeEt_2 = findViewById(R.id.breed_drink_time_2);
        TextView waitingRatioTv_2 = findViewById(R.id.breed_waiting_ratio_2);
        TextView drinkScoreTv_2 = findViewById(R.id.breed_drink_water_score_2);

        EditText totalCowEt_3 = findViewById(R.id.breed_total_cow_3);
        EditText waitingCowEt_3 = findViewById(R.id.breed_waiting_cow_3);
        EditText drinkTimeEt_3 = findViewById(R.id.breed_drink_time_3);
        TextView waitingRatioTv_3 = findViewById(R.id.breed_waiting_ratio_3);
        TextView drinkScoreTv_3 = findViewById(R.id.breed_drink_water_score_3);

        EditText totalCowEt_4 = findViewById(R.id.breed_total_cow_4);
        EditText waitingCowEt_4 = findViewById(R.id.breed_waiting_cow_4);
        EditText drinkTimeEt_4 = findViewById(R.id.breed_drink_time_4);
        TextView waitingRatioTv_4 = findViewById(R.id.breed_waiting_ratio_4);
        TextView drinkScoreTv_4 = findViewById(R.id.breed_drink_water_score_4);

        EditText totalCowEt_5 = findViewById(R.id.breed_total_cow_5);
        EditText waitingCowEt_5 = findViewById(R.id.breed_waiting_cow_5);
        EditText drinkTimeEt_5 = findViewById(R.id.breed_drink_time_5);
        TextView waitingRatioTv_5 = findViewById(R.id.breed_waiting_ratio_5);
        TextView drinkScoreTv_5 = findViewById(R.id.breed_drink_water_score_5);

        EditText totalCowEt_6 = findViewById(R.id.breed_total_cow_6);
        EditText waitingCowEt_6 = findViewById(R.id.breed_waiting_cow_6);
        EditText drinkTimeEt_6 = findViewById(R.id.breed_drink_time_6);
        TextView waitingRatioTv_6 = findViewById(R.id.breed_waiting_ratio_6);
        TextView drinkScoreTv_6 = findViewById(R.id.breed_drink_water_score_6);

        EditText totalCowEt_7 = findViewById(R.id.breed_total_cow_7);
        EditText waitingCowEt_7 = findViewById(R.id.breed_waiting_cow_7);
        EditText drinkTimeEt_7 = findViewById(R.id.breed_drink_time_7);
        TextView waitingRatioTv_7 = findViewById(R.id.breed_waiting_ratio_7);
        TextView drinkScoreTv_7 = findViewById(R.id.breed_drink_water_score_7);

        EditText totalCowEt_8 = findViewById(R.id.breed_total_cow_8);
        EditText waitingCowEt_8 = findViewById(R.id.breed_waiting_cow_8);
        EditText drinkTimeEt_8 = findViewById(R.id.breed_drink_time_8);
        TextView waitingRatioTv_8 = findViewById(R.id.breed_waiting_ratio_8);
        TextView drinkScoreTv_8 = findViewById(R.id.breed_drink_water_score_8);

        EditText totalCowEt_9 = findViewById(R.id.breed_total_cow_9);
        EditText waitingCowEt_9 = findViewById(R.id.breed_waiting_cow_9);
        EditText drinkTimeEt_9 = findViewById(R.id.breed_drink_time_9);
        TextView waitingRatioTv_9 = findViewById(R.id.breed_waiting_ratio_9);
        TextView drinkScoreTv_9 = findViewById(R.id.breed_drink_water_score_9);

        EditText totalCowEt_10 = findViewById(R.id.breed_total_cow_10);
        EditText waitingCowEt_10 = findViewById(R.id.breed_waiting_cow_10);
        EditText drinkTimeEt_10 = findViewById(R.id.breed_drink_time_10);
        TextView waitingRatioTv_10 = findViewById(R.id.breed_waiting_ratio_10);
        TextView drinkScoreTv_10 = findViewById(R.id.breed_drink_water_score_10);

        EditText totalCowEt_11 = findViewById(R.id.breed_total_cow_11);
        EditText waitingCowEt_11 = findViewById(R.id.breed_waiting_cow_11);
        EditText drinkTimeEt_11 = findViewById(R.id.breed_drink_time_11);
        TextView waitingRatioTv_11 = findViewById(R.id.breed_waiting_ratio_11);
        TextView drinkScoreTv_11 = findViewById(R.id.breed_drink_water_score_11);

        EditText totalCowEt_12 = findViewById(R.id.breed_total_cow_12);
        EditText waitingCowEt_12 = findViewById(R.id.breed_waiting_cow_12);
        EditText drinkTimeEt_12 = findViewById(R.id.breed_drink_time_12);
        TextView waitingRatioTv_12 = findViewById(R.id.breed_waiting_ratio_12);
        TextView drinkScoreTv_12 = findViewById(R.id.breed_drink_water_score_12);

        EditText totalCowEt_13 = findViewById(R.id.breed_total_cow_13);
        EditText waitingCowEt_13 = findViewById(R.id.breed_waiting_cow_13);
        EditText drinkTimeEt_13 = findViewById(R.id.breed_drink_time_13);
        TextView waitingRatioTv_13 = findViewById(R.id.breed_waiting_ratio_13);
        TextView drinkScoreTv_13 = findViewById(R.id.breed_drink_water_score_13);

        EditText totalCowEt_14 = findViewById(R.id.breed_total_cow_14);
        EditText waitingCowEt_14 = findViewById(R.id.breed_waiting_cow_14);
        EditText drinkTimeEt_14 = findViewById(R.id.breed_drink_time_14);
        TextView waitingRatioTv_14 = findViewById(R.id.breed_waiting_ratio_14);
        TextView drinkScoreTv_14 = findViewById(R.id.breed_drink_water_score_14);

        EditText totalCowEt_15 = findViewById(R.id.breed_total_cow_15);
        EditText waitingCowEt_15 = findViewById(R.id.breed_waiting_cow_15);
        EditText drinkTimeEt_15 = findViewById(R.id.breed_drink_time_15);
        TextView waitingRatioTv_15 = findViewById(R.id.breed_waiting_ratio_15);
        TextView drinkScoreTv_15 = findViewById(R.id.breed_drink_water_score_15);

        EditText totalCowEt_16 = findViewById(R.id.breed_total_cow_16);
        EditText waitingCowEt_16 = findViewById(R.id.breed_waiting_cow_16);
        EditText drinkTimeEt_16 = findViewById(R.id.breed_drink_time_16);
        TextView waitingRatioTv_16 = findViewById(R.id.breed_waiting_ratio_16);
        TextView drinkScoreTv_16 = findViewById(R.id.breed_drink_water_score_16);

        EditText totalCowEt_17 = findViewById(R.id.breed_total_cow_17);
        EditText waitingCowEt_17 = findViewById(R.id.breed_waiting_cow_17);
        EditText drinkTimeEt_17 = findViewById(R.id.breed_drink_time_17);
        TextView waitingRatioTv_17 = findViewById(R.id.breed_waiting_ratio_17);
        TextView drinkScoreTv_17 = findViewById(R.id.breed_drink_water_score_17);

        EditText totalCowEt_18 = findViewById(R.id.breed_total_cow_18);
        EditText waitingCowEt_18 = findViewById(R.id.breed_waiting_cow_18);
        EditText drinkTimeEt_18 = findViewById(R.id.breed_drink_time_18);
        TextView waitingRatioTv_18 = findViewById(R.id.breed_waiting_ratio_18);
        TextView drinkScoreTv_18 = findViewById(R.id.breed_drink_water_score_18);

        EditText totalCowEt_19 = findViewById(R.id.breed_total_cow_19);
        EditText waitingCowEt_19 = findViewById(R.id.breed_waiting_cow_19);
        EditText drinkTimeEt_19 = findViewById(R.id.breed_drink_time_19);
        TextView waitingRatioTv_19 = findViewById(R.id.breed_waiting_ratio_19);
        TextView drinkScoreTv_19 = findViewById(R.id.breed_drink_water_score_19);

        EditText totalCowEt_20 = findViewById(R.id.breed_total_cow_20);
        EditText waitingCowEt_20 = findViewById(R.id.breed_waiting_cow_20);
        EditText drinkTimeEt_20 = findViewById(R.id.breed_drink_time_20);
        TextView waitingRatioTv_20 = findViewById(R.id.breed_waiting_ratio_20);
        TextView drinkScoreTv_20 = findViewById(R.id.breed_drink_water_score_20);


        dong = new LinearLayout[]{dong_1,dong_2,dong_3,dong_4,dong_5,dong_6,dong_7,dong_8,dong_9,dong_10,dong_11
                ,dong_12,dong_13,dong_14,dong_15,dong_16,dong_17,dong_18,dong_19,dong_20};
        EditText[] totalCowEtArr = {totalCowEt_1,totalCowEt_2,totalCowEt_3,totalCowEt_4,totalCowEt_5,totalCowEt_6,totalCowEt_7
        ,totalCowEt_8,totalCowEt_9,totalCowEt_10,totalCowEt_11,totalCowEt_12,totalCowEt_13,totalCowEt_14,totalCowEt_15,totalCowEt_16,
                totalCowEt_17,totalCowEt_18,totalCowEt_19,totalCowEt_20};
        TextView[] drinkScoreTvArr = { drinkScoreTv_1, drinkScoreTv_2, drinkScoreTv_3, drinkScoreTv_4, drinkScoreTv_5, drinkScoreTv_6, drinkScoreTv_7, drinkScoreTv_8, drinkScoreTv_9
                ,drinkScoreTv_10,drinkScoreTv_11,drinkScoreTv_12,drinkScoreTv_13,drinkScoreTv_14,drinkScoreTv_15,drinkScoreTv_16,drinkScoreTv_17,drinkScoreTv_18,drinkScoreTv_19,drinkScoreTv_20};

        setTextView(totalCowEt_1,drinkTimeEt_1,waitingCowEt_1,waitingRatioTv_1,drinkScoreTv_1);
        setTextView(totalCowEt_2,drinkTimeEt_2,waitingCowEt_2,waitingRatioTv_2,drinkScoreTv_2);
        setTextView(totalCowEt_3,drinkTimeEt_3,waitingCowEt_3,waitingRatioTv_3,drinkScoreTv_3);
        setTextView(totalCowEt_4,drinkTimeEt_4,waitingCowEt_4,waitingRatioTv_4,drinkScoreTv_4);
        setTextView(totalCowEt_5,drinkTimeEt_5,waitingCowEt_5,waitingRatioTv_5,drinkScoreTv_5);
        setTextView(totalCowEt_6,drinkTimeEt_6,waitingCowEt_6,waitingRatioTv_6,drinkScoreTv_6);
        setTextView(totalCowEt_7,drinkTimeEt_7,waitingCowEt_7,waitingRatioTv_7,drinkScoreTv_7);
        setTextView(totalCowEt_8,drinkTimeEt_8,waitingCowEt_8,waitingRatioTv_8,drinkScoreTv_8);
        setTextView(totalCowEt_9,drinkTimeEt_9,waitingCowEt_9,waitingRatioTv_9,drinkScoreTv_9);
        setTextView(totalCowEt_10,drinkTimeEt_10,waitingCowEt_10,waitingRatioTv_10,drinkScoreTv_10);
        setTextView(totalCowEt_11,drinkTimeEt_11,waitingCowEt_11,waitingRatioTv_11,drinkScoreTv_11);
        setTextView(totalCowEt_12,drinkTimeEt_12,waitingCowEt_12,waitingRatioTv_12,drinkScoreTv_12);
        setTextView(totalCowEt_13,drinkTimeEt_13,waitingCowEt_13,waitingRatioTv_13,drinkScoreTv_13);
        setTextView(totalCowEt_14,drinkTimeEt_14,waitingCowEt_14,waitingRatioTv_14,drinkScoreTv_14);
        setTextView(totalCowEt_15,drinkTimeEt_15,waitingCowEt_15,waitingRatioTv_15,drinkScoreTv_15);
        setTextView(totalCowEt_16,drinkTimeEt_16,waitingCowEt_16,waitingRatioTv_16,drinkScoreTv_16);
        setTextView(totalCowEt_17,drinkTimeEt_17,waitingCowEt_17,waitingRatioTv_17,drinkScoreTv_17);
        setTextView(totalCowEt_18,drinkTimeEt_18,waitingCowEt_18,waitingRatioTv_18,drinkScoreTv_18);
        setTextView(totalCowEt_19,drinkTimeEt_19,waitingCowEt_19,waitingRatioTv_19,drinkScoreTv_19);
        setTextView(totalCowEt_20,drinkTimeEt_20,waitingCowEt_20,waitingRatioTv_20,drinkScoreTv_20);

        breed_water_dong_total.setText(String.valueOf(dong_size));
        if(dong_size == 1){
            next_dong_btn.setVisibility(View.INVISIBLE);
            prev_dong_btn.setVisibility(View.INVISIBLE);
            breed_dong_q3_btn.setVisibility(View.VISIBLE);
        }

        // 완료 버튼

        int [] drinkScoreArr = new int[20];
        breed_dong_q3_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("click", "on");
                Boolean checkEmpty = false;
                int emptyDong = 0;
                for(int idx = 0; idx < dong_size ; idx++){
                    if(totalCowEtArr[idx].getText().toString().equals("")){
                        checkEmpty = true;
                        emptyDong = idx + 1;
                    }  else {
                        drinkScoreArr[idx] = Integer.parseInt((String) drinkScoreTvArr[idx].getText());
                    }
                }
                // 이전 화면으로 돌아가기 ( 빈 값 있는지 체크 )
                if(checkEmpty == true){
                    String msg = emptyDong + "동의 빈 값을 입력해주세요";
                    Toast.makeText(getApplicationContext(),msg, Toast.LENGTH_LONG ).show();
                } else {
                    Arrays.sort(drinkScoreArr);
                    int max = drinkScoreArr[drinkScoreArr.length-1];
                    Intent intent = new Intent();
                    intent.putExtra("key", max);
                    setResult(1, intent);
                    finish();
                }

            }
        });
    }
    public void clickDongHandler(View view)
    {

        switch(view.getId())
        {

            case R.id.next_dong_btn:
                if(currentDong == 0) {
                    prev_dong_btn.setVisibility(View.VISIBLE);
                }
                // 마지막 전 페이지
                if(currentDong + 2 == dong_size){
                    breed_dong_q3_btn.setVisibility(View.VISIBLE);
                    dong[currentDong].setVisibility(View.GONE);
                    dong[++currentDong].setVisibility(View.VISIBLE);
                    breed_water_dong_current.setText(String.valueOf(currentDong+1));
                    next_dong_btn.setVisibility(View.INVISIBLE);
                }
                else {
                    dong[currentDong].setVisibility(View.GONE);
                    dong[++currentDong].setVisibility(View.VISIBLE);
                    breed_water_dong_current.setText(String.valueOf(currentDong+1));
                }
                break;
            case R.id.prev_dong_btn:
                Log.d("currentDong",String.valueOf(currentDong));
                // 마지막 페이지에서 이전 버튼 눌렀을 때
                if(currentDong + 1 == dong_size){
                    next_dong_btn.setVisibility(View.VISIBLE);
                    breed_dong_q3_btn.setVisibility(View.INVISIBLE);
                }
                dong[currentDong].setVisibility(View.GONE);
                dong[--currentDong].setVisibility(View.VISIBLE);
                breed_water_dong_current.setText(String.valueOf(currentDong+1));

                if(currentDong == 1 || currentDong == 0){
                    prev_dong_btn.setVisibility(View.INVISIBLE);
                }
                Log.d("currentDong",String.valueOf(currentDong));
                break;

            case R.id.breed_water_dong_home_btn:
                super.onBackPressed();
        }




    }
    private int getWaitingRatio(float total_cow, float waiting_cow){
        float waiting_ratio = (waiting_cow / total_cow) * 100;
        return Math.round((waiting_ratio));
    }
    private int getDrinkWaterScore(int waiting_ratio, int drink_time) {
        int drinkWaterScore = 0;
        if(waiting_ratio == 0 && drink_time <= 5){
            drinkWaterScore = 0;
        } else if(waiting_ratio <= 20 && drink_time <= 10) {
            drinkWaterScore = 1;
        } else {
            drinkWaterScore = 2;
        }
        return drinkWaterScore;
    }
    private void setWaitingRatio(EditText totalCowEt, EditText waitingCowEt, TextView waitingRatioTv){
        int totalCow = Integer.parseInt(totalCowEt.getText().toString());
        int waitingCow = Integer.parseInt(waitingCowEt.getText().toString());
        int waitingRatio = getWaitingRatio(totalCow,waitingCow);
        waitingRatioTv.setText(String.valueOf(waitingRatio));
    }
    private void setWaitingCowTv(EditText totalCowEt,EditText waitingCowEt,TextView waitingRatioTv){
        if (TextUtils.isEmpty(totalCowEt.getText().toString()) || TextUtils.isEmpty(waitingCowEt.getText().toString())) {
            waitingRatioTv.setText("값을 입력해주세요");
        } else{
            setWaitingRatio(totalCowEt,waitingCowEt,waitingRatioTv);
        }
    }
    private void setDrinkTimeTv(EditText waitingCowEt, EditText drinkTimeEt, EditText totalCowEt, TextView drinkScoreTv){
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
    private void setTextView(EditText totalCowEt, EditText drinkTimeEt, EditText waitingCowEt,
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
    private static boolean isNumeric(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }
}
