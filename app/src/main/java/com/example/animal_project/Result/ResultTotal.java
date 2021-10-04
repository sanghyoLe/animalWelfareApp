package com.example.animal_project.Result;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;

public class ResultTotal extends Fragment {


    private QuestionTemplateViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.result_total, container, false);
        viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);


        ImageView totalScoreImageView = view.findViewById(R.id.total_score_image_view);
        TextView totalScoreTitleTv = view.findViewById(R.id.total_score_title_tv);
        TextView totalScoreExplainTv = view.findViewById(R.id.total_score_explain_tv);
        if(viewModel.getTotalProtocolScoreString().equals("Excellent")){
            totalScoreImageView.setImageResource(R.drawable.outline_sentiment_very_satisfied_24);
            totalScoreTitleTv.setText("우수");
            totalScoreTitleTv.setTextColor(Color.parseColor("#0000FF"));
            totalScoreExplainTv.setText(R.string.total_score_explain_excellent);
        }else if(viewModel.getTotalProtocolScoreString().equals("Enhanced")){
            totalScoreImageView.setImageResource(R.drawable.outline_sentiment_satisfied_alt_24);
            totalScoreTitleTv.setText("양호");
            totalScoreTitleTv.setTextColor(Color.parseColor("#32CD32"));
            totalScoreExplainTv.setText(R.string.total_score_explain_enhance);
        }else if(viewModel.getTotalProtocolScoreString().equals("Acceptable")){
            totalScoreImageView.setImageResource(R.drawable.outline_sentiment_dissatisfied_24);
            totalScoreTitleTv.setText("허용");
            totalScoreTitleTv.setTextColor(Color.parseColor("#D2691E"));
            totalScoreExplainTv.setText(R.string.total_score_explain_acceptable);
        } else {
            totalScoreImageView.setImageResource(R.drawable.outline_sick_24);
            totalScoreTitleTv.setText("분류불가");
            totalScoreTitleTv.setTextColor(Color.parseColor("#FF0000"));
            totalScoreExplainTv.setText(R.string.total_score_explain_not_classified);
        }
        return view;
    }

}
