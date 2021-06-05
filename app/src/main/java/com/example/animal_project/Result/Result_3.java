package com.example.animal_project.Result;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.animal_project.R;
import com.example.animal_project.Result_View;

public class Result_3 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.result_3, container, false);

        TextView total_result_2 = view.findViewById(R.id.total_result_2);
        Result_View activity = (Result_View) getActivity();
        Bundle bundle = activity.getProtocolScoreBundle();
        double protocolTwoScore = bundle.getDouble("protocolTwoScore");
        total_result_2.setText(String.valueOf(protocolTwoScore));


        return view;
    }
}
