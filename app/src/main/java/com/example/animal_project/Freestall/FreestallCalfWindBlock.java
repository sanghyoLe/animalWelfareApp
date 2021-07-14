package com.example.animal_project.Freestall;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;


public class FreestallCalfWindBlock extends Fragment {
    private View view;
    Integer calfWindBlock = 0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_calf_wind_block, container, false);

        QuestionTemplateViewModel viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);
        RadioGroup calfWindBlockRg = view.findViewById(R.id.calf_wind_block_rg);
        TextView calfWinterRestScoreTv = view.findViewById(R.id.calf_winter_rest_score);
        TextView totalWarmVenTv = view.findViewById(R.id.warm_ventilation_score);
        calfWindBlockRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.calf_wind_block_1){
                    calfWindBlock = 1;
                }else if(checkedId == R.id.calf_wind_block_2){
                    calfWindBlock = 2;
                }
                viewModel.setCalfWindBlockScore(calfWindBlock);

                if(viewModel.getCalfStrawScore() == 0){
                    calfWinterRestScoreTv.setText("19번 문항을 완료해주세요");
                }else if(viewModel.getCalfWarmScore() == 0){
                    calfWinterRestScoreTv.setText("20번 문항을 완료해주세요");
                }else {
                    int calfWinterRestScore = viewModel.calculatorCalfWinterRestScore(
                            viewModel.getCalfStrawScore(),
                            viewModel.getCalfWarmScore(),
                            viewModel.getCalfWindBlockScore()
                    );
                    viewModel.setCalfWinterRestScore(calfWinterRestScore);
                    calfWinterRestScoreTv.setText(String.valueOf(calfWinterRestScore));
                }
                if(viewModel.getSummerRestScore() == 0){
                    totalWarmVenTv.setText("성우 혹서기 설문조사를 완료하세요");
                } else if(viewModel.getWinterRestScore() == 0 ){
                    totalWarmVenTv.setText("성우 혹한기 설문조사를 완료하세요");
                } else if(viewModel.getCalfSummerRestScore() == 0 ) {
                    totalWarmVenTv.setText("송아지 혹서기 설문조사를 완료하세요");
                } else if(viewModel.getCalfWinterRestScore() == 0) {
                    totalWarmVenTv.setText("송아지 혹한기 설문조사를 완료하세요");
                } else {
                    double totalWarmVen = viewModel.calculatorTotalWarmVentilationScore(
                            viewModel.getSummerRestScore(),
                            viewModel.getWinterRestScore(),
                            viewModel.getCalfSummerRestScore(),
                            viewModel.getCalfWinterRestScore()
                    );
                    viewModel.setTotalWarmVentilatingScore(totalWarmVen);
                    totalWarmVenTv.setText(String.valueOf(totalWarmVen));

                }
            }
        });
        return view;
    }
}