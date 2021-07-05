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
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.animal_project.BreedBatch.ProtocolFour.BreedAvoidDistance;
import com.example.animal_project.BreedBatch.ProtocolFour.BreedHarmony;
import com.example.animal_project.BreedBatch.ProtocolFour.BreedStruggle;
import com.example.animal_project.BreedBatch.ProtocolThree.BreedBreath;
import com.example.animal_project.BreedBatch.ProtocolThree.BreedCastrationQ1;
import com.example.animal_project.BreedBatch.ProtocolThree.BreedCastrationQ2;
import com.example.animal_project.BreedBatch.ProtocolThree.BreedCastrationQ3;
import com.example.animal_project.BreedBatch.ProtocolThree.BreedCough;
import com.example.animal_project.BreedBatch.ProtocolThree.BreedCriticalHairLoss;
import com.example.animal_project.BreedBatch.ProtocolThree.BreedDiarrhea;
import com.example.animal_project.BreedBatch.ProtocolThree.BreedFallDead;
import com.example.animal_project.BreedBatch.ProtocolThree.BreedHornQ1;
import com.example.animal_project.BreedBatch.ProtocolThree.BreedHornQ2;
import com.example.animal_project.BreedBatch.ProtocolThree.BreedHornQ3;
import com.example.animal_project.BreedBatch.ProtocolThree.BreedOphthalmic;
import com.example.animal_project.BreedBatch.ProtocolThree.BreedRuminant;
import com.example.animal_project.BreedBatch.ProtocolThree.BreedRunnyNose;
import com.example.animal_project.BreedBatch.ProtocolThree.BreedSlightHairLoss;
import com.example.animal_project.BreedBatch.ProtocolThree.BreedLimp;
import com.example.animal_project.BreedBatch.ProtocolTwo.BreedMistSpray;
import com.example.animal_project.BreedBatch.ProtocolTwo.BreedOutward;
import com.example.animal_project.BreedBatch.ProtocolOne.BreedPoor;
import com.example.animal_project.BreedBatch.ProtocolTwo.BreedShade;
import com.example.animal_project.BreedBatch.ProtocolTwo.BreedStraw;
import com.example.animal_project.BreedBatch.ProtocolTwo.BreedSummerVentilating;
import com.example.animal_project.BreedBatch.ProtocolOne.BreedWaterQ1;
import com.example.animal_project.BreedBatch.ProtocolOne.BreedWaterQ2;
import com.example.animal_project.BreedBatch.ProtocolOne.BreedWaterQ3;
import com.example.animal_project.BreedBatch.ProtocolTwo.BreedWindBlock;
import com.example.animal_project.BreedBatch.ProtocolTwo.BreedWinterVentilating;
import com.example.animal_project.BreedBatch.ProtocolTwo.CalfMistSpray;
import com.example.animal_project.BreedBatch.ProtocolTwo.CalfShade;
import com.example.animal_project.BreedBatch.ProtocolTwo.CalfStraw;
import com.example.animal_project.BreedBatch.ProtocolTwo.CalfSummerVentilating;
import com.example.animal_project.BreedBatch.ProtocolTwo.CalfWarm;
import com.example.animal_project.BreedBatch.ProtocolTwo.CalfWindBlock;
import com.example.animal_project.Result.ResultTotal;
import com.example.animal_project.Result.Result_1;
import com.example.animal_project.Result.Result_2;
import com.example.animal_project.Result.Result_3;
import com.example.animal_project.Result.Result_4;
import com.google.android.material.tabs.TabLayout;


