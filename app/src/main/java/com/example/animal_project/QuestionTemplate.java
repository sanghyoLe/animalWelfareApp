package com.example.animal_project;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.animal_project.Beef.ProtocolFour.AvoidDistance;
import com.example.animal_project.Beef.ProtocolFour.BreedHarmony;
import com.example.animal_project.Beef.ProtocolFour.BreedStruggle;
import com.example.animal_project.Beef.ProtocolOne.Poor;
import com.example.animal_project.Beef.ProtocolOne.WaterTankClean;
import com.example.animal_project.Beef.ProtocolOne.WaterTankNum;
import com.example.animal_project.Beef.ProtocolOne.WaterTime;
import com.example.animal_project.Beef.ProtocolThree.BreedBreath;
import com.example.animal_project.Beef.ProtocolThree.BreedCastrationQ1;
import com.example.animal_project.Beef.ProtocolThree.BreedCastrationQ2;
import com.example.animal_project.Beef.ProtocolThree.BreedCastrationQ3;
import com.example.animal_project.Beef.ProtocolThree.BreedCough;
import com.example.animal_project.Beef.ProtocolThree.BreedCriticalHairLoss;
import com.example.animal_project.Beef.ProtocolThree.BreedDiarrhea;
import com.example.animal_project.Beef.ProtocolThree.BreedFallDead;
import com.example.animal_project.Beef.ProtocolThree.BreedHornQ1;
import com.example.animal_project.Beef.ProtocolThree.BreedHornQ2;
import com.example.animal_project.Beef.ProtocolThree.BreedHornQ3;
import com.example.animal_project.Beef.ProtocolThree.BreedLimp;
import com.example.animal_project.Beef.ProtocolThree.BreedOphthalmic;
import com.example.animal_project.Beef.ProtocolThree.BreedRuminant;
import com.example.animal_project.Beef.ProtocolThree.BreedRunnyNose;
import com.example.animal_project.Beef.ProtocolThree.BreedSlightHairLoss;
import com.example.animal_project.Beef.ProtocolTwo.BreedMistSpray;
import com.example.animal_project.Beef.ProtocolTwo.BreedOutward;
import com.example.animal_project.Beef.ProtocolTwo.BreedShade;
import com.example.animal_project.Beef.ProtocolTwo.BreedStraw;
import com.example.animal_project.Beef.ProtocolTwo.BreedSummerVentilating;
import com.example.animal_project.Beef.ProtocolTwo.BreedWindBlock;
import com.example.animal_project.Beef.ProtocolTwo.BreedWinterVentilating;
import com.example.animal_project.Beef.ProtocolTwo.CalfMistSpray;
import com.example.animal_project.Beef.ProtocolTwo.CalfShade;
import com.example.animal_project.Beef.ProtocolTwo.CalfStraw;
import com.example.animal_project.Beef.ProtocolTwo.CalfSummerVentilating;
import com.example.animal_project.Beef.ProtocolTwo.CalfWarm;
import com.example.animal_project.Beef.ProtocolTwo.CalfWindBlock;
import com.example.animal_project.Insert.InsertAnswer;
import com.example.animal_project.Insert.InsertAvoidDistance;
import com.example.animal_project.Insert.InsertDongAnswer;
import com.example.animal_project.MilkCow.MilkCowScoreCalculator;
import com.example.animal_project.MilkCow.OutwardBack;
import com.example.animal_project.MilkCow.OutwardBackReg;
import com.example.animal_project.MilkCow.OutwardBreast;
import com.example.animal_project.MilkCow.CriticalLimp;
import com.example.animal_project.MilkCow.FreeStallAreaOutCollision;
import com.example.animal_project.MilkCow.FreeStallCount;
import com.example.animal_project.MilkCow.FreeStallSitCollision;
import com.example.animal_project.MilkCow.HardBirth;
import com.example.animal_project.MilkCow.MilkInCell;
import com.example.animal_project.MilkCow.MovementStability;
import com.example.animal_project.MilkCow.OutGenitals;
import com.example.animal_project.MilkCow.SitTime;
import com.example.animal_project.MilkCow.UnableStand;
import com.example.animal_project.Result.ResultActivity;
import com.example.animal_project.Result.ResultTotal;
import com.example.animal_project.Result.ResultProtocolOne;
import com.example.animal_project.Result.ResultProtocolTwo;
import com.example.animal_project.Result.ResultProtocolThree;
import com.example.animal_project.Result.ResultProtocolFour;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

// DataBase 처리를 위한 Import
// ---------------------------------


