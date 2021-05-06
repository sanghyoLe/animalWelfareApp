package com.example.animal_project.Farm_Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.animal_project.MainActivity;
import com.example.animal_project.R;

public class MilkCow_3 extends AppCompatActivity {
    private View view;
    private String result;
    private Button btn_move;
    Integer horn = 0, horn_Anesthesia = 0, horn_Painkiller = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.milkcow_3);

        ScrollView scrollview_milk_3 = findViewById(R.id.scrollview_milk_3);
        TextView milk_slight_Limp_q17 = (TextView) findViewById(R.id.milk_slight_Limp_q17);
        TextView milk_slight_Hairloss_q19 = (TextView) findViewById(R.id.milk_slight_Hairloss_q19);
        TextView milk_critical_Hairloss_q20 = (TextView) findViewById(R.id.milk_critical_Hairloss_q20);
        TextView milk_cough_q21 = (TextView) findViewById(R.id.milk_cough_q21);
        TextView milk_runny_Nose_q22 = (TextView) findViewById(R.id.milk_runny_Nose_q22);
        TextView milk_ophthalmic_Secretion_q23 = (TextView) findViewById(R.id.milk_ophthalmic_Secretion_q23);
        TextView milk_respiratory_Failure_q24 = (TextView) findViewById(R.id.milk_respiratory_Failure_q24);
        TextView milk_diarrhea_q25 = (TextView) findViewById(R.id.milk_diarrhea_q25);
        TextView milk_out_Genitals_Secretion_q26 = (TextView) findViewById(R.id.milk_out_Genitals_Secretion_q26);
        TextView milk_breast_Inflammation_q27 = (TextView) findViewById(R.id.milk_breast_Inflammation_q27);
        TextView milk_fall_Dead_q28 = (TextView) findViewById(R.id.milk_fall_Dead_q28);
        TextView milk_dystocia_q29 = (TextView) findViewById(R.id.milk_dystocia_q29);
        TextView milk_astasia_q30 = (TextView) findViewById(R.id.milk_astasia_q30);
        TextView milk_horn_q31 = (TextView) findViewById(R.id.milk_horn_q31);
        TextView milk_horn_Anesthesia_q32 = (TextView) findViewById(R.id.milk_horn_Anesthesia_q32);
        TextView milk_horn_Painkiller_q33 = (TextView) findViewById(R.id.milk_horn_Painkiller_q33);

        EditText ed_17_slight_Limp = findViewById(R.id.milk_slight_Limp_a17);
        EditText ed_18_critical_Limp = findViewById(R.id.milk_critical_Limp_a18);
        EditText ed_19_slight_Hairloss = findViewById(R.id.milk_slight_Hairloss_a19);
        EditText ed_20_critical_Hairloss = findViewById(R.id.milk_critical_Hairloss_a20);
        EditText ed_21_cought = findViewById(R.id.milk_cough_a21);
        EditText ed_22_runny_Nose = findViewById(R.id.milk_runny_Nose_a22);
        EditText ed_23_ophthalmic_Secretion = findViewById(R.id.milk_ophthalmic_Secretion_a23);
        EditText ed_24_respiratory_Failure = findViewById(R.id.milk_respiratory_Failure_a24);
        EditText ed_25_diarrhea = findViewById(R.id.milk_diarrhea_a25);
        EditText ed_26_out_Genitals_Secretion = findViewById(R.id.milk_out_Genitals_Secretion_a26);
        EditText ed_27_breast_Inflammation = findViewById(R.id.milk_breast_Inflammation_a27);
        EditText ed_28_fall_Dead = findViewById(R.id.milk_fall_Dead_a28);
        EditText ed_29_dystocia = findViewById(R.id.milk_dystocia_a29);
        EditText ed_30_astasia = findViewById(R.id.milk_astasia_a30);

        RadioGroup rdiog_31_horn = (RadioGroup) findViewById(R.id.milk_horn_rdogrp31); //31번 문항
        RadioGroup rdiog_32_horn_anesthesia = (RadioGroup) findViewById(R.id.milk_horn_Anesthesia_rdogrp32); //32번 문항
        RadioGroup rdiog_33_horn_painkiller = (RadioGroup) findViewById(R.id.milk_horn_Painkiller_rdogrp33); //33번 문항

        rdiog_31_horn.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ((MainActivity)MainActivity.mContext).scrollToView(milk_horn_Anesthesia_q32,scrollview_milk_3,0);
                if (checkedId == R.id.milk_horn_a31_1) {
                    horn = 1;
                } else if (checkedId == R.id.milk_horn_a31_2) {
                    horn = 2;
                } else if (checkedId == R.id.milk_horn_a31_3) {
                    horn = 3;
                } else if (checkedId == R.id.milk_horn_a31_4) {
                    horn = 4;
                }
            }
        });

        rdiog_32_horn_anesthesia.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ((MainActivity)MainActivity.mContext).scrollToView(milk_horn_Painkiller_q33,scrollview_milk_3,0);
                if (checkedId == R.id.milk_horn_Anesthesia_a32_1) {
                    horn_Anesthesia = 1;
                } else if (checkedId == R.id.milk_horn_Anesthesia_a32_2) {
                    horn_Anesthesia = 2;
                }
            }
        });

        rdiog_33_horn_painkiller.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.milk_horn_Painkiller_a33_1) {
                    horn_Painkiller = 1;
                } else if (checkedId == R.id.milk_horn_Painkiller_a33_2) {
                    horn_Painkiller = 2;
                }
            }
        });

        Button milkcow_pre_3_btn = (Button) findViewById(R.id.milkcow_pre_3_btn);
        Button milkcow_next_3_btn = (Button) findViewById(R.id.milkcow_next_3_btn);

        milkcow_pre_3_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        milkcow_next_3_btn.setOnClickListener(new View.OnClickListener() { //fragment1로 이동
            @Override
            public void onClick(View v) {
                String slight_limp = ed_17_slight_Limp.getText().toString();
                String critical_limp = ed_18_critical_Limp.getText().toString();
                String slight_hairloss = ed_19_slight_Hairloss.getText().toString();
                String critical_hairloss = ed_20_critical_Hairloss.getText().toString();
                String cought = ed_21_cought.getText().toString();
                String runny_nose = ed_22_runny_Nose.getText().toString();
                String ophthalmic_secretion = ed_23_ophthalmic_Secretion.getText().toString();
                String respiratory_failure = ed_24_respiratory_Failure.getText().toString();
                String diarrhea = ed_25_diarrhea.getText().toString();
                String out_genitals_secretion = ed_26_out_Genitals_Secretion.getText().toString();
                String breast_inflammation = ed_27_breast_Inflammation.getText().toString();
                String fall_dead = ed_28_fall_Dead.getText().toString();
                String dystocia = ed_29_dystocia.getText().toString();
                String astasia = ed_30_astasia.getText().toString();
                String horn_1 = Integer.toString(horn);
                String horn_anesthesia = Integer.toString(horn_Anesthesia);
                String horn_painkiller = Integer.toString(horn_Painkiller);

                String[] protocol3 = {slight_limp, critical_limp, slight_hairloss, critical_hairloss, cought, runny_nose, ophthalmic_secretion, respiratory_failure,
                        diarrhea, out_genitals_secretion, breast_inflammation, fall_dead, dystocia, astasia, horn_1, horn_anesthesia, horn_painkiller};

                Intent intent_MilkCow_4 = new Intent(MilkCow_3.this, MilkCow_4.class);
                startActivity(intent_MilkCow_4);
            }
        });
    }
}
