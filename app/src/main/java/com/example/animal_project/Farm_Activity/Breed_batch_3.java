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
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.animal_project.Input_userinfo;
import com.example.animal_project.R;

public class Breed_batch_3 extends AppCompatActivity {
    private View view;
    private String result;
    private Button btn_move;
    private EditText breed_batch_Limp_ed, ed_18_slight_Hairloss, ed_19_critical_Hairloss,
            ed_20_cough, ed_21_runny_Nose, ed_22_ophthalmic_Secretion, ed_23_respiratory_Failure, ed_24_diarrhea,
            ed_25_ruminant, ed_26_fall_Dead;
    Integer horn = 0, horn_Anesthesia = 0, horn_Painkiller = 0, castration = 0, castration_Anesthesia = 0,
            castration_Painkiller = 0, limp_score =0;
    int sample_size_count = Integer.parseInt(((Input_userinfo)Input_userinfo.context_userinfo).sample_size_count);
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.breed_batch_3);

        breed_batch_Limp_ed = (EditText) findViewById(R.id.breed_batch_Limp_ed);

        EditText breed_slight_hairloss_ed = findViewById(R.id.breed_slight_hairloss_ed);
        EditText breed_critical_hairloss_ed = findViewById(R.id.breed_critical_hairloss_ed);
        ed_20_cough = (EditText) findViewById(R.id.breed_batch_cough_a20);
        EditText breed_runny_nose_ed = findViewById(R.id.breed_runny_nose_ed);
        ed_22_ophthalmic_Secretion = (EditText) findViewById(R.id.breed_batch_ophthalmic_Secretion_a22);
        ed_23_respiratory_Failure = (EditText) findViewById(R.id.breed_batch_respiratory_Failure_a23);
        ed_24_diarrhea = (EditText) findViewById(R.id.breed_batch_diarrhea_a24);
        ed_25_ruminant = (EditText) findViewById(R.id.breed_batch_ruminant_a25);
        ed_26_fall_Dead = (EditText) findViewById(R.id.breed_batch_fall_Dead_a26);

        RadioGroup rdiog_27_horn = (RadioGroup) findViewById(R.id.breed_batch_horn_rdogrp27);
        RadioGroup rdiog_28_horn_anesthesia = (RadioGroup) findViewById(R.id.breed_batch_horn_Anesthesia_rdogrp28);
        RadioGroup rdiog_29_horn_painkiller = (RadioGroup) findViewById(R.id.breed_batch_horn_Painkiller_rdogrp29);
        RadioGroup rdiog_30_castration = (RadioGroup) findViewById(R.id.breed_batch_castration_rdogrp30);
        RadioGroup rdiog_31_castration_anesthesia = (RadioGroup) findViewById(R.id.breed_batch_castration_Anesthesia_rdogrp31);
        RadioGroup rdiog_32_castration_painkiller = (RadioGroup) findViewById(R.id.breed_batch_castration_Painkiller_rdogrp32);
        TextView breed_limp_score = findViewById(R.id.breed_limp_score);
        TextView breed_limp_ratio = findViewById(R.id.breed_limp_ratio);
        TextView breed_hairloss_ratio_tv = findViewById(R.id.breed_hairloss_ratio);
        TextView breed_hairloss_score_tv = findViewById(R.id.breed_hairloss_score);
        TextView breed_runnynose_ratio_tv = findViewById(R.id.breed_runny_nose_ratio);



        breed_batch_Limp_ed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(TextUtils.isEmpty(breed_batch_Limp_ed.getText().toString())){
                    breed_limp_ratio.setText("값을 입력해주세요");
                    breed_limp_score.setText("값을 입력해주세요");
                }else {
                    float ratio = Float.parseFloat(breed_batch_Limp_ed.getText().toString()) / sample_size_count  ;
                    ratio = ratio * 100;
                    ratio = Math.round(ratio);
                    breed_limp_ratio.setText(String.valueOf(ratio));
                    limp_score = getLimpScore(ratio);
                    breed_limp_score.setText(String.valueOf(limp_score));
                }
            }
        });
        breed_slight_hairloss_ed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                setHairRatioScore(breed_slight_hairloss_ed,breed_critical_hairloss_ed,breed_hairloss_ratio_tv,breed_hairloss_score_tv);
            }
        });
        breed_critical_hairloss_ed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                setHairRatioScore(breed_slight_hairloss_ed,breed_critical_hairloss_ed,breed_hairloss_ratio_tv,breed_hairloss_score_tv);
            }
        });
        setRunnyNoseRatio(breed_runny_nose_ed,breed_runnynose_ratio_tv);
        rdiog_27_horn.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.breed_batch_horn_a27_1) {
                    horn = 1;
                } else if (checkedId == R.id.breed_batch_horn_a27_2) {
                    horn = 2;
                } else if (checkedId == R.id.breed_batch_horn_a27_3) {
                    horn = 3;
                } else if (checkedId == R.id.breed_batch_horn_a27_4) {
                    horn = 4;
                }
            }
        });

        rdiog_28_horn_anesthesia.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.breed_batch_horn_Anesthesia_a28_1) {
                    horn_Anesthesia = 1;
                } else if (checkedId == R.id.breed_batch_horn_Anesthesia_a28_2) {
                    horn_Anesthesia = 2;
                }
            }
        });

        rdiog_29_horn_painkiller.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.breed_batch_horn_Painkiller_a29_1) {
                    horn_Painkiller = 1;
                } else if (checkedId == R.id.breed_batch_horn_Painkiller_a29_2) {
                    horn_Painkiller = 2;
                }
            }
        });

        rdiog_30_castration.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.breed_batch_castration_a30_1) {
                    castration = 1;
                } else if (checkedId == R.id.breed_batch_castration_a30_2) {
                    castration = 2;
                } else if (checkedId == R.id.breed_batch_castration_a30_3) {
                    castration = 3;
                } else if (checkedId == R.id.breed_batch_castration_a30_4) {
                    castration = 4;
                }
            }
        });

        rdiog_31_castration_anesthesia.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.breed_batch_castration_Anesthesia_a31_1) {
                    castration_Anesthesia = 1;
                } else if (checkedId == R.id.breed_batch_castration_Anesthesia_a31_2) {
                    castration_Anesthesia = 2;
                }
            }
        });

        rdiog_32_castration_painkiller.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.breed_batch_castration_Painkiller_a32_1) {
                    castration_Painkiller = 1;
                } else if (checkedId == R.id.breed_batch_castration_Painkiller_a32_2) {
                    castration_Painkiller = 2;
                }
            }
        });

        Button breed_batch_pre_3_btn = (Button) findViewById(R.id.breed_batch_pre_3_btn);
        Button breed_batch_next_3_btn = (Button) findViewById(R.id.breed_batch_next_3_btn);

        breed_batch_pre_3_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        breed_batch_next_3_btn.setOnClickListener(new View.OnClickListener() { //fragment1로 이동
            @Override
            public void onClick(View v) {
                String limp = String.valueOf(breed_limp_score);
                String slight_hairloss = ed_18_slight_Hairloss.getText().toString();
                String critical_hairloss = ed_19_critical_Hairloss.getText().toString();
                String cought = ed_20_cough.getText().toString();
                String runny_nose = ed_21_runny_Nose.getText().toString();
                String ophthalmic_secretion = ed_22_ophthalmic_Secretion.getText().toString();
                String respiratory_failure = ed_23_respiratory_Failure.getText().toString();
                String diarrhea = ed_24_diarrhea.getText().toString();
                String ruminant = ed_25_ruminant.getText().toString();
                String fall_dead = ed_26_fall_Dead.getText().toString();

                String horn_1 = Integer.toString(horn);
                String horn_anesthesia = Integer.toString(horn_Anesthesia);
                String horn_painkiller = Integer.toString(horn_Painkiller);
                String castration_1 = Integer.toString(castration);
                String castration_anesthesia = Integer.toString(castration_Anesthesia);
                String castration_painkiller = Integer.toString(castration_Painkiller);

                String[] protocol3 = { limp, slight_hairloss, critical_hairloss, cought, runny_nose,
                        ophthalmic_secretion, respiratory_failure, diarrhea, ruminant, fall_dead };

                Intent intent_Breed_batch_4 = new Intent(Breed_batch_3.this, Breed_batch_4.class);
                startActivity(intent_Breed_batch_4);
            }
        });
    }
    private int getLimpScore(float limp)
    {
        int limpScore = 0;
        if (limp == 0) {
            limpScore = 100;
        } else if (limp <= 1.5) {
        limpScore = 90;
    } else if (limp <= 3) {
        limpScore = 80;
    } else if (limp <= 5) {
        limpScore = 70;
    } else if (limp <= 7) {
        limpScore = 60;
    } else if (limp <= 10) {
        limpScore = 50;
    } else if (limp <= 13) {
        limpScore = 40;
    } else if (limp <= 20) {
        limpScore = 30;
    } else if (limp <= 31) {
        limpScore = 20;
    } else if (limp <= 49) {
        limpScore = 10;
    } else {
        limpScore = 0;
    }
        return limpScore;
    }
    private int getHairLossScore(float hairLoss)
    {
        int hairLossScore = 0;
        if (hairLoss == 0) {
            hairLossScore = 100;
        } else if (hairLoss <= 4) {
        hairLossScore = 90;
    } else if (hairLoss <= 8) {
        hairLossScore = 80;
    } else if (hairLoss <= 13) {
        hairLossScore = 70;
    } else if (hairLoss <= 18) {
        hairLossScore = 60;
    } else if (hairLoss <= 24) {
        hairLossScore = 50;
    } else if (hairLoss <= 31) {
        hairLossScore = 40;
    } else if (hairLoss <= 40) {
        hairLossScore = 30;
    } else if (hairLoss <= 52) {
        hairLossScore = 20;
    } else if (hairLoss <= 72) {
        hairLossScore = 10;
    } else {
        hairLossScore = 0;
    }
        return hairLossScore;
    }
    private void setHairRatioScore(EditText slight_hairloss_ed, EditText critical_hairloss_ed, TextView hairloss_ratio_tv, TextView hairloss_score_tv){
        float slight_ratio = 0;
        float critical_ratio = 0;
        float ratio_total = 0;
        if(TextUtils.isEmpty(slight_hairloss_ed.getText().toString()) || TextUtils.isEmpty(critical_hairloss_ed.getText().toString())){
            hairloss_ratio_tv.setText("값을 입력해주세요");
            hairloss_score_tv.setText("값을 입력해주세요");
        }else {
            slight_ratio = Float.parseFloat(slight_hairloss_ed.getText().toString()) / sample_size_count  ;
            slight_ratio = slight_ratio * 100;
            critical_ratio = Float.parseFloat(critical_hairloss_ed.getText().toString()) / sample_size_count;
            critical_ratio = critical_ratio * 100;
            ratio_total = (slight_ratio + 5 * critical_ratio) / 5;
            ratio_total =  Math.round(ratio_total);
            hairloss_ratio_tv.setText(String.valueOf(ratio_total));
            int hairloss_score = getHairLossScore(ratio_total);

            hairloss_score_tv.setText(String.valueOf(hairloss_score));
        }
    }

    private float getRunnyNoseRatio(EditText runny_nose_ed){
            float ratio = (Float.parseFloat(runny_nose_ed.getText().toString()) / sample_size_count) * 100;
            ratio = Math.round(ratio);
            return ratio;
    }

    private void setRunnyNoseRatio(EditText runny_nose_ed, TextView runny_nose_ratio_tv){
        runny_nose_ed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(TextUtils.isEmpty(runny_nose_ed.getText().toString())){
                    runny_nose_ratio_tv.setText("값을 입력해주세요");
                } else {
                    runny_nose_ratio_tv.setText(String.valueOf(getRunnyNoseRatio(runny_nose_ed)));
                }
            }
        });
    }
}
