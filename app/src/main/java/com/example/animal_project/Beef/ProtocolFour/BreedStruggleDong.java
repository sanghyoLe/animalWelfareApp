package com.example.animal_project.Beef.ProtocolFour;

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

import com.example.animal_project.Beef.ProtocolTwo.BreedStrawDong;
import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;

public class BreedStruggleDong extends AppCompatActivity {
    private int dong_size;
    private QuestionTemplateViewModel viewModel;
    @Override
    public void onBackPressed(){

        myOnBackPressed(new AlertDialog.Builder(BreedStruggleDong.this));
    }
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


        ImageButton home_btn = view.findViewById(R.id.home_btn);
        View[] questionViewArr = {
                question_1, question_2, question_3, question_4, question_5
                , question_6, question_7, question_8, question_9, question_10
                , question_11, question_12 };
        viewModel.showQuestionView(questionViewArr,dong_size);
        EditText[] penLocationOneEd = viewModel.makeEditText(questionViewArr,dong_size,R.id.pen_location_1_ed);
        EditText[] penLocationTwoEd = viewModel.makeEditText(questionViewArr,dong_size,R.id.pen_location_2_ed);
        EditText[] cowSizeEd = viewModel.makeEditText(questionViewArr,dong_size,R.id.cow_size_ed);
        EditText[] struggleEd = viewModel.makeEditText(questionViewArr,dong_size,R.id.struggle_ed);
        Button end_btn = view.findViewById(R.id.end_btn);



        // ?????? ??????
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
                    msg = viewModel.checkEmptyEditText(penLocationOneEd, dong_size) + "??? ??? ????????? ???????????????";
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                } else if (viewModel.checkEmptyEditText(penLocationTwoEd, dong_size) != -1) {
                    msg = viewModel.checkEmptyEditText(penLocationTwoEd, dong_size) + "??? ??? ????????? ???????????????";
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                } else if (viewModel.checkEmptyEditText(cowSizeEd, dong_size) != -1) {
                    msg = viewModel.checkEmptyEditText(cowSizeEd, dong_size) + "??? ?????? ????????? ???????????????";
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                } else if (viewModel.checkEmptyEditText(struggleEd, dong_size) != -1) {
                    msg = viewModel.checkEmptyEditText(struggleEd, dong_size) + "??? ?????? ?????? ?????? ???????????????";
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
                    AlterBuilder.setTitle("?????? ??????");
                    AlterBuilder.setMessage(msg + "\n"
                    +"?????? ?????? ?????? : " + struggleQuestion.getBehaviorPerOneAvg() +"???"+" \n\n" +"????????? ?????????????????????????");
                    // ?????? ?????? (Ok ????????? Cancle ?????? )
                    AlterBuilder.setPositiveButton("??????", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    AlterBuilder.setNegativeButton("???", new DialogInterface.OnClickListener() {
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
            inputStrings[i] = (i+1) + "??? \n1????????? 1?????? ?????? ?????? ?????? ??? : " + strugglePerOne[i] + "???\n";
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