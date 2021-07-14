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

import com.example.animal_project.BreedBatch.BreedBreath;
import com.example.animal_project.BreedBatch.BreedCough;
import com.example.animal_project.BreedBatch.BreedCriticalHairLoss;
import com.example.animal_project.BreedBatch.BreedOphthalmic;
import com.example.animal_project.BreedBatch.BreedRunnyNose;
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
import com.example.animal_project.Freestall.FreestallAppearanceQ1;
import com.example.animal_project.Freestall.FreestallAppearanceQ2;
import com.example.animal_project.Freestall.FreestallAppearanceQ3;
import com.example.animal_project.Freestall.FreestallAreaOutCollision;
import com.example.animal_project.Freestall.FreestallAstasia;
import com.example.animal_project.Freestall.FreestallBreast;
import com.example.animal_project.Freestall.FreestallCalfMistSpray;
import com.example.animal_project.Freestall.FreestallCalfShade;
import com.example.animal_project.Freestall.FreestallCalfStraw;
import com.example.animal_project.Freestall.FreestallCalfSummerVentilating;
import com.example.animal_project.Freestall.FreestallCalfWarm;
import com.example.animal_project.Freestall.FreestallCalfWindBlock;
import com.example.animal_project.Freestall.FreestallCount;
import com.example.animal_project.Freestall.FreestallCriticalHairloss;
import com.example.animal_project.Freestall.FreestallCriticalLimp;
import com.example.animal_project.Freestall.FreestallDiarrhea;
import com.example.animal_project.Freestall.FreestallDystocia;
import com.example.animal_project.Freestall.FreestallFallDead;
import com.example.animal_project.Freestall.FreestallSlightHairloss;
import com.example.animal_project.Freestall.FreestallSlightLimp;
import com.example.animal_project.Freestall.FreestallMistSpray;
import com.example.animal_project.Freestall.FreestallOphthalmic;
import com.example.animal_project.Freestall.FreestallOutGenitals;
import com.example.animal_project.Freestall.FreestallPoor;
import com.example.animal_project.Freestall.FreestallRespiratory;
import com.example.animal_project.Freestall.FreestallRunnyNose;
import com.example.animal_project.Freestall.FreestallShade;
import com.example.animal_project.Freestall.FreestallSummerVentilating;
import com.example.animal_project.Freestall.FreestallWaterQ1;
import com.example.animal_project.Freestall.FreestallWaterQ1_1;
import com.example.animal_project.Freestall.FreestallWaterQ1_2;
import com.example.animal_project.Freestall.FreestallWaterQ2;
import com.example.animal_project.Freestall.FreestallWaterQ3;
import com.example.animal_project.Freestall.FreestallWindBlock;
import com.example.animal_project.Freestall.FreestallWinterVentilating;


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
    private BreedCough breed_cough;
    private BreedRunnyNose breed_runny_nose;
    private BreedOphthalmic breed_ophthalmic;
    private BreedBreath breed_breath;
    private TextView current_page;
    private TextView total_page;
    private int inputCheck = 0;
    private ImageButton prev_btn;
    private ImageButton next_btn;
    private int totalCowSize;
    private int sampleCowSize;
    private Fragment[] breed_frag_arr = new Fragment[20];
    // freestall
    private FreestallPoor freestall_poor;
    private FreestallWaterQ1 freestall_water_q1;
    private FreestallWaterQ1_1 freestall_water_q1_1;
    private FreestallWaterQ1_2 freestall_water_q1_2;
    private FreestallWaterQ2 freestall_water_q2;
    private FreestallWaterQ3 freestall_water_q3;
    private FreestallCount freestall_count;

    private FreestallAreaOutCollision freestall_area_out_collision;
    private FreestallAppearanceQ1 freestall_appearance_q1;
    private FreestallAppearanceQ2 freestall_appearance_q2;
    private FreestallAppearanceQ3 freestall_appearance_q3;

    //6,7,8,9,10,11
    private FreestallShade freestall_shade;
    private FreestallSummerVentilating freestall_summer_ventilating;
    private FreestallMistSpray freestall_mist_spray;
    private FreestallWindBlock freestall_wind_block;
    private FreestallWinterVentilating freestall_winter_ventilating;
    private FreestallCalfShade freestall_calf_shade;
    private FreestallCalfSummerVentilating freestall_calf_summer_ventilating;
    private FreestallCalfMistSpray freestall_calf_mist_spray;
    private FreestallCalfStraw freestall_calf_straw;
    private FreestallCalfWarm freestall_calf_warm;
    private FreestallCalfWindBlock freestall_calf_wind_block;

    private FreestallSlightLimp freestall_slight_limp;
    private FreestallCriticalLimp freestall_critical_limp;
    private FreestallSlightHairloss freestall_slight_hairloss;
    private FreestallCriticalHairloss freestall_critical_hairloss;

    private FreestallRunnyNose freestall_runnynose;
    private FreestallOphthalmic freestall_ophthalmic;
    private FreestallRespiratory freestall_respiratory;
    private FreestallDiarrhea freestall_diarrhea;
    private FreestallOutGenitals freestall_outgenitals;
    private FreestallBreast freestall_breast;
    private FreestallFallDead freestall_falldead;
    private FreestallDystocia freestall_dystocia;
    private FreestallAstasia freestall_astasia;



    private Fragment[] freestall_frag_arr = new Fragment[20];
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
        breed_cough = new BreedCough();
        breed_runny_nose = new BreedRunnyNose();
        breed_ophthalmic = new BreedOphthalmic();
        breed_breath = new BreedBreath();

        // 프리스톨
        freestall_poor = new FreestallPoor();
        freestall_water_q1 = new FreestallWaterQ1();
        freestall_water_q1_1 = new FreestallWaterQ1_1();
        freestall_water_q1_2 = new FreestallWaterQ1_2();
        freestall_water_q2 = new FreestallWaterQ2();
        freestall_water_q3 = new FreestallWaterQ3();
        freestall_count = new FreestallCount();

        freestall_area_out_collision = new FreestallAreaOutCollision();

        freestall_appearance_q1 = new FreestallAppearanceQ1();
        freestall_appearance_q2 = new FreestallAppearanceQ2();
        freestall_appearance_q3 = new FreestallAppearanceQ3();

        freestall_shade = new FreestallShade();
        freestall_summer_ventilating = new FreestallSummerVentilating();
        freestall_mist_spray = new FreestallMistSpray();
        freestall_wind_block = new FreestallWindBlock();
        freestall_winter_ventilating = new FreestallWinterVentilating();
        freestall_calf_shade = new FreestallCalfShade();
        freestall_calf_summer_ventilating = new FreestallCalfSummerVentilating();
        freestall_calf_mist_spray = new FreestallCalfMistSpray();
        freestall_calf_straw = new FreestallCalfStraw();
        freestall_calf_warm = new FreestallCalfWarm();
        freestall_calf_wind_block = new FreestallCalfWindBlock();
        freestall_slight_limp = new FreestallSlightLimp();
        freestall_critical_limp = new FreestallCriticalLimp();
        freestall_slight_hairloss = new FreestallSlightHairloss();
        freestall_critical_hairloss = new FreestallCriticalHairloss();
        freestall_runnynose = new FreestallRunnyNose();
        freestall_ophthalmic = new FreestallOphthalmic();
        freestall_respiratory = new FreestallRespiratory();
        freestall_diarrhea = new FreestallDiarrhea();
        freestall_outgenitals = new FreestallOutGenitals();
        freestall_breast = new FreestallBreast();
        freestall_falldead = new FreestallFallDead();
        freestall_dystocia = new FreestallDystocia();
        freestall_astasia = new FreestallAstasia();

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
                breed_cough,breed_runny_nose,breed_ophthalmic,breed_breath};

        freestall_frag_arr = new Fragment[]{ freestall_poor,freestall_water_q1,freestall_water_q2,freestall_water_q3,
                freestall_count,freestall_area_out_collision,freestall_appearance_q1,freestall_appearance_q2,freestall_appearance_q3,freestall_shade,freestall_summer_ventilating,freestall_mist_spray,
                freestall_wind_block,freestall_winter_ventilating,freestall_calf_shade,freestall_calf_summer_ventilating,freestall_calf_mist_spray,
                freestall_calf_straw,freestall_calf_warm,freestall_calf_wind_block,freestall_slight_limp,freestall_critical_limp,freestall_slight_hairloss,freestall_critical_hairloss,
                breed_cough,freestall_runnynose,freestall_ophthalmic,
                freestall_respiratory,freestall_diarrhea,freestall_outgenitals,freestall_breast,freestall_falldead,freestall_dystocia,freestall_astasia}; // 6,7,8,9,10,11 추가하기



        transaction = fragmentManager.beginTransaction();
        if (inputCheck == 1) {

        }
        else if (inputCheck == 2 || inputCheck == 3) {
            transaction.replace(R.id.fragment_paper, breed_poor).commitAllowingStateLoss();
            total_page.setText(String.valueOf(" / " + breed_frag_arr.length));
        }
        else if (inputCheck == 4) {

        }
        else if (inputCheck == 5) {
            transaction.replace(R.id.fragment_paper, freestall_poor).commitAllowingStateLoss();
            total_page.setText(String.valueOf(" / " + freestall_frag_arr.length));
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
                    nextBtnHandler(count,freestall_frag_arr.length);
                    transaction.replace(R.id.fragment_paper,freestall_frag_arr[++count]).commitAllowingStateLoss();
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
                    prevBtnHandler(count,freestall_frag_arr.length);
                    transaction.replace(R.id.fragment_paper, freestall_frag_arr[--count]).commitAllowingStateLoss();
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

    // freestall Water Q1 Method
    public void fragmentChange(int index) {
        if(index == 1) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_paper, freestall_water_q1_1).commit();
        }
        else if(index == 2) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_paper, freestall_water_q1_2).commit();
        }
    }
}