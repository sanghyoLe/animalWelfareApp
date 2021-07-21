package com.example.animal_project.BreedBatch.ProtocolThree;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;


public class BreedOphthalmic extends Fragment {
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_breed_ophthalmic, container, false);
        EditText breed_ophthalmic_ed = view.findViewById(R.id.breed_ophthalmic_ed);
        TextView breed_ophthalmic_tv = view.findViewById(R.id.breed_ophthalmic_ratio);
        TextView sample_size_tv = view.findViewById(R.id.sample_size_tv);
        EditText pen_location_one_ed = view.findViewById(R.id.pen_location_ed_1);
        EditText pen_location_two_ed = view.findViewById(R.id.pen_location_ed_2);
        QuestionTemplateViewModel viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);

        breed_ophthalmic_ed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                viewModel.penQuestionAfterTextChanged(breed_ophthalmic_ed,breed_ophthalmic_tv,
                        sample_size_tv, pen_location_one_ed,pen_location_two_ed,(QuestionTemplateViewModel.PenQuestion)viewModel.BreedOphthalmic);


            }

        });
       

        // Inflate the layout for this fragment
        return view;
    }
}