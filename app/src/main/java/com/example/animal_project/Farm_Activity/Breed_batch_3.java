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

import com.example.animal_project.BreedBatchQuestion.Breed_cough;
import com.example.animal_project.BreedBatchQuestion.Breed_q4;
import com.example.animal_project.Input_userinfo;
import com.example.animal_project.R;

import java.util.HashMap;
import java.util.Map;

public class Breed_batch_3 extends AppCompatActivity {
    private View view;
    private String result;
    private Button btn_move;
    private EditText breed_batch_Limp_ed;
    Integer limp_score =0, dong_size = 0;
    int sample_size_count = Integer.parseInt(((Input_userinfo)Input_userinfo.context_userinfo).sample_size_count);
    private TextView breed_cough_ratio_tv,breed_runnynose_ratio_tv,breed_ophthalmic_ratio_tv,
            breed_breath_ratio_tv,breed_diarrhea_tv,breed_ruminant_tv,breed_falldead_tv,breed_disease_score_tv,
            breed_horn_removal_score_tv,breed_castration_score_tv, breed_min_pain_score;
    private double diseaseScore, minPainScore, minInjuryScore;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.breed_batch_3);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();


        breed_batch_Limp_ed = (EditText) findViewById(R.id.breed_batch_Limp_ed);

        EditText breed_slight_hairloss_ed = findViewById(R.id.breed_slight_hairloss_ed);
        EditText breed_critical_hairloss_ed = findViewById(R.id.breed_critical_hairloss_ed);

        EditText breed_runny_nose_ed = findViewById(R.id.breed_runny_nose_ed);
        EditText breed_ophthalmic_ed = findViewById(R.id.breed_ophthalmic_ed);
        EditText breed_breath_ed = findViewById(R.id.breed_breath_ed);
        EditText breed_diarrhea_ed = findViewById(R.id.breed_diarrhea_ed);
        EditText breed_ruminant_ed = findViewById(R.id.breed_ruminant_ed);
        EditText breed_falldead_ed = findViewById(R.id.breed_falldead_ed);


        RadioGroup breed_horn = (RadioGroup) findViewById(R.id.breed_batch_horn_rdogrp27);
        RadioGroup breed_horn_anesthesia = (RadioGroup) findViewById(R.id.breed_batch_horn_Anesthesia_rdogrp28);
        RadioGroup breed_horn_painkiller = (RadioGroup) findViewById(R.id.breed_batch_horn_Painkiller_rdogrp29);
        RadioGroup breed_castration = (RadioGroup) findViewById(R.id.breed_batch_castration_rdogrp30);
        RadioGroup breed_castration_anesthesia = (RadioGroup) findViewById(R.id.breed_batch_castration_Anesthesia_rdogrp31);
        RadioGroup breed_castration_painkiller = (RadioGroup) findViewById(R.id.breed_batch_castration_Painkiller_rdogrp32);
        TextView breed_limp_score = findViewById(R.id.breed_limp_score);
        TextView breed_limp_ratio = findViewById(R.id.breed_limp_ratio);
        TextView breed_hairloss_ratio_tv = findViewById(R.id.breed_hairloss_ratio);
        TextView breed_hairloss_score_tv = findViewById(R.id.breed_hairloss_score);
        TextView breed_min_injury_score = findViewById(R.id.breed_min_injury_score);
        breed_runnynose_ratio_tv = findViewById(R.id.breed_runny_nose_ratio);
        breed_ophthalmic_ratio_tv = findViewById(R.id.breed_ophthalmic_ratio);
        breed_breath_ratio_tv = findViewById(R.id.breed_breath_ratio);
        breed_diarrhea_tv = findViewById(R.id.breed_diarrhea_ratio);
        breed_ruminant_tv = findViewById(R.id.breed_ruminant_ratio);
        breed_falldead_tv = findViewById(R.id.breed_falldead_ratio);
        breed_disease_score_tv = findViewById(R.id.breed_disease_score);
        breed_cough_ratio_tv = findViewById(R.id.breed_cough_ratio);
        breed_horn_removal_score_tv = findViewById(R.id.breed_horn_removal_score);
        breed_castration_score_tv = findViewById(R.id.breed_castration_score);
        breed_min_pain_score = findViewById(R.id.breed_min_pain_score);

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
                    breed_limp_ratio.setText("값을 입력하세요");
                    breed_limp_score.setText("값을 입력하세요");
                }else {
                    float ratio = Float.parseFloat(breed_batch_Limp_ed.getText().toString()) / sample_size_count  ;
                    ratio = ratio * 100;
                    ratio = Math.round(ratio);
                    breed_limp_ratio.setText(String.valueOf(ratio));
                    limp_score = getLimpScore(ratio);
                    breed_limp_score.setText(String.valueOf(limp_score));
                    setMinimiztionOfInjury(breed_limp_score, breed_hairloss_score_tv, breed_min_injury_score);
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
                setMinimiztionOfInjury(breed_limp_score, breed_hairloss_score_tv, breed_min_injury_score);
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
                setMinimiztionOfInjury(breed_limp_score, breed_hairloss_score_tv, breed_min_injury_score);
            }
        });


        ArrayAdapter spinnerAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                R.array.dong_size,
                android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner mSpinner = findViewById(R.id.spinner_breed_cough);
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
        Button breed_btn_cough = findViewById(R.id.breed_btn_cough);


        breed_btn_cough.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String dong_count = Integer.toString(selectedItemIndex[0]);
                if(Integer.parseInt(dong_count) == 0){
                    String msg = "축사 동 수를 선택해주세요";
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                }else{
                    dong_size = Integer.parseInt(dong_count);
                    Intent intent = new Intent(Breed_batch_3.this, Breed_cough.class);
                    intent.putExtra("dong_count",dong_size); /*송신*/
                    startActivityForResult(intent, 0);
                }
            }
        });

        setRatioTextView(breed_runny_nose_ed,breed_runnynose_ratio_tv);
        setRatioTextView(breed_ophthalmic_ed,breed_ophthalmic_ratio_tv);
        setRatioTextView(breed_breath_ed,breed_breath_ratio_tv);
        setRatioTextView(breed_diarrhea_ed,breed_diarrhea_tv);
        setRatioTextView(breed_ruminant_ed,breed_ruminant_tv);
        setRatioTextView(breed_falldead_ed,breed_falldead_tv);

        setRemovalScore(breed_horn,breed_horn_anesthesia,breed_horn_painkiller,breed_horn_removal_score_tv);
        setCastrationScore(breed_castration,breed_castration_anesthesia,breed_castration_painkiller,breed_castration_score_tv);

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
    /*            String limp = String.valueOf(breed_limp_score);
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
                        ophthalmic_secretion, respiratory_failure, diarrhea, ruminant, fall_dead };*/
                double protocolThreeScore = setProtocolThreeResult(minInjuryScore,minPainScore,diseaseScore);
                bundle.putDouble("protocolThreeScore",protocolThreeScore);
                Intent intent_Breed_batch_4 = new Intent(Breed_batch_3.this, Breed_batch_4.class);
                intent_Breed_batch_4.putExtras(bundle);
                startActivity(intent_Breed_batch_4);
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        TextView breed_cough_ratio = findViewById(R.id.breed_cough_ratio);
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case 1:
                int key = data.getExtras().getInt("key");
                key = key / dong_size;
                breed_cough_ratio.setText(String.valueOf(key));

                break;
            default:
                break;
        }
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
            hairloss_ratio_tv.setText("값을 입력하세요");
            hairloss_score_tv.setText("값을 입력하세요");
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

    private float getRatio(EditText editText){
            float ratio = (Float.parseFloat(editText.getText().toString()) / sample_size_count) * 100;
            ratio = Math.round(ratio);
            return ratio;
    }

    private void setRatioTextView(EditText editText, TextView textView){
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(TextUtils.isEmpty(editText.getText().toString())){
                    textView.setText("값을 입력하세요");
                } else {
                    if(getRatio(editText) > 100){
                        textView.setText("표본 규모보다 큰 값을 입력할 수 없습니다.");
                    } else {
                        textView.setText(String.valueOf(getRatio(editText)));
                    } if(!isNumeric((String)breed_cough_ratio_tv.getText())
                            || !isNumeric((String)breed_runnynose_ratio_tv.getText())
                            || !isNumeric((String)breed_ophthalmic_ratio_tv.getText())
                            || !isNumeric((String)breed_breath_ratio_tv.getText())
                            || !isNumeric((String)breed_diarrhea_tv.getText())
                            || !isNumeric((String)breed_ruminant_tv.getText())
                            || !isNumeric((String)breed_falldead_tv.getText())) {
                        breed_disease_score_tv.setText("질병 영역에 대한 설문을 모두 완료하세요");
                    } else {
                        setDiseaseScore(breed_cough_ratio_tv
                                , breed_cough_ratio_tv
                                , breed_ophthalmic_ratio_tv
                                , breed_breath_ratio_tv
                                , breed_diarrhea_tv
                                , breed_ruminant_tv
                                , breed_falldead_tv
                                , breed_disease_score_tv);
                    }
                }
            }
        });
    }

    private int getHornRemovalScore(int horn, int hornAnesthesia, int hornPainkiller)
    {
        int hornRemovalScore = 0;
        // 제각안함
        if (horn == 1) {
            hornRemovalScore = 100;
        } // 송아지 제각 가열 방식
        else if (horn == 2) {
        // 마취제 사용
        if (hornAnesthesia == 1) {
            // 사후진통제 사용
            if (hornPainkiller == 1) {
                hornRemovalScore = 75;
            } else {
                hornRemovalScore = 52;
            }
        }
        // 마취제 미사용
        else {
            if (hornPainkiller == 1) {
                // 사후 진통제만 사용했을 경우 (누락 부분)
                hornRemovalScore = 49;
            }
            // 처치 없음
            else {
                hornRemovalScore = 28;
            }
        }
    }
        // 송아지 제각 화학적 방식
        else if (horn == 3) {
        // 마취제 사용
        if (hornAnesthesia == 1) {
            // 사후진통제 사용
            if (hornPainkiller == 1) {
                hornRemovalScore = 58;
            } else {
                hornRemovalScore = 39;
            }
        }
        // 마취제 미사용
        else {
            // 사후 진통제만 사용했을 경우 (누락 부분)
            if (hornPainkiller == 1) {
                hornRemovalScore = 41;
            } else {
                hornRemovalScore = 20;
            }
        }
    }
        // 성우 제각
        // 송아지는 사후진통제만 했을 때 점수가 마취제 점수보다 높은데 왜 성우는 더 높지 마취제가
    else {
        if (hornAnesthesia == 1) {
            if (hornPainkiller == 1) {
                hornRemovalScore = 27;
            } else {
                hornRemovalScore = 17;
            }
        } else {
            if (hornPainkiller == 1) {
                hornRemovalScore = 16;
            } else {
                hornRemovalScore = 2;
            }
        }
    }
        return hornRemovalScore;
    }
    private int getCastrationScore(int castration, int castrationAnesthesia, int castrationPainkiller)
    {
        int castrationScore = 0;
        // 거세 안함
        if (castration == 1) {
            castrationScore  = 100;
        }
        // 외과적 수술
        else if (castration == 2) {
            if (castrationAnesthesia == 1) {
                if (castrationPainkiller == 1) {
                    castrationScore = 34;
                } else {
                    castrationScore = 21;
                }
            } else {
                //"사후진통제"만 사용했을 경우 (누락 부분)
                if (castrationPainkiller == 1) {
                    castrationScore = 20;
                } else {
                    castrationScore = 0;
                }
            }
        }
        // 고무링
        else if (castration == 3) {
            if (castrationAnesthesia == 1) {
                if (castrationPainkiller == 1) {
                    castrationScore = 21;
                } else {
                    castrationScore = 17;
                }
            } else {
                //"사후진통제"만 사용했을 경우 (누락 부분)
                if (castrationPainkiller == 1) {
                    castrationScore = 17;
                } else {
                    castrationScore = 2;
                }
            }
        }
        // Burdizzo
        else if (castration == 4) {
            if (castrationAnesthesia == 1) {
                if (castrationPainkiller == 1) {
                    castrationScore = 35;
                } else {
                    castrationScore = 21;
                }
            } else {
                //"사후진통제"만 사용했을 경우 (누락 부분)
                if (castrationPainkiller == 1) {
                    castrationScore = 19;
                } else {
                    castrationScore = 0;
                }
            }
        }
        return castrationScore;
    }
    private void setRemovalScore(RadioGroup hornRg,RadioGroup anesthesiaRg, RadioGroup painkillerRg, TextView hornRemovalScoreTv){
        final int[] horn = {0};
        final int[] anesthesia = {0};
        final int[] painkiller = {0};
        final int[] score = {0};
        hornRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View radioButton = group.findViewById(checkedId);
                int index = group.indexOfChild(radioButton);
                switch (index) {
                    case 0:
                        horn[0] = 1;
                        score[0] = getHornRemovalScore(horn[0],anesthesia[0],painkiller[0]);
                        hornRemovalScoreTv.setText(String.valueOf(score[0]));
                        break;
                    case 1:
                        horn[0] = 2;
                        score[0] = getHornRemovalScore(horn[0],anesthesia[0],painkiller[0]);
                        hornRemovalScoreTv.setText(String.valueOf(score[0]));
                        break;
                    case 2:
                        horn[0] = 3;
                        score[0] = getHornRemovalScore(horn[0],anesthesia[0],painkiller[0]);
                        hornRemovalScoreTv.setText(String.valueOf(score[0]));
                    case 3:
                        horn[0] = 4;
                        score[0] = getHornRemovalScore(horn[0],anesthesia[0],painkiller[0]);
                        hornRemovalScoreTv.setText(String.valueOf(score[0]));

                }
                setMinPainScore(breed_horn_removal_score_tv,breed_castration_score_tv,breed_min_pain_score);
            }
        });

        anesthesiaRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View radioButton = group.findViewById(checkedId);
                int index = group.indexOfChild(radioButton);
                switch (index) {
                    case 0:
                        anesthesia[0] = 1;
                        score[0] = getHornRemovalScore(horn[0],anesthesia[0],painkiller[0]);
                        hornRemovalScoreTv.setText(String.valueOf(score[0]));
                        break;
                    case 1:
                        anesthesia[0] = 2;
                        score[0] = getHornRemovalScore(horn[0],anesthesia[0],painkiller[0]);
                        hornRemovalScoreTv.setText(String.valueOf(score[0]));
                        break;
                }
                setMinPainScore(breed_horn_removal_score_tv,breed_castration_score_tv,breed_min_pain_score);
            }
        });
        painkillerRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View radioButton = group.findViewById(checkedId);
                int index = group.indexOfChild(radioButton);
                switch (index) {
                    case 0:
                        painkiller[0] = 1;
                        score[0] = getHornRemovalScore(horn[0],anesthesia[0],painkiller[0]);
                        hornRemovalScoreTv.setText(String.valueOf(score[0]));
                        break;
                    case 1:
                        painkiller[0] = 2;
                        score[0] = getHornRemovalScore(horn[0],anesthesia[0],painkiller[0]);
                        hornRemovalScoreTv.setText(String.valueOf(score[0]));
                        break;
                }
                setMinPainScore(breed_horn_removal_score_tv,breed_castration_score_tv,breed_min_pain_score);
            }
        });
    }
    private void setCastrationScore(RadioGroup castrationRg, RadioGroup anesthesiaRg, RadioGroup painkillerRg, TextView castrationScoreTv) {
        int[] castration = {0};
        int[] anesthesia = {0};
        int[] painkiller = {0};
        int[] score = {0};

        castrationRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View radioButton = group.findViewById(checkedId);
                int index = group.indexOfChild(radioButton);
                switch (index) {
                    case 0:
                        castration[0] = 1;
                        score[0] = getCastrationScore(castration[0],anesthesia[0],painkiller[0]);
                        castrationScoreTv.setText(String.valueOf(score[0]));
                        break;
                    case 1:
                        castration[0] = 2;
                        score[0] = getCastrationScore(castration[0],anesthesia[0],painkiller[0]);
                        castrationScoreTv.setText(String.valueOf(score[0]));
                        break;
                    case 2:
                        castration[0] = 3;
                        score[0] = getCastrationScore(castration[0],anesthesia[0],painkiller[0]);
                        castrationScoreTv.setText(String.valueOf(score[0]));
                    case 3:
                        castration[0] = 4;
                        score[0] = getCastrationScore(castration[0],anesthesia[0],painkiller[0]);
                        castrationScoreTv.setText(String.valueOf(score[0]));

                }
                setMinPainScore(breed_horn_removal_score_tv,breed_castration_score_tv,breed_min_pain_score);
            }
        });

        anesthesiaRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View radioButton = group.findViewById(checkedId);
                int index = group.indexOfChild(radioButton);
                switch (index) {
                    case 0:
                        anesthesia[0] = 1;
                        score[0] = getCastrationScore(castration[0],anesthesia[0],painkiller[0]);
                        castrationScoreTv.setText(String.valueOf(score[0]));
                        break;
                    case 1:
                        anesthesia[0] = 2;
                        score[0] = getCastrationScore(castration[0],anesthesia[0],painkiller[0]);
                        castrationScoreTv.setText(String.valueOf(score[0]));
                        break;
                }
                setMinPainScore(breed_horn_removal_score_tv,breed_castration_score_tv,breed_min_pain_score);
            }
        });
        painkillerRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View radioButton = group.findViewById(checkedId);
                int index = group.indexOfChild(radioButton);
                switch (index) {
                    case 0:
                        painkiller[0] = 1;
                        score[0] = getCastrationScore(castration[0],anesthesia[0],painkiller[0]);
                        castrationScoreTv.setText(String.valueOf(score[0]));
                        break;
                    case 1:
                        painkiller[0] = 2;
                        score[0] = getCastrationScore(castration[0],anesthesia[0],painkiller[0]);
                        castrationScoreTv.setText(String.valueOf(score[0]));
                        break;
                }
                setMinPainScore(breed_horn_removal_score_tv,breed_castration_score_tv,breed_min_pain_score);
            }
        });

    }

    private void setMinimiztionOfInjury(TextView limpScoreTv, TextView hairLossScoreTv, TextView minInjuryScoreTv)
    {
      if(TextUtils.isEmpty(limpScoreTv.getText())
              || TextUtils.isEmpty(hairLossScoreTv.getText()) 
              || hairLossScoreTv.getText() == "값을 입력하세요"
      ){
            minInjuryScoreTv.setText("상해의 최소화 설문을 모두 완료해주세요");
      } else {
          int LimpScore = Integer.parseInt(String.valueOf(limpScoreTv.getText()));
          int hairLossScore = Integer.parseInt(String.valueOf(hairLossScoreTv.getText()));
          minInjuryScore = (LimpScore * 0.6) + (hairLossScore *0.4);
          minInjuryScore = Math.round(minInjuryScore);
          minInjuryScoreTv.setText(String.valueOf(minInjuryScore));
      }
    }
    private void setMinPainScore(TextView removalScoreTv, TextView castrationScoreTv, TextView minPainScoreTv)
    {
        if(TextUtils.isEmpty(removalScoreTv.getText())
                || TextUtils.isEmpty(castrationScoreTv.getText())
        ){
            minPainScoreTv.setText("고통의 최소화 설문을 모두 완료해주세요");
        } else {
            int removalScore = Integer.parseInt(String.valueOf(removalScoreTv.getText()));
            int castrationScore = Integer.parseInt(String.valueOf(castrationScoreTv.getText()));
            minPainScore = (removalScore * 0.7) + (castrationScore * 0.3);
            minPainScore = Math.round(minPainScore);
            minPainScoreTv.setText(String.valueOf(minPainScore));
        }
    }
    private Map getDiseaseSectionOne(TextView runnyNoseTv,TextView ophthalmicTv)
    {
         Map <String, Integer> sectionScores = new HashMap<String, Integer>();
         sectionScores.put("care",0);
         sectionScores.put("warning",0);

        Float runnyNose = Float.valueOf(String.valueOf(runnyNoseTv.getText()));
        Float ophthalmic = Float.valueOf(String.valueOf(ophthalmicTv.getText()));
        // 비강분비물 상태 좋음, 안구분비물 상태 좋음 => "0"
        if (runnyNose < 5 && ophthalmic < 3) {
            return sectionScores;
        }
        // 비강분비물 상태 좋음, 안구분비물(주의) => "주의"
        else if (runnyNose < 5 && 3 <= ophthalmic && ophthalmic < 6) {
            sectionScores.put("care",1);
    }
        // 비강분비물(주의), 안구분비물 상태 좋음 => "주의"
        else if (5 <= runnyNose && runnyNose < 10 && ophthalmic < 3) {
            sectionScores.put("care",1);
    }
        // 비강분비물(주의), 안구분비물(주의) => "주의"
        else if (5 <= runnyNose && runnyNose < 10 && 3 <= ophthalmic && ophthalmic < 6) {
            sectionScores.put("care",1);
    }
        // 비강, 안구분비물 중 1개라도 "경보" => "경보"
        else if (10 <= runnyNose || 6 <= ophthalmic) {
            sectionScores.put("warning",1);
    }
        return sectionScores;
    }
    private Map getDiseaseSectionTwo(TextView coughTv,TextView breathTv)
    {
        Map <String, Integer> sectionScores = new HashMap<String, Integer>();
        sectionScores.put("care",0);
        sectionScores.put("warning",0);

        float cough = Float.valueOf(String.valueOf(coughTv.getText()));
        float breath = Float.valueOf(String.valueOf(breathTv.getText()));

        // 비강분비물 상태 좋음, 안구분비물 상태 좋음 => "0"
        if (cough < 4 && breath < 5) {
            return sectionScores;
        }
        // 기침 상태 좋음, 호흡장애(주의) => "주의"
        else if (cough < 4 && 5 <= breath && breath < 10) {
            sectionScores.put("care",1);
        }
        // 기침(주의), 호흡장애 상태 좋음 => "주의"
        else if (4 <= cough && cough < 8 && breath < 4) {
            sectionScores.put("care",1);
        }
        // 기침(주의), 호흡장애(주의) => "주의"
        else if (4 <= cough && cough < 8 && 5 <= breath && breath < 10) {
            sectionScores.put("care",1);
        }
        // 기침, 호흡장애 중 1개라도 "경보" => "경보"
        else if (8 <= cough || 10 <= breath) {
            sectionScores.put("warning",1);
        }
        return sectionScores;
    }

    private Map getDiseaseSectionThree(TextView ruminantTv,TextView diarrheaTv)
    {
        Map <String, Integer> sectionScores = new HashMap<String, Integer>();
        sectionScores.put("care",0);
        sectionScores.put("warning",0);

        float ruminant = Float.valueOf(String.valueOf(ruminantTv.getText()));
        float diarrhea = Float.valueOf(String.valueOf(diarrheaTv.getText()));

        // 비강분비물 상태 좋음, 안구분비물 상태 좋음 => "0"
        if (ruminant < 5 && diarrhea < 3) {
            return sectionScores;
        }
        // 반추위 팽창 상태 좋음, 설사(주의) => "주의"
        else if (ruminant < 5 && 3 <= diarrhea && diarrhea < 6) {
            sectionScores.put("care",1);
    }
        // 반추위 팽창(주의), 설사 좋음 => "주의"
        else if (5 <= ruminant && ruminant < 10 && diarrhea < 3) {
            sectionScores.put("care",1);
    }
        // 반추위 팽창(주의), 설사(주의) => "주의"
        else if (5 <= ruminant && ruminant < 10 && 3 <= diarrhea && diarrhea < 6) {
            sectionScores.put("care",1);
    }
        // 반추위 팽창 ,설사 중 1개라도 "경보" => "경보"
        else if (10 <= ruminant || 6 <= diarrhea) {
            sectionScores.put("warning",1);
    }
        return sectionScores;
    }
    private Map getDiseaseSectionFour(TextView fallDeadTv)
    {
        Map <String, Integer> sectionScores = new HashMap<String, Integer>();
        sectionScores.put("care",0);
        sectionScores.put("warning",0);
        float fallDead = 0;
        if(!isNumeric((String)fallDeadTv.getText())){
            fallDead = 0;
        } else {
            fallDead = Float.valueOf(String.valueOf(fallDeadTv.getText()));
        }

        if (fallDead < 2)
            return sectionScores;
        // 폐사율 상태 주의
        if (2 <= fallDead && fallDead < 4) {
            sectionScores.put("care",1);
            // 폐사율 상태 경보  
        } else if (4 <= fallDead) {
            sectionScores.put("warning",1);
    }
        return sectionScores;
    }
    private Map getCareWarningScore(Map sectionOneScore, Map sectionTwoScore, Map sectionThreeScore, Map sectionFourScore)
    {
        Map <String, Integer> careWarningScore = new HashMap<String, Integer>();
        int totalCareScore = (int) sectionOneScore.get("care")
                + (int) sectionTwoScore.get("care")
                + (int) sectionThreeScore.get("care")
                + (int) sectionFourScore.get("care");
        careWarningScore.put("care",totalCareScore);
        int totalWarningScore = (int) sectionOneScore.get("warning")
                + (int) sectionTwoScore.get("warning")
                + (int) sectionThreeScore.get("warning")
                + (int) sectionFourScore.get("warning");
        careWarningScore.put("warning",totalWarningScore);

        return careWarningScore;
    }
    private double getDiseaseScore(Map careWarningScore)
    {
        int careScore = (int)careWarningScore.get("care");
        int warningScore = (int)careWarningScore.get("warning");
        diseaseScore = (100 / 4) * (4 - ((careScore) + 3 * (warningScore)) / 3);

        return Math.round(diseaseScore);
    }

    private void setDiseaseScore(TextView coughTv, TextView runnyNoseTv, TextView ophthalmicTv, TextView breathTv,
                                 TextView diarrheaTv, TextView ruminantTv, TextView fallDeadTv, TextView diseaseScoreTv){
            Map <String,Integer>CareWarningScore = new HashMap <String,Integer>();
            CareWarningScore = getCareWarningScore
                (
                    getDiseaseSectionOne(runnyNoseTv,ophthalmicTv),
                    getDiseaseSectionTwo(coughTv,breathTv),
                    getDiseaseSectionThree(ruminantTv,diarrheaTv),
                    getDiseaseSectionFour(fallDeadTv)
                );

            diseaseScoreTv.setText(String.valueOf(getDiseaseScore(CareWarningScore)));



    }

    private static boolean isNumeric(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }
    private double setProtocolThreeResult(double minInjuryScore, double minPainScore, double diseaseScore){
        return (minInjuryScore * 0.35) + (diseaseScore * 0.4) + (minPainScore * 0.25);
    }
}
