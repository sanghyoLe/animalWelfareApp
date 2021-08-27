package com.example.animal_project.BreedBatch.ProtocolTwo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;

import java.util.Arrays;

public class BreedStrawDong extends AppCompatActivity {
    private int dong_size;
    @Override
    public void onBackPressed(){

        myOnBackPressed(new AlertDialog.Builder(BreedStrawDong.this));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.straw_dong);
        QuestionTemplateViewModel viewModel = new ViewModelProvider(this).get(QuestionTemplateViewModel.class);
        Intent intent = getIntent();
        dong_size = intent.getExtras().getInt("dong_count");
        

        View view = findViewById(R.id.breed_straw_dong_layout);



        ImageButton home_btn = view.findViewById(R.id.home_btn);
        Button end_btn = view.findViewById(R.id.end_btn);
        Button standard_table_btn = findViewById(R.id.standard_table_btn);
        View question_1 = findViewById(R.id.breed_straw_dong_question_1);
        View question_2 = findViewById(R.id.breed_straw_dong_question_2);
        View question_3 = findViewById(R.id.breed_straw_dong_question_3);
        View question_4 = findViewById(R.id.breed_straw_dong_question_4);
        View question_5 = findViewById(R.id.breed_straw_dong_question_5);
        View question_6 = findViewById(R.id.breed_straw_dong_question_6);
        View question_7 = findViewById(R.id.breed_straw_dong_question_7);
        View question_8 = findViewById(R.id.breed_straw_dong_question_8);
        View question_9 = findViewById(R.id.breed_straw_dong_question_9);
        View question_10 = findViewById(R.id.breed_straw_dong_question_10);
        View question_11 = findViewById(R.id.breed_straw_dong_question_11);
        View question_12 = findViewById(R.id.breed_straw_dong_question_12);
        View question_13 = findViewById(R.id.breed_straw_dong_question_13);
        View question_14 = findViewById(R.id.breed_straw_dong_question_14);
        View question_15 = findViewById(R.id.breed_straw_dong_question_15);
        View question_16 = findViewById(R.id.breed_straw_dong_question_16);
        View question_17 = findViewById(R.id.breed_straw_dong_question_17);
        View question_18 = findViewById(R.id.breed_straw_dong_question_18);
        View question_19 = findViewById(R.id.breed_straw_dong_question_19);
        View question_20 = findViewById(R.id.breed_straw_dong_question_20);

        View[] questionViewArr = {
                question_1, question_2, question_3, question_4, question_5
                , question_6, question_7, question_8, question_9, question_10
                , question_11, question_12, question_13, question_14, question_15
                , question_16, question_17, question_18, question_19, question_20};

        viewModel.showQuestionView(questionViewArr, dong_size);
        EditText[] penLocationOneEd = viewModel.makeEditText(questionViewArr,dong_size,R.id.pen_location_1_ed);
        EditText[] penLocationTwoEd = viewModel.makeEditText(questionViewArr,dong_size,R.id.pen_location_2_ed);

