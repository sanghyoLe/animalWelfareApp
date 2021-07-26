package com.example.animal_project.Freestall.ProtocolTwo;


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


public class FreestallAppearanceQ2 extends Fragment {
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_freestall_appearance_q2, container, false);
        MilkCowViewModel viewModel = new ViewModelProvider(getActivity()).get(MilkCowViewModel.class);
        QuestionTemplateViewModel viewModel2 = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);
        TextView ratio_number = (TextView) view.findViewById(R.id.ratio_number);
        EditText appearance_a2 = (EditText) view.findViewById(R.id.appearance_a2);
        TextView appearance_ratio_2 = (TextView) view.findViewById(R.id.appearance_ratio_2);
        TextView appearance_score_2 = (TextView) view.findViewById(R.id.appearance_score_2);

        ratio_number.setText(String.valueOf(viewModel2.getSampleCowSize())); //표본 두수 표시
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
                    viewModel.setAppearanceQ2Score(-1);
                    appearance_ratio_2.setText("값을 입력해주세요");
                    appearance_score_2.setText(String.valueOf(viewModel.getAppearanceQ2Score()));
                } else if (viewModel2.getSampleCowSize() < Integer.parseInt(appearance_a2.getText().toString())) {
                    viewModel.setAppearanceQ2Score(-1);
                    appearance_ratio_2.setText("표본 두수보다 큰 값을 입력할 수 없습니다.");
                    appearance_score_2.setText(String.valueOf(viewModel.getAppearanceQ2Score()));
                } else {
                    int appearanceQ2Score = 0;
                    float ratio = Float.parseFloat(appearance_a2.getText().toString()) / viewModel2.getSampleCowSize();
                    ratio = ratio * 100;
                    ratio = Math.round(ratio);
                    appearance_ratio_2.setText(String.valueOf(ratio));
                    appearanceQ2Score = viewModel.calculatorAppearanceQ2Score(ratio);
                    appearance_score_2.setText(String.valueOf(appearanceQ2Score));
                    viewModel.setAppearanceQ2Score(appearanceQ2Score);
                }
            }
        });
        return view;
    }
}