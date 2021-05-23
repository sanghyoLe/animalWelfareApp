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

        EditText breed_runny_nose_ed = findViewById(R.id.breed_runny_nose_ed);
        EditText breed_ophthalmic_ed = findViewById(R.id.breed_ophthalmic_ed);
        EditText breed_breath_ed = findViewById(R.id.breed_breath_ed);
        EditText breed_diarrhea_ed = findViewById(R.id.breed_diarrhea_ed);
        EditText breed_ruminant_ed = findViewById(R.id.breed_ruminant_ed);
        EditText breed_falldead_ed = findViewById(R.id.breed_falldead_ed);


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
        TextView breed_ophthalmic_ratio_tv = findViewById(R.id.breed_ophthalmic_ratio);
        TextView breed_breath_ratio_tv = findViewById(R.id.breed_breath_ratio);
        TextView breed_diarrhea_tv = findViewById(R.id.breed_diarrhea_ratio);
        TextView breed_ruminant_tv = findViewById(R.id.breed_ruminant_ratio);
        TextView breed_falldead_tv = findViewById(R.id.breed_falldead_ratio);
        TextView breed_horn_removal_score_tv = findViewById(R.id.breed_horn_removal_score);
        TextView breed_castration_score_tv = findViewById(R.id.breed_castration_score);

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
                    int dong_size = Integer.parseInt(dong_count);
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
                breed_horn_removal_score_tv.setText(Integer.toString(getHornRemovalScore(horn,horn_Anesthesia,horn_Painkiller)));
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
                breed_horn_removal_score_tv.setText(Integer.toString(getHornRemovalScore(horn,horn_Anesthesia,horn_Painkiller)));
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
                breed_horn_removal_score_tv.setText(Integer.toString(getHornRemovalScore(horn,horn_Anesthesia,horn_Painkiller)));
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
                breed_castration_score_tv.setText(Integer.toString(getCastrationScore(castration,castration_Anesthesia,castration_Painkiller)));
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
                breed_castration_score_tv.setText(Integer.toString(getCastrationScore(castration,castration_Anesthesia,castration_Painkiller)));
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
                breed_castration_score_tv.setText(Integer.toString(getCastrationScore(castration,castration_Anesthesia,castration_Painkiller)));
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

                Intent intent_Breed_batch_4 = new Intent(Breed_batch_3.this, Breed_batch_4.class);
                startActivity(intent_Breed_batch_4);
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        TextView breed_cough_ratio = findViewById(R.id.breed_cough_ratio);
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case 0:
                int key = data.getExtras().getInt("key");
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
                    textView.setText("값을 입력해주세요");
                } else {
                    if(getRatio(editText) > 100){
                        textView.setText("표본 규모보다 큰 값을 입력할 수 없습니다.");
                    } else {
                        textView.setText(String.valueOf(getRatio(editText)));
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

}
