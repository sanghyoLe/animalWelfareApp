package com.example.animal_project.Result;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;

import org.w3c.dom.Text;


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


        LinearLayout beefRestLayout = view.findViewById(R.id.beef_rest_layout);
        protocolScoreTv.setText(String.valueOf(viewModel.getProtocolTwoScore()));
        protocolRestScoreTv.setText(String.valueOf(viewModel.getRestScore()));

        LinearLayout calfSummerWinterLayout = view.findViewById(R.id.calf_summer_winter_layout);
        if(viewModel.isBeef(viewModel.getFarmType())){
            beefRestLayout.setVisibility(View.VISIBLE);
            strawScoreTv.setText(String.valueOf(viewModel.getStrawScore()));
            outwardScoreTv.setText(String.valueOf(viewModel.getOutWardScore()));
        }else {

        }
        protocolWarmVentilatingScoreTv.setText(String.valueOf(viewModel.getTotalWarmVentilatingScore()));
        summerScoreTv.setText(String.valueOf(viewModel.getSummerRestScore()));
        winterScoreTv.setText(String.valueOf(viewModel.getWinterRestScore()));

        if(viewModel.getFarmType() == 1){
            calfSummerWinterLayout.setVisibility(View.GONE);
        } else {
            calfSummerScoreTv.setText(String.valueOf(viewModel.getCalfSummerRestScore()));
            calfWinterScoreTv.setText(String.valueOf(viewModel.getCalfWinterRestScore()));
        }


        return view;
    }
}
