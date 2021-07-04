package com.example.animal_project.BreedBatch.ProtocolThree;

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

import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;

public class BreedFallDead extends Fragment {

   private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_breed_fall_dead, container, false);
        EditText breed_fall_dead_ed = view.findViewById(R.id.breed_fall_dead_ed);
        TextView breed_fall_dead_tv = view.findViewById(R.id.breed_fall_dead_ratio);
        TextView sample_size_tv = view.findViewById(R.id.sample_size_tv);
        QuestionTemplateViewModel viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);
        TextView breed_disease_score_tv = view.findViewById(R.id.breed_disease_score);


        breed_fall_dead_ed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                // 질병의 최소화 프로토콜 점수 표시하는 로직
                if(viewModel.getCough() == -1){
                    breed_disease_score_tv.setText("기침 평가를 완료하세요");
                }else if(viewModel.getRunnyNoseRatio() == -1){
                    breed_disease_score_tv.setText("비강분비물 평가를 완료하세요");
                    Log.d("runnyNose",String.valueOf(viewModel.getRunnyNoseRatio()));
                }else if(viewModel.getOphthalmicRatio() == -1){
                    breed_disease_score_tv.setText("안구분비물 평가를 완료하세요");
                }else if(viewModel.getBreathRatio() == -1){
                    breed_disease_score_tv.setText("호흡 장애 평가를 완료하세요");
                }else if(viewModel.getDiarrheaRatio() == -1){
                    breed_disease_score_tv.setText("설사 평가를 완료하세요");
                }else if(viewModel.getRuminantRatio() == -1){
                    breed_disease_score_tv.setText("반추위 팽창 평가를 완료하세요");
                } else if(TextUtils.isEmpty(breed_fall_dead_ed.getText().toString())){
                    breed_fall_dead_tv.setText("값을 입력하세요");
                    viewModel.setFallDeadRatio(-1);
                } else if(viewModel.getRatio(breed_fall_dead_ed) > 100) {
                    viewModel.setFallDeadRatio(-1);
                    breed_fall_dead_tv.setText("표본 규모보다 큰 값 입력 불가");
                    sample_size_tv.setVisibility(View.VISIBLE);
                    sample_size_tv.setText("표본 규모 : " + String.valueOf(viewModel.getSampleCowSize()));
                } else {
                  viewModel.setDiarrheaRatio(viewModel.getRatio(breed_fall_dead_ed));
                  breed_fall_dead_tv.setText(String.valueOf(viewModel.getRatio(breed_fall_dead_ed)));

                    double diseaseScore =
                    viewModel.calculatorDiseaseScore(
                            viewModel.calculatorCareWarningScore(
                            viewModel.calculatorDiseaseSectionOne(viewModel.getRunnyNoseRatio(),viewModel.getOphthalmicRatio()),
                            viewModel.calculatorDiseaseSectionTwo(viewModel.getCoughRatio(),viewModel.getBreathRatio()),
                            viewModel.calculatorDiseaseSectionThree(viewModel.getRuminantRatio(),viewModel.getDiarrheaRatio()),
                            viewModel.calculatorDiseaseSectionFour(viewModel.getFallDeadRatio())
                            )
                    );
                    viewModel.setDiseaseScore(diseaseScore);
                    breed_disease_score_tv.setText(String.valueOf(diseaseScore));
                }
            }
        });

        return view;
    }
}