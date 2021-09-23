package com.example.animal_project.FreeStall.ProtocolTwo;


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

import com.example.animal_project.MilkCowViewModel;
import com.example.animal_project.QuestionTemplate;
import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;


public class FreestallAreaOutCollision extends Fragment {
    int freestall_area_out_collision_score = 0;
    private EditText freestall_area_out_collision_a1, freestall_area_out_collision_a2;
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_freestall_area_out_collision, container, false);
        MilkCowViewModel viewModel = new ViewModelProvider(getActivity()).get(MilkCowViewModel.class);
        QuestionTemplateViewModel viewModel2 = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);

        freestall_area_out_collision_a1 = (EditText) view.findViewById(R.id.freestall_area_out_collision_a1);
        freestall_area_out_collision_a2 = (EditText) view.findViewById(R.id.freestall_area_out_collision_a2);
        TextView freestall_area_out_collision_ratio = (TextView) view.findViewById(R.id.freestall_area_out_collision_ratio);
        TextView freestall_area_out_collision_score = (TextView) view.findViewById(R.id.freestall_area_out_collision_score);
        QuestionTemplate activity = (QuestionTemplate) getActivity();

        freestall_area_out_collision_a1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (TextUtils.isEmpty(freestall_area_out_collision_a1.getText().toString())) {
                    freestall_area_out_collision_ratio.setText("값을 입력해주세요");
                    freestall_area_out_collision_score.setText("문항을 완료하세요");
                    viewModel.setAreaOutCollision(-1);
                } else if (TextUtils.isEmpty(freestall_area_out_collision_a2.getText().toString())) {
                    freestall_area_out_collision_ratio.setText("값을 입력해주세요");
                    freestall_area_out_collision_score.setText("문항을 완료하세요");
                    viewModel.setAreaOutCollision(-1);
                } else if (Integer.parseInt(freestall_area_out_collision_a1.getText().toString()) > viewModel2.getSampleCowSize()) {
                    Log.d("샘플:", String.valueOf(viewModel2.getSampleCowSize()));
                    freestall_area_out_collision_ratio.setText("표본 두수보다 큰 값을 입력할 수 없습니다.");
                } else if (Integer.parseInt(freestall_area_out_collision_a2.getText().toString()) > Integer.parseInt(freestall_area_out_collision_a1.getText().toString())) {
                    freestall_area_out_collision_ratio.setText("2번 문항은 1번 문항의 값보다 클 수 없습니다");
                    freestall_area_out_collision_score.setText("2번 문항은 1번 문항의 값보다 클 수 없습니다");
                } else {
                    int areaOutCollisionScore = 0;
                    float ratio = Float.parseFloat(freestall_area_out_collision_a2.getText().toString()) / Float.parseFloat(freestall_area_out_collision_a1.getText().toString());;
                    ratio = ratio * 100;
                    ratio = Math.round(ratio);
                    freestall_area_out_collision_ratio.setText(String.valueOf(ratio));
                    areaOutCollisionScore = viewModel.calculatorAreaOutCollisionScore(ratio);
                    freestall_area_out_collision_score.setText(String.valueOf(areaOutCollisionScore));
                    viewModel.setAreaOutCollision(areaOutCollisionScore);
                }
            }
        });
        freestall_area_out_collision_a2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (TextUtils.isEmpty(freestall_area_out_collision_a1.getText().toString())) {
                    freestall_area_out_collision_ratio.setText("값을 입력해주세요");
                    freestall_area_out_collision_score.setText("문항을 완료하세요");
                    viewModel.setAreaOutCollision(-1);
                } else if (TextUtils.isEmpty(freestall_area_out_collision_a2.getText().toString())) {
                    freestall_area_out_collision_ratio.setText("값을 입력해주세요");
                    freestall_area_out_collision_score.setText("문항을 완료하세요");
                    viewModel.setAreaOutCollision(-1);
                } else if (Integer.parseInt(freestall_area_out_collision_a2.getText().toString()) > viewModel2.getSampleCowSize()) {
                    freestall_area_out_collision_ratio.setText("표본 두수보다 큰 값을 입력할 수 없습니다.");
                } else if (Integer.parseInt(freestall_area_out_collision_a2.getText().toString()) > Integer.parseInt(freestall_area_out_collision_a1.getText().toString())) {
                    freestall_area_out_collision_ratio.setText("2번 문항은 1번 문항의 값보다 클 수 없습니다");
                    freestall_area_out_collision_score.setText("2번 문항은 1번 문항의 값보다 클 수 없습니다");
                } else {
                    int areaOutCollisionScore = 0;
                    float ratio = Float.parseFloat(freestall_area_out_collision_a2.getText().toString()) / Float.parseFloat(freestall_area_out_collision_a1.getText().toString());
                    ratio = ratio * 100;
                    ratio = Math.round(ratio);
                    freestall_area_out_collision_ratio.setText(String.valueOf(ratio));
                    areaOutCollisionScore = viewModel.calculatorAreaOutCollisionScore(ratio);
                    freestall_area_out_collision_score.setText(String.valueOf(areaOutCollisionScore));
                    viewModel.setAreaOutCollision(areaOutCollisionScore);
                }
            }
        });

        return view;
    }
}