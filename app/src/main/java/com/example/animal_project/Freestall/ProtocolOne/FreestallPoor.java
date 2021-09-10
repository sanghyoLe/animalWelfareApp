package com.example.animal_project.Freestall.ProtocolOne;


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

import com.example.animal_project.QuestionTemplate;
import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;


public class FreestallPoor extends Fragment {
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
                    // 총 두수 보다 입력한 값이 클 때
                } else if (total_cow_count < Integer.parseInt(ed_1_poorRate.getText().toString())) {
                    breed_poor_Rate_ratio.setText("총 두수보다 큰 값을 입력할 수 없습니다.");
                } else {
                    String total_cow = getPoorRateRatio(String.valueOf(total_cow_count), ed_1_poorRate.getText().toString());
                    breed_poor_Rate_ratio.setText(total_cow + "%");
                    breed_poor_rate_score = Integer.parseInt(getPoorRateScore(total_cow));
                    breed_poor_Rate_score.setText(String.valueOf(breed_poor_rate_score));
                    viewModel.setPoorScore(breed_poor_rate_score);
                    Log.d("점수:", String.valueOf(breed_poor_rate_score));
                }
            }});
        // Inflate the layout for this fragment
        return view;
    }
    //표본 마릿 수 계산
    public String getPoorRateRatio(String total, String rate) {
        Float totalFloat = Float.parseFloat(total);
        Float rateFloat = Float.parseFloat(rate);
        double result = ((rateFloat / totalFloat) * 100);
        return String.format("%.2f", result);
    }

    //여윈 개체 비율 계산
    public String getPoorRateScore(String ratio) {
        Float RatioFloat = Float.parseFloat(ratio);
        int poorScore = 0;
        if (RatioFloat == 0) {
            poorScore = 100;
        } else if (RatioFloat <= 3) {
            poorScore = 90;
        } else if (RatioFloat <= 6) {
            poorScore = 80;
        } else if (RatioFloat <= 8) {
            poorScore = 70;
        } else if (RatioFloat <= 10) {
            poorScore = 60;
        } else if (RatioFloat <= 13) {
            poorScore = 50;
        } else if (RatioFloat <= 16) {
            poorScore = 40;
        } else if (RatioFloat <= 20) {
            poorScore = 30;
        } else if (RatioFloat <= 26) {
            poorScore = 20;
        } else if (RatioFloat <= 44) {
            poorScore = 10;
        } else poorScore = 0;

        return Integer.toString(poorScore);
    }
}