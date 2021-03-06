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



        // ?????? ??????
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
                    msg = viewModel.checkEmptyEditText(penLocationOneEd, dong_size) + "??? ??? ????????? ???????????????";
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                } else if (viewModel.checkEmptyEditText(penLocationTwoEd, dong_size) != -1) {
                    msg = viewModel.checkEmptyEditText(penLocationTwoEd, dong_size) + "??? ??? ????????? ???????????????";
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                } else if (viewModel.checkEmptyEditText(cowSizeEd, dong_size) != -1) {
                    msg = viewModel.checkEmptyEditText(cowSizeEd, dong_size) + "??? ?????? ????????? ???????????????";
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                } else if (viewModel.checkEmptyEditText(headBangFreqEd, dong_size) != -1) {
                    msg = viewModel.checkEmptyEditText(headBangFreqEd, dong_size) + "??? ?????? ????????? ????????? ???????????????";
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                } else if (viewModel.checkEmptyEditText(headBangExceptStruggle, dong_size) != -1) {
                    msg = viewModel.checkEmptyEditText(headBangExceptStruggle, dong_size) + "??? ??????????????? ?????? ?????? ?????? ????????? ???????????????";
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                } else {
                    milkCowStruggleQuestion.setDongSize(dong_size);
                    milkCowStruggleQuestion.setPenLocation(viewModel.makePenLocationArr(penLocationOneEd,penLocationTwoEd,dong_size));
                    milkCowStruggleQuestion.setCowSize(viewModel.getIntEditTextValues(cowSizeEd,dong_size));
                    // ???????????? ??????????????? ?????? ?????? ???
                    milkCowStruggleQuestion.setHeadBangExceptStruggleCount(viewModel.getIntEditTextValues(headBangExceptStruggle,dong_size));
                    milkCowStruggleQuestion.setHeadBangCount(viewModel.getIntEditTextValues(headBangFreqEd,dong_size));
                    milkCowStruggleQuestion.setHeadBangExceptStrugglePerOne(
                            calStrugglePerOne(
                                    milkCowStruggleQuestion.getCowSize(),
                                    milkCowStruggleQuestion.getHeadBangExceptStruggleCount(),
                                    dong_size
                            )
                    );
                    milkCowStruggleQuestion.setHeadBangPerOne(
                            calStrugglePerOne(
                                    milkCowStruggleQuestion.getCowSize(),
                                    milkCowStruggleQuestion.getHeadBangCount(),
                                    dong_size
                            )
                    );
                    float[] headBangPerOne = milkCowStruggleQuestion.getHeadBangPerOne();
                    float[] headBangExceptPerOne = milkCowStruggleQuestion.getHeadBangExceptStrugglePerOne();
                    for(int i = 0 ; i < dong_size ; i++){
                        if(headBangPerOne[i] >= 1.6){
                            headBangPerOne[i] = (float)1.6;
                        }
                        if(headBangExceptPerOne[i] >= 3.4){
                            headBangExceptPerOne[i] = (float)3.4;
                        }
                    }
                    milkCowStruggleQuestion.setHeadBangPerOne(headBangPerOne);
                    milkCowStruggleQuestion.setHeadBangExceptStrugglePerOne(headBangExceptPerOne);






                    float[] struggleIndex = new float[dong_size];
                    for(int i = 0 ; i < dong_size ; i++) {
                        struggleIndex[i] = milkCowStruggleQuestion.calculatorStruggleIndex(
                                headBangPerOne[i],
                                headBangExceptPerOne[i]
                        );
                    }

                    milkCowStruggleQuestion.setStruggleIndex(struggleIndex);
                    milkCowStruggleQuestion.setStruggleIndexAvg(
                            calStruggleIndexAvg(
                                    milkCowStruggleQuestion.getStruggleIndex(),
                                    dong_size
                            )
                    );
                    float[] scores = new float[50];
                    for(int i = 0 ; i < dong_size; i++){
                        scores[i] = milkCowStruggleQuestion.calculatorScore(struggleIndex[i]);
                    }
                    milkCowStruggleQuestion.setScore(scores);

//                    String msg = makeInputString(strugglePerOne, dong_size);
                    AlertDialog.Builder AlterBuilder = new AlertDialog.Builder(MilkCowStruggleDong.this);
                    AlterBuilder.setTitle("?????? ??????");
                    String msg = makeInputString(
                            milkCowStruggleQuestion.getStruggleIndex(),
                            dong_size
                    );
                    AlterBuilder.setMessage(
                            msg + "\n"
                            +"???????????? ?????? ?????? : " + milkCowStruggleQuestion.getStruggleIndexAvg());
                    // ?????? ?????? (Ok ????????? Cancle ?????? )
                    AlterBuilder.setPositiveButton("??????", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    AlterBuilder.setNegativeButton("???", new DialogInterface.OnClickListener() {
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
    private float calStruggleIndexAvg(float[] struggleIndex, int dongSize){
        float struggleIndexTotal= 0 ;
        for (int i = 0; i< dongSize ; i++){
            struggleIndexTotal += struggleIndex[i];
        }
        struggleIndexTotal = struggleIndexTotal / (float) dongSize;
        return struggleIndexTotal;
    }
    private String makeInputString(float[] struggleIndex,int dong_size){
        String[] inputStrings = new String[dong_size];
        String msg = "";
        for(int i = 0 ; i < dong_size ; i++){
            inputStrings[i] = (i+1) + "??? \n1????????? 1?????? ?????? ???????????? ?????? : " + struggleIndex[i] + "\n\n";
            msg += inputStrings[i];
        }
        return msg;
    }
    public void myOnBackPressed(AlertDialog.Builder AlertBuilder){

        AlertBuilder.setTitle("??????");
        AlertBuilder.setMessage("???????????? ????????? ????????? ???????????????.\n" +
                "?????? ???????????? ?????????????????????????");
        // ?????? ?????? (Ok ????????? Cancle ?????? )
        AlertBuilder.setPositiveButton("??????",new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog,int which){
                // OK ????????? ????????? ??????

            }
        });
        AlertBuilder.setNegativeButton("???", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        AlertBuilder.show();
    }
}
