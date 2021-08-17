package com.example.animal_project.BreedBatch.ProtocolThree;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;

public class BreedHornQ1 extends Fragment {
    private View view;
    private int hornRemoval;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_breed_horn_q1, container, false);
        RadioGroup breed_horn_q1_rg = (RadioGroup) view.findViewById(R.id.breed_horn_q1_rg);
        QuestionTemplateViewModel viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);
        breed_horn_q1_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.breed_horn_q1_1) {
                    hornRemoval = 1;
                } else if (checkedId == R.id.breed_horn_q1_2) {
                    hornRemoval = 2;
                } else if (checkedId == R.id.breed_horn_q1_3) {
                    hornRemoval = 3;
                } else if (checkedId == R.id.breed_horn_q1_4) {
                    hornRemoval = 4;
                }
                ((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedHornRemoval).setSelectedItem(hornRemoval);
                int selectedItem =((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedHornRemoval).getSelectedItem();
                ((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedHornRemoval).setAnswer(breed_horn_q1_rg,selectedItem);

            }
        });



        return view;
    }
}