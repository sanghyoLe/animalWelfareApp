package com.example.animal_project.MilkCow;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;


public class MilkInCell extends Fragment {
    private View view;
    private QuestionTemplateViewModel viewModel;
//    public String total_cow_count = ((Input_userinfo)Input_userinfo.context_userinfo).total_cow_count;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_milk_in_cell, container, false);

         viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);


        EditText milkInCellEd = (EditText) view.findViewById(R.id.milk_in_cell_a1);
        TextView milkInCellTv = (TextView) view.findViewById(R.id.milk_in_cell_ratio_1);

        
        EditText penLocationOne = view.findViewById(R.id.pen_location_ed_1);
        EditText penLocationTwo = view.findViewById(R.id.pen_location_ed_2);

        milkInCellEd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(TextUtils.isEmpty(milkInCellEd.getText().toString())){
                    milkInCellTv.setText("값을 입력하세요");
                    ((QuestionTemplateViewModel.PenQuestion)viewModel.MilkInCell).setRatio(-1);
                    ((QuestionTemplateViewModel.PenQuestion)viewModel.MilkInCell).setNumberOfCow(-1);
                    ((QuestionTemplateViewModel.PenQuestion)viewModel.MilkInCell).setScore(-1);
                } else if(viewModel.getRatio(milkInCellEd) > 100) {
                    ((QuestionTemplateViewModel.PenQuestion)viewModel.MilkInCell).setRatio(-1);
                    milkInCellTv.setText("표본 규모보다 큰 값 입력 불가");
                    ((QuestionTemplateViewModel.PenQuestion)viewModel.MilkInCell).setNumberOfCow(-1);
                    ((QuestionTemplateViewModel.PenQuestion)viewModel.MilkInCell).setScore(-1);
  ;
                } else {
                    ((QuestionTemplateViewModel.PenQuestion)viewModel.MilkInCell).setPenLocation(
                            viewModel.makePenLocation(penLocationOne,penLocationTwo)
                    );
                    ((QuestionTemplateViewModel.PenQuestion)viewModel.MilkInCell).setRatio(getRatioMilkInCell(milkInCellEd));

                    ((QuestionTemplateViewModel.PenQuestion)viewModel.MilkInCell).setNumberOfCow(Integer.parseInt(String.valueOf(milkInCellEd.getText())));
                    milkInCellTv.setText(String.valueOf(viewModel.getRatio(milkInCellEd)));
                }
            }
        });

        return view;
    }

    public float getRatioMilkInCell(EditText editText){
        float ratio = (Float.parseFloat(editText.getText().toString()) / viewModel.getMilkCowSize()) * 100;
        ratio = (float) (Math.round(ratio*100)/100.0);

        return ratio;
    }
}