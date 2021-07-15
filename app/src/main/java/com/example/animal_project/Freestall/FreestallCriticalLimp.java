package com.example.animal_project.Freestall;


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

import com.example.animal_project.Input_userinfo;
import com.example.animal_project.MilkCowViewModel;
import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;


public class FreestallCriticalLimp extends Fragment {
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_freestall_critical_limp, container, false);
        MilkCowViewModel viewModel = new ViewModelProvider(getActivity()).get(MilkCowViewModel.class);
        QuestionTemplateViewModel viewModel2 = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);
        TextView ratio_number = (TextView) view.findViewById(R.id.ratio_number);
        EditText limp_a2 = (EditText) view.findViewById(R.id.limp_a2 );
        TextView limp_ratio_2 = (TextView) view.findViewById(R.id.limp_ratio_2);
        TextView limp_score_1 = (TextView) view.findViewById(R.id.limp_score_1);

        ratio_number.setText(String.valueOf(viewModel2.getSampleCowSize())); //표본 두수 표시
        limp_a2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(viewModel.getSlightLimp() == -1)
                {
                    limp_ratio_2.setText("경미한 다리절음 문항을 완료하세요");
                    limp_score_1.setText("경미한 다리절음 문항을 완료하세요");
                }  else if(TextUtils.isEmpty(limp_a2.getText().toString())){
                    limp_ratio_2.setText("문항을 완료하세요");
                    limp_score_1.setText("문항을 완료하세요");
                }

                else {
                    float criticalLimp = 0;
                    criticalLimp = Float.parseFloat(limp_a2.getText().toString());
                    if ((int) (viewModel.getSlightLimp() + criticalLimp) > viewModel2.getSampleCowSize()) {
                        limp_ratio_2.setText("표본 두수보다 큰 값을 입력하셨습니다");
                    } else {
                        float slight_ratio;
                        float critical_ratio;
                        double ratio_total;
                        slight_ratio = viewModel.getSlightLimp() / viewModel2.getSampleCowSize();
                        slight_ratio = slight_ratio * 100;
                        critical_ratio = criticalLimp / viewModel2.getSampleCowSize();
                        critical_ratio = critical_ratio * 100;
                        ratio_total = (slight_ratio + 3.45 * critical_ratio) / 3.45;
                        ratio_total = Math.round(ratio_total);
                        limp_ratio_2.setText(String.valueOf(critical_ratio));
                        int limp_score = viewModel.calculatorLimpScore(ratio_total);
                        viewModel.setLimpScore(limp_score);
                        limp_score_1.setText(String.valueOf(limp_score));
//                        if (viewModel.getLimpScore() == -1) {
//                            breedMinInjuryScoreTv.setText("다리 절음 평가를 완료해주세요");
//                        } else {
//                            long minInjuryScore = viewModel.calculatorMinInjuryScore(viewModel.getLimpScore(), viewModel.getHairLossScore());
//                            breedMinInjuryScoreTv.setText(String.valueOf(minInjuryScore));
//                            viewModel.setMinInjuryScore(minInjuryScore);
//                        }

                    }
                }
            }
        });
        return view;
    }
}