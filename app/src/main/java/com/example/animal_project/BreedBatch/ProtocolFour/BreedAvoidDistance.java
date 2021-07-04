package com.example.animal_project.BreedBatch.ProtocolFour;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;


public class BreedAvoidDistance extends Fragment {
    private QuestionTemplateViewModel viewModel;
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel .class);
        view = inflater.inflate(R.layout.fragment_breed_avoid_distance, container, false);
        viewModel.setAvoidDistanceScore(50);

        TextView protocol_4 = view.findViewById(R.id.breed_protocol_4);
        if(viewModel.getSocialBehaviorScore() == -1){
            protocol_4.setText("사회적 행동의 표현 평가를 완료하세요");
        } else {
            viewModel.setProtocolFourScore(
                    viewModel.calculatorProtocolFourScore
                            (
                                    viewModel.getSocialBehaviorScore(),
                                    viewModel.getAvoidDistanceScore()
                            )
            );
            protocol_4.setText(String.valueOf(viewModel.getProtocolFourScore()));

        }
        // Inflate the layout for this fragment
        return view;
    }
}