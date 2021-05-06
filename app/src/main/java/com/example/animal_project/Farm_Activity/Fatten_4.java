package com.example.animal_project.Farm_Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.animal_project.R;
import com.example.animal_project.Result_View;

public class Fatten_4 extends AppCompatActivity {
    private View view;
    private String result;
    private Button btn_move;
    private EditText ed_30_struggle, ed_31_harmony, ed_32_touch_Near, ed_33_touch_Far, ed_34_touch_Impossibility;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fatten_4);

        ed_30_struggle = findViewById(R.id.fatten_struggle_a30);
        ed_31_harmony = findViewById(R.id.fatten_harmony_a31);
        ed_32_touch_Near = findViewById(R.id.fatten_touch_Near_a32);
        ed_33_touch_Far = findViewById(R.id.fatten_touch_Far_a33);
        ed_34_touch_Impossibility = findViewById(R.id.fatten_touch_Impossibility_a34);

        Button fatten_pre_4_btn = (Button) findViewById(R.id.fatten_pre_4_btn);
        Button fatten_next_4_btn = (Button) findViewById(R.id.fatten_next_4_btn);
        fatten_next_4_btn.setText("제출");

        fatten_pre_4_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_move.setText("다음");
                finish();
            }
        });
        //뒤로갈때 제출로 바뀜.

        fatten_next_4_btn.setOnClickListener(new View.OnClickListener() { //fragment1로 이동
            @Override
            public void onClick(View v) {
                String struggle = ed_30_struggle.getText().toString();
                String harmony = ed_31_harmony.getText().toString();
                String touch_near = ed_32_touch_Near.getText().toString();
                String touch_far = ed_33_touch_Far.getText().toString();
                String touch_impossibility = ed_34_touch_Impossibility.getText().toString();

                String[] protocol4 = {struggle, harmony, touch_near, touch_far, touch_impossibility};

                Intent intent_Result_View = new Intent(Fatten_4.this, Result_View.class);
                startActivity(intent_Result_View);
            }
        });
    }
}
