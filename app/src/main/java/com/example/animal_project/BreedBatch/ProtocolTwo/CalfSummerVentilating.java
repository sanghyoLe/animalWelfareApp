package com.example.animal_project.BreedBatch.ProtocolTwo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;


public class CalfSummerVentilating extends Fragment {
    private View view;
    private RadioGroup summerVentilatingRg;
    Integer summerVentilating = 0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        QuestionTemplateViewModel viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);
        view = inflater.inflate(R.layout.fragment_calf_summer_ventilating, container, false);
        summerVentilatingRg = view.findViewById(R.id.calf_summer_ventilating_rg);

        summerVentilatingRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.calf_summer_ventilating_1){
                    summerVentilating = 1;
                }else if(checkedId == R.id.calf_summer_ventilating_2){
                    summerVentilating = 2;
                }
                viewModel.setCalfSummerVentilatingScore(summerVentilating);
            }
        });


        return view;
    }
}