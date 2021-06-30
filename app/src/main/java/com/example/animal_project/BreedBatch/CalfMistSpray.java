package com.example.animal_project.BreedBatch;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;


public class CalfMistSpray extends Fragment {
    private View view;
    Integer mistSpray = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_calf_mist_spray, container, false);
        QuestionTemplateViewModel viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);
        TextView calfRestScoreTv = view.findViewById(R.id.calf_summer_rest_score);
        RadioGroup mistSprayRg = view.findViewById(R.id.calf_mist_spray_rg);


        mistSprayRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.calf_mist_spray_1)
                {
                    mistSpray = 1;
                } else if(checkedId == R.id.calf_mist_spray_2)
                {
                    mistSpray = 2;
                }
                viewModel.setCalfMistSprayScore(mistSpray);

                if(viewModel.getCalfShadeScore() == 0){
                    calfRestScoreTv.setText("11번 문항을 완료해주세요");
                } else if(viewModel.getCalfSummerVentilatingScore() == 0){
                    calfRestScoreTv.setText("12번 문항을 완료해주세요");
                } else {
                    int summerRestScore = viewModel.calculatorBreedSummerRestScore(
                            viewModel.getCalfShadeScore(),
                            viewModel.getCalfSummerVentilatingScore(),
                            viewModel.getCalfMistSprayScore()
                    );
                    viewModel.setCalfSummerRestScore(summerRestScore);
                    calfRestScoreTv.setText(String.valueOf(summerRestScore));
                }

            }
        });






        return view;
    }
}