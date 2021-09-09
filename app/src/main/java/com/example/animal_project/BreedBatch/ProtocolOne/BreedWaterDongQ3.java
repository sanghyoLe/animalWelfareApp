package com.example.animal_project.BreedBatch.ProtocolOne;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProvider;

import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;

public class BreedWaterDongQ3 extends AppCompatActivity {
    private int dong_size;
    private QuestionTemplateViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.water_q3_dong);
        viewModel = new ViewModelProvider(this).get(QuestionTemplateViewModel.class);
        Intent intent = getIntent();
        dong_size = intent.getExtras().getInt("dong_count");

        View view = findViewById(R.id.breed_water_q3_dong_question_layout);
        ImageButton home_btn = view.findViewById(R.id.home_btn);

        Button standard_table_btn = findViewById(R.id.standard_table_btn);
        View question_1 = findViewById(R.id.breed_water_q3_dong_question_1);
        View question_2 = findViewById(R.id.breed_water_q3_dong_question_2);
        View question_3 = findViewById(R.id.breed_water_q3_dong_question_3);
        View question_4 = findViewById(R.id.breed_water_q3_dong_question_4);
        View question_5 = findViewById(R.id.breed_water_q3_dong_question_5);
        View question_6 = findViewById(R.id.breed_water_q3_dong_question_6);
        View question_7 = findViewById(R.id.breed_water_q3_dong_question_7);
        View question_8 = findViewById(R.id.breed_water_q3_dong_question_8);
        View question_9 = findViewById(R.id.breed_water_q3_dong_question_9);
        View question_10 = findViewById(R.id.breed_water_q3_dong_question_10);
        View question_11 = findViewById(R.id.breed_water_q3_dong_question_11);
        View question_12 = findViewById(R.id.breed_water_q3_dong_question_12);
        View question_13 = findViewById(R.id.breed_water_q3_dong_question_13);
        View question_14 = findViewById(R.id.breed_water_q3_dong_question_14);
        View question_15 = findViewById(R.id.breed_water_q3_dong_question_15);
        View question_16 = findViewById(R.id.breed_water_q3_dong_question_16);
        View question_17 = findViewById(R.id.breed_water_q3_dong_question_17);
        View question_18 = findViewById(R.id.breed_water_q3_dong_question_18);
        View question_19 = findViewById(R.id.breed_water_q3_dong_question_19);
        View question_20 = findViewById(R.id.breed_water_q3_dong_question_20);

        View[] questionViewArr = {
                question_1, question_2, question_3, question_4, question_5
                , question_6, question_7, question_8, question_9, question_10
                , question_11, question_12, question_13, question_14, question_15
                , question_16, question_17, question_18, question_19, question_20};

        standard_table_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerHandler();
            }
        });

        viewModel.showQuestionView(questionViewArr, dong_size);
        EditText[] penLocationOneEd = viewModel.makeEditText(questionViewArr,dong_size,R.id.pen_location_1_ed);
        EditText[] penLocationTwoEd = viewModel.makeEditText(questionViewArr,dong_size,R.id.pen_location_2_ed);
        EditText[] cowSizeEd = viewModel.makeEditText(questionViewArr,dong_size,R.id.cow_size_ed);
        EditText[] waitingCowSizeEd = viewModel.makeEditText(questionViewArr,dong_size,R.id.waiting_cow_size_ed);
        EditText[] drinkTimeEd = viewModel.makeEditText(questionViewArr,dong_size,R.id.drink_time_ed);
        QuestionTemplateViewModel.WaterTimeQuestion WaterTimeQuestion = new QuestionTemplateViewModel.WaterTimeQuestion(dong_size);
        Button endBtn = view.findViewById(R.id.end_btn);

        endBtn.setOnClickListener(new View.OnClickListener() {
            String msg;
            @Override
            public void onClick(View v) {
                if(viewModel.checkEmptyEditText(penLocationOneEd,dong_size) != -1){
                    msg = viewModel.checkEmptyEditText(penLocationOneEd,dong_size) + "동 펜 위치를 입력하세요";
                    Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
                }else if(viewModel.checkEmptyEditText(penLocationTwoEd,dong_size) != -1){
                    msg = viewModel.checkEmptyEditText(penLocationTwoEd,dong_size) + "동 펜 위치를 입력하세요";
                    Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
                } else if(viewModel.checkEmptyEditText(cowSizeEd,dong_size) != -1){
                    msg = viewModel.checkEmptyEditText(cowSizeEd,dong_size) + "동 사육 두수를 입력하세요";
                    Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
                } else if(viewModel.checkEmptyEditText(waitingCowSizeEd,dong_size) != -1){
                    msg = viewModel.checkEmptyEditText(waitingCowSizeEd,dong_size) + "동 대기우 수를 입력하세요";
                    Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
                }else if(viewModel.checkEmptyEditText(drinkTimeEd,dong_size) != -1){
                    msg = viewModel.checkEmptyEditText(drinkTimeEd,dong_size) + "동 음수 우 음수시간을 입력하세요";
                    Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
                }else if(checkGreaterThanCowSize(cowSizeEd,waitingCowSizeEd,dong_size) != -1) {
                    msg = checkGreaterThanCowSize(cowSizeEd,waitingCowSizeEd,dong_size) + "동의 대기우 수가 사육두수 보다 큽니다";
                    Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
                } else {
                    WaterTimeQuestion.setDongSize(dong_size);
                    WaterTimeQuestion.setPenLocation(viewModel.makePenLocationArr(penLocationOneEd,penLocationTwoEd,dong_size));
                    WaterTimeQuestion.setCowSize(viewModel.getIntEditTextValues(cowSizeEd,dong_size));
                    WaterTimeQuestion.setWaitingCowSize(viewModel.getIntEditTextValues(waitingCowSizeEd,dong_size));
                    WaterTimeQuestion.setDrinkTime(viewModel.getIntEditTextValues(drinkTimeEd,dong_size));
                    WaterTimeQuestion.setWaitingRatio(getWaitingRatio(cowSizeEd,waitingCowSizeEd,dong_size));
                    WaterTimeQuestion.setWaterTimeScore(getWaterTimeScore(
                            WaterTimeQuestion.getWaitingRatio(),
                            WaterTimeQuestion.getDrinkTime(),
                            dong_size
                    ));

                    WaterTimeQuestion.setMaxWaterTimeScore(
                            getMaxWaterTimeScore(
                                    WaterTimeQuestion.getWaterTimeScore(),
                                    dong_size)
                    );
                    String msg = makeInputString(
                            WaterTimeQuestion.getWaitingRatio(),
                            WaterTimeQuestion.getWaterTimeScore(),
                            dong_size
                    );

                    AlertDialog.Builder AlertBuilder = new AlertDialog.Builder(BreedWaterDongQ3.this);
                    AlertBuilder.setTitle("평가 결과");
                    AlertBuilder.setMessage(msg + "\n 대표 점수 : " + WaterTimeQuestion.getMaxWaterTimeScore() + "점 \n" +
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
                            intent.putExtra("waterTimeQuestion",WaterTimeQuestion);
                            setResult(1,intent);
                            finish();
                        }
                    });
                    AlertBuilder.show();
                }
            }
        });

    }

    private float[] getWaitingRatio(EditText[] cowSizeEd, EditText[] waitingCowEd,int dong_size) {
        float waitingRatio[] = new float[dong_size];
        for(int i = 0 ; i< dong_size ; i++){
            waitingRatio[i] = (Float.parseFloat(String.valueOf(waitingCowEd[i].getText())) /
                    Float.parseFloat(String.valueOf(cowSizeEd[i].getText()))) * 100;
            waitingRatio[i] = (float) viewModel.cutDecimal((double)waitingRatio[i]);

        }
        return waitingRatio;
    }

    private int[] getWaterTimeScore(float[] waitingRatio, int[] drinkTime,int dong_size) {
        int waterTimeScore[] = new int[dong_size];
        for(int i = 0 ;i < dong_size ; i++)
        {
           if(waitingRatio[i] == 0 && drinkTime[i] <= 5) {
               waterTimeScore[i] = 0;
           } else if(waitingRatio[i] <= 20 && drinkTime[i] <= 10){
               waterTimeScore[i] = 1;
           } else {
               waterTimeScore[i] = 2;
           }
        }
        return waterTimeScore;
    }
    private int getMaxWaterTimeScore(int[] waterTimeScore,int dong_size){
        int max = -1;
        for(int i = 0 ; i < dong_size ; i++){
            if(waterTimeScore[i] > max){
                max = waterTimeScore[i];
            }
        }
        return max;
    }

    public int checkGreaterThanCowSize(EditText[] cowSizes, EditText[] waitingCowSizes,int dong_size){
        for(int i = 0 ; i < dong_size ; i++){
            if(Integer.parseInt(String.valueOf(cowSizes[i].getText()))
                    < Integer.parseInt(String.valueOf(waitingCowSizes[i].getText()))){
                return i+1;
            }
        }
        return -1;
    }


    // 드로우 핸들러 ( 음수 행동 기준 표 )
    private void drawerHandler() {
        View view = findViewById(R.id.breed_water_q3_dong_question_layout);
        DrawerLayout drawer = (DrawerLayout) view.findViewById(R.id.drawer);
        if (!drawer.isDrawerOpen(Gravity.RIGHT)) {
            drawer.openDrawer(Gravity.RIGHT);
        } else if (drawer.isDrawerOpen(Gravity.RIGHT)) {
            drawer.closeDrawer(Gravity.RIGHT);
        }
    }
    private String makeInputString(float[] waitingRatio, int[] waterTimeScore,int dong_size){
        String[] inputStrings = new String[dong_size];
        String msg = "";
     for(int i = 0 ; i < dong_size ; i++){
         inputStrings[i] = (i+1) + "동 음수 대기우 비율 : " + waitingRatio[i] + "%\n"
                 + "음수 행동 점수 : " + waterTimeScore[i] + "점 \n\n";
         msg += inputStrings[i];
     }
     return msg;
    }

}

