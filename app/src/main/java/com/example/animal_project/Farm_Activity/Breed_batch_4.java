package com.example.animal_project.Farm_Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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
import androidx.fragment.app.FragmentActivity;

import com.example.animal_project.BreedBatchQuestion.Breed_cough;
import com.example.animal_project.BreedBatchQuestion.Breed_harmony;
import com.example.animal_project.BreedBatchQuestion.Breed_struggle;
import com.example.animal_project.R;
import com.example.animal_project.Result.Result_1;
import com.example.animal_project.Result_View;

import javax.xml.transform.Result;

public class
Breed_batch_4 extends FragmentActivity {
    private View view;
    private String result;
    private Button btn_move;
    private EditText ed_33_struggle, ed_34_harmony, ed_35_touch_Near, ed_36_touch_Far, ed_37_touch_Impossibility;

    Result_View Result_view;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.breed_batch_4);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Log.d("Three",String.valueOf(bundle.getDouble("protocolThreeScore")));

        Result_view = new Result_View();

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

                    bundle.putDouble("protocolFourScore",50.4);
                    Intent intent_Result_View = new Intent(Breed_batch_4.this, Result_View.class);
                    intent_Result_View.putExtras(bundle);
                    startActivity(intent_Result_View);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        TextView breed_struggle_ratio = findViewById(R.id.breed_struggle_ratio);
        TextView breed_harmony_ratio = findViewById(R.id.breed_harmony_ratio);
        TextView breed_social_behavior_score = findViewById(R.id.breed_social_behavior_score);
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case 1:
                double sum_struggle = data.getExtras().getDouble("sum");
                breed_struggle_ratio.setText(String.valueOf(sum_struggle));
                setSocialBehaviorScore(breed_struggle_ratio,breed_harmony_ratio,breed_social_behavior_score);
                break;
            case 2:
                double sum_harmony = data.getExtras().getDouble("sum");
                breed_harmony_ratio.setText(String.valueOf(sum_harmony));
                setSocialBehaviorScore(breed_struggle_ratio,breed_harmony_ratio,breed_social_behavior_score);
            default:

                break;
        }
    }
    private void setSocialBehaviorScore(TextView struggleRatioTv, TextView harmonyRatioTv, TextView socialBehaviorScoreTv){
        if(TextUtils.isEmpty(struggleRatioTv.getText())
        || TextUtils.isEmpty(harmonyRatioTv.getText())){
            socialBehaviorScoreTv.setText("사회적 행동 설문을 모두 완료하세요");
        } else {
            double struggle = Double.parseDouble(String.valueOf(struggleRatioTv.getText()));
            double harmony = Double.parseDouble(String.valueOf(harmonyRatioTv.getText()));
            int socialBehaivorScore = getSocialBehaviorScore(struggle,harmony);
            socialBehaviorScoreTv.setText(String.valueOf(socialBehaivorScore));
        }
    }

    // 사회적 행동의 표현(투쟁행동, 화합행동)" 종합 기준점수
    private int getSocialBehaviorScore(double struggle, double harmony)
    {
        // 투쟁행동 비율 계산
        double struggleRatio = struggle / (struggle + harmony) * 100;

        int socialBehaviorScore = 0;
        // 투쟁행동빈도 0.5 이하일때
        if (struggle <= 0.5) {
            if (struggleRatio > 100) {
                return socialBehaviorScore = -1;
            }
            if (struggleRatio == 100) {
                socialBehaviorScore = 58;
            } else if (struggleRatio >= 90) {
                socialBehaviorScore = 62;
            } else if (struggleRatio >= 80) {
                socialBehaviorScore = 67;
            } else if (struggleRatio >= 70) {
                socialBehaviorScore = 73;
            } else if (struggleRatio >= 60) {
                socialBehaviorScore = 78;
            } else if (struggleRatio >= 50) {
                socialBehaviorScore = 83;
            } else if (struggleRatio >= 40) {
                socialBehaviorScore = 87;
            } else if (struggleRatio >= 30) {
                socialBehaviorScore = 91;
            } else if (struggleRatio >= 20) {
                socialBehaviorScore = 93;
            } else if (struggleRatio >= 10) {
                socialBehaviorScore = 95;
            } else {
                socialBehaviorScore = 100;
            }
            return socialBehaviorScore;
        } // 투쟁행동빈도 0.5 초과, 1.5 이하일때 
        else if (0.5 < struggle && struggle <= 1.5) {
            if (struggleRatio > 100) {
                return socialBehaviorScore = -1;
            }
            if (struggleRatio == 100) {
                socialBehaviorScore = 34;
            } else if (struggleRatio >= 90) {
                socialBehaviorScore = 41;
            } else if (struggleRatio >= 80) {
                socialBehaviorScore = 47;
            } else if (struggleRatio >= 70) {
                socialBehaviorScore = 52;
            } else if (struggleRatio >= 60) {
                socialBehaviorScore = 57;
            } else if (struggleRatio >= 50) {
                socialBehaviorScore = 61;
            } else if (struggleRatio >= 40) {
                socialBehaviorScore = 65;
            } else if (struggleRatio >= 30) {
                socialBehaviorScore = 67;
            } else if (struggleRatio >= 20) {
                socialBehaviorScore = 69;
            } else if (struggleRatio >= 10) {
                socialBehaviorScore = 72;
            } else {
                socialBehaviorScore = 100;
            }
        } // 투쟁행동빈도 1.5 초과, 3 이하일때 
        else if (1.5 < struggle && struggle <= 3) {
            if (struggleRatio > 100) {
                return socialBehaviorScore = -1;
            }
            if (struggleRatio == 100) {
                socialBehaviorScore = 25;
            } else if (struggleRatio >= 90) {
                socialBehaviorScore = 30;
            } else if (struggleRatio >= 80) {
                socialBehaviorScore = 35;
            } else if (struggleRatio >= 70) {
                socialBehaviorScore = 39;
            } else if (struggleRatio >= 60) {
                socialBehaviorScore = 42;
            } else if (struggleRatio >= 50) {
                socialBehaviorScore = 45;
            } else if (struggleRatio >= 40) {
                socialBehaviorScore = 47;
            } else if (struggleRatio >= 30) {
                socialBehaviorScore = 48;
            } else if (struggleRatio >= 20) {
                socialBehaviorScore = 49;
            } else if (struggleRatio >= 10) {
                socialBehaviorScore = 52;
            } else {
                socialBehaviorScore = 100;
            }
            // 40 % 점수에서 왜 내려가는 지?
        } // 투쟁행동빈도 3 초과, 8 이하일때 
        else if (3 < struggle && struggle <= 8) {
            if (struggleRatio > 100) {
                return socialBehaviorScore = -1;
            }
            if (struggleRatio == 100) {
                socialBehaviorScore = 8;
            } else if (struggleRatio >= 90) {
                socialBehaviorScore = 13;
            } else if (struggleRatio >= 80) {
                socialBehaviorScore = 16;
            } else if (struggleRatio >= 70) {
                socialBehaviorScore = 19;
            } else if (struggleRatio >= 60) {
                socialBehaviorScore = 22;
            } else if (struggleRatio >= 50) {
                socialBehaviorScore = 24;
            } else if (struggleRatio >= 40) {
                // 왜 여기서 점수가 내려가는지?
                socialBehaviorScore = 20;
            } else if (struggleRatio >= 30) {
                socialBehaviorScore = 27;
            } else if (struggleRatio >= 20) {
                socialBehaviorScore = 28;
            } else if (struggleRatio >= 10) {
                socialBehaviorScore = 30;
            } else {
                socialBehaviorScore = 100;
            }
        } // 투쟁행동빈도 8 초과일때
        else if (8 < struggle) {
            if (struggleRatio > 100) {
                return socialBehaviorScore = -1;
            }
            if (struggleRatio == 100) {
                socialBehaviorScore = 0;
            } else if (struggleRatio >= 90) {
                socialBehaviorScore = 3;
            } else if (struggleRatio >= 80) {
                socialBehaviorScore = 3;
            } else if (struggleRatio >= 70) {
                socialBehaviorScore = 4;
            } else if (struggleRatio >= 60) {
                socialBehaviorScore = 5;
            } else if (struggleRatio >= 50) {
                socialBehaviorScore = 6;
            } else if (struggleRatio >= 40) {
                socialBehaviorScore = 6;
            } else if (struggleRatio >= 30) {
                socialBehaviorScore = 6;
            } else if (struggleRatio >= 20) {
                socialBehaviorScore = 7;
            } else if (struggleRatio >= 10) {
                socialBehaviorScore = 8;
            } else {
                socialBehaviorScore = 100;
            }
        }
        Log.d("1",String.valueOf(struggleRatio));
        return socialBehaviorScore;
    }
}
