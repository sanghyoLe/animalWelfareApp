package com.example.animal_project.BreedBatch.ProtocolTwo;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;

public class BreedOutward extends Fragment {
    private View view;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        QuestionTemplateViewModel viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);
        view = inflater.inflate(R.layout.fragment_breed_outward, container, false);

        EditText breed_outward_ed = view.findViewById(R.id.breed_outward_ed);
        EditText penLocationOne = view.findViewById(R.id.pen_location_ed_1);
        EditText penLocationTwo = view.findViewById(R.id.pen_location_ed_2);
        TextView breed_outward_ratio = view.findViewById(R.id.breed_outward_ratio);
        TextView breed_outward_score = view.findViewById(R.id.breed_outward_score);

        breed_outward_ed.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void afterTextChanged(Editable editable) {
                if(viewModel.checkNumberOfCow(breed_outward_ed) == -1){
                    breed_outward_ratio.setText("값을 입력해주세요");
                    breed_outward_score.setText("값을 입력해주세요");
                } else {
                    TextView breed_rest_score = view.findViewById(R.id.breed_rest_score);
                    float ratio = Float.parseFloat(breed_outward_ed.getText().toString()) / viewModel.getSampleCowSize() ;
                    ratio = ratio * 100;
                    ratio = (float)viewModel.cutDecimal(ratio);
                    if( ratio > 100){
                        breed_outward_ratio.setText("표본 규모보다 큰 값을 입력 하셨습니다.");
                    }else {
                        breed_outward_ratio.setText(String.valueOf(ratio));
                    }
                    QuestionTemplateViewModel.PenQuestion BreedOutward = new QuestionTemplateViewModel.PenQuestion(
                            viewModel.makePenLocation(penLocationOne,penLocationTwo),
                            viewModel.makeNumberOfCow(breed_outward_ed),
                            viewModel.calculatorBreedOutwardScore(ratio),
                            ratio
                    );
                    viewModel.BreedOutward = BreedOutward;
                    breed_outward_score.setText(String.valueOf(((QuestionTemplateViewModel.PenQuestion) viewModel.BreedOutward).getScore()));
                    // 편안한 휴식 종합 점수
                    viewModel.setRestScore(viewModel.calculatorBreedRestScore(viewModel.getStrawScore(), (int) ((QuestionTemplateViewModel.PenQuestion) viewModel.BreedOutward).getScore()));
                    breed_rest_score.setText(String.valueOf(viewModel.getRestScore()));
                }
            }
        });

        return view;
    }

}