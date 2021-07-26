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


public class FreestallAppearanceQ3 extends Fragment {
    private View view;
    double freestallRestScore;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_freestall_appearance_q3, container, false);
        MilkCowViewModel viewModel = new ViewModelProvider(getActivity()).get(MilkCowViewModel.class);
        QuestionTemplateViewModel viewModel2 = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);
        TextView ratio_number = (TextView) view.findViewById(R.id.ratio_number);
        EditText appearance_a3 = (EditText) view.findViewById(R.id.appearance_a3);
        TextView appearance_ratio_3 = (TextView) view.findViewById(R.id.appearance_ratio_3);
        TextView appearance_score_3 = (TextView) view.findViewById(R.id.appearance_score_3);
        TextView freestall_rest_score = (TextView) view.findViewById(R.id.freestall_rest_score);

        ratio_number.setText(String.valueOf(viewModel2.getSampleCowSize())); //표본 두수 표시
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
                    viewModel.setAppearanceQ3Score(-1);
                    appearance_ratio_3.setText("값을 입력해주세요");
                    appearance_score_3.setText(String.valueOf(viewModel.getAppearanceQ3Score()));
                } else if (viewModel2.getSampleCowSize() < Integer.parseInt(appearance_a3.getText().toString())) {
                    viewModel.setAppearanceQ1Score(-1);
                    appearance_ratio_3.setText("표본 두수보다 큰 값을 입력할 수 없습니다.");
                    appearance_score_3.setText(String.valueOf(viewModel.getAppearanceQ3Score()));
                } else {
                    int appearanceQ3Score = 0;
                    float ratio = Float.parseFloat(appearance_a3.getText().toString()) / viewModel2.getSampleCowSize();
                    ratio = ratio * 100;
                    ratio = Math.round(ratio);
                    appearance_ratio_3.setText(String.valueOf(ratio));
                    appearanceQ3Score = viewModel.calculatorAppearanceQ3Score(ratio);
                    appearance_score_3.setText(String.valueOf(appearanceQ3Score));
                    viewModel.setAppearanceQ3Score(appearanceQ3Score);

                    // 편안한 휴식 점수 계산
                    freestallRestScore = viewModel.calculatorFreestallRestScore(
                            viewModel.getCountScore(),
                            viewModel.getSitCollisionScore(),
                            viewModel.getAreaOutCollision(),
                            viewModel.getSitTimeScore(),
                            viewModel.getAppearanceQ1Score(),
                            viewModel.getAppearanceQ2Score(),
                            viewModel.getAppearanceQ3Score()
                    );
                    freestall_rest_score.setText(String.valueOf(freestallRestScore));
                    viewModel.setFreestallRestScore(freestallRestScore);
                }
           }
        });
        return view;
    }
}