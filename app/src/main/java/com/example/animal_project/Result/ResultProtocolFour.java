package com.example.animal_project.Result;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;

public class ResultProtocolFour extends Fragment {
    QuestionTemplateViewModel viewModel;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.result_4, container, false);
        viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);
        View progressBarView = view.findViewById(R.id.result_progressbar_4);
        TextView progressBarTv = progressBarView.findViewById(R.id.progress_tv);
        ProgressBar progressBar = progressBarView.findViewById(R.id.circular_determinative_pb);
        viewModel.setProgressBar(viewModel.getProtocolFourScore(),progressBar,progressBarTv);

        return view;
    }
}
