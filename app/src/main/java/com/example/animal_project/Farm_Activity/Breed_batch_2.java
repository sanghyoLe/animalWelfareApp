package com.example.animal_project.Farm_Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.animal_project.BreedBatchQuestion.Breed_q5;
import com.example.animal_project.Input_userinfo;
import com.example.animal_project.R;

public class Breed_batch_2 extends AppCompatActivity {
    private View view;
    private String result;
    private Button btn_move;
    Integer straw_Feed_Tank = 0, straw_Normal = 0, straw_Resting_Place = 0, outward_Hygiene = 0, shade = 0, summer_Ventilating = 0, mist_Spary = 0,
    wind_Block_Adult = 0, winter_Ventilating = 0, straw = 0, warm = 0, wind_Block_Child = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.breed_batch_2);



        EditText breed_outward_hygiene_ed = findViewById(R.id.breed_outward_hygiene_ed);
        RadioGroup rdiog_9_shade = (RadioGroup) findViewById(R.id.breed_batch_shade_rdogrp9); //9번 문항
        RadioGroup rdiog_10_summer_ventilating = (RadioGroup) findViewById(R.id.breed_batch_summer_Ventilating_rdogrp10); //10번 문항
        RadioGroup rdiog_11_mist_spary = (RadioGroup) findViewById(R.id.breed_batch_mist_Spary_rdogrp11); //11번 문항
        RadioGroup rdiog_12_wind_block = (RadioGroup) findViewById(R.id.breed_batch_wind_Block_rdogrp12); //11번 문항
        RadioGroup rdiog_13_winter_ventilating = (RadioGroup) findViewById(R.id.breed_batch_winter_Ventilating_rdogrp13);
        RadioGroup rdiog_14_straw = (RadioGroup) findViewById(R.id.breed_batch_straw_rdogrp14);
        RadioGroup rdiog_15_warm = (RadioGroup) findViewById(R.id.breed_batch_warm_rdogrp15);
        RadioGroup rdiog_16_wind_block = (RadioGroup) findViewById(R.id.breed_batch_wind_Block_rdogrp16);

        TextView breed_summer_rest_score = (TextView) findViewById(R.id.breed_summer_rest_score);
        TextView breed_winter_rest_score = (TextView) findViewById(R.id.breed_winter_rest_score);
        TextView breed_calf_winter_rest_score = (TextView) findViewById(R.id.breed_calf_winter_rest_score);
        TextView breed_outward_hygiene_ratio = findViewById(R.id.breed_outward_Hygiene_ratio);
        TextView breed_outward_hygiene_score = findViewById(R.id.breed_outward_Hygiene_score);

        ArrayAdapter spinnerAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                R.array.dong_size,
                android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner mSpinner = findViewById(R.id.spinner_breed_q5);
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
        Button breed_btn_q5 = findViewById(R.id.breed_btn_q5);


        breed_btn_q5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String dong_count = Integer.toString(selectedItemIndex[0]);
                if(Integer.parseInt(dong_count) == 0){
                    String msg = "축사 동 수를 선택해주세요";
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                }else{
                    int dong_size = Integer.parseInt(dong_count);
                    Intent intent = new Intent(Breed_batch_2.this, Breed_q5.class);
                    intent.putExtra("dong_count",dong_size); /*송신*/

                    startActivity(intent);
                }

            }
        });
        int sample_size_count = Integer.parseInt(((Input_userinfo)Input_userinfo.context_userinfo).sample_size_count);

        breed_outward_hygiene_ed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void afterTextChanged(Editable editable) {
                if(TextUtils.isEmpty(breed_outward_hygiene_ed.getText().toString())){
                    breed_outward_hygiene_ratio.setText("값을 입력해주세요");
                    breed_outward_hygiene_score.setText("값을 입력해주세요");
                } else {
                    float ratio = Float.parseFloat(breed_outward_hygiene_ed.getText().toString()) / sample_size_count  ;
                    ratio = ratio * 100;
                    ratio = Math.round(ratio);
                    breed_outward_hygiene_ratio.setText(String.valueOf(ratio));
                    outward_Hygiene = getOutwardHygieneScore(ratio);
                    breed_outward_hygiene_score.setText(String.valueOf(outward_Hygiene));
                }
            }
        });
        rdiog_9_shade.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.breed_batch_shade_a9_1) {
                    shade = 1;
                } else if (checkedId == R.id.breed_batch_shade_a9_2) {
                    shade = 2;
                }
                breed_summer_rest_score.setText(Integer.toString(getSummerRestScore(shade,summer_Ventilating,mist_Spary)));
            }
        });

        rdiog_10_summer_ventilating.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.breed_batch_summer_Ventilating_a10_1) {
                    summer_Ventilating = 1;
                } else if (checkedId == R.id.breed_batch_summer_Ventilating_a10_2) {
                    summer_Ventilating = 2;
                }
                breed_summer_rest_score.setText(Integer.toString(getSummerRestScore(shade,summer_Ventilating,mist_Spary)));
            }
        });

        rdiog_11_mist_spary.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.breed_batch_mist_Spary_a11_1) {
                    mist_Spary = 1;
                } else if (checkedId == R.id.breed_batch_mist_Spary_a11_2) {
                    mist_Spary = 2;
                }
                breed_summer_rest_score.setText(Integer.toString(getSummerRestScore(shade,summer_Ventilating,mist_Spary)));
            }
        });

        rdiog_12_wind_block.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.breed_batch_wind_Block_a12_1) {
                    wind_Block_Adult = 1;
                } else if (checkedId == R.id.breed_batch_wind_Block_a12_2) {
                    wind_Block_Adult = 2;
                }
                breed_winter_rest_score.setText(Integer.toString(getWinterRestScore(wind_Block_Adult,winter_Ventilating)));
            }
        });

        rdiog_13_winter_ventilating.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.breed_batch_winter_Ventilating_a13_1) {
                    winter_Ventilating = 1;
                } else if (checkedId == R.id.breed_batch_winter_Ventilating_a13_2) {
                    winter_Ventilating = 2;
                }
                breed_winter_rest_score.setText(Integer.toString(getWinterRestScore(wind_Block_Adult,winter_Ventilating)));
            }
        });

        rdiog_14_straw.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.breed_batch_straw_a14_1) {
                    straw = 1;
                } else if (checkedId == R.id.breed_batch_straw_a14_2) {
                    straw = 2;
                }
                breed_calf_winter_rest_score.setText(Integer.toString(getWinterCalfRestScore(
                        straw,warm,wind_Block_Child)));
            }
        });

        rdiog_15_warm.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.breed_batch_warm_a15_1) {
                    warm = 1;
                } else if (checkedId == R.id.breed_batch_warm_a15_2) {
                    warm = 2;
                }

                breed_calf_winter_rest_score.setText(Integer.toString(getWinterCalfRestScore(
                        straw,warm,wind_Block_Child)));
            }
        });

        rdiog_16_wind_block.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.breed_batch_wind_Block_a16_1) {
                    wind_Block_Child = 1;
                } else if (checkedId == R.id.breed_batch_wind_Block_a16_2) {
                    wind_Block_Child = 2;
                }
                breed_calf_winter_rest_score.setText(Integer.toString(getWinterCalfRestScore(
                        straw,warm,wind_Block_Child)));
            }
        });

        Button breed_batch_pre_2_btn = (Button) findViewById(R.id.breed_batch_pre_2_btn);
        Button breed_batch_next_2_btn = (Button) findViewById(R.id.breed_batch_next_2_btn);

        breed_batch_pre_2_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        breed_batch_next_2_btn.setOnClickListener(new View.OnClickListener() { //fragment1로 이동
            @Override
            public void onClick(View v) {
                String straw_feed_tank = Integer.toString(straw_Feed_Tank);
                String straw_normal = Integer.toString(straw_Normal);
                String straw_resting_place = Integer.toString(straw_Resting_Place);
                String outward_hygiene = Integer.toString(outward_Hygiene);
                String shade_1 = Integer.toString(shade);
                String summer_ventilating = Integer.toString(summer_Ventilating);
                String mist_spary = Integer.toString(mist_Spary);
                String wind_block_adult = Integer.toString(wind_Block_Adult);
                String winter_ventilating = Integer.toString(winter_Ventilating);
                String straw_1 = Integer.toString(straw);
                String warm_1 = Integer.toString(warm);
                String wind_block_child = Integer.toString(wind_Block_Child);

                String[] protocol2 = {straw_feed_tank, straw_normal, straw_resting_place, outward_hygiene, shade_1, summer_ventilating,
                        mist_spary, wind_block_adult, winter_ventilating, straw_1, warm_1, wind_block_child};

                Intent intent_Breed_batch_3 = new Intent(Breed_batch_2.this, Breed_batch_3.class);
                startActivity(intent_Breed_batch_3);
            }
        });
    }
    private int getOutwardHygieneScore(float ratio)
    {
        int outwardHygieneScore = 0;
        if (ratio == 0) {
            outwardHygieneScore = 100;
        } else if (ratio <= 3) {
        outwardHygieneScore = 90;
    } else if (ratio <= 6) {
        outwardHygieneScore = 80;
    } else if (ratio <= 9) {
        outwardHygieneScore = 70;
    } else if (ratio <= 13) {
        outwardHygieneScore = 60;
    } else if (ratio <= 18) {
        outwardHygieneScore = 50;
    } else if (ratio <= 23) {
        outwardHygieneScore = 40;
    } else if (ratio <= 29) {
        outwardHygieneScore = 30;
    } else if (ratio <= 37) {
        outwardHygieneScore = 20;
    } else if (ratio <= 52) {
        outwardHygieneScore = 10;
    } else {
        outwardHygieneScore = 0;
    }
        return outwardHygieneScore;
    }
    // 혹서기 - 그늘, 환기팬, 안개분무 시설 점수 계산
    public int getSummerRestScore(int shade,int summerVentilating, int mistSpary)
    {
        int summerRestScore = 0;
        // 충분한 그늘 항목 "예"인 경우
        if (shade == 1) {
            // 충분한 풍속 항목 "예"인 경우
            if (summerVentilating  == 1) {
                //안개분무 풍속 "예"인 경우
                if (mistSpary == 1) {
                    summerRestScore = 100;
                } else {
                    summerRestScore = 80;
                }
            } else {
                if (mistSpary == 1) {
                    summerRestScore = 60;
                } else {
                    summerRestScore = 45;
                }
            }
        } else {
            if (summerVentilating == 1) {
                if (mistSpary == 1) {
                    summerRestScore = 55;
                } else {
                    summerRestScore = 40;
                }
            } else {
                if (mistSpary == 1) {
                    summerRestScore = 20;
                } else {
                    summerRestScore = 0;
                }
            }
        }
        return summerRestScore;
    }
    public int getWinterRestScore(int windBlock, int winterVentilating)
    {
        int windRestScore = 0;
        // 바람차단시설 항목 "예"인 경우
        if (windBlock == 1) {
            // 최소 풍속시설 항목 "예"인 경우
            if (winterVentilating == 1) {
                windRestScore = 100;
            } else {
                windRestScore = 70;
            }
            // 바람차단시설 항목 "아니오 "인 경우
        } else {
            if (winterVentilating == 1) {
                windRestScore = 40;
            } else {
                windRestScore = 20;
            }
        }
        return windRestScore;
    }
    public int getWinterCalfRestScore(int straw, int warm, int windBlock)
    {
        int winterCalfRestScore = 0;
        // 충분한 깔짚 항목 "예"
        if (straw == 1) {
            // 충분한 보온 항목 "예"
            if (warm == 1) {
                // 바람 차단 시설 "예"
                if (windBlock == 1) {
                    winterCalfRestScore = 100;
                } else {
                    winterCalfRestScore = 80;
                }
            }
            // 충분한 보온 항목 "아니오"
            else {
                if (windBlock == 1) {
                    winterCalfRestScore = 60;
                } else {
                    winterCalfRestScore = 45;
                }
            }
        }
        // 충분한 깔짚 항목 "아니오"
        else {
            if (warm == 1) {
                if (windBlock == 1) {
                    winterCalfRestScore = 55;
                } else {
                    winterCalfRestScore = 40;
                }
            } else {
                if (windBlock == 1) {
                    winterCalfRestScore = 20;
                } else {
                    winterCalfRestScore = 0;
                }
            }
        }
        return winterCalfRestScore;
    }
}

