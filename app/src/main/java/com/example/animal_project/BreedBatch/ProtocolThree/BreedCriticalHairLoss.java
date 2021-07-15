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
        TextView breedHairLossRatioTv = view.findViewById(R.id.breed_hair_loss_ratio_tv);
        TextView breedHairLossScoreTv = view.findViewById(R.id.breed_hair_loss_score_tv);
        TextView breedMinInjuryScoreTv = view.findViewById(R.id.breed_min_injury_score_tv);
        TextView hairLossSampleSizeTv = view.findViewById(R.id.hair_loss_sample_size);

        breedCriticalHairLossEd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if(viewModel.getSlightHairLoss() == -1)
                {
                    breedHairLossRatioTv.setText("19번 문항을 완료하세요");
                    breedHairLossScoreTv.setText("19번 문항을 완료하세요");
                }  else if(TextUtils.isEmpty(breedCriticalHairLossEd.getText().toString())){
                    breedHairLossRatioTv.setText("문항을 완료하세요");
                    breedHairLossScoreTv.setText("문항을 완료하세요");
                }

                else {
                    float criticalHairLoss = 0;
                    criticalHairLoss = Float.parseFloat(breedCriticalHairLossEd.getText().toString());

                    if((int)(viewModel.getSlightHairLoss() + criticalHairLoss) > viewModel.getSampleCowSize()) {
                        breedHairLossRatioTv.setText("표본 두수보다 큰 값을 입력하셨습니다");
                        hairLossSampleSizeTv.setVisibility(View.VISIBLE);
                        hairLossSampleSizeTv.setText("표본 두수 : " + viewModel.getSampleCowSize());
                    } else {
                        viewModel.setCriticalHairLoss(criticalHairLoss);
                        hairLossSampleSizeTv.setVisibility(View.GONE);
                        float slight_ratio;
                        float critical_ratio;
                        float ratio_total;
                        slight_ratio = viewModel.getSlightHairLoss() / viewModel.getSampleCowSize() ;
                        slight_ratio = slight_ratio * 100;
                        critical_ratio = criticalHairLoss / viewModel.getSampleCowSize();
                        critical_ratio = critical_ratio * 100;
                        ratio_total = (slight_ratio + 5 * critical_ratio) / 5;
                        ratio_total =  Math.round(ratio_total);
                        breedHairLossRatioTv.setText(String.valueOf(ratio_total));
                        int hair_loss_score = viewModel.calculatorHairLossScore(ratio_total);
                        viewModel.setHairLossScore(hair_loss_score);
                        breedHairLossScoreTv.setText(String.valueOf(hair_loss_score));
                        if(viewModel.getLimpScore() == -1){
                            breedMinInjuryScoreTv.setText("다리 절음 평가를 완료해주세요");
                        } else{
                            long minInjuryScore = viewModel.calculatorMinInjuryScore(viewModel.getLimpScore(),viewModel.getHairLossScore());
                            breedMinInjuryScoreTv.setText(String.valueOf(minInjuryScore));
                            viewModel.setMinInjuryScore(minInjuryScore);
                        }

                    }

                }
            }
        });
        return view;
    }
}