        ArrayAdapter spinnerAdapterQuestionOne = ArrayAdapter.createFromResource(getApplicationContext(),
                R.array.straw_question_1,
                android.R.layout.simple_dropdown_item_1line);
        spinnerAdapterQuestionOne.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter spinnerAdapterQuestionTwo = ArrayAdapter.createFromResource(getApplicationContext(),
                R.array.straw_question_2,
                android.R.layout.simple_dropdown_item_1line);
        spinnerAdapterQuestionTwo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter spinnerAdapterQuestionThree = ArrayAdapter.createFromResource(getApplicationContext(),
                R.array.straw_question_3,
                android.R.layout.simple_dropdown_item_1line);
        spinnerAdapterQuestionThree.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner[] strawSpinnerOne = makeSpinner(questionViewArr,spinnerAdapterQuestionOne,dong_size,R.id.straw_question_spinner_1);
        Spinner[] strawSpinnerTwo = makeSpinner(questionViewArr,spinnerAdapterQuestionTwo,dong_size,R.id.straw_question_spinner_2);
        Spinner[] strawSpinnerThree = makeSpinner(questionViewArr,spinnerAdapterQuestionThree,dong_size,R.id.straw_question_spinner_3);
        QuestionTemplateViewModel.StrawQuestion strawQuestion = new QuestionTemplateViewModel.StrawQuestion(dong_size);
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(BreedStrawDong.this);

        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myOnBackPressed(alertDialog);
            }
        });

        standard_table_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerHandler();
            }
        });
        int[] answersOne = new int[dong_size];
        for(int i = 0 ; i < dong_size ; i++){
            int finalI = i;
            strawSpinnerOne[i].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    // 선택된 데이터 값
                    String selectedItem = parent.getSelectedItem().toString();
                    // 선택된 데이터 위치( 0 부터 )
                    answersOne[finalI] = position;

                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    answersOne[finalI] = 0;
                }
            });
        }
        int[] answersTwo = new int[dong_size];
        for(int i = 0 ; i < dong_size ; i++){
            int finalI = i;
            strawSpinnerTwo[i].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    // 선택된 데이터 값
                    String selectedItem = parent.getSelectedItem().toString();
                    // 선택된 데이터 위치( 0 부터 )
                    answersTwo[finalI] = position;

                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    answersTwo[finalI] = 0;
                }
            });
        }
        int[] answersThree = new int[dong_size];
        for(int i = 0 ; i < dong_size ; i++){
            int finalI = i;
            strawSpinnerThree[i].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    // 선택된 데이터 값
                    String selectedItem = parent.getSelectedItem().toString();
                    // 선택된 데이터 위치( 0 부터 )
                    answersThree[finalI] = position;

                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    answersThree[finalI] = 0;
                }
            });
        }
        end_btn.setOnClickListener(new View.OnClickListener() {
            String msg;
            @Override
            public void onClick(View v) {
                if(viewModel.checkEmptyEditText(penLocationOneEd,dong_size) != -1){
                    msg = viewModel.checkEmptyEditText(penLocationOneEd,dong_size) + "동 펜 위치를 입력하세요";
                    Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
                }else if(viewModel.checkEmptyEditText(penLocationTwoEd,dong_size) != -1){
                    msg = viewModel.checkEmptyEditText(penLocationOneEd,dong_size) + "동 펜 위치를 입력하세요";
                    Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
                } else if(viewModel.checkEmptySpinner(answersOne ,dong_size) != -1){
                    msg = viewModel.checkEmptySpinner(answersOne,dong_size) + "동 사료조 근처 비율을 선택하세요";
                    Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
                }else if(viewModel.checkEmptySpinner(answersTwo,dong_size) != -1){
                    msg = viewModel.checkEmptySpinner(answersTwo ,dong_size) + "동 사료조와 주 휴식장소 사이 비율을 선택하세요";
                    Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
                }else if(viewModel.checkEmptySpinner(answersThree,dong_size) != -1){
                    msg = viewModel.checkEmptySpinner(answersThree ,dong_size) + "동 주 휴식장소 사이 비율을 선택하세요";
                    Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
                } else {
                    strawQuestion.setPenLocation(viewModel.makePenLocationArr(penLocationOneEd,penLocationTwoEd,dong_size));
                    strawQuestion.setStrawOne(answersOne);
                    strawQuestion.setStrawTwo(answersTwo);
                    strawQuestion.setStrawThree(answersThree);
                    // 깔짚 수분 기준 점수표 나오면 점수는 재 작성 예정
                    finish();
                }
            }
        });





        }
    public void myOnBackPressed(AlertDialog.Builder AlertBuilder){

        AlertBuilder.setTitle("이전");
        AlertBuilder.setMessage("지금까지 평가한 항목이 사라집니다.\n" +
                "평가 화면으로 돌아가시겠습니까?");
        // 버튼 추가 (Ok 버튼과 Cancle 버튼 )
        AlertBuilder.setPositiveButton("취소",new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog,int which){
                // OK 버튼을 눌렸을 경우

            }
        });
        AlertBuilder.setNegativeButton("네", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        AlertBuilder.show();
    }
    public Spinner[] makeSpinner(View[] QuestionViewArr, ArrayAdapter spinnerAdapter, int dong_size,int id) {
        Spinner[] SpinnerArr = new Spinner[dong_size];
        for (int i = 0; i < dong_size ; i++) {
            SpinnerArr[i] = QuestionViewArr[i].findViewById(id);
            SpinnerArr[i].setAdapter(spinnerAdapter);
        }
        return SpinnerArr;
    }
    private void drawerHandler() {
        View view = findViewById(R.id.breed_straw_dong_layout);
        DrawerLayout drawer = (DrawerLayout) view.findViewById(R.id.drawer);
        if (!drawer.isDrawerOpen(Gravity.RIGHT)) {
            drawer.openDrawer(Gravity.RIGHT);
        } else if (drawer.isDrawerOpen(Gravity.RIGHT)) {
            drawer.closeDrawer(Gravity.RIGHT);
        }
     }

    }
