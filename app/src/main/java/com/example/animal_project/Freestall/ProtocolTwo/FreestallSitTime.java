package com.example.animal_project.Freestall.ProtocolTwo;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.animal_project.BreedBatch.ProtocolFour.BreedAvoidDistanceCowQuestions;
import com.example.animal_project.MilkCowViewModel;
import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;


public class FreestallSitTime extends Fragment {
    private QuestionTemplateViewModel viewModel;
    private MilkCowViewModel viewModelMilk;
    private View view;
    private int sit_time_num;
    float sum = 0;
    float sumAvg;
    int sitTimeScore;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);
        viewModelMilk = new ViewModelProvider(getActivity()).get(MilkCowViewModel.class);
        view = inflater.inflate(R.layout.fragment_freestall_sit_time, container, false);
        TextView sit_time_ratio = view.findViewById(R.id.sit_time_ratio);
        TextView sit_time_score = view.findViewById(R.id.sit_time_score);
        View question_1 = view.findViewById(R.id.freestall_sit_time_question_1);
        View question_2 = view.findViewById(R.id.freestall_sit_time_question_2);
        View question_3 = view.findViewById(R.id.freestall_sit_time_question_3);
        View question_4 = view.findViewById(R.id.freestall_sit_time_question_4);
        View question_5 = view.findViewById(R.id.freestall_sit_time_question_5);
        View question_6 = view.findViewById(R.id.freestall_sit_time_question_6);
        View question_7 = view.findViewById(R.id.freestall_sit_time_question_7);
        View question_8 = view.findViewById(R.id.freestall_sit_time_question_8);
        View question_9 = view.findViewById(R.id.freestall_sit_time_question_9);
        View question_10 = view.findViewById(R.id.freestall_sit_time_question_10);
        View question_11 = view.findViewById(R.id.freestall_sit_time_question_11);
        View question_12 = view.findViewById(R.id.freestall_sit_time_question_12);
        View question_13 = view.findViewById(R.id.freestall_sit_time_question_13);
        View question_14 = view.findViewById(R.id.freestall_sit_time_question_14);
        View question_15 = view.findViewById(R.id.freestall_sit_time_question_15);
        View question_16 = view.findViewById(R.id.freestall_sit_time_question_16);
        View question_17 = view.findViewById(R.id.freestall_sit_time_question_17);
        View question_18 = view.findViewById(R.id.freestall_sit_time_question_18);
        View question_19 = view.findViewById(R.id.freestall_sit_time_question_19);
        View question_20 = view.findViewById(R.id.freestall_sit_time_question_20);
        View question_21 = view.findViewById(R.id.freestall_sit_time_question_21);
        View question_22 = view.findViewById(R.id.freestall_sit_time_question_22);
        View question_23 = view.findViewById(R.id.freestall_sit_time_question_23);
        View question_24 = view.findViewById(R.id.freestall_sit_time_question_24);
        View question_25 = view.findViewById(R.id.freestall_sit_time_question_25);
        View question_26 = view.findViewById(R.id.freestall_sit_time_question_26);
        View question_27 = view.findViewById(R.id.freestall_sit_time_question_27);
        View question_28 = view.findViewById(R.id.freestall_sit_time_question_28);
        View question_29 = view.findViewById(R.id.freestall_sit_time_question_29);
        View question_30 = view.findViewById(R.id.freestall_sit_time_question_30);
        View question_31 = view.findViewById(R.id.freestall_sit_time_question_31);
        View question_32 = view.findViewById(R.id.freestall_sit_time_question_32);
        View question_33 = view.findViewById(R.id.freestall_sit_time_question_33);
        View question_34 = view.findViewById(R.id.freestall_sit_time_question_34);
        View question_35 = view.findViewById(R.id.freestall_sit_time_question_35);
        View question_36 = view.findViewById(R.id.freestall_sit_time_question_36);
        View question_37 = view.findViewById(R.id.freestall_sit_time_question_37);
        View question_38 = view.findViewById(R.id.freestall_sit_time_question_38);
        View question_39 = view.findViewById(R.id.freestall_sit_time_question_39);
        View question_40 = view.findViewById(R.id.freestall_sit_time_question_40);
        View question_41 = view.findViewById(R.id.freestall_sit_time_question_41);
        View question_42 = view.findViewById(R.id.freestall_sit_time_question_42);
        View question_43 = view.findViewById(R.id.freestall_sit_time_question_43);
        View question_44 = view.findViewById(R.id.freestall_sit_time_question_44);
        View question_45 = view.findViewById(R.id.freestall_sit_time_question_45);
        View question_46 = view.findViewById(R.id.freestall_sit_time_question_46);
        View question_47 = view.findViewById(R.id.freestall_sit_time_question_47);
        View question_48 = view.findViewById(R.id.freestall_sit_time_question_48);
        View question_49 = view.findViewById(R.id.freestall_sit_time_question_49);
        View question_50 = view.findViewById(R.id.freestall_sit_time_question_50);

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

        Spinner numSpinner = view.findViewById(R.id.sit_time_spinner);
        ArrayAdapter spinnerAdapter = ArrayAdapter.createFromResource(getActivity().getApplicationContext(), R.array.sit_collision_num, android.R.layout.simple_dropdown_item_1line);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        numSpinner.setAdapter(spinnerAdapter);

        final int[] selectedItemIndex = new int[1];
        numSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // 선택된 데이터 값
                String selectedItem = parent.getSelectedItem().toString();
                // 선택된 데이터 위치( 0 부터 )
                selectedItemIndex[0] = position;
                Log.d("선택:", String.valueOf(selectedItemIndex[0]));
                sit_time_num = selectedItemIndex[0];
                showQuestionView(questionViewArr, selectedItemIndex[0]);
                viewModelMilk.setSitCollision(selectedItemIndex[0] + 6);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        final EditText[] sitTimeAnswer = new EditText[50];
        final float[] sitTimeArr = new float[50];
        for(int i = 0 ; i < 50 ; i++) {
            int finalI = i;
            sitTimeAnswer[i] = questionViewArr[i].findViewById(R.id.sit_time_duration);
            sitTimeAnswer[i].addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    if(TextUtils.isEmpty(sitTimeAnswer[finalI].getText().toString())) {
                        sit_time_ratio.setText("문항을 완료하세요");
                        sit_time_score.setText("문항을 완료하세요");
                        sum = sum - sitTimeArr[finalI];
                        viewModelMilk.setSitTimeScore(-1);
                    } else {
                        sitTimeArr[finalI] = Float.parseFloat(sitTimeAnswer[finalI].getText().toString());
                        sitTimeArr[finalI] = calculatorSitTime(sitTimeArr[finalI]);
                        sum = sum + sitTimeArr[finalI];
                        sumAvg = sum / (selectedItemIndex[0] + 6);
                        String sumAvgRatio = String.format("%.1f", sumAvg);
                        sit_time_ratio.setText(sumAvgRatio);
                        sitTimeScore = viewModelMilk.calculatorSitTimeScore(sumAvg);
                        sit_time_score.setText(String.valueOf(sitTimeScore));
                        viewModelMilk.setSitTimeScore(sitTimeScore);
                    }
                }
            });
        }
        return view;
    }
    public void showQuestionView(View[] QuestionViewArr, int sit_num) {
        TextView[] tvArr = new TextView[50];
        for (int i = 0; i < 50; i++) {
            tvArr[i] = QuestionViewArr[i].findViewById(R.id.sit_time_tv);
            QuestionViewArr[i].setVisibility(View.GONE);
            tvArr[i].setText(String.valueOf(i + 1));
        }
        for (int i = 0; i < sit_num + 5; i++) {
            QuestionViewArr[5].setVisibility(View.VISIBLE);
            QuestionViewArr[i].setVisibility(View.VISIBLE);
            Log.d("선택:", String.valueOf(sit_num));
        }
    }
    public float calculatorSitTime(float sitTime) {
        if(sitTime > 10) {
            sitTime = sitTime - 1;
        } else if(sitTime > 20) {
            sitTime = sitTime - 2;
        } else if(sitTime > 30) {
            sitTime = sitTime - 3;
        } else if(sitTime > 40) {
            sitTime = sitTime - 4;
        } else if(sitTime > 50) {
            sitTime = sitTime - 5;
        } else if(sitTime > 60) {
            sitTime = sitTime - 6;
        } else if(sitTime > 70) {
            sitTime = sitTime - 7;
        } else if(sitTime > 80) {
            sitTime = sitTime - 8;
        } else if(sitTime > 90) {
            sitTime = sitTime - 9;
        } else if(sitTime > 100) {
            sitTime = sitTime - 10;
        }
        return sitTime;
    }
}
