package com.example.animal_project.Farm_Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.animal_project.BreedBatchQuestion.Breed_cough;
import com.example.animal_project.BreedBatchQuestion.Breed_harmony;
import com.example.animal_project.BreedBatchQuestion.Breed_struggle;
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


        ed_35_touch_Near = findViewById(R.id.breed_batch_touch_Near_a35);
        ed_36_touch_Far = findViewById(R.id.breed_batch_touch_Far_a36);
        ed_37_touch_Impossibility = findViewById(R.id.breed_batch_touch_Impossibility_a37);

        Button breed_batch_pre_4_btn = (Button) findViewById(R.id.breed_batch_pre_4_btn);
        Button breed_batch_next_4_btn = (Button) findViewById(R.id.breed_batch_next_4_btn);

        ArrayAdapter spinnerAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                R.array.dong_size_12,
                android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner mSpinner = findViewById(R.id.spinner_breed_struggle);
        mSpinner.setAdapter( spinnerAdapter );
        final int[] selectedItemIndex = new int[1];
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // 선택된 데이터 값
                String selectedItem = parent.getSelectedItem().toString();

                // 선택된 데이터 위치( 0 부터 )
                selectedItemIndex[0] = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        Button breed_btn_struggle = findViewById(R.id.breed_btn_struggle);


        breed_btn_struggle.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String dong_count = Integer.toString(selectedItemIndex[0]);
                if(Integer.parseInt(dong_count) == 0){
                    String msg = "축사 동 수를 선택해주세요";
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                }else{
                    int dong_size = Integer.parseInt(dong_count);
                    Intent intent = new Intent(Breed_batch_4.this, Breed_struggle.class);
                    intent.putExtra("dong_count",dong_size); /*송신*/
                    startActivityForResult(intent, 0);
                }
            }
        });

     ArrayAdapter spinnerAdapter2 = ArrayAdapter.createFromResource(getApplicationContext(),
                R.array.dong_size_12,
                android.R.layout.simple_spinner_item);
        spinnerAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner mSpinner2 = findViewById(R.id.spinner_breed_harmony);
        mSpinner2.setAdapter( spinnerAdapter2 );
        final int[] selectedItemIndex2 = new int[1];
        mSpinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // 선택된 데이터 값
                String selectedItem = parent.getSelectedItem().toString();

                // 선택된 데이터 위치( 0 부터 )
                selectedItemIndex2[0] = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        Button breed_btn_harmony = findViewById(R.id.breed_btn_harmony);


        breed_btn_harmony.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String dong_count = Integer.toString(selectedItemIndex2[0]);
                if(Integer.parseInt(dong_count) == 0){
                    String msg = "축사 동 수를 선택해주세요";
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                }else{
                    int dong_size = Integer.parseInt(dong_count);
                    Intent intent = new Intent(Breed_batch_4.this, Breed_harmony.class);
                    intent.putExtra("dong_count",dong_size); /*송신*/
                    startActivityForResult(intent, 0);
                }
            }
        });


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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        TextView breed_struggle_ratio = findViewById(R.id.breed_struggle_ratio);
        TextView breed_harmony_ratio = findViewById(R.id.breed_harmony_ratio);
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case 0:
                int sum_struggle = data.getExtras().getInt("sum");
                breed_struggle_ratio.setText(String.valueOf(sum_struggle));
                break;
            case 1:
                int sum_harmony = data.getExtras().getInt("sum");
                breed_harmony_ratio.setText(String.valueOf(sum_harmony));
            default:
                break;
        }
    }

}
