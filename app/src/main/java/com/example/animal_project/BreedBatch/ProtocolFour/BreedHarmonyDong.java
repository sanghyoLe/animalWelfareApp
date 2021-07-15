package com.example.animal_project.BreedBatch.ProtocolFour;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.content.DialogInterface;
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

public class BreedHarmonyDong extends AppCompatActivity {
    private int dong_size;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breed_harmony_dong);
        QuestionTemplateViewModel viewModel = new ViewModelProvider(this).get(QuestionTemplateViewModel.class);

        Intent intent = getIntent();
        dong_size = intent.getExtras().getInt("dong_count");

        ImageButton prev_dong_btn = findViewById(R.id.prev_dong_q3_btn);
        ImageButton next_dong_btn = findViewById(R.id.next_dong_q3_btn_);
        TextView dong_current = findViewById(R.id.current_dong_q3);
        TextView dong_total = findViewById(R.id.total_dong_q3);
        Button dong_btn = findViewById(R.id.breed_dong_harmony_btn);
        ImageButton home_btn = findViewById(R.id.dong_home_q3_btn);


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

        LinearLayout[] dong = {dong_1,dong_2,dong_3,dong_4,dong_5,dong_6,dong_7,dong_8,dong_9,dong_10,dong_11
                ,dong_12};

        dong_total.setText(String.valueOf(dong_size));
        if(dong_size == 1){
            next_dong_btn.setVisibility(View.INVISIBLE);
            prev_dong_btn.setVisibility(View.INVISIBLE);
            dong_btn.setVisibility(View.VISIBLE);
        }
        viewModel.clickDongHandler(next_dong_btn,prev_dong_btn,dong_btn,dong,dong_current,dong_size);
        AlertDialog.Builder myAlterDialog = new AlertDialog.Builder(BreedHarmonyDong.this);
        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myOnBackPressed(myAlterDialog);
            }
        });
        // 완료 버튼
        EditText breed_total_cow_1_ed = findViewById(R.id.breed_total_cow_1);
        EditText breed_harmony_1_ed = findViewById(R.id.breed_harmony_1);
        TextView breed_harmony_ratio_1_tv = findViewById(R.id.breed_harmony_ratio_1);

        EditText breed_total_cow_2_ed = findViewById(R.id.breed_total_cow_2);
        EditText breed_harmony_2_ed = findViewById(R.id.breed_harmony_2);
        TextView breed_harmony_ratio_2_tv = findViewById(R.id.breed_harmony_ratio_2);

        EditText breed_total_cow_3_ed = findViewById(R.id.breed_total_cow_3);
        EditText breed_harmony_3_ed = findViewById(R.id.breed_harmony_3);
        TextView breed_harmony_ratio_3_tv = findViewById(R.id.breed_harmony_ratio_3);

        EditText breed_total_cow_4_ed = findViewById(R.id.breed_total_cow_4);
        EditText breed_harmony_4_ed = findViewById(R.id.breed_harmony_4);
        TextView breed_harmony_ratio_4_tv = findViewById(R.id.breed_harmony_ratio_4);

        EditText breed_total_cow_5_ed = findViewById(R.id.breed_total_cow_5);
        EditText breed_harmony_5_ed = findViewById(R.id.breed_harmony_5);
        TextView breed_harmony_ratio_5_tv = findViewById(R.id.breed_harmony_ratio_5);

        EditText breed_total_cow_6_ed = findViewById(R.id.breed_total_cow_6);
        EditText breed_harmony_6_ed = findViewById(R.id.breed_harmony_6);
        TextView breed_harmony_ratio_6_tv = findViewById(R.id.breed_harmony_ratio_6);

        EditText breed_total_cow_7_ed = findViewById(R.id.breed_total_cow_7);
        EditText breed_harmony_7_ed = findViewById(R.id.breed_harmony_7);
        TextView breed_harmony_ratio_7_tv = findViewById(R.id.breed_harmony_ratio_7);

        EditText breed_total_cow_8_ed = findViewById(R.id.breed_total_cow_8);
        EditText breed_harmony_8_ed = findViewById(R.id.breed_harmony_8);
        TextView breed_harmony_ratio_8_tv = findViewById(R.id.breed_harmony_ratio_8);

        EditText breed_total_cow_9_ed = findViewById(R.id.breed_total_cow_9);
        EditText breed_harmony_9_ed = findViewById(R.id.breed_harmony_9);
        TextView breed_harmony_ratio_9_tv = findViewById(R.id.breed_harmony_ratio_9);

        EditText breed_total_cow_10_ed = findViewById(R.id.breed_total_cow_10);
        EditText breed_harmony_10_ed = findViewById(R.id.breed_harmony_10);
        TextView breed_harmony_ratio_10_tv = findViewById(R.id.breed_harmony_ratio_10);

        EditText breed_total_cow_11_ed = findViewById(R.id.breed_total_cow_11);
        EditText breed_harmony_11_ed = findViewById(R.id.breed_harmony_11);
        TextView breed_harmony_ratio_11_tv = findViewById(R.id.breed_harmony_ratio_11);

        EditText breed_total_cow_12_ed = findViewById(R.id.breed_total_cow_12);
        EditText breed_harmony_12_ed = findViewById(R.id.breed_harmony_12);
        TextView breed_harmony_ratio_12_tv = findViewById(R.id.breed_harmony_ratio_12);


        setHarmonyRatio(breed_total_cow_1_ed,breed_harmony_1_ed,breed_harmony_ratio_1_tv);
        setHarmonyRatio(breed_total_cow_2_ed,breed_harmony_2_ed,breed_harmony_ratio_2_tv);
        setHarmonyRatio(breed_total_cow_3_ed,breed_harmony_3_ed,breed_harmony_ratio_3_tv);
        setHarmonyRatio(breed_total_cow_4_ed,breed_harmony_4_ed,breed_harmony_ratio_4_tv);
        setHarmonyRatio(breed_total_cow_5_ed,breed_harmony_5_ed,breed_harmony_ratio_5_tv);
        setHarmonyRatio(breed_total_cow_6_ed,breed_harmony_6_ed,breed_harmony_ratio_6_tv);
        setHarmonyRatio(breed_total_cow_7_ed,breed_harmony_7_ed,breed_harmony_ratio_7_tv);
        setHarmonyRatio(breed_total_cow_8_ed,breed_harmony_8_ed,breed_harmony_ratio_8_tv);
        setHarmonyRatio(breed_total_cow_9_ed,breed_harmony_9_ed,breed_harmony_ratio_9_tv);
        setHarmonyRatio(breed_total_cow_10_ed,breed_harmony_10_ed,breed_harmony_ratio_10_tv);
        setHarmonyRatio(breed_total_cow_11_ed,breed_harmony_11_ed,breed_harmony_ratio_11_tv);
        setHarmonyRatio(breed_total_cow_12_ed,breed_harmony_12_ed,breed_harmony_ratio_12_tv);
        EditText[] totalCowEtArr = {breed_total_cow_1_ed,breed_total_cow_2_ed,breed_total_cow_3_ed
                ,breed_total_cow_4_ed,breed_total_cow_5_ed,breed_total_cow_6_ed,breed_total_cow_7_ed
                ,breed_total_cow_8_ed,breed_total_cow_9_ed,breed_total_cow_10_ed
                ,breed_total_cow_11_ed,breed_total_cow_12_ed};

        TextView[] harmonyRatioTvArr = {breed_harmony_ratio_1_tv,breed_harmony_ratio_2_tv
                ,breed_harmony_ratio_3_tv, breed_harmony_ratio_4_tv,
                breed_harmony_ratio_5_tv,breed_harmony_ratio_6_tv,
                breed_harmony_ratio_7_tv,breed_harmony_ratio_8_tv,breed_harmony_ratio_9_tv,
                breed_harmony_ratio_10_tv, breed_harmony_ratio_11_tv,breed_harmony_ratio_12_tv};
        Button breed_harmony_button = findViewById(R.id.breed_dong_harmony_btn);
        double [] harmonyRatioArr = new double[12];
        breed_harmony_button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                Boolean checkEmpty = false;
                int emptyDong = 0;
                for(int idx = 0; idx < dong_size ; idx++){
                    if(totalCowEtArr[idx].getText().toString().equals("")){
                        checkEmpty = true;
                        emptyDong = idx + 1;
                    }  else {
                        harmonyRatioArr[idx] = Double.parseDouble((String) harmonyRatioTvArr[idx].getText());
                    }
                }
                // 이전 화면으로 돌아가기 ( 빈 값 있는지 체크 )
                if(checkEmpty == true){
                    String msg = emptyDong + "동의 빈 값을 입력해주세요";
                    Toast.makeText(getApplicationContext(),msg, Toast.LENGTH_LONG ).show();
                } else {
                    double sum = Arrays.stream(harmonyRatioArr).sum();
                    sum = sum / (double)dong_size;
                    sum = Math.round(sum*100)/ 100.0;
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
    private void setHarmonyRatio(EditText breed_total_cow, EditText breed_harmony_ed, TextView breed_harmony_ratio){
        double pen_total_cow[] = new double[1];
        double harmony_count[] = new double[1];
        breed_total_cow.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(TextUtils.isEmpty(breed_total_cow.getText()) || TextUtils.isEmpty(breed_harmony_ed.getText())){
                    breed_harmony_ratio.setText("값을 입력하세요");
                } else{
                    pen_total_cow[0]  = Double.parseDouble(breed_total_cow.getText().toString());
                    harmony_count[0] = Double.parseDouble(breed_harmony_ed.getText().toString());
                    double harmonyRatio = Math.round((harmony_count[0]/pen_total_cow[0])*100)/ 100.0;
                    harmonyRatio = harmonyRatio * 6;
                    harmonyRatio = Math.round(harmonyRatio);
                    breed_harmony_ratio.setText(String.valueOf(harmonyRatio));
                }
            }
        });

        breed_harmony_ed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(TextUtils.isEmpty(breed_total_cow.getText()) || TextUtils.isEmpty(breed_harmony_ed.getText())){
                    breed_harmony_ratio.setText("값을 입력하세요");
                } else{
                    pen_total_cow[0]  = Double.parseDouble(breed_total_cow.getText().toString());
                    harmony_count[0] = Double.parseDouble(breed_harmony_ed.getText().toString());
                    double harmonyRatio = Math.round((harmony_count[0]/pen_total_cow[0])*100)/ 100.0;
                    harmonyRatio = harmonyRatio * 6;
                    harmonyRatio = Math.round(harmonyRatio);
                    breed_harmony_ratio.setText(String.valueOf(harmonyRatio));

                }
            }
        });
    }
    public void myOnBackPressed(AlertDialog.Builder AlertBuilder){

        AlertBuilder.setTitle("이전");
        AlertBuilder.setMessage("지금까지 평가한 항목이 사라집니다.\n" +
                "평가 화면으로 돌아가시겠습니까?");
        // 버튼 추가 (Ok 버튼과 Cancle 버튼 )
        AlertBuilder.setPositiveButton("취소",new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog,int which){
                // OK 버튼을 눌렸을 경우

            }
        });
        AlertBuilder.setNegativeButton("네", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        AlertBuilder.show();
    }
}