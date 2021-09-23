package com.example.animal_project.FreeStall.ProtocolOne;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;


import com.example.animal_project.QuestionTemplate;
import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;

public class FreestallWaterQ1 extends Fragment {
    private View view;
    Integer waterTankNum = 0;

    QuestionTemplate questionTemplate;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        questionTemplate = (QuestionTemplate) getActivity();
    }
    @Override
    public void onDetach() {
        super.onDetach();
        questionTemplate = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        QuestionTemplateViewModel viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);

        view = inflater.inflate(R.layout.fragment_freestall_water_q1_1, container, false);
        RadioGroup freestall_water_supply = (RadioGroup) view.findViewById(R.id.freestall_water_supply);

        freestall_water_supply.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.freestall_water_supply_1) {
                    questionTemplate.fragmentChange(1);
                } else if (checkedId == R.id.freestall_water_supply_2) {
                    questionTemplate.fragmentChange(2);
                }
            }
        });


        return view;



    }

}