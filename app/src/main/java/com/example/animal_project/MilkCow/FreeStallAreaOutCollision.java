package com.example.animal_project.MilkCow;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.animal_project.QuestionTemplate;
import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;


public class FreeStallAreaOutCollision extends Fragment {

    private EditText freeStallAreaOutCollisionSitEd, freeStallAreaOutCollisionOutEd;
    private View view;
    private QuestionTemplateViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_freestall_area_out_collision, container, false);

        viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);
        freeStallAreaOutCollisionSitEd = (EditText) view.findViewById(R.id.free_stall_area_out_collision_sit_ed);
        freeStallAreaOutCollisionOutEd = (EditText) view.findViewById(R.id.free_stall_area_out_collision_out_ed);
        TextView freeStallAreaOutCollisionRatioTv = (TextView) view.findViewById(R.id.freestall_area_out_collision_ratio);
        TextView freeStallAreaOutCollisionScoreTv = (TextView) view.findViewById(R.id.freestall_area_out_collision_score);
        QuestionTemplate activity = (QuestionTemplate) getActivity();

        freeStallAreaOutCollisionSitEd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (TextUtils.isEmpty(freeStallAreaOutCollisionSitEd.getText().toString())) {
                    freeStallAreaOutCollisionRatioTv.setText("값을 입력해주세요");
                    freeStallAreaOutCollisionScoreTv.setText("문항을 완료하세요");
                    wrongInputSetValues();
                } else if (TextUtils.isEmpty(freeStallAreaOutCollisionOutEd.getText().toString())) {
                    freeStallAreaOutCollisionRatioTv.setText("값을 입력해주세요");
                    freeStallAreaOutCollisionScoreTv.setText("문항을 완료하세요");
                    wrongInputSetValues();
                } else if (Integer.parseInt(freeStallAreaOutCollisionSitEd.getText().toString()) > viewModel.getSampleCowSize()) {
                    freeStallAreaOutCollisionRatioTv.setText("표본 두수보다 큰 값을 입력할 수 없습니다.");
                    wrongInputSetValues();
                } else if (Integer.parseInt(freeStallAreaOutCollisionOutEd.getText().toString()) > Integer.parseInt(freeStallAreaOutCollisionSitEd.getText().toString())) {
                    freeStallAreaOutCollisionRatioTv.setText("2번 문항은 1번 문항의 값보다 클 수 없습니다");
                    freeStallAreaOutCollisionScoreTv.setText("2번 문항은 1번 문항의 값보다 클 수 없습니다");
                    wrongInputSetValues();
                } else {
                    int areaOutCollisionScore = 0;
                    float ratio = Float.parseFloat(freeStallAreaOutCollisionOutEd.getText().toString()) / Float.parseFloat(freeStallAreaOutCollisionSitEd.getText().toString());;
                    ratio = ratio * 100;
                    ratio = Math.round(ratio);
                    ((QuestionTemplateViewModel.FreeStallAreaOutCollision)viewModel.freeStallAreaOutCollision).setSitCowCount(
                            Integer.parseInt(freeStallAreaOutCollisionSitEd.getText().toString()));
                    ((QuestionTemplateViewModel.FreeStallAreaOutCollision)viewModel.freeStallAreaOutCollision).setAreaOutCollisionCowCount(
                            Integer.parseInt(freeStallAreaOutCollisionSitEd.getText().toString()));
                    ((QuestionTemplateViewModel.FreeStallAreaOutCollision)viewModel.freeStallAreaOutCollision).setRatio(ratio);
                    areaOutCollisionScore = ((QuestionTemplateViewModel.FreeStallAreaOutCollision)viewModel.freeStallAreaOutCollision).calculatorScore(ratio);
                    ((QuestionTemplateViewModel.FreeStallAreaOutCollision)viewModel.freeStallAreaOutCollision).setScore(areaOutCollisionScore);
                    freeStallAreaOutCollisionScoreTv.setText(String.valueOf(areaOutCollisionScore));
                    freeStallAreaOutCollisionRatioTv.setText(String.valueOf(ratio));

                }
            }
        });
        freeStallAreaOutCollisionOutEd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (TextUtils.isEmpty(freeStallAreaOutCollisionSitEd.getText().toString())) {
                    freeStallAreaOutCollisionRatioTv.setText("값을 입력해주세요");
                    freeStallAreaOutCollisionScoreTv.setText("문항을 완료하세요");
                    wrongInputSetValues();
                } else if (TextUtils.isEmpty(freeStallAreaOutCollisionOutEd.getText().toString())) {
                    freeStallAreaOutCollisionRatioTv.setText("값을 입력해주세요");
                    freeStallAreaOutCollisionScoreTv.setText("문항을 완료하세요");
                    wrongInputSetValues();
                } else if (Integer.parseInt(freeStallAreaOutCollisionOutEd.getText().toString()) > viewModel.getSampleCowSize()) {
                    freeStallAreaOutCollisionRatioTv.setText("표본 두수보다 큰 값을 입력할 수 없습니다.");
                    wrongInputSetValues();
                } else if (Integer.parseInt(freeStallAreaOutCollisionOutEd.getText().toString()) > Integer.parseInt(freeStallAreaOutCollisionSitEd.getText().toString())) {
                    freeStallAreaOutCollisionRatioTv.setText("2번 문항은 1번 문항의 값보다 클 수 없습니다");
                    freeStallAreaOutCollisionScoreTv.setText("2번 문항은 1번 문항의 값보다 클 수 없습니다");
                    wrongInputSetValues();
                } else {
                    int areaOutCollisionScore = 0;
                    float ratio = Float.parseFloat(freeStallAreaOutCollisionOutEd.getText().toString()) / Float.parseFloat(freeStallAreaOutCollisionSitEd.getText().toString());;
                    ratio = ratio * 100;
                    ratio = (float) (Math.round(ratio*100)/100.0);
                    ((QuestionTemplateViewModel.FreeStallAreaOutCollision)viewModel.freeStallAreaOutCollision).setSitCowCount(
                            Integer.parseInt(freeStallAreaOutCollisionSitEd.getText().toString()));
                    ((QuestionTemplateViewModel.FreeStallAreaOutCollision)viewModel.freeStallAreaOutCollision).setAreaOutCollisionCowCount(
                            Integer.parseInt(freeStallAreaOutCollisionSitEd.getText().toString()));
                    ((QuestionTemplateViewModel.FreeStallAreaOutCollision)viewModel.freeStallAreaOutCollision).setRatio(ratio);
                    areaOutCollisionScore = ((QuestionTemplateViewModel.FreeStallAreaOutCollision)viewModel.freeStallAreaOutCollision).calculatorScore(ratio);
                    ((QuestionTemplateViewModel.FreeStallAreaOutCollision)viewModel.freeStallAreaOutCollision).setScore(areaOutCollisionScore);
                    freeStallAreaOutCollisionScoreTv.setText(String.valueOf(areaOutCollisionScore));
                    freeStallAreaOutCollisionRatioTv.setText(String.valueOf(ratio));
                }
            }
        });

        return view;
    }
    public void wrongInputSetValues(){
        ((QuestionTemplateViewModel.FreeStallAreaOutCollision)viewModel.freeStallAreaOutCollision).setSitCowCount(-1);
        ((QuestionTemplateViewModel.FreeStallAreaOutCollision)viewModel.freeStallAreaOutCollision).setAreaOutCollisionCowCount(-1);
        ((QuestionTemplateViewModel.FreeStallAreaOutCollision)viewModel.freeStallAreaOutCollision).setScore(-1);
        ((QuestionTemplateViewModel.FreeStallAreaOutCollision)viewModel.freeStallAreaOutCollision).setRatio(-1);
    }
}