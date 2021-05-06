package com.example.animal_project.Farm_Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.animal_project.Input_userinfo;
import com.example.animal_project.Milk_cow;
import com.example.animal_project.R;
import com.example.animal_project.Result_View;

public class Freestall_4 extends AppCompatActivity {
    private View view;
    private String result;
    private Button btn_move;
    public String total_cow_count = ((Input_userinfo)Input_userinfo.context_userinfo).total_cow_count;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.freestall_4);

        ScrollView scrollview_freestall_4 = findViewById(R.id.scrollview_freestall_4);
        TextView freestall_head_Butt_q37 = (TextView) findViewById(R.id.freestall_head_Butt_q37);
        TextView freestall_struggle_q38 = (TextView) findViewById(R.id.freestall_struggle_q38);
        TextView freestall_touch_Near_q39 = (TextView) findViewById(R.id.freestall_touch_Near_q39);
        TextView freestall_touch_Far_q40 = (TextView) findViewById(R.id.freestall_touch_Far_q40);
        TextView freestall_touch_Impossibility_q41 = (TextView) findViewById(R.id.freestall_touch_Impossibility_q41);

        //Score TV
        TextView freestall_struggle_score = (TextView) findViewById(R.id.freestall_struggle_score);
        TextView freestall_untouchable_score = (TextView) findViewById(R.id.freestall_untouchable_score);

        EditText ed_37_head_Butt = findViewById(R.id.freestall_head_Butt_a37);
        EditText ed_38_struggle = findViewById(R.id.freestall_struggle_a38);
        EditText ed_39_touch_Near = findViewById(R.id.freestall_touch_Near_a39);
        EditText ed_40_touch_Far = findViewById(R.id.freestall_touch_Far_a40);
        EditText ed_41_touch_Impossibility = findViewById(R.id.freestall_touch_Impossibility_a41);

        ed_37_head_Butt.addTextChangedListener(new TextWatcher(){
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable arg0) {
                Log.d("37번 머리박치기", "현재값은: " + ed_37_head_Butt.getText().toString());
                if(TextUtils.isEmpty(ed_37_head_Butt.getText().toString())) {
                    freestall_struggle_score.setText("37번 값을 입력해주세요");
                    // 총 두수 보다 입력한 값이 클 때
                } else if(TextUtils.isEmpty(ed_38_struggle.getText().toString())) {
                    freestall_struggle_score.setText("38번 값을 입력해주세요");
                } else if(Integer.parseInt(total_cow_count) < Double.parseDouble(ed_37_head_Butt.getText().toString())){
                    freestall_struggle_score.setText("총 두수보다 큰 값을 입력할 수 없습니다.");
                } else {
//                    freestall_struggle_score.setText(getStruggleScore(ed_37_head_Butt.getText().toString(), ed_38_struggle.getText().toString()));
                    freestall_struggle_score.setText(((Milk_cow)Milk_cow.context).getStruggleScore(ed_37_head_Butt.getText().toString(), ed_38_struggle.getText().toString()));
                }
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
        });

        ed_38_struggle.addTextChangedListener(new TextWatcher(){
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable arg0) {
                Log.d("38번 머리박치기", "현재값은: " + ed_38_struggle.getText().toString());
                if(TextUtils.isEmpty(ed_37_head_Butt.getText().toString())) {
                    freestall_struggle_score.setText("37번 값을 입력해주세요");
                    // 총 두수 보다 입력한 값이 클 때
                } else if(TextUtils.isEmpty(ed_38_struggle.getText().toString())) {
                    freestall_struggle_score.setText("38번 값을 입력해주세요");
                } else if(Integer.parseInt(total_cow_count) < Double.parseDouble(ed_38_struggle.getText().toString())){
                    freestall_struggle_score.setText("총 두수보다 큰 값을 입력할 수 없습니다.");
                } else {
//                    freestall_struggle_score.setText(getStruggleScore(ed_37_head_Butt.getText().toString(), ed_38_struggle.getText().toString()));
                    freestall_struggle_score.setText(((Milk_cow)Milk_cow.context).getStruggleScore(ed_37_head_Butt.getText().toString(), ed_38_struggle.getText().toString()));
                }
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
        });

        ed_39_touch_Near.addTextChangedListener(new TextWatcher(){
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable arg0) {
                Log.d("39번 가까이", "현재값은: " + ed_39_touch_Near.getText().toString());
                if(TextUtils.isEmpty(ed_39_touch_Near.getText().toString())) {
                    freestall_untouchable_score.setText("39번 값을 입력해주세요");
                    // 총 두수 보다 입력한 값이 클 때
                } else if(TextUtils.isEmpty(ed_40_touch_Far.getText().toString())) {
                    freestall_untouchable_score.setText("40번 값을 입력해주세요");
                } else if(TextUtils.isEmpty(ed_41_touch_Impossibility.getText().toString())) {
                    freestall_untouchable_score.setText("41번 값을 입력해주세요");
                } else if(Integer.parseInt(total_cow_count) < Double.parseDouble(ed_39_touch_Near.getText().toString())){
                    freestall_untouchable_score.setText("총 두수보다 큰 값을 입력할 수 없습니다.");
                } else {
                    freestall_untouchable_score.setText(((Milk_cow)Milk_cow.context).getUntouchableCowScore(ed_39_touch_Near.getText().toString(), ed_40_touch_Far.getText().toString(), ed_41_touch_Impossibility.getText().toString()));
                }
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
        });

        ed_40_touch_Far.addTextChangedListener(new TextWatcher(){
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable arg0) {
                Log.d("40번 중간", "현재값은: " + ed_40_touch_Far.getText().toString());
                if(TextUtils.isEmpty(ed_39_touch_Near.getText().toString())) {
                    freestall_untouchable_score.setText("39번 값을 입력해주세요");
                    // 총 두수 보다 입력한 값이 클 때
                } else if(TextUtils.isEmpty(ed_40_touch_Far.getText().toString())) {
                    freestall_untouchable_score.setText("40번 값을 입력해주세요");
                } else if(TextUtils.isEmpty(ed_41_touch_Impossibility.getText().toString())) {
                    freestall_untouchable_score.setText("41번 값을 입력해주세요");
                } else if(Integer.parseInt(total_cow_count) < Double.parseDouble(ed_40_touch_Far.getText().toString())){
                    freestall_untouchable_score.setText("총 두수보다 큰 값을 입력할 수 없습니다.");
                } else {
                    freestall_untouchable_score.setText(((Milk_cow)Milk_cow.context).getUntouchableCowScore(ed_39_touch_Near.getText().toString(), ed_40_touch_Far.getText().toString(), ed_41_touch_Impossibility.getText().toString()));
                }
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
        });

        ed_41_touch_Impossibility.addTextChangedListener(new TextWatcher(){
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable arg0) {
                Log.d("41번 못만지는", "현재값은: " + ed_41_touch_Impossibility.getText().toString());
                if(TextUtils.isEmpty(ed_39_touch_Near.getText().toString())) {
                    freestall_untouchable_score.setText("39번 값을 입력해주세요");
                    // 총 두수 보다 입력한 값이 클 때
                } else if(TextUtils.isEmpty(ed_40_touch_Far.getText().toString())) {
                    freestall_untouchable_score.setText("40번 값을 입력해주세요");
                } else if(TextUtils.isEmpty(ed_41_touch_Impossibility.getText().toString())) {
                    freestall_untouchable_score.setText("41번 값을 입력해주세요");
                } else if(Integer.parseInt(total_cow_count) < Integer.parseInt(ed_41_touch_Impossibility.getText().toString())){
                    freestall_untouchable_score.setText("총 두수보다 큰 값을 입력할 수 없습니다.");
                } else {
                    freestall_untouchable_score.setText(((Milk_cow)Milk_cow.context).getUntouchableCowScore(ed_39_touch_Near.getText().toString(), ed_40_touch_Far.getText().toString(), ed_41_touch_Impossibility.getText().toString()));
                }
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
        });

        Button freestall_pre_4_btn = (Button) findViewById(R.id.freestall_pre_4_btn);
        Button freestall_next_4_btn = (Button) findViewById(R.id.freestall_next_4_btn);
        freestall_next_4_btn.setText("제출");

        freestall_pre_4_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //뒤로갈때 제출로 바뀜.

        freestall_next_4_btn.setOnClickListener(new View.OnClickListener() { //fragment1로 이동
            @Override
            public void onClick(View v) {
                String head_butt = ed_37_head_Butt.getText().toString();
                String struggle = ed_38_struggle.getText().toString();
                String touch_near = ed_39_touch_Near.getText().toString();
                String touch_far = ed_40_touch_Far.getText().toString();
                String touch_impossibility = ed_41_touch_Impossibility.getText().toString();

                String[] protocol4 = {head_butt, struggle, touch_near, touch_far, touch_impossibility};

                Intent intent_Result_View = new Intent(Freestall_4.this, Result_View.class);
                startActivity(intent_Result_View);
            }
        });
    }
}