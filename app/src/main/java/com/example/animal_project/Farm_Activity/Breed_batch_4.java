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

public class Breed_batch_4 extends AppCompatActivity {
    private View view;
    private String result;
    private Button btn_move;
    private EditText ed_33_struggle, ed_34_harmony, ed_35_touch_Near, ed_36_touch_Far, ed_37_touch_Impossibility;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.breed_batch_4);

        ed_33_struggle = findViewById(R.id.breed_batch_struggle_a33);
        ed_34_harmony = findViewById(R.id.breed_batch_harmony_a34);
        ed_35_touch_Near = findViewById(R.id.breed_batch_touch_Near_a35);
        ed_36_touch_Far = findViewById(R.id.breed_batch_touch_Far_a36);
        ed_37_touch_Impossibility = findViewById(R.id.breed_batch_touch_Impossibility_a37);

        Button breed_batch_pre_4_btn = (Button) findViewById(R.id.breed_batch_pre_4_btn);
        Button breed_batch_next_4_btn = (Button) findViewById(R.id.breed_batch_next_4_btn);
        breed_batch_next_4_btn.setText("제출");

        breed_batch_pre_4_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //뒤로갈때 제출로 바뀜.

        breed_batch_next_4_btn.setOnClickListener(new View.OnClickListener() { //fragment1로 이동
            @Override
            public void onClick(View v) {
                String struggle = ed_33_struggle.getText().toString();
                String harmony = ed_34_harmony.getText().toString();
                String touch_near = ed_35_touch_Near.getText().toString();
                String touch_far = ed_36_touch_Far.getText().toString();
                String touch_impossibility = ed_37_touch_Impossibility.getText().toString();

                String[] protocol4 = {struggle, harmony, touch_near, touch_far, touch_impossibility};

                Intent intent_Result_View = new Intent(Breed_batch_4.this, Result_View.class);
                startActivity(intent_Result_View);
            }
        });
    }
}
