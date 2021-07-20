package com.example.animal_project.BreedBatch.ProtocolTwo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;


public class BreedShade extends Fragment {
    private View view;

    Integer shade = 0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        QuestionTemplateViewModel viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);
        view = inflater.inflate(R.layout.fragment_breed_shade, container, false);

        RadioGroup shadeRg = view.findViewById(R.id.breed_shade_rg);
            shadeRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    if(checkedId == R.id.breed_shade_1)
                    {
                        shade = 1;
                    } else if(checkedId == R.id.breed_shade_2)
                    {
                        shade = 2;
                    }
                    ((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedShade).setSelectedItem(shade);
                }
            });



        return view;
    }
}