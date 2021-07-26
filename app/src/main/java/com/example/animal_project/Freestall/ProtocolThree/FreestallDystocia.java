package com.example.animal_project.Freestall.ProtocolThree;


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

import com.example.animal_project.Input_userinfo;
import com.example.animal_project.MilkCowViewModel;
import com.example.animal_project.QuestionTemplate;
import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;
import com.example.animal_project.Result_View;


public class FreestallDystocia extends Fragment {
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_freestall_dystocia, container, false);
        MilkCowViewModel viewModel = new ViewModelProvider(getActivity()).get(MilkCowViewModel.class);
        QuestionTemplateViewModel viewModel2 = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);
        EditText dystocia_count_a1 = (EditText) view.findViewById(R.id.dystocia_count_a1);
        EditText dystocia_a1 = (EditText) view.findViewById(R.id.dystocia_a1);
        TextView dystocia_ratio_1 = (TextView) view.findViewById(R.id.dystocia_ratio_1);
        dystocia_count_a1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (TextUtils.isEmpty(dystocia_count_a1.getText().toString())){
                    dystocia_ratio_1.setText("값을 입력하세요");
                    viewModel.setDystociaRatio(-1);
                } else if (TextUtils.isEmpty(dystocia_a1.getText().toString())) {
                    dystocia_ratio_1.setText("값을 입력하세요");
                } else if(Integer.parseInt(dystocia_a1.getText().toString()) > Integer.parseInt(dystocia_count_a1.getText().toString())) {
                    viewModel.setDystociaRatio(-1);
                    dystocia_ratio_1.setText("2번 문항은 1번 문항보다 클 수 없습니다");
                } else {
                    float ratio = Float.parseFloat(dystocia_a1.getText().toString()) / Float.parseFloat(dystocia_count_a1.getText().toString());
                    ratio = ratio * 100;
                    viewModel.setDystociaRatio(ratio);
                    dystocia_ratio_1.setText(String.valueOf(ratio));
                }
            }
        });
        dystocia_a1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (TextUtils.isEmpty(dystocia_count_a1.getText().toString())){
                    dystocia_ratio_1.setText("값을 입력하세요");
                    viewModel.setDystociaRatio(-1);
                } else if (TextUtils.isEmpty(dystocia_a1.getText().toString())) {
                    dystocia_ratio_1.setText("값을 입력하세요");
                } else if(Integer.parseInt(dystocia_a1.getText().toString()) > Integer.parseInt(dystocia_count_a1.getText().toString())) {
                    viewModel.setDystociaRatio(-1);
                    dystocia_ratio_1.setText("2번 문항은 1번 문항보다 클 수 없습니다");
                } else {
                    float ratio = Float.parseFloat(dystocia_a1.getText().toString()) / Float.parseFloat(dystocia_count_a1.getText().toString());
                    ratio = ratio * 100;
                    ratio = Math.round(ratio);
                    viewModel.setDystociaRatio(ratio);
                    dystocia_ratio_1.setText(String.valueOf(ratio));
                }
            }
        });

        return view;
    }
}