package com.example.animal_project.BreedBatch.ProtocolThree;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;

public class BreedRunnyNose extends Fragment {
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_breed_runny_nose, container, false);
        // Inflate the layout for this fragment
        EditText breed_runny_nose_ed = view.findViewById(R.id.breed_runny_nose_ed);
        TextView breed_runny_nose_ratio_tv = view.findViewById(R.id.breed_runny_nose_ratio);
        TextView sample_size_tv = view.findViewById(R.id.sample_size_tv);
        QuestionTemplateViewModel viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);







        breed_runny_nose_ed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(TextUtils.isEmpty(breed_runny_nose_ed.getText().toString())){
                    breed_runny_nose_ratio_tv.setText("값을 입력하세요");
                    viewModel.setRunnyNoseRatio(-1);
                } else if(viewModel.getRatio(breed_runny_nose_ed) > 100) {
                    viewModel.setRunnyNoseRatio(-1);
                    breed_runny_nose_ratio_tv.setText("표본 규모보다 큰 값 입력 불가");
                    sample_size_tv.setVisibility(View.VISIBLE);
                    sample_size_tv.setText("표본 규모 : " + String.valueOf(viewModel.getSampleCowSize()));
                } else {
                    viewModel.setRunnyNoseRatio((float)viewModel.getRatio(breed_runny_nose_ed));
                    breed_runny_nose_ratio_tv.setText(String.valueOf(viewModel.getRatio(breed_runny_nose_ed)));
                }
            }

        });
        return view;
    }
}