package com.example.animal_project.BreedBatch;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;

import java.util.Arrays;

public class BreedCoughDong extends AppCompatActivity {
    private int dong_size;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breed_cough_dong);
        QuestionTemplateViewModel viewModel = new ViewModelProvider(this).get(QuestionTemplateViewModel.class);

        Intent intent = getIntent();
        dong_size = intent.getExtras().getInt("dong_count");

        ImageButton prev_dong_btn = findViewById(R.id.prev_dong_q3_btn);
        ImageButton next_dong_btn = findViewById(R.id.next_dong_q3_btn_);
        TextView dong_current = findViewById(R.id.current_dong_q3);
        TextView dong_total = findViewById(R.id.total_dong_q3);
        Button dong_btn = findViewById(R.id.breed_dong_cough_btn);
        ImageButton home_btn = findViewById(R.id.dong_home_q3_btn);


        LinearLayout dong_1 = findViewById(R.id.breed_dong_cough_1);
        LinearLayout dong_2 = findViewById(R.id.breed_dong_cough_2);
        LinearLayout dong_3 = findViewById(R.id.breed_dong_cough_3);
        LinearLayout dong_4 = findViewById(R.id.breed_dong_cough_4);
        LinearLayout dong_5 = findViewById(R.id.breed_dong_cough_5);
        LinearLayout dong_6 = findViewById(R.id.breed_dong_cough_6);
        LinearLayout dong_7 = findViewById(R.id.breed_dong_cough_7);
        LinearLayout dong_8 = findViewById(R.id.breed_dong_cough_8);
        LinearLayout dong_9 = findViewById(R.id.breed_dong_cough_9);
        LinearLayout dong_10 = findViewById(R.id.breed_dong_cough_10);
        LinearLayout dong_11 = findViewById(R.id.breed_dong_cough_11);
        LinearLayout dong_12 = findViewById(R.id.breed_dong_cough_12);
        LinearLayout dong_13 = findViewById(R.id.breed_dong_cough_13);
        LinearLayout dong_14 = findViewById(R.id.breed_dong_cough_14);
        LinearLayout dong_15 = findViewById(R.id.breed_dong_cough_15);
        LinearLayout dong_16 = findViewById(R.id.breed_dong_cough_16);
        LinearLayout dong_17 = findViewById(R.id.breed_dong_cough_17);
        LinearLayout dong_18 = findViewById(R.id.breed_dong_cough_18);
        LinearLayout dong_19 = findViewById(R.id.breed_dong_cough_19);
        LinearLayout dong_20 = findViewById(R.id.breed_dong_cough_20);
        LinearLayout[] dong = {dong_1,dong_2,dong_3,dong_4,dong_5,dong_6,dong_7,dong_8,dong_9,dong_10,dong_11
                ,dong_12,dong_13,dong_14,dong_15,dong_16,dong_17,dong_18,dong_19,dong_20};

        dong_total.setText(String.valueOf(dong_size));
        if(dong_size == 1){
            next_dong_btn.setVisibility(View.INVISIBLE);
            prev_dong_btn.setVisibility(View.INVISIBLE);
            dong_btn.setVisibility(View.VISIBLE);
        }
        viewModel.clickDongHandler(next_dong_btn,prev_dong_btn,dong_btn,dong,dong_current,dong_size);
        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        // 완료 버튼
        EditText breed_total_cow_1_ed = findViewById(R.id.breed_total_cow_1);
        EditText breed_cough_1_ed = findViewById(R.id.breed_cough_1);
        TextView breed_cough_ratio_1_tv = findViewById(R.id.breed_cough_ratio_1);

        EditText breed_total_cow_2_ed = findViewById(R.id.breed_total_cow_2);
        EditText breed_cough_2_ed = findViewById(R.id.breed_cough_2);
        TextView breed_cough_ratio_2_tv = findViewById(R.id.breed_cough_ratio_2);

        EditText breed_total_cow_3_ed = findViewById(R.id.breed_total_cow_3);
        EditText breed_cough_3_ed = findViewById(R.id.breed_cough_3);
        TextView breed_cough_ratio_3_tv = findViewById(R.id.breed_cough_ratio_3);

        EditText breed_total_cow_4_ed = findViewById(R.id.breed_total_cow_4);
        EditText breed_cough_4_ed = findViewById(R.id.breed_cough_4);
        TextView breed_cough_ratio_4_tv = findViewById(R.id.breed_cough_ratio_4);

        EditText breed_total_cow_5_ed = findViewById(R.id.breed_total_cow_5);
        EditText breed_cough_5_ed = findViewById(R.id.breed_cough_5);
        TextView breed_cough_ratio_5_tv = findViewById(R.id.breed_cough_ratio_5);

        EditText breed_total_cow_6_ed = findViewById(R.id.breed_total_cow_6);
        EditText breed_cough_6_ed = findViewById(R.id.breed_cough_6);
        TextView breed_cough_ratio_6_tv = findViewById(R.id.breed_cough_ratio_6);

        EditText breed_total_cow_7_ed = findViewById(R.id.breed_total_cow_7);
        EditText breed_cough_7_ed = findViewById(R.id.breed_cough_7);
        TextView breed_cough_ratio_7_tv = findViewById(R.id.breed_cough_ratio_7);

        EditText breed_total_cow_8_ed = findViewById(R.id.breed_total_cow_8);
        EditText breed_cough_8_ed = findViewById(R.id.breed_cough_8);
        TextView breed_cough_ratio_8_tv = findViewById(R.id.breed_cough_ratio_8);

        EditText breed_total_cow_9_ed = findViewById(R.id.breed_total_cow_9);
        EditText breed_cough_9_ed = findViewById(R.id.breed_cough_9);
        TextView breed_cough_ratio_9_tv = findViewById(R.id.breed_cough_ratio_9);

        EditText breed_total_cow_10_ed = findViewById(R.id.breed_total_cow_10);
        EditText breed_cough_10_ed = findViewById(R.id.breed_cough_10);
        TextView breed_cough_ratio_10_tv = findViewById(R.id.breed_cough_ratio_10);

        EditText breed_total_cow_11_ed = findViewById(R.id.breed_total_cow_11);
        EditText breed_cough_11_ed = findViewById(R.id.breed_cough_11);
        TextView breed_cough_ratio_11_tv = findViewById(R.id.breed_cough_ratio_11);

        EditText breed_total_cow_12_ed = findViewById(R.id.breed_total_cow_12);
        EditText breed_cough_12_ed = findViewById(R.id.breed_cough_12);
        TextView breed_cough_ratio_12_tv = findViewById(R.id.breed_cough_ratio_12);

        EditText breed_total_cow_13_ed = findViewById(R.id.breed_total_cow_13);
        EditText breed_cough_13_ed = findViewById(R.id.breed_cough_13);
        TextView breed_cough_ratio_13_tv = findViewById(R.id.breed_cough_ratio_13);

        EditText breed_total_cow_14_ed = findViewById(R.id.breed_total_cow_14);
        EditText breed_cough_14_ed = findViewById(R.id.breed_cough_14);
        TextView breed_cough_ratio_14_tv = findViewById(R.id.breed_cough_ratio_14);

        EditText breed_total_cow_15_ed = findViewById(R.id.breed_total_cow_15);
        EditText breed_cough_15_ed = findViewById(R.id.breed_cough_15);
        TextView breed_cough_ratio_15_tv = findViewById(R.id.breed_cough_ratio_15);

        EditText breed_total_cow_16_ed = findViewById(R.id.breed_total_cow_16);
        EditText breed_cough_16_ed = findViewById(R.id.breed_cough_16);
        TextView breed_cough_ratio_16_tv = findViewById(R.id.breed_cough_ratio_16);

        EditText breed_total_cow_17_ed = findViewById(R.id.breed_total_cow_17);
        EditText breed_cough_17_ed = findViewById(R.id.breed_cough_17);
        TextView breed_cough_ratio_17_tv = findViewById(R.id.breed_cough_ratio_17);

        EditText breed_total_cow_18_ed = findViewById(R.id.breed_total_cow_18);
        EditText breed_cough_18_ed = findViewById(R.id.breed_cough_18);
        TextView breed_cough_ratio_18_tv = findViewById(R.id.breed_cough_ratio_18);

        EditText breed_total_cow_19_ed = findViewById(R.id.breed_total_cow_19);
        EditText breed_cough_19_ed = findViewById(R.id.breed_cough_19);
        TextView breed_cough_ratio_19_tv = findViewById(R.id.breed_cough_ratio_19);

        EditText breed_total_cow_20_ed = findViewById(R.id.breed_total_cow_20);
        EditText breed_cough_20_ed = findViewById(R.id.breed_cough_20);
        TextView breed_cough_ratio_20_tv = findViewById(R.id.breed_cough_ratio_20);


        setCoughRatio(breed_total_cow_1_ed,breed_cough_1_ed,breed_cough_ratio_1_tv);
        setCoughRatio(breed_total_cow_2_ed,breed_cough_2_ed,breed_cough_ratio_2_tv);
        setCoughRatio(breed_total_cow_3_ed,breed_cough_3_ed,breed_cough_ratio_3_tv);
        setCoughRatio(breed_total_cow_4_ed,breed_cough_4_ed,breed_cough_ratio_4_tv);
        setCoughRatio(breed_total_cow_5_ed,breed_cough_5_ed,breed_cough_ratio_5_tv);
        setCoughRatio(breed_total_cow_6_ed,breed_cough_6_ed,breed_cough_ratio_6_tv);
        setCoughRatio(breed_total_cow_7_ed,breed_cough_7_ed,breed_cough_ratio_7_tv);
        setCoughRatio(breed_total_cow_8_ed,breed_cough_8_ed,breed_cough_ratio_8_tv);
        setCoughRatio(breed_total_cow_9_ed,breed_cough_9_ed,breed_cough_ratio_9_tv);
        setCoughRatio(breed_total_cow_10_ed,breed_cough_10_ed,breed_cough_ratio_10_tv);
        setCoughRatio(breed_total_cow_11_ed,breed_cough_11_ed,breed_cough_ratio_11_tv);
        setCoughRatio(breed_total_cow_12_ed,breed_cough_12_ed,breed_cough_ratio_12_tv);
        setCoughRatio(breed_total_cow_13_ed,breed_cough_13_ed,breed_cough_ratio_13_tv);
        setCoughRatio(breed_total_cow_14_ed,breed_cough_14_ed,breed_cough_ratio_14_tv);
        setCoughRatio(breed_total_cow_15_ed,breed_cough_15_ed,breed_cough_ratio_15_tv);
        setCoughRatio(breed_total_cow_16_ed,breed_cough_16_ed,breed_cough_ratio_16_tv);
        setCoughRatio(breed_total_cow_17_ed,breed_cough_17_ed,breed_cough_ratio_17_tv);
        setCoughRatio(breed_total_cow_18_ed,breed_cough_18_ed,breed_cough_ratio_18_tv);
        setCoughRatio(breed_total_cow_19_ed,breed_cough_19_ed,breed_cough_ratio_19_tv);
        setCoughRatio(breed_total_cow_20_ed,breed_cough_20_ed,breed_cough_ratio_20_tv);

        TextView[] coughRatioTvArr = {breed_cough_ratio_1_tv,breed_cough_ratio_2_tv,breed_cough_ratio_3_tv,breed_cough_ratio_4_tv,
                breed_cough_ratio_5_tv,breed_cough_ratio_6_tv,breed_cough_ratio_7_tv,breed_cough_ratio_8_tv,breed_cough_ratio_9_tv,
                breed_cough_ratio_10_tv,breed_cough_ratio_11_tv,breed_cough_ratio_12_tv,breed_cough_ratio_13_tv,breed_cough_ratio_14_tv,
                breed_cough_ratio_15_tv,breed_cough_ratio_16_tv,breed_cough_ratio_17_tv,breed_cough_ratio_18_tv,breed_cough_ratio_19_tv,
                breed_cough_ratio_20_tv,};
        Button breed_cough_button = findViewById(R.id.breed_dong_cough_btn);
        int [] coughRatioArr = new int[20];
        breed_cough_button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                Boolean checkEmpty = false;
                int emptyDong = 0;
                for(int idx = 0; idx < dong_size ; idx++){
                    if(!isNumeric((String)coughRatioTvArr[idx].getText())){
                        checkEmpty = true;
                        emptyDong = idx + 1;
                    }  else {
                        coughRatioArr[idx] = Integer.parseInt((String) coughRatioTvArr[idx].getText());
                    }
                }
                // 이전 화면으로 돌아가기 ( 빈 값 있는지 체크 )
                if(checkEmpty == true){
                    String msg = emptyDong + "동의 빈 값을 입력해주세요";
                    Toast.makeText(getApplicationContext(),msg, Toast.LENGTH_LONG ).show();
                } else {
                    int sum = Arrays.stream(coughRatioArr).sum();
                    Intent intent = new Intent();
                    intent.putExtra("key", sum);
                    setResult(1, intent);
                    finish();
                }

            }
        });
    }

    private void setCoughRatio(EditText breed_total_cow_ed, EditText breed_cough_ed, TextView breed_cough_ratio_tv){
        float pen_total_cow[] = new float[1];
        float cough_count[] = new float[1];
        breed_total_cow_ed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(TextUtils.isEmpty(breed_total_cow_ed.getText()) || TextUtils.isEmpty(breed_cough_ed.getText())){
                    breed_cough_ratio_tv.setText("값을 입력해주세요");
                } else{
                    pen_total_cow[0]  = Float.parseFloat(breed_total_cow_ed.getText().toString());
                    cough_count[0] = Float.parseFloat(breed_cough_ed.getText().toString());
                    breed_cough_ratio_tv.setText(String.valueOf(Math.round(cough_count[0]/pen_total_cow[0])));
                }
            }
        });

        breed_cough_ed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(TextUtils.isEmpty(breed_total_cow_ed.getText()) || TextUtils.isEmpty(breed_cough_ed.getText())){
                    breed_cough_ratio_tv.setText("값을 입력해주세요");
                } else{
                    pen_total_cow[0]  = Float.parseFloat(breed_total_cow_ed.getText().toString());
                    cough_count[0] = Float.parseFloat(breed_cough_ed.getText().toString());
                    breed_cough_ratio_tv.setText(String.valueOf(Math.round(cough_count[0]/pen_total_cow[0])));

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
}