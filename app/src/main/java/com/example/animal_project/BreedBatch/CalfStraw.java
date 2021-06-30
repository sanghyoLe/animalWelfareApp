package com.example.animal_project.BreedBatch;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;


public class CalfStraw extends Fragment {
    private View view;
    Integer calfStraw = 0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_calf_straw, container, false);
        QuestionTemplateViewModel viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);

        RadioGroup calfStrawRg = view.findViewById(R.id.calf_straw_rg);

        calfStrawRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.calf_straw_1){
                    calfStraw = 1;
                }else if(checkedId == R.id.calf_straw_2){
                    calfStraw = 2;
                }
                viewModel.setCalfStrawScore(calfStraw);
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}