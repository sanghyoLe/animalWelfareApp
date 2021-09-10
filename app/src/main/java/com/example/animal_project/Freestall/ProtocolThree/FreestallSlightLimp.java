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


public class FreestallSlightLimp extends Fragment {
    private View view;
//    public String sample_size_count = ((Input_userinfo)Input_userinfo.context_userinfo).sample_size_count;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_freestall_slight_limp, container, false);
        MilkCowViewModel viewModel = new ViewModelProvider(getActivity()).get(MilkCowViewModel.class);
        QuestionTemplateViewModel viewModel2 = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);
        TextView ratio_number = (TextView) view.findViewById(R.id.ratio_number);
        EditText limp_a1 = (EditText) view.findViewById(R.id.limp_a1);
        TextView slight_limp_ratio = (TextView) view.findViewById(R.id.limp_ratio_1);

        ratio_number.setText(String.valueOf(viewModel2.getSampleCowSize())); //표본 두수 표시
        limp_a1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(TextUtils.isEmpty(limp_a1.getText().toString())){
                    slight_limp_ratio.setText("값을 입력해주세요");
                    viewModel.setSlightLimp(-1);
                } else if (Integer.parseInt(limp_a1.getText().toString()) > viewModel2.getSampleCowSize()) {
                    slight_limp_ratio.setText("표본 두수보다 큰 값을 입력할 수 없습니다.");
                } else {
                    float slightLimp = 0;
                    float ratio = Float.parseFloat(limp_a1.getText().toString()) / viewModel2.getSampleCowSize();
                    ratio = ratio * 100;
                    ratio = Math.round(ratio);
                    slight_limp_ratio.setText(String.valueOf(ratio));
                    slightLimp = Float.parseFloat(limp_a1.getText().toString());
                    viewModel.setSlightLimp(slightLimp);
                }
            }
        });
        return view;
    }
    public int getSlightLimpRatio(int freestall_slight_20_et) {
        String sample_size_count = ((InputUserInfo) InputUserInfo.context_userinfo).sample_size_count;
        float sample_count = Float.parseFloat(sample_size_count);
        float slightLimpRatio = (freestall_slight_20_et / sample_count) * 100;
        return Math.round(slightLimpRatio);
    }
    public int getCriticalLimpRatio(int freestall_critical_21_et) {
        String sample_size_count = ((InputUserInfo) InputUserInfo.context_userinfo).sample_size_count;
        float sample_count = Float.parseFloat(sample_size_count);
        float criticalLimpRatio = (freestall_critical_21_et / sample_count) * 100;
        return Math.round(criticalLimpRatio);
    }
    public int getLimpScore(int freestall_slight_20_et, int freestall_critical_21_et) {
        float slightLimpRatio = getSlightLimpRatio(freestall_slight_20_et);
        float criticalLimpRatio = getCriticalLimpRatio(freestall_critical_21_et);
        double totalLimpRatio = (slightLimpRatio / 3.45 * criticalLimpRatio) / 3.45;
        int limpScore = 0;
        if(totalLimpRatio >= 49) {
            limpScore = 0;
        }
        else if(totalLimpRatio >= 32) {
            limpScore = 10;
        }
        else if(totalLimpRatio >= 21) {
            limpScore = 20;
        }
        else if(totalLimpRatio >= 14) {
            limpScore = 30;
        }
        else if(totalLimpRatio >= 11) {
            limpScore = 40;
        }
        else if(totalLimpRatio >= 8) {
            limpScore = 50;
        }
        else if(totalLimpRatio >= 6) {
            limpScore = 60;
        }
        else if(totalLimpRatio >= 4) {
            limpScore = 70;
        }
        else if(totalLimpRatio >= 1.6) {
            limpScore = 80;
        }
        else if(totalLimpRatio >= 0.1) {
            limpScore = 90;
        }
        else
            limpScore = 100;
        return limpScore;
    }
    public void setSlightLimpRatio(int freestall_slight_20_et, TextView freestall_slight_20_ratio) {
        int freestallSlightLimpRatio = getSlightLimpRatio(freestall_slight_20_et);
        freestall_slight_20_ratio.setText(String.valueOf(freestallSlightLimpRatio));
    }
    public void setCriticalLimpRatio(int freestall_critical_21_et, TextView freestall_critical_21_ratio) {
        int freestallCriticalLimpRatio = getCriticalLimpRatio(freestall_critical_21_et);
        freestall_critical_21_ratio.setText(String.valueOf(freestallCriticalLimpRatio));
    }
    public void setLimpScore(EditText freestall_slight_20_et, TextView freestall_slight_20_ratio, EditText freestall_critical_21_et, TextView freestall_critical_21_ratio, TextView freestall_limp_score) {
        String sample_size_count = ((InputUserInfo) InputUserInfo.context_userinfo).sample_size_count;
        int freestallSlightLimp = 0;
        int freestallCriticalLimp = 0;

        if(!TextUtils.isEmpty(freestall_slight_20_et.getText())) {
            freestallSlightLimp = Integer.parseInt(freestall_slight_20_et.getText().toString());
        }
        else if(TextUtils.isEmpty(freestall_slight_20_et.getText())) {
            freestall_slight_20_ratio.setText("값을 입력해주세요");
        }
        else if(Integer.parseInt(freestall_slight_20_et.getText().toString()) > Integer.parseInt(sample_size_count)) {
            freestall_slight_20_ratio.setText("표본 규모보다 큰 수는 입력할 수 없습니다.");
        }
        if(!TextUtils.isEmpty(freestall_critical_21_et.getText())) {
            freestallCriticalLimp = Integer.parseInt(freestall_critical_21_et.getText().toString());
        }
        else if(TextUtils.isEmpty(freestall_critical_21_et.getText())) {
            freestall_critical_21_ratio.setText("갑을 입력해주세요");
        }
        else if(Integer.parseInt(freestall_critical_21_et.getText().toString()) > Integer.parseInt(sample_size_count)) {
            freestall_critical_21_ratio.setText("표본 규모보다 큰 수는 입력할 수 없습니다.");
        }
        int slightLimp = getSlightLimpRatio(freestallSlightLimp);
        int criticalLimp = getCriticalLimpRatio(freestallCriticalLimp);
        Log.d("slightLimp: ", String.valueOf(slightLimp));
        Log.d("criticalLimp: ", String.valueOf(criticalLimp));
        setSlightLimpRatio(freestallSlightLimp, freestall_slight_20_ratio);
        setCriticalLimpRatio(freestallCriticalLimp, freestall_critical_21_ratio);

        int limpScore = getLimpScore(slightLimp, criticalLimp);
        Log.d("limpScore: ", String.valueOf(limpScore));
        freestall_limp_score.setText(String.valueOf(limpScore));
    }
    public void setLimpTv(EditText freestall_slight_20_et, TextView freestall_slight_20_ratio, EditText freestall_critical_21_et, TextView freestall_critical_21_ratio, TextView freestall_limp_score) {
        freestall_slight_20_et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                setLimpScore(freestall_slight_20_et, freestall_slight_20_ratio, freestall_critical_21_et, freestall_critical_21_ratio, freestall_limp_score);
            }
        });
        freestall_critical_21_et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                setLimpScore(freestall_slight_20_et, freestall_slight_20_ratio, freestall_critical_21_et, freestall_critical_21_ratio, freestall_limp_score);
            }
        });
    }
}