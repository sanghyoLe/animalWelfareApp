package com.example.animal_project.Freestall.ProtocolThree;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.animal_project.InputUserInfo;
import com.example.animal_project.MilkCowViewModel;
import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;


public class FreestallCriticalHairloss extends Fragment {
    private View view;
//    public String sample_size_count = ((Input_userinfo)Input_userinfo.context_userinfo).sample_size_count;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_freestall_critical_hairloss, container, false);
        MilkCowViewModel viewModel = new ViewModelProvider(getActivity()).get(MilkCowViewModel.class);
        QuestionTemplateViewModel viewModel2 = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);

        TextView ratio_number = (TextView) view.findViewById(R.id.ratio_number);
        EditText hairloss_a2 = (EditText) view.findViewById(R.id.hairloss_a2);
        TextView hairloss_ratio_2 = (TextView) view.findViewById(R.id.hairloss_ratio_2);
        TextView hairloss_score_1 = (TextView) view.findViewById(R.id.hairloss_score_1);
        TextView freestallMinInjuryScoreTv = view.findViewById(R.id.freestall_min_injury_score_tv);

        ratio_number.setText(String.valueOf(viewModel2.getSampleCowSize())); //표본 두수 표시
        hairloss_a2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(viewModel.getSlightHairLoss() == -1)
                {
                    hairloss_ratio_2.setText("경미한 외피변형 문항을 완료하세요");
                    hairloss_score_1.setText("경미한 외피변형 문항을 완료하세요");
                }  else if(TextUtils.isEmpty(hairloss_a2.getText().toString())){
                    hairloss_ratio_2.setText("문항을 완료하세요");
                    hairloss_score_1.setText("문항을 완료하세요");
                }

                else {
                    float criticalHairLoss = 0;
                    criticalHairLoss = Float.parseFloat(hairloss_a2.getText().toString());
                    if((int)(viewModel.getSlightHairLoss() + criticalHairLoss) > viewModel2.getSampleCowSize()) {
                        hairloss_ratio_2.setText("표본 두수보다 큰 값을 입력하셨습니다");
                    } else {
                        float slight_ratio;
                        float critical_ratio;
                        float ratio_total;
                        slight_ratio = viewModel.getSlightHairLoss() / viewModel2.getSampleCowSize() ;
                        slight_ratio = slight_ratio * 100;
                        critical_ratio = criticalHairLoss / viewModel2.getSampleCowSize();
                        critical_ratio = critical_ratio * 100;
                        ratio_total = (slight_ratio + 5 * critical_ratio) / 5;
                        ratio_total =  Math.round(ratio_total);
                        hairloss_ratio_2.setText(String.valueOf(ratio_total));
                        int hair_loss_score = viewModel.calculatorHairLossScore(ratio_total);
                        viewModel.setHairLossScore(hair_loss_score);
                        hairloss_score_1.setText(String.valueOf(hair_loss_score));
                        if(viewModel.getLimpScore() == -1){
                            freestallMinInjuryScoreTv.setText("다리 절음 평가를 완료해주세요");
                        } else{
                            long minInjuryScore = viewModel.calculatorFrestallMinInjuryScore(viewModel.getLimpScore(),viewModel.getHairLossScore());
                            freestallMinInjuryScoreTv.setText(String.valueOf(minInjuryScore));
                            viewModel.setMinInjuryScore(minInjuryScore);
                        }

                    }

                }
            }
        });

        return view;
    }
    public int getSlightHairlossRatio(int freestall_slight_hairloss_22_et) {
        String sample_size_count = ((InputUserInfo) InputUserInfo.context_userinfo).sample_size_count;
        float sample_count = Float.parseFloat(sample_size_count);
        float slightHairLossRatio = (freestall_slight_hairloss_22_et / sample_count) * 100;
        return Math.round(slightHairLossRatio);
    }
    public int getCriticalHairlossRatio(int freestall_critical_hairloss_22_et) {
        String sample_size_count = ((InputUserInfo) InputUserInfo.context_userinfo).sample_size_count;
        float sample_count = Float.parseFloat(sample_size_count);
        float criticalHairLossRatio = (freestall_critical_hairloss_22_et / sample_count) * 100;
        return Math.round(criticalHairLossRatio);
    }
    public int getHairlossScore(int freestall_slight_hairloss_22_et, int freestall_critical_hairloss_22_et) {
        float slightHairlossRatio = getSlightHairlossRatio(freestall_slight_hairloss_22_et);
        float criticalHairlossRatio = getCriticalHairlossRatio(freestall_critical_hairloss_22_et);
        float totalHairlossRatio = (slightHairlossRatio + 5 * criticalHairlossRatio) / 5;
        int hairlossScore = 0;
        if(totalHairlossRatio >= 73) {
            hairlossScore = 0;
        }
        else if(totalHairlossRatio >= 53) {
            hairlossScore = 10;
        }
        else if(totalHairlossRatio >= 41) {
            hairlossScore = 20;
        }
        else if(totalHairlossRatio >= 32) {
            hairlossScore = 30;
        }
        else if(totalHairlossRatio >= 25) {
            hairlossScore = 40;
        }
        else if(totalHairlossRatio >= 19) {
            hairlossScore = 50;
        }
        else if(totalHairlossRatio >= 14) {
            hairlossScore = 60;
        }
        else if(totalHairlossRatio >= 9) {
            hairlossScore = 70;
        }
        else if(totalHairlossRatio >= 5) {
            hairlossScore = 80;
        }
        else if(totalHairlossRatio >= 1) {
            hairlossScore = 90;
        }
        else
            hairlossScore = 10;
        return hairlossScore;
    }
    public void setSlightHairlossRatio(int freestall_slight_hairloss_22_et, TextView freestall_slight_hairloss_ratio_tv) {
        int freestallSlightHairlossRatio = getSlightHairlossRatio(freestall_slight_hairloss_22_et);
        freestall_slight_hairloss_ratio_tv.setText(String.valueOf(freestallSlightHairlossRatio));
    }
    public void setCriticalHairlossRatio(int freestall_critical_hairloss_22_et, TextView freestall_critical_hairloss_ratio_tv) {
        int freestallCriticalHairlossRatio = getCriticalHairlossRatio(freestall_critical_hairloss_22_et);
        freestall_critical_hairloss_ratio_tv.setText(String.valueOf(freestallCriticalHairlossRatio));
    }
    public void setHairlossScore(EditText freestall_slight_hairloss_22_et, TextView freestall_slight_hairloss_ratio_tv, EditText freestall_critical_hairloss_22_et, TextView freestall_critical_hairloss_ratio_tv, TextView freestall_hairloss_score_tv) {
        String sample_size_count = ((InputUserInfo) InputUserInfo.context_userinfo).sample_size_count;
        int freestallSlightHairloss = 0;
        int freestallCriticalHairloss = 0;

        if(!TextUtils.isEmpty(freestall_slight_hairloss_22_et.getText())) {
            freestallSlightHairloss = Integer.parseInt(freestall_slight_hairloss_22_et.getText().toString());
        }
        else if(TextUtils.isEmpty(freestall_slight_hairloss_22_et.getText())) {
            freestall_slight_hairloss_ratio_tv.setText("값을 입력해주세요");
        }
        else if(Integer.parseInt(freestall_slight_hairloss_22_et.getText().toString()) > Integer.parseInt(sample_size_count)) {
            freestall_slight_hairloss_ratio_tv.setText("표본 규모보다 큰 수는 입력할 수 없습니다.");
        }
        if(!TextUtils.isEmpty(freestall_critical_hairloss_22_et.getText())) {
            freestallCriticalHairloss = Integer.parseInt(freestall_critical_hairloss_22_et.getText().toString());
        }
        else if(TextUtils.isEmpty(freestall_critical_hairloss_22_et.getText())) {
            freestall_critical_hairloss_ratio_tv.setText("갑을 입력해주세요");
        }
        else if(Integer.parseInt(freestall_critical_hairloss_22_et.getText().toString()) > Integer.parseInt(sample_size_count)) {
            freestall_critical_hairloss_ratio_tv.setText("표본 규모보다 큰 수는 입력할 수 없습니다.");
        }
        int slightHairloss = getSlightHairlossRatio(freestallSlightHairloss);
        int criticalHairloss = getCriticalHairlossRatio(freestallCriticalHairloss);
        Log.d("slightHairloss: ", String.valueOf(slightHairloss));
        Log.d("criticalHairloss: ", String.valueOf(criticalHairloss));
        setSlightHairlossRatio(freestallSlightHairloss, freestall_slight_hairloss_ratio_tv);
        setCriticalHairlossRatio(freestallCriticalHairloss, freestall_critical_hairloss_ratio_tv);

        int hairlossScore = getHairlossScore(slightHairloss, criticalHairloss);
        Log.d("hairlossScore: ", String.valueOf(hairlossScore));
        freestall_hairloss_score_tv.setText(String.valueOf(hairlossScore));
    }
    public void setHairlossTv(EditText freestall_slight_hairloss_22_et, TextView freestall_slight_hairloss_ratio_tv, EditText freestall_critical_hairloss_22_et, TextView freestall_critical_hairloss_ratio_tv, TextView freestall_hairloss_score_tv) {
        freestall_slight_hairloss_22_et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                setHairlossScore(freestall_slight_hairloss_22_et, freestall_slight_hairloss_ratio_tv, freestall_critical_hairloss_22_et, freestall_critical_hairloss_ratio_tv, freestall_hairloss_score_tv);
            }
        });
        freestall_critical_hairloss_22_et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                setHairlossScore(freestall_slight_hairloss_22_et, freestall_slight_hairloss_ratio_tv, freestall_critical_hairloss_22_et, freestall_critical_hairloss_ratio_tv, freestall_hairloss_score_tv);
            }
        });
    }
}