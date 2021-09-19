package com.example.animal_project.Beef.ProtocolThree;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;


public class BreedHornQ2 extends Fragment {
private View view;
private int anesthesia;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_breed_horn_q2, container, false);
        RadioGroup breed_horn_q2_rg = (RadioGroup) view.findViewById(R.id.breed_horn_q2_rg);
        QuestionTemplateViewModel viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);
        breed_horn_q2_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.breed_horn_q2_1) {
                    anesthesia = 1;
                } else if (checkedId == R.id.breed_horn_q2_2) {
                    anesthesia = 2;
                }
                ((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedHornAnesthesia).setSelectedItem(anesthesia);
                int selectedItem =((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedHornAnesthesia).getSelectedItem();
                ((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedHornAnesthesia).setAnswer(breed_horn_q2_rg,selectedItem);
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}