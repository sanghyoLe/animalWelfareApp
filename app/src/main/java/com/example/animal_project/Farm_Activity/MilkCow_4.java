package com.example.animal_project.Farm_Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.animal_project.R;
import com.example.animal_project.Result_View;

public class MilkCow_4 extends AppCompatActivity {
    private View view;
    private String result;
    private Button btn_move;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.milkcow_4);

        ScrollView scrollview_milk_4 = findViewById(R.id.scrollview_milk_4);
        TextView milk_head_Butt_q34 = (TextView) findViewById(R.id.milk_head_Butt_q34);
        TextView milk_struggle_q35 = (TextView) findViewById(R.id.milk_struggle_q35);
        TextView milk_touch_Near_q36 = (TextView) findViewById(R.id.milk_touch_Near_q36);
        TextView milk_touch_Far_q37 = (TextView) findViewById(R.id.milk_touch_Far_q37);
        TextView milk_touch_Impossibility_q38 = (TextView) findViewById(R.id.milk_touch_Impossibility_q38);

        EditText ed_34_head_Butt = findViewById(R.id.milk_head_Butt_a34);
        EditText ed_35_struggle = findViewById(R.id.milk_struggle_a35);
        EditText ed_36_touch_Near = findViewById(R.id.milk_touch_Near_a36);
        EditText ed_37_touch_Far = findViewById(R.id.milk_touch_Far_a37);
        EditText ed_38_touch_Impossibility = findViewById(R.id.milk_touch_Impossibility_a38);

        Button milkcow_pre_4_btn = (Button) findViewById(R.id.milkcow_pre_4_btn);
        Button milkcow_next_4_btn = (Button) findViewById(R.id.milkcow_next_4_btn);
        milkcow_next_4_btn.setText("제출");

        milkcow_pre_4_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        milkcow_next_4_btn.setOnClickListener(new View.OnClickListener() { //fragment1로 이동
            @Override
            public void onClick(View v) {
                String head_butt = ed_34_head_Butt.getText().toString();
                String struggle = ed_35_struggle.getText().toString();
                String touch_near = ed_36_touch_Near.getText().toString();
                String touch_far = ed_37_touch_Far.getText().toString();
                String touch_impossibility = ed_38_touch_Impossibility.getText().toString();

                String[] protocol4 = {head_butt, struggle, touch_near, touch_far, touch_impossibility};

                Intent intent_Result_View = new Intent(MilkCow_4.this, Result_View.class);
                startActivity(intent_Result_View);
            }
        });
    }
}
