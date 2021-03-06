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

public class BreedHarmonyDong extends AppCompatActivity {
    private int dong_size;
    private QuestionTemplateViewModel viewModel;
    @Override
    public void onBackPressed(){

        myOnBackPressed(new AlertDialog.Builder(BreedHarmonyDong.this));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.harmony_dong);
        viewModel = new ViewModelProvider(this).get(QuestionTemplateViewModel.class);

        Intent intent = getIntent();
        dong_size = intent.getExtras().getInt("dong_count");

        View view = findViewById(R.id.breed_harmony_dong_layout);
        ImageButton home_btn = view.findViewById(R.id.home_btn);
        View question_1 = findViewById(R.id.breed_harmony_dong_question_1);
        View question_2 = findViewById(R.id.breed_harmony_dong_question_2);
        View question_3 = findViewById(R.id.breed_harmony_dong_question_3);
        View question_4 = findViewById(R.id.breed_harmony_dong_question_4);
        View question_5 = findViewById(R.id.breed_harmony_dong_question_5);
        View question_6 = findViewById(R.id.breed_harmony_dong_question_6);
        View question_7 = findViewById(R.id.breed_harmony_dong_question_7);
        View question_8 = findViewById(R.id.breed_harmony_dong_question_8);
        View question_9 = findViewById(R.id.breed_harmony_dong_question_9);
        View question_10 = findViewById(R.id.breed_harmony_dong_question_10);
        View question_11 = findViewById(R.id.breed_harmony_dong_question_11);
        View question_12 = findViewById(R.id.breed_harmony_dong_question_12);
        View question_13 = findViewById(R.id.breed_harmony_dong_question_13);
        View question_14 = findViewById(R.id.breed_harmony_dong_question_14);
        View question_15 = findViewById(R.id.breed_harmony_dong_question_15);
        View question_16 = findViewById(R.id.breed_harmony_dong_question_16);
        View question_17 = findViewById(R.id.breed_harmony_dong_question_17);
        View question_18 = findViewById(R.id.breed_harmony_dong_question_18);
        View question_19 = findViewById(R.id.breed_harmony_dong_question_19);
        View question_20 = findViewById(R.id.breed_harmony_dong_question_20);

        View[] questionViewArr = {
                question_1, question_2, question_3, question_4, question_5
                , question_6, question_7, question_8, question_9, question_10
                , question_11, question_12, question_13, question_14, question_15
                , question_16, question_17, question_18, question_19, question_20};
        viewModel.showQuestionView(questionViewArr,dong_size);
        EditText[] penLocationOneEd = viewModel.makeEditText(questionViewArr,dong_size,R.id.pen_location_1_ed);
        EditText[] penLocationTwoEd = viewModel.makeEditText(questionViewArr,dong_size,R.id.pen_location_2_ed);
        EditText[] cowSizeEd = viewModel.makeEditText(questionViewArr,dong_size,R.id.cow_size_ed);
        EditText[] harmonyEd = viewModel.makeEditText(questionViewArr,dong_size,R.id.harmony_ed);
        Button end_btn = view.findViewById(R.id.end_btn);
        
        QuestionTemplateViewModel.BehaviorQuestion harmonyQuestion = new QuestionTemplateViewModel.BehaviorQuestion(dong_size);
        
        AlertDialog.Builder myAlterDialog = new AlertDialog.Builder(BreedHarmonyDong.this);
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
                } else if (viewModel.checkEmptyEditText(harmonyEd, dong_size) != -1) {
                    msg = viewModel.checkEmptyEditText(harmonyEd, dong_size) + "??? ?????? ?????? ?????? ???????????????";
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                } else {
                    harmonyQuestion.setDongSize(dong_size);
                    harmonyQuestion.setPenLocation(viewModel.makePenLocationArr(penLocationOneEd,penLocationTwoEd,dong_size));
                    harmonyQuestion.setCowSize(viewModel.getIntEditTextValues(cowSizeEd,dong_size));
                    harmonyQuestion.setBehaviorCount(viewModel.getIntEditTextValues(harmonyEd,dong_size));
                    harmonyQuestion.setBehaviorPerOne(
                            calHarmonyPerOne(
                                    harmonyQuestion.getCowSize(),
                                    harmonyQuestion.getBehaviorCount(),
                                    dong_size
                            )
                    );
                    float[] harmonyPerOne = harmonyQuestion.getBehaviorPerOne();
                    harmonyQuestion.setBehaviorPerOneAvg(
                            calHarmonyPerOneAvg(
                                    harmonyQuestion.getCowSize(),
                                    harmonyQuestion.getBehaviorCount(),
                                    dong_size
                            )
                    );

                    String msg = makeInputString(harmonyPerOne, dong_size);
                    AlertDialog.Builder AlterBuilder = new AlertDialog.Builder(BreedHarmonyDong.this);
                    AlterBuilder.setTitle("?????? ??????");
                    AlterBuilder.setMessage(msg + "\n"
                            +"?????? ?????? ?????? : " + harmonyQuestion.getBehaviorPerOneAvg() +"???"+" \n\n" +"????????? ?????????????????????????");
                    // ?????? ?????? (Ok ????????? Cancle ?????? )
                    AlterBuilder.setPositiveButton("??????", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    AlterBuilder.setNegativeButton("???", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent();
                            intent.putExtra("harmonyQuestion", harmonyQuestion);
                            setResult(1, intent);
                            finish();
                        }
                    });
                    AlterBuilder.show();


                }

            }
        });
    }
    private float[] calHarmonyPerOne(int[] cowSize, int[] harmonyEd,int dong_size){
        float[] harmonyPerOne = new float[dong_size];
        for(int i = 0 ; i< dong_size ; i++){
            harmonyPerOne[i] = (float)harmonyEd[i] / (float)cowSize[i];
            harmonyPerOne[i] = (float) viewModel.cutDecimal(harmonyPerOne[i]);
            harmonyPerOne[i] = harmonyPerOne[i] * 6;
            harmonyPerOne[i] = (float) viewModel.cutDecimal(harmonyPerOne[i]);
        }
        return harmonyPerOne;
    }
    private float calHarmonyPerOneAvg(int[] cowSize, int[] harmonyEd, int dong_size){
        float harmonyPerOneAvg;
        int totalCowSize = 0;
        float totalharmony = 0;
        for(int i = 0 ; i< dong_size ; i++){
            totalCowSize += cowSize[i];
            totalharmony += harmonyEd[i];
        }
        harmonyPerOneAvg = totalharmony / (float)totalCowSize;
        harmonyPerOneAvg = (float) viewModel.cutDecimal(harmonyPerOneAvg);
        harmonyPerOneAvg = harmonyPerOneAvg * 6;

        return (float)viewModel.cutDecimal(harmonyPerOneAvg);
    }
    private String makeInputString(float[] harmonyPerOne,int dong_size){
        String[] inputStrings = new String[dong_size];
        String msg = "";
        for(int i = 0 ; i < dong_size ; i++){
            inputStrings[i] = (i+1) + "??? \n1????????? 1?????? ?????? ?????? ?????? ??? : " + harmonyPerOne[i] + "???\n";
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