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
import androidx.lifecycle.ViewModelProvider;

import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;
import com.example.animal_project.Result_View;

public class Result_1 extends Fragment {
    private QuestionTemplateViewModel viewModel;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.result_1, container, false);
        viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);

        Log.d("four",String.valueOf(viewModel.getProtocolFourScore()));
        return view;
    }
}