public class QuestionTemplate extends AppCompatActivity

 {
        private String IP_ADDRESS = "218.151.112.65";

     private MilkCowScoreCalculator mc = new MilkCowScoreCalculator();
     String pdfQuestionName = null;
     // 정보 입력 창에서 넘어온 정보들
     private String farmName;
     private String address;
     private String addressDetail;
     private String farmTypeMsg;
     private String repName;
     private int totalCowSize;
     private int totalAdultCow;
     private int totalChildCow;
     private String evaName;
     private String evaDate;
     public int farmType = 0;
     private String farmId;
     private int sampleCowSize;
     private int milkCowSize;
     private int dryMilkCowSize;
     private int pregnantCowSize;
     // ------------------------------

    // --- 결과 창 ---
    ResultTotal result_total;
    ResultProtocolOne result1;
    ResultProtocolTwo result2;
    ResultProtocolThree result3;
    ResultProtocolFour result4;
    TabLayout tabs;
    Bundle bundle;
    // --------------------------------------------------------
    private LinearLayout fragment_paper;
    private LinearLayout question_top_nav;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    // 한 육우 프로토콜 질문 항목 Fragments
    private Poor breed_poor;
    private WaterTankNum breed_water_q1;
    private WaterTankClean breed_water_q2;
    private WaterTime breed_water_q3;
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
    private AvoidDistance breed_avoid_distance;

    // 착유우 프로토콜 질문 항목 Fragments
     private SitTime sit_time;
     private CriticalLimp criticalLimp;
     private OutwardBackReg outwardBackReg;
     private OutwardBack outwardBack;
     private OutwardBreast outwardBreast;
     private MovementStability movementStability;
     private OutGenitals out_genital;
     private MilkInCell milk_min_cell;
     private HardBirth hard_birth;
     private UnableStand unAble_stand;

    // 프리스톨 프로토콜 질문 항목 Fragments
     private FreeStallCount free_stall_count;
     private FreeStallAreaOutCollision free_stall_area_out_collision;
     private FreeStallSitCollision free_stall_sit_collision;

     // --- UI에 사용되는 버튼들 ---------------------------
    private TextView current_page;
    private TextView total_page;
    private ImageButton prev_btn;
    private ImageButton next_btn;
    private Button end_btn;
    private ImageButton list_btn;
    private ImageButton list_menu_btn_1;
    private ImageButton list_menu_btn_2;
    private ImageButton list_menu_btn_3;
    private ImageButton list_menu_btn_4;
    private Button checkSampleSizeBtn;
    private Button evaWayBtn;
    private Button introWayBtn;
    // --------------------------------------------------------


    // 한 육우 프로토콜 질문 항목 fragments 를 담는 배열
    private Fragment[] breed_frag_arr = new Fragment[20];
    private Fragment[] milk_cow_frag_arr = new Fragment[20];
    private Fragment[] fatten_frag_arr = new Fragment[20];
    private Fragment[] freeStall_frag_arr = new Fragment[20];

    int count = 0;
    QuestionTemplateViewModel viewModel;

    AlertDialog.Builder myAlertBuilder;
    AlertDialog.Builder endBtnAlertBuilder;


    private int[] drawableIdArr = new int[20];



     // 사용자가 이전 안드로이드 이전 버튼 눌렀을 때 처리를 위한 Override
    @Override public void onBackPressed() {
        for (Fragment fragment: getSupportFragmentManager().getFragments()) {
            if (fragment.isVisible()) {
                if (fragment == result1 || fragment == result2 || fragment == result3 || fragment == result4 || fragment == result_total) {

                    break;
                } else {
                    myOnBackPressed(myAlertBuilder);
                }
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_template);
        myAlertBuilder = new AlertDialog.Builder(QuestionTemplate.this);
        endBtnAlertBuilder = new AlertDialog.Builder(QuestionTemplate.this);

        // 결과 창 fragments  ?Activity 로 변경할 지 고민중(변경 시 모든 정보 Bundle 로 결과창에 넘겨주어야 함) ----------------------
        result_total = new ResultTotal();
        result1 = new ResultProtocolOne();
        result2 = new ResultProtocolTwo();
        result3 = new ResultProtocolThree();
        result4 = new ResultProtocolFour();
        // ------------------------------------------

        viewModel = new ViewModelProvider(this).get(QuestionTemplateViewModel.class);
        // pdfView Intent
        Intent pdfViewIntent = new Intent(QuestionTemplate.this,WebViewPdfActivity.class);

        // 회피거리 배열 초기화
        viewModel.setAvoidDistances();
        fragmentManager = getSupportFragmentManager();



        next_btn = findViewById(R.id.next_btn);
        prev_btn = findViewById(R.id.previous_btn);
        current_page = findViewById(R.id.current_page);
        total_page = findViewById(R.id.total_page);
        end_btn = findViewById(R.id.end_btn);
        list_btn = findViewById(R.id.list_btn);
        list_menu_btn_1 = findViewById(R.id.list_menu_btn_1);
        list_menu_btn_2 = findViewById(R.id.list_menu_btn_2);
        list_menu_btn_3 = findViewById(R.id.list_menu_btn_3);
        list_menu_btn_4 = findViewById(R.id.list_menu_btn_4);
        fragment_paper = findViewById(R.id.fragment_paper);
        question_top_nav = findViewById(R.id.question_top_nav);
        checkSampleSizeBtn = findViewById(R.id.check_sample_size_btn);
        evaWayBtn = findViewById(R.id.eva_way_btn);
        introWayBtn = findViewById(R.id.intro_way_btn);

        // 평가를 위한 프래그먼트들
        breed_poor = new Poor();
        breed_water_q1 = new WaterTankNum();
        breed_water_q2 = new WaterTankClean();
        breed_water_q3 = new WaterTime();
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
        breed_avoid_distance = new AvoidDistance();

        // 착유우
        sit_time = new SitTime();
        outwardBackReg = new OutwardBackReg();
        outwardBack = new OutwardBack();
        outwardBreast = new OutwardBreast();
        criticalLimp = new CriticalLimp();
        movementStability = new MovementStability();
        milk_min_cell = new MilkInCell();
        out_genital = new OutGenitals();
        hard_birth = new HardBirth();
        unAble_stand = new UnableStand();

        // 프리스톨
        free_stall_count = new FreeStallCount();
        free_stall_sit_collision = new FreeStallSitCollision();
        free_stall_area_out_collision = new FreeStallAreaOutCollision();
        // 마지막 페이지 개수 지정

        Intent intent = getIntent();
        Bundle BeforeBundle = intent.getExtras();

        // ----- 실제 서비스에서 저장되어야 하는 정보 ----
        farmName = BeforeBundle.getString("farmName");
        address = BeforeBundle.getString("address");
        addressDetail = BeforeBundle.getString("addressDetail");
        repName = BeforeBundle.getString("repName");
        totalCowSize = BeforeBundle.getInt("totalCow");
        totalAdultCow = BeforeBundle.getInt("totalAdultCow");
        totalChildCow = BeforeBundle.getInt("totalChildCow");
        evaName = BeforeBundle.getString("evaName");
        evaDate = BeforeBundle.getString("evaDate");
        farmType = BeforeBundle.getInt("farmType");
        farmTypeMsg = BeforeBundle.getString("farmTypeMsg");
        sampleCowSize = BeforeBundle.getInt("sampleCow");
        farmId = BeforeBundle.getString("farmId");
        milkCowSize = BeforeBundle.getInt("milkCow");
        dryMilkCowSize = BeforeBundle.getInt("dryMilkCow");
        pregnantCowSize = BeforeBundle.getInt("pregnantCow");



        // ------------------------------------------------
        Bundle bundle = new Bundle(1);
        bundle.putInt("farmType",farmType);
        breed_winter_ventilating.setArguments(bundle);
        // ---- 테스트를 위한 최소 정보 ---------
  
        // ------------------------------------
        viewModel.setSampleCowSize(sampleCowSize);
        viewModel.setTotalCowSize(totalCowSize);
        viewModel.setAdultCowSize(totalAdultCow);
        viewModel.setMilkCowSize(milkCowSize);
        viewModel.setChildCowSize(totalChildCow);
        viewModel.setDryMilkCowSize(dryMilkCowSize);
        viewModel.setPregnantCowSize(pregnantCowSize);


        viewModel.setFarmType(farmType);
        breed_frag_arr = new Fragment[]{ breed_poor,breed_water_q1,breed_water_q2,breed_water_q3,
                breed_straw,breed_outward,breed_shade,breed_summer_ventilating,breed_mist_spray,
                breed_wind_block,breed_winter_ventilating,calf_shade,calf_summer_ventilating,calf_mist_spray,
                calf_straw,calf_warm,calf_wind_block,breed_limp,breed_slight_hair_loss,breed_critical_hair_loss,
                breed_cough,breed_runny_nose,breed_ophthalmic,breed_breath,breed_diarrhea,breed_ruminant,breed_fall_dead,
                breed_horn_q1,breed_horn_q2,breed_horn_q3,breed_castration_q1,breed_castration_q2,breed_castration_q3,
                breed_struggle,breed_harmony,breed_avoid_distance};

        fatten_frag_arr = new Fragment[]{breed_poor,breed_water_q1,breed_water_q2,breed_water_q3,
                breed_straw,breed_outward,breed_shade,breed_summer_ventilating,breed_mist_spray,
                breed_wind_block,breed_winter_ventilating,breed_limp,breed_slight_hair_loss,breed_critical_hair_loss,
                breed_cough,breed_runny_nose,breed_ophthalmic,breed_breath,breed_diarrhea,breed_ruminant,breed_fall_dead,
                breed_horn_q1,breed_horn_q2,breed_horn_q3,breed_castration_q1,breed_castration_q2,breed_castration_q3,
                breed_struggle,breed_harmony,breed_avoid_distance
        };
        milk_cow_frag_arr = new Fragment[]{breed_poor,breed_water_q1,breed_water_q2,breed_water_q3,sit_time, outwardBackReg, outwardBack, outwardBreast
                ,breed_shade,breed_summer_ventilating,breed_mist_spray,
                breed_wind_block,breed_winter_ventilating,calf_shade,calf_summer_ventilating,calf_mist_spray,
                calf_straw,calf_warm,calf_wind_block,movementStability,breed_limp,criticalLimp,breed_slight_hair_loss,breed_critical_hair_loss,breed_cough,
                breed_runny_nose,breed_ophthalmic,breed_breath,breed_diarrhea,out_genital,milk_min_cell,breed_fall_dead,hard_birth, unAble_stand,
                breed_horn_q1,breed_horn_q2,breed_horn_q3,breed_castration_q1,breed_castration_q2,breed_castration_q3,breed_struggle,breed_avoid_distance
        };

        freeStall_frag_arr = new Fragment[]{breed_poor,breed_water_q1,breed_water_q2,breed_water_q3,
                free_stall_count,free_stall_sit_collision, free_stall_area_out_collision, sit_time, outwardBackReg, outwardBack, outwardBreast
                ,breed_shade,breed_summer_ventilating,breed_mist_spray,
                breed_wind_block,breed_winter_ventilating,calf_shade,calf_summer_ventilating,calf_mist_spray,
                calf_straw,calf_warm,calf_wind_block,movementStability,breed_limp,criticalLimp,breed_slight_hair_loss,breed_critical_hair_loss,breed_cough,
                breed_runny_nose,breed_ophthalmic,breed_breath,breed_diarrhea,out_genital,milk_min_cell,breed_fall_dead,hard_birth, unAble_stand,
                breed_horn_q1,breed_horn_q2,breed_horn_q3,breed_castration_q1,breed_castration_q2,breed_castration_q3,breed_struggle,breed_avoid_distance
        };
        LinearLayout listSubMenuLayoutOne = findViewById(R.id.list_sub_menu_1);
        LinearLayout listSubMenuLayoutTwo = findViewById(R.id.list_sub_menu_2);
        LinearLayout listSubMenuLayoutThree = findViewById(R.id.list_sub_menu_3);
        LinearLayout listSubMenuLayoutFour = findViewById(R.id.list_sub_menu_4);
        ImageButton breed_list_btn_1 = listSubMenuLayoutOne.findViewById(R.id.question_list_btn_1);
        ImageButton breed_list_btn_2 = listSubMenuLayoutOne.findViewById(R.id.question_list_btn_2);
        ImageButton breed_list_btn_3 = listSubMenuLayoutOne.findViewById(R.id.question_list_btn_3);
        ImageButton breed_list_btn_4 = listSubMenuLayoutOne.findViewById(R.id.question_list_btn_4);
        ImageButton breed_list_btn_5 = listSubMenuLayoutTwo.findViewById(R.id.question_list_btn_5);
        ImageButton breed_list_btn_6 = listSubMenuLayoutTwo.findViewById(R.id.question_list_btn_6);
        ImageButton breed_list_btn_7 = listSubMenuLayoutTwo.findViewById(R.id.question_list_btn_7);
        ImageButton breed_list_btn_8 = listSubMenuLayoutTwo.findViewById(R.id.question_list_btn_8);
        ImageButton breed_list_btn_9 = listSubMenuLayoutTwo.findViewById(R.id.question_list_btn_9);
        ImageButton breed_list_btn_10 = listSubMenuLayoutTwo.findViewById(R.id.question_list_btn_10);
        ImageButton breed_list_btn_11 = listSubMenuLayoutTwo.findViewById(R.id.question_list_btn_11);
        ImageButton breed_list_btn_12 = listSubMenuLayoutTwo.findViewById(R.id.question_list_btn_12);
        ImageButton breed_list_btn_13 = listSubMenuLayoutTwo.findViewById(R.id.question_list_btn_13);
        ImageButton breed_list_btn_14 = listSubMenuLayoutTwo.findViewById(R.id.question_list_btn_14);
        ImageButton breed_list_btn_15 = listSubMenuLayoutTwo.findViewById(R.id.question_list_btn_15);
        ImageButton breed_list_btn_16 = listSubMenuLayoutTwo.findViewById(R.id.question_list_btn_16);
        ImageButton breed_list_btn_17 = listSubMenuLayoutTwo.findViewById(R.id.question_list_btn_17);
        ImageButton breed_list_btn_18 = listSubMenuLayoutThree.findViewById(R.id.question_list_btn_18);
        ImageButton breed_list_btn_19 = listSubMenuLayoutThree.findViewById(R.id.question_list_btn_19);
        ImageButton breed_list_btn_20 = listSubMenuLayoutThree.findViewById(R.id.question_list_btn_20);
        ImageButton breed_list_btn_21 = listSubMenuLayoutThree.findViewById(R.id.question_list_btn_21);
        ImageButton breed_list_btn_22 = listSubMenuLayoutThree.findViewById(R.id.question_list_btn_22);
        ImageButton breed_list_btn_23 = listSubMenuLayoutThree.findViewById(R.id.question_list_btn_23);
        ImageButton breed_list_btn_24 = listSubMenuLayoutThree.findViewById(R.id.question_list_btn_24);
        ImageButton breed_list_btn_25 = listSubMenuLayoutThree.findViewById(R.id.question_list_btn_25);
        ImageButton breed_list_btn_26 = listSubMenuLayoutThree.findViewById(R.id.question_list_btn_26);
        ImageButton breed_list_btn_27 = listSubMenuLayoutThree.findViewById(R.id.question_list_btn_27);
        ImageButton breed_list_btn_28 = listSubMenuLayoutThree.findViewById(R.id.question_list_btn_28);
        ImageButton breed_list_btn_29 = listSubMenuLayoutThree.findViewById(R.id.question_list_btn_29);
        ImageButton breed_list_btn_30 = listSubMenuLayoutThree.findViewById(R.id.question_list_btn_30);
        ImageButton breed_list_btn_31 = listSubMenuLayoutThree.findViewById(R.id.question_list_btn_31);
        ImageButton breed_list_btn_32 = listSubMenuLayoutThree.findViewById(R.id.question_list_btn_32);
        ImageButton breed_list_btn_33 = listSubMenuLayoutThree.findViewById(R.id.question_list_btn_33);
        ImageButton breed_list_btn_34 = listSubMenuLayoutFour.findViewById(R.id.question_list_btn_34);
        ImageButton breed_list_btn_35 = listSubMenuLayoutFour.findViewById(R.id.question_list_btn_35);
        ImageButton breed_list_btn_36 = listSubMenuLayoutFour.findViewById(R.id.question_list_btn_36);

        ImageButton[] breed_list_btn_arr = {
                breed_list_btn_1,breed_list_btn_2,breed_list_btn_3,breed_list_btn_4,breed_list_btn_5,
                breed_list_btn_6,breed_list_btn_7,breed_list_btn_8,breed_list_btn_9,breed_list_btn_10,
                breed_list_btn_11,breed_list_btn_12,breed_list_btn_13,breed_list_btn_14,breed_list_btn_15,
                breed_list_btn_16,breed_list_btn_17,breed_list_btn_18,breed_list_btn_19,breed_list_btn_20,
                breed_list_btn_21,breed_list_btn_22,breed_list_btn_23,breed_list_btn_24,breed_list_btn_25,
                breed_list_btn_26,breed_list_btn_27,breed_list_btn_28,breed_list_btn_29,breed_list_btn_30,
                breed_list_btn_31,breed_list_btn_32,breed_list_btn_33,breed_list_btn_34,breed_list_btn_35,
                breed_list_btn_36};

        View fattenListSubMenuView = findViewById(R.id.fatten_list_sub_menu_2);
        ImageButton fatten_list_btn_5 = fattenListSubMenuView.findViewById(R.id.question_list_btn_5);
        ImageButton fatten_list_btn_6 = fattenListSubMenuView.findViewById(R.id.question_list_btn_6);
        ImageButton fatten_list_btn_7 = fattenListSubMenuView.findViewById(R.id.question_list_btn_7);
        ImageButton fatten_list_btn_8 = fattenListSubMenuView.findViewById(R.id.question_list_btn_8);
        ImageButton fatten_list_btn_9 = fattenListSubMenuView.findViewById(R.id.question_list_btn_9);
        ImageButton fatten_list_btn_10 = fattenListSubMenuView.findViewById(R.id.question_list_btn_10);
        ImageButton fatten_list_btn_11 = fattenListSubMenuView.findViewById(R.id.question_list_btn_11);


        ImageButton[] fatten_list_btn_arr=  {
                breed_list_btn_1,breed_list_btn_2,breed_list_btn_3,breed_list_btn_4,fatten_list_btn_5,
                fatten_list_btn_6,fatten_list_btn_7,fatten_list_btn_8,fatten_list_btn_9,fatten_list_btn_10, fatten_list_btn_11,
                breed_list_btn_18,breed_list_btn_19,breed_list_btn_20, breed_list_btn_21,breed_list_btn_22,breed_list_btn_23,
                breed_list_btn_24,breed_list_btn_25, breed_list_btn_26,breed_list_btn_27,breed_list_btn_28,breed_list_btn_29,
                breed_list_btn_30, breed_list_btn_31,breed_list_btn_32,breed_list_btn_33,breed_list_btn_34,breed_list_btn_35,
                breed_list_btn_36};

        View milkCowListSubMenuViewTwo = findViewById(R.id.milk_cow_list_sub_menu_2);
        View milkCowListSubMenuViewThree = findViewById(R.id.milk_cow_list_sub_menu_3);
        View milkCowListSubMenuViewFour = findViewById(R.id.milk_cow_list_sub_menu_4);
        ImageButton milk_cow_list_btn_5 = milkCowListSubMenuViewTwo.findViewById(R.id.question_list_btn_5);
        ImageButton milk_cow_list_btn_6 = milkCowListSubMenuViewTwo.findViewById(R.id.question_list_btn_6);
        ImageButton milk_cow_list_btn_7 = milkCowListSubMenuViewTwo.findViewById(R.id.question_list_btn_7);
        ImageButton milk_cow_list_btn_8 = milkCowListSubMenuViewTwo.findViewById(R.id.question_list_btn_8);
        ImageButton milk_cow_list_btn_9 = milkCowListSubMenuViewTwo.findViewById(R.id.question_list_btn_9);
        ImageButton milk_cow_list_btn_10 = milkCowListSubMenuViewTwo.findViewById(R.id.question_list_btn_10);
        ImageButton milk_cow_list_btn_11 = milkCowListSubMenuViewTwo.findViewById(R.id.question_list_btn_11);
        ImageButton milk_cow_list_btn_12 = milkCowListSubMenuViewTwo.findViewById(R.id.question_list_btn_12);
        ImageButton milk_cow_list_btn_13 = milkCowListSubMenuViewTwo.findViewById(R.id.question_list_btn_13);
        ImageButton milk_cow_list_btn_14 = milkCowListSubMenuViewTwo.findViewById(R.id.question_list_btn_14);
        ImageButton milk_cow_list_btn_15 = milkCowListSubMenuViewTwo.findViewById(R.id.question_list_btn_15);
        ImageButton milk_cow_list_btn_16 = milkCowListSubMenuViewTwo.findViewById(R.id.question_list_btn_16);
        ImageButton milk_cow_list_btn_17 = milkCowListSubMenuViewTwo.findViewById(R.id.question_list_btn_17);
        ImageButton milk_cow_list_btn_18 = milkCowListSubMenuViewTwo.findViewById(R.id.question_list_btn_18);
        ImageButton milk_cow_list_btn_19 = milkCowListSubMenuViewTwo.findViewById(R.id.question_list_btn_19);
        ImageButton movementStabilityBtn = milkCowListSubMenuViewTwo.findViewById(R.id.movement_stability_move_btn);
        ImageButton milk_cow_list_btn_20 = milkCowListSubMenuViewThree.findViewById(R.id.question_list_btn_20);
        ImageButton milk_cow_list_btn_21 = milkCowListSubMenuViewThree.findViewById(R.id.question_list_btn_21);
        ImageButton milk_cow_list_btn_22 = milkCowListSubMenuViewThree.findViewById(R.id.question_list_btn_22);
        ImageButton milk_cow_list_btn_23 = milkCowListSubMenuViewThree.findViewById(R.id.question_list_btn_23);
        ImageButton milk_cow_list_btn_24 = milkCowListSubMenuViewThree.findViewById(R.id.question_list_btn_24);
        ImageButton milk_cow_list_btn_25 = milkCowListSubMenuViewThree.findViewById(R.id.question_list_btn_25);
        ImageButton milk_cow_list_btn_26 = milkCowListSubMenuViewThree.findViewById(R.id.question_list_btn_26);
        ImageButton milk_cow_list_btn_27 = milkCowListSubMenuViewThree.findViewById(R.id.question_list_btn_27);
        ImageButton milk_cow_list_btn_28 = milkCowListSubMenuViewThree.findViewById(R.id.question_list_btn_28);
        ImageButton milk_cow_list_btn_29 = milkCowListSubMenuViewThree.findViewById(R.id.question_list_btn_29);
        ImageButton milk_cow_list_btn_30 = milkCowListSubMenuViewThree.findViewById(R.id.question_list_btn_30);
        ImageButton milk_cow_list_btn_31 = milkCowListSubMenuViewThree.findViewById(R.id.question_list_btn_31);
        ImageButton milk_cow_list_btn_32 = milkCowListSubMenuViewThree.findViewById(R.id.question_list_btn_32);
        ImageButton milk_cow_list_btn_33 = milkCowListSubMenuViewThree.findViewById(R.id.question_list_btn_33);
        ImageButton milk_cow_list_btn_34 = milkCowListSubMenuViewThree.findViewById(R.id.question_list_btn_34);
        ImageButton milk_cow_list_btn_35 = milkCowListSubMenuViewThree.findViewById(R.id.question_list_btn_35);
        ImageButton milk_cow_list_btn_36 = milkCowListSubMenuViewThree.findViewById(R.id.question_list_btn_36);
        ImageButton milk_cow_list_btn_37 = milkCowListSubMenuViewThree.findViewById(R.id.question_list_btn_37);
        ImageButton milk_cow_list_btn_38 = milkCowListSubMenuViewThree.findViewById(R.id.question_list_btn_38);
        ImageButton milk_cow_list_btn_39 = milkCowListSubMenuViewThree.findViewById(R.id.question_list_btn_39);
        ImageButton milk_cow_list_btn_40 = milkCowListSubMenuViewFour.findViewById(R.id.question_list_btn_40);
        ImageButton milk_cow_list_btn_41 = milkCowListSubMenuViewFour.findViewById(R.id.question_list_btn_41);

        ImageButton[] milk_cow_list_btn_arr = {breed_list_btn_1,breed_list_btn_2,breed_list_btn_3,breed_list_btn_4,milk_cow_list_btn_5,
                milk_cow_list_btn_6,milk_cow_list_btn_7,milk_cow_list_btn_8,milk_cow_list_btn_9,milk_cow_list_btn_10,
                milk_cow_list_btn_11,milk_cow_list_btn_12,milk_cow_list_btn_13,milk_cow_list_btn_14,milk_cow_list_btn_15
        ,milk_cow_list_btn_16,milk_cow_list_btn_17,milk_cow_list_btn_18,milk_cow_list_btn_19,movementStabilityBtn,milk_cow_list_btn_20,milk_cow_list_btn_21,
                milk_cow_list_btn_22,milk_cow_list_btn_23,milk_cow_list_btn_24,milk_cow_list_btn_25,milk_cow_list_btn_26,milk_cow_list_btn_27,
                milk_cow_list_btn_28,milk_cow_list_btn_29,milk_cow_list_btn_30,milk_cow_list_btn_31,milk_cow_list_btn_32,milk_cow_list_btn_33,
                milk_cow_list_btn_34,milk_cow_list_btn_35,milk_cow_list_btn_36,milk_cow_list_btn_37,milk_cow_list_btn_38,milk_cow_list_btn_39,
                milk_cow_list_btn_40, milk_cow_list_btn_41};


        ImageButton free_stall_list_btn_1 = milkCowListSubMenuViewTwo.findViewById(R.id.free_stall_list_btn_1);
        ImageButton free_stall_list_btn_2 = milkCowListSubMenuViewTwo.findViewById(R.id.free_stall_list_btn_2);
        ImageButton free_stall_list_btn_3 = milkCowListSubMenuViewTwo.findViewById(R.id.free_stall_list_btn_3);
        ImageButton[] free_stall_list_btn_arr = {breed_list_btn_1,breed_list_btn_2,breed_list_btn_3,breed_list_btn_4,
                free_stall_list_btn_1,free_stall_list_btn_2,free_stall_list_btn_3,
                milk_cow_list_btn_5, milk_cow_list_btn_6,milk_cow_list_btn_7,milk_cow_list_btn_8,milk_cow_list_btn_9,milk_cow_list_btn_10,
                milk_cow_list_btn_11,milk_cow_list_btn_12,milk_cow_list_btn_13,milk_cow_list_btn_14,milk_cow_list_btn_15
                ,milk_cow_list_btn_16,milk_cow_list_btn_17,milk_cow_list_btn_18,milk_cow_list_btn_19,movementStabilityBtn,milk_cow_list_btn_20,milk_cow_list_btn_21,
                milk_cow_list_btn_22,milk_cow_list_btn_23,milk_cow_list_btn_24,milk_cow_list_btn_25,milk_cow_list_btn_26,milk_cow_list_btn_27,
                milk_cow_list_btn_28,milk_cow_list_btn_29,milk_cow_list_btn_30,milk_cow_list_btn_31,milk_cow_list_btn_32,milk_cow_list_btn_33,
                milk_cow_list_btn_34,milk_cow_list_btn_35,milk_cow_list_btn_36,milk_cow_list_btn_37,milk_cow_list_btn_38,milk_cow_list_btn_39,
                milk_cow_list_btn_40, milk_cow_list_btn_41};

        drawableIdArr = new int[]{
                R.drawable.sit_collision
        };


        // 표본 규모 확인 버튼
        checkSampleSizeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Fragment fragment: getSupportFragmentManager().getFragments()) {
                    if (fragment.isVisible()) {
                        List<String> inputMessage = new ArrayList<String>();
                        inputMessage.add(farmTypeMsg);
                        inputMessage.add( String.valueOf(totalCowSize));
                        inputMessage.add(String.valueOf(totalChildCow));
                        inputMessage.add(String.valueOf(sampleCowSize));
                        inputMessage.add(String.valueOf(farmType));
                        if(viewModel.isBeef(farmType)){
                            inputMessage.add(String.valueOf(totalAdultCow));
                        }
                        else {
                            inputMessage.add(String.valueOf(milkCowSize));
                            inputMessage.add(String.valueOf(dryMilkCowSize));
                            inputMessage.add(String.valueOf(pregnantCowSize));
                        }

                        CheckSampleSizeDialog checkSampleSizeDialog = new CheckSampleSizeDialog(fragment.getContext());
                        checkSampleSizeDialog.viewSampleSize(inputMessage);
                    }
                    }
                }

        });

        evaWayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (Fragment fragment : getSupportFragmentManager().getFragments()) {
                    if (fragment.isVisible()) {
                        if (viewModel.isBeef(viewModel.getFarmType())) {
                            for (int i = 0; i < breed_frag_arr.length; i++) {
                                if (fragment == breed_frag_arr[i]) {
                                    pdfViewIntent.putExtra("farmType", farmType);
                                    if (fragment == breed_poor) {
                                        pdfQuestionName = "poor";
                                    } else if (fragment == breed_water_q2) {
                                        pdfQuestionName = "waterClean";
                                    } else if (fragment == breed_straw) {
                                        pdfQuestionName = "straw";
                                    } else if (fragment == breed_outward) {
                                        pdfQuestionName = "outward";
                                    } else if (fragment == breed_shade
                                            || fragment == breed_summer_ventilating
                                            || fragment == breed_winter_ventilating) {
                                        pdfQuestionName = "shadeVen";
                                    } else if (fragment == breed_mist_spray
                                            || fragment == calf_mist_spray) {
                                        pdfQuestionName = "mistSpray";
                                    } else if (fragment == breed_wind_block) {
                                        pdfQuestionName = "windBlock";
                                    } else if (fragment == calf_shade
                                            || fragment == calf_summer_ventilating
                                            || fragment == calf_straw
                                            || fragment == calf_warm
                                            || fragment == calf_wind_block) {
                                        pdfQuestionName = "calf";
                                    } else if (fragment == breed_slight_hair_loss
                                            || fragment == breed_critical_hair_loss) {
                                    pdfQuestionName = "hairLoss";
                                    } else if (fragment == breed_runny_nose
                                            || fragment == breed_ophthalmic
                                            || fragment == breed_diarrhea) {
                                        pdfQuestionName = "noseEyeDiarrhea";
                                    } else if (fragment == breed_struggle) {
                                        pdfQuestionName = "struggle";
                                    } else if (fragment == breed_avoid_distance) {
                                        pdfQuestionName = "avoidDistance";
                                    } else {
                                        pdfQuestionName = null;
                                    }
                                }

                            }
                        } else {
                            for(int i = 0; i < freeStall_frag_arr.length; i++){
                                if(fragment == freeStall_frag_arr[i]){
                                    if(!viewModel.isBeef(viewModel.getFarmType())) {
                                        pdfViewIntent.putExtra("farmType",farmType);
                                        if(fragment == breed_poor) { pdfQuestionName = "poor";}
                                        else if(fragment == breed_water_q2) { pdfQuestionName = "waterClean";}
                                        else if(fragment == free_stall_count) { pdfQuestionName = "freeStallCount"; }
                                        else if(fragment == free_stall_sit_collision) { pdfQuestionName = "sitCollision"; }
                                        else if(fragment == sit_time) { pdfQuestionName = "sitTime"; }
                                        else if(fragment == outwardBackReg) { pdfQuestionName = "outwardBackReg"; }
                                        else if(fragment == outwardBack) { pdfQuestionName = "outwardBack"; }
                                        else if(fragment == breed_shade) { pdfQuestionName = "shade"; }
                                        else if(fragment == breed_summer_ventilating) { pdfQuestionName = "pen"; }
                                        else if(fragment == breed_mist_spray) { pdfQuestionName = "mistSpray"; }
                                        else if(fragment == breed_wind_block) { pdfQuestionName = "windBlock"; }
                                        else if(fragment == breed_winter_ventilating) { pdfQuestionName = "ventilating"; }
                                        else if(fragment == calf_shade) { pdfQuestionName = "shade"; }
                                        else if(fragment == calf_summer_ventilating) { pdfQuestionName = "pen"; }
                                        else if(fragment == calf_mist_spray) { pdfQuestionName = "mistSpray"; }
                                        else if(fragment == calf_straw) { pdfQuestionName = "calf"; }
                                        else if(fragment == calf_warm) { pdfQuestionName = "calf"; }
                                        else if(fragment == calf_wind_block) { pdfQuestionName = "windBlock"; }
                                        else if(fragment == breed_avoid_distance) { pdfQuestionName = "avoidDistance"; }
                                        else { pdfQuestionName = null; }
                                    }
                                }
                            }
                        }
                        }
                    }

                if(pdfQuestionName != null){
                    pdfViewIntent.putExtra("questionName", pdfQuestionName);
                    startActivity(pdfViewIntent);
                } else {
                    Toast.makeText(getApplicationContext(),"해당 평가에 대한 평가방법이 없습니다.",Toast.LENGTH_SHORT).show();
                }

                }
            });
        introWayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(viewModel.isBeef(viewModel.getFarmType())){
                    pdfViewIntent.putExtra("farmType",farmType);
                    pdfViewIntent.putExtra("questionName","beefIntro");
                } else {
                    pdfViewIntent.putExtra("farmType",farmType);
                    pdfViewIntent.putExtra("questionName","intro");
                }
                startActivity(pdfViewIntent);
            }
        });

        transaction = fragmentManager.beginTransaction();



        // 목록 버튼 누르면 왼쪽에서 나오는 드로우 나타내기 및 없애기 & 체크 이미지 바꾸기
        list_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(farmType == 1 || farmType == 2 || farmType == 3) {
                    drawerHandler();
                    changeCheckImageFunc();
                }
                else if(farmType == 4 || farmType == 5) {
                    drawerHandler();
                    changeCheckImageMilkCowFunc();
                }
            }
        });
        list_menu_btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    View view = findViewById(R.id.list_sub_menu_1);
                    listMenuBtnHandler(list_menu_btn_1,view);
            }
        });
        list_menu_btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (farmType == 1) {
                    View fattenView = findViewById(R.id.fatten_list_sub_menu_2);
                    listMenuBtnHandler(list_menu_btn_2, fattenView);
                }
                else if (farmType == 2 || farmType == 3) {
                    View view = findViewById(R.id.list_sub_menu_2);
                    listMenuBtnHandler(list_menu_btn_2, view);
                } else if(farmType == 4){
                    View milkCowView = findViewById(R.id.milk_cow_list_sub_menu_2);
                    listMenuBtnHandler(list_menu_btn_2,milkCowView);
                }
                else if(farmType == 5 ){
                    View freeStallCowView = findViewById(R.id.milk_cow_list_sub_menu_2);
                    LinearLayout freeStallListLayout_1 = freeStallCowView.findViewById(R.id.free_stall_list_layout_1);
                    freeStallListLayout_1.setVisibility(View.VISIBLE);
                    LinearLayout freeStallListLayout_2 = freeStallCowView.findViewById(R.id.free_stall_list_layout_2);
                    freeStallListLayout_2.setVisibility(View.VISIBLE);
                    LinearLayout freeStallListLayout_3 = freeStallCowView.findViewById(R.id.free_stall_list_layout_3);
                    freeStallListLayout_3.setVisibility(View.VISIBLE);

                    listMenuBtnHandler(list_menu_btn_2,freeStallCowView);
                }
            }
        });
        list_menu_btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(farmType == 1 || farmType == 2 || farmType == 3) {
                    View view = findViewById(R.id.list_sub_menu_3);
                    listMenuBtnHandler(list_menu_btn_3,view);
                }else if(farmType == 4 || farmType == 5){
                    View view = findViewById(R.id.milk_cow_list_sub_menu_3);
                    listMenuBtnHandler(list_menu_btn_3,view);
                }

            }
        });
        list_menu_btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(farmType == 1 || farmType == 2 || farmType == 3) {
                    View view = findViewById(R.id.list_sub_menu_4);
                    listMenuBtnHandler(list_menu_btn_4,view);
                }
                else if(farmType == 4 || farmType == 5){
                    View view =findViewById(R.id.milk_cow_list_sub_menu_4);
                    listMenuBtnHandler(list_menu_btn_4,view);
                }

            }
        });

        transaction = fragmentManager.beginTransaction();

        if (farmType == 1) {
            transaction.replace(R.id.fragment_paper, breed_poor).commitAllowingStateLoss();
            total_page.setText(String.valueOf(" / " + fatten_frag_arr.length));
            count = listBtnHandler(fatten_list_btn_arr,fatten_frag_arr);
        }
        else if (farmType == 2 || farmType == 3) {
            transaction.replace(R.id.fragment_paper, breed_poor).commitAllowingStateLoss();
            total_page.setText(String.valueOf(" / " + breed_frag_arr.length));
            count = listBtnHandler(breed_list_btn_arr,breed_frag_arr);

        }
        else if (farmType == 4) {
            transaction.replace(R.id.fragment_paper, breed_poor).commitAllowingStateLoss();
            total_page.setText(" / " + milk_cow_frag_arr.length);
            count = listBtnHandler(milk_cow_list_btn_arr,milk_cow_frag_arr);

        }
        else if (farmType == 5) {
            transaction.replace(R.id.fragment_paper, breed_poor).commitAllowingStateLoss();
            total_page.setText(String.valueOf(" / " + freeStall_frag_arr.length));
            count = listBtnHandler(free_stall_list_btn_arr,freeStall_frag_arr);
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
                if (farmType == 1) {
                    nextBtnHandler(count,fatten_frag_arr.length);
                    transaction.replace(R.id.fragment_paper,fatten_frag_arr[++count]).commitAllowingStateLoss();
                }
                else if (farmType == 2 || farmType == 3) {


                    nextBtnHandler(count,breed_frag_arr.length);
                    transaction.replace(R.id.fragment_paper,breed_frag_arr[++count]).commitAllowingStateLoss();

                }
                else if (farmType == 4) {
                    nextBtnHandler(count,milk_cow_frag_arr.length);
                    transaction.replace(R.id.fragment_paper, milk_cow_frag_arr[++count]).commitAllowingStateLoss();
                }
                else if (farmType == 5) {
                    nextBtnHandler(count, freeStall_frag_arr.length);
                    transaction.replace(R.id.fragment_paper, freeStall_frag_arr[++count]).commitAllowingStateLoss();
                }
                current_page.setText(String.valueOf(count+1));

                break;
            // 이전 버튼 누를 시 이어질 페이지 지정
            case R.id.previous_btn:
                if (farmType == 1) {
                    prevBtnHandler(count,fatten_frag_arr.length);
                    transaction.replace(R.id.fragment_paper, fatten_frag_arr[--count]).commitAllowingStateLoss();
                }
                else if (farmType == 2 || farmType == 3) {
                    prevBtnHandler(count,breed_frag_arr.length);
                    transaction.replace(R.id.fragment_paper, breed_frag_arr[--count]).commitAllowingStateLoss();
                }
                else if (farmType == 4) {
                    prevBtnHandler(count,milk_cow_frag_arr.length);
                    transaction.replace(R.id.fragment_paper, milk_cow_frag_arr[--count]).commitAllowingStateLoss();
                }

                else if (farmType == 5) {
                    prevBtnHandler(count, freeStall_frag_arr.length);
                    transaction.replace(R.id.fragment_paper, freeStall_frag_arr[--count]).commitAllowingStateLoss();
                }
                current_page.setText(String.valueOf(count+1));
                break;
            case R.id.back_btn:
                myOnBackPressed(myAlertBuilder);
                break;


            case R.id.end_btn:
                // database 연동
                if(checkEvaEndBtn() != null) {
                    String msg = checkEvaEndBtn() + " 항목을 완료해주세요";

                    Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
                }
                else{
                    endBtnAlertBuilder.setTitle("완료");
                    endBtnAlertBuilder.setMessage("평가를 완료하면\n평가 내용을 수정할 수 없습니다.\n평가를 완료하시겠습니까?");
                    // 버튼 추가 (Ok 버튼과 Cancle 버튼 )
                    endBtnAlertBuilder.setPositiveButton("취소",new DialogInterface.OnClickListener(){
                        public void onClick(DialogInterface dialog,int which){

                        }
                    });
                    endBtnAlertBuilder.setNegativeButton("네", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            viewModel.setTotalProtocolScoreString(
                                    viewModel.calculatorTotalProtocolScoreString(
                                            viewModel.getProtocolOneScore(),
                                            viewModel.getProtocolTwoScore(),
                                            viewModel.getProtocolThreeScore(),
                                            viewModel.getProtocolFourScore()
                                    )
                            );
                            InsertAnswerFunc();
                            Bundle resultBundle = new Bundle();
                            makeResultBundle(resultBundle);
                            Intent intentResultActivity = new Intent(QuestionTemplate.this, ResultActivity.class);
                            intentResultActivity.putExtras(resultBundle);
                            startActivity(intentResultActivity);
                            finish();
                        }
                    });
                    endBtnAlertBuilder.show();

                 }



        }
    }

    private int listBtnHandler(ImageButton[] btnArr,Fragment[] fragments){

        for(int i = 0 ; i < btnArr.length ; i++){
            int finalI = i;
            btnArr[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                    count = finalI;
                    if(count == 0){
                        prev_btn.setVisibility(View.INVISIBLE);
                        next_btn.setVisibility(View.VISIBLE);
                        end_btn.setVisibility(View.GONE);
                    } else if(count == btnArr.length-1) {
                        end_btn.setVisibility(View.VISIBLE);
                        next_btn.setVisibility(View.INVISIBLE);
                        prev_btn.setVisibility(View.VISIBLE);
                    } else{
                        next_btn.setVisibility(View.VISIBLE);
                        prev_btn.setVisibility(View.VISIBLE);
                        end_btn.setVisibility(View.GONE);
                    }
                    current_page.setText(String.valueOf(count+1));
                    closeDrawer();
                    hideKeyboard(QuestionTemplate.this);
                    transaction.replace(R.id.fragment_paper,fragments[count]).commitAllowingStateLoss();
                }
            });
        }
        return count;


    }
    private void nextBtnHandler(int count, int totalPageLength){
        hideKeyboard(QuestionTemplate.this);
        if(count + 2 == totalPageLength){
            next_btn.setVisibility(View.INVISIBLE);
            end_btn.setVisibility(View.VISIBLE);
        }
        prev_btn.setVisibility(View.VISIBLE);
        setScores();
        closeDrawer();
    }
    private void prevBtnHandler(int count, int totalPageLength){
        hideKeyboard(QuestionTemplate.this);
        if(count + 1 == totalPageLength){
            next_btn.setVisibility(View.VISIBLE);
        }
        if(count == 1){
            prev_btn.setVisibility(View.INVISIBLE);
        }
        end_btn.setVisibility(View.GONE);
        closeDrawer();

    }
    private void drawerHandler(){
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);
        if(!drawer.isDrawerOpen(Gravity.LEFT)){
            drawer.openDrawer(Gravity.LEFT);
        } else if(drawer.isDrawerOpen(Gravity.LEFT)){
            drawer.closeDrawer(Gravity.LEFT);
        }
    }
    private void closeDrawer(){
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);
        drawer.closeDrawer(Gravity.LEFT);
        list_btn.setImageResource(R.drawable.outline_reorder_24);
    }

     private void changeCheckImageFunc (){
        View breedListSubMenuThreeView  = findViewById(R.id.list_sub_menu_3);
        View breedListSubMenuFourView = findViewById(R.id.list_sub_menu_4);
         ImageView check_total_1 = findViewById(R.id.check_total_1);
         ImageView check_total_2 = findViewById(R.id.check_total_2);
         ImageView check_total_3 = findViewById(R.id.check_total_3);
         ImageView check_total_4 = findViewById(R.id.check_total_4);
         ImageView check_sub_1 = findViewById(R.id.check_sub_1);
         ImageView check_sub_2 = findViewById(R.id.check_sub_2);
         ImageView check_sub_3 = findViewById(R.id.check_sub_3);
         ImageView check_sub_4 = findViewById(R.id.check_sub_4);
         ImageView check_sub_5 = findViewById(R.id.check_sub_5);
         ImageView check_sub_6 = findViewById(R.id.check_sub_6);
         ImageView check_sub_7 = findViewById(R.id.check_sub_7);
         ImageView check_sub_8 = findViewById(R.id.check_sub_8);
         ImageView check_sub_9 = findViewById(R.id.check_sub_9);
         ImageView check_sub_10 = findViewById(R.id.check_sub_10);
         ImageView check_sub_11 = findViewById(R.id.check_sub_11);
         ImageView check_sub_12 = findViewById(R.id.check_sub_12);
         ImageView check_sub_13 = findViewById(R.id.check_sub_13);
         ImageView check_sub_14 = findViewById(R.id.check_sub_14);
         ImageView check_sub_15 = findViewById(R.id.check_sub_15);
         ImageView check_sub_16 = findViewById(R.id.check_sub_16);
         ImageView check_sub_17 = findViewById(R.id.check_sub_17);
         ImageView check_sub_18 = breedListSubMenuThreeView.findViewById(R.id.check_sub_18);
         ImageView check_sub_19 = breedListSubMenuThreeView.findViewById(R.id.check_sub_19);
         ImageView check_sub_20 = findViewById(R.id.check_sub_20);
         ImageView check_sub_21 = findViewById(R.id.check_sub_21);
         ImageView check_sub_22 = findViewById(R.id.check_sub_22);
         ImageView check_sub_23 = findViewById(R.id.check_sub_23);
         ImageView check_sub_24 = findViewById(R.id.check_sub_24);
         ImageView check_sub_25 = findViewById(R.id.check_sub_25);
         ImageView check_sub_26 = findViewById(R.id.check_sub_26);
         ImageView check_sub_27 = findViewById(R.id.check_sub_27);
         ImageView check_sub_28 = findViewById(R.id.check_sub_28);
         ImageView check_sub_29 = findViewById(R.id.check_sub_29);
         ImageView check_sub_30 = findViewById(R.id.check_sub_30);
         ImageView check_sub_31 = findViewById(R.id.check_sub_31);
         ImageView check_sub_32 = findViewById(R.id.check_sub_32);
         ImageView check_sub_33 = findViewById(R.id.check_sub_33);

         ImageView check_sub_34 = breedListSubMenuFourView.findViewById(R.id.check_sub_34);
         ImageView check_sub_35 = breedListSubMenuFourView.findViewById(R.id.check_sub_35);
         ImageView check_sub_36 = breedListSubMenuFourView.findViewById(R.id.check_sub_36);
         if(farmType == 1){
             View fattenListMenuTwo = findViewById(R.id.fatten_list_sub_menu_2);
             ImageView fatten_check_sub_5 = fattenListMenuTwo.findViewById(R.id.check_sub_5);

             if(((QuestionTemplateViewModel.StrawQuestion)viewModel.StrawQuestion).getStrawAvgScore() != -1) {
                 changeCheckImage(fatten_check_sub_5);
             }
             ImageView fatten_check_sub_6 = fattenListMenuTwo.findViewById(R.id.check_sub_6);
             if(((QuestionTemplateViewModel.PenQuestion)viewModel.BreedOutward).getNumberOfCow() != -1) {
                 changeCheckImage(fatten_check_sub_6);
             }
             ImageView fatten_check_sub_7 = fattenListMenuTwo.findViewById(R.id.check_sub_7);
             ImageView fatten_check_sub_8 = fattenListMenuTwo.findViewById(R.id.check_sub_8);
             ImageView fatten_check_sub_9 = fattenListMenuTwo.findViewById(R.id.check_sub_9);
             ImageView fatten_check_sub_10 = fattenListMenuTwo.findViewById(R.id.check_sub_10);
             ImageView fatten_check_sub_11 = fattenListMenuTwo.findViewById(R.id.check_sub_11);
             if(((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedShade).getSelectedItem() != -1){
                 changeCheckImage(fatten_check_sub_7);
             }
             if(((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedSummerVentilating).getSelectedItem() != -1){
                 changeCheckImage(fatten_check_sub_8);
             }
             if(((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedMistSpray).getSelectedItem() != -1){
                 changeCheckImage(fatten_check_sub_9);
             }
             if(((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedWindBlock).getSelectedItem() != -1){
                 changeCheckImage(fatten_check_sub_10);
             }
             if(((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedWinterVentilating).getSelectedItem() != -1){
                 changeCheckImage(fatten_check_sub_11);
             }

         }
         // 라디오 그룹들
         ImageView[] radioImageViewArr = {
                 check_sub_2,check_sub_3,check_sub_7,check_sub_8,check_sub_9,
                 check_sub_10,check_sub_11,check_sub_12,check_sub_13,check_sub_14,
                 check_sub_15,check_sub_16,check_sub_17, check_sub_28,check_sub_29,
                 check_sub_30,check_sub_31,check_sub_32,check_sub_33};

         ImageView[] penImageViewArr = {
                 check_sub_6,check_sub_19,check_sub_20,check_sub_22,check_sub_23,
                 check_sub_24, check_sub_25,check_sub_26,check_sub_27
         };
         for(int i = 0 ; i < radioImageViewArr.length ; i ++){
             if(((QuestionTemplateViewModel.RadioQuestion)viewModel.radioQuestionArr[i]).getSelectedItem() != -1){
                 changeCheckImage(radioImageViewArr[i]);
             }
         }
         for(int i = 0 ;i < penImageViewArr.length ; i++){
             if(((QuestionTemplateViewModel.PenQuestion)viewModel.penQuestionArr[i]).getNumberOfCow() != -1){
                 changeCheckImage(penImageViewArr[i]);
             }
         }

         // 프로토콜 1
         changeEditTextCheckImage(check_sub_1, (int) ((QuestionTemplateViewModel.Question)viewModel.BreedPoor).getScore());
         if(viewModel.getWaterTimeQuestion().getMaxWaterTimeScore() != -1) changeCheckImage(check_sub_4);
         if(viewModel.getProtocolOneScore() != -1)changeCheckImage(check_total_1);
         // 프로토콜 2
         if(viewModel.getStrawScore() != -1) changeCheckImage(check_sub_5);
         if(viewModel.getProtocolTwoScore() != -1) changeCheckImage(check_total_2);
         //프로토콜 3
         if( (((QuestionTemplateViewModel.Question)viewModel.BreedLimp).getNumberOfCow()) != -1) changeCheckImage(check_sub_18);
         if(viewModel.getCoughQuestion().getCoughPerOneAvg() != -1) changeCheckImage(check_sub_21);
         if(viewModel.getProtocolThreeScore() != -1) changeCheckImage(check_total_3);
         //프로토콜 4
         if(((QuestionTemplateViewModel.BehaviorQuestion)viewModel.StruggleQuestion).getBehaviorPerOneAvg() != -1) changeCheckImage(check_sub_34);
         if(((QuestionTemplateViewModel.BehaviorQuestion)viewModel.HarmonyQuestion).getBehaviorPerOneAvg() != -1)changeCheckImage(check_sub_35);
         if(viewModel.getAvoidDistanceScore() != -1) changeCheckImage(check_sub_36);
         if(viewModel.getProtocolFourScore() != -1)changeCheckImage(check_total_4);
     }
     private void changeCheckImageMilkCowFunc (){
         View milkCowListSubMenuViewTwo = findViewById(R.id.milk_cow_list_sub_menu_2);
         View milkCowListSubMenuViewThree = findViewById(R.id.milk_cow_list_sub_menu_3);
         View milkCowListSubMenuViewFour = findViewById(R.id.milk_cow_list_sub_menu_4);

         ImageView check_total_1 = findViewById(R.id.check_total_1);
         ImageView check_total_2 = findViewById(R.id.check_total_2);
         ImageView check_total_3 = findViewById(R.id.check_total_3);
         ImageView check_total_4 = findViewById(R.id.check_total_4);
         ImageView check_sub_1 = findViewById(R.id.check_sub_1);
         ImageView check_sub_2 = findViewById(R.id.check_sub_2);
         ImageView check_sub_3 = findViewById(R.id.check_sub_3);
         ImageView check_sub_4 = findViewById(R.id.check_sub_4);
         ImageView check_sub_5 = milkCowListSubMenuViewTwo.findViewById(R.id.check_sub_5);
         ImageView check_sub_6 = milkCowListSubMenuViewTwo.findViewById(R.id.check_sub_6);
         ImageView check_sub_7 = milkCowListSubMenuViewTwo.findViewById(R.id.check_sub_7);
         ImageView check_sub_8 = milkCowListSubMenuViewTwo.findViewById(R.id.check_sub_8);
         ImageView check_sub_9 = milkCowListSubMenuViewTwo.findViewById(R.id.check_sub_9);
         ImageView check_sub_10 = milkCowListSubMenuViewTwo.findViewById(R.id.check_sub_10);
         ImageView check_sub_11 = milkCowListSubMenuViewTwo.findViewById(R.id.check_sub_11);
         ImageView check_sub_12 = milkCowListSubMenuViewTwo.findViewById(R.id.check_sub_12);
         ImageView check_sub_13 = milkCowListSubMenuViewTwo.findViewById(R.id.check_sub_13);
         ImageView check_sub_14 = milkCowListSubMenuViewTwo.findViewById(R.id.check_sub_14);
         ImageView check_sub_15 = milkCowListSubMenuViewTwo.findViewById(R.id.check_sub_15);
         ImageView check_sub_16 = milkCowListSubMenuViewTwo.findViewById(R.id.check_sub_16);
         ImageView check_sub_17 = milkCowListSubMenuViewTwo.findViewById(R.id.check_sub_17);
         ImageView check_sub_18 = milkCowListSubMenuViewTwo.findViewById(R.id.check_sub_18);
         ImageView check_sub_19 = milkCowListSubMenuViewTwo.findViewById(R.id.check_sub_19);
         ImageView movementStabilityCheckSub = milkCowListSubMenuViewTwo.findViewById(R.id.movement_stability_check_sub);;
         ImageView check_sub_20 = milkCowListSubMenuViewThree.findViewById(R.id.check_sub_20);
         ImageView check_sub_21 = milkCowListSubMenuViewThree.findViewById(R.id.check_sub_21);
         ImageView check_sub_22 = milkCowListSubMenuViewThree.findViewById(R.id.check_sub_22);
         ImageView check_sub_23 = milkCowListSubMenuViewThree.findViewById(R.id.check_sub_23);
         ImageView check_sub_24 = milkCowListSubMenuViewThree.findViewById(R.id.check_sub_24);
         ImageView check_sub_25 = milkCowListSubMenuViewThree.findViewById(R.id.check_sub_25);
         ImageView check_sub_26 = milkCowListSubMenuViewThree.findViewById(R.id.check_sub_26);
         ImageView check_sub_27 = milkCowListSubMenuViewThree.findViewById(R.id.check_sub_27);
         ImageView check_sub_28 = milkCowListSubMenuViewThree.findViewById(R.id.check_sub_28);
         ImageView check_sub_29 = milkCowListSubMenuViewThree.findViewById(R.id.check_sub_29);
         ImageView check_sub_30 = milkCowListSubMenuViewThree.findViewById(R.id.check_sub_30);
         ImageView check_sub_31 = milkCowListSubMenuViewThree.findViewById(R.id.check_sub_31);
         ImageView check_sub_32 = milkCowListSubMenuViewThree.findViewById(R.id.check_sub_32);
         ImageView check_sub_33 = milkCowListSubMenuViewThree.findViewById(R.id.check_sub_33);
         ImageView check_sub_34 = milkCowListSubMenuViewThree.findViewById(R.id.check_sub_34);
         ImageView check_sub_35 = milkCowListSubMenuViewThree.findViewById(R.id.check_sub_35);
         ImageView check_sub_36 = milkCowListSubMenuViewThree.findViewById(R.id.check_sub_36);
         ImageView check_sub_37 = milkCowListSubMenuViewThree.findViewById(R.id.check_sub_37);
         ImageView check_sub_38 = milkCowListSubMenuViewThree.findViewById(R.id.check_sub_38);
         ImageView check_sub_39 = milkCowListSubMenuViewThree.findViewById(R.id.check_sub_39);
         ImageView check_sub_40 = milkCowListSubMenuViewFour.findViewById(R.id.check_sub_40);
         ImageView check_sub_41 = milkCowListSubMenuViewFour.findViewById(R.id.check_sub_41);

         ImageView free_stall_sub_1 = milkCowListSubMenuViewTwo.findViewById(R.id.free_stall_sub_1);
         ImageView free_stall_sub_2 = milkCowListSubMenuViewTwo.findViewById(R.id.free_stall_sub_2);
         ImageView free_stall_sub_3 = milkCowListSubMenuViewTwo.findViewById(R.id.free_stall_sub_3);

         // 라디오 그룹들
         ImageView[] radioImageViewArr = {
                 check_sub_2,check_sub_3,check_sub_9,
                 check_sub_10,check_sub_11,check_sub_12,check_sub_13,check_sub_14,
                 check_sub_15,check_sub_16,check_sub_17,check_sub_18,check_sub_19,
         check_sub_34,check_sub_35,check_sub_36,check_sub_37,check_sub_38,check_sub_39};

         ImageView[] penImageViewArr = {
                 check_sub_22,check_sub_25,check_sub_26,check_sub_27,check_sub_28,
                 check_sub_29,check_sub_30,check_sub_31,

         };
         for(int i = 0 ; i < radioImageViewArr.length ; i ++){
             if(((QuestionTemplateViewModel.RadioQuestion)viewModel.radioQuestionArr[i]).getSelectedItem() != -1){
                 changeCheckImage(radioImageViewArr[i]);
             }
         }
         for(int i = 0 ;i < penImageViewArr.length ; i++){
             if(((QuestionTemplateViewModel.PenQuestion)viewModel.milkCowPenQuestionArr[i]).getNumberOfCow() != -1){
                 changeCheckImage(penImageViewArr[i]);
             }
         }

         // 프로토콜 1
         changeEditTextCheckImage(check_sub_1, (int) ((QuestionTemplateViewModel.Question)viewModel.BreedPoor).getScore());
         if(viewModel.getWaterTimeQuestion().getMaxWaterTimeScore() != -1) changeCheckImage(check_sub_4);
         if(viewModel.getProtocolOneScore() != -1)changeCheckImage(check_total_1);
         // 프로토콜 2
         if(((QuestionTemplateViewModel.SitTimeQuestion)viewModel.SitTimeQuestion).getScore() != -1) changeCheckImage(check_sub_5);
         changeEditTextCheckImage(check_sub_6, (int) ((QuestionTemplateViewModel.Question)viewModel.OutwardBackReg).getScore());
         changeEditTextCheckImage(check_sub_7, (int) ((QuestionTemplateViewModel.Question)viewModel.OutwardBack).getScore());
         changeEditTextCheckImage(check_sub_8, (int) ((QuestionTemplateViewModel.Question)viewModel.OutwardBreast).getScore());
         if(((QuestionTemplateViewModel.MovementStability)viewModel.MovementStability).getScore() != -1){
             changeCheckImage(movementStabilityCheckSub);
         }
         if(viewModel.getProtocolTwoScore() != -1) changeCheckImage(check_total_2);
         // 프리스톨
         if(((QuestionTemplateViewModel.FreeStallCountQuestion)viewModel.FreeStallCountQuestion).getLowestScore() != -1) changeCheckImage(free_stall_sub_1);
         if( ((QuestionTemplateViewModel.SitCollisionQuestion)viewModel.SitCollision).getScore() != -1) changeCheckImage(free_stall_sub_2);
         changeEditTextCheckImage(free_stall_sub_3, (int) ((QuestionTemplateViewModel.FreeStallAreaOutCollision)viewModel.FreeStallAreaOutCollision).getScore());
         //프로토콜 3
         changeEditTextCheckImage(check_sub_20,((QuestionTemplateViewModel.Question)viewModel.BreedLimp).getNumberOfCow());
         changeEditTextCheckImage(check_sub_21,((QuestionTemplateViewModel.Question)viewModel.CriticalLimp).getNumberOfCow());
         changeEditTextCheckImage(check_sub_23,((QuestionTemplateViewModel.Question)viewModel.BreedCriticalHairLoss).getNumberOfCow());
         if(((QuestionTemplateViewModel.CoughQuestion)viewModel.CoughQuestion).getCoughPerOneAvg() != -1) changeCheckImage(check_sub_24);
         changeEditTextCheckImage(check_sub_32,((QuestionTemplateViewModel.YearAvgQuestion)viewModel.HardBirth).getNumberOfCow());
         changeEditTextCheckImage(check_sub_33,((QuestionTemplateViewModel.YearAvgQuestion)viewModel.UnableStand).getNumberOfCow());
         if(viewModel.getProtocolThreeScore() != -1) changeCheckImage(check_total_3);
         //프로토콜 4
        if(((QuestionTemplateViewModel.MilkCowStruggleQuestion)viewModel.MilkCowStruggle).getStruggleIndexAvg() != -1) changeCheckImage(check_sub_40);

         if(viewModel.getAvoidDistanceScore() != -1) changeCheckImage(check_sub_41);
         if(viewModel.getProtocolFourScore() != -1)changeCheckImage(check_total_4);
     }

    private void changeEditTextCheckImage(ImageView checkImageView,int questionScore){
        if(questionScore == -1)
            checkImageView.setImageResource(R.drawable.ic_baseline_not_check_circle_24);
        else
            checkImageView.setImageResource(R.drawable.ic_baseline_check_circle_24);
    }
    private void changeCheckImage(ImageView checkImageView){
        checkImageView.setImageResource(R.drawable.ic_baseline_check_circle_24);
    }
    private void listMenuBtnHandler(ImageButton btn,View view)
    {
        if(view.getVisibility() == View.GONE){
            view.setVisibility(View.VISIBLE);
            btn.setImageResource(R.drawable.outline_menu_open_24);
        }else if(view.getVisibility() == View.VISIBLE){
            view.setVisibility(View.GONE);
            btn.setImageResource(R.drawable.outline_reorder_24);
        }
    }


    private void myOnBackPressed(AlertDialog.Builder AlertBuilder){

        AlertBuilder.setTitle("이전");
        AlertBuilder.setMessage("지금까지 평가한 항목이 사라집니다.\n" +
                "시작 화면으로 돌아가시겠습니까?");
        // 버튼 추가 (Ok 버튼과 Cancle 버튼 )
        AlertBuilder.setPositiveButton("취소",new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog,int which){
                // OK 버튼을 눌렸을 경우

            }
        });
        AlertBuilder.setNegativeButton("네", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        AlertBuilder.show();
    }






     // database 연동
     private void InsertAnswerFunc(){
        InsertAnswer task = new InsertAnswer(QuestionTemplate.this);
        InsertDongAnswer dongTask = new InsertDongAnswer(QuestionTemplate.this);
        InsertAvoidDistance avoidDistanceTask = new InsertAvoidDistance(QuestionTemplate.this);

         InsertQuestion(task);
         insertDongQuestion(dongTask);
         insertAvoidDistance(avoidDistanceTask);


     }
     public void insertAvoidDistance(InsertAvoidDistance task){
         Object[] avoidDistances  = viewModel.avoidDistances;
         ((QuestionTemplateViewModel.avoidDistance)avoidDistances[1]).setFarmId(Integer.parseInt(farmId));
         ((QuestionTemplateViewModel.avoidDistance)avoidDistances[1]).setFarmType(viewModel.getFarmType());

         task.execute(avoidDistances);

     }
     public void insertDongQuestion(InsertDongAnswer task){
         Object waterTimeQuestion = viewModel.WaterTimeQuestion;
         ((QuestionTemplateViewModel.WaterTimeQuestion)waterTimeQuestion).setFarmId(Integer.parseInt(farmId));
         Object coughQuestion = viewModel.CoughQuestion;
         Object struggleQuestion = viewModel.StruggleQuestion;
         Object harmonyQuestion = viewModel.HarmonyQuestion;
         Object strawQuestion = viewModel.StrawQuestion;
         Object freeStallCountQuestion = viewModel.FreeStallCountQuestion;
         Object sitCollision = viewModel.SitCollision;
         Object sitAreaOut  = viewModel.FreeStallAreaOutCollision;
         Object sitTime = viewModel.SitTimeQuestion;
         Object milkCowStruggle = viewModel.MilkCowStruggle;

             task.execute(waterTimeQuestion,
                     coughQuestion,
                     struggleQuestion,
                     harmonyQuestion,
                     strawQuestion,
                     freeStallCountQuestion,
                     sitCollision,
                     sitAreaOut,
                     sitTime,
                     milkCowStruggle
             );


     }
     public void InsertQuestion(InsertAnswer task){
         int breedPoorNumberOfCow = ((QuestionTemplateViewModel.Question)viewModel.BreedPoor).getNumberOfCow();
         float breedPoorScore = ((QuestionTemplateViewModel.Question)viewModel.BreedPoor).getScore();
         float breedPoorRatio = ((QuestionTemplateViewModel.Question)viewModel.BreedPoor).getRatio();
         String breedWaterTankNum = ((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedWaterTankNum).getAnswer();
         String breedWaterTankClean = ((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedWaterTankClean).getAnswer();
         int waterScore = viewModel.getWaterScore();
         float breedStrawAvgScore = ((QuestionTemplateViewModel.StrawQuestion)viewModel.StrawQuestion).getStrawAvgScore();
         String breedStrawDongSize = String.valueOf(
                 ((QuestionTemplateViewModel.StrawQuestion)viewModel.StrawQuestion).getDongSize()
         );
         String breedOutwardPenLocation = ((QuestionTemplateViewModel.PenQuestion)viewModel.BreedOutward).getPenLocation();
         int breedOutwardNumberOfCow = ((QuestionTemplateViewModel.PenQuestion) viewModel.BreedOutward).getNumberOfCow();
         int breedOutwardScore = viewModel.getOutWardScore();
         float breedOutWardRatio = ((QuestionTemplateViewModel.PenQuestion) viewModel.BreedOutward).getRatio();
         String breedShadeAnswer = ((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedShade).getAnswer();
         String breedSummerVentilatingAnswer = ((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedSummerVentilating).getAnswer();
         String breedMistSpray = ((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedMistSpray).getAnswer();
         int breedSummerRestScore = viewModel.getSummerRestScore();
         String breedWindBlockAnswer = ((QuestionTemplateViewModel.RadioQuestion) viewModel.BreedWindBlock).getAnswer();
         String breedWinterVentilatingAnswer = ((QuestionTemplateViewModel.RadioQuestion) viewModel.BreedWinterVentilating).getAnswer();
         int breedWinterRestScore = viewModel.getWinterRestScore();
         String calfShadeAnswer = ((QuestionTemplateViewModel.RadioQuestion) viewModel.CalfShade).getAnswer();
         String calfSummerVentilatingAnswer = ((QuestionTemplateViewModel.RadioQuestion) viewModel.CalfSummerVentilating).getAnswer();
         String calfMistSprayAnswer = ((QuestionTemplateViewModel.RadioQuestion) viewModel.CalfMistSpray).getAnswer();
         int calfSummerRestScore = viewModel.getCalfSummerRestScore();
         String calfStrawAnswer = ((QuestionTemplateViewModel.RadioQuestion) viewModel.CalfStraw).getAnswer();
         String calfWarmAnswer = ((QuestionTemplateViewModel.RadioQuestion) viewModel.CalfWarm).getAnswer();
         String calfWindBlock = ((QuestionTemplateViewModel.RadioQuestion) viewModel.CalfWindBlock).getAnswer();
         int calfWinterRestScore = viewModel.getCalfWinterRestScore();
         double TotalWarmVentilatingScore = viewModel.getTotalWarmVentilatingScore();

         int breedLimpNumberOfCow = ((QuestionTemplateViewModel.Question)viewModel.BreedLimp).getNumberOfCow();
         float breedLimpScore = ((QuestionTemplateViewModel.Question)viewModel.BreedLimp).getScore();
         float breedLimpRatio = ((QuestionTemplateViewModel.Question)viewModel.BreedLimp).getRatio();

         int breedSlightHairLossNumberOfCow = ((QuestionTemplateViewModel.PenQuestion)viewModel.BreedSlightHairLoss).getNumberOfCow();
         String breedSlightHairPenLocation = ((QuestionTemplateViewModel.PenQuestion)viewModel.BreedSlightHairLoss).getPenLocation();
         float breedSlightHairLossRatio = ((QuestionTemplateViewModel.PenQuestion)viewModel.BreedSlightHairLoss).getRatio();

         int breedCriticalHairLossNumberOfCow = ((QuestionTemplateViewModel.PenQuestion)viewModel.BreedCriticalHairLoss).getNumberOfCow();
         float breedCriticalHairLossScore = ((QuestionTemplateViewModel.PenQuestion)viewModel.BreedCriticalHairLoss).getScore();
         float breedCriticalHairLossRatio = ((QuestionTemplateViewModel.PenQuestion)viewModel.BreedCriticalHairLoss).getRatio();
         float breedTotalHairLossRatio = viewModel.getHairLossTotalRatio();
         String breedRunnyNosePenLocation = ((QuestionTemplateViewModel.PenQuestion)viewModel.BreedRunnyNose).getPenLocation();
         int breedRunnyNoseNumberOfCow = ((QuestionTemplateViewModel.PenQuestion)viewModel.BreedRunnyNose).getNumberOfCow();
         float breedRunnyNoseRatio = ((QuestionTemplateViewModel.PenQuestion)viewModel.BreedRunnyNose).getRatio();

         String breedOphthalmicPenLocation = ((QuestionTemplateViewModel.PenQuestion)viewModel.BreedOphthalmic).getPenLocation();
         int breedOphthalmicNumberOfCow = ((QuestionTemplateViewModel.PenQuestion)viewModel.BreedOphthalmic).getNumberOfCow();
         float breedOphthalmicRatio = ((QuestionTemplateViewModel.PenQuestion)viewModel.BreedOphthalmic).getRatio();

         String breedBreathPenLocation = ((QuestionTemplateViewModel.PenQuestion)viewModel.BreedBreath).getPenLocation();
         int breedBreathNumberOfCow = ((QuestionTemplateViewModel.PenQuestion)viewModel.BreedBreath).getNumberOfCow();
         float breedBreathRatio = ((QuestionTemplateViewModel.PenQuestion)viewModel.BreedBreath).getRatio();

         String breedDiarrheaPenLocation = ((QuestionTemplateViewModel.PenQuestion)viewModel.BreedDiarrhea).getPenLocation();
         int breedDiarrheaNumberOfCow = ((QuestionTemplateViewModel.PenQuestion)viewModel.BreedDiarrhea).getNumberOfCow();
         float breedDiarrheaRatio = ((QuestionTemplateViewModel.PenQuestion)viewModel.BreedDiarrhea).getRatio();

         String breedRuminantPenLocation = ((QuestionTemplateViewModel.PenQuestion)viewModel.BreedRuminant).getPenLocation();
         int breedRuminantNumberOfCow = ((QuestionTemplateViewModel.PenQuestion)viewModel.BreedRuminant).getNumberOfCow();
         float breedRuminantRatio = ((QuestionTemplateViewModel.PenQuestion)viewModel.BreedRuminant).getRatio();

         String breedFallDeadPenLocation = ((QuestionTemplateViewModel.PenQuestion)viewModel.BreedFallDead).getPenLocation();
         int breedFallDeadNumberOfCow = ((QuestionTemplateViewModel.PenQuestion)viewModel.BreedFallDead).getNumberOfCow();
         float breedFallDeadRatio = ((QuestionTemplateViewModel.PenQuestion)viewModel.BreedFallDead).getRatio();

         String breedHornAnswer = ((QuestionTemplateViewModel.RadioQuestion) viewModel.BreedHornRemoval).getAnswer();
         String breedHornAnesthesiaAnswer = ((QuestionTemplateViewModel.RadioQuestion) viewModel.BreedHornAnesthesia).getAnswer();
         String breedHornPainkillerAnswer = ((QuestionTemplateViewModel.RadioQuestion) viewModel.BreedHornPainkiller).getAnswer();
         int breedHornRemovalScore = viewModel.getHornRemovalScore();

         String breedCastrationAnswer = ((QuestionTemplateViewModel.RadioQuestion) viewModel.BreedCastration).getAnswer();
         String breedCastrationAnesthesiaAnswer = ((QuestionTemplateViewModel.RadioQuestion) viewModel.BreedCastrationAnesthesia).getAnswer();
         String breedCastrationPainkillerAnswer = ((QuestionTemplateViewModel.RadioQuestion) viewModel.BreedCastrationPainkiller).getAnswer();
         int breedCastrationScore = viewModel.getCastrationScore();
         Object waterTimeQuestion = viewModel.WaterTimeQuestion;

         String waterTimeDongSize = String.valueOf(((QuestionTemplateViewModel.DongQuestion)viewModel.WaterTimeQuestion).getDongSize());
         int waterTimeMaxScore = ((QuestionTemplateViewModel.WaterTimeQuestion)viewModel.WaterTimeQuestion).getMaxWaterTimeScore();
         Object coughQuestion = viewModel.CoughQuestion;
         Object struggleQuestion = viewModel.StruggleQuestion;
         Object harmonyQuestion = viewModel.HarmonyQuestion;

         String coughDongSize =String.valueOf(
                 ((QuestionTemplateViewModel.CoughQuestion)coughQuestion).getDongSize()
         );
         float coughPerOneAvg = ((QuestionTemplateViewModel.CoughQuestion)coughQuestion).getCoughPerOneAvg();
         float coughRatio = ((QuestionTemplateViewModel.CoughQuestion)coughQuestion).getCoughRatio();

         String struggleDongSize = String.valueOf(((QuestionTemplateViewModel.BehaviorQuestion)struggleQuestion).getDongSize());
         float strugglePerOneAvg = ((QuestionTemplateViewModel.BehaviorQuestion)struggleQuestion).getBehaviorPerOneAvg();

         String harmonyDongSize = String.valueOf(
                 ((QuestionTemplateViewModel.BehaviorQuestion)harmonyQuestion).getDongSize()
         );
         float harmonyPerOneAvg = ((QuestionTemplateViewModel.BehaviorQuestion)harmonyQuestion).getBehaviorPerOneAvg();
         Object avoidDistance = viewModel.avoidDistances[1];

         String avoidDistancePenSize = String.valueOf(
                 ((QuestionTemplateViewModel.avoidDistance)avoidDistance).getPenSize()
         );
         float avoidDistanceScore =  viewModel.getAvoidDistanceScore();

         double protocolOneScore = viewModel.getProtocolOneScore();
         double protocolTwoScore = viewModel.getProtocolTwoScore();
         double protocolThreeScore = viewModel.getProtocolThreeScore();
         double protocolFourScore = viewModel.getProtocolFourScore();
         double restScore = viewModel.getRestScore();
         double hairLossScore = viewModel.getHairLossScore();
         double minPainScore = viewModel.getMinPainScore();
         double BehaviorScore = viewModel.getSocialBehaviorScore();
         double minInjuryScore = viewModel.getMinInjuryScore();
         double minDiseaseScore = viewModel.getDiseaseScore();

         // 착유우
         String waterTankForm = viewModel.getWaterTankForm();
         int sitCowCount = ((QuestionTemplateViewModel.FreeStallAreaOutCollision)viewModel.FreeStallAreaOutCollision).getSitCowCount();
         int sitAreaOutCowCount = ((QuestionTemplateViewModel.FreeStallAreaOutCollision)viewModel.FreeStallAreaOutCollision).getAreaOutCollisionCowCount();
         int appearanceBackRegNumberOfCow = ((QuestionTemplateViewModel.Question)viewModel.OutwardBackReg).getNumberOfCow();
         int appearanceBackNumberOfCow = ((QuestionTemplateViewModel.Question)viewModel.OutwardBack).getNumberOfCow();
         int appearanceBreastNumberOfCow = ((QuestionTemplateViewModel.Question)viewModel.OutwardBreast).getNumberOfCow();
        int criticalLimpNumberOfCow = ((QuestionTemplateViewModel.Question)viewModel.CriticalLimp).getNumberOfCow();
        String outGenitalsPenLocation = ((QuestionTemplateViewModel.PenQuestion)viewModel.OutGenitals).getPenLocation();
        int outGenitalsNumberOfCow =((QuestionTemplateViewModel.PenQuestion)viewModel.OutGenitals).getNumberOfCow();
         String milkInCellPenLocation = ((QuestionTemplateViewModel.PenQuestion)viewModel.MilkInCell).getPenLocation();
         int milkInCellNumberOfCow =((QuestionTemplateViewModel.PenQuestion)viewModel.MilkInCell).getNumberOfCow();
         int hardBirthYearAnswer = ((QuestionTemplateViewModel.YearAvgQuestion)viewModel.HardBirth).getYearAvgCount();
         int hardBirthYearSubAnswer = ((QuestionTemplateViewModel.YearAvgQuestion)viewModel.HardBirth).getNumberOfCow();
         int unAbleStandYearAnswer = ((QuestionTemplateViewModel.YearAvgQuestion)viewModel.UnableStand).getYearAvgCount();
         int unAbleStandYearSubAnswer = ((QuestionTemplateViewModel.YearAvgQuestion)viewModel.UnableStand).getNumberOfCow();
         String milkCowStruggleDongSize = String.valueOf(
                 ((QuestionTemplateViewModel.MilkCowStruggleQuestion)viewModel.MilkCowStruggle).getDongSize()
         );
         String freeStallCountDongSize =String.valueOf(
                 ((QuestionTemplateViewModel.FreeStallCountQuestion)viewModel.FreeStallCountQuestion).getDongSize()
         );

         String sitCollisionSitCount =String.valueOf(
                 ((QuestionTemplateViewModel.SitCollisionQuestion)viewModel.SitCollision).getSitCount()
         );
         String sitTimeSitCount =String.valueOf(
                 ((QuestionTemplateViewModel.SitTimeQuestion)viewModel.SitTimeQuestion).getSitCount()
         );
         int accessTroubleCowCount = ((QuestionTemplateViewModel.MovementStability)viewModel.MovementStability).getAccessTroubleCowCount();
         int exitTroubleCowCount = ((QuestionTemplateViewModel.MovementStability)viewModel.MovementStability).getExitTroubleCowCount();
         // 착유우 점수
         int freeStallCountScore = ((QuestionTemplateViewModel.FreeStallCountQuestion)viewModel.FreeStallCountQuestion).getLowestScore();
         float sitCollisionScore = ((QuestionTemplateViewModel.SitCollisionQuestion)viewModel.SitCollision).getScore();
         float areaOutCollisionScore = ((QuestionTemplateViewModel.FreeStallAreaOutCollision)viewModel.FreeStallAreaOutCollision).getScore();
         float sitTimeScore= ((QuestionTemplateViewModel.SitTimeQuestion)viewModel.SitTimeQuestion).getScore();
         float outwardBackRegScore = ((QuestionTemplateViewModel.Question)viewModel.OutwardBackReg).getScore();
         float outwardBackScore = ((QuestionTemplateViewModel.Question)viewModel.OutwardBack).getScore();
         float outwardBreastScore = ((QuestionTemplateViewModel.Question)viewModel.OutwardBreast).getScore();
         float movementStabilityScore = ((QuestionTemplateViewModel.MovementStability)viewModel.MovementStability).getScore();
         float milkCowLimpScore = ((QuestionTemplateViewModel.Question)viewModel.CriticalLimp).getScore();
         float milkCowStruggleScore = ((QuestionTemplateViewModel.MilkCowStruggleQuestion)viewModel.MilkCowStruggle).getRepScore();
         // 착유우 비율
         double freeStallCountRatio = ((QuestionTemplateViewModel.FreeStallCountQuestion)viewModel.FreeStallCountQuestion).getLowestRatio();
         float sitCollisionRatio = ((QuestionTemplateViewModel.SitCollisionQuestion)viewModel.SitCollision).getRatio();
         float areaOutSitCollisionRatio = ((QuestionTemplateViewModel.FreeStallAreaOutCollision)viewModel.FreeStallAreaOutCollision).getRatio();
         float sitTimeAvgTime = ((QuestionTemplateViewModel.SitTimeQuestion)viewModel.SitTimeQuestion).getSitTimeAvg();
         float outwardBackRegRatio = ((QuestionTemplateViewModel.Question)viewModel.OutwardBackReg).getRatio();
         float outwardBackRatio = ((QuestionTemplateViewModel.Question)viewModel.OutwardBack).getRatio();
         float outwardBreastRatio = ((QuestionTemplateViewModel.Question)viewModel.OutwardBreast).getRatio();
         float accessTroubleRatio = ((QuestionTemplateViewModel.MovementStability)viewModel.MovementStability).getAccessTroubleRatio();
         float exitTroubleRatio = ((QuestionTemplateViewModel.MovementStability)viewModel.MovementStability).getExitTroubleRatio();
         float totalAccessTroubleRatio =((QuestionTemplateViewModel.MovementStability)viewModel.MovementStability).getTotalRatio();
         float milkCowLimpRatio = ((QuestionTemplateViewModel.Question)viewModel.BreedLimp).getRatio();
         float milkCowCriticalLimpRatio= ((QuestionTemplateViewModel.Question)viewModel.CriticalLimp).getRatio();
         float milkCowTotalLimpRatio= viewModel.getTotalLimpRatio();
         float outGenitalsRatio = ((QuestionTemplateViewModel.Question)viewModel.OutGenitals).getRatio();
         float milkInCellRatio = ((QuestionTemplateViewModel.Question)viewModel.MilkInCell).getRatio();
         float hardBirthRatio = ((QuestionTemplateViewModel.YearAvgQuestion)viewModel.HardBirth).getRatio();
         float unAbleStandRatio = ((QuestionTemplateViewModel.YearAvgQuestion)viewModel.UnableStand).getRatio();
         float milkCowStruggleIndexAvg = ((QuestionTemplateViewModel.MilkCowStruggleQuestion)viewModel.MilkCowStruggle).getStruggleIndexAvg();
         float milkCowAvoidDistanceRatio = viewModel.getAvoidDistanceRatio();

         String protocolTotalString = viewModel.getTotalProtocolScoreString();


         waterTimeDongSize = waterTimeDongSize + "\t(축사동 수)";
         breedStrawDongSize = breedStrawDongSize + "\t(축사동 수)";
         sitTimeSitCount = sitTimeSitCount + "\t(앉기동작 개수)";
         coughDongSize = coughDongSize + "\t(축사동 수)";
         struggleDongSize = struggleDongSize + "\t(축사동 수)";
         milkCowStruggleDongSize = milkCowStruggleDongSize + "\t(축사동 수)";
         freeStallCountDongSize = freeStallCountDongSize + "\t(축사동 수)";
         sitCollisionSitCount = sitCollisionSitCount + "\t(앉기동작 개수)";
         harmonyDongSize = harmonyDongSize + "\t(축사동 수)";
         avoidDistancePenSize = avoidDistancePenSize + "\t(표본펜 수)";







         task.execute("http://" + IP_ADDRESS + "/insertBeefAnswer.php",
                 farmId,
                 String.valueOf(breedPoorNumberOfCow),
                 String.valueOf(breedPoorScore),
                 String.valueOf(breedPoorRatio),
                 breedWaterTankNum,
                 breedWaterTankClean,
                 breedOutwardPenLocation,
                 String.valueOf(breedOutwardNumberOfCow),
                 String.valueOf(breedOutwardScore),
                 String.valueOf(breedOutWardRatio),
                 breedShadeAnswer,
                 breedSummerVentilatingAnswer,
                 breedMistSpray,
                 String.valueOf(breedSummerRestScore),
                 breedWindBlockAnswer,
                 breedWinterVentilatingAnswer,
                 String.valueOf(breedWinterRestScore),
                 calfShadeAnswer,
                 calfSummerVentilatingAnswer,
                 calfMistSprayAnswer,
                 String.valueOf(calfSummerRestScore),
                 calfStrawAnswer,
                 calfWarmAnswer,
                 calfWindBlock,
                 String.valueOf(calfWinterRestScore),
                 String.valueOf(breedLimpNumberOfCow),
                 String.valueOf(breedLimpScore),
                 String.valueOf(breedLimpRatio),
                 String.valueOf(breedSlightHairLossNumberOfCow),
                 breedSlightHairPenLocation,
                 String.valueOf(breedSlightHairLossRatio),
                 String.valueOf(breedCriticalHairLossNumberOfCow),
                 String.valueOf(breedCriticalHairLossScore),
                 String.valueOf(breedCriticalHairLossRatio),
                 breedRunnyNosePenLocation,
                 String.valueOf(breedRunnyNoseNumberOfCow),
                 String.valueOf(breedRunnyNoseRatio),
                 breedOphthalmicPenLocation,
                 String.valueOf(breedOphthalmicNumberOfCow),
                 String.valueOf(breedOphthalmicRatio),
                 breedBreathPenLocation,
                 String.valueOf(breedBreathNumberOfCow),
                 String.valueOf(breedBreathRatio),
                 breedDiarrheaPenLocation,
                 String.valueOf(breedDiarrheaNumberOfCow),
                 String.valueOf(breedDiarrheaRatio),
                 breedRuminantPenLocation,
                 String.valueOf(breedRuminantNumberOfCow),
                 String.valueOf(breedRuminantRatio),
                 breedFallDeadPenLocation,
                 String.valueOf(breedFallDeadNumberOfCow),
                 String.valueOf(breedFallDeadRatio),
                 breedHornAnswer,
                 breedHornAnesthesiaAnswer,
                 breedHornPainkillerAnswer,
                 String.valueOf(breedHornRemovalScore),
                 breedCastrationAnswer,
                 breedCastrationAnesthesiaAnswer,
                 breedCastrationPainkillerAnswer,
                 String.valueOf(breedCastrationScore),
                 String.valueOf(waterTimeDongSize),
                 String.valueOf(waterTimeMaxScore),
                 String.valueOf(coughDongSize),
                 String.valueOf(coughPerOneAvg),
                 String.valueOf(coughRatio),
                 String.valueOf(struggleDongSize),
                 String.valueOf(strugglePerOneAvg),
                 String.valueOf(harmonyDongSize),
                 String.valueOf(harmonyPerOneAvg),
                 String.valueOf(avoidDistancePenSize),
                 String.valueOf(avoidDistanceScore),
                 String.valueOf(waterScore),
                 String.valueOf(protocolOneScore),
                 String.valueOf(protocolTwoScore),
                 String.valueOf(restScore),
                 String.valueOf(TotalWarmVentilatingScore),
                 String.valueOf(hairLossScore),
                 String.valueOf(minPainScore),
                 String.valueOf(BehaviorScore),
                 String.valueOf(protocolFourScore),
                 String.valueOf(protocolThreeScore),
                 String.valueOf(minInjuryScore),
                 String.valueOf(minDiseaseScore),
                 String.valueOf(breedStrawAvgScore),
                 String.valueOf(breedStrawDongSize),
                 String.valueOf(breedTotalHairLossRatio),
                 String.valueOf(farmType),
                 String.valueOf(waterTankForm),
                 String.valueOf(sitCowCount),
                 String.valueOf(sitAreaOutCowCount),
                 String.valueOf(appearanceBackRegNumberOfCow),
                 String.valueOf(appearanceBackNumberOfCow),
                 String.valueOf(appearanceBreastNumberOfCow),
                 String.valueOf(criticalLimpNumberOfCow),
                 String.valueOf(outGenitalsPenLocation),
                 String.valueOf(outGenitalsNumberOfCow),
                 String.valueOf(milkInCellPenLocation),
                 String.valueOf(milkInCellNumberOfCow),
                 String.valueOf(hardBirthYearAnswer),
                 String.valueOf(hardBirthYearSubAnswer),
                 String.valueOf(unAbleStandYearAnswer),
                 String.valueOf(unAbleStandYearSubAnswer),
                 String.valueOf(milkCowStruggleDongSize),
                 String.valueOf(freeStallCountDongSize),
                 String.valueOf(sitCollisionSitCount),
                 String.valueOf(sitTimeSitCount),
                 String.valueOf(accessTroubleCowCount),
                 String.valueOf(exitTroubleCowCount),
                 String.valueOf(freeStallCountScore),
                 String.valueOf(sitCollisionScore),
                 String.valueOf(areaOutCollisionScore),
                 String.valueOf(sitTimeScore),
                 String.valueOf(outwardBackRegScore),
                 String.valueOf(outwardBackScore),
                 String.valueOf(outwardBreastScore),
                 String.valueOf(movementStabilityScore),
                 String.valueOf(milkCowLimpScore),
                 String.valueOf(milkCowStruggleScore),
                 String.valueOf(freeStallCountRatio),
                 String.valueOf(sitCollisionRatio),
                 String.valueOf(areaOutSitCollisionRatio),
                 String.valueOf(sitTimeAvgTime),
                 String.valueOf(outwardBackRegRatio),
                 String.valueOf(outwardBackRatio),
                 String.valueOf(outwardBreastRatio),
                 String.valueOf(accessTroubleRatio),
                 String.valueOf(exitTroubleRatio),
                 String.valueOf(totalAccessTroubleRatio),
                 String.valueOf(milkCowLimpRatio),
                 String.valueOf(milkCowCriticalLimpRatio),
                 String.valueOf(milkCowTotalLimpRatio),
                 String.valueOf(outGenitalsRatio),
                 String.valueOf(milkInCellRatio),
                 String.valueOf(hardBirthRatio),
                 String.valueOf(unAbleStandRatio),
                 String.valueOf(milkCowStruggleIndexAvg),
                 String.valueOf(milkCowAvoidDistanceRatio),
                 String.valueOf(protocolTotalString)
         );

     }
     public static void hideKeyboard(Activity activity) {
         InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
         //Find the currently focused view, so we can grab the correct window token from it.
         View view = activity.getCurrentFocus();
         //If no view currently has focus, create a new one, just so we can grab a window token from it
         if (view == null) {
             view = new View(activity);
         }
         imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
     }

    public void setEvaWayFragmentImage(Fragment fragmentClass, int drawableId ){

                  CustomDialog customDialog = new CustomDialog(fragmentClass.getContext());
                  customDialog.setImage(drawableId);
                }
     public Bundle makeResultBundle(Bundle bundle){
         bundle.putInt("farmType",viewModel.getFarmType());
         bundle.putInt("nutritionScore",viewModel.getPoorScore());
         bundle.putInt("waterScore",viewModel.getWaterScore());
         //
         bundle.putFloat("strawScore",viewModel.getStrawScore());
         bundle.putFloat("outwardScore",viewModel.getOutWardScore());
         //
         bundle.putInt("freeStallCountScore",((QuestionTemplateViewModel.FreeStallCountQuestion)viewModel.FreeStallCountQuestion).getLowestScore());
         bundle.putInt("sitCollisionScore", (int) ((QuestionTemplateViewModel.SitCollisionQuestion)viewModel.SitCollision).getScore());
         bundle.putInt("areaOutSitCollision", (int) ((QuestionTemplateViewModel.FreeStallAreaOutCollision)viewModel.FreeStallAreaOutCollision).getScore());
         bundle.putInt("sitTimeScore", (int) ((QuestionTemplateViewModel.SitTimeQuestion)viewModel.SitTimeQuestion).getScore());
         bundle.putInt("outwardBackRegScore", (int) ((QuestionTemplateViewModel.Question)viewModel.OutwardBackReg).getScore());
         bundle.putInt("outwardBackScore", (int) ((QuestionTemplateViewModel.Question)viewModel.OutwardBack).getScore());
         bundle.putInt("outwardBreastScore", (int) ((QuestionTemplateViewModel.Question)viewModel.OutwardBreast).getScore());

         //
         bundle.putDouble("restScore",viewModel.getRestScore());
         bundle.putFloat("summerScore",viewModel.getSummerRestScore());
         bundle.putFloat("winterScore",viewModel.getWinterRestScore());
         bundle.putFloat("calfSummerScore",viewModel.getCalfSummerRestScore());
         bundle.putFloat("calfWinterScore",viewModel.getCalfWinterRestScore());
         bundle.putDouble("totalWarmVentilatingScore",viewModel.getTotalWarmVentilatingScore());
         //
         bundle.putLong("minInjuryScore", viewModel.getMinInjuryScore());
         bundle.putDouble("diseaseScore",viewModel.getDiseaseScore());
         bundle.putDouble("minPainScore",viewModel.getMinPainScore());
         bundle.putInt("breedLimpScore", (int) ((QuestionTemplateViewModel.Question)viewModel.BreedLimp).getScore());
         bundle.putInt("milkCowLimpScore", (int) ((QuestionTemplateViewModel.Question)viewModel.CriticalLimp).getScore());
         bundle.putInt("hairLossScore",viewModel.getHairLossScore());
         bundle.putInt("hornRemoveScore",viewModel.getHornRemovalScore());
         bundle.putInt("castrationScore",viewModel.getCastrationScore());
         bundle.putInt("socialBehaviorScore",viewModel.getSocialBehaviorScore());
         bundle.putInt("avoidDistanceScore",viewModel.getAvoidDistanceScore());

         //
         bundle.putString("protocolTotalScoreString",viewModel.getTotalProtocolScoreString());
         bundle.putDouble("protocolOneScore",viewModel.getProtocolOneScore());
         bundle.putDouble("protocolTwoScore",viewModel.getProtocolTwoScore());
         bundle.putDouble("protocolThreeScore",viewModel.getProtocolThreeScore());
         bundle.putDouble("protocolFourScore",viewModel.getProtocolFourScore());

        return bundle;
     }
     private String checkEvaEndBtn(){
        String msg = null;
         if(((QuestionTemplateViewModel.Question)viewModel.BreedPoor).getNumberOfCow() == -1){
                msg = "여윈 개체";
         }
         if(((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedWaterTankNum).getSelectedItem() == -1){
             msg = "음수조 수";
         }
         if(((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedWaterTankClean).getSelectedItem() == -1){
             msg = "음수조 위생";
         }
         if(((QuestionTemplateViewModel.WaterTimeQuestion)viewModel.WaterTimeQuestion).getMaxWaterTimeScore() == -1){
             msg = "음수 대기우와 음수 시간";
         }

         if(((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedShade).getSelectedItem() == -1){
             msg = "혹서기 그늘";
         }
         if(((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedSummerVentilating).getSelectedItem() == -1){
             msg = "혹서기 환기팬";
         }
         if(((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedMistSpray).getSelectedItem() == -1){
             msg = "혹서기 안개분무시설";
         }
         if(((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedWindBlock).getSelectedItem() == -1){
             msg = "혹한기 바람차단시설";
         }
         if(((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedWinterVentilating).getSelectedItem() == -1){
             msg = "혹한기 환기시설";
         }
         if(((QuestionTemplateViewModel.Question)viewModel.BreedLimp).getNumberOfCow() == -1){
             msg = "다리 절음";
         }

         if(((QuestionTemplateViewModel.PenQuestion)viewModel.BreedSlightHairLoss).getNumberOfCow() == -1){
             msg = "경미한 외피 변형";
         }
         if(((QuestionTemplateViewModel.Question)viewModel.BreedCriticalHairLoss).getNumberOfCow() == -1){
             msg = "심각한 외피 변형";
         }
         if(((QuestionTemplateViewModel.CoughQuestion)viewModel.CoughQuestion).getCoughPerOneAvg() == -1){
             msg = "기침 평가";
         }
         if(((QuestionTemplateViewModel.PenQuestion)viewModel.BreedRunnyNose).getNumberOfCow() == -1){
             msg = "비강 분비물";
         }

         if(((QuestionTemplateViewModel.PenQuestion)viewModel.BreedOphthalmic).getNumberOfCow() == -1){
             msg = "안구 분비물";
         }



         if(((QuestionTemplateViewModel.PenQuestion)viewModel.BreedBreath).getNumberOfCow() == -1){
             msg = "호흡 장애";
         }



         if(((QuestionTemplateViewModel.PenQuestion)viewModel.BreedDiarrhea).getNumberOfCow() == -1){
             msg = "설사";
         }



         if(((QuestionTemplateViewModel.PenQuestion)viewModel.BreedFallDead).getNumberOfCow() == -1){
             msg = "폐사율";
         }

         if(((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedHornRemoval).getSelectedItem() == -1){
             msg = "제각/탈각 - 1";
         }
         if(((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedHornAnesthesia).getSelectedItem() == -1){
             msg = "제각/탈각 - 2";
         }
         if(((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedHornPainkiller).getSelectedItem() == -1){
             msg = "제각/탈각 - 3";
         }

         if(((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedCastration).getSelectedItem() == -1){
             msg = "거세 - 1";
         }
         if(((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedCastrationAnesthesia).getSelectedItem() == -1){
             msg = "거세 - 2";
         }
         if(((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedCastrationPainkiller).getSelectedItem() == -1){
             msg = "거세 - 3";
         }



        if(viewModel.getAvoidDistanceScore() == -1){
            msg = "회피 거리";
        }



//         비육 농장을 제외한 송아지 평가 항목
         if(viewModel.getFarmType() != 1){
             if(((QuestionTemplateViewModel.RadioQuestion)viewModel.CalfShade).getSelectedItem() == -1){
                 msg = "포유 송아지 그늘";
             }
             if(((QuestionTemplateViewModel.RadioQuestion)viewModel.CalfSummerVentilating).getSelectedItem() == -1){
                 msg = "포유 송아지 환기팬";
             }
             if(((QuestionTemplateViewModel.RadioQuestion)viewModel.CalfMistSpray).getSelectedItem() == -1){
                 msg = "포유 송아지 안개분무시설";
             }
             if(((QuestionTemplateViewModel.RadioQuestion)viewModel.CalfStraw).getSelectedItem() == -1){
                 msg = "포유 송아지 깔짚";
             }
             if(((QuestionTemplateViewModel.RadioQuestion)viewModel.CalfWarm).getSelectedItem() == -1){
                 msg = "포유 송아지 보온";
             }
             if(((QuestionTemplateViewModel.RadioQuestion)viewModel.CalfWindBlock).getSelectedItem() == -1){
                 msg = "포유 송아지 바람차단시설";
             }
         }








         // 한-육우 착우유 별로 구분이 필요한 항목들
         if(viewModel.isBeef(viewModel.getFarmType())){
             if(((QuestionTemplateViewModel.StrawQuestion)viewModel.StrawQuestion).getStrawAvgScore() == -1) {
                 msg = "깔짚 평가";
             }
             if(((QuestionTemplateViewModel.PenQuestion)viewModel.BreedOutward).getNumberOfCow() == -1){
                 msg = "가축외형 위생";
             }

             if(((QuestionTemplateViewModel.PenQuestion)viewModel.BreedRuminant).getNumberOfCow() == -1){
                 msg = "반추위 팽창";
             }
             if(((QuestionTemplateViewModel.BehaviorQuestion)viewModel.StruggleQuestion).getBehaviorPerOneAvg() == -1){
                 msg = "투쟁(서열) 행동";
             }
             if(((QuestionTemplateViewModel.BehaviorQuestion)viewModel.HarmonyQuestion).getBehaviorPerOneAvg() == -1){
                 msg = "화합 행동";
             }

         } else {
             if(((QuestionTemplateViewModel.PenQuestion)viewModel.MilkInCell).getNumberOfCow() == -1){
                 msg = "우유 내 체세포";
             }

             if(((QuestionTemplateViewModel.PenQuestion)viewModel.OutGenitals).getNumberOfCow() == -1){
                 msg = "외음부 분비물";
             }
            if(((QuestionTemplateViewModel.YearAvgQuestion)viewModel.HardBirth).getNumberOfCow() == -1
            || ((QuestionTemplateViewModel.YearAvgQuestion)viewModel.HardBirth).getYearAvgCount() == -1){
                msg = "난산";
            }
             if(((QuestionTemplateViewModel.YearAvgQuestion)viewModel.UnableStand).getNumberOfCow() == -1
                     || ((QuestionTemplateViewModel.YearAvgQuestion)viewModel.UnableStand).getYearAvgCount() == -1){
                 msg = "기립불능";
             }
            if(((QuestionTemplateViewModel.SitTimeQuestion)viewModel.SitTimeQuestion).getScore() == -1){
                msg = "앉기 동작 소요시간";
            }
            if( ((QuestionTemplateViewModel.Question)viewModel.OutwardBackReg).getNumberOfCow() == -1 ){
                msg = "가축외형 위생(뒤쪽 아랫다리)";
            }
             if( ((QuestionTemplateViewModel.Question)viewModel.OutwardBack).getNumberOfCow() == -1 ){
                 msg = "가축외형 위생(뒷 부분)";
             }
             if( ((QuestionTemplateViewModel.Question)viewModel.OutwardBreast).getNumberOfCow() == -1 ){
                 msg = "가축외형 위생(유방)";
             }
             if(((QuestionTemplateViewModel.MovementStability)viewModel.MovementStability).getAccessTroubleCowCount() == -1){
                 msg = "착유실 이동 안정성";
             }
             if(((QuestionTemplateViewModel.MovementStability)viewModel.MovementStability).getExitTroubleCowCount() == -1){
                 msg = "착유실 이동 안정성";
             }
             if( ((QuestionTemplateViewModel.Question)viewModel.CriticalLimp).getNumberOfCow() == -1){
                 msg = "심각한 다리 절음";
             }
             if(((QuestionTemplateViewModel.MilkCowStruggleQuestion)viewModel.MilkCowStruggle).getStruggleIndexAvg() == -1 ){
                 msg = "투쟁(서열) 행동";
             }

             // 프리스톨 우사일 경우
             if(viewModel.getFarmType() == 5){
                 if(((QuestionTemplateViewModel.FreeStallCountQuestion)viewModel.FreeStallCountQuestion).getLowestScore() == -1){
                     msg = "프리스톨 수";
                 }
                 if(((QuestionTemplateViewModel.SitCollisionQuestion)viewModel.SitCollision).getSitCount() == -1){
                     msg = "앉기 시 충돌";
                 }
                 if(((QuestionTemplateViewModel.FreeStallAreaOutCollision)viewModel.FreeStallAreaOutCollision).getAreaOutCollisionCowCount() == -1){
                     msg = "프리스톨 영역 외 앉기";
                 }
                 if(((QuestionTemplateViewModel.FreeStallAreaOutCollision)viewModel.FreeStallAreaOutCollision).getSitCowCount() == -1){
                     msg = "프리스톨 영역 외 앉기";
                 }
             }
         }


         return msg;
     }
     private void setScores(){
         viewModel.setWaterScore(
                 viewModel.calculatorWaterScore(
                         ((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedWaterTankNum).getSelectedItem(),
                         ((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedWaterTankClean).getSelectedItem(),
                         viewModel.getWaterTimeQuestion().getMaxWaterTimeScore()
                 )
         );
         if(viewModel.getProtocolOneScore() != -1){
             viewModel.setProtocolOneScore(
                     viewModel.calculatorProtocolOneResult(viewModel.getFarmType(),
                             viewModel.getPoorScore(),
                             viewModel.getWaterScore()
                     )
             );
         }

         if(viewModel.getRestScore() != -1){
             if(viewModel.isBeef(viewModel.getFarmType()))
             {
                 viewModel.setRestScore(
                         viewModel.calculatorBreedRestScore(
                                 viewModel.getStrawScore(),
                                 viewModel.getOutWardScore()
                         )
                 );
             } else if(viewModel.getFarmType() == 4){
                 viewModel.setRestScore(
                         mc.calculatorRestScore(
                                 ((QuestionTemplateViewModel.SitTimeQuestion)viewModel.SitTimeQuestion).getScore(),
                                 ((QuestionTemplateViewModel.Question)viewModel.OutwardBackReg).getScore(),
                                 ((QuestionTemplateViewModel.Question)viewModel.OutwardBack).getScore(),
                                 ((QuestionTemplateViewModel.Question)viewModel.OutwardBreast).getScore()
                    )
                 );
             } else if(viewModel.getFarmType() == 5){
                 viewModel.setRestScore(
                         mc.calculatorFreeStallRestScore(
                                 ((QuestionTemplateViewModel.FreeStallCountQuestion)viewModel.FreeStallCountQuestion).getLowestScore(),
                                 ((QuestionTemplateViewModel.SitCollisionQuestion)viewModel.SitCollision).getScore(),
                                 ((QuestionTemplateViewModel.FreeStallAreaOutCollision)viewModel.FreeStallAreaOutCollision).getScore(),
                                 ((QuestionTemplateViewModel.SitTimeQuestion)viewModel.SitTimeQuestion).getScore(),
                                 ((QuestionTemplateViewModel.Question)viewModel.OutwardBackReg).getScore(),
                                 ((QuestionTemplateViewModel.Question)viewModel.OutwardBack).getScore(),
                                 ((QuestionTemplateViewModel.Question)viewModel.OutwardBreast).getScore()
                         )
                 );
             }

         }
         if(viewModel.getSummerRestScore() != -1){
             viewModel.setSummerRestScore(viewModel.calculatorBreedSummerRestScore(
                     ((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedShade).getSelectedItem(),
                     ((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedSummerVentilating).getSelectedItem(),
                     ((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedMistSpray).getSelectedItem()
                     )
             );
         }
         if(viewModel.getWinterRestScore() != -1){
             viewModel.setWinterRestScore( viewModel.calculatorBreedWinterRestScore(
                     ((QuestionTemplateViewModel.RadioQuestion) viewModel.BreedWindBlock).getSelectedItem(),
                     ((QuestionTemplateViewModel.RadioQuestion) viewModel.BreedWinterVentilating).getSelectedItem()
                     )
             );
         }


         if(((QuestionTemplateViewModel.PenQuestion)viewModel.BreedSlightHairLoss).getRatio() != -1
                 && ((QuestionTemplateViewModel.PenQuestion)viewModel.BreedCriticalHairLoss).getRatio() != -1
         ) {
             viewModel.setHairLossTotalRatio(
                     viewModel.calculatorHairLossTotalRatio(
                             ((QuestionTemplateViewModel.PenQuestion)viewModel.BreedSlightHairLoss).getRatio(),
                             ((QuestionTemplateViewModel.PenQuestion)viewModel.BreedCriticalHairLoss).getRatio()
                     )
             );
             viewModel.setHairLossScore(
                     viewModel.calculatorHairLossScore(
                             viewModel.getHairLossTotalRatio()
                     )
             );
         }

        if(viewModel.getMinInjuryScore() != -1){
            viewModel.setMinInjuryScore(
                    viewModel.calculatorMinInjuryScore(
                            viewModel.getFarmType(),
                            (int)((QuestionTemplateViewModel.Question)viewModel.BreedLimp).getScore(),
                            viewModel.getHairLossScore()
                    )
            );
        }
         if(viewModel.getHornRemovalScore() != -1){
             viewModel.setHornRemovalScore(
                     viewModel.calculatorHornRemovalScore(
                             ((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedHornRemoval).getSelectedItem(),
                             ((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedHornAnesthesia).getSelectedItem(),
                             ((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedHornPainkiller).getSelectedItem()
                     )
             );
         }


         if(viewModel.getCastrationScore() != -1){
             viewModel.setCastrationScore(
                     viewModel.calculatorCastrationScore(
                             ((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedCastration).getSelectedItem(),
                             ((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedCastrationAnesthesia).getSelectedItem(),
                             ((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedCastrationPainkiller).getSelectedItem()
                     )
             );
         }


         if(viewModel.getMinPainScore() != -1){
             viewModel.setMinPainScore(
                     viewModel.calculatorMinPainScore(
                             viewModel.getHornRemovalScore(),
                             viewModel.getCastrationScore()
                     )
             );
         }

         if(viewModel.getProtocolThreeScore() != -1){
             viewModel.setProtocolThreeScore(
                     viewModel.calculatorProtocolThreeResult(
                             viewModel.getFarmType(),
                             viewModel.getMinInjuryScore(),
                             viewModel.getMinPainScore(),
                             viewModel.getDiseaseScore()
                     )
             );
         }





         if(viewModel.isBeef(viewModel.getFarmType())) {
             if (viewModel.getCoughQuestion().getCoughPerOneAvg() != -1
                     && ((QuestionTemplateViewModel.PenQuestion) viewModel.BreedRunnyNose).getRatio() != -1
                     && ((QuestionTemplateViewModel.PenQuestion) viewModel.BreedOphthalmic).getRatio() != -1
                     && ((QuestionTemplateViewModel.PenQuestion) viewModel.BreedBreath).getRatio() != -1
                     && ((QuestionTemplateViewModel.PenQuestion) viewModel.BreedDiarrhea).getRatio() != -1
                     && ((QuestionTemplateViewModel.PenQuestion) viewModel.BreedRuminant).getRatio() != -1
                     && ((QuestionTemplateViewModel.PenQuestion) viewModel.BreedFallDead).getRatio() != -1
             ) {
                 viewModel.setDiseaseScore(
                         viewModel.calculatorDiseaseScore(
                                 viewModel.calculatorCareWarningScore(
                                         viewModel.calculatorDiseaseSectionOne(
                                                 ((QuestionTemplateViewModel.PenQuestion) viewModel.BreedRunnyNose).getRatio(),
                                                 ((QuestionTemplateViewModel.PenQuestion) viewModel.BreedOphthalmic).getRatio()
                                         ),
                                         viewModel.calculatorDiseaseSectionTwo(
                                                 viewModel.getCoughQuestion().getCoughRatio(),
                                                 ((QuestionTemplateViewModel.PenQuestion) viewModel.BreedBreath).getRatio()
                                         ),
                                         viewModel.calculatorDiseaseSectionThree(
                                                 ((QuestionTemplateViewModel.PenQuestion) viewModel.BreedRuminant).getRatio(),
                                                 ((QuestionTemplateViewModel.PenQuestion) viewModel.BreedDiarrhea).getRatio()
                                         ),
                                         viewModel.calculatorDiseaseSectionFour(
                                                 ((QuestionTemplateViewModel.PenQuestion) viewModel.BreedFallDead).getRatio()
                                         )
                                 )
                         )
                 );
             }
             if(viewModel.getSocialBehaviorScore() != -1){
                 viewModel.setSocialBehaviorScore(
                         viewModel.calculatorSocialBehaviorScore(
                                 ((QuestionTemplateViewModel.BehaviorQuestion)viewModel.StruggleQuestion).getBehaviorPerOneAvg(),
                                 ((QuestionTemplateViewModel.BehaviorQuestion)viewModel.HarmonyQuestion).getBehaviorPerOneAvg()
                         )
                 );
             }

             if(viewModel.getProtocolFourScore() != -1){
                 viewModel.setProtocolFourScore(
                         viewModel.calculatorProtocolFourScore
                                 (
                                         viewModel.getFarmType(),
                                         viewModel.getSocialBehaviorScore(),
                                         viewModel.getAvoidDistanceScore()
                                 )
                 );
             }
         } else {
             if(viewModel.getProtocolFourScore() != -1){
                 viewModel.setProtocolFourScore(
                         viewModel.calculatorProtocolFourScore
                                 (
                                         viewModel.getFarmType(),
                                         ((QuestionTemplateViewModel.MilkCowStruggleQuestion)viewModel.MilkCowStruggle).getRepScore(),
                                         viewModel.getAvoidDistanceScore()
                                 )
                 );
             }
         }




         if(farmType == 1){
             double totalWarmVenScore = viewModel.getSummerRestScore() * 0.7 + viewModel.getWinterRestScore() * 0.3;
             viewModel.setTotalWarmVentilatingScore(totalWarmVenScore);
             if(viewModel.getProtocolTwoScore() != -1){
                 viewModel.setProtocolTwoScore(
                         viewModel.calculatorProtocolTwoScore(
                                 viewModel.getRestScore(),
                                 viewModel.getTotalWarmVentilatingScore()
                         )
                 );
             }

         }
         else {

             viewModel.setCalfSummerRestScore(
                     viewModel.calculatorBreedSummerRestScore(
                             ((QuestionTemplateViewModel.RadioQuestion)viewModel.CalfShade).getSelectedItem(),
                             ((QuestionTemplateViewModel.RadioQuestion)viewModel.CalfSummerVentilating).getSelectedItem(),
                             ((QuestionTemplateViewModel.RadioQuestion)viewModel.CalfMistSpray).getSelectedItem()
                     )
             );
             viewModel.setCalfWinterRestScore(
                     viewModel.calculatorCalfWinterRestScore(
                             ((QuestionTemplateViewModel.RadioQuestion)viewModel.CalfStraw).getSelectedItem(),
                             ((QuestionTemplateViewModel.RadioQuestion)viewModel.CalfWarm).getSelectedItem(),
                             ((QuestionTemplateViewModel.RadioQuestion)viewModel.CalfWindBlock).getSelectedItem()
                     )
             );
             viewModel.setTotalWarmVentilatingScore(
                     viewModel.calculatorTotalWarmVentilationScore(
                             viewModel.getFarmType(),
                             viewModel.getSummerRestScore(),
                             viewModel.getWinterRestScore(),
                             viewModel.getCalfSummerRestScore(),
                             viewModel.getCalfWinterRestScore()
                     )
             );

             if(viewModel.isBeef(viewModel.getFarmType())) {
                 if(viewModel.getProtocolTwoScore() != -1){
                     viewModel.setProtocolTwoScore(
                             viewModel.calculatorProtocolTwoScore(
                                     viewModel.getRestScore(),
                                     viewModel.getTotalWarmVentilatingScore()
                             )
                     );
                 }

             } else {
                 viewModel.setProtocolTwoScore(
                         mc.calculatorProtocolTwoScore(
                                 viewModel.getRestScore(),
                                 viewModel.getTotalWarmVentilatingScore(),
                                 ((QuestionTemplateViewModel.MovementStability)viewModel.MovementStability).getScore()
                         )
                 );
             }

         }
     }
}



