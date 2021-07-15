package com.example.animal_project.BreedBatch.ProtocolTwo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;


public class BreedWinterVentilating extends Fragment {
    private View view;
    Integer winterVentilating = 0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_breed_winter_ventilating, container, false);
        QuestionTemplateViewModel viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);
        RadioGroup winterVentilatingRg = view.findViewById(R.id.breed_winter_ventilating_rg);
        TextView winterRestScoreTv = view.findViewById(R.id.breed_winter_rest_score);
        winterVentilatingRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.breed_winter_ventilating_1){
                    winterVentilating = 1;
                }else if(checkedId == R.id.breed_winter_ventilating_2){
                    winterVentilating = 2;
                }
                viewModel.setWinterVentilatingScore(winterVentilating);
                if(viewModel.getWindBlockScore() == 0){
                    winterRestScoreTv.setText("9번 문항을 완료해주세요");
                }  else {
                    int winterRestScore = viewModel.calculatorBreedWinterRestScore(viewModel.getWindBlockScore(),viewModel.getWinterVentilatingScore());
                    viewModel.setWinterRestScore(winterRestScore);
                    winterRestScoreTv.setText(String.valueOf(winterRestScore));

                }
            }
        });

        return view;
    }
}