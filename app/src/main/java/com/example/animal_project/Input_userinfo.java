package com.example.animal_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;

import android.util.Log;
import android.view.MotionEvent;

import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import android.widget.Toast;




public class Input_userinfo extends AppCompatActivity {
    public static Context context_userinfo;
    public String result;
    public String total_cow_count;
    public String sample_size_count;
    private static final int SEARCH_ADDRESS_ACTIVITY = 10000;
    private int input_checked = 0;
    private Button beef_btn;
    private Button milk_cow_btn;
    private LinearLayout beef_group;
    private LinearLayout milk_cow_group;



    private EditText farm_name_et;
    private EditText address_et;
    private EditText address_detail_et;
    private EditText farm_rep_name_et;
    private EditText total_adult_cow_et;
    private EditText total_child_cow_et;
    private EditText eva_name_et;
    private DatePicker eva_data_picker;


    private QuestionTemplate Qt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_userinfo);

        context_userinfo = this;

        beef_btn = findViewById(R.id.beef_btn);
        milk_cow_btn = findViewById(R.id.milk_cow_btn);

        beef_group = findViewById(R.id.beef_group);
        milk_cow_group = findViewById(R.id.milk_cow_group);

        Button farm_selector = (Button) findViewById(R.id.farm_selector); //농장 선택
        RadioGroup input_farm_beef = (RadioGroup) findViewById(R.id.input_farm_beef);
        RadioGroup input_farm_milk_cow = (RadioGroup) findViewById(R.id.input_farm_milk_cow);
        EditText total_cow_et = (EditText)findViewById(R.id.total_cow); //전체 두수
        TextView sample_size = (TextView)findViewById(R.id.sample_size); //표본 규모
        farm_name_et = findViewById(R.id.farm_name);
        address_detail_et = findViewById(R.id.et_address_detail);
        farm_rep_name_et = findViewById(R.id.farm_rep);
        total_adult_cow_et = findViewById(R.id.total_adult_cow);
        total_child_cow_et = findViewById(R.id.total_child_cow);
        eva_name_et = findViewById(R.id.eva_name);
        eva_data_picker = findViewById(R.id.eva_date_picker);


        // 한육우 라디오 그룹 클릭 시
        input_farm_beef.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                /*if (checkedId == R.id.input_1) { // 비육 농장
                    input_checked = 1;
                }*/
                if (checkedId == R.id.input_2) { // 번식 농장
                    input_checked = 2;
/*                } else if (checkedId == R.id.input_3) { // 일괄 사육 농장
                    input_checked = 3;
                }*/
                }
            }
        });

        // 착유우 라디오 그룹 클릭 시
        input_farm_milk_cow.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
               /* if (checkedId == R.id.input_4) { // 젖소 일반 우사
                    input_checked = 4;
                }*/ if (checkedId == R.id.input_5) { // 젖소 프리스톨 우사
                    input_checked = 5;
                }
            }
        });

        // 평가하기 버튼 눌렀을 때
        farm_selector.setOnClickListener(new View.OnClickListener() {
            String msg;
            @Override
            public void onClick(View v) {
                // 사용자가 모든 정보를 입력하였는지 확인
/*                if(TextUtils.isEmpty(farm_name_et.getText())){
                    msg = "농장명을 입력하세요";
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                } else if(TextUtils.isEmpty(address_et.getText())){
                    msg = "주소를 입력하세요";
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                } else if(TextUtils.isEmpty(address_detail_et.getText())) {
                    msg = "상세 주소를 입력하세요";
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                } else if(TextUtils.isEmpty(farm_rep_name_et.getText())){
                    msg = "대표자명을 입력하세요";
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                } else if(input_checked == 0){
                    msg = "농장 종류를 선택하세요";
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                } else if(TextUtils.isEmpty(total_cow_et.getText())){
                    msg = "총 두수를 입력하세요";
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                } else if(TextUtils.isEmpty(total_adult_cow_et.getText())){
                    msg = "성우 두수를 입력하세요";
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                } else if(TextUtils.isEmpty(total_child_cow_et.getText())){
                    msg = "송아지 두수를 입력하세요";
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                } else if(TextUtils.isEmpty(eva_name_et.getText())){
                    msg = "평가자명을 입력하세요";
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                }
                // 모든 정보를 입력하였을 때
                else {
                    AlertDialog.Builder AlertBuilder = new AlertDialog.Builder(Input_userinfo.this);
                    CheckInputInformation(
                            AlertBuilder,
                            String.valueOf(farm_name_et.getText()),
                            String.valueOf(address_et.getText()),
                            String.valueOf(address_detail_et.getText()),
                            String.valueOf(farm_rep_name_et.getText()),
                            Integer.parseInt(String.valueOf(total_cow_et.getText())),
                            Integer.parseInt(String.valueOf(total_adult_cow_et.getText())),
                            Integer.parseInt(String.valueOf(total_child_cow_et.getText())),
                            Integer.parseInt(String.valueOf(sample_size_count)),
                            String.valueOf(eva_name_et.getText()),
                            eva_data_picker.getYear(),
                            eva_data_picker.getMonth(),
                            eva_data_picker.getDayOfMonth(), input_checked
                            );
                }*/
                // 테스트 용 코드 위에 조건문 주석 걸고 실행
                if(input_checked == 0) {
                    String msg = "농장 종류 선택";
                    Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
                }else {
                    Intent intentQuestionTemplate = new Intent(Input_userinfo.this, QuestionTemplate.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("totalCow",Integer.parseInt(total_cow_count));
                    bundle.putInt("sampleCowSize",Integer.parseInt(sample_size_count));
                    bundle.putInt("farmType",input_checked);
                    intentQuestionTemplate.putExtras(bundle);
                    startActivity(intentQuestionTemplate);
                }
                // --------------------------------------------------
            }
        });



        total_cow_et.addTextChangedListener(new TextWatcher(){
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable arg0) {
                if(TextUtils.isEmpty(total_cow_et.getText().toString())) {
                    sample_size.setText("값을 입력해주세요");
                } else {
                    result = getSampleSizeScore(total_cow_et.getText().toString());
                    sample_size.setText(result);
                    total_cow_count = total_cow_et.getText().toString();
                    sample_size_count = result;
                }
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
        });

        // 주소 입력을 위한 창
        address_et = (EditText) findViewById(R.id.et_address);

/*        if (address_et != null) {
            address_et.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event)
                {
                    if(event.getAction() == MotionEvent.ACTION_UP) {
                        Intent i = new Intent(Input_userinfo.this, com.example.animal_project.WebViewActivity.class);
                        startActivityForResult(i, SEARCH_ADDRESS_ACTIVITY);
                        return true;
                    }
                    return false;
                }
            });
        }*/
    }

    // 주소지 결과 창
    public void onActivityResult(int requestCode, int resultCode, Intent intent)
    {
        super.onActivityResult(requestCode, resultCode, intent);
        switch (requestCode) {
            case SEARCH_ADDRESS_ACTIVITY:
                if (resultCode == RESULT_OK) {
                    String data = intent.getExtras().getString("data");
                    if (data != null) {
                        address_et.setText(data);
                    }
                }
                break;
        }
    }
    //--------------------------------

    public String getSampleSizeScore(String inputVal){
        int inputIntval = Integer.parseInt(inputVal);

        if(inputIntval <= 30){
            return "30";
        } else if(inputIntval <= 40){
            return "30";
        }  else if(inputIntval <= 50){
            return "33";
        } else if(inputIntval <= 60){
            return "37";
        } else if(inputIntval <= 70){
            return "41";
        } else if(inputIntval <= 80){
            return "44";
        } else if(inputIntval <= 90){
            return "47";
        } else if(inputIntval <= 100){
            return "59";
        } else if(inputIntval <= 110){
            return "52";
        } else if(inputIntval <= 120){
            return "54";
        } else if(inputIntval <= 130){
            return "55";
        } else if(inputIntval <= 140){
            return "57";
        } else if(inputIntval <= 150){
            return "59";
        } else if(inputIntval <= 160){
            return "60";
        } else if(inputIntval <= 170){
            return "62";
        } else if(inputIntval <= 180){
            return "63";
        } else if(inputIntval <= 190){
            return "64";
        }else if(inputIntval <= 200){
            return "65";
        }else if(inputIntval <= 210){
            return "66";
        }else if(inputIntval <= 220){
            return "67";
        }else if(inputIntval <= 230){
            return "68";
        }else if(inputIntval <= 240){
            return "69";
        }else if(inputIntval <= 250){
            return "70";
        }else if(inputIntval <= 260){
            return "70";
        }else if(inputIntval <= 270){
            return "71";
        }else if(inputIntval <= 280){
            return "72";
        }else if(inputIntval <= 290){
            return "72";
        }else {
            return "73";
        }
    }
   private void sendInformation(Intent intent, String farmName,
                                String address, String addressDetail,
                                String repName, int totalCow, int totalAdultCow,
                                int totalChildCow,int sampleCow, String evaName, int year,
                                int month, int day,int farmType){


        String evaDate = year +"년"+ month+1 +"월" + day + "일";
        Bundle bundle = new Bundle();
        bundle.putString("farmName",farmName);
        bundle.putString("address",address);
        bundle.putString("addressDetail",addressDetail);
        bundle.putString("repName",repName);
        bundle.putInt("totalCow",totalCow);
        bundle.putInt("totalAdultCow",totalAdultCow);
        bundle.putInt("totalChildCow",totalChildCow);
        bundle.putInt("sampleCowSize",sampleCow);
        bundle.putString("evaName",evaName);
        bundle.putString("evaDate",evaDate);
        bundle.putInt("farmType",farmType);
        intent.putExtras(bundle);

   }
    public void CowHandler(View view)
    {
        switch(view.getId())
        {
            case R.id.beef_btn:
                beef_group.setVisibility(View.VISIBLE);
                milk_cow_group.setVisibility(View.GONE);
                break;
            case R.id.milk_cow_btn:
                milk_cow_group.setVisibility(View.VISIBLE);
                beef_group.setVisibility(View.GONE);
                break;
        }
    }
    private void CheckInputInformation( AlertDialog.Builder AlertBuilder, String farmName,
                                        String address, String addressDetail,
                                       String repName, int totalCow, int totalAdultCow,
                                       int totalChildCow,int sampleCow, String evaName, int year,
                                       int month, int day,int farmType){
        String farmTypeMsg;
        if(farmType == 1){
            farmTypeMsg = "한육우, 비육 농장";
        } else if(farmType == 2) {
            farmTypeMsg = "한육우, 번식 농장";
        } else if(farmType == 3){
            farmTypeMsg = "한육우, 일괄 사육 농징";
        } else if(farmType == 4){
            farmTypeMsg = "착유우, 일반 우사";
        } else {
            farmTypeMsg ="착유우, 프리스톨 우사";
        }
        AlertBuilder.setTitle("정보 입력 결과");
        String msg =
                "농장명 : " + farmName + " \n"
                + "주소 : " + address + " \n"
                + "상세주소 : " + addressDetail + " \n"
                + "대표자명 : " + repName + " \n"
                + "농장종류 : " + farmTypeMsg + " \n"
                + "총 두수 : " + totalCow + "두 \n"
                + "성우 두수 : " + totalAdultCow + "두 \n"
                + "송아지 두수 : " + totalChildCow + "두 \n"
                + "표본 두수 : " + sampleCow +"두 \n"
                + "평가자명 : " + evaName + " \n"
                + "평가일 :" + year + "년 " + (month+1) + "월 " + day + "일 \n\n"
                + "입력 하신 정보로 평가를 진행하시겠습니까? ";
        AlertBuilder.setMessage(msg);
        // 버튼 추가 (Ok 버튼과 Cancle 버튼 )
        AlertBuilder.setPositiveButton("취소",new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog,int which){
                // OK 버튼을 눌렸을 경우

            }
        });
        AlertBuilder.setNegativeButton("네", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intentQuestionTemplate = new Intent(Input_userinfo.this, QuestionTemplate.class);
                sendInformation(intentQuestionTemplate,farmName,address,addressDetail,
                        repName,totalCow,totalAdultCow,totalChildCow,sampleCow,evaName,
                        year,month,day,farmType);
                startActivity(intentQuestionTemplate);
            }
        });
        AlertBuilder.show();
    }

}