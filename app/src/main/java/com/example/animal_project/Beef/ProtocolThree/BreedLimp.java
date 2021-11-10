package com.example.animal_project.Beef.ProtocolThree;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.animal_project.CustomDialog;
import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;


public class BreedLimp extends Fragment {
  private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_breed_limp, container, false);
        QuestionTemplateViewModel viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);
        EditText breedLimpEd = view.findViewById(R.id.breed_limp_ed);
        TextView breedLimpScoreTV = view.findViewById(R.id.breed_limp_score);
        TextView breedLimpRatioTv = view.findViewById(R.id.breed_limp_ratio);

        LinearLayout limpScoreLayout = view.findViewById(R.id.limp_score_layout);
        if(!viewModel.isBeef(viewModel.getFarmType())){
            limpScoreLayout.setVisibility(View.GONE);
        }

        // 한육우가 아닐 경우 다리절음 기준 버튼 VISIBLE, 점수 Layout GONE


        breedLimpEd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (TextUtils.isEmpty(breedLimpEd.getText().toString())) {
                    breedLimpRatioTv.setText("값을 입력해주세요");
                    ((QuestionTemplateViewModel.Question) viewModel.BreedLimp).setScore(-1);
                    // 총 두수 보다 입력한 값이 클 때
                } else if (viewModel.getSampleCowSize() < Integer.parseInt(breedLimpEd.getText().toString())) {
                    breedLimpRatioTv.setText("총 두수보다 큰 값을 입력할 수 없습니다.");
                } else {
                    if(viewModel.isBeef(viewModel.getFarmType())){
                        int limpScore = 0;
                        float ratio = Float.parseFloat(breedLimpEd.getText().toString()) / viewModel.getSampleCowSize();
                        ratio = ratio * 100;
                        ratio = (float)viewModel.cutDecimal(ratio);
                        breedLimpRatioTv.setText(String.valueOf(ratio));
                        ((QuestionTemplateViewModel.Question) viewModel.BreedLimp).setNumberOfCow(viewModel.makeNumberOfCow(breedLimpEd));
                        ((QuestionTemplateViewModel.Question) viewModel.BreedLimp).setRatio(ratio);
                        limpScore = viewModel.calculatorLimpScore(ratio);
                        ((QuestionTemplateViewModel.Question) viewModel.BreedLimp).setScore(limpScore);
                        breedLimpScoreTV.setText(String.valueOf(limpScore));
                    } else {

                        float ratio = Float.parseFloat(breedLimpEd.getText().toString()) / viewModel.getSampleCowSize();
                        ratio = ratio * 100;
                        ratio = (float)viewModel.cutDecimal(ratio);
                        breedLimpRatioTv.setText(String.valueOf(ratio));
                        ((QuestionTemplateViewModel.Question) viewModel.BreedLimp).setNumberOfCow(viewModel.makeNumberOfCow(breedLimpEd));
                        ((QuestionTemplateViewModel.Question) viewModel.BreedLimp).setRatio(ratio);
                    }

                }
            }
        });
        return view;
    }
}