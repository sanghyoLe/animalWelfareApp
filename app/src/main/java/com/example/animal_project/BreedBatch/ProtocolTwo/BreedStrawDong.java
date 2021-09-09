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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.animal_project.BreedBatch.ProtocolOne.BreedWaterDongQ3;
import com.example.animal_project.QuestionTemplate;
import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;

import java.util.Arrays;

public class BreedStrawDong extends AppCompatActivity {
    private int dong_size;
    private QuestionTemplateViewModel viewModel;
    @Override
    public void onBackPressed(){

        myOnBackPressed(new AlertDialog.Builder(BreedStrawDong.this));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.straw_dong);
        viewModel = new ViewModelProvider(this).get(QuestionTemplateViewModel.class);
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
        CheckBox[] locationOne = makeCheckBoxArr(questionViewArr,dong_size, R.id.checkbox_location_one);
        CheckBox[] locationTwo = makeCheckBoxArr(questionViewArr,dong_size, R.id.checkbox_location_two);
        CheckBox[] locationThree = makeCheckBoxArr(questionViewArr,dong_size, R.id.checkbox_location_three);

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
                }  else {
                    for(int i = 0 ;i < dong_size;i++){
                        int finalI = i;
                        locationOne[i].setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if (locationOne[finalI].isChecked()) {
                                        strawQuestion.setStrawOne(1, finalI);
                                } else {
                                    strawQuestion.setStrawOne(0, finalI);
                                }

                            }
                        });
                        locationTwo[i].setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if (locationTwo[finalI].isChecked()) {
                                    strawQuestion.setStrawTwo(1, finalI);
                                } else {
                                    strawQuestion.setStrawTwo(0, finalI);
                                }

                            }
                        });
                        locationThree[i].setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                if (locationThree[finalI].isChecked()) {
                                    strawQuestion.setStrawThree(1, finalI);
                                } else {
                                    strawQuestion.setStrawThree(0, finalI);
                                }

                            }
                        });
                        strawQuestion.setStrawScore(
                                viewModel.calculatorBreedStrawScore(
                                        strawQuestion.getStrawOne(finalI),
                                        strawQuestion.getStrawTwo(finalI),
                                        strawQuestion.getStrawThree(finalI)
                                ),finalI
                        );
                    }

                    strawQuestion.setPenLocation(viewModel.makePenLocationArr(penLocationOneEd,penLocationTwoEd,dong_size));
                    strawQuestion.setStrawAvgScore(strawQuestion.getStrawScore(),dong_size);
                    strawQuestion.setDongSize(dong_size);
                    String msg = makeInputString(
                            strawQuestion.getStrawScore(),
                            dong_size
                    );

                    AlertDialog.Builder AlertBuilder = new AlertDialog.Builder(BreedStrawDong.this);
                    AlertBuilder.setTitle("평가 결과");
                    AlertBuilder.setMessage(msg + "\n 깔짚수분 평균점수 : " + strawQuestion.getStrawAvgScore() + "점 \n" +
                            "평가를 완료하시겠습니까 ? ");
                    // 버튼 추가 (Ok 버튼과 Cancle 버튼 )
                    AlertBuilder.setPositiveButton("취소",new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface dialog,int which){


                        }
                    });
                    AlertBuilder.setNegativeButton("네", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent();
                            intent.putExtra("strawDongQuestion",strawQuestion);
                            setResult(1,intent);
                            finish();
                        }
                    });
                    AlertBuilder.show();


                }
            }
        });





        }
    private String makeInputString(int strawScore[] ,int dong_size){
        String[] inputStrings = new String[dong_size];
        String msg = "";
        for(int i = 0 ; i < dong_size ; i++){
            inputStrings[i] = (i+1) + "동 깔짚수분 점수 : " + strawScore[i] + "점 \n";
            msg += inputStrings[i];
        }
        return msg;
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
     private CheckBox[] makeCheckBoxArr(View[] view, int dongSize, int id){
        CheckBox[] checkBoxes = new CheckBox[dongSize];
        for(int i = 0 ; i <  dongSize ;  i++){
            checkBoxes[i] = view[i].findViewById(id);
        }
        return checkBoxes;
     }

    }
