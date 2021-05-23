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

public class Breed_struggle extends AppCompatActivity {
    private int dong_size;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breed_struggle);

        Intent intent = getIntent();

        dong_size = intent.getExtras().getInt("dong_count");


        LinearLayout dong_1 = findViewById(R.id.breed_dong_struggle_1);
        LinearLayout dong_2 = findViewById(R.id.breed_dong_struggle_2);
        LinearLayout dong_3 = findViewById(R.id.breed_dong_struggle_3);
        LinearLayout dong_4 = findViewById(R.id.breed_dong_struggle_4);
        LinearLayout dong_5 = findViewById(R.id.breed_dong_struggle_5);
        LinearLayout dong_6 = findViewById(R.id.breed_dong_struggle_6);
        LinearLayout dong_7 = findViewById(R.id.breed_dong_struggle_7);
        LinearLayout dong_8 = findViewById(R.id.breed_dong_struggle_8);
        LinearLayout dong_9 = findViewById(R.id.breed_dong_struggle_9);
        LinearLayout dong_10 = findViewById(R.id.breed_dong_struggle_10);
        LinearLayout dong_11 = findViewById(R.id.breed_dong_struggle_11);
        LinearLayout dong_12 = findViewById(R.id.breed_dong_struggle_12);
        LinearLayout[] dong = {dong_1,dong_2,dong_3,dong_4,dong_5,dong_6,dong_7,dong_8,dong_9,dong_10,dong_11
                ,dong_12};

        for(int idx = 0 ; idx < dong_size ; idx++)
        {
            dong[idx].setVisibility(View.VISIBLE);
        }

        EditText breed_struggle_total_ed_1 = findViewById(R.id.breed_struggle_total_1);
        EditText breed_struggle_ed_1 = findViewById(R.id.breed_struggle_1);
        TextView breed_struggle_ratio_tv_1 = findViewById(R.id.breed_struggle_ratio_1);

        EditText breed_struggle_total_ed_2 = findViewById(R.id.breed_struggle_total_2);
        EditText breed_struggle_ed_2 = findViewById(R.id.breed_struggle_2);
        TextView breed_struggle_ratio_tv_2 = findViewById(R.id.breed_struggle_ratio_2);

        EditText breed_struggle_total_ed_3 = findViewById(R.id.breed_struggle_total_3);
        EditText breed_struggle_ed_3 = findViewById(R.id.breed_struggle_3);
        TextView breed_struggle_ratio_tv_3 = findViewById(R.id.breed_struggle_ratio_3);

        EditText breed_struggle_total_ed_4 = findViewById(R.id.breed_struggle_total_4);
        EditText breed_struggle_ed_4 = findViewById(R.id.breed_struggle_4);
        TextView breed_struggle_ratio_tv_4 = findViewById(R.id.breed_struggle_ratio_4);

        EditText breed_struggle_total_ed_5 = findViewById(R.id.breed_struggle_total_5);
        EditText breed_struggle_ed_5 = findViewById(R.id.breed_struggle_5);
        TextView breed_struggle_ratio_tv_5 = findViewById(R.id.breed_struggle_ratio_5);

        EditText breed_struggle_total_ed_6 = findViewById(R.id.breed_struggle_total_6);
        EditText breed_struggle_ed_6 = findViewById(R.id.breed_struggle_6);
        TextView breed_struggle_ratio_tv_6 = findViewById(R.id.breed_struggle_ratio_6);

        EditText breed_struggle_total_ed_7 = findViewById(R.id.breed_struggle_total_7);
        EditText breed_struggle_ed_7 = findViewById(R.id.breed_struggle_7);
        TextView breed_struggle_ratio_tv_7 = findViewById(R.id.breed_struggle_ratio_7);

        EditText breed_struggle_total_ed_8 = findViewById(R.id.breed_struggle_total_8);
        EditText breed_struggle_ed_8 = findViewById(R.id.breed_struggle_8);
        TextView breed_struggle_ratio_tv_8 = findViewById(R.id.breed_struggle_ratio_8);

        EditText breed_struggle_total_ed_9 = findViewById(R.id.breed_struggle_total_9);
        EditText breed_struggle_ed_9 = findViewById(R.id.breed_struggle_9);
        TextView breed_struggle_ratio_tv_9 = findViewById(R.id.breed_struggle_ratio_9);

        EditText breed_struggle_total_ed_10 = findViewById(R.id.breed_struggle_total_10);
        EditText breed_struggle_ed_10 = findViewById(R.id.breed_struggle_10);
        TextView breed_struggle_ratio_tv_10 = findViewById(R.id.breed_struggle_ratio_10);

        EditText breed_struggle_total_ed_11 = findViewById(R.id.breed_struggle_total_11);
        EditText breed_struggle_ed_11 = findViewById(R.id.breed_struggle_11);
        TextView breed_struggle_ratio_tv_11 = findViewById(R.id.breed_struggle_ratio_11);

        EditText breed_struggle_total_ed_12 = findViewById(R.id.breed_struggle_total_12);
        EditText breed_struggle_ed_12 = findViewById(R.id.breed_struggle_12);
        TextView breed_struggle_ratio_tv_12 = findViewById(R.id.breed_struggle_ratio_12);

        setStruggleRatio(breed_struggle_total_ed_1,breed_struggle_ed_1,breed_struggle_ratio_tv_1);
        setStruggleRatio(breed_struggle_total_ed_2,breed_struggle_ed_2,breed_struggle_ratio_tv_2);
        setStruggleRatio(breed_struggle_total_ed_3,breed_struggle_ed_3,breed_struggle_ratio_tv_3);
        setStruggleRatio(breed_struggle_total_ed_4,breed_struggle_ed_4,breed_struggle_ratio_tv_4);
        setStruggleRatio(breed_struggle_total_ed_5,breed_struggle_ed_5,breed_struggle_ratio_tv_5);
        setStruggleRatio(breed_struggle_total_ed_6,breed_struggle_ed_6,breed_struggle_ratio_tv_6);
        setStruggleRatio(breed_struggle_total_ed_7,breed_struggle_ed_7,breed_struggle_ratio_tv_7);
        setStruggleRatio(breed_struggle_total_ed_8,breed_struggle_ed_8,breed_struggle_ratio_tv_8);
        setStruggleRatio(breed_struggle_total_ed_9,breed_struggle_ed_9,breed_struggle_ratio_tv_9);
        setStruggleRatio(breed_struggle_total_ed_10,breed_struggle_ed_10,breed_struggle_ratio_tv_10);
        setStruggleRatio(breed_struggle_total_ed_11,breed_struggle_ed_11,breed_struggle_ratio_tv_11);
        setStruggleRatio(breed_struggle_total_ed_12,breed_struggle_ed_12,breed_struggle_ratio_tv_12);

        TextView[] struggleRatioTvArr = {breed_struggle_ratio_tv_1,breed_struggle_ratio_tv_2,breed_struggle_ratio_tv_3,
                breed_struggle_ratio_tv_4,breed_struggle_ratio_tv_5,breed_struggle_ratio_tv_6,
                breed_struggle_ratio_tv_7,breed_struggle_ratio_tv_8,breed_struggle_ratio_tv_9,breed_struggle_ratio_tv_10,
                breed_struggle_ratio_tv_11,breed_struggle_ratio_tv_12};
        Button breed_struggle_button = findViewById(R.id.breed_struggle_button);
        int [] struggleRatioArr = new int[12];
        breed_struggle_button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                Boolean checkEmpty = false;
                int emptyDong = 0;
                for(int idx = 0; idx < dong_size ; idx++){
                    if(!isNumeric((String)struggleRatioTvArr[idx].getText())){
                        checkEmpty = true;
                        emptyDong = idx + 1;
                    }  else {
                        struggleRatioArr[idx] = Integer.parseInt((String) struggleRatioTvArr[idx].getText());
                    }
                }
                // 이전 화면으로 돌아가기 ( 빈 값 있는지 체크 )
                if(checkEmpty == true){
                    String msg = emptyDong + "동의 빈 값을 입력해주세요";
                    Toast.makeText(getApplicationContext(),msg, Toast.LENGTH_LONG ).show();
                } else {
                    int sum = Arrays.stream(struggleRatioArr).sum();
                    Intent intent = new Intent();
                    intent.putExtra("sum", sum);
                    setResult(0, intent);
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
    private void setStruggleRatio(EditText breed_struggle_total_ed, EditText breed_struggle_ed, TextView breed_struggle_ratio_tv){
        float pen_total_cow[] = new float[1];
        float struggle_count[] = new float[1];
        breed_struggle_total_ed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(TextUtils.isEmpty(breed_struggle_total_ed.getText()) || TextUtils.isEmpty(breed_struggle_ed.getText())){
                    breed_struggle_ratio_tv.setText("값을 입력하세요");
                } else{
                    pen_total_cow[0]  = Float.parseFloat(breed_struggle_total_ed.getText().toString());
                    struggle_count[0] = Float.parseFloat(breed_struggle_ed.getText().toString());
                    breed_struggle_ratio_tv.setText(String.valueOf(Math.round(struggle_count[0]/pen_total_cow[0])*6));
                }
            }
        });

        breed_struggle_ed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(TextUtils.isEmpty(breed_struggle_total_ed.getText()) || TextUtils.isEmpty(breed_struggle_ed.getText())){
                    breed_struggle_ratio_tv.setText("값을 입력하세요");
                } else{
                    pen_total_cow[0]  = Float.parseFloat(breed_struggle_total_ed.getText().toString());
                    struggle_count[0] = Float.parseFloat(breed_struggle_ed.getText().toString());
                    breed_struggle_ratio_tv.setText(String.valueOf(Math.round(struggle_count[0]/pen_total_cow[0])*6));

                }
            }
        });
    }
}