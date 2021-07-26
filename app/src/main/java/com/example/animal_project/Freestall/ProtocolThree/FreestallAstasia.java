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


public class FreestallAstasia extends Fragment {
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_freestall_astasia, container, false);
        MilkCowViewModel viewModel = new ViewModelProvider(getActivity()).get(MilkCowViewModel.class);
        QuestionTemplateViewModel viewModel2 = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);
        EditText astasia_count_a1 = (EditText) view.findViewById(R.id.astasia_count_a1);
        EditText astasia_a1 = (EditText) view.findViewById(R.id.astasia_a1);
        TextView astasia_ratio_1 = (TextView) view.findViewById(R.id.astasia_ratio_1);
        TextView disease_score = (TextView) view.findViewById(R.id.freestall_disease_score);

        astasia_count_a1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(TextUtils.isEmpty(astasia_count_a1.getText().toString())){
                    astasia_ratio_1.setText("값을 입력하세요");
                    disease_score.setText("문항을 완료하세요");
                    viewModel.setAstasiaRatio(-1);
                }else if(TextUtils.isEmpty(astasia_a1.getText().toString())){
                    astasia_ratio_1.setText("값을 입력하세요");
                    disease_score.setText("문항을 완료하세요");
                    viewModel.setAstasiaRatio(-1);
                }else if(Integer.parseInt(astasia_a1.getText().toString()) > Integer.parseInt(astasia_count_a1.getText().toString())){
                    viewModel.setAstasiaRatio(-1);
                    astasia_ratio_1.setText("2번 문항은 1번 문항보다 클 수 없습니다");
                    disease_score.setText("문항을 완료하세요");
                }else if(Integer.parseInt(astasia_count_a1.getText().toString()) > viewModel2.getTotalCowSize()) {
                    viewModel.setAstasiaRatio(-1);
                    astasia_ratio_1.setText("전체 두수보다 큰 값 입력 불가");
                }else if(viewModel2.getCoughRatio() == -1){ //영역2
                    disease_score.setText("기침 평가를 완료하세요");
                }else if(viewModel.getRunnyNoseRatio() == -1){ //영역1
                    disease_score.setText("비강분비물 평가를 완료하세요");
                }else if(viewModel.getOphthalmicRatio() == -1){ //영역1
                    disease_score.setText("안구분비물 평가를 완료하세요");
                }else if(viewModel.getRespiratoryRatio() == -1){ //영역2
                    disease_score.setText("호흡 장애 평가를 완료하세요");
                }else if(viewModel.getDiarrheaRatio() == -1){ //영역3
                    disease_score.setText("설사 평가를 완료하세요");
                }else if(viewModel.getOutGenitalsRatio() == -1){ //영역5
                    disease_score.setText("외음부 분비물 평가를 완료하세요");
                }else if(viewModel.getBreastRatio() == -1){ //영역4
                    disease_score.setText("우유내 체세포 평가를 완료하세요");
                }else if(viewModel.getFallDeadRatio() == -1){ //영역8
                    disease_score.setText("폐사율 평가를 완료하세요");
                }else if(viewModel.getDystociaRatio() == -1) { //영역6
                    disease_score.setText("난산 평가를 완료하세요");
                }else {
                    float ratio = Float.parseFloat(astasia_a1.getText().toString()) / Float.parseFloat(astasia_count_a1.getText().toString());
                    ratio = ratio * 100;
                    ratio = Math.round(ratio);
                    viewModel.setAstasiaRatio(ratio);
                    astasia_ratio_1.setText(String.valueOf(ratio));
                    double diseaseScore =
                    viewModel.calculatorDiseaseScore(
                            viewModel.calculatorCareWarningScore(
                                    viewModel.calculatorDiseaseSectionOne(viewModel.getRunnyNoseRatio(),viewModel.getOphthalmicRatio()),
                                    viewModel.calculatorDiseaseSectionTwo(viewModel2.getCoughRatio(),viewModel.getRespiratoryRatio()),
                                    viewModel.calculatorDiseaseSectionThree(viewModel.getDiarrheaRatio()),
                                    viewModel.calculatorDiseaseSectionFour(viewModel.getBreastRatio()),
                                    viewModel.calculatorDiseaseSectionFive(viewModel.getOutGenitalsRatio()),
                                    viewModel.calculatorDiseaseSectionSix(viewModel.getDystociaRatio()),
                                    viewModel.calculatorDiseaseSectionSeven(viewModel.getAstasiaRatio()),
                                    viewModel.calculatorDiseaseSectionEight(viewModel.getFallDeadRatio())
                            )
                    );
                    viewModel.setDiseaseScore(diseaseScore);
                    disease_score.setText(String.valueOf(diseaseScore));
                }
            }
        });
        astasia_a1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(TextUtils.isEmpty(astasia_a1.getText().toString())){
                    astasia_ratio_1.setText("값을 입력하세요");
                    disease_score.setText("문항을 완료하세요");
                    viewModel.setAstasiaRatio(-1);
                }else if(Integer.parseInt(astasia_a1.getText().toString()) > Integer.parseInt(astasia_count_a1.getText().toString())){
                    viewModel.setAstasiaRatio(-1);
                    astasia_ratio_1.setText("2번 문항은 1번 문항보다 클 수 없습니다");
                    disease_score.setText("문항을 완료하세요");
                }else if(Integer.parseInt(astasia_a1.getText().toString()) > viewModel2.getTotalCowSize()) {
                    viewModel.setAstasiaRatio(-1);
                    astasia_ratio_1.setText("전체 두수보다 큰 값 입력 불가");
                }else if(viewModel2.getCoughRatio() == -1){ //영역2
                    disease_score.setText("기침 평가를 완료하세요");
                }else if(viewModel.getRunnyNoseRatio() == -1){ //영역1
                    disease_score.setText("비강분비물 평가를 완료하세요");
                }else if(viewModel.getOphthalmicRatio() == -1){ //영역1
                    disease_score.setText("안구분비물 평가를 완료하세요");
                }else if(viewModel.getRespiratoryRatio() == -1){ //영역2
                    disease_score.setText("호흡 장애 평가를 완료하세요");
                }else if(viewModel.getDiarrheaRatio() == -1){ //영역3
                    disease_score.setText("설사 평가를 완료하세요");
                }else if(viewModel.getOutGenitalsRatio() == -1){ //영역5
                    disease_score.setText("외음부 분비물 평가를 완료하세요");
                }else if(viewModel.getBreastRatio() == -1){ //영역4
                    disease_score.setText("우유내 체세포 평가를 완료하세요");
                }else if(viewModel.getFallDeadRatio() == -1){ //영역8
                    disease_score.setText("폐사율 평가를 완료하세요");
                }else if(viewModel.getDystociaRatio() == -1) { //영역6
                    disease_score.setText("난산 평가를 완료하세요");
                }else if(TextUtils.isEmpty(astasia_count_a1.getText().toString())){
                    astasia_ratio_1.setText("값을 입력하세요");
                    disease_score.setText("문항을 완료하세요");
                    viewModel.setAstasiaRatio(-1);
                }else {
                    float ratio = Float.parseFloat(astasia_a1.getText().toString()) / Float.parseFloat(astasia_count_a1.getText().toString());
                    ratio = ratio * 100;
                    ratio = Math.round(ratio);
                    Log.d("ratio:", String.valueOf(ratio));
                    viewModel.setAstasiaRatio(ratio);
                    astasia_ratio_1.setText(String.valueOf(ratio));
                    double diseaseScore =
                    viewModel.calculatorDiseaseScore(
                            viewModel.calculatorCareWarningScore(
                                    viewModel.calculatorDiseaseSectionOne(viewModel.getRunnyNoseRatio(),viewModel.getOphthalmicRatio()),
                                    viewModel.calculatorDiseaseSectionTwo(viewModel2.getCoughRatio(),viewModel.getRespiratoryRatio()),
                                    viewModel.calculatorDiseaseSectionThree(viewModel.getDiarrheaRatio()),
                                    viewModel.calculatorDiseaseSectionFour(viewModel.getBreastRatio()),
                                    viewModel.calculatorDiseaseSectionFive(viewModel.getOutGenitalsRatio()),
                                    viewModel.calculatorDiseaseSectionSix(viewModel.getDystociaRatio()),
                                    viewModel.calculatorDiseaseSectionSeven(viewModel.getAstasiaRatio()),
                                    viewModel.calculatorDiseaseSectionEight(viewModel.getFallDeadRatio())
                            )
                    );
                    viewModel.setDiseaseScore(diseaseScore);
                    disease_score.setText(String.valueOf(diseaseScore));
                }
            }
        });
        return view;
    }
}