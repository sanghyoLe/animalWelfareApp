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


public class OutwardBackReg extends Fragment {
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_outward_back_reg, container, false);
        QuestionTemplateViewModel viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);
        MilkCowScoreCalculator mc = new MilkCowScoreCalculator();

        EditText outwardBackRegEd = (EditText) view.findViewById(R.id.outward_back_reg_ed);
        TextView outwardBackRegRatioTv = (TextView) view.findViewById(R.id.outward_back_reg_ratio_tv);
        TextView outwardBackRegScoreTv = (TextView) view.findViewById(R.id.outward_back_reg_score_tv);


        outwardBackRegEd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(TextUtils.isEmpty(outwardBackRegEd.getText().toString())){
                    ((QuestionTemplateViewModel.Question) viewModel.OutwardBackReg).setNumberOfCow(-1);
                    ((QuestionTemplateViewModel.Question) viewModel.OutwardBackReg).setScore(-1);
                    ((QuestionTemplateViewModel.Question) viewModel.OutwardBackReg).setRatio(-1);
                    outwardBackRegRatioTv.setText("값을 입력해주세요");
                    outwardBackRegScoreTv.setText("-1");
                } else if (viewModel.getSampleCowSize() < Integer.parseInt(outwardBackRegEd.getText().toString())) {
                    ((QuestionTemplateViewModel.Question) viewModel.OutwardBackReg).setNumberOfCow(-1);
                    ((QuestionTemplateViewModel.Question) viewModel.OutwardBackReg).setScore(-1);
                    ((QuestionTemplateViewModel.Question) viewModel.OutwardBackReg).setRatio(-1);
                    outwardBackRegRatioTv.setText("총 두수보다 큰 값을 입력할 수 없습니다.");
                    outwardBackRegScoreTv.setText("-1");
                } else {
                    int appearanceQ1Score = 0;

                    float ratio = Float.parseFloat(outwardBackRegEd.getText().toString()) / viewModel.getSampleCowSize();

                    ratio = ratio * 100;
                    ratio = viewModel.cutDecimal(ratio);
                    outwardBackRegRatioTv.setText(String.valueOf(ratio));
                    appearanceQ1Score = mc.calculatorAppearanceQ1Score(ratio);
                    outwardBackRegScoreTv.setText(String.valueOf(appearanceQ1Score));
                    ((QuestionTemplateViewModel.Question) viewModel.OutwardBackReg).setNumberOfCow(Integer.parseInt(outwardBackRegEd.getText().toString()));
                    ((QuestionTemplateViewModel.Question) viewModel.OutwardBackReg).setScore(appearanceQ1Score);
                    ((QuestionTemplateViewModel.Question) viewModel.OutwardBackReg).setRatio(ratio);
                }
            }
        });
        return view;
    }
}