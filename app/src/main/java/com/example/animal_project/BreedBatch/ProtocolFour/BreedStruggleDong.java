package com.example.animal_project.BreedBatch.ProtocolFour;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;

import java.util.Arrays;

public class BreedStruggleDong extends AppCompatActivity {
    private int dong_size;
    private QuestionTemplateViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.struggle_dong);
        viewModel = new ViewModelProvider(this).get(QuestionTemplateViewModel.class);

        Intent intent = getIntent();
        dong_size = intent.getExtras().getInt("dong_count");

        View view = findViewById(R.id.breed_struggle_dong_layout);



        View question_1 = findViewById(R.id.breed_struggle_dong_question_1);
        View question_2 = findViewById(R.id.breed_struggle_dong_question_2);
        View question_3 = findViewById(R.id.breed_struggle_dong_question_3);
        View question_4 = findViewById(R.id.breed_struggle_dong_question_4);
        View question_5 = findViewById(R.id.breed_struggle_dong_question_5);
        View question_6 = findViewById(R.id.breed_struggle_dong_question_6);
        View question_7 = findViewById(R.id.breed_struggle_dong_question_7);
        View question_8 = findViewById(R.id.breed_struggle_dong_question_8);
        View question_9 = findViewById(R.id.breed_struggle_dong_question_9);
        View question_10 = findViewById(R.id.breed_struggle_dong_question_10);
        View question_11 = findViewById(R.id.breed_struggle_dong_question_11);
        View question_12 = findViewById(R.id.breed_struggle_dong_question_12);
        View question_13 = findViewById(R.id.breed_struggle_dong_question_13);
        View question_14 = findViewById(R.id.breed_struggle_dong_question_14);
        View question_15 = findViewById(R.id.breed_struggle_dong_question_15);
        View question_16 = findViewById(R.id.breed_struggle_dong_question_16);
        View question_17 = findViewById(R.id.breed_struggle_dong_question_17);
        View question_18 = findViewById(R.id.breed_struggle_dong_question_18);
        View question_19 = findViewById(R.id.breed_struggle_dong_question_19);
        View question_20 = findViewById(R.id.breed_struggle_dong_question_20);

        ImageButton home_btn = view.findViewById(R.id.home_btn);
        View[] questionViewArr = {
                question_1, question_2, question_3, question_4, question_5
                , question_6, question_7, question_8, question_9, question_10
                , question_11, question_12, question_13, question_14, question_15
                , question_16, question_17, question_18, question_19, question_20};
        viewModel.showQuestionView(questionViewArr,dong_size);
        EditText[] penLocationOneEd = viewModel.makeEditText(questionViewArr,dong_size,R.id.pen_location_1_ed);
        EditText[] penLocationTwoEd = viewModel.makeEditText(questionViewArr,dong_size,R.id.pen_location_2_ed);
        EditText[] cowSizeEd = viewModel.makeEditText(questionViewArr,dong_size,R.id.cow_size_ed);
        EditText[] struggleEd = viewModel.makeEditText(questionViewArr,dong_size,R.id.struggle_ed);
        Button end_btn = view.findViewById(R.id.end_btn);



        // 완료 버튼
        QuestionTemplateViewModel.BehaviorQuestion struggleQuestion = new QuestionTemplateViewModel.BehaviorQuestion(dong_size);


                AlertDialog.Builder myAlterDialog = new AlertDialog.Builder(BreedStruggleDong.this);
        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myOnBackPressed(myAlterDialog);
            }
        });
        end_btn.setOnClickListener(new View.OnClickListener() {
            String msg;
            @Override
            public void onClick(View v) {
                if (viewModel.checkEmptyEditText(penLocationOneEd, dong_size) != -1) {
                    msg = viewModel.checkEmptyEditText(penLocationOneEd, dong_size) + "동 펜 위치를 입력하세요";
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                } else if (viewModel.checkEmptyEditText(penLocationTwoEd, dong_size) != -1) {
                    msg = viewModel.checkEmptyEditText(penLocationTwoEd, dong_size) + "동 펜 위치를 입력하세요";
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                } else if (viewModel.checkEmptyEditText(cowSizeEd, dong_size) != -1) {
                    msg = viewModel.checkEmptyEditText(cowSizeEd, dong_size) + "동 사육 두수를 입력하세요";
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                } else if (viewModel.checkEmptyEditText(struggleEd, dong_size) != -1) {
                    msg = viewModel.checkEmptyEditText(struggleEd, dong_size) + "동 투쟁 행동 수를 입력하세요";
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                } else {
                    struggleQuestion.setDongSize(dong_size);
                    struggleQuestion.setPenLocation(viewModel.makePenLocationArr(penLocationOneEd,penLocationTwoEd,dong_size));
                    struggleQuestion.setCowSize(viewModel.getIntEditTextValues(cowSizeEd,dong_size));
                    struggleQuestion.setBehaviorCount(viewModel.getIntEditTextValues(struggleEd,dong_size));
                    struggleQuestion.setBehaviorPerOne(
                            calStrugglePerOne(
                                    struggleQuestion.getCowSize(),
                                    struggleQuestion.getBehaviorCount(),
                                    dong_size
                            )
                    );
                    float[] strugglePerOne = struggleQuestion.getBehaviorPerOne();
                    struggleQuestion.setBehaviorPerOneAvg(
                            calStrugglePerOneAvg(
                                    struggleQuestion.getCowSize(),
                                    struggleQuestion.getBehaviorCount(),
                                    dong_size
                            )
                    );

                    String msg = makeInputString(strugglePerOne, dong_size);
                    AlertDialog.Builder AlterBuilder = new AlertDialog.Builder(BreedStruggleDong.this);
                    AlterBuilder.setTitle("평과 결과");
                    AlterBuilder.setMessage(msg + "\n"
                    +"투쟁 행동 평균 : " + struggleQuestion.getBehaviorPerOneAvg() +"번"+" \n\n" +"평가를 완료하시겠습니까?");
                    // 버튼 추가 (Ok 버튼과 Cancle 버튼 )
                    AlterBuilder.setPositiveButton("취소", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    AlterBuilder.setNegativeButton("네", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent();
                            intent.putExtra("struggleQuestion", struggleQuestion);
                            setResult(1, intent);
                            finish();
                        }
                    });
                    AlterBuilder.show();


                }

            }
        });
    }

    private float[] calStrugglePerOne(int[] cowSize, int[] struggleEd,int dong_size){
        float[] strugglePerOne = new float[dong_size];
        for(int i = 0 ; i< dong_size ; i++){
            strugglePerOne[i] = (float)struggleEd[i] / (float)cowSize[i];
            strugglePerOne[i] = (float) viewModel.cutDecimal(strugglePerOne[i]);
            strugglePerOne[i] = strugglePerOne[i] * 6;
            strugglePerOne[i] = (float) viewModel.cutDecimal(strugglePerOne[i]);
        }
        return strugglePerOne;
    }
    private float calStrugglePerOneAvg(int[] cowSize, int[] struggleEd, int dong_size){
        float strugglePerOneAvg;
        int totalCowSize = 0;
        float totalStruggle = 0;
        for(int i = 0 ; i< dong_size ; i++){
            totalCowSize += cowSize[i];
            totalStruggle += struggleEd[i];
        }
        strugglePerOneAvg = totalStruggle / (float)totalCowSize;
        strugglePerOneAvg = (float) viewModel.cutDecimal(strugglePerOneAvg);
        strugglePerOneAvg = strugglePerOneAvg * 6;

        return (float)viewModel.cutDecimal(strugglePerOneAvg);
    }
    private String makeInputString(float[] strugglePerOne,int dong_size){
        String[] inputStrings = new String[dong_size];
        String msg = "";
        for(int i = 0 ; i < dong_size ; i++){
            inputStrings[i] = (i+1) + "동 \n1마리당 1시간 동안 투쟁 행동 수 : " + strugglePerOne[i] + "번\n";
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
}