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


public class HardBirth extends Fragment {
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_hard_birth, container, false);

        QuestionTemplateViewModel viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);
        EditText hardBirthYearAvgEd = (EditText) view.findViewById(R.id.hard_birth_year_avg_ed);
        EditText hardBirthCountEd = (EditText) view.findViewById(R.id.hard_birth_count_ed);
        TextView hardBirthRatioTv = (TextView) view.findViewById(R.id.hard_birth_ratio_tv);
        hardBirthYearAvgEd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (TextUtils.isEmpty(hardBirthYearAvgEd.getText().toString())){
                    hardBirthRatioTv.setText("값을 입력하세요");
                    ((QuestionTemplateViewModel.YearAvgQuestion)viewModel.HardBirth).setRatio(-1);
                    ((QuestionTemplateViewModel.YearAvgQuestion)viewModel.HardBirth).setScore(-1);
                    ((QuestionTemplateViewModel.YearAvgQuestion)viewModel.HardBirth).setYearAvgCount(-1);
                } else if (TextUtils.isEmpty(hardBirthCountEd.getText().toString())) {
                    hardBirthRatioTv.setText("값을 입력하세요");
                } else if(Integer.parseInt(hardBirthCountEd.getText().toString()) > Integer.parseInt(hardBirthYearAvgEd.getText().toString())) {
                    ((QuestionTemplateViewModel.YearAvgQuestion)viewModel.HardBirth).setRatio(-1);
                    ((QuestionTemplateViewModel.YearAvgQuestion)viewModel.HardBirth).setScore(-1);
                    ((QuestionTemplateViewModel.YearAvgQuestion)viewModel.HardBirth).setYearAvgCount(-1);
                    hardBirthRatioTv.setText("2번 문항은 1번 문항보다 클 수 없습니다");

                } else {
                    float ratio = Float.parseFloat(hardBirthCountEd.getText().toString()) / Float.parseFloat(hardBirthYearAvgEd.getText().toString());
                    ratio = ratio * 100;
                    ((QuestionTemplateViewModel.YearAvgQuestion)viewModel.HardBirth).setRatio(ratio);
                    ((QuestionTemplateViewModel.YearAvgQuestion)viewModel.HardBirth).setYearAvgCount(Integer.parseInt(String.valueOf(hardBirthYearAvgEd.getText())));
                    hardBirthRatioTv.setText(String.valueOf(ratio));
                }
            }
        });
        hardBirthCountEd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (TextUtils.isEmpty(hardBirthYearAvgEd.getText().toString())){
                    hardBirthRatioTv.setText("값을 입력하세요");
                    ((QuestionTemplateViewModel.YearAvgQuestion)viewModel.HardBirth).setRatio(-1);
                    ((QuestionTemplateViewModel.YearAvgQuestion)viewModel.HardBirth).setScore(-1);
                    ((QuestionTemplateViewModel.YearAvgQuestion)viewModel.HardBirth).setNumberOfCow(-1);
                } else if (TextUtils.isEmpty(hardBirthCountEd.getText().toString())) {
                    hardBirthRatioTv.setText("값을 입력하세요");
                } else if(Integer.parseInt(hardBirthCountEd.getText().toString()) > Integer.parseInt(hardBirthYearAvgEd.getText().toString())) {
                    ((QuestionTemplateViewModel.YearAvgQuestion)viewModel.HardBirth).setRatio(-1);
                    ((QuestionTemplateViewModel.YearAvgQuestion)viewModel.HardBirth).setScore(-1);
                    ((QuestionTemplateViewModel.YearAvgQuestion)viewModel.HardBirth).setNumberOfCow(-1);
                    hardBirthRatioTv.setText("2번 문항은 1번 문항보다 클 수 없습니다");
                } else {
                    float ratio = Float.parseFloat(hardBirthCountEd.getText().toString()) / Float.parseFloat(hardBirthYearAvgEd.getText().toString());
                    ratio = ratio * 100;
                    ratio = Math.round(ratio);
                    ratio = (float) viewModel.cutDecimal(ratio);
                    ((QuestionTemplateViewModel.YearAvgQuestion)viewModel.HardBirth).setRatio(ratio);
                    ((QuestionTemplateViewModel.YearAvgQuestion)viewModel.HardBirth).setNumberOfCow(Integer.parseInt(String.valueOf(hardBirthYearAvgEd.getText())));
                    hardBirthRatioTv.setText(String.valueOf(ratio));
                }
            }
        });

        return view;
    }
}