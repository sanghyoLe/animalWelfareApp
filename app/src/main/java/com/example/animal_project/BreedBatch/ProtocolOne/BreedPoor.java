package com.example.animal_project.BreedBatch.ProtocolOne;


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
import com.example.animal_project.QuestionTemplate;
import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;
import com.example.animal_project.Result_View;


public class BreedPoor extends Fragment {
    int breed_poor_rate_score = 0;
    private EditText ed_1_poorRate;
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        QuestionTemplateViewModel viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);
        view = inflater.inflate(R.layout.fragment_breed_poor, container, false);

        ed_1_poorRate = (EditText) view.findViewById(R.id.breed_batch_poor_Rate_a1); //1번 문항
        TextView breed_poor_Rate_ratio = (TextView) view.findViewById(R.id.breed_poor_Rate_ratio);
        TextView breed_poor_Rate_score = (TextView) view.findViewById(R.id.breed_poor_Rate_score);



        QuestionTemplate activity = (QuestionTemplate) getActivity();
        int total_cow_count = viewModel.getTotalCowSize();
        Log.d("total_cow_Count",String.valueOf(total_cow_count));

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
                    viewModel.setPoorScore(-1);
                    // 총 두수 보다 입력한 값이 클 때
                } else if (total_cow_count < Integer.parseInt(ed_1_poorRate.getText().toString())) {
                    breed_poor_Rate_ratio.setText("총 두수보다 큰 값을 입력할 수 없습니다.");
                } else {
                    String total_cow = breedPoorRateRatio(String.valueOf(total_cow_count), ed_1_poorRate.getText().toString());
                    breed_poor_Rate_ratio.setText(total_cow + "%");
                    breed_poor_rate_score = Integer.parseInt(breedPoorRateScore(total_cow));
                    breed_poor_Rate_score.setText(String.valueOf(breed_poor_rate_score));
                    viewModel.setPoorScore(breed_poor_rate_score);
                }
            }});
        // Inflate the layout for this fragment
        return view;
    }
    public String breedPoorRateScore(String ratio){
        Float RatioFloat = Float.parseFloat(ratio);
        int poorScore = 0;
        if (RatioFloat == 0) {
            poorScore = 100;
        } else if (RatioFloat < 1) {
            poorScore = 90;
        } else if (RatioFloat < 2) {
            poorScore = 80;
        } else if (RatioFloat < 3) {
            poorScore = 70;
        } else if (RatioFloat < 4) {
            poorScore = 60;
        } else if (RatioFloat < 5) {
            poorScore = 50;
        } else if (RatioFloat < 6) {
            poorScore = 40;
        } else if (RatioFloat <= 7) {
            poorScore = 30;
        } else if (RatioFloat <= 9) {
            poorScore = 20;
        } else if (RatioFloat < 11) {
            poorScore = 10;
        } else  poorScore = 0;

        return Integer.toString(poorScore);
    }
    public String breedPoorRateRatio(String total, String rate){
        Float totalFloat = Float.parseFloat(total);
        Float rateFloat = Float.parseFloat(rate);
        double result = (rateFloat / totalFloat) * 100;
        return String.format("%.2f",result);
    }
}