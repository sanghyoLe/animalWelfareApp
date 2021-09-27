package com.example.animal_project.MilkCow;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;

public class FreeStallCountDong extends AppCompatActivity {
    private int dongSize;
    private QuestionTemplateViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_free_stall_count_dong);
        viewModel = new ViewModelProvider(this).get(QuestionTemplateViewModel.class);
        Intent intent = getIntent();
        dongSize = intent.getExtras().getInt("dong_count");

        View view = findViewById(R.id.free_stall_count_dong_layout);
        ImageButton home_btn = view.findViewById(R.id.home_btn);


        View question_1 = findViewById(R.id.free_stall_dong_count_1);
        View question_2 = findViewById(R.id.free_stall_dong_count_2);
        View question_3 = findViewById(R.id.free_stall_dong_count_3);
        View question_4 = findViewById(R.id.free_stall_dong_count_4);
        View question_5 = findViewById(R.id.free_stall_dong_count_5);
        View question_6 = findViewById(R.id.free_stall_dong_count_6);
        View question_7 = findViewById(R.id.free_stall_dong_count_7);
        View question_8 = findViewById(R.id.free_stall_dong_count_8);
        View question_9 = findViewById(R.id.free_stall_dong_count_9);
        View question_10 = findViewById(R.id.free_stall_dong_count_10);
        View question_11 = findViewById(R.id.free_stall_dong_count_11);
        View question_12 = findViewById(R.id.free_stall_dong_count_12);
        View question_13 = findViewById(R.id.free_stall_dong_count_13);
        View question_14 = findViewById(R.id.free_stall_dong_count_14);
        View question_15 = findViewById(R.id.free_stall_dong_count_15);
        View question_16 = findViewById(R.id.free_stall_dong_count_16);
        View question_17 = findViewById(R.id.free_stall_dong_count_17);
        View question_18 = findViewById(R.id.free_stall_dong_count_18);
        View question_19 = findViewById(R.id.free_stall_dong_count_19);
        View question_20 = findViewById(R.id.free_stall_dong_count_20);

        View[] questionViewArr = {
                question_1, question_2, question_3, question_4, question_5
                , question_6, question_7, question_8, question_9, question_10
                , question_11, question_12, question_13, question_14, question_15
                , question_16, question_17, question_18, question_19, question_20 };



        viewModel.showQuestionView(questionViewArr, dongSize);

        EditText[] cowSizeEd = viewModel.makeEditText(questionViewArr,dongSize,R.id.cow_size_ed);
        EditText[] freeStallCountEd = viewModel.makeEditText(questionViewArr,dongSize,R.id.free_stall_count_ed);

        QuestionTemplateViewModel.FreeStallCountQuestion freeStallCountQuestion = new QuestionTemplateViewModel.FreeStallCountQuestion(dongSize);
        Button endBtn = view.findViewById(R.id.end_btn);

        endBtn.setOnClickListener(new View.OnClickListener() {
            String msg;
            @Override
            public void onClick(View v) {
                if(viewModel.checkEmptyEditText(cowSizeEd,dongSize) != -1){
                    msg = viewModel.checkEmptyEditText(cowSizeEd,dongSize) + "동 사육 두수를 입력하세요";
                    Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
                } else if(viewModel.checkEmptyEditText(freeStallCountEd,dongSize) != -1){
                    msg = viewModel.checkEmptyEditText(freeStallCountEd,dongSize) + "동 프리스톨 수를 입력하세요";
                    Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
                } else {
                    freeStallCountQuestion.setDongSize(dongSize);
                    freeStallCountQuestion.setCowSize(viewModel.getIntEditTextValues(cowSizeEd,dongSize));
                    freeStallCountQuestion.setFreeStallCount(viewModel.getIntEditTextValues(freeStallCountEd, dongSize));
                    freeStallCountQuestion.setFreeStallCountRatio(
                            freeStallCountQuestion.calculatorRatio(
                                    freeStallCountQuestion.getCowSize(),
                                    freeStallCountQuestion.getFreeStallCount(),
                                    dongSize
                            )
                    );
                    freeStallCountQuestion.setFreeStallCountScore(
                            freeStallCountQuestion.calculatorScore(
                                    freeStallCountQuestion.getFreeStallCountRatio(),
                                    dongSize
                            )
                    );
                    freeStallCountQuestion.setLowestScore(
                            freeStallCountQuestion.calculatorLowestScore(
                                    freeStallCountQuestion.getFreeStallCountScore(),
                                    dongSize
                            )
                    );
                    freeStallCountQuestion.setLowestRatio(
                            freeStallCountQuestion.calculatorLowestRatio(
                                    freeStallCountQuestion.getFreeStallCountRatio(),
                                    dongSize
                            )
                    );


                    String msg = makeInputString(
                            freeStallCountQuestion.getFreeStallCountRatio(),
                            freeStallCountQuestion.getFreeStallCountScore(),
                            dongSize
                    );
                    String status;
                    if(freeStallCountQuestion.getLowestScore() == 100){
                        status = " (양호) ";
                    } else if(freeStallCountQuestion.getLowestScore() == 70){
                        status = " (경계) ";
                    } else {
                        status = " (미흡) ";
                    }
                    AlertDialog.Builder AlertBuilder = new AlertDialog.Builder(FreeStallCountDong.this);
                    AlertBuilder.setTitle("평가 결과");
                    AlertBuilder.setMessage(msg  + "\n" + "대표 점수  : " + freeStallCountQuestion.getLowestScore() + status + "\n" +
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
                            intent.putExtra("freeStallCountQuestion",freeStallCountQuestion);
                            setResult(1,intent);
                            finish();
                        }
                    });
                    AlertBuilder.show();
                }
            }
        });

    }





    private String makeInputString(double[] freeStallCountRatio, int[] freeStallCountScore,int dongSize){
        String[] inputStrings = new String[dongSize];
        String msg = "";
        for(int i = 0 ; i < dongSize ; i++){
            inputStrings[i] = (i+1) + "동 사육두수 대비 프리스톨 비율 : " + freeStallCountRatio[i] + "\n"
                    + "프리스톨 수 점수: " + freeStallCountScore[i] + "점 \n\n";
            msg += inputStrings[i];
        }
        return msg;
    }

}

