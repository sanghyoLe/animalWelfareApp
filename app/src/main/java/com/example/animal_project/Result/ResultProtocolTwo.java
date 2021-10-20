package com.example.animal_project.Result;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;


public class ResultProtocolTwo extends Fragment {
    QuestionTemplateViewModel viewModel;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.result_2, container, false);
        viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);
        TextView protocolScoreTv = view.findViewById(R.id.protocol_score_tv);
        TextView protocolRestScoreTv = view.findViewById(R.id.protocol_rest_score_tv);
        TextView strawScoreTv = view.findViewById(R.id.straw_score_tv);
        TextView outwardScoreTv = view.findViewById(R.id.outward_score_tv);

        TextView protocolWarmVentilatingScoreTv = view.findViewById(R.id.protocol_warm_ventilating_score_tv);
        TextView summerScoreTv = view.findViewById(R.id.summer_score_tv);
        TextView winterScoreTv = view.findViewById(R.id.winter_score_tv);
        TextView calfSummerScoreTv = view.findViewById(R.id.calf_summer_score_tv);
        TextView calfWinterScoreTv = view.findViewById(R.id.calf_winter_score_tv);
        LinearLayout calfSummerWinterLayout = view.findViewById(R.id.calf_summer_winter_layout);




        LinearLayout beefRestLayout = view.findViewById(R.id.beef_rest_layout);
        LinearLayout milkCowRestLayout = view.findViewById(R.id.milk_cow_rest_layout);
        LinearLayout freeStallRestLayout = view.findViewById(R.id.free_stall_rest_layout);
        TextView freeStallCountScoreTv = view.findViewById(R.id.free_stall_count_score_tv);
        TextView sitCollisionScoreTv = view.findViewById(R.id.sit_collision_score_tv);
        TextView areaOutSitCollisionScoreTv = view.findViewById(R.id.area_out_collision_score_tv);
        TextView sitTimeScoreTv = view.findViewById(R.id.sit_time_score_tv);
        TextView outwardBackRegScoreTv = view.findViewById(R.id.outward_back_reg_score_tv);
        TextView outwardBackScoreTv = view.findViewById(R.id.outward_back_reg_score_tv);
        TextView outwardBreastScoreTv = view.findViewById(R.id.outward_breast_score_tv);


        protocolScoreTv.setText(String.valueOf((int)viewModel.getProtocolTwoScore()));
        protocolRestScoreTv.setText(String.valueOf((int)viewModel.getRestScore()));
        protocolWarmVentilatingScoreTv.setText(String.valueOf((int)viewModel.getTotalWarmVentilatingScore()));
        summerScoreTv.setText(String.valueOf(viewModel.getSummerRestScore()));
        winterScoreTv.setText(String.valueOf(viewModel.getWinterRestScore()));

        if(viewModel.isBeef(viewModel.getFarmType())){
            beefRestLayout.setVisibility(View.VISIBLE);
            strawScoreTv.setText(String.valueOf((int)viewModel.getStrawScore()));
            outwardScoreTv.setText(String.valueOf(viewModel.getOutWardScore()));
        }else {
            milkCowRestLayout.setVisibility(View.VISIBLE);
            sitTimeScoreTv.setText(String.valueOf((int)((QuestionTemplateViewModel.SitTimeQuestion)viewModel.SitTimeQuestion).getScore()));
            int outwardBackRegScore = (int)((QuestionTemplateViewModel.Question)viewModel.OutwardBackReg).getScore();
            int outwardBackScore = (int)((QuestionTemplateViewModel.Question)viewModel.OutwardBack).getScore();
            int outwardBreastScore = (int)((QuestionTemplateViewModel.Question)viewModel.OutwardBreast).getScore();

            outwardBackRegScoreTv.setText(String.valueOf(outwardBackRegScore));
            outwardBackScoreTv.setText(String.valueOf(outwardBackScore));
            outwardBreastScoreTv.setText(String.valueOf(outwardBreastScore));

            if(viewModel.getFarmType() == 5) {
                freeStallRestLayout.setVisibility(View.VISIBLE);
                int freeStallCountScore = ((QuestionTemplateViewModel.FreeStallCountQuestion)viewModel.FreeStallCountQuestion).getLowestScore();
                int sitCollisionScore = (int)((QuestionTemplateViewModel.SitCollisionQuestion)viewModel.SitCollision).getScore();
                int areaOutSitCollisionScore = (int)((QuestionTemplateViewModel.FreeStallAreaOutCollision)viewModel.FreeStallAreaOutCollision).getScore();
                freeStallCountScoreTv.setText(String.valueOf(freeStallCountScore));
                sitCollisionScoreTv.setText(String.valueOf(sitCollisionScore));
                areaOutSitCollisionScoreTv.setText(String.valueOf(areaOutSitCollisionScore));
            }
        }


        if(viewModel.getFarmType() == 1){
            calfSummerWinterLayout.setVisibility(View.GONE);
        } else {
            calfSummerScoreTv.setText(String.valueOf(viewModel.getCalfSummerRestScore()));
            calfWinterScoreTv.setText(String.valueOf(viewModel.getCalfWinterRestScore()));
        }


        return view;
    }
}
