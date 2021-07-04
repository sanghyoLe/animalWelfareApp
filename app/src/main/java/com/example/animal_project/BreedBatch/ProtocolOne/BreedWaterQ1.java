package com.example.animal_project.BreedBatch.ProtocolOne;



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
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.animal_project.Input_userinfo;
import com.example.animal_project.MainActivity;
import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;
import com.example.animal_project.Result_View;

public class BreedWaterQ1 extends Fragment {
    private View view;
    Integer waterTankNum = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        QuestionTemplateViewModel viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);

        view = inflater.inflate(R.layout.fragment_breed_water_q1, container, false);
        RadioGroup breed_water_tank_num = (RadioGroup) view.findViewById(R.id.breed_water_tank_num);

        breed_water_tank_num.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.breed_water_tank_num_1) {
                    waterTankNum = 1;
                } else if (checkedId == R.id.breed_water_tank_num_2) {
                    waterTankNum = 2;
                }
                viewModel.setWaterTankNum(waterTankNum);
            }
        });


      return view;



    }

}