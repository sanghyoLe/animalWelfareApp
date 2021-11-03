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

import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;


public class UnableStand extends Fragment {
    private View view;
    private QuestionTemplateViewModel viewModel;
    private MilkCowScoreCalculator mc;
    private TextView disease_score;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_unable_stand, container, false);
        viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);
        mc = new MilkCowScoreCalculator();
        EditText astasia_count_a1 = (EditText) view.findViewById(R.id.astasia_count_a1);
        EditText astasia_a1 = (EditText) view.findViewById(R.id.astasia_a1);
        TextView astasia_ratio_1 = (TextView) view.findViewById(R.id.astasia_ratio_1);
        disease_score = (TextView) view.findViewById(R.id.freestall_disease_score);

        astasia_count_a1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(TextUtils.isEmpty(astasia_count_a1.getText().toString()) || TextUtils.isEmpty(astasia_a1.getText().toString())){
                    astasia_ratio_1.setText("값을 입력하세요");
                    disease_score.setText("문항을 완료하세요");
                    ((QuestionTemplateViewModel.YearAvgQuestion)viewModel.UnableStand).setRatio(-1);
                    ((QuestionTemplateViewModel.YearAvgQuestion)viewModel.UnableStand).setScore(-1);
                    ((QuestionTemplateViewModel.YearAvgQuestion)viewModel.UnableStand).setYearAvgCount(-1);
                }else if(Integer.parseInt(astasia_a1.getText().toString()) > Integer.parseInt(astasia_count_a1.getText().toString())){
                    ((QuestionTemplateViewModel.YearAvgQuestion)viewModel.UnableStand).setRatio(-1);
                    ((QuestionTemplateViewModel.YearAvgQuestion)viewModel.UnableStand).setScore(-1);
                    ((QuestionTemplateViewModel.YearAvgQuestion)viewModel.UnableStand).setYearAvgCount(-1);
                    astasia_ratio_1.setText("2번 문항은 1번 문항보다 클 수 없습니다");
                    disease_score.setText("문항을 완료하세요");
                }else if(Integer.parseInt(astasia_count_a1.getText().toString()) > viewModel.getTotalCowSize()) {
                    ((QuestionTemplateViewModel.YearAvgQuestion)viewModel.UnableStand).setRatio(-1);
                    ((QuestionTemplateViewModel.YearAvgQuestion)viewModel.UnableStand).setScore(-1);
                    ((QuestionTemplateViewModel.YearAvgQuestion)viewModel.UnableStand).setYearAvgCount(-1);
                    astasia_ratio_1.setText("전체 두수보다 큰 값 입력 불가");
                }else {
                    float ratio = Float.parseFloat(astasia_a1.getText().toString()) / Float.parseFloat(astasia_count_a1.getText().toString());
                    ratio = ratio * 100;
                    ratio = (float) viewModel.cutDecimal(ratio);
                    ((QuestionTemplateViewModel.YearAvgQuestion)viewModel.UnableStand).setRatio(ratio);
                    ((QuestionTemplateViewModel.YearAvgQuestion)viewModel.UnableStand).setScore(-1);
                    ((QuestionTemplateViewModel.YearAvgQuestion)viewModel.UnableStand).setYearAvgCount(Integer.parseInt(astasia_count_a1.getText().toString()));
                    ((QuestionTemplateViewModel.YearAvgQuestion)viewModel.UnableStand).setNumberOfCow(Integer.parseInt(String.valueOf(astasia_a1.getText())));
                    astasia_ratio_1.setText(String.valueOf(ratio));

                    calculatorMilkCowDiseaseSection();
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
                if(TextUtils.isEmpty(astasia_a1.getText().toString())  ||  TextUtils.isEmpty(astasia_count_a1.getText().toString()) ){
                    astasia_ratio_1.setText("값을 입력하세요");
                    disease_score.setText("문항을 완료하세요");
                    ((QuestionTemplateViewModel.YearAvgQuestion)viewModel.UnableStand).setRatio(-1);
                    ((QuestionTemplateViewModel.YearAvgQuestion)viewModel.UnableStand).setScore(-1);
                    ((QuestionTemplateViewModel.YearAvgQuestion)viewModel.UnableStand).setNumberOfCow(-1);
                }else if(Integer.parseInt(astasia_a1.getText().toString()) > Integer.parseInt(astasia_count_a1.getText().toString())){
                    ((QuestionTemplateViewModel.YearAvgQuestion)viewModel.UnableStand).setRatio(-1);
                    ((QuestionTemplateViewModel.YearAvgQuestion)viewModel.UnableStand).setScore(-1);
                    ((QuestionTemplateViewModel.YearAvgQuestion)viewModel.UnableStand).setNumberOfCow(-1);
                    astasia_ratio_1.setText("2번 문항은 1번 문항보다 클 수 없습니다");
                    disease_score.setText("문항을 완료하세요");
                }else if(Integer.parseInt(astasia_a1.getText().toString()) > viewModel.getTotalCowSize()) {
                    ((QuestionTemplateViewModel.YearAvgQuestion)viewModel.UnableStand).setRatio(-1);
                    ((QuestionTemplateViewModel.YearAvgQuestion)viewModel.UnableStand).setScore(-1);
                    ((QuestionTemplateViewModel.YearAvgQuestion)viewModel.UnableStand).setNumberOfCow(-1);
                    astasia_ratio_1.setText("전체 두수보다 큰 값 입력 불가");
                } else {
                    float ratio = Float.parseFloat(astasia_a1.getText().toString()) / Float.parseFloat(astasia_count_a1.getText().toString());
                    ratio = ratio * 100;
                    ratio = Math.round(ratio);
                    ((QuestionTemplateViewModel.YearAvgQuestion)viewModel.UnableStand).setRatio(ratio);
                    ((QuestionTemplateViewModel.YearAvgQuestion)viewModel.UnableStand).setScore(-1);
                    ((QuestionTemplateViewModel.YearAvgQuestion)viewModel.UnableStand).setNumberOfCow(Integer.parseInt(String.valueOf(astasia_a1.getText())));
                    ((QuestionTemplateViewModel.YearAvgQuestion)viewModel.UnableStand).setYearAvgCount(Integer.parseInt(astasia_count_a1.getText().toString()));
                    astasia_ratio_1.setText(String.valueOf(ratio));

                    calculatorMilkCowDiseaseSection();
                }


            }

        });
        return view;
    }
    public void calculatorMilkCowDiseaseSection(){
        if(((QuestionTemplateViewModel.CoughQuestion)viewModel.CoughQuestion).getCoughPerOneAvg()== -1){ //영역2
            disease_score.setText("기침 평가를 완료하세요");
        }else if(((QuestionTemplateViewModel.PenQuestion)viewModel.BreedRunnyNose).getRatio() == -1){ //영역1
            disease_score.setText("비강분비물 평가를 완료하세요");
        }else if(((QuestionTemplateViewModel.PenQuestion)viewModel.BreedOphthalmic).getRatio() == -1){ //영역1
            disease_score.setText("안구분비물 평가를 완료하세요");
        }else if(((QuestionTemplateViewModel.PenQuestion)viewModel.BreedBreath).getRatio() == -1){ //영역2
            disease_score.setText("호흡 장애 평가를 완료하세요");
        }else if(((QuestionTemplateViewModel.PenQuestion)viewModel.BreedDiarrhea).getRatio() == -1){ //영역3
            disease_score.setText("설사 평가를 완료하세요");
        }else if(((QuestionTemplateViewModel.PenQuestion)viewModel.OutGenitals).getRatio() == -1){ //영역5
            disease_score.setText("외음부 분비물 평가를 완료하세요");
        }else if(((QuestionTemplateViewModel.PenQuestion)viewModel.MilkInCell).getRatio() == -1){ //영역4
            disease_score.setText("우유내 체세포 평가를 완료하세요");
        }else if(((QuestionTemplateViewModel.PenQuestion)viewModel.BreedFallDead).getRatio() == -1){ //영역8
            disease_score.setText("폐사율 평가를 완료하세요");
        }else if(((QuestionTemplateViewModel.YearAvgQuestion)viewModel.HardBirth).getRatio() == -1) { //영역6
            disease_score.setText("난산 평가를 완료하세요");
        } else if(((QuestionTemplateViewModel.YearAvgQuestion)viewModel.UnableStand).getRatio() == -1){
            disease_score.setText("기립불능 평가를 완료하세요");
        }else {
            double diseaseScore =
                    mc.calculatorDiseaseScore(
                            mc.calculatorCareWarningScore(
                                    mc.calculatorDiseaseSectionOne(
                                            ((QuestionTemplateViewModel.PenQuestion)viewModel.BreedRunnyNose).getRatio(),
                                            ((QuestionTemplateViewModel.PenQuestion)viewModel.BreedOphthalmic).getRatio()
                                    ),
                                    mc.calculatorDiseaseSectionTwo(
                                            ((QuestionTemplateViewModel.CoughQuestion)viewModel.CoughQuestion).getCoughRatio(),
                                            ((QuestionTemplateViewModel.PenQuestion)viewModel.BreedBreath).getRatio()
                                    ),
                                    mc.calculatorDiseaseSectionThree(((QuestionTemplateViewModel.PenQuestion)viewModel.BreedDiarrhea).getRatio()),
                                    mc.calculatorDiseaseSectionFour(((QuestionTemplateViewModel.PenQuestion)viewModel.MilkInCell).getRatio()),
                                    mc.calculatorDiseaseSectionFive(((QuestionTemplateViewModel.PenQuestion)viewModel.OutGenitals).getRatio()),
                                    mc.calculatorDiseaseSectionSix(((QuestionTemplateViewModel.YearAvgQuestion)viewModel.HardBirth).getRatio()),
                                    mc.calculatorDiseaseSectionSeven(((QuestionTemplateViewModel.YearAvgQuestion)viewModel.UnableStand).getRatio()),
                                    mc.calculatorDiseaseSectionEight(((QuestionTemplateViewModel.PenQuestion)viewModel.BreedFallDead).getRatio())
                            )
                    );
            viewModel.setDiseaseScore(diseaseScore);
            disease_score.setText(String.valueOf(diseaseScore));
        }
    }
}