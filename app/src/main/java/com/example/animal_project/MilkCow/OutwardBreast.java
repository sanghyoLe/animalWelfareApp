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


public class OutwardBreast extends Fragment {
    private View view;
    double restScore;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_outward_breast, container, false);
        
        QuestionTemplateViewModel viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);
        MilkCowScoreCalculator mc = new MilkCowScoreCalculator();

        EditText outwardBreastEd = (EditText) view.findViewById(R.id.outward_breast_ed);
        TextView outwardBreastRatioTv = (TextView) view.findViewById(R.id.outward_breast_ratio_tv);
        TextView outwardBreastScoreTv = (TextView) view.findViewById(R.id.outward_breast_score_tv);
        TextView freeStallRestScoreTv = (TextView) view.findViewById(R.id.free_stall_rest_score_tv);


        outwardBreastEd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(TextUtils.isEmpty(outwardBreastEd.getText().toString())){
            
                    ((QuestionTemplateViewModel.Question) viewModel.OutwardBreast).setNumberOfCow(-1);
                    ((QuestionTemplateViewModel.Question) viewModel.OutwardBreast).setScore(-1);
                    ((QuestionTemplateViewModel.Question) viewModel.OutwardBreast).setRatio(-1);
                    outwardBreastRatioTv.setText("값을 입력해주세요");
                    outwardBreastScoreTv.setText("-1");
                } else if (viewModel.getSampleCowSize() < Integer.parseInt(outwardBreastEd.getText().toString())) {
                    ((QuestionTemplateViewModel.Question) viewModel.OutwardBreast).setNumberOfCow(-1);
                    ((QuestionTemplateViewModel.Question) viewModel.OutwardBreast).setScore(-1);
                    ((QuestionTemplateViewModel.Question) viewModel.OutwardBreast).setRatio(-1);
                    outwardBreastRatioTv.setText("총 두수보다 큰 값을 입력할 수 없습니다.");
                    outwardBreastScoreTv.setText("-1");
                } else {
                    int appearanceQ3Score = 0;
                    float ratio = Float.parseFloat(outwardBreastEd.getText().toString()) / viewModel.getSampleCowSize();
                    ratio = ratio * 100;
                    ratio = Math.round(ratio);
                    outwardBreastRatioTv.setText(String.valueOf(ratio));
                    appearanceQ3Score = mc.calculatorAppearanceQ3Score(ratio);
                    outwardBreastScoreTv.setText(String.valueOf(appearanceQ3Score));
                    ((QuestionTemplateViewModel.Question) viewModel.OutwardBreast).setNumberOfCow(Integer.parseInt(outwardBreastEd.getText().toString()));
                    ((QuestionTemplateViewModel.Question) viewModel.OutwardBreast).setScore(appearanceQ3Score);
                    ((QuestionTemplateViewModel.Question) viewModel.OutwardBreast).setRatio(ratio);


                    // 운동장형 축사 편안한 휴식 점수
                    if(viewModel.getFarmType() == 4 ){
                        restScore = mc.calculatorRestScore(
                                ((QuestionTemplateViewModel.SitTimeQuestion)viewModel.SitTimeQuestion).getScore(),
                                ((QuestionTemplateViewModel.Question)viewModel.OutwardBackReg).getScore(),
                                ((QuestionTemplateViewModel.Question)viewModel.OutwardBack).getScore(),
                                ((QuestionTemplateViewModel.Question)viewModel.OutwardBreast).getScore()
                        );
                        restScore = viewModel.cutDecimal(restScore);
                        freeStallRestScoreTv.setText(String.valueOf(restScore));
                        viewModel.setRestScore(restScore);
                    } else if(viewModel.getFarmType() == 5){

                        restScore = mc.calculatorFreeStallRestScore(
                                ((QuestionTemplateViewModel.FreeStallCountQuestion)viewModel.FreeStallCountQuestion).getLowestScore(),
                                ((QuestionTemplateViewModel.SitCollisionQuestion)viewModel.SitCollision).getScore(),
                                ((QuestionTemplateViewModel.FreeStallAreaOutCollision)viewModel.FreeStallAreaOutCollision).getScore(),
                                ((QuestionTemplateViewModel.SitTimeQuestion)viewModel.SitTimeQuestion).getScore(),
                                ((QuestionTemplateViewModel.Question)viewModel.OutwardBackReg).getScore(),
                                ((QuestionTemplateViewModel.Question)viewModel.OutwardBack).getScore(),
                                ((QuestionTemplateViewModel.Question)viewModel.OutwardBreast).getScore()
                        );
                        restScore = viewModel.cutDecimal(restScore);
                        freeStallRestScoreTv.setText(String.valueOf(restScore));
                        viewModel.setRestScore(restScore);
                    }

                }
           }
        });
        return view;
    }
}