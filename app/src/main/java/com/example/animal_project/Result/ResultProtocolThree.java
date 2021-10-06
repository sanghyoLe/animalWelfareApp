package com.example.animal_project.Result;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;

public class ResultProtocolThree extends Fragment {
    QuestionTemplateViewModel viewModel;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.result_3, container, false);

        viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);
        LinearLayout ruminantLayout = view.findViewById(R.id.ruminant_layout);
        LinearLayout milkCowDiseaseLayout = view.findViewById(R.id.milk_cow_disease_layout);
        TextView protocolScoreTv = view.findViewById(R.id.protocol_score_tv);
        TextView woundScoreTv = view.findViewById(R.id.protocol_wound_score_tv);
        TextView limpScoreTv = view.findViewById(R.id.limp_score_tv);
        TextView hairLossScoreTv = view.findViewById(R.id.hair_loss_score_tv);
        TextView diseaseScoreTv = view.findViewById(R.id.protocol_disease_score_tv);
        TextView painScoreTv = view.findViewById(R.id.protocol_pain_score_tv);

        TextView hornRemoveScoreTv =view.findViewById(R.id.horn_remove_score_tv);
        TextView castrationScoreTv = view.findViewById(R.id.castration_score_tv);


        if(viewModel.isBeef(viewModel.getFarmType())){
            ruminantLayout.setVisibility(View.VISIBLE);
        }else {
            milkCowDiseaseLayout.setVisibility(View.VISIBLE);
        }
        protocolScoreTv.setText(String.valueOf((int)viewModel.getProtocolThreeScore()));
        woundScoreTv.setText(String.valueOf((int)viewModel.getMinInjuryScore()));
        if(viewModel.isBeef(viewModel.getFarmType())){
            limpScoreTv.setText(String.valueOf((int)((QuestionTemplateViewModel.Question)viewModel.BreedLimp).getScore()));
        }else {
            limpScoreTv.setText(String.valueOf((int)((QuestionTemplateViewModel.Question)viewModel.CriticalLimp).getScore()));
        }

        hairLossScoreTv.setText(String.valueOf((int)viewModel.getHairLossScore()));
        diseaseScoreTv.setText(String.valueOf((int)viewModel.getDiseaseScore()));
        painScoreTv.setText(String.valueOf((int)viewModel.getMinPainScore()));
        hornRemoveScoreTv.setText(String.valueOf((int)viewModel.getHornRemovalScore()));
        castrationScoreTv.setText(String.valueOf((int)viewModel.getCastrationScore()));


        return view;
    }
}
