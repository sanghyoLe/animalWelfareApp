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

public class MilkCowStruggleDong extends AppCompatActivity {
    private int dong_size;
    private QuestionTemplateViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.milk_cow_struggle_dong);
        viewModel = new ViewModelProvider(this).get(QuestionTemplateViewModel.class);

        Intent intent = getIntent();
        dong_size = intent.getExtras().getInt("dong_count");

        View view = findViewById(R.id.milk_cow_struggle_dong_layout);



        View question_1 = findViewById(R.id.milk_cow_struggle_dong_question_1);
        View question_2 = findViewById(R.id.milk_cow_struggle_dong_question_2);
        View question_3 = findViewById(R.id.milk_cow_struggle_dong_question_3);
        View question_4 = findViewById(R.id.milk_cow_struggle_dong_question_4);
        View question_5 = findViewById(R.id.milk_cow_struggle_dong_question_5);
        View question_6 = findViewById(R.id.milk_cow_struggle_dong_question_6);
        View question_7 = findViewById(R.id.milk_cow_struggle_dong_question_7);
        View question_8 = findViewById(R.id.milk_cow_struggle_dong_question_8);
        View question_9 = findViewById(R.id.milk_cow_struggle_dong_question_9);
        View question_10 = findViewById(R.id.milk_cow_struggle_dong_question_10);
        View question_11 = findViewById(R.id.milk_cow_struggle_dong_question_11);
        View question_12 = findViewById(R.id.milk_cow_struggle_dong_question_12);


        ImageButton home_btn = view.findViewById(R.id.home_btn);
        View[] questionViewArr = {
                question_1, question_2, question_3, question_4, question_5
                , question_6, question_7, question_8, question_9, question_10
                , question_11, question_12 };
        viewModel.showQuestionView(questionViewArr,dong_size);
        EditText[] penLocationOneEd = viewModel.makeEditText(questionViewArr,dong_size,R.id.pen_location_1_ed);
        EditText[] penLocationTwoEd = viewModel.makeEditText(questionViewArr,dong_size,R.id.pen_location_2_ed);
        EditText[] cowSizeEd = viewModel.makeEditText(questionViewArr,dong_size,R.id.cow_size_ed);
        EditText[] headBangFreqEd = viewModel.makeEditText(questionViewArr,dong_size,R.id.head_bang_freq_ed);
        EditText[] headBangExceptStruggle = viewModel.makeEditText(questionViewArr,dong_size,R.id.head_bang_except_ed);
        Button end_btn = view.findViewById(R.id.end_btn);



        // 완료 버튼
        QuestionTemplateViewModel.MilkCowStruggleQuestion milkCowStruggleQuestion
                = new QuestionTemplateViewModel.MilkCowStruggleQuestion(dong_size);


        AlertDialog.Builder myAlterDialog = new AlertDialog.Builder(MilkCowStruggleDong.this);
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
                } else if (viewModel.checkEmptyEditText(headBangFreqEd, dong_size) != -1) {
                    msg = viewModel.checkEmptyEditText(headBangFreqEd, dong_size) + "동 머리 박치기 빈도를 입력하세요";
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                } else if (viewModel.checkEmptyEditText(headBangExceptStruggle, dong_size) != -1) {
                    msg = viewModel.checkEmptyEditText(headBangExceptStruggle, dong_size) + "동 머리박치기 제외 투쟁 행동 빈도를 입력하세요";
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                } else {
                    milkCowStruggleQuestion.setDongSize(dong_size);
                    milkCowStruggleQuestion.setPenLocation(viewModel.makePenLocationArr(penLocationOneEd,penLocationTwoEd,dong_size));
                    milkCowStruggleQuestion.setCowSize(viewModel.getIntEditTextValues(cowSizeEd,dong_size));
                    // 착유우는 머리박치기 제외 빈도 수
                    milkCowStruggleQuestion.setHeadBangExceptStruggleCount(viewModel.getIntEditTextValues(headBangExceptStruggle,dong_size));
                    milkCowStruggleQuestion.setHeadBangExceptStrugglePerOne(
                            calStrugglePerOne(
                                    milkCowStruggleQuestion.getCowSize(),
                                    milkCowStruggleQuestion.getHeadBangExceptStruggleCount(),
                                    dong_size
                            )
                    );

                    milkCowStruggleQuestion.setHeadBangExceptStrugglePerOneAvg(
                            calStrugglePerOneAvg(
                                    milkCowStruggleQuestion.getCowSize(),
                                    milkCowStruggleQuestion.getHeadBangExceptStruggleCount(),
                                    dong_size
                            )
                    );

                    // 머리 박치기
                    milkCowStruggleQuestion.setHeadBangCount(viewModel.getIntEditTextValues(headBangFreqEd,dong_size));
                    milkCowStruggleQuestion.setHeadBangPerOne(
                            calStrugglePerOne(
                             milkCowStruggleQuestion.getCowSize(),
                             milkCowStruggleQuestion.getHeadBangCount(),
                             dong_size
                            )
                    );
                    milkCowStruggleQuestion.setHeadBangPerOneAvg(
                            calStrugglePerOneAvg(
                                    milkCowStruggleQuestion.getCowSize(),
                                    milkCowStruggleQuestion.getHeadBangCount(),
                                    dong_size
                            )
                    );
                    if(milkCowStruggleQuestion.getHeadBangPerOneAvg() >= 1.6){
                        milkCowStruggleQuestion.setHeadBangPerOneAvg((float)1.6);
                    }
                    if(milkCowStruggleQuestion.getHeadBangExceptStrugglePerOneAvg() >= 3.4){
                        milkCowStruggleQuestion.setHeadBangExceptStrugglePerOneAvg((float)3.4);
                    }
                    milkCowStruggleQuestion.setStruggleIndex(
                            milkCowStruggleQuestion.calculatorStruggleIndex(
                            milkCowStruggleQuestion.getHeadBangPerOneAvg(),
                            milkCowStruggleQuestion.getHeadBangExceptStrugglePerOneAvg()
                            )
                    );

//                    String msg = makeInputString(strugglePerOne, dong_size);
                    AlertDialog.Builder AlterBuilder = new AlertDialog.Builder(MilkCowStruggleDong.this);
                    AlterBuilder.setTitle("평과 결과");
                    AlterBuilder.setMessage(
                            "머리박치기 평균 : " + milkCowStruggleQuestion.getHeadBangPerOneAvg() +"번"+" \n"
                            +"머리박치기 제외 투쟁행동 평균 : " + milkCowStruggleQuestion.getHeadBangExceptStrugglePerOneAvg() +"번" +"\n"
                            +"투쟁행동 지수 : " + milkCowStruggleQuestion.getStruggleIndex());
                    // 버튼 추가 (Ok 버튼과 Cancle 버튼 )
                    AlterBuilder.setPositiveButton("취소", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    AlterBuilder.setNegativeButton("네", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent();
                            intent.putExtra("milkCowStruggleQuestion", milkCowStruggleQuestion);
                            setResult(2, intent);
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
