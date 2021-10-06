package com.example.animal_project.Result;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;

public class ResultProtocolOne extends Fragment {
    QuestionTemplateViewModel viewModel;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.result_1, container, false);

        viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);
        TextView protocolOneTv = view.findViewById(R.id.protocol_score_tv);
        TextView nutritionScoreTv = view.findViewById(R.id.protocol_one_nutrition_tv);
        TextView waterScoreTv = view.findViewById(R.id.protocol_one_water_tv);
        protocolOneTv.setText(String.valueOf((int)viewModel.getProtocolOneScore()));
        nutritionScoreTv.setText(String.valueOf((int)viewModel.getPoorScore()));
        waterScoreTv.setText(String.valueOf((int)viewModel.getWaterScore()));

        return view;
    }
}
