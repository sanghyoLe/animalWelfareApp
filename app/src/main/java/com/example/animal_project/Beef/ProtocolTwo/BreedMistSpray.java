package com.example.animal_project.Beef.ProtocolTwo;

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


public class BreedMistSpray extends Fragment {
    private View view;
    Integer mistSpray = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_breed_mist_spray, container, false);
        QuestionTemplateViewModel viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);
        TextView breedRestScoreTv = view.findViewById(R.id.breed_summer_rest_score);
        RadioGroup mistSprayRg = view.findViewById(R.id.breed_mist_spray_rg);



        mistSprayRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.breed_mist_spray_1)
                {
                    mistSpray = 1;
                } else if(checkedId == R.id.breed_mist_spray_2)
                {
                    mistSpray = 2;
                }
                ((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedMistSpray).setSelectedItem(mistSpray);
                int selectedItem = ((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedMistSpray).getSelectedItem();

                ((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedMistSpray).setAnswer(mistSprayRg,selectedItem);


                if(((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedShade).getSelectedItem() == -1){
                    breedRestScoreTv.setText("7번 문항을 완료해주세요");
                } else if(((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedSummerVentilating).getSelectedItem() == -1){
                    breedRestScoreTv.setText("8번 문항을 완료해주세요");
                } else {
                    int summerRestScore = viewModel.calculatorBreedSummerRestScore(
                            ((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedShade).getSelectedItem(),
                            ((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedSummerVentilating).getSelectedItem(),
                            ((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedShade).getSelectedItem()
                );
                    viewModel.setSummerRestScore(summerRestScore);
                    breedRestScoreTv.setText(String.valueOf(summerRestScore));
                }

            }
        });






        return view;
    }
}