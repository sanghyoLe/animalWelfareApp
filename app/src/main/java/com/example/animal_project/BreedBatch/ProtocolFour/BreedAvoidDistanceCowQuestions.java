package com.example.animal_project.BreedBatch.ProtocolFour;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;

import org.w3c.dom.Text;

public class BreedAvoidDistanceCowQuestions extends AppCompatActivity {
    private int cow_size;
    private int pen_number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breed_avoid_distance_cow_questions);
        View mainView = findViewById(R.id.breed_avoid_distance_cow_question_layout);
        QuestionTemplateViewModel viewModel = new ViewModelProvider(this).get(QuestionTemplateViewModel.class);
        Intent intent = getIntent();
        int pen_number = intent.getExtras().getInt("pen_number");
        String pen_location = intent.getExtras().getString("pen_location");
        int cow_size = intent.getExtras().getInt("cow_count");

        QuestionTemplateViewModel.avoidDistance avoidDistance = new QuestionTemplateViewModel.avoidDistance(pen_number, pen_location, cow_size);

        Log.d("pen_number",String.valueOf(avoidDistance.getPenNumber()));
        Log.d("pen_location",String.valueOf(avoidDistance.getPenLocation()));
        Log.d("cow_size",String.valueOf(avoidDistance.getCowSize()));
        avoidDistance.setCowFieldSize(cow_size);


        TextView pen_number_tv = mainView.findViewById(R.id.pen_number_tv);
        TextView pen_location_tv = mainView.findViewById(R.id.pen_location_tv);
        TextView pen_cow_count_tv = mainView.findViewById(R.id.pen_cow_count_tv);

        pen_number_tv.setText("표본펜 " + String.valueOf(pen_number) +"번");
        pen_location_tv.setText("위치 " + pen_location);
        pen_cow_count_tv.setText("개체수 " + String.valueOf(cow_size)+"마리");
        View view = findViewById(R.id.breed_avoid_distance_cow_question_layout);


        Button standard_table_btn = findViewById(R.id.standard_table_btn);
        View question_1 = findViewById(R.id.breed_avoid_distance_cow_question_1);
        View question_2 = findViewById(R.id.breed_avoid_distance_cow_question_2);
        View question_3 = findViewById(R.id.breed_avoid_distance_cow_question_3);
        View question_4 = findViewById(R.id.breed_avoid_distance_cow_question_4);
        View question_5 = findViewById(R.id.breed_avoid_distance_cow_question_5);
        View question_6 = findViewById(R.id.breed_avoid_distance_cow_question_6);
        View question_7 = findViewById(R.id.breed_avoid_distance_cow_question_7);
        View question_8 = findViewById(R.id.breed_avoid_distance_cow_question_8);
        View question_9 = findViewById(R.id.breed_avoid_distance_cow_question_9);
        View question_10 = findViewById(R.id.breed_avoid_distance_cow_question_10);
        View question_11 = findViewById(R.id.breed_avoid_distance_cow_question_11);
        View question_12 = findViewById(R.id.breed_avoid_distance_cow_question_12);
        View question_13 = findViewById(R.id.breed_avoid_distance_cow_question_13);
        View question_14 = findViewById(R.id.breed_avoid_distance_cow_question_14);
        View question_15 = findViewById(R.id.breed_avoid_distance_cow_question_15);
        View question_16 = findViewById(R.id.breed_avoid_distance_cow_question_16);
        View question_17 = findViewById(R.id.breed_avoid_distance_cow_question_17);
        View question_18 = findViewById(R.id.breed_avoid_distance_cow_question_18);
        View question_19 = findViewById(R.id.breed_avoid_distance_cow_question_19);
        View question_20 = findViewById(R.id.breed_avoid_distance_cow_question_20);
        View question_21 = findViewById(R.id.breed_avoid_distance_cow_question_21);
        View question_22 = findViewById(R.id.breed_avoid_distance_cow_question_22);
        View question_23 = findViewById(R.id.breed_avoid_distance_cow_question_23);
        View question_24 = findViewById(R.id.breed_avoid_distance_cow_question_24);
        View question_25 = findViewById(R.id.breed_avoid_distance_cow_question_25);
        View question_26 = findViewById(R.id.breed_avoid_distance_cow_question_26);
        View question_27 = findViewById(R.id.breed_avoid_distance_cow_question_27);
        View question_28 = findViewById(R.id.breed_avoid_distance_cow_question_28);
        View question_29 = findViewById(R.id.breed_avoid_distance_cow_question_29);
        View question_30 = findViewById(R.id.breed_avoid_distance_cow_question_30);
        View question_31 = findViewById(R.id.breed_avoid_distance_cow_question_31);
        View question_32 = findViewById(R.id.breed_avoid_distance_cow_question_32);
        View question_33 = findViewById(R.id.breed_avoid_distance_cow_question_33);
        View question_34 = findViewById(R.id.breed_avoid_distance_cow_question_34);
        View question_35 = findViewById(R.id.breed_avoid_distance_cow_question_35);
        View question_36 = findViewById(R.id.breed_avoid_distance_cow_question_36);
        View question_37 = findViewById(R.id.breed_avoid_distance_cow_question_37);
        View question_38 = findViewById(R.id.breed_avoid_distance_cow_question_38);
        View question_39 = findViewById(R.id.breed_avoid_distance_cow_question_39);
        View question_40 = findViewById(R.id.breed_avoid_distance_cow_question_40);
        View question_41 = findViewById(R.id.breed_avoid_distance_cow_question_41);
        View question_42 = findViewById(R.id.breed_avoid_distance_cow_question_42);
        View question_43 = findViewById(R.id.breed_avoid_distance_cow_question_43);
        View question_44 = findViewById(R.id.breed_avoid_distance_cow_question_44);
        View question_45 = findViewById(R.id.breed_avoid_distance_cow_question_45);
        View question_46 = findViewById(R.id.breed_avoid_distance_cow_question_46);
        View question_47 = findViewById(R.id.breed_avoid_distance_cow_question_47);
        View question_48 = findViewById(R.id.breed_avoid_distance_cow_question_48);
        View question_49 = findViewById(R.id.breed_avoid_distance_cow_question_49);
        View question_50 = findViewById(R.id.breed_avoid_distance_cow_question_50);


        View[] questionViewArr = {
                question_1,question_2,question_3,question_4,question_5
                ,question_6,question_7,question_8,question_9,question_10
                ,question_11,question_12,question_13,question_14,question_15
                ,question_16,question_17,question_18,question_19,question_20
                ,question_21,question_22,question_23,question_24,question_25
                ,question_26,question_27,question_28,question_29,question_30
                ,question_31,question_32,question_33,question_34,question_35
                ,question_36,question_37,question_38,question_39,question_40,
                question_41,question_42,question_43,question_44,question_45
                ,question_46,question_47,question_48,question_49,question_50};

        ArrayAdapter spinnerAdapterQuestion = ArrayAdapter.createFromResource(getApplicationContext(),
                R.array.avoid_distance_question,
                android.R.layout.simple_dropdown_item_1line);
        spinnerAdapterQuestion.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        EditText[] cowNumberEd = makeCowNumberEd(questionViewArr,cow_size);
        Spinner[] spinners = makeSpinner(questionViewArr,spinnerAdapterQuestion,cow_size);
        showQuestionView(questionViewArr,cow_size);
        Button end_btn = view.findViewById(R.id.end_btn);


        int[] cowNumbers = new int[cow_size];
        // 체크한 스피너 문항 저장
        final int[] avoidDistanceAnswer = new int[cow_size];
        for(int i = 0 ; i < cow_size ; i++){
            int finalI = i;
            spinners[i].setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    // 선택된 데이터 값
                    String selectedItem = parent.getSelectedItem().toString();
                    // 선택된 데이터 위치( 0 부터 )
                    avoidDistanceAnswer[finalI] = position;

                }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    avoidDistanceAnswer[finalI] = 0;
                }
            });
        }

        // 개체번호, 회피 수준 빈곳 있는지 체크하고, 없으면 결과 값 이전 액티비티로 객체 전달
        /* 객체 생성할 때 이전 액티비티에서 받은 표본펜 순번, 표본펜 위치, 펜별 마릿수로
         객체 생성하고, 그 객체에 입력받은 값들 저장후 전달 */
        end_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkEmptyEditText(cowNumberEd,cow_size) == false
                        && checkEmptySpinner(avoidDistanceAnswer,cow_size) == false){
                    AlertDialog.Builder myAlertBuilder =
                            new AlertDialog.Builder(BreedAvoidDistanceCowQuestions.this);
                    myAlertBuilder.setTitle("이전");
                    myAlertBuilder.setMessage("평가를 완료한 문항은\n" +
                            "다시 입력하실 수 없습니다. \n" +
                            "완료하시겠습니까? ");
                    // 버튼 추가 (네 버튼과 취소 버튼 )
                    myAlertBuilder.setPositiveButton("취소",new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface dialog,int which){
                            // 취소 버튼
                        }
                    });
                    myAlertBuilder.setNegativeButton("네", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            makeCowNumbers(cowNumberEd,cow_size,cowNumbers);
                            avoidDistance.setCowCount(cow_size);
                            avoidDistance.setCowNumber(cowNumbers);
                            avoidDistance.setAvoidDistance(avoidDistanceAnswer);
                            Intent intent = new Intent();
                            intent.putExtra("pen_number", pen_number);
                            intent.putExtra("avoidDistance",  avoidDistance);
                            setResult(1,intent);
                            finish();
                        }
                    });
                    myAlertBuilder.show();
                }




            }
        });

        // 기준표 Button 누를 시 DrawHandler 작동
        standard_table_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerHandler();
            }
        });
    }

    // Spinner cow_size에 맞춰 반환
    public Spinner[] makeSpinner(View[] QuestionViewArr, ArrayAdapter spinnerAdapter,int cow_size) {
        Spinner[] SpinnerArr = new Spinner[cow_size];
        for (int i = 0; i < cow_size ; i++) {
            SpinnerArr[i] = QuestionViewArr[i].findViewById(R.id.avoid_distance_question_spinner);
            SpinnerArr[i].setAdapter(spinnerAdapter);
        }
        return SpinnerArr;
    }
    // EditText cow_size에 맞춰 반환
    private EditText[] makeCowNumberEd(View[] QuestionViewArr, int cow_size){
        EditText[] edArr = new EditText[cow_size];
        for(int i = 0 ; i < cow_size ; i++){
            edArr[i] = QuestionViewArr[i].findViewById(R.id.cow_number_ed);
        }
        return edArr;

    }
    // 질문 항목 cow_size에 맞게 보여주기
    public void showQuestionView(View[] QuestionViewArr, int cow_size) {
        TextView[] tvArr = new TextView[50];
        for (int i = 0; i < 50; i++) {
            tvArr[i] = QuestionViewArr[i].findViewById(R.id.cow_count_tv);
            QuestionViewArr[i].setVisibility(View.GONE);
            tvArr[i].setText(String.valueOf(i + 1));
        }
        for (int i = 0; i < cow_size; i++) {
            QuestionViewArr[i].setVisibility(View.VISIBLE);
        }
    }

    // 드로우 핸들러 ( 회피 거리 기준 표 )
    private void drawerHandler(){
        View view = findViewById(R.id.breed_avoid_distance_cow_question_layout);
        DrawerLayout drawer = (DrawerLayout) view.findViewById(R.id.drawer);
        if(!drawer.isDrawerOpen(Gravity.RIGHT)){
            drawer.openDrawer(Gravity.RIGHT);
        } else if(drawer.isDrawerOpen(Gravity.RIGHT)){
            drawer.closeDrawer(Gravity.RIGHT);
        }
    }


    // 개체 번호 EditText 빈 부분 Check 해서 Toast 메시지
    private boolean checkEmptyEditText(EditText[] cowNumberEdArr, int cow_size){
                for(int i = 0 ;i < cow_size ; i++){
                    if(TextUtils.isEmpty(cowNumberEdArr[i].getText())){
                        String msg = (i + 1)  + "번 개체 번호를 입력하세요";
                        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
                        return true;
                    }
                }
                return false;
    }

    // 개체 회피 수준 평가 선택 Check 해서 Toast 메시지
    private boolean checkEmptySpinner(int[] selectedItemIndex, int cow_size){
        for(int i = 0 ; i < cow_size ; i++){
            Log.d("12",String.valueOf(selectedItemIndex[i]));
            if(selectedItemIndex[i] == 0){
                String msg = (i+1) + "번 개체 회피 수준을 선택하세요";
                Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
                return true;
            }
        }
        return false;
    }
    private void makeCowNumbers(EditText[] edArr, int cow_size, int[] cowNumbers){
        for(int i = 0 ; i < cow_size ; i++) {
            cowNumbers[i] = Integer.parseInt(String.valueOf(edArr[i].getText()));
        }
    }




}