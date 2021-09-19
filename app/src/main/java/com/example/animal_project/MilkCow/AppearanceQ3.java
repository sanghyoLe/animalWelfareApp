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


public class AppearanceQ3 extends Fragment {
    private View view;
    double restScore;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_freestall_appearance_q3, container, false);
        
        QuestionTemplateViewModel viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);
        MilkCowScoreCalculator mc = new MilkCowScoreCalculator();
        TextView ratio_number = (TextView) view.findViewById(R.id.ratio_number);
        EditText appearance_a3 = (EditText) view.findViewById(R.id.appearance_a3);
        TextView appearance_ratio_3 = (TextView) view.findViewById(R.id.appearance_ratio_3);
        TextView appearance_score_3 = (TextView) view.findViewById(R.id.appearance_score_3);
        TextView freestall_rest_score = (TextView) view.findViewById(R.id.freestall_rest_score);

        ratio_number.setText(String.valueOf(viewModel.getSampleCowSize())); //표본 두수 표시
        appearance_a3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(TextUtils.isEmpty(appearance_a3.getText().toString())){
            
                    ((QuestionTemplateViewModel.Question) viewModel.AppearanceBreast).setNumberOfCow(-1);
                    ((QuestionTemplateViewModel.Question) viewModel.AppearanceBreast).setScore(-1);
                    ((QuestionTemplateViewModel.Question) viewModel.AppearanceBreast).setRatio(-1);
                    appearance_ratio_3.setText("값을 입력해주세요");
                    appearance_score_3.setText("-1");
                } else if (viewModel.getSampleCowSize() < Integer.parseInt(appearance_a3.getText().toString())) {
                    ((QuestionTemplateViewModel.Question) viewModel.AppearanceBreast).setNumberOfCow(-1);
                    ((QuestionTemplateViewModel.Question) viewModel.AppearanceBreast).setScore(-1);
                    ((QuestionTemplateViewModel.Question) viewModel.AppearanceBreast).setRatio(-1);
                    appearance_ratio_3.setText("총 두수보다 큰 값을 입력할 수 없습니다.");
                    appearance_score_3.setText("-1");
                } else {
                    int appearanceQ3Score = 0;
                    float ratio = Float.parseFloat(appearance_a3.getText().toString()) / viewModel.getSampleCowSize();
                    ratio = ratio * 100;
                    ratio = Math.round(ratio);
                    appearance_ratio_3.setText(String.valueOf(ratio));
                    appearanceQ3Score = mc.calculatorAppearanceQ3Score(ratio);
                    appearance_score_3.setText(String.valueOf(appearanceQ3Score));
                    ((QuestionTemplateViewModel.Question) viewModel.AppearanceBreast).setNumberOfCow(Integer.parseInt(appearance_a3.getText().toString()));
                    ((QuestionTemplateViewModel.Question) viewModel.AppearanceBreast).setScore(appearanceQ3Score);
                    ((QuestionTemplateViewModel.Question) viewModel.AppearanceBreast).setRatio(ratio);


                    // 편안한 휴식 점수 계산
                    restScore = mc.calculatorRestScore(
                            ((QuestionTemplateViewModel.SitTimeQuestion)viewModel.SitTimeQuestion).getScore(),
                            ((QuestionTemplateViewModel.Question)viewModel.AppearanceBottomLeg).getScore(),
                            ((QuestionTemplateViewModel.Question)viewModel.AppearanceBack).getScore(),
                            ((QuestionTemplateViewModel.Question)viewModel.AppearanceBreast).getScore()
                    );
                    restScore = viewModel.cutDecimal(restScore);
                    freestall_rest_score.setText(String.valueOf(restScore));
                    viewModel.setRestScore(restScore);
                }
           }
        });
        return view;
    }
}