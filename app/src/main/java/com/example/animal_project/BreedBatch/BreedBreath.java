package com.example.animal_project.BreedBatch;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;


public class BreedBreath extends Fragment {
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_breed_breath, container, false);
        EditText breed_breath_ed = view.findViewById(R.id.breed_breath_ed);
        TextView breed_breath_tv = view.findViewById(R.id.breed_breath_ratio);
        TextView sample_size_tv = view.findViewById(R.id.sample_size_tv);
        QuestionTemplateViewModel viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);

        float ratio = viewModel.setDiseaseSectionRatio(breed_breath_ed,breed_breath_tv,sample_size_tv);
        if(ratio == -1){

        }else {
            viewModel.setBreathRatio(ratio);
        }

        // Inflate the layout for this fragment
        return view;
    }
}