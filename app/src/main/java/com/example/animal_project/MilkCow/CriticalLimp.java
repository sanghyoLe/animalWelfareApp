package com.example.animal_project.MilkCow;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.animal_project.CustomImageDialog;
import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;


public class CriticalLimp extends Fragment {
    private View view;
    private QuestionTemplateViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_critical_limp, container, false);
        viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);
        MilkCowScoreCalculator mc = new MilkCowScoreCalculator();
        EditText criticalEd = view.findViewById(R.id.critical_limp_ed);
        TextView criticalLimpRatioTv = view.findViewById(R.id.critical_limp_ratio);
        TextView totalRatioTv = view.findViewById(R.id.total_limp_ratio);
        TextView totalScoreTv = view.findViewById(R.id.total_limp_score);
        Button standard_btn = view.findViewById(R.id.standard_btn);
        standard_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomImageDialog customImageDialog = new CustomImageDialog(CriticalLimp.this.getContext());
                customImageDialog.setImage(R.drawable.milk_cow_critical_limp);

            }
        });



        criticalEd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (TextUtils.isEmpty(criticalEd.getText().toString())) {
                    criticalLimpRatioTv.setText("값을 입력해주세요");
                    ((QuestionTemplateViewModel.Question) viewModel.BreedLimp).setScore(-1);
                    // 총 두수 보다 입력한 값이 클 때
                } else if (viewModel.getSampleCowSize() < Integer.parseInt(criticalEd.getText().toString())) {
                    criticalLimpRatioTv.setText("총 두수보다 큰 값을 입력할 수 없습니다.");
                } else {
                        int limpScore = 0;
                        float criticalRatio = Float.parseFloat(criticalEd.getText().toString()) / viewModel.getSampleCowSize();
                        criticalRatio = criticalRatio * 100;
                        criticalRatio = (float)viewModel.cutDecimal(criticalRatio);
                        criticalLimpRatioTv.setText(String.valueOf(criticalRatio));
                        ((QuestionTemplateViewModel.Question) viewModel.CriticalLimp).setNumberOfCow(viewModel.makeNumberOfCow(criticalEd));
                        ((QuestionTemplateViewModel.Question) viewModel.CriticalLimp).setRatio(criticalRatio);
                        float totalRatio = mc.calculatorTotalLimpRatio(((QuestionTemplateViewModel.Question)viewModel.BreedLimp).getRatio(),criticalRatio);
                        Log.d("totalRatio_1",String.valueOf(totalRatio));
                        totalRatio = (float) viewModel.cutDecimal(totalRatio);
                        Log.d("totalRatio_2",String.valueOf(totalRatio));
                        viewModel.setTotalLimpRatio(totalRatio);
                        limpScore = mc.calculatorLimpScore(totalRatio);
                        totalRatioTv.setText(String.valueOf(totalRatio));
                        ((QuestionTemplateViewModel.Question) viewModel.BreedLimp).setScore(limpScore);
                        ((QuestionTemplateViewModel.Question) viewModel.CriticalLimp).setScore(limpScore);
                        totalScoreTv.setText(String.valueOf(limpScore));

                }
            }
        });
        return view;
    }
}