package com.example.animal_project.Beef.ProtocolThree;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

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

        EditText penLocationOne = view.findViewById(R.id.pen_location_ed_1);
        EditText penLocationTwo = view.findViewById(R.id.pen_location_ed_2);
        QuestionTemplateViewModel viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);

        penLocationOne.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                viewModel.penQuestionAfterTextChanged(breed_breath_ed,breed_breath_tv,
                        penLocationOne,penLocationTwo,(QuestionTemplateViewModel.PenQuestion)viewModel.BreedBreath);
            }
        });
        penLocationTwo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                viewModel.penQuestionAfterTextChanged(breed_breath_ed,breed_breath_tv,
                        penLocationOne,penLocationTwo,(QuestionTemplateViewModel.PenQuestion)viewModel.BreedBreath);
            }
        });
        breed_breath_ed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                viewModel.penQuestionAfterTextChanged(breed_breath_ed,breed_breath_tv,
                         penLocationOne,penLocationTwo,(QuestionTemplateViewModel.PenQuestion)viewModel.BreedBreath);

            }

        });

        // Inflate the layout for this fragment
        return view;
    }
}