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


        breed_breath_ed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(TextUtils.isEmpty(breed_breath_ed.getText().toString())){
                    breed_breath_tv.setText("값을 입력하세요");
                    viewModel.setBreathRatio(-1);
                } else if(viewModel.getRatio(breed_breath_ed) > 100) {
                    viewModel.setBreathRatio(-1);
                    breed_breath_tv.setText("표본 규모보다 큰 값 입력 불가");
                    sample_size_tv.setVisibility(View.VISIBLE);
                    sample_size_tv.setText("표본 규모 : " + String.valueOf(viewModel.getSampleCowSize()));
                } else {
                    viewModel.setBreathRatio(viewModel.getRatio(breed_breath_ed));
                    breed_breath_tv.setText(String.valueOf(viewModel.getRatio(breed_breath_ed)));
                }
            }

        });

        // Inflate the layout for this fragment
        return view;
    }
}