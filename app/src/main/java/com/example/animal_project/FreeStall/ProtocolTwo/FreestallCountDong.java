package com.example.animal_project.FreeStall.ProtocolTwo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
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

import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;

import java.util.Arrays;

public class FreestallCountDong extends AppCompatActivity {
    private int dong_size;
    private ImageButton prev_dong_btn;
    private ImageButton next_dong_btn;
    private ImageButton home_btn;
    private LinearLayout[] dong = new LinearLayout[20];
    private TextView freestall_dong_current;
    private TextView freestall_dong_total;
    private Button freestall_dong_btn;

    private int currentDong = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_freestall_count_dong);
        QuestionTemplateViewModel viewModel = new ViewModelProvider(this).get(QuestionTemplateViewModel.class);
        Intent intent = getIntent();
        dong_size = intent.getExtras().getInt("dong_count");

        prev_dong_btn = findViewById(R.id.prev_dong_btn);
        next_dong_btn = findViewById(R.id.next_dong_btn);
        freestall_dong_btn = findViewById(R.id.freestall_dong_btn);
        home_btn = findViewById(R.id.dong_home_btn);

        freestall_dong_current = findViewById(R.id.current_dong);
        freestall_dong_total = findViewById(R.id.total_dong);


        LinearLayout dong_1 = findViewById(R.id.freestall_dong_1);
        LinearLayout dong_2 = findViewById(R.id.freestall_dong_2);
        LinearLayout dong_3 = findViewById(R.id.freestall_dong_3);
        LinearLayout dong_4 = findViewById(R.id.freestall_dong_4);
        LinearLayout dong_5 = findViewById(R.id.freestall_dong_5);
        LinearLayout dong_6 = findViewById(R.id.freestall_dong_6);
        LinearLayout dong_7 = findViewById(R.id.freestall_dong_7);
        LinearLayout dong_8 = findViewById(R.id.freestall_dong_8);
        LinearLayout dong_9 = findViewById(R.id.freestall_dong_9);
        LinearLayout dong_10 = findViewById(R.id.freestall_dong_10);
        LinearLayout dong_11 = findViewById(R.id.freestall_dong_11);
        LinearLayout dong_12 = findViewById(R.id.freestall_dong_12);
        LinearLayout dong_13 = findViewById(R.id.freestall_dong_13);
        LinearLayout dong_14 = findViewById(R.id.freestall_dong_14);
        LinearLayout dong_15 = findViewById(R.id.freestall_dong_15);
        LinearLayout dong_16 = findViewById(R.id.freestall_dong_16);
        LinearLayout dong_17 = findViewById(R.id.freestall_dong_17);
        LinearLayout dong_18 = findViewById(R.id.freestall_dong_18);
        LinearLayout dong_19 = findViewById(R.id.freestall_dong_19);
        LinearLayout dong_20 = findViewById(R.id.freestall_dong_20);
        // 1동
        EditText cowCountEt_1 = findViewById(R.id.freestall_cow_count_1);
        EditText cowAvailableEt_1 = findViewById(R.id.freestall_cow_available_1);
        TextView countRatioTv_1 = findViewById(R.id.freestall_count_ratio_1);
        TextView countScoreTv_1 = findViewById(R.id.freestall_count_score_1);
        //
        EditText cowCountEt_2 = findViewById(R.id.freestall_cow_count_2);
        EditText cowAvailableEt_2 = findViewById(R.id.freestall_cow_available_2);
        TextView countRatioTv_2 = findViewById(R.id.freestall_count_ratio_2);
        TextView countScoreTv_2 = findViewById(R.id.freestall_count_score_2);
        //
        EditText cowCountEt_3 = findViewById(R.id.freestall_cow_count_3);
        EditText cowAvailableEt_3 = findViewById(R.id.freestall_cow_available_3);
        TextView countRatioTv_3 = findViewById(R.id.freestall_count_ratio_3);
        TextView countScoreTv_3 = findViewById(R.id.freestall_count_score_3);
        //
        EditText cowCountEt_4 = findViewById(R.id.freestall_cow_count_4);
        EditText cowAvailableEt_4 = findViewById(R.id.freestall_cow_available_4);
        TextView countRatioTv_4 = findViewById(R.id.freestall_count_ratio_4);
        TextView countScoreTv_4 = findViewById(R.id.freestall_count_score_4);
        //
        EditText cowCountEt_5 = findViewById(R.id.freestall_cow_count_5);
        EditText cowAvailableEt_5 = findViewById(R.id.freestall_cow_available_5);
        TextView countRatioTv_5 = findViewById(R.id.freestall_count_ratio_5);
        TextView countScoreTv_5 = findViewById(R.id.freestall_count_score_5);
        //
        EditText cowCountEt_6 = findViewById(R.id.freestall_cow_count_6);
        EditText cowAvailableEt_6 = findViewById(R.id.freestall_cow_available_6);
        TextView countRatioTv_6 = findViewById(R.id.freestall_count_ratio_6);
        TextView countScoreTv_6 = findViewById(R.id.freestall_count_score_6);
        //
        EditText cowCountEt_7 = findViewById(R.id.freestall_cow_count_7);
        EditText cowAvailableEt_7 = findViewById(R.id.freestall_cow_available_7);
        TextView countRatioTv_7 = findViewById(R.id.freestall_count_ratio_7);
        TextView countScoreTv_7 = findViewById(R.id.freestall_count_score_7);
        //
        EditText cowCountEt_8 = findViewById(R.id.freestall_cow_count_8);
        EditText cowAvailableEt_8 = findViewById(R.id.freestall_cow_available_8);
        TextView countRatioTv_8 = findViewById(R.id.freestall_count_ratio_8);
        TextView countScoreTv_8 = findViewById(R.id.freestall_count_score_8);
        //
        EditText cowCountEt_9 = findViewById(R.id.freestall_cow_count_9);
        EditText cowAvailableEt_9 = findViewById(R.id.freestall_cow_available_9);
        TextView countRatioTv_9 = findViewById(R.id.freestall_count_ratio_9);
        TextView countScoreTv_9 = findViewById(R.id.freestall_count_score_9);
        //
        EditText cowCountEt_10 = findViewById(R.id.freestall_cow_count_10);
        EditText cowAvailableEt_10 = findViewById(R.id.freestall_cow_available_10);
        TextView countRatioTv_10 = findViewById(R.id.freestall_count_ratio_10);
        TextView countScoreTv_10 = findViewById(R.id.freestall_count_score_10);
        //
        EditText cowCountEt_11 = findViewById(R.id.freestall_cow_count_11);
        EditText cowAvailableEt_11 = findViewById(R.id.freestall_cow_available_11);
        TextView countRatioTv_11 = findViewById(R.id.freestall_count_ratio_11);
        TextView countScoreTv_11 = findViewById(R.id.freestall_count_score_11);
        //
        EditText cowCountEt_12 = findViewById(R.id.freestall_cow_count_12);
        EditText cowAvailableEt_12 = findViewById(R.id.freestall_cow_available_12);
        TextView countRatioTv_12 = findViewById(R.id.freestall_count_ratio_12);
        TextView countScoreTv_12 = findViewById(R.id.freestall_count_score_12);
        //
        EditText cowCountEt_13 = findViewById(R.id.freestall_cow_count_13);
        EditText cowAvailableEt_13 = findViewById(R.id.freestall_cow_available_13);
        TextView countRatioTv_13 = findViewById(R.id.freestall_count_ratio_13);
        TextView countScoreTv_13 = findViewById(R.id.freestall_count_score_13);
        //
        EditText cowCountEt_14 = findViewById(R.id.freestall_cow_count_14);
        EditText cowAvailableEt_14 = findViewById(R.id.freestall_cow_available_14);
        TextView countRatioTv_14 = findViewById(R.id.freestall_count_ratio_14);
        TextView countScoreTv_14 = findViewById(R.id.freestall_count_score_14);
        //
        EditText cowCountEt_15 = findViewById(R.id.freestall_cow_count_15);
        EditText cowAvailableEt_15 = findViewById(R.id.freestall_cow_available_15);
        TextView countRatioTv_15 = findViewById(R.id.freestall_count_ratio_15);
        TextView countScoreTv_15 = findViewById(R.id.freestall_count_score_15);
        //
        EditText cowCountEt_16 = findViewById(R.id.freestall_cow_count_16);
        EditText cowAvailableEt_16 = findViewById(R.id.freestall_cow_available_16);
        TextView countRatioTv_16 = findViewById(R.id.freestall_count_ratio_16);
        TextView countScoreTv_16 = findViewById(R.id.freestall_count_score_16);
        //
        EditText cowCountEt_17 = findViewById(R.id.freestall_cow_count_17);
        EditText cowAvailableEt_17 = findViewById(R.id.freestall_cow_available_17);
        TextView countRatioTv_17 = findViewById(R.id.freestall_count_ratio_17);
        TextView countScoreTv_17 = findViewById(R.id.freestall_count_score_17);
        //
        EditText cowCountEt_18 = findViewById(R.id.freestall_cow_count_18);
        EditText cowAvailableEt_18 = findViewById(R.id.freestall_cow_available_18);
        TextView countRatioTv_18 = findViewById(R.id.freestall_count_ratio_18);
        TextView countScoreTv_18 = findViewById(R.id.freestall_count_score_18);
        //
        EditText cowCountEt_19 = findViewById(R.id.freestall_cow_count_19);
        EditText cowAvailableEt_19 = findViewById(R.id.freestall_cow_available_19);
        TextView countRatioTv_19 = findViewById(R.id.freestall_count_ratio_19);
        TextView countScoreTv_19 = findViewById(R.id.freestall_count_score_19);
        //
        EditText cowCountEt_20 = findViewById(R.id.freestall_cow_count_20);
        EditText cowAvailableEt_20 = findViewById(R.id.freestall_cow_available_20);
        TextView countRatioTv_20 = findViewById(R.id.freestall_count_ratio_20);
        TextView countScoreTv_20 = findViewById(R.id.freestall_count_score_20);


        dong = new LinearLayout[]{dong_1,dong_2,dong_3,dong_4,dong_5,dong_6,dong_7,dong_8,dong_9,dong_10,dong_11
                ,dong_12,dong_13,dong_14,dong_15,dong_16,dong_17,dong_18,dong_19,dong_20};
        EditText[] countCowEtArr = {cowCountEt_1,cowCountEt_2,cowCountEt_3,cowCountEt_4,cowCountEt_5,cowCountEt_6,cowCountEt_7
                ,cowCountEt_8,cowCountEt_9,cowCountEt_10,cowCountEt_11,cowCountEt_12,cowCountEt_13,cowCountEt_14,cowCountEt_15,cowCountEt_16,
                cowCountEt_17,cowCountEt_18,cowCountEt_19,cowCountEt_20};
        TextView[] countScoreTvArr = { countScoreTv_1, countScoreTv_2, countScoreTv_3, countScoreTv_4, countScoreTv_5, countScoreTv_6, countScoreTv_7, countScoreTv_8, countScoreTv_9
                ,countScoreTv_10,countScoreTv_11,countScoreTv_12,countScoreTv_13,countScoreTv_14,countScoreTv_15,countScoreTv_16,countScoreTv_17,countScoreTv_18,countScoreTv_19,countScoreTv_20};

        setTextView(cowCountEt_1,cowAvailableEt_1,countRatioTv_1,countScoreTv_1);
        setTextView(cowCountEt_2,cowAvailableEt_2,countRatioTv_2,countScoreTv_2);
        setTextView(cowCountEt_3,cowAvailableEt_3,countRatioTv_3,countScoreTv_3);
        setTextView(cowCountEt_4,cowAvailableEt_4,countRatioTv_4,countScoreTv_4);
        setTextView(cowCountEt_5,cowAvailableEt_5,countRatioTv_5,countScoreTv_5);
        setTextView(cowCountEt_6,cowAvailableEt_6,countRatioTv_6,countScoreTv_6);
        setTextView(cowCountEt_7,cowAvailableEt_7,countRatioTv_7,countScoreTv_7);
        setTextView(cowCountEt_8,cowAvailableEt_8,countRatioTv_8,countScoreTv_8);
        setTextView(cowCountEt_9,cowAvailableEt_9,countRatioTv_9,countScoreTv_9);
        setTextView(cowCountEt_10,cowAvailableEt_10,countRatioTv_10,countScoreTv_10);
        setTextView(cowCountEt_11,cowAvailableEt_11,countRatioTv_11,countScoreTv_11);
        setTextView(cowCountEt_12,cowAvailableEt_12,countRatioTv_12,countScoreTv_12);
        setTextView(cowCountEt_13,cowAvailableEt_13,countRatioTv_13,countScoreTv_13);
        setTextView(cowCountEt_14,cowAvailableEt_14,countRatioTv_14,countScoreTv_14);
        setTextView(cowCountEt_15,cowAvailableEt_15,countRatioTv_15,countScoreTv_15);
        setTextView(cowCountEt_16,cowAvailableEt_16,countRatioTv_16,countScoreTv_16);
        setTextView(cowCountEt_17,cowAvailableEt_17,countRatioTv_17,countScoreTv_17);
        setTextView(cowCountEt_18,cowAvailableEt_18,countRatioTv_18,countScoreTv_18);
        setTextView(cowCountEt_19,cowAvailableEt_19,countRatioTv_19,countScoreTv_19);
        setTextView(cowCountEt_20,cowAvailableEt_20,countRatioTv_20,countScoreTv_20);

        freestall_dong_total.setText(String.valueOf(dong_size));
        if(dong_size == 1){
            next_dong_btn.setVisibility(View.INVISIBLE);
            prev_dong_btn.setVisibility(View.INVISIBLE);
            freestall_dong_btn.setVisibility(View.VISIBLE);
        }
        viewModel.clickDongHandler(next_dong_btn,prev_dong_btn,freestall_dong_btn,dong,freestall_dong_current,dong_size);
        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        // 완료 버튼

        int [] countScoreArr = new int[20];
        freestall_dong_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("click", "on");
                Boolean checkEmpty = false;
                int emptyDong = 0;
                for(int idx = 0; idx < dong_size ; idx++){
                    if(countCowEtArr[idx].getText().toString().equals("")){
                        checkEmpty = true;
                        emptyDong = idx + 1;
                    }  else {
                        countScoreArr[idx] = Integer.parseInt((String) countScoreTvArr[idx].getText());
                    }
                }
                // 이전 화면으로 돌아가기 ( 빈 값 있는지 체크 )
                if(checkEmpty == true){
                    String msg = emptyDong + "동의 빈 값을 입력해주세요";
                    Toast.makeText(getApplicationContext(),msg, Toast.LENGTH_LONG ).show();
                } else {
                    Arrays.sort(countScoreArr);
                    int max = countScoreArr[countScoreArr.length-1];
                    Intent intent = new Intent();
                    intent.putExtra("key", max);
                    setResult(1, intent);
                    finish();
                }

            }
        });
    }

    public int getFreestallNumRatio(float freestall_cow, float available_cow) { //동별 사육두수 대비 프리스톨 비율 계산
        float freestall_ratio = (available_cow / freestall_cow) * 100;
        return Math.round(freestall_ratio);
    }
    public int getFreestallNumScore(float freestall_cow, float available_cow) { //5번 문항 점수 계산
        int freestall_score = 0;
        if((available_cow / freestall_cow) >= 1) {
            freestall_score = 100; //양호
        }
        else if((available_cow / freestall_cow) > 0.94) {
            freestall_score = 70; //경계
        }
        else
            freestall_score = 40; //미흡
        return freestall_score;
    }
    public void setFreestallNumRatio(EditText totalCowEt, EditText freestallNumEt, TextView freestallNumRatioTv) { //프리스톨 비율 표기
        int totalCow = Integer.parseInt(totalCowEt.getText().toString());
        int freestallNum = Integer.parseInt(freestallNumEt.getText().toString());
        int freestallNumRatio = getFreestallNumRatio(totalCow, freestallNum);
        freestallNumRatioTv.setText(String.valueOf(freestallNumRatio));
    }
    public void setFreestallNumTv(EditText totalCowEt, EditText freestallNumEt, TextView freestallNumRatioTv, TextView freestallNumScoreTv) {
        int freestallNumScore = 0;
        int totalCow = 0;
        int freestallNum = 0;

        if(!TextUtils.isEmpty(totalCowEt.getText())) {
            totalCow = Integer.parseInt(totalCowEt.getText().toString());
        }
        if(!TextUtils.isEmpty(freestallNumEt.getText().toString())) {
            freestallNum = Integer.parseInt(freestallNumEt.getText().toString());
        }
        if(TextUtils.isEmpty(totalCowEt.getText().toString()) || TextUtils.isEmpty(freestallNumEt.getText().toString())) {
            freestallNumRatioTv.setText("값을 입력해주세요");
        } else {
            setFreestallNumRatio(totalCowEt, freestallNumEt, freestallNumRatioTv);
            freestallNumScore = getFreestallNumScore(totalCow, freestallNum);
            freestallNumScoreTv.setText(String.valueOf(freestallNumScore));
        }
    }


    public void setTextView(EditText totalCowEt, EditText freestallNumEt, TextView freestallNumRatioTv, TextView freestallNumScoreTv) {
        totalCowEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                setFreestallNumTv(totalCowEt, freestallNumEt, freestallNumRatioTv, freestallNumScoreTv);
            }
        });
        freestallNumEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                setFreestallNumTv(totalCowEt, freestallNumEt, freestallNumRatioTv, freestallNumScoreTv);
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
