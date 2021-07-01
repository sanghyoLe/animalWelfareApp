package com.example.animal_project;

import android.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.animal_project.BreedBatch.BreedCriticalHairLoss;
import com.example.animal_project.BreedBatch.BreedSlightHairLoss;
import com.example.animal_project.BreedBatch.BreedLimp;
import com.example.animal_project.BreedBatch.BreedMistSpray;
import com.example.animal_project.BreedBatch.BreedOutward;
import com.example.animal_project.BreedBatch.BreedPoor;
import com.example.animal_project.BreedBatch.BreedShade;
import com.example.animal_project.BreedBatch.BreedStraw;
import com.example.animal_project.BreedBatch.BreedSummerVentilating;
import com.example.animal_project.BreedBatch.BreedWaterQ1;
import com.example.animal_project.BreedBatch.BreedWaterQ2;
import com.example.animal_project.BreedBatch.BreedWaterQ3;
import com.example.animal_project.BreedBatch.BreedWindBlock;
import com.example.animal_project.BreedBatch.BreedWinterVentilating;
import com.example.animal_project.BreedBatch.CalfMistSpray;
import com.example.animal_project.BreedBatch.CalfShade;
import com.example.animal_project.BreedBatch.CalfStraw;
import com.example.animal_project.BreedBatch.CalfSummerVentilating;
import com.example.animal_project.BreedBatch.CalfWarm;
import com.example.animal_project.BreedBatch.CalfWindBlock;


