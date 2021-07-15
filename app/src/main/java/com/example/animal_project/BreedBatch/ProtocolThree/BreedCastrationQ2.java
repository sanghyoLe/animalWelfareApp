package com.example.animal_project.BreedBatch.ProtocolThree;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;

public class BreedCastrationQ2 extends Fragment {
    private View view;
    private int anesthesia;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_breed_castration_q2, container, false);
        // Inflate the layout for this fragment
        RadioGroup breed_castration_q2_rg = (RadioGroup) view.findViewById(R.id.breed_castration_q2_rg);
        QuestionTemplateViewModel viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);
        breed_castration_q2_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.breed_castration_q2_1) {
                    anesthesia = 1;
                } else if (checkedId == R.id.breed_castration_q2_2) {
                    anesthesia = 2;
                }
                viewModel.setCastrationAnesthesia(anesthesia);
            }
        });


        return view;
    }
}