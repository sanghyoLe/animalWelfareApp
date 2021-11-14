package com.example.animal_project.Beef.ProtocolOne;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;

public class WaterTankNum extends Fragment {
    private View view;
    Integer waterTankNum = 0;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        QuestionTemplateViewModel viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);
        int farmType = viewModel.getFarmType();
        view = inflater.inflate(R.layout.fragment_breed_water_q1, container, false);
        RadioGroup breed_water_tank_num = (RadioGroup) view.findViewById(R.id.breed_water_tank_num);
        RadioGroup milkCowWaterTankForm = (RadioGroup) view.findViewById(R.id.milk_cow_water_tank_form);
        RadioGroup largeWaterTankNum = (RadioGroup) view.findViewById(R.id.large_drink_tank_rg);

        RadioButton individualTankBtnOne = (RadioButton) view.findViewById(R.id.breed_water_tank_num_1);
        RadioButton individualTankBtnTwo = (RadioButton) view.findViewById(R.id.breed_water_tank_num_2);
        RadioButton largeWaterTankBtnOne = (RadioButton) view.findViewById(R.id.large_drink_tank_1);
        RadioButton largeWaterTankBtnTwo = (RadioButton) view.findViewById(R.id.large_drink_tank_2);
        LinearLayout milkCowWaterTankNumLayout = view.findViewById(R.id.milk_cow_water_tank_num_layout);
        LinearLayout individualWaterTankLayout = view.findViewById(R.id.individual_drink_layout);
        LinearLayout largeWaterTankLayout = view.findViewById(R.id.large_drink_layout);

        if(viewModel.isBeef(farmType)){
            individualWaterTankLayout.setVisibility(View.VISIBLE);
        } else {
            milkCowWaterTankNumLayout.setVisibility(View.VISIBLE);
        }
        milkCowWaterTankForm.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if(checkedId == R.id.milk_cow_water_tank_form_1){
                    individualWaterTankLayout.setVisibility(View.VISIBLE);
                    largeWaterTankLayout.setVisibility(View.GONE);
                    viewModel.setWaterTankForm("개별 급수기");
                    largeWaterTankBtnOne.setChecked(false);
                    largeWaterTankBtnTwo.setChecked(false);
                    ((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedWaterTankNum).setSelectedItem(-1);

                } else if(checkedId == R.id.milk_cow_water_tank_form_2){
                    largeWaterTankLayout.setVisibility(View.VISIBLE);
                    individualWaterTankLayout.setVisibility(View.GONE);
                    viewModel.setWaterTankForm("대형 급수기");
                    individualTankBtnOne.setChecked(false);
                    individualTankBtnTwo.setChecked(false);

                    waterTankNum = -1;
                    ((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedWaterTankNum).setSelectedItem(-1);
                }
                viewModel.setProtocolOneScore(
                        viewModel.calculatorProtocolOneResult(viewModel.getFarmType(),
                                viewModel.getPoorScore(),
                                viewModel.getWaterScore()
                        )
                );
            }

        });

        largeWaterTankNum.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.large_drink_tank_1) {
                    waterTankNum = 1;
                } else if (checkedId == R.id.large_drink_tank_2) {
                    waterTankNum = 2;
                }
                ((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedWaterTankNum).setSelectedItem(waterTankNum);
                int selectItem = ((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedWaterTankNum).getSelectedItem();
                ((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedWaterTankNum).setAnswer(largeWaterTankNum,selectItem);
                int waterScore = viewModel.calculatorWaterScore(
                        ((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedWaterTankNum).getSelectedItem(),
                        ((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedWaterTankClean).getSelectedItem(),
                        viewModel.getWaterTimeQuestion().getMaxWaterTimeScore());
                viewModel.setWaterScore(waterScore);

                viewModel.setProtocolOneScore(
                        viewModel.calculatorProtocolOneResult(viewModel.getFarmType(),
                                viewModel.getPoorScore(),
                                viewModel.getWaterScore()
                        )
                );

            }
        });
        breed_water_tank_num.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.breed_water_tank_num_1) {
                    waterTankNum = 1;
                } else if (checkedId == R.id.breed_water_tank_num_2) {
                    waterTankNum = 2;
                }
                ((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedWaterTankNum).setSelectedItem(waterTankNum);
                int selectItem = ((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedWaterTankNum).getSelectedItem();
                ((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedWaterTankNum).setAnswer(breed_water_tank_num,selectItem);
                int waterScore = viewModel.calculatorWaterScore(
                        ((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedWaterTankNum).getSelectedItem(),
                        ((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedWaterTankClean).getSelectedItem(),
                        viewModel.getWaterTimeQuestion().getMaxWaterTimeScore());
                viewModel.setWaterScore(waterScore);



            }
        });


      return view;



    }

}