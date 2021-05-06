package com.example.animal_project.Farm_Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.animal_project.R;

public class Breed_batch_3 extends AppCompatActivity {
    private View view;
    private String result;
    private Button btn_move;
    private EditText ed_17_Limp, ed_18_slight_Hairloss, ed_19_critical_Hairloss,
            ed_20_cough, ed_21_runny_Nose, ed_22_ophthalmic_Secretion, ed_23_respiratory_Failure, ed_24_diarrhea,
            ed_25_ruminant, ed_26_fall_Dead;
    Integer horn = 0, horn_Anesthesia = 0, horn_Painkiller = 0, castration = 0, castration_Anesthesia = 0,
            castration_Painkiller = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.breed_batch_3);

        ed_17_Limp = (EditText) findViewById(R.id.breed_batch_Limp_a17);
        ed_18_slight_Hairloss = (EditText) findViewById(R.id.breed_batch_slight_Hairloss_a18);
        ed_19_critical_Hairloss = (EditText) findViewById(R.id.breed_batch_critical_Hairloss_a19);
        ed_20_cough = (EditText) findViewById(R.id.breed_batch_cough_a20);
        ed_21_runny_Nose = (EditText) findViewById(R.id.breed_batch_runny_Nose_a21);
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
                String limp = ed_17_Limp.getText().toString();
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
}