public class QuestionTemplate extends AppCompatActivity {

// --- 결과 창 ---
    ResultTotal result_total;
    Result_1 result1;
    Result_2 result2;
    Result_3 result3;
    Result_4 result4;
    TabLayout tabs;
    Bundle bundle;
    // --------------------------------------------------------
    private LinearLayout fragment_paper;
    private LinearLayout question_top_nav;
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
    private BreedCough breed_cough;
    private BreedRunnyNose breed_runny_nose;
    private BreedOphthalmic breed_ophthalmic;
    private BreedBreath breed_breath;
    private BreedDiarrhea breed_diarrhea;
    private BreedRuminant breed_ruminant;
    private BreedFallDead breed_fall_dead;
    private BreedHornQ1 breed_horn_q1;
    private BreedHornQ2 breed_horn_q2;
    private BreedHornQ3 breed_horn_q3;
    private BreedCastrationQ1 breed_castration_q1;
    private BreedCastrationQ2 breed_castration_q2;
    private BreedCastrationQ3 breed_castration_q3;
    private BreedStruggle breed_struggle;
    private BreedHarmony breed_harmony;
    private BreedAvoidDistance breed_avoid_distance;
    private TextView current_page;
    private TextView total_page;
    private int inputCheck = 0;
    private ImageButton prev_btn;
    private ImageButton next_btn;
    private Button end_btn;
    private int totalCowSize;
    private int sampleCowSize;
    private Fragment[] breed_frag_arr = new Fragment[20];
    int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_template);

        result_total = new ResultTotal();
        result1 = new Result_1();
        result2 = new Result_2();
        result3 = new Result_3();
        result4 = new Result_4();


        QuestionTemplateViewModel viewModel = new ViewModelProvider(this).get(QuestionTemplateViewModel.class);

        fragmentManager = getSupportFragmentManager();

        next_btn = findViewById(R.id.next_btn);
        prev_btn = findViewById(R.id.previous_btn);
        current_page = findViewById(R.id.current_page);
        total_page = findViewById(R.id.total_page);
        end_btn = findViewById(R.id.end_btn);
        fragment_paper = findViewById(R.id.fragment_paper);
        question_top_nav = findViewById(R.id.question_top_nav);

        // 평가를 위한 프래그먼트들
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
        breed_cough = new BreedCough();
        breed_runny_nose = new BreedRunnyNose();
        breed_ophthalmic = new BreedOphthalmic();
        breed_breath = new BreedBreath();
        breed_diarrhea = new BreedDiarrhea();
        breed_ruminant = new BreedRuminant();
        breed_fall_dead = new BreedFallDead();
        breed_horn_q1 = new BreedHornQ1();
        breed_horn_q2 = new BreedHornQ2();
        breed_horn_q3 = new BreedHornQ3();
        breed_castration_q1 = new BreedCastrationQ1();
        breed_castration_q2 = new BreedCastrationQ2();
        breed_castration_q3 = new BreedCastrationQ3();
        breed_struggle = new BreedStruggle();
        breed_harmony = new BreedHarmony();
        breed_avoid_distance = new BreedAvoidDistance();

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
                calf_straw,calf_warm,calf_wind_block,breed_limp,breed_slight_hair_loss,breed_critical_hair_loss,
                breed_cough,breed_runny_nose,breed_ophthalmic,breed_breath,breed_diarrhea,breed_ruminant,breed_fall_dead,
                breed_horn_q1,breed_horn_q2,breed_horn_q3,breed_castration_q1,breed_castration_q2,breed_castration_q3,
        breed_struggle,breed_harmony,breed_avoid_distance};



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
            case R.id.end_btn:
                fragment_paper.setVisibility(View.GONE);
                end_btn.setVisibility(View.GONE);
                question_top_nav.setVisibility(View.GONE);
                getSupportFragmentManager().beginTransaction().add(R.id.container, result_total).commit();
                tabs = findViewById(R.id.tab_layout);
                tabs.addTab(tabs.newTab().setText("종합"));
                tabs.addTab(tabs.newTab().setText("사료"));
                tabs.addTab(tabs.newTab().setText("환경"));
                tabs.addTab(tabs.newTab().setText("건강"));
                tabs.addTab(tabs.newTab().setText("행동"));

                tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        int position = tab.getPosition();
                        Fragment selected = null;
                        if(position == 0)
                            selected = result_total;
                        else if(position == 1)
                            selected = result1;
                        else if(position == 2)
                            selected = result2;
                        else if(position == 3)
                            selected = result3;
                        else if(position == 4)
                            selected = result4;
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, selected).commit();
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {

                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {

                    }
                });



        }
    }


    private void nextBtnHandler(int count, int totalPageLength){
        if(count + 2 == totalPageLength){
            next_btn.setVisibility(View.INVISIBLE);
            end_btn.setVisibility(View.VISIBLE);
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
        end_btn.setVisibility(View.GONE);
    }

}