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


public class BreedCastrationQ1 extends Fragment {
    private View view;
    private int castration;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_breed_castration_q1, container, false);
        // Inflate the layout for this fragment
        RadioGroup breed_castration_q1_rg = (RadioGroup) view.findViewById(R.id.breed_castration_q1_rg);
        QuestionTemplateViewModel viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);
        breed_castration_q1_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.breed_castration_q1_1) {
                    castration = 1;
                } else if (checkedId == R.id.breed_castration_q1_2) {
                    castration = 2;
                } else if (checkedId == R.id.breed_castration_q1_3) {
                    castration = 3;
                } else if (checkedId == R.id.breed_castration_q1_4) {
                    castration = 4;
                }
                ((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedCastration).setSelectedItem(castration);
                int selectedItem =((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedCastration).getSelectedItem();
                ((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedCastration).setAnswer(breed_castration_q1_rg,selectedItem);
            }
        });


        return view;
    }
}