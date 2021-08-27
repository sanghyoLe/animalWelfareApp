package com.example.animal_project.BreedBatch.ProtocolTwo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;


public class CalfMistSpray extends Fragment {
    private View view;
    Integer mistSpray = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_calf_mist_spray, container, false);
        QuestionTemplateViewModel viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);
        TextView calfRestScoreTv = view.findViewById(R.id.calf_summer_rest_score);
        RadioGroup mistSprayRg = view.findViewById(R.id.calf_mist_spray_rg);


        mistSprayRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.calf_mist_spray_1)
                {
                    mistSpray = 1;
                } else if(checkedId == R.id.calf_mist_spray_2)
                {
                    mistSpray = 2;
                }
                ((QuestionTemplateViewModel.RadioQuestion)viewModel.CalfMistSpray).setSelectedItem(mistSpray);
                int selectedItem = ((QuestionTemplateViewModel.RadioQuestion)viewModel.CalfMistSpray).getSelectedItem();
                ((QuestionTemplateViewModel.RadioQuestion)viewModel.CalfMistSpray).setAnswer(mistSprayRg,selectedItem);


                if(((QuestionTemplateViewModel.RadioQuestion)viewModel.CalfShade).getSelectedItem() == -1){
                    calfRestScoreTv.setText("11번 문항을 완료해주세요");
                } else if(((QuestionTemplateViewModel.RadioQuestion)viewModel.CalfSummerVentilating).getSelectedItem() == -1){
                    calfRestScoreTv.setText("12번 문항을 완료해주세요");
                } else {
                    int summerRestScore = viewModel.calculatorBreedSummerRestScore(
                            ((QuestionTemplateViewModel.RadioQuestion)viewModel.CalfShade).getSelectedItem(),
                            ((QuestionTemplateViewModel.RadioQuestion)viewModel.CalfSummerVentilating).getSelectedItem(),
                            ((QuestionTemplateViewModel.RadioQuestion)viewModel.CalfMistSpray).getSelectedItem()
                    );
                    viewModel.setCalfSummerRestScore(summerRestScore);
                    calfRestScoreTv.setText(String.valueOf(summerRestScore));
                }

            }
        });
        return view;
    }
}