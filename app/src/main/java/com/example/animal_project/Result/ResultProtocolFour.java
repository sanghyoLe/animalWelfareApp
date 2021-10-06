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

public class ResultProtocolFour extends Fragment {
    QuestionTemplateViewModel viewModel;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.result_4, container, false);
        viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);
        LinearLayout harmonyLayout = view.findViewById(R.id.harmony_layout);
        TextView protocolScoreTv = view.findViewById(R.id.protocol_score_tv);
        TextView behaviorScoreTv = view.findViewById(R.id.protocol_behavior_score_tv);
        TextView avoidDistanceScoreTv = view.findViewById(R.id.protocol_avoid_distance_score_tv);

        protocolScoreTv.setText(String.valueOf((int)viewModel.getProtocolFourScore()));
        behaviorScoreTv.setText(String.valueOf(viewModel.getSocialBehaviorScore()));
        avoidDistanceScoreTv.setText(String.valueOf(viewModel.getAvoidDistanceScore()));
        if(viewModel.isBeef(viewModel.getFarmType())){
            harmonyLayout.setVisibility(View.VISIBLE);
        }

        return view;
    }
}
