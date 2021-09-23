
package com.example.animal_project.FreeStall.ProtocolThree;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.animal_project.MilkCowViewModel;
import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;


public class FreestallHornQ3 extends Fragment {
    private View view;
    private int painkiller;
    private TextView breed_horn_removal_score_tv, freestall_min_pain_score, freestall_protocol_3;
    double minPainScore, protocolThreeScore;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_freestall_horn_q3, container, false);
        RadioGroup breed_horn_q3_rg = (RadioGroup) view.findViewById(R.id.breed_horn_q3_rg);
        breed_horn_removal_score_tv = view.findViewById(R.id.breed_horn_removal_score_tv);
        freestall_min_pain_score = view.findViewById(R.id.freestall_min_pain_score);
        freestall_protocol_3 = view.findViewById(R.id.freestall_protocol_3);
        QuestionTemplateViewModel viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);
        MilkCowViewModel viewModelMilk = new ViewModelProvider(getActivity()).get(MilkCowViewModel.class);
        breed_horn_q3_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.breed_horn_q3_1) {
                    painkiller = 1;
                } else if (checkedId == R.id.breed_horn_q3_2) {
                    painkiller = 2;
                }
                viewModel.setPainkiller(painkiller);
                if(viewModel.getHornRemoval() == -1){
                    breed_horn_removal_score_tv.setText("문항을 완료하세요");
                } else if(viewModel.getAnesthesia() == -1){
                    breed_horn_removal_score_tv.setText("문항을 완료하세요");
                } else {
                    viewModel.setHornRemovalScore(
                            viewModel.calculatorHornRemovalScore(
                                    viewModel.getHornRemoval(),
                                    viewModel.getAnesthesia(),
                                    viewModel.getPainkiller()
                            )
                    );
                    breed_horn_removal_score_tv.setText(String.valueOf(viewModel.getHornRemovalScore()));
                    minPainScore = viewModelMilk.calculatorMinPainScore(viewModel.getHornRemovalScore());
                    freestall_min_pain_score.setText(String.valueOf(minPainScore));
                    protocolThreeScore = viewModelMilk.calculatorProtocolThreeScore(
                            viewModelMilk.getMinInjuryScore(),
                            viewModelMilk.getDiseaseScore(),
                            viewModelMilk.getMinPainScore()
                    );
                    freestall_protocol_3.setText(String.valueOf(protocolThreeScore));
                    viewModelMilk.setProtocolThreeScore(protocolThreeScore);
                }
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}