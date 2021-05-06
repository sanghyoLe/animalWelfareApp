package com.example.animal_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class getStrawScore extends AppCompatActivity {
    LinearLayout myLinear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_get_straw_score);
        Intent intent = getIntent();
        int size = intent.getExtras().getInt("exSize");

        myLinear = findViewById(R.id.parent_layout);

        createEx(size);

    }
    public void createEx(int size){
        LinearLayout.LayoutParams mParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams wParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams wmParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.MATCH_PARENT);

        LinearLayout.LayoutParams hrParmas = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                TypedValue.COMPLEX_UNIT_DIP,3);
        TextView textview;
        EditText editText;
        View view;
        RadioGroup radioGroup;
        RadioGroup radioGroup2;
        RadioGroup radioGroup3;

        int[][] idArray = new int[100][100];

        RadioButton radioButton1 = null;
        RadioButton radioButton2 = null;
        RadioButton radioButton3 = null;
        RadioButton radioButton4 = null;

        for(int j = 1 ; j <= size; j++) {

            textview = new TextView(this);
            textview.setBackgroundColor(Color.DKGRAY);
            textview.setText(j + "번 표본펜 위치");
            textview.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);
            textview.setTextColor(Color.WHITE);
            textview.setLayoutParams(mParams);

            myLinear.addView(textview);

            editText = new EditText(this);
            editText.setBackground(getResources().getDrawable(R.drawable.edittext));
            editText.setHint(j + " 동 표본펜 위치 ex) 1-2, 2-3, 3-4");
            editText.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 12);
            editText.setInputType(TypedValue.TYPE_STRING);
            editText.setLayoutParams(mParams);

            myLinear.addView(editText);

            textview = new TextView(this);
            textview.setBackgroundColor(Color.DKGRAY);
            textview.setText(j + "번 표본펜 1, 2, 3구역 깔짚수분 간이측정점수");
            textview.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);
            textview.setTextColor(Color.WHITE);
            textview.setLayoutParams(mParams);
            myLinear.addView(textview);
            // Q. 5
            textview = new TextView(this);
            textview.setText("사료조 근처의 '즉시 깔짚교체 시기'의 비율이 얼마나 되는가? (즉시 깔짚교체 시기-깔집을 쥐었을때 수분방울이 맺히거나 흘러내림)");
            textview.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);
            textview.setTextColor(Color.BLACK);
            textview.setLayoutParams(mParams);
            myLinear.addView(textview);




            radioGroup = new RadioGroup(this);
            radioGroup.setId(ViewCompat.generateViewId());

            radioGroup.setLayoutParams(mParams);
            radioGroup.setOrientation(LinearLayout.VERTICAL);


            radioButton1 = new RadioButton(this);
            radioButton1.setLayoutParams(wParams);
            radioButton1.setText("20% 이하");
            radioButton1.setTextSize(TypedValue.COMPLEX_UNIT_DIP,15);
            radioGroup.addView(radioButton1);


            radioButton2 = new RadioButton(this);
            radioButton2.setLayoutParams(wParams);
            radioButton2.setText("40% 이하");
            radioButton2.setTextSize(TypedValue.COMPLEX_UNIT_DIP,15);
            radioGroup.addView(radioButton2);

            radioButton3 = new RadioButton(this);
            radioButton3.setLayoutParams(wParams);
            radioButton3.setText("60% 이하");
            radioButton3.setTextSize(TypedValue.COMPLEX_UNIT_DIP,15);
            radioGroup.addView(radioButton3);

            radioButton4 = new RadioButton(this);
            radioButton4.setLayoutParams(wParams);
            radioButton4.setText("60% 초과");
            radioButton4.setTextSize(TypedValue.COMPLEX_UNIT_DIP,15);
            radioGroup.addView(radioButton4);


            myLinear.addView(radioGroup);
            RadioButton finalRadioButton = radioButton1;
            RadioButton finalRadioButton2 = radioButton2;
            RadioButton finalRadioButton3 = radioButton3;
            RadioButton finalRadioButton4 = radioButton4;
            int finalJ = j;
            final int[] value = {0};
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int i) {
                    if (radioGroup.getId() == idArray[finalJ][0]) {
                        if (finalRadioButton.isChecked()) {
                           value[0] = 1;
                        } else if (finalRadioButton2.isChecked()) {
                            value[1] = 2;
                        } else if (finalRadioButton3.isChecked()) {
                            value[2] = 3;
                        } else if (finalRadioButton4.isChecked()) {
                            value[3] = 4;
                        }
                    }
                    Log.d("1",String.valueOf(value[0]));
                }
            });





            view = new View(this);
            view.setLayoutParams(hrParmas);
            view.setBackgroundColor(Color.BLACK);

            myLinear.addView(view);

            // Q. 6
            textview = new TextView(this);
            textview.setText("사료조와 주 휴식장소사이의 '즉시 깔짚교체 시기'의 비율이 얼마나 되는가? (즉시 깔짚교체 시기-깔집을 쥐었을때 수분방울이 맺히거나 흘러내림)");
            textview.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);
            textview.setTextColor(Color.BLACK);
            textview.setLayoutParams(mParams);
            myLinear.addView(textview);



            radioGroup2 = new RadioGroup(this);

            radioGroup2.setLayoutParams(mParams);
            radioGroup2.setOrientation(LinearLayout.VERTICAL);


            radioButton1 = new RadioButton(this);
            radioButton1.setLayoutParams(wParams);
            radioButton1.setText("10% 이하");
            radioButton1.setTextSize(TypedValue.COMPLEX_UNIT_DIP,15);
            radioGroup2.addView(radioButton1);

            radioButton2 = new RadioButton(this);
            radioButton2.setLayoutParams(wParams);
            radioButton2.setText("20% 이하");
            radioButton2.setTextSize(TypedValue.COMPLEX_UNIT_DIP,15);
            radioGroup2.addView(radioButton2);

            radioButton3 = new RadioButton(this);
            radioButton3.setLayoutParams(wParams);
            radioButton3.setText("40% 이하");
            radioButton3.setTextSize(TypedValue.COMPLEX_UNIT_DIP,15);
            radioGroup2.addView(radioButton3);

            radioButton4 = new RadioButton(this);
            radioButton4.setLayoutParams(wParams);
            radioButton4.setText("40% 초과");
            radioButton4.setTextSize(TypedValue.COMPLEX_UNIT_DIP,15);
            radioGroup2.addView(radioButton4);

            myLinear.addView(radioGroup2);

            RadioButton finalRadioButton2_1 = radioButton1;
            RadioButton finalRadioButton2_2 = radioButton2;
            RadioButton finalRadioButton2_3 = radioButton3;
            RadioButton finalRadioButton2_4 = radioButton4;

            view = new View(this);
            view.setLayoutParams(hrParmas);
            view.setBackgroundColor(Color.BLACK);

            myLinear.addView(view);


            // Q. 7
            textview = new TextView(this);
            textview.setText("주 휴식장소사이의 '즉시 깔짚교체 시기'의 비율이 얼마나 되는가? (즉시 깔짚교체 시기-깔집을 쥐었을때 수분방울이 맺히거나 흘러내림)");
            textview.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);
            textview.setTextColor(Color.BLACK);
            textview.setLayoutParams(mParams);
            myLinear.addView(textview);



            radioGroup3 = new RadioGroup(this);

            radioGroup3.setLayoutParams(mParams);
            radioGroup3.setOrientation(LinearLayout.VERTICAL);


            radioButton1 = new RadioButton(this);
            radioButton1.setLayoutParams(wParams);
            radioButton1.setText("0% 이하");
            radioButton1.setTextSize(TypedValue.COMPLEX_UNIT_DIP,15);
            radioGroup3.addView(radioButton1);

            radioButton2 = new RadioButton(this);
            radioButton2.setLayoutParams(wParams);
            radioButton2.setText("20% 이하");
            radioButton2.setTextSize(TypedValue.COMPLEX_UNIT_DIP,15);
            radioGroup3.addView(radioButton2);

            radioButton3 = new RadioButton(this);
            radioButton3.setLayoutParams(wParams);
            radioButton3.setText("40% 이하");
            radioButton3.setTextSize(TypedValue.COMPLEX_UNIT_DIP,15);
            radioGroup3.addView(radioButton3);

            radioButton4 = new RadioButton(this);
            radioButton4.setLayoutParams(wParams);
            radioButton4.setText("40% 초과");
            radioButton4.setTextSize(TypedValue.COMPLEX_UNIT_DIP,15);
            radioGroup3.addView(radioButton4);

            myLinear.addView(radioGroup3);

            RadioButton finalRadioButton3_1 = radioButton1;
            RadioButton finalRadioButton3_2 = radioButton2;
            RadioButton finalRadioButton3_3 = radioButton3;
            RadioButton finalRadioButton3_4 = radioButton4;


            view = new View(this);
            view.setLayoutParams(hrParmas);
            view.setBackgroundColor(Color.BLACK);
            myLinear.addView(view);


        }
    }

}