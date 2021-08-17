package com.example.animal_project.BreedBatch.ProtocolTwo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;


public class CalfShade extends Fragment {
    private View view;

    Integer shade = 0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        QuestionTemplateViewModel viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);
        view = inflater.inflate(R.layout.fragment_calf_shade, container, false);

        RadioGroup shadeRg = view.findViewById(R.id.calf_shade_rg);
        shadeRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.calf_shade_1)
                {
                    shade = 1;
                } else if(checkedId == R.id.calf_shade_2)
                {
                    shade = 2;
                }
                ((QuestionTemplateViewModel.RadioQuestion)viewModel.CalfShade).setSelectedItem(shade);
                int selectedItem = ((QuestionTemplateViewModel.RadioQuestion)viewModel.CalfShade).getSelectedItem();
                ((QuestionTemplateViewModel.RadioQuestion)viewModel.CalfShade).setAnswer(shadeRg,selectedItem);
            }
        });



        return view;
    }
}