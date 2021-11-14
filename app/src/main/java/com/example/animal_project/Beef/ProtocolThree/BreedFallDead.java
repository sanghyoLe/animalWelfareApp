package com.example.animal_project.Beef.ProtocolThree;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

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

        QuestionTemplateViewModel viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);
        TextView breed_disease_score_tv = view.findViewById(R.id.breed_disease_score);
        EditText penLocationOne = view.findViewById(R.id.pen_location_ed_1);
        EditText penLocationTwo = view.findViewById(R.id.pen_location_ed_2);
        LinearLayout diseaseScoreLayout = view.findViewById(R.id.disease_score_layout);
        if(!viewModel.isBeef(viewModel.getFarmType())){
            diseaseScoreLayout.setVisibility(View.GONE);
        }
        if(viewModel.getDiseaseScore() != -1){
            breed_disease_score_tv.setText(String.valueOf(
                    viewModel.getDiseaseScore()
            ));
        }
        penLocationOne.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                viewModel.penQuestionAfterTextChanged(breed_fall_dead_ed,breed_fall_dead_tv,
                        penLocationOne,penLocationTwo,(QuestionTemplateViewModel.PenQuestion)viewModel.BreedFallDead);
            }
        });

        penLocationTwo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                viewModel.penQuestionAfterTextChanged(breed_fall_dead_ed,breed_fall_dead_tv,
                        penLocationOne,penLocationTwo,(QuestionTemplateViewModel.PenQuestion)viewModel.BreedFallDead);
            }
        });




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
                viewModel.penQuestionAfterTextChanged(breed_fall_dead_ed,breed_fall_dead_tv,
                       penLocationOne,penLocationTwo,(QuestionTemplateViewModel.PenQuestion)viewModel.BreedFallDead);

                if(viewModel.isBeef(viewModel.getFarmType()))
                {

                        double diseaseScore =
                                viewModel.calculatorDiseaseScore(
                                        viewModel.calculatorCareWarningScore(
                                                viewModel.calculatorDiseaseSectionOne(
                                                        ((QuestionTemplateViewModel.PenQuestion) viewModel.BreedRunnyNose).getRatio(),
                                                        ((QuestionTemplateViewModel.PenQuestion) viewModel.BreedOphthalmic).getRatio()
                                                ),
                                                viewModel.calculatorDiseaseSectionTwo(
                                                        viewModel.getCoughQuestion().getCoughRatio(),
                                                        ((QuestionTemplateViewModel.PenQuestion) viewModel.BreedBreath).getRatio()
                                                ),
                                                viewModel.calculatorDiseaseSectionThree(
                                                        ((QuestionTemplateViewModel.PenQuestion) viewModel.BreedRuminant).getRatio(),
                                                        ((QuestionTemplateViewModel.PenQuestion) viewModel.BreedDiarrhea).getRatio()
                                                ),
                                                viewModel.calculatorDiseaseSectionFour(
                                                        ((QuestionTemplateViewModel.PenQuestion) viewModel.BreedFallDead).getRatio()
                                                )
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