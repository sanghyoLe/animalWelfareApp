package com.example.animal_project.FreeStall.ProtocolOne;



import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;

public class FreestallWaterQ2 extends Fragment {
    private View view;
    Integer waterTankClean = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        QuestionTemplateViewModel viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);
        view = inflater.inflate(R.layout.fragment_breed_water_q2, container, false);
        RadioGroup breed_water_tank_clean = (RadioGroup) view.findViewById(R.id.breed_water_tank_clean);
        breed_water_tank_clean.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.breed_water_tank_clean_1) {
                    waterTankClean = 1;
                } else if (checkedId == R.id.breed_water_tank_clean_2) {
                    waterTankClean = 2;
                } else if (checkedId == R.id.breed_water_tank_clean_3) {
                    waterTankClean = 3;
                }
                viewModel.setWaterTankClean(waterTankClean);
            }
        });

        return view;



    }

}