package com.example.animal_project.Beef.ProtocolThree;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;


public class BreedCastrationQ3 extends Fragment {
    private View view;
    private int painkiller;
    private TextView breed_castration_score_tv;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_breed_castration_q3, container, false);
        RadioGroup breed_castration_q3_rg = (RadioGroup) view.findViewById(R.id.breed_castration_q3_rg);
        breed_castration_score_tv = view.findViewById(R.id.breed_castration_score_tv);
        TextView min_pain_score_tv = view.findViewById(R.id.breed_min_pain_score);
        TextView protocol_tv = view.findViewById(R.id.breed_protocol_3);

        QuestionTemplateViewModel viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);
        breed_castration_q3_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.breed_castration_q3_1) {
                    painkiller = 1;
                } else if (checkedId == R.id.breed_castration_q3_2) {
                    painkiller = 2;
                }
                ((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedCastrationPainkiller).setSelectedItem(painkiller);
                int selectedItem =((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedCastrationPainkiller).getSelectedItem();
                ((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedCastrationPainkiller).setAnswer(breed_castration_q3_rg,selectedItem);

                if(((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedCastration).getSelectedItem()== -1){
                    breed_castration_score_tv.setText("31번 문항을 완료하세요");
                } else if(((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedCastrationAnesthesia).getSelectedItem() == -1){
                    breed_castration_score_tv.setText("32번 문항을 완료하세요");
                } else {
                    viewModel.setCastrationScore(
                            viewModel.calculatorCastrationScore(
                                    ((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedCastration).getSelectedItem(),
                                    ((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedCastrationAnesthesia).getSelectedItem(),
                                    ((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedCastrationPainkiller).getSelectedItem()
                            )
                    );
                    breed_castration_score_tv.setText(String.valueOf(viewModel.getCastrationScore()));
                    if(viewModel.getHornRemovalScore() == -1){
                        min_pain_score_tv.setText("제각 평가를 완료하세요");
                    } else if(viewModel.getCastrationScore() == -1){
                        min_pain_score_tv.setText("거세 평가를 완료하세요");
                    } else {
                        viewModel.setMinPainScore
                                (
                                viewModel.calculatorMinPainScore
                                        (
                                viewModel.getHornRemovalScore(),
                                viewModel.getCastrationScore()
                                        )
                                );

                        min_pain_score_tv.setText(
                                String.valueOf(viewModel.getMinPainScore()));
                    }
                }
                if(viewModel.getMinInjuryScore() == -1){
                    protocol_tv.setText("상해의 최소화 평가를 완료하세요");
                }else if(viewModel.getDiseaseScore() == -1){
                    protocol_tv.setText("질병의 최소화 평가를 완료하세요");
                }else if(viewModel.getMinPainScore() == -1) {
                    protocol_tv.setText("고통의 최소화 평가를 완료하세요");
                } else {
                    viewModel.setProtocolThreeScore(
                            viewModel.calculatorProtocolThreeResult(
                                    viewModel.getFarmType(),
                                    viewModel.getMinInjuryScore(),
                                    viewModel.getMinPainScore(),
                                    viewModel.getDiseaseScore()
                            )
                    );
                    protocol_tv.setText(String.valueOf(viewModel.getProtocolThreeScore()));

                }
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}