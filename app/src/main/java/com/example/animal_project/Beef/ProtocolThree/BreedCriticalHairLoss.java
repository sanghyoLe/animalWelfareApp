package com.example.animal_project.Beef.ProtocolThree;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.animal_project.QuestionTemplate;
import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;


public class BreedCriticalHairLoss extends Fragment {
    private View view;
    private QuestionTemplateViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);

        view = inflater.inflate(R.layout.fragment_breed_critical_hair_loss, container, false);
        EditText breedCriticalHairLossEd = view.findViewById(R.id.breed_critical_hair_loss_ed);
        TextView totalHairLossRatioTv = view.findViewById(R.id.breed_hair_loss_ratio_tv);
        TextView totalHairLossScoreTv = view.findViewById(R.id.breed_hair_loss_score_tv);
        TextView minInjuryScoreTv = view.findViewById(R.id.breed_min_injury_score_tv);

        if(((QuestionTemplateViewModel.PenQuestion)viewModel.BreedCriticalHairLoss).getRatio() != -1){
            breedCriticalHairLossEd.setText(
                    String.valueOf(
                            ((QuestionTemplateViewModel.PenQuestion)viewModel.BreedCriticalHairLoss).getRatio()
                    )
            );
        }
        if(viewModel.getHairLossTotalRatio() != -1){
            totalHairLossRatioTv.setText(
                    String.valueOf(
                            viewModel.getHairLossTotalRatio()
                    )
            );
        }
        if(viewModel.getHairLossScore() != -1){
            totalHairLossScoreTv.setText(
                    String.valueOf(
                            viewModel.getHairLossScore()
                    )
            );
        }
        if(viewModel.getMinInjuryScore() != -1){
            minInjuryScoreTv.setText(
                    String.valueOf(
                            viewModel.getMinInjuryScore()
                    )
            );
        }

        breedCriticalHairLossEd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                     if(TextUtils.isEmpty(breedCriticalHairLossEd.getText().toString())){
                        totalHairLossRatioTv.setText("문항을 완료하세요");
                        totalHairLossScoreTv.setText("문항을 완료하세요");
                    }else {
                         ((QuestionTemplateViewModel.Question)viewModel.BreedCriticalHairLoss).setNumberOfCow(
                                 Integer.parseInt(breedCriticalHairLossEd.getText().toString())
                         );
                     }

                     if(((QuestionTemplateViewModel.PenQuestion)viewModel.BreedSlightHairLoss).getNumberOfCow() != -1) {
                        float criticalHairLoss = 0;
                        criticalHairLoss = Float.parseFloat(breedCriticalHairLossEd.getText().toString());
                        ((QuestionTemplateViewModel.PenQuestion)viewModel.BreedCriticalHairLoss).setNumberOfCow((int)criticalHairLoss);
                        if((((QuestionTemplateViewModel.PenQuestion)viewModel.BreedSlightHairLoss).getNumberOfCow()
                                + criticalHairLoss) > viewModel.getSampleCowSize()) {
                            totalHairLossRatioTv.setText("표본 두수보다 큰 값을 입력하셨습니다");

                        } else {
                            TextView criticalHairLossTv = view.findViewById(R.id.breed_critical_hair_loss_ratio_tv);

                            ((QuestionTemplateViewModel.PenQuestion)viewModel.BreedCriticalHairLoss).setNumberOfCow((int)criticalHairLoss);
                            ((QuestionTemplateViewModel.PenQuestion)viewModel.BreedCriticalHairLoss).setPenLocation(
                                    ((QuestionTemplateViewModel.PenQuestion) viewModel.BreedSlightHairLoss).getPenLocation()
                            );

                            float slight_ratio;
                            float critical_ratio;
                            float ratio_total;

                            slight_ratio = ((QuestionTemplateViewModel.PenQuestion) viewModel.BreedSlightHairLoss).getRatio();

                            critical_ratio = criticalHairLoss / viewModel.getSampleCowSize();
                            critical_ratio = critical_ratio * 100;

                            critical_ratio = (float)viewModel.cutDecimal(critical_ratio);
                            ((QuestionTemplateViewModel.PenQuestion) viewModel.BreedCriticalHairLoss).setRatio(critical_ratio);
                            criticalHairLossTv.setText(String.valueOf(
                                    critical_ratio
                            ));
                            ratio_total = (slight_ratio + 5 * critical_ratio) / 5;
                            ratio_total = (float)viewModel.cutDecimal(ratio_total);
                            totalHairLossRatioTv.setText(String.valueOf(ratio_total));

                            viewModel.setHairLossTotalRatio(ratio_total);
                            int hair_loss_score = viewModel.calculatorHairLossScore(ratio_total);
                            viewModel.setHairLossScore(hair_loss_score);
                            totalHairLossScoreTv.setText(String.valueOf(hair_loss_score));



                                viewModel.setMinInjuryScore(
                                        viewModel.calculatorMinInjuryScore(
                                                viewModel.getFarmType(),
                                                (int)((QuestionTemplateViewModel.Question)viewModel.BreedLimp).getScore(),
                                                viewModel.getHairLossScore()
                                        )
                                );
                            minInjuryScoreTv.setText(String.valueOf(
                                    viewModel.getMinInjuryScore()
                            ));


                        }
                    }
                }


        });
        return view;
    }
}