public class QuestionTemplate extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private BreedPoor breed_poor;
    private BreedWaterQ1 breed_water_q1;
    private BreedWaterQ2 breed_water_q2;
    private BreedWaterQ3 breed_water_q3;
    private BreedStraw breed_straw;
    private BreedOutward breed_outward;
    private BreedShade breed_shade;
    private BreedSummerVentilating breed_summer_ventilating;
    private BreedMistSpray breed_mist_spray;
    private BreedWindBlock breed_wind_block;
    private BreedWinterVentilating breed_winter_ventilating;
    private CalfShade calf_shade;
    private CalfSummerVentilating calf_summer_ventilating;
    private CalfMistSpray calf_mist_spray;
    private CalfStraw calf_straw;
    private CalfWarm calf_warm;
    private CalfWindBlock calf_wind_block;
    private BreedLimp breed_limp;
    private BreedSlightHairLoss breed_slight_hair_loss;
    private BreedCriticalHairLoss breed_critical_hair_loss;
    private TextView current_page;
    private TextView total_page;
    private int inputCheck = 0;
    private ImageButton prev_btn;
    private ImageButton next_btn;
    private int totalCowSize;
    private int sampleCowSize;
    private Fragment[] breed_frag_arr = new Fragment[20];
    int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_template);

        QuestionTemplateViewModel viewModel = new ViewModelProvider(this).get(QuestionTemplateViewModel.class);

        fragmentManager = getSupportFragmentManager();

        next_btn = findViewById(R.id.next_btn);
        prev_btn = findViewById(R.id.previous_btn);
        current_page = findViewById(R.id.current_page);
        total_page = findViewById(R.id.total_page);

        breed_poor = new BreedPoor();
        breed_water_q1 = new BreedWaterQ1();
        breed_water_q2 = new BreedWaterQ2();
        breed_water_q3 = new BreedWaterQ3();
        breed_straw = new BreedStraw();
        breed_outward = new BreedOutward();
        breed_shade = new BreedShade();
        breed_summer_ventilating = new BreedSummerVentilating();
        breed_mist_spray = new BreedMistSpray();
        breed_wind_block = new BreedWindBlock();
        breed_winter_ventilating = new BreedWinterVentilating();
        calf_shade = new CalfShade();
        calf_summer_ventilating = new CalfSummerVentilating();
        calf_mist_spray = new CalfMistSpray();
        calf_straw = new CalfStraw();
        calf_warm = new CalfWarm();
        calf_wind_block = new CalfWindBlock();
        breed_limp = new BreedLimp();
        breed_slight_hair_loss = new BreedSlightHairLoss();
        breed_critical_hair_loss = new BreedCriticalHairLoss();



        // 마지막 페이지 개수 지정
        Intent intent = getIntent();
        Bundle BeforeBundle = intent.getExtras();
        inputCheck = BeforeBundle.getInt("inputChecked");
        totalCowSize = BeforeBundle.getInt("totalCow");
        sampleCowSize = BeforeBundle.getInt("sampleCowSize");

        viewModel.setSampleCowSize(sampleCowSize);
        viewModel.setTotalCowSize(totalCowSize);
        breed_frag_arr = new Fragment[]{ breed_poor,breed_water_q1,breed_water_q2,breed_water_q3,
                breed_straw,breed_outward,breed_shade,breed_summer_ventilating,breed_mist_spray,
                breed_wind_block,breed_winter_ventilating,calf_shade,calf_summer_ventilating,calf_mist_spray,
                calf_straw,calf_warm,calf_wind_block,breed_limp,breed_slight_hair_loss,breed_critical_hair_loss};



        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_paper, breed_poor).commitAllowingStateLoss();
        if (inputCheck == 1) {

        }
        else if (inputCheck == 2 || inputCheck == 3) {
            total_page.setText(String.valueOf(" / " + breed_frag_arr.length));
        }
        else if (inputCheck == 4) {

        }
        else if (inputCheck == 5) {

        }


    }
    public void clickHandler(View view)
    {
        transaction = fragmentManager.beginTransaction();
        if(count == 0){
            prev_btn.setVisibility(View.INVISIBLE);
        }

        switch(view.getId())
        {
            // 다음 버튼 누를 시 이어질 페이지 지정
            case R.id.next_btn:
                if (inputCheck == 1) {

                }
                else if (inputCheck == 2 || inputCheck == 3) {
                    nextBtnHandler(count,breed_frag_arr.length);
                    transaction.replace(R.id.fragment_paper,breed_frag_arr[++count]).commitAllowingStateLoss();

                }
                else if (inputCheck == 4) {

                }
                else if (inputCheck == 5) {

                }
                current_page.setText(String.valueOf(count+1));

                break;
                // 이전 버튼 누를 시 이어질 페이지 지정
            case R.id.previous_btn:
                if (inputCheck == 1) {

                }
                else if (inputCheck == 2 || inputCheck == 3) {
                    prevBtnHandler(count,breed_frag_arr.length);
                    transaction.replace(R.id.fragment_paper, breed_frag_arr[--count]).commitAllowingStateLoss();
                }
                else if (inputCheck == 4) {
                }
                else if (inputCheck == 5) {

                }
                current_page.setText(String.valueOf(count+1));
                break;
            case R.id.back_btn:
                AlertDialog.Builder myAlertBuilder =
                        new AlertDialog.Builder(QuestionTemplate.this);
                myAlertBuilder.setTitle("이전");
                myAlertBuilder.setMessage("정보 입력화면으로 돌아가시겠습니까?");
                // 버튼 추가 (Ok 버튼과 Cancle 버튼 )
                myAlertBuilder.setPositiveButton("취소",new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog,int which){
                        // OK 버튼을 눌렸을 경우

                    }
                });
                myAlertBuilder.setNegativeButton("네", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        onBackPressed();
                    }
                });
                myAlertBuilder.show();
                break;


        }
    }


    private void nextBtnHandler(int count, int totalPageLength){
        if(count + 2 == totalPageLength){
            next_btn.setVisibility(View.INVISIBLE);
        }
        prev_btn.setVisibility(View.VISIBLE);
    }
    private void prevBtnHandler(int count, int totalPageLength){
        if(count + 1 == totalPageLength){
            next_btn.setVisibility(View.VISIBLE);
        }
        if(count == 1){
            prev_btn.setVisibility(View.INVISIBLE);
        }
    }

}