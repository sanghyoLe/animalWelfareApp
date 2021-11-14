package com.example.animal_project.Beef.ProtocolTwo;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;


public class BreedWinterVentilating extends Fragment {
    private View view;
    Integer winterVentilating = 0;
    private QuestionTemplateViewModel viewModel;
    private int farmType;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_breed_winter_ventilating, container, false);
        viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);
        Bundle bundle = getArguments();
        View fattenProtocolTwoView = view.findViewById(R.id.fatten_protocol_2);
        TextView totalWarmVenTv = fattenProtocolTwoView.findViewById(R.id.warm_ventilation_score);
        TextView protocolTwoTv = fattenProtocolTwoView.findViewById(R.id.breed_protocol_2);
        RadioGroup winterVentilatingRg = view.findViewById(R.id.breed_winter_ventilating_rg);
        TextView winterRestScoreTv = view.findViewById(R.id.breed_winter_rest_score);
        farmType = viewModel.getFarmType();
        if(viewModel.getWinterRestScore() != -1){
            winterRestScoreTv.setText(String.valueOf(
                    viewModel.getWinterRestScore()
            ));
        }
        if (farmType == 1) {
            fattenProtocolTwoView.setVisibility(View.VISIBLE);
            if(viewModel.getTotalWarmVentilatingScore() != -1){
                totalWarmVenTv.setText(String.valueOf(viewModel.getTotalWarmVentilatingScore()));
            }
        } else {
            fattenProtocolTwoView.setVisibility(View.INVISIBLE);
        }




        winterVentilatingRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.breed_winter_ventilating_1) {
                    winterVentilating = 1;
                } else if (checkedId == R.id.breed_winter_ventilating_2) {
                    winterVentilating = 2;
                }
                ((QuestionTemplateViewModel.RadioQuestion) viewModel.BreedWinterVentilating).setSelectedItem(winterVentilating);
                int selectedItem = ((QuestionTemplateViewModel.RadioQuestion) viewModel.BreedWinterVentilating).getSelectedItem();
                ((QuestionTemplateViewModel.RadioQuestion) viewModel.BreedWinterVentilating).setAnswer(winterVentilatingRg,selectedItem);




                    viewModel.setWinterRestScore( viewModel.calculatorBreedWinterRestScore(
                            ((QuestionTemplateViewModel.RadioQuestion) viewModel.BreedWindBlock).getSelectedItem(),
                            ((QuestionTemplateViewModel.RadioQuestion) viewModel.BreedWinterVentilating).getSelectedItem()
                        )
                    );
                    winterRestScoreTv.setText(String.valueOf(viewModel.getWinterRestScore()));

                if (farmType == 1) {
                        double totalWarmVenScore = viewModel.getSummerRestScore() * 0.7 + viewModel.getWinterRestScore() * 0.3;
                        viewModel.setTotalWarmVentilatingScore(totalWarmVenScore);
                        viewModel.setProtocolTwoScore(
                                viewModel.calculatorProtocolTwoScore(
                                        viewModel.getRestScore(),
                                        viewModel.getTotalWarmVentilatingScore()
                                )
                        );


                        totalWarmVenTv.setText(String.valueOf(viewModel.getTotalWarmVentilatingScore()));
                        protocolTwoTv.setText(String.valueOf(viewModel.getProtocolTwoScore()));

                }

            }
        });
        return view;
    }
}