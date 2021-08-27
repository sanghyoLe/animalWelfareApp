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


public class CalfWarm extends Fragment {

    private View view;
    Integer calfWarm = 0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_calf_warm, container, false);
        QuestionTemplateViewModel viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);
        RadioGroup calfWarmRg = view.findViewById(R.id.calf_warm_rg);

        calfWarmRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.calf_warm_1){
                    calfWarm = 1;
                }else if(checkedId == R.id.calf_warm_2){
                    calfWarm = 2;
                }
                ((QuestionTemplateViewModel.RadioQuestion)viewModel.CalfWarm).setSelectedItem(calfWarm);
                int selectedItem = ((QuestionTemplateViewModel.RadioQuestion)viewModel.CalfWarm).getSelectedItem();
                ((QuestionTemplateViewModel.RadioQuestion)viewModel.CalfWarm).setAnswer(calfWarmRg,selectedItem);
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}