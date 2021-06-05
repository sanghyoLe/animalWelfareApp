package com.example.animal_project.Result;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.animal_project.Farm_Activity.Breed_batch_4;
import com.example.animal_project.R;
import com.example.animal_project.Result_View;

public class Result_1 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.result_1, container, false);

        TextView total_result_1 = view.findViewById(R.id.total_result_1);
        TextView total_result_2 = view.findViewById(R.id.total_result_2);
        TextView total_result_3 = view.findViewById(R.id.total_result_3);
        TextView total_result_4 = view.findViewById(R.id.total_result_4);

        Result_View activity = (Result_View) getActivity();
        Bundle bundle = activity.getProtocolScoreBundle();
        double protocolOneScore = bundle.getDouble("protocolOneScore");
        double protocolTwoScore = bundle.getDouble("protocolTwoScore");
        double protocolThreeScore = bundle.getDouble("protocolThreeScore");
        double protocolFourScore = bundle.getDouble("protocolFourScore");
        total_result_1.setText(String.valueOf(protocolOneScore));
        total_result_2.setText(String.valueOf(protocolTwoScore));
        total_result_3.setText(String.valueOf(protocolThreeScore));
        total_result_4.setText(String.valueOf(protocolFourScore));


        return view;
    }
}
