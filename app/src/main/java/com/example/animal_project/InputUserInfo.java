package com.example.animal_project;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class InputUserInfo extends AppCompatActivity {

    public static Context context_userinfo;
    public String result;
    public String total_cow_count;
    public String sample_size_count;
    private static final int SEARCH_ADDRESS_ACTIVITY = 10000;
    private static String IP_ADDRESS = "218.151.112.65";
    private int input_checked = 0;
    private Button beef_btn;
    private Button milk_cow_btn;
    private LinearLayout beef_group;
    private LinearLayout milk_cow_group;
    private Bundle bundle = new Bundle();


    private EditText farm_name_et;
    private EditText zipcode_et;
    private EditText address_et;
    private EditText address_detail_et;
    private EditText farm_rep_name_et;
    private EditText total_adult_cow_et;
    private EditText total_child_cow_et;
    private EditText milk_cow_et;
    private EditText dry_milk_cow_et;
    private EditText pregnant_cow_et;
    private EditText eva_name_et;
    private DatePicker eva_data_picker;
    private String farmType;
    private String farmId;
    private LinearLayout beef_cow_input_layout;
    private LinearLayout milk_cow_input_layout;



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
        beef_cow_input_layout = findViewById(R.id.beef_cow_input_layout);
        milk_cow_input_layout = findViewById(R.id.milk_cow_input_layout);

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

        milk_cow_et = findViewById(R.id.milk_cow_ed);
        dry_milk_cow_et = findViewById(R.id.dry_milk_cow_ed);
        pregnant_cow_et = findViewById(R.id.pregnant_cow_ed);




        // 한육우 라디오 그룹 클릭 시
        input_farm_beef.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.input_1) { // 비육 농장
                    input_checked = 1;
                    farmType = "한육우, 비육 농장";
                }
                if (checkedId == R.id.input_2) { // 번식 농장
                    input_checked = 2;
                    farmType = "한육우, 번식 농장";
                } else if (checkedId == R.id.input_3) { // 일괄 사육 농장
                    input_checked = 3;
                    farmType = "한육우, 일괄 사육 농장";
                }

            }
        });

        // 착유우 라디오 그룹 클릭 시
        input_farm_milk_cow.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.input_4) { // 젖소 일반 우사
                    input_checked = 4;
                    farmType = "착유우, 일반 우사";
                } if (checkedId == R.id.input_5) { // 젖소 프리스톨 우사
                    input_checked = 5;
                    farmType = "착유우, 프리스톨 우사";
                }
            }
        });

        // 평가하기 버튼 눌렀을 때
        farm_selector.setOnClickListener(new View.OnClickListener() {
            String msg;
            @Override
            public void onClick(View v) {
                // 사용자가 모든 정보를 입력하였는지 확인
                if(input_checked == 1 || input_checked == 2 || input_checked == 3){
                    if(!checkEmptyInputInfo(farm_name_et, "농장명을 입력하세요")
                            && !checkEmptyInputInfo(address_et, "주소를 입력하세요")
                            && !checkEmptyInputInfo(address_detail_et, "상세 주소를 입력하세요")
                            && !checkEmptyInputInfo(farm_rep_name_et, "대표자명을 입력하세요")
                            && !checkEmptyInputInfo(total_cow_et, "총 두수를 입력하세요")
                            && !checkEmptyInputInfo(total_adult_cow_et, "성우 두수를 입력하세요")
                            && !checkEmptyInputInfo(total_child_cow_et, "송아지 두수를 입력하세요")
                            && !checkEmptyInputInfo(eva_name_et, "평가자명을 입력하세요")
                    ){
                        AlertDialog.Builder AlertBuilder = new AlertDialog.Builder(InputUserInfo.this);
                        CheckInputInformation(
                                AlertBuilder,
                                String.valueOf(farm_name_et.getText()),
                                String.valueOf(zipcode_et.getText()),
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
                                eva_data_picker.getDayOfMonth(), input_checked,
                                0,0,0
                        );
                    }
                } else if(input_checked == 4 || input_checked == 5){
                    if(!checkEmptyInputInfo(farm_name_et, "농장명을 입력하세요")
                            && !checkEmptyInputInfo(address_et, "주소를 입력하세요")
                            && !checkEmptyInputInfo(address_detail_et, "상세 주소를 입력하세요")
                            && !checkEmptyInputInfo(farm_rep_name_et, "대표자명을 입력하세요")
                            && !checkEmptyInputInfo(total_cow_et, "성우 두수를 입력하세요")
                            && !checkEmptyInputInfo(milk_cow_et, "착유우 두수를 입력하세요")
                            && !checkEmptyInputInfo(dry_milk_cow_et, "건유우 두수를 입력하세요")
                            && !checkEmptyInputInfo(pregnant_cow_et, "미경산임신우 두수를 입력하세요")
                            && !checkEmptyInputInfo(total_child_cow_et, "송아지 두수를 입력하세요")
                            && !checkEmptyInputInfo(eva_name_et, "평가자명을 입력하세요")){
                        AlertDialog.Builder AlertBuilder = new AlertDialog.Builder(InputUserInfo.this);
                        CheckInputInformation(
                                AlertBuilder,
                                String.valueOf(farm_name_et.getText()),
                                String.valueOf(zipcode_et.getText()),
                                String.valueOf(address_et.getText()),
                                String.valueOf(address_detail_et.getText()),
                                String.valueOf(farm_rep_name_et.getText()),
                                Integer.parseInt(String.valueOf(total_cow_et.getText())),
                                0,
                                Integer.parseInt(String.valueOf(total_child_cow_et.getText())),
                                Integer.parseInt(String.valueOf(sample_size_count)),
                                String.valueOf(eva_name_et.getText()),
                                eva_data_picker.getYear(),
                                eva_data_picker.getMonth(),
                                eva_data_picker.getDayOfMonth(), input_checked,
                                Integer.parseInt(String.valueOf(milk_cow_et.getText())),
                                Integer.parseInt(String.valueOf(dry_milk_cow_et.getText())),
                                Integer.parseInt(String.valueOf(pregnant_cow_et.getText()))
                        );
                    }
                }
                else if(input_checked == 0){
                    msg = "농장 종류를 선택하세요";
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                }

                // 모든 정보를 입력하였을 때

                // 테스트 용 코드 위에 조건문 주석 걸고 실행
/*                if(input_checked == 0) {
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
                }*/
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

        // 우편 번호 입력 창
        zipcode_et = (EditText) findViewById(R.id.et_zipCode);
        // 주소 입력을 위한 창
        address_et = (EditText) findViewById(R.id.et_address);
        if(zipcode_et != null){
            zipcode_et.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event)
                {
                    if(event.getAction() == MotionEvent.ACTION_UP) {
                        Intent i = new Intent(InputUserInfo.this, com.example.animal_project.WebViewActivity.class);
                        startActivityForResult(i, SEARCH_ADDRESS_ACTIVITY);
                        return true;
                    }
                    return false;
                }
            });
        }
        if (address_et != null) {
            address_et.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event)
                {
                    if(event.getAction() == MotionEvent.ACTION_UP) {
                        Intent i = new Intent(InputUserInfo.this, com.example.animal_project.WebViewActivity.class);
                        startActivityForResult(i, SEARCH_ADDRESS_ACTIVITY);
                        return true;
                    }
                    return false;
                }
            });
        }
    }

    // 주소지 결과 창
    public void onActivityResult(int requestCode, int resultCode, Intent intent)
    {
        super.onActivityResult(requestCode, resultCode, intent);
        switch (requestCode) {
            case SEARCH_ADDRESS_ACTIVITY:
                if (resultCode == RESULT_OK) {
                    String data = intent.getExtras().getString("data");
                    String[] dataArr = data.split(",");
                    if (data != null) {
                        zipcode_et.setText(dataArr[0]);
                        address_et.setText(dataArr[1]);
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
            return "49";
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
   private void sendInformation(String farmName,
                                String address, String addressDetail,
                                String repName, int totalCow, int totalAdultCow,
                                int totalChildCow,int sampleCow, String evaName, int year,
                                int month, int day,int farmType, int milkCow, int dryMilkCow,int pregnantCow){


        String evaDate = year +"년"+ (month+1) +"월" + day + "일";
        if(farmType == 1 || farmType == 2 || farmType == 3){
            bundle.putInt("totalAdultCow",totalAdultCow);    
        } else if( farmType == 4 || farmType == 5){
            bundle.putInt("milkCow",milkCow);
            bundle.putInt("dryMilkCow",dryMilkCow);
            bundle.putInt("pregnantCow",pregnantCow);
        }
        bundle.putString("farmName",farmName);
        bundle.putString("address",address);
        bundle.putString("addressDetail",addressDetail);
        bundle.putString("repName",repName);
        bundle.putInt("totalCow",totalCow);
        bundle.putInt("totalChildCow",totalChildCow);
        bundle.putInt("sampleCowSize",sampleCow);
        bundle.putString("evaName",evaName);
        bundle.putString("evaDate",evaDate);
        bundle.putInt("farmType",farmType);



   }
    public void CowHandler(View view)
    {
        switch(view.getId())
        {
            case R.id.beef_btn:
                beef_group.setVisibility(View.VISIBLE);
                milk_cow_group.setVisibility(View.GONE);
                beef_cow_input_layout.setVisibility(View.VISIBLE);
                milk_cow_input_layout.setVisibility(View.GONE);
                break;
            case R.id.milk_cow_btn:
                milk_cow_group.setVisibility(View.VISIBLE);
                beef_group.setVisibility(View.GONE);
                milk_cow_input_layout.setVisibility(View.VISIBLE);
                beef_cow_input_layout.setVisibility(View.GONE);

                break;
        }
    }
    private void CheckInputInformation( AlertDialog.Builder AlertBuilder, String farmName,String zipCode,
                                        String address, String addressDetail,
                                       String repName, int totalCow, int totalAdultCow,
                                       int totalChildCow,int sampleCow, String evaName, int year,
                                       int month, int day,int farmType,int milkCow, int dryMilkCow, int pregnantCow){
        String farmTypeMsg;
        if(farmType == 1){
            farmTypeMsg = "한육우, 비육 농장";
        } else if(farmType == 2) {
            farmTypeMsg = "한육우, 번식 농장";
        } else if(farmType == 3){
            farmTypeMsg = "한육우, 일괄 사육 농장";
        } else if(farmType == 4){
            farmTypeMsg = "착유우, 운동장형 우사";
        } else {
            farmTypeMsg ="착유우, 프리스톨 우사";
        }
        CustomDialog customDialog = new CustomDialog(InputUserInfo.this);

        String evaDate = year + "년 " + (month+1) + " 월 " + day + " 일";
        List<String> inputMessage = new ArrayList<String>();
        inputMessage.add(farmName);
        inputMessage.add(zipCode);
        inputMessage.add(address);
        inputMessage.add(addressDetail);
        inputMessage.add(repName);
        inputMessage.add(farmTypeMsg);
        inputMessage.add( String.valueOf(totalCow));
        inputMessage.add(String.valueOf(totalChildCow));
        inputMessage.add(String.valueOf(sampleCow));
        inputMessage.add(evaName);
        inputMessage.add(evaDate);
        inputMessage.add(String.valueOf(farmType));

        if(farmType == 1 || farmType == 2 || farmType == 3){
            inputMessage.add(String.valueOf(totalAdultCow));
            
        } else if(farmType == 4 || farmType == 5) {
            inputMessage.add(String.valueOf(milkCow));
            inputMessage.add(String.valueOf(dryMilkCow));
            inputMessage.add(String.valueOf(pregnantCow));
            }
        customDialog.setInputMessage(inputMessage);
        

        

        customDialog.cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(InputUserInfo.this, "취소 했습니다.", Toast.LENGTH_SHORT).show();

                // 커스텀 다이얼로그를 종료한다.
                customDialog.dismiss();
            }
        });
        customDialog.okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentQuestionTemplate = new Intent(InputUserInfo.this, QuestionTemplate.class);
                sendInformation(farmName,address,addressDetail,
                        repName,totalCow,totalAdultCow,totalChildCow,sampleCow,evaName,
                        year,month+1,day,farmType,milkCow,dryMilkCow,pregnantCow);
                
                    InsertEvaInfo task = (InsertEvaInfo) new InsertEvaInfo(InputUserInfo.this, new InsertEvaInfo.AsyncResponse() {
                        @Override
                        public void processFinish(String output) {
                            farmId = output;
                            bundle.putString("farmId",farmId);
                            intentQuestionTemplate.putExtras(bundle);
                            startActivity(intentQuestionTemplate);

                        }
                    }).execute("http://" + IP_ADDRESS + "/insertInfo.php",
                            farmName,
                            address,
                            addressDetail,
                            repName,
                            farmTypeMsg,
                            String.valueOf(totalCow),
                            String.valueOf(totalAdultCow),
                            String.valueOf(totalChildCow),
                            String.valueOf(sampleCow),
                            String.valueOf(evaName),
                            String.valueOf(year),
                            String.valueOf(month+1),
                            String.valueOf(day),
                            String.valueOf(zipCode),
                            String.valueOf(farmType),
                            String.valueOf(milkCow),
                            String.valueOf(dryMilkCow),
                            String.valueOf(pregnantCow)
                    );
                customDialog.dismiss();
            }
        });



    }
    private boolean checkEmptyInputInfo(EditText infoEt, String msg){
        if(TextUtils.isEmpty(infoEt.getText())){
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            return true;
        }
        return false;
    }

}