package com.example.animal_project.Beef.ProtocolTwo;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;

public class BreedOutward extends Fragment {
    private View view;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        QuestionTemplateViewModel viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);
        view = inflater.inflate(R.layout.fragment_breed_outward, container, false);

        EditText breed_outward_ed = view.findViewById(R.id.breed_outward_ed);
        EditText penLocationOne = view.findViewById(R.id.pen_location_ed_1);
        EditText penLocationTwo = view.findViewById(R.id.pen_location_ed_2);
        TextView breed_outward_ratio = view.findViewById(R.id.breed_outward_ratio);
        TextView breed_outward_score = view.findViewById(R.id.breed_outward_score);
        TextView breed_rest_score = view.findViewById(R.id.breed_rest_score);

        if(viewModel.getRestScore() != -1){
            breed_rest_score.setText(String.valueOf(viewModel.getRestScore()));
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
                viewModel.penQuestionAfterTextChanged(breed_outward_ed,breed_outward_ratio
                        ,penLocationOne,penLocationTwo,(QuestionTemplateViewModel.PenQuestion)viewModel.BreedOutward);


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
                viewModel.penQuestionAfterTextChanged(breed_outward_ed,breed_outward_ratio
                        ,penLocationOne,penLocationTwo,(QuestionTemplateViewModel.PenQuestion)viewModel.BreedOutward);



            }
        });

        breed_outward_ed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void afterTextChanged(Editable editable) {

                viewModel.penQuestionAfterTextChanged(breed_outward_ed,breed_outward_ratio
                    ,penLocationOne,penLocationTwo,(QuestionTemplateViewModel.PenQuestion)viewModel.BreedOutward);
                if(((QuestionTemplateViewModel.PenQuestion) viewModel.BreedOutward).getRatio() == -1){
                    breed_outward_score.setText("값을 입력해주세요");
                } else {
                    viewModel.setOutwardScore(
                            viewModel.calculatorBreedOutwardScore(
                                    ((QuestionTemplateViewModel.PenQuestion) viewModel.BreedOutward).getRatio()
                        )
                    );
                    breed_outward_score.setText(String.valueOf(viewModel.getOutWardScore()));
                    if(viewModel.getStrawScore() == -1){
                        breed_rest_score.setText("깔짚 수분 평가를 완료하세요");
                    }else {
                        // 편안한 휴식 종합 점수
                        viewModel.setRestScore(
                                viewModel.calculatorBreedRestScore(
                                        viewModel.getStrawScore(),
                                        viewModel.getOutWardScore()
                                )
                        );
                        breed_rest_score.setText(String.valueOf(viewModel.getRestScore()));
                        }
                    }

                }
            });
        return view;
    }

}