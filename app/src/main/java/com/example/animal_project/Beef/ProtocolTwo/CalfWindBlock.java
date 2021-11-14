package com.example.animal_project.Beef.ProtocolTwo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;


public class CalfWindBlock extends Fragment {
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
        TextView protocolTwoTv = view.findViewById(R.id.breed_protocol_2);
        LinearLayout breedProtocolTwoLayout = view.findViewById(R.id.breed_protocol_two_score_layout);

        if(viewModel.getCalfWinterRestScore() != -1){
            calfWinterRestScoreTv.setText(
                    String.valueOf(
                            viewModel.getCalfWinterRestScore()
                    )
            );
        }
        if(viewModel.getTotalWarmVentilatingScore() != -1){
            totalWarmVenTv.setText(
                    String.valueOf(
                            viewModel.getTotalWarmVentilatingScore()
                    )
            );
        }

        if(!viewModel.isBeef(viewModel.getFarmType())){
            breedProtocolTwoLayout.setVisibility(View.GONE);
        } else {
            if(viewModel.getProtocolTwoScore() != -1){
                protocolTwoTv.setText(
                        String.valueOf(
                                viewModel.getProtocolTwoScore()
                        )
                );
            }
        }
        calfWindBlockRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.calf_wind_block_1){
                    calfWindBlock = 1;
                }else if(checkedId == R.id.calf_wind_block_2){
                    calfWindBlock = 2;
                }
                ((QuestionTemplateViewModel.RadioQuestion)viewModel.CalfWindBlock).setSelectedItem(calfWindBlock);
                int selectedItem = ((QuestionTemplateViewModel.RadioQuestion)viewModel.CalfWindBlock).getSelectedItem();
                ((QuestionTemplateViewModel.RadioQuestion)viewModel.CalfWindBlock).setAnswer(calfWindBlockRg,selectedItem);



                    viewModel.setCalfWinterRestScore(
                            viewModel.calculatorCalfWinterRestScore(
                            ((QuestionTemplateViewModel.RadioQuestion)viewModel.CalfStraw).getSelectedItem(),
                            ((QuestionTemplateViewModel.RadioQuestion)viewModel.CalfWarm).getSelectedItem(),
                            ((QuestionTemplateViewModel.RadioQuestion)viewModel.CalfWindBlock).getSelectedItem()
                        )
                    );

                    calfWinterRestScoreTv.setText(
                            String.valueOf(
                                    viewModel.getCalfWinterRestScore()
                            )
                    );




                        viewModel.setTotalWarmVentilatingScore(
                                viewModel.calculatorTotalWarmVentilationScore(
                                        viewModel.getFarmType(),
                                        viewModel.getSummerRestScore(),
                                        viewModel.getWinterRestScore(),
                                        viewModel.getCalfSummerRestScore(),
                                        viewModel.getCalfWinterRestScore()
                                )
                        );

                        totalWarmVenTv.setText(
                                String.valueOf(
                                        viewModel.getTotalWarmVentilatingScore()
                                )
                        );

                        if(viewModel.isBeef(viewModel.getFarmType())){
                                viewModel.setProtocolTwoScore(
                                        viewModel.calculatorProtocolTwoScore(
                                                viewModel.getRestScore(),
                                                viewModel.getTotalWarmVentilatingScore()
                                        )
                                );
                                protocolTwoTv.setText(String.valueOf(viewModel.getProtocolTwoScore()));

                        }




            }
        });
        return view;
    }
}