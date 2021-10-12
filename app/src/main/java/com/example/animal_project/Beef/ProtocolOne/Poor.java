package com.example.animal_project.Beef.ProtocolOne;


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


public class Poor extends Fragment {
    int breed_poor_rate_score = 0;
    private EditText ed_1_poorRate;
    private QuestionTemplateViewModel viewModel;
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);
        view = inflater.inflate(R.layout.fragment_poor, container, false);
        int farmType = viewModel.getFarmType();


        ed_1_poorRate = (EditText) view.findViewById(R.id.breed_batch_poor_Rate_a1); //1번 문항
        TextView breed_poor_Rate_ratio = (TextView) view.findViewById(R.id.breed_poor_Rate_ratio);
        TextView breed_poor_Rate_score = (TextView) view.findViewById(R.id.breed_poor_Rate_score);



        QuestionTemplate activity = (QuestionTemplate) getActivity();
        int total_cow_count = viewModel.getTotalCowSize();


        ed_1_poorRate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                if (TextUtils.isEmpty(ed_1_poorRate.getText().toString())) {
                    breed_poor_Rate_ratio.setText("값을 입력해주세요");
                    ((QuestionTemplateViewModel.Question) viewModel.BreedPoor).setNumberOfCow(-1);
                    ((QuestionTemplateViewModel.Question) viewModel.BreedPoor).setScore(-1);
                    ((QuestionTemplateViewModel.Question) viewModel.BreedPoor).setRatio(-1);
                    breed_poor_Rate_score.setText("-1");
                    // 총 두수 보다 입력한 값이 클 때
                } else if (total_cow_count < Integer.parseInt(ed_1_poorRate.getText().toString())) {
                    breed_poor_Rate_ratio.setText("총 두수보다 큰 값을 입력할 수 없습니다.");
                    ((QuestionTemplateViewModel.Question) viewModel.BreedPoor).setNumberOfCow(-1);
                    ((QuestionTemplateViewModel.Question) viewModel.BreedPoor).setScore(-1);
                    ((QuestionTemplateViewModel.Question) viewModel.BreedPoor).setRatio(-1);
                    breed_poor_Rate_score.setText("-1");
                } else {

                    float ratio = getPoorRatio(farmType,String.valueOf(total_cow_count), ed_1_poorRate.getText().toString());
                    breed_poor_Rate_ratio.setText(ratio + "%");
                    breed_poor_rate_score = Integer.parseInt(getPoorRateScore(farmType,ratio));
                    breed_poor_Rate_score.setText(String.valueOf(breed_poor_rate_score));
                    viewModel.setPoorScore(breed_poor_rate_score);
                    ((QuestionTemplateViewModel.Question) viewModel.BreedPoor).setNumberOfCow(Integer.parseInt(ed_1_poorRate.getText().toString()));
                    ((QuestionTemplateViewModel.Question) viewModel.BreedPoor).setScore(breed_poor_rate_score);
                    ((QuestionTemplateViewModel.Question) viewModel.BreedPoor).setRatio(ratio);

                }
            }});
        // Inflate the layout for this fragment
        return view;
    }

    public String getPoorRateScore(int farmType , float ratio){
        int poorScore = 0;
        if(viewModel.isBeef(farmType)){
            if (ratio == 0) {
                poorScore = 100;
            } else if (ratio < 1) {
                poorScore = 90;
            } else if (ratio < 2) {
                poorScore = 80;
            } else if (ratio < 3) {
                poorScore = 70;
            } else if (ratio < 4) {
                poorScore = 60;
            } else if (ratio < 5) {
                poorScore = 50;
            } else if (ratio < 6) {
                poorScore = 40;
            } else if (ratio <= 7) {
                poorScore = 30;
            } else if (ratio <= 9) {
                poorScore = 20;
            } else if (ratio < 11) {
                poorScore = 10;
            } else  poorScore = 0;
        } else {
            if (ratio == 0) {
                poorScore = 100;
            } else if (ratio <= 3) {
                poorScore = 90;
            } else if (ratio <= 6) {
                poorScore = 80;
            } else if (ratio <= 8) {
                poorScore = 70;
            } else if (ratio <= 10) {
                poorScore = 60;
            } else if (ratio <= 13) {
                poorScore = 50;
            } else if (ratio <= 16) {
                poorScore = 40;
            } else if (ratio <= 20) {
                poorScore = 30;
            } else if (ratio <= 26) {
                poorScore = 20;
            } else if (ratio <= 44) {
                poorScore = 10;
            } else poorScore = 0;
        }
        return Integer.toString(poorScore);
    }
    public float getPoorRatio(int farmType, String total, String rate){
        Float totalFloat = Float.parseFloat(total);
        Float rateFloat = Float.parseFloat(rate);
        float ratio = (rateFloat / totalFloat) * 100;
        if(viewModel.isBeef(farmType)){
            if(ratio >= 1){
                ratio = Math.round(ratio);
            }
        }
        return ratio;
    }
    

}