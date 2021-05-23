package com.example.animal_project.BreedBatchQuestion;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.animal_project.R;

import java.util.Arrays;

public class Breed_harmony extends AppCompatActivity {
    private int dong_size;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breed_harmony);
        Intent intent = getIntent();
        dong_size = intent.getExtras().getInt("dong_count");
        LinearLayout dong_1 = findViewById(R.id.breed_dong_harmony_1);
        LinearLayout dong_2 = findViewById(R.id.breed_dong_harmony_2);
        LinearLayout dong_3 = findViewById(R.id.breed_dong_harmony_3);
        LinearLayout dong_4 = findViewById(R.id.breed_dong_harmony_4);
        LinearLayout dong_5 = findViewById(R.id.breed_dong_harmony_5);
        LinearLayout dong_6 = findViewById(R.id.breed_dong_harmony_6);
        LinearLayout dong_7 = findViewById(R.id.breed_dong_harmony_7);
        LinearLayout dong_8 = findViewById(R.id.breed_dong_harmony_8);
        LinearLayout dong_9 = findViewById(R.id.breed_dong_harmony_9);
        LinearLayout dong_10 = findViewById(R.id.breed_dong_harmony_10);
        LinearLayout dong_11 = findViewById(R.id.breed_dong_harmony_11);
        LinearLayout dong_12 = findViewById(R.id.breed_dong_harmony_12);

        EditText breed_harmony_total_ed_1 = findViewById(R.id.breed_harmony_total_1);
        EditText breed_harmony_ed_1 = findViewById(R.id.breed_harmony_1);
        TextView breed_harmony_ratio_tv_1 = findViewById(R.id.breed_harmony_ratio_1);

        EditText breed_harmony_total_ed_2 = findViewById(R.id.breed_harmony_total_2);
        EditText breed_harmony_ed_2 = findViewById(R.id.breed_harmony_2);
        TextView breed_harmony_ratio_tv_2 = findViewById(R.id.breed_harmony_ratio_2);

        EditText breed_harmony_total_ed_3 = findViewById(R.id.breed_harmony_total_3);
        EditText breed_harmony_ed_3 = findViewById(R.id.breed_harmony_3);
        TextView breed_harmony_ratio_tv_3 = findViewById(R.id.breed_harmony_ratio_3);

        EditText breed_harmony_total_ed_4 = findViewById(R.id.breed_harmony_total_4);
        EditText breed_harmony_ed_4 = findViewById(R.id.breed_harmony_4);
        TextView breed_harmony_ratio_tv_4 = findViewById(R.id.breed_harmony_ratio_4);

        EditText breed_harmony_total_ed_5 = findViewById(R.id.breed_harmony_total_5);
        EditText breed_harmony_ed_5 = findViewById(R.id.breed_harmony_5);
        TextView breed_harmony_ratio_tv_5 = findViewById(R.id.breed_harmony_ratio_5);

        EditText breed_harmony_total_ed_6 = findViewById(R.id.breed_harmony_total_6);
        EditText breed_harmony_ed_6 = findViewById(R.id.breed_harmony_6);
        TextView breed_harmony_ratio_tv_6 = findViewById(R.id.breed_harmony_ratio_6);

        EditText breed_harmony_total_ed_7 = findViewById(R.id.breed_harmony_total_7);
        EditText breed_harmony_ed_7 = findViewById(R.id.breed_harmony_7);
        TextView breed_harmony_ratio_tv_7 = findViewById(R.id.breed_harmony_ratio_7);

        EditText breed_harmony_total_ed_8 = findViewById(R.id.breed_harmony_total_8);
        EditText breed_harmony_ed_8 = findViewById(R.id.breed_harmony_8);
        TextView breed_harmony_ratio_tv_8 = findViewById(R.id.breed_harmony_ratio_8);

        EditText breed_harmony_total_ed_9 = findViewById(R.id.breed_harmony_total_9);
        EditText breed_harmony_ed_9 = findViewById(R.id.breed_harmony_9);
        TextView breed_harmony_ratio_tv_9 = findViewById(R.id.breed_harmony_ratio_9);

        EditText breed_harmony_total_ed_10 = findViewById(R.id.breed_harmony_total_10);
        EditText breed_harmony_ed_10 = findViewById(R.id.breed_harmony_10);
        TextView breed_harmony_ratio_tv_10 = findViewById(R.id.breed_harmony_ratio_10);

        EditText breed_harmony_total_ed_11 = findViewById(R.id.breed_harmony_total_11);
        EditText breed_harmony_ed_11 = findViewById(R.id.breed_harmony_11);
        TextView breed_harmony_ratio_tv_11 = findViewById(R.id.breed_harmony_ratio_11);

        EditText breed_harmony_total_ed_12 = findViewById(R.id.breed_harmony_total_12);
        EditText breed_harmony_ed_12 = findViewById(R.id.breed_harmony_12);
        TextView breed_harmony_ratio_tv_12 = findViewById(R.id.breed_harmony_ratio_12);

        setHarmonyRatio(breed_harmony_total_ed_1,breed_harmony_ed_1,breed_harmony_ratio_tv_1);
        setHarmonyRatio(breed_harmony_total_ed_2,breed_harmony_ed_2,breed_harmony_ratio_tv_2);
        setHarmonyRatio(breed_harmony_total_ed_3,breed_harmony_ed_3,breed_harmony_ratio_tv_3);
        setHarmonyRatio(breed_harmony_total_ed_4,breed_harmony_ed_4,breed_harmony_ratio_tv_4);
        setHarmonyRatio(breed_harmony_total_ed_5,breed_harmony_ed_5,breed_harmony_ratio_tv_5);
        setHarmonyRatio(breed_harmony_total_ed_6,breed_harmony_ed_6,breed_harmony_ratio_tv_6);
        setHarmonyRatio(breed_harmony_total_ed_7,breed_harmony_ed_7,breed_harmony_ratio_tv_7);
        setHarmonyRatio(breed_harmony_total_ed_8,breed_harmony_ed_8,breed_harmony_ratio_tv_8);
        setHarmonyRatio(breed_harmony_total_ed_9,breed_harmony_ed_9,breed_harmony_ratio_tv_9);
        setHarmonyRatio(breed_harmony_total_ed_10,breed_harmony_ed_10,breed_harmony_ratio_tv_10);
        setHarmonyRatio(breed_harmony_total_ed_11,breed_harmony_ed_11,breed_harmony_ratio_tv_11);
        setHarmonyRatio(breed_harmony_total_ed_12,breed_harmony_ed_12,breed_harmony_ratio_tv_12);

        LinearLayout[] dong = {dong_1,dong_2,dong_3,dong_4,dong_5,dong_6,dong_7,dong_8,dong_9,dong_10,dong_11
                ,dong_12};

        for(int idx = 0 ; idx < dong_size ; idx++)
        {
            dong[idx].setVisibility(View.VISIBLE);
        }

        TextView[] harmonyRatioTvArr = {breed_harmony_ratio_tv_1,breed_harmony_ratio_tv_2,breed_harmony_ratio_tv_3,
                breed_harmony_ratio_tv_4,breed_harmony_ratio_tv_5,breed_harmony_ratio_tv_6,
                breed_harmony_ratio_tv_7,breed_harmony_ratio_tv_8,breed_harmony_ratio_tv_9,breed_harmony_ratio_tv_10,
                breed_harmony_ratio_tv_11,breed_harmony_ratio_tv_12};
        Button breed_harmony_button = findViewById(R.id.breed_harmony_button);
        int [] harmonyRatioArr = new int[12];
        breed_harmony_button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                Boolean checkEmpty = false;
                int emptyDong = 0;
                for(int idx = 0; idx < dong_size ; idx++){
                    if(!isNumeric((String)harmonyRatioTvArr[idx].getText())){
                        checkEmpty = true;
                        emptyDong = idx + 1;
                    }  else {
                        harmonyRatioArr[idx] = Integer.parseInt((String) harmonyRatioTvArr[idx].getText());
                    }
                }
                // 이전 화면으로 돌아가기 ( 빈 값 있는지 체크 )
                if(checkEmpty == true){
                    String msg = emptyDong + "동의 빈 값을 입력해주세요";
                    Toast.makeText(getApplicationContext(),msg, Toast.LENGTH_LONG ).show();
                } else {
                    int sum = Arrays.stream(harmonyRatioArr).sum();
                    Intent intent = new Intent();
                    intent.putExtra("sum", sum);
                    setResult(1, intent);
                    finish();
                }

            }
        });
    }

    private static boolean isNumeric(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }
    private void setHarmonyRatio(EditText harmony_total_ed, EditText harmony_ed, TextView harmony_ratio_tv){
        float pen_total_cow[] = new float[1];
        float harmony_count[] = new float[1];
        harmony_total_ed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(TextUtils.isEmpty(harmony_total_ed.getText()) || TextUtils.isEmpty(harmony_ed.getText())){
                    harmony_ratio_tv.setText("값을 입력하세요");
                } else{
                    pen_total_cow[0]  = Float.parseFloat(harmony_total_ed.getText().toString());
                    harmony_count[0] = Float.parseFloat(harmony_ed.getText().toString());
                    harmony_ratio_tv.setText(String.valueOf(Math.round(harmony_count[0]/pen_total_cow[0])*6));
                }
            }
        });

        harmony_ed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(TextUtils.isEmpty(harmony_total_ed.getText()) || TextUtils.isEmpty(harmony_ed.getText())){
                    harmony_ratio_tv.setText("값을 입력하세요");
                } else{
                    pen_total_cow[0]  = Float.parseFloat(harmony_total_ed.getText().toString());
                    harmony_count[0] = Float.parseFloat(harmony_ed.getText().toString());
                    harmony_ratio_tv.setText(String.valueOf(Math.round(harmony_count[0]/pen_total_cow[0])*6));

                }
            }
        });
    }
}