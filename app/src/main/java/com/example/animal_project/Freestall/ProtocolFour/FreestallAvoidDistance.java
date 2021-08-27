package com.example.animal_project.Freestall.ProtocolFour;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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


public class FreestallAvoidDistance extends Fragment {
    private QuestionTemplateViewModel viewModel;
    private MilkCowViewModel viewModelMilk;
    private View view;
    private int pen_size;
    private Button btnArr[];
    private TextView avoid_distance_score_tv;
    private QuestionTemplateViewModel.avoidDistance[] avoidDistances;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);
        viewModelMilk = new ViewModelProvider(getActivity()).get(MilkCowViewModel.class);
        view = inflater.inflate(R.layout.fragment_breed_avoid_distance, container, false);

        // 뷰모델에 있는 avoidDistance 배열 초기화


        avoid_distance_score_tv = view.findViewById(R.id.breed_avoid_distance_score_tv);
        if(viewModel.getAvoidDistanceScore() == -1){
            avoid_distance_score_tv.setText("회피 거리 평가를 모두 완료하세요");
        } else {
            avoid_distance_score_tv.setText(String.valueOf(viewModel.getAvoidDistanceScore()));
        }

        View question_1 = view.findViewById(R.id.breed_avoid_distance_question_1);
        View question_2 = view.findViewById(R.id.breed_avoid_distance_question_2);
        View question_3 = view.findViewById(R.id.breed_avoid_distance_question_3);
        View question_4 = view.findViewById(R.id.breed_avoid_distance_question_4);
        View question_5 = view.findViewById(R.id.breed_avoid_distance_question_5);
        View question_6 = view.findViewById(R.id.breed_avoid_distance_question_6);
        View question_7 = view.findViewById(R.id.breed_avoid_distance_question_7);
        View question_8 = view.findViewById(R.id.breed_avoid_distance_question_8);
        View question_9 = view.findViewById(R.id.breed_avoid_distance_question_9);
        View question_10 = view.findViewById(R.id.breed_avoid_distance_question_10);
        View question_11 = view.findViewById(R.id.breed_avoid_distance_question_11);
        View question_12 = view.findViewById(R.id.breed_avoid_distance_question_12);
        View question_13 = view.findViewById(R.id.breed_avoid_distance_question_13);
        View question_14 = view.findViewById(R.id.breed_avoid_distance_question_14);
        View question_15 = view.findViewById(R.id.breed_avoid_distance_question_15);
        View question_16 = view.findViewById(R.id.breed_avoid_distance_question_16);
        View question_17 = view.findViewById(R.id.breed_avoid_distance_question_17);
        View question_18 = view.findViewById(R.id.breed_avoid_distance_question_18);
        View question_19 = view.findViewById(R.id.breed_avoid_distance_question_19);
        View question_20 = view.findViewById(R.id.breed_avoid_distance_question_20);
        View question_21 = view.findViewById(R.id.breed_avoid_distance_question_21);
        View question_22 = view.findViewById(R.id.breed_avoid_distance_question_22);
        View question_23 = view.findViewById(R.id.breed_avoid_distance_question_23);
        View question_24 = view.findViewById(R.id.breed_avoid_distance_question_24);
        View question_25 = view.findViewById(R.id.breed_avoid_distance_question_25);
        View question_26 = view.findViewById(R.id.breed_avoid_distance_question_26);
        View question_27 = view.findViewById(R.id.breed_avoid_distance_question_27);
        View question_28 = view.findViewById(R.id.breed_avoid_distance_question_28);
        View question_29 = view.findViewById(R.id.breed_avoid_distance_question_29);
        View question_30 = view.findViewById(R.id.breed_avoid_distance_question_30);
        View question_31 = view.findViewById(R.id.breed_avoid_distance_question_31);
        View question_32 = view.findViewById(R.id.breed_avoid_distance_question_32);
        View question_33 = view.findViewById(R.id.breed_avoid_distance_question_33);
        View question_34 = view.findViewById(R.id.breed_avoid_distance_question_34);
        View question_35 = view.findViewById(R.id.breed_avoid_distance_question_35);
        View question_36 = view.findViewById(R.id.breed_avoid_distance_question_36);
        View question_37 = view.findViewById(R.id.breed_avoid_distance_question_37);
        View question_38 = view.findViewById(R.id.breed_avoid_distance_question_38);
        View question_39 = view.findViewById(R.id.breed_avoid_distance_question_39);
        View question_40 = view.findViewById(R.id.breed_avoid_distance_question_40);
        View question_41 = view.findViewById(R.id.breed_avoid_distance_question_41);
        View question_42 = view.findViewById(R.id.breed_avoid_distance_question_42);
        View question_43 = view.findViewById(R.id.breed_avoid_distance_question_43);
        View question_44 = view.findViewById(R.id.breed_avoid_distance_question_44);
        View question_45 = view.findViewById(R.id.breed_avoid_distance_question_45);
        View question_46 = view.findViewById(R.id.breed_avoid_distance_question_46);
        View question_47 = view.findViewById(R.id.breed_avoid_distance_question_47);
        View question_48 = view.findViewById(R.id.breed_avoid_distance_question_48);
        View question_49 = view.findViewById(R.id.breed_avoid_distance_question_49);
        View question_50 = view.findViewById(R.id.breed_avoid_distance_question_50);


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



        Spinner mSpinner = view.findViewById(R.id.avoid_distance_spinner);

        ArrayAdapter spinnerAdapter = ArrayAdapter.createFromResource(getActivity().getApplicationContext(),
                R.array.pen_size_50,
                android.R.layout.simple_dropdown_item_1line);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(spinnerAdapter);

        ArrayAdapter spinnerAdapterCowSize = ArrayAdapter.createFromResource(getActivity().getApplicationContext(),
                R.array.cow_size_50,
                android.R.layout.simple_dropdown_item_1line);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        final int[] selectedItemIndex = new int[1];
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // 선택된 데이터 값
                String selectedItem = parent.getSelectedItem().toString();
                // 선택된 데이터 위치( 0 부터 )
                selectedItemIndex[0] = position;
                pen_size = selectedItemIndex[0];
                Spinner spinnerArr[] = makeSpinner(questionViewArr,spinnerAdapterCowSize);
                showQuestionView(questionViewArr, selectedItemIndex[0]);
                btnArr = makeBtnArr(questionViewArr);
                EditText edArr[] = makeEditTextArr(questionViewArr);

                btnHandler(btnArr,edArr,spinnerArr,pen_size);
                Log.d("1",String.valueOf(pen_size));

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });




        // Inflate the layout for this fragment
        return view;
    }

    public Spinner[] makeSpinner(View[] QuestionViewArr, ArrayAdapter spinnerAdapter) {
        Spinner[] SpinnerArr = new Spinner[50];
        for (int i = 0; i < 50 ; i++) {
            SpinnerArr[i] = QuestionViewArr[i].findViewById(R.id.cow_count_spinner);
            SpinnerArr[i].setAdapter(spinnerAdapter);
        }
        return SpinnerArr;
    }

    public void showQuestionView(View[] QuestionViewArr, int pen_size) {
        TextView[] tvArr = new TextView[50];
        for (int i = 0; i < 50; i++) {
            tvArr[i] = QuestionViewArr[i].findViewById(R.id.pen_number_tv);
            QuestionViewArr[i].setVisibility(View.GONE);
            tvArr[i].setText(String.valueOf(i + 1));
        }
        for (int i = 0; i < pen_size; i++) {
            QuestionViewArr[i].setVisibility(View.VISIBLE);
        }
    }

    public Button[] makeBtnArr(View[] questionViewArr) {
        Button[] btnArr = new Button[50];
        for (int i = 0; i < 50; i++) {
            btnArr[i] = questionViewArr[i].findViewById(R.id.select_pen_btn);
        }
        return btnArr;
        }
    public EditText[] makeEditTextArr(View[] questionViewArr){
        EditText[] edArr = new EditText[50];
        for(int i = 0 ;i < 50 ;i++){
//            edArr[i] = questionViewArr[i].findViewById(R.id.pen_location_ed);
        }
        return edArr;
    }

        public void btnHandler(Button[] btnArr,EditText[] edArr, Spinner[] spinnerArr, int pen_size){
            final int[] selectedItemIndex = new int[pen_size];
            for(int i = 0 ; i < pen_size ; i++){
                final int FinalI = i;
                spinnerArr[FinalI].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        // 선택된 데이터 값
                        String selectedItem = parent.getSelectedItem().toString();
                        // 선택된 데이터 위치( 0 부터 )
                        selectedItemIndex[FinalI] = position;
                        Log.d("select",String.valueOf(FinalI + "번" + selectedItemIndex[FinalI]));
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });
                btnArr[FinalI].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                            execCowQuestion(edArr,FinalI,selectedItemIndex);
                    }
                });
            }
        }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case 1:
                int pen_number = data.getExtras().getInt("pen_number");
                QuestionTemplateViewModel.avoidDistance avoidDistance =
                        (QuestionTemplateViewModel.avoidDistance) data.getExtras().getSerializable("avoidDistance");


                viewModel.setAvoidDistance(pen_number,avoidDistance);
                QuestionTemplateViewModel.avoidDistance avoid = viewModel.getAvoidDistance(pen_number);
                Log.d("penNumber",String.valueOf(avoid.getPenNumber()));
                Log.d("penLocation",String.valueOf(avoid.getPenLocation()));
                Log.d("cowSize",String.valueOf(avoid.getCowSize()));
                int[] exAvoid = avoid.getAvoidDistance();
                int[] exCowNum = avoid.getCowNumber();
                for(int i = 0 ;i < avoid.getCowSize(); i++ ){
                    Log.d("cowCount",String.valueOf(i+1));
                    Log.d("cowNum",String.valueOf(exCowNum[i]));
                    Log.d("avoid",String.valueOf(exAvoid[i]));
                }

                btnArr[pen_number-1].setVisibility(View.INVISIBLE);
                avoidDistances = viewModel.getAvoidDistances();
                boolean flagPenQuestion = true;

                for(int i = 1 ; i <= pen_size ;i++){
                    if(avoidDistances[i].getCowSize() == -1){
                        flagPenQuestion = true;
                        avoid_distance_score_tv.setText(String.valueOf(i) + "번 표본펜 설문을 완료하세요");
                    } else {
                        flagPenQuestion = false;
                    }
                }

                if(flagPenQuestion == false){
                    for(int i =1 ; i <=pen_size ;i++){
                            int[] avoidDistanceLevel = avoidDistances[i].getAvoidDistance();
                            for(int j = 0 ; j < avoidDistances[i].getCowSize() ; j++){
                                if(avoidDistanceLevel[j] == 1){
                                    viewModel.setAvoidDistanceLevelOneTotal(avoidDistanceLevel[j]);
                                }else if(avoidDistanceLevel[j] == 2){
                                    viewModel.setAvoidDistanceLevelTwoTotal(avoidDistanceLevel[j]);
                                }else if(avoidDistanceLevel[j] == 3){
                                    viewModel.setAvoidDistanceLevelThreeTotal(avoidDistanceLevel[j]);
                                }else if(avoidDistanceLevel[j] == 4){
                                    viewModel.setAvoidDistanceLevelFourTotal(avoidDistanceLevel[j]);
                                }
                            }
                        }

                    viewModel.setAvoidDistanceScore(
                            viewModelMilk.calculatorAvoidDistanceScore(
                                    viewModelMilk.calculatorAvoidDistanceRatio(
                                    viewModel.getAvoidDistanceLevelOneTotal(),
                                    viewModel.getAvoidDistanceLevelTwoTotal(),
                                    viewModel.getAvoidDistanceLevelThreeTotal(),
                                    viewModel.getAvoidDistanceLevelFourTotal()
                                )
                            )
                        );
                    Log.d("avoid_level_one",String.valueOf(viewModel.getAvoidDistanceLevelOneTotal()));
                    Log.d("avoid_level_two",String.valueOf(viewModel.getAvoidDistanceLevelTwoTotal()));
                    Log.d("avoid_level_three",String.valueOf(viewModel.getAvoidDistanceLevelThreeTotal()));
                    Log.d("avoid_level_four",String.valueOf(viewModel.getAvoidDistanceLevelFourTotal()));
                    Log.d("avoid_Ratio",String.valueOf(viewModelMilk.calculatorAvoidDistanceRatio(
                            viewModel.getAvoidDistanceLevelOneTotal(),
                            viewModel.getAvoidDistanceLevelTwoTotal(),
                            viewModel.getAvoidDistanceLevelThreeTotal(),
                            viewModel.getAvoidDistanceLevelFourTotal()
                    )));
                    avoid_distance_score_tv.setText(String.valueOf(viewModel.getAvoidDistanceScore()));
                    }
                TextView protocol_4 = view.findViewById(R.id.breed_protocol_4);
                if (viewModelMilk.getSocialBehaviorScore() == -1) {
                    protocol_4.setText("사회적 행동의 표현 평가를 완료하세요");
                } else if(viewModel.getAvoidDistanceScore()== -1 ) {
                    protocol_4.setText("회피 거리 평가를 완료하세요");
                }
                else
                {
                    viewModelMilk.setProtocolFourScore(
                            viewModelMilk.calculatorProtocolFourScore
                                    (
                                            viewModelMilk.getSocialBehaviorScore(),
                                            viewModel.getAvoidDistanceScore()
                                    )
                    );
                    protocol_4.setText(String.valueOf(viewModelMilk.getProtocolFourScore()));

                }
                break;
            default:
                break;
        }
    }

    // 재 입력받는 메소드인데, 재 입력받으면 모든 데이터 처리해줘야 하는 문제 있어서 보류
    /*private void onBtnClickReEnter(EditText[] edArr, int FinalI, int[] selectedItemIndex){
        AlertDialog.Builder myAlertBuilder =
                new AlertDialog.Builder(getActivity());
        myAlertBuilder.setTitle("이전");
        myAlertBuilder.setMessage("평가한 항목이 사라집니다.\n" +
                "재입력 하시겠습니까?");
        // 버튼 추가 (네 버튼과 취소 버튼 )
        myAlertBuilder.setPositiveButton("취소",new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog,int which){
                // 취소 버튼
            }
        });
        myAlertBuilder.setNegativeButton("네", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                execCowQuestion(edArr,FinalI,selectedItemIndex);
            }
        });
        myAlertBuilder.show();
    }*/

    // BreedAvoidDistanceCowQuestion Activity 실행
    private void execCowQuestion(EditText edArr[], int FinalI, int[] selectedItemIndex){
        if(TextUtils.isEmpty(edArr[FinalI].getText())){
            String msg = FinalI+1 + "번 펜 위치를 입력하세요";
            Toast.makeText(getActivity(),msg,Toast.LENGTH_LONG).show();
        } else if(selectedItemIndex[FinalI] == 0){
            String msg = FinalI+1 + "번 펜 개체 두수를 선택하세요";
            Toast.makeText(getActivity(),msg,Toast.LENGTH_LONG).show();
        }
        else{
            Intent intent = new Intent(getActivity(), BreedAvoidDistanceCowQuestions.class);
            intent.putExtra("pen_number",FinalI+1);
            intent.putExtra("pen_location",String.valueOf(edArr[FinalI].getText()));
            intent.putExtra("cow_count",selectedItemIndex[FinalI]);
            startActivityForResult(intent, 0);
            }
        }
    }
