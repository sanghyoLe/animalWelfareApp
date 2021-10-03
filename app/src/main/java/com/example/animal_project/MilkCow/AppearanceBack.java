package com.example.animal_project.MilkCow;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;


public class AppearanceBack extends Fragment {
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_appearance_q2, container, false);

        QuestionTemplateViewModel viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);
        MilkCowScoreCalculator mc = new MilkCowScoreCalculator();

        EditText appearance_a2 = (EditText) view.findViewById(R.id.appearance_a2);
        TextView appearance_ratio_2 = (TextView) view.findViewById(R.id.appearance_ratio_2);
        TextView appearance_score_2 = (TextView) view.findViewById(R.id.appearance_score_2);


        appearance_a2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(TextUtils.isEmpty(appearance_a2.getText().toString())){
                    ((QuestionTemplateViewModel.Question) viewModel.AppearanceBack).setNumberOfCow(-1);
                    ((QuestionTemplateViewModel.Question) viewModel.AppearanceBack).setScore(-1);
                    ((QuestionTemplateViewModel.Question) viewModel.AppearanceBack).setRatio(-1);
                    appearance_ratio_2.setText("값을 입력해주세요");
                    appearance_score_2.setText("-1");
                } else if (viewModel.getSampleCowSize() < Integer.parseInt(appearance_a2.getText().toString())) {
                    ((QuestionTemplateViewModel.Question) viewModel.AppearanceBack).setNumberOfCow(-1);
                    ((QuestionTemplateViewModel.Question) viewModel.AppearanceBack).setScore(-1);
                    ((QuestionTemplateViewModel.Question) viewModel.AppearanceBack).setRatio(-1);
                    appearance_ratio_2.setText("총 두수보다 큰 값을 입력할 수 없습니다.");
                    appearance_score_2.setText("-1");
                } else {
                    int appearanceQ2Score = 0;
                    float ratio = Float.parseFloat(appearance_a2.getText().toString()) / viewModel.getSampleCowSize();
                    ratio = ratio * 100;
                    ratio = Math.round(ratio);
                    appearance_ratio_2.setText(String.valueOf(ratio));
                    appearanceQ2Score = mc.calculatorAppearanceQ2Score(ratio);
                    appearance_score_2.setText(String.valueOf(appearanceQ2Score));
                    ((QuestionTemplateViewModel.Question) viewModel.AppearanceBack).setNumberOfCow(Integer.parseInt(appearance_a2.getText().toString()));
                    ((QuestionTemplateViewModel.Question) viewModel.AppearanceBack).setScore(appearanceQ2Score);
                    ((QuestionTemplateViewModel.Question) viewModel.AppearanceBack).setRatio(ratio);
                }
            }
        });
        return view;
    }
}