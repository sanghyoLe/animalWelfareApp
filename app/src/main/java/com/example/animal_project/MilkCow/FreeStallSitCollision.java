package com.example.animal_project.MilkCow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.animal_project.CustomImageDialog;
import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;


public class FreeStallSitCollision extends Fragment {
    private QuestionTemplateViewModel viewModel;

    private View view;
    private int sitCount;
    private TextView sitCollisionRatioTv;
    private TextView sitCollisionScoreTv;
    private CheckBox[] sitCollisionCB;
    private int countYes = 0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);

        view = inflater.inflate(R.layout.fragment_freestall_sit_collision, container,

                false);
        sitCollisionRatioTv = view.findViewById(R.id.sit_collision_ratio);
        sitCollisionScoreTv = view.findViewById(R.id.sit_collision_score);
        View question_1 = view.findViewById(R.id.free_stall_sit_collision_question_1);
        View question_2 = view.findViewById(R.id.free_stall_sit_collision_question_2);
        View question_3 = view.findViewById(R.id.free_stall_sit_collision_question_3);
        View question_4 = view.findViewById(R.id.free_stall_sit_collision_question_4);
        View question_5 = view.findViewById(R.id.free_stall_sit_collision_question_5);
        View question_6 = view.findViewById(R.id.free_stall_sit_collision_question_6);
        View question_7 = view.findViewById(R.id.free_stall_sit_collision_question_7);
        View question_8 = view.findViewById(R.id.free_stall_sit_collision_question_8);
        View question_9 = view.findViewById(R.id.free_stall_sit_collision_question_9);
        View question_10 = view.findViewById(R.id.free_stall_sit_collision_question_10);
        View question_11 = view.findViewById(R.id.free_stall_sit_collision_question_11);
        View question_12 = view.findViewById(R.id.free_stall_sit_collision_question_12);
        View question_13 = view.findViewById(R.id.free_stall_sit_collision_question_13);
        View question_14 = view.findViewById(R.id.free_stall_sit_collision_question_14);
        View question_15 = view.findViewById(R.id.free_stall_sit_collision_question_15);
        View question_16 = view.findViewById(R.id.free_stall_sit_collision_question_16);
        View question_17 = view.findViewById(R.id.free_stall_sit_collision_question_17);
        View question_18 = view.findViewById(R.id.free_stall_sit_collision_question_18);
        View question_19 = view.findViewById(R.id.free_stall_sit_collision_question_19);
        View question_20 = view.findViewById(R.id.free_stall_sit_collision_question_20);
        View question_21 = view.findViewById(R.id.free_stall_sit_collision_question_21);
        View question_22 = view.findViewById(R.id.free_stall_sit_collision_question_22);
        View question_23 = view.findViewById(R.id.free_stall_sit_collision_question_23);
        View question_24 = view.findViewById(R.id.free_stall_sit_collision_question_24);
        View question_25 = view.findViewById(R.id.free_stall_sit_collision_question_25);
        View question_26 = view.findViewById(R.id.free_stall_sit_collision_question_26);
        View question_27 = view.findViewById(R.id.free_stall_sit_collision_question_27);
        View question_28 = view.findViewById(R.id.free_stall_sit_collision_question_28);
        View question_29 = view.findViewById(R.id.free_stall_sit_collision_question_29);
        View question_30 = view.findViewById(R.id.free_stall_sit_collision_question_30);
        View question_31 = view.findViewById(R.id.free_stall_sit_collision_question_31);
        View question_32 = view.findViewById(R.id.free_stall_sit_collision_question_32);
        View question_33 = view.findViewById(R.id.free_stall_sit_collision_question_33);
        View question_34 = view.findViewById(R.id.free_stall_sit_collision_question_34);
        View question_35 = view.findViewById(R.id.free_stall_sit_collision_question_35);
        View question_36 = view.findViewById(R.id.free_stall_sit_collision_question_36);
        View question_37 = view.findViewById(R.id.free_stall_sit_collision_question_37);
        View question_38 = view.findViewById(R.id.free_stall_sit_collision_question_38);
        View question_39 = view.findViewById(R.id.free_stall_sit_collision_question_39);
        View question_40 = view.findViewById(R.id.free_stall_sit_collision_question_40);
        View question_41 = view.findViewById(R.id.free_stall_sit_collision_question_41);
        View question_42 = view.findViewById(R.id.free_stall_sit_collision_question_42);
        View question_43 = view.findViewById(R.id.free_stall_sit_collision_question_43);
        View question_44 = view.findViewById(R.id.free_stall_sit_collision_question_44);
        View question_45 = view.findViewById(R.id.free_stall_sit_collision_question_45);
        View question_46 = view.findViewById(R.id.free_stall_sit_collision_question_46);
        View question_47 = view.findViewById(R.id.free_stall_sit_collision_question_47);
        View question_48 = view.findViewById(R.id.free_stall_sit_collision_question_48);
        View question_49 = view.findViewById(R.id.free_stall_sit_collision_question_49);
        View question_50 = view.findViewById(R.id.free_stall_sit_collision_question_50);

        View[] questionViewArr = {
                question_1, question_2, question_3, question_4, question_5
                , question_6, question_7, question_8, question_9, question_10
                , question_11, question_12, question_13, question_14, question_15
                , question_16, question_17, question_18, question_19, question_20
                , question_21, question_22, question_23, question_24, question_25
                , question_26, question_27, question_28, question_29, question_30
                , question_31, question_32, question_33, question_34, question_35
                , question_36, question_37, question_38, question_39, question_40,
                question_41, question_42, question_43, question_44, question_45
                , question_46, question_47, question_48, question_49, question_50};

        Spinner numSpinner = view.findViewById(R.id.sit_collision_spinner);
        ArrayAdapter spinnerAdapter = ArrayAdapter.createFromResource(getActivity().getApplicationContext(), R.array.sit_collision_num, android.R.layout.simple_dropdown_item_1line);

        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        numSpinner.setAdapter(spinnerAdapter);


        Button standard_btn = view.findViewById(R.id.standard_btn);
        standard_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomImageDialog customImageDialog = new CustomImageDialog(FreeStallSitCollision.this.getContext());
                    customImageDialog.setImage(R.drawable.sit_collision);
            }
        });

        final int[] selectedItemIndex = new int[1];
        numSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // 선택된 데이터 값
                String selectedItem = parent.getSelectedItem().toString();
                // 선택된 데이터 위치( 0 부터 )
                selectedItemIndex[0] = position;
                if(selectedItemIndex[0] == 0){
                    showQuestionView(questionViewArr,0);
                }else if(selectedItemIndex[0] != 0) {
                    sitCount = selectedItemIndex[0] + 5;
                    showQuestionView(questionViewArr, sitCount);
                    sitCollisionCB = makeCheckBoxArr(questionViewArr, sitCount, R.id.collision_check_box);
                    ((QuestionTemplateViewModel.SitCollisionQuestion)viewModel.SitCollision).setSitCount(sitCount);

                    for(int i = 0 ; i < sitCount ; i++){
                        ((QuestionTemplateViewModel.SitCollisionQuestion)viewModel.SitCollision).setSitCollision(false,i);
                        sitCollisionCB[i].setChecked(false);
                    }
                    ((QuestionTemplateViewModel.SitCollisionQuestion)viewModel.SitCollision).setRatio(
                            ((QuestionTemplateViewModel.SitCollisionQuestion)viewModel.SitCollision).calculatorRatio(
                                    ((QuestionTemplateViewModel.SitCollisionQuestion)viewModel.SitCollision).getSitCollision(),
                                    ((QuestionTemplateViewModel.SitCollisionQuestion)viewModel.SitCollision).getSitCount()
                            )
                    );
                    ((QuestionTemplateViewModel.SitCollisionQuestion)viewModel.SitCollision).setScore(
                            ((QuestionTemplateViewModel.SitCollisionQuestion)viewModel.SitCollision).calculatorScore(
                                    ((QuestionTemplateViewModel.SitCollisionQuestion)viewModel.SitCollision).getRatio()
                            )
                    );

                    sitCollisionRatioTv.setText(String.valueOf(((QuestionTemplateViewModel.SitCollisionQuestion)viewModel.SitCollision).getRatio()));
                    sitCollisionScoreTv.setText(String.valueOf(((QuestionTemplateViewModel.SitCollisionQuestion)viewModel.SitCollision).getScore()));
                    for(int i  = 0; i < sitCount ; i++){
                        onClickSitCollisionCheckBox(sitCollisionCB[i],i);
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });




        return view;
    }

    public void showQuestionView(View[] QuestionViewArr, int sit_num) {
        TextView[] tvArr = new TextView[50];
        if(sit_num == 0){
            for(int i = 0 ; i < 50 ; i++){
                QuestionViewArr[i].setVisibility(View.GONE);
            }

        }else {
            for (int i = 0; i < 50; i++) {
                tvArr[i] = QuestionViewArr[i].findViewById(R.id.sit_collision_num_tv);
                QuestionViewArr[i].setVisibility(View.GONE);
                tvArr[i].setText(String.valueOf(i + 1));
            }
            for (int i = 0; i < sit_num ; i++) {
                QuestionViewArr[i].setVisibility(View.VISIBLE);
            }
        }

    }

    private CheckBox[] makeCheckBoxArr(View[] view,int sitCount, int id){
        CheckBox[] checkBoxes = new CheckBox[sitCount];
        for(int i = 0 ; i <  sitCount ;  i++){
            checkBoxes[i] = view[i].findViewById(id);
        }
        return checkBoxes;
    }
    public void onClickSitCollisionCheckBox(CheckBox cb,int index){
        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean ifChecked;
                ifChecked = cb.isChecked() ? true : false;
                ((QuestionTemplateViewModel.SitCollisionQuestion)viewModel.SitCollision).setSitCollision(ifChecked, index);
                ((QuestionTemplateViewModel.SitCollisionQuestion)viewModel.SitCollision).setRatio(
                        ((QuestionTemplateViewModel.SitCollisionQuestion)viewModel.SitCollision).calculatorRatio(
                                ((QuestionTemplateViewModel.SitCollisionQuestion)viewModel.SitCollision).getSitCollision(),
                                ((QuestionTemplateViewModel.SitCollisionQuestion)viewModel.SitCollision).getSitCount()
                        )
                );
                ((QuestionTemplateViewModel.SitCollisionQuestion)viewModel.SitCollision).setScore(
                        ((QuestionTemplateViewModel.SitCollisionQuestion)viewModel.SitCollision).calculatorScore(
                                ((QuestionTemplateViewModel.SitCollisionQuestion)viewModel.SitCollision).getRatio()
                        )
                );

                sitCollisionRatioTv.setText(String.valueOf(((QuestionTemplateViewModel.SitCollisionQuestion)viewModel.SitCollision).getRatio()));
                sitCollisionScoreTv.setText(String.valueOf(((QuestionTemplateViewModel.SitCollisionQuestion)viewModel.SitCollision).getScore()));

            }
        });
    }
}
