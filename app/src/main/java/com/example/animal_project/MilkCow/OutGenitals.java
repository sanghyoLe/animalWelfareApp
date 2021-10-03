package com.example.animal_project.MilkCow;


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


public class OutGenitals extends Fragment {
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_out_genitals, container, false);

        QuestionTemplateViewModel viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);

      
        EditText outGenitalEd = (EditText) view.findViewById(R.id.outgenitals_a1);
        TextView outGenitalTv = (TextView) view.findViewById(R.id.outgenitals_ratio_1);

        EditText penLocationOne = view.findViewById(R.id.pen_location_ed_1);
        EditText penLocationTwo = view.findViewById(R.id.pen_location_ed_2);


        outGenitalEd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                viewModel.penQuestionAfterTextChanged(outGenitalEd,outGenitalTv,
                     penLocationOne,penLocationTwo,(QuestionTemplateViewModel.PenQuestion)viewModel.OutGenitals);
            }
        });
        return view;
    }
}