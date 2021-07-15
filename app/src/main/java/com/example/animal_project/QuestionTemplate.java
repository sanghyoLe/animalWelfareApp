package com.example.animal_project;

import android.app.AlertDialog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
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
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;


public class QuestionTemplate extends AppCompatActivity
 {
     public static Context context_question_template;


     // 정보 입력 창에서 넘어온 정보들
     private String farmName;
     private String address;
     private String addressDetail;
     private String repName;
     private int totalCowSize;
     private int totalAdultCow;
     private int totalChildCow;
     private String evaName;
     private String evaDate;
     private int farmType = 0;
     private int sampleCowSize;
     // ------------------------------
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
    // 한 육우 프로토콜 질문 항목 Fragments
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
    // ---------------------------------------


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
    // --------------------------------------------------------


     // 한 육우 프로토콜 질문 항목 fragments 를 담는 배열
    private Fragment[] breed_frag_arr = new Fragment[20];

    int count = 0;
     QuestionTemplateViewModel viewModel;
     AlertDialog.Builder myAlertBuilder;


     // 사용자가 이전 안드로이드 이전 버튼 눌렀을 때 처리를 위한 Override
     @Override
     public void onBackPressed(){
         myOnBackPressed(myAlertBuilder);
     }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_template);
        myAlertBuilder = new AlertDialog.Builder(QuestionTemplate.this);

        // 결과 창 fragments  ?Activity 로 변경할 지 고민중(변경 시 모든 정보 Bundle 로 결과창에 넘겨주어야 함) ----------------------
        result_total = new ResultTotal();
        result1 = new Result_1();
        result2 = new Result_2();
        result3 = new Result_3();
        result4 = new Result_4();
        // ------------------------------------------

        viewModel = new ViewModelProvider(this).get(QuestionTemplateViewModel.class);
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
        sampleCowSize = BeforeBundle.getInt("sampleCowSize");
        // 정보 잘 넘어 오는지 로그  -------------------------------------
        Log.d("farmName",String.valueOf(farmName));
        Log.d("address",String.valueOf(address));
        Log.d("detail",String.valueOf(addressDetail));
        Log.d("repName",String.valueOf(repName));
        Log.d("totalCowSize",String.valueOf(totalCowSize));
        Log.d("totalAdultCow",String.valueOf(totalAdultCow));
        Log.d("totalChildCow",String.valueOf(totalChildCow));
        Log.d("evaName",String.valueOf(evaName));
        Log.d("evaDate",String.valueOf(evaDate));
        Log.d("farmType",String.valueOf(farmType));
        Log.d("sampleCowSize",String.valueOf(sampleCowSize));
        // -----------------------------------------------

        // ------------------------------------------------

        // ---- 테스트를 위한 최소 정보 ---------
/*        farmType = BeforeBundle.getInt("farmType");
        totalCowSize = BeforeBundle.getInt("totalCow");
        sampleCowSize = BeforeBundle.getInt("sampleCowSize");*/
        // ------------------------------------
        viewModel.setSampleCowSize(sampleCowSize);
        viewModel.setTotalCowSize(totalCowSize);
        breed_frag_arr = new Fragment[]{ breed_poor,breed_water_q1,breed_water_q2,breed_water_q3,
                breed_straw,breed_outward,breed_shade,breed_summer_ventilating,breed_mist_spray,
                breed_wind_block,breed_winter_ventilating,calf_shade,calf_summer_ventilating,calf_mist_spray,
                calf_straw,calf_warm,calf_wind_block,breed_limp,breed_slight_hair_loss,breed_critical_hair_loss,
                breed_cough,breed_runny_nose,breed_ophthalmic,breed_breath,breed_diarrhea,breed_ruminant,breed_fall_dead,
                breed_horn_q1,breed_horn_q2,breed_horn_q3,breed_castration_q1,breed_castration_q2,breed_castration_q3,
        breed_struggle,breed_harmony,breed_avoid_distance};

        // 목록 버튼 누르면 왼쪽에서 나오는 드로우 나타내기 및 없애기 & 체크 이미지 바꾸기
        list_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerHandler();
                changeCheckImageFunc();
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
                View view = findViewById(R.id.list_sub_menu_2);
                listMenuBtnHandler(list_menu_btn_2,view);
            }
        });
        list_menu_btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = findViewById(R.id.list_sub_menu_3);
                listMenuBtnHandler(list_menu_btn_3,view);
            }
        });
        list_menu_btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = findViewById(R.id.list_sub_menu_4);
                listMenuBtnHandler(list_menu_btn_4,view);
            }
        });


        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_paper, breed_poor).commitAllowingStateLoss();
        if (farmType == 1) {

        }
        else if (farmType == 2 || farmType == 3) {
            total_page.setText(String.valueOf(" / " + breed_frag_arr.length));
        }
        else if (farmType == 4) {

        }
        else if (farmType == 5) {

        }


    }
    public void listBtnHandler(View view){
        transaction = fragmentManager.beginTransaction();
        switch(view.getId()){
          case  R.id.question_list_btn_1:

              count = listBtnHandlerFunc(0);
            break;
            case  R.id.question_list_btn_2:
                count = listBtnHandlerFunc(1);
                break;
            case  R.id.question_list_btn_3:
                count = listBtnHandlerFunc(2);
                break;
            case  R.id.question_list_btn_4:
                count = listBtnHandlerFunc(3);
                break;
            case  R.id.question_list_btn_5:
                count = listBtnHandlerFunc(4);
                break;
            case  R.id.question_list_btn_6:
                count = listBtnHandlerFunc(5);
                break;
            case  R.id.question_list_btn_7:
                count = listBtnHandlerFunc(6);
                break;
            case  R.id.question_list_btn_8:
                count = listBtnHandlerFunc(7);
                break;
            case  R.id.question_list_btn_9:
                count = listBtnHandlerFunc(8);
                break;
            case  R.id.question_list_btn_10:
                count = listBtnHandlerFunc(9);
                break;
            case  R.id.question_list_btn_11:
                count = listBtnHandlerFunc(10);
                break;
            case  R.id.question_list_btn_12:
                count = listBtnHandlerFunc(11);
                break;
            case  R.id.question_list_btn_13:
                count = listBtnHandlerFunc(12);
                break;
            case  R.id.question_list_btn_14:
                count = listBtnHandlerFunc(13);
                break;
            case  R.id.question_list_btn_15:
                count = listBtnHandlerFunc(14);
                break;
            case  R.id.question_list_btn_16:
                count = listBtnHandlerFunc(15);
                break;
            case  R.id.question_list_btn_17:
                count = listBtnHandlerFunc(16);
                break;
            case  R.id.question_list_btn_18:
                count = listBtnHandlerFunc(17);
                break;
            case  R.id.question_list_btn_19:
                count = listBtnHandlerFunc(18);
                break;
            case  R.id.question_list_btn_20:
                count = listBtnHandlerFunc(19);
                break;
            case  R.id.question_list_btn_21:
                count = listBtnHandlerFunc(20);
                break;
            case  R.id.question_list_btn_22:
                count = listBtnHandlerFunc(21);
                break;
            case  R.id.question_list_btn_23:
                count = listBtnHandlerFunc(22);
                break;
            case  R.id.question_list_btn_24:
                count = listBtnHandlerFunc(23);
                break;
            case  R.id.question_list_btn_25:
                count = listBtnHandlerFunc(24);
                break;
            case  R.id.question_list_btn_26:
                count = listBtnHandlerFunc(25);
                break;
            case  R.id.question_list_btn_27:
                count = listBtnHandlerFunc(26);
                break;
            case  R.id.question_list_btn_28:
                count = listBtnHandlerFunc(27);
                break;
            case  R.id.question_list_btn_29:
                count = listBtnHandlerFunc(28);
                break;
            case  R.id.question_list_btn_30:
                count = listBtnHandlerFunc(29);
                break;
            case  R.id.question_list_btn_31:
                count = listBtnHandlerFunc(30);
                break;
            case  R.id.question_list_btn_32:
                count = listBtnHandlerFunc(31);
                break;
            case  R.id.question_list_btn_33:
                count = listBtnHandlerFunc(32);
                break;
            case  R.id.question_list_btn_34:
                count = listBtnHandlerFunc(33);
                break;
            case  R.id.question_list_btn_35:
                count = listBtnHandlerFunc(34);
                break;
            case  R.id.question_list_btn_36:
                count = listBtnHandlerFunc(35);
                next_btn.setVisibility(View.INVISIBLE);
                end_btn.setVisibility(View.VISIBLE);
                break;
            default:
            break;

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

                }
                else if (farmType == 2 || farmType == 3) {
                    nextBtnHandler(count,breed_frag_arr.length);
                    transaction.replace(R.id.fragment_paper,breed_frag_arr[++count]).commitAllowingStateLoss();

                }
                else if (farmType == 4) {

                }
                else if (farmType == 5) {

                }
                current_page.setText(String.valueOf(count+1));

                break;
                // 이전 버튼 누를 시 이어질 페이지 지정
            case R.id.previous_btn:
                if (farmType == 1) {

                }
                else if (farmType == 2 || farmType == 3) {
                    prevBtnHandler(count,breed_frag_arr.length);
                    transaction.replace(R.id.fragment_paper, breed_frag_arr[--count]).commitAllowingStateLoss();
                }
                else if (farmType == 4) {
                }
                else if (farmType == 5) {

                }
                current_page.setText(String.valueOf(count+1));
                break;
            case R.id.back_btn:
                myOnBackPressed(myAlertBuilder);
                break;
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
                break;

        }
    }


    private void nextBtnHandler(int count, int totalPageLength){
        if(count + 2 == totalPageLength){
            next_btn.setVisibility(View.INVISIBLE);
            end_btn.setVisibility(View.VISIBLE);
        }
        prev_btn.setVisibility(View.VISIBLE);
        closeDrawer();
    }
    private void prevBtnHandler(int count, int totalPageLength){
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
            list_btn.setImageResource(R.drawable.outline_menu_open_24);
        } else if(drawer.isDrawerOpen(Gravity.LEFT)){
            drawer.closeDrawer(Gravity.LEFT);
            list_btn.setImageResource(R.drawable.outline_reorder_24);
        }
    }
    private void closeDrawer(){
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);
        drawer.closeDrawer(Gravity.LEFT);
        list_btn.setImageResource(R.drawable.outline_reorder_24);
    }
    private int listBtnHandlerFunc(int listCount){
        int count = listCount;
        if(count == 0){
            prev_btn.setVisibility(View.INVISIBLE);
        } else {
            next_btn.setVisibility(View.VISIBLE);
            prev_btn.setVisibility(View.VISIBLE);
        }
        end_btn.setVisibility(View.GONE);
        current_page.setText(String.valueOf(count+1));
        closeDrawer();
        transaction.replace(R.id.fragment_paper,breed_frag_arr[count]).commitAllowingStateLoss();
        return count;
    }
    private void changeCheckImageFunc (){
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
        ImageView check_sub_18 = findViewById(R.id.check_sub_18);
        ImageView check_sub_19 = findViewById(R.id.check_sub_19);
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
        ImageView check_sub_34 = findViewById(R.id.check_sub_34);
        ImageView check_sub_35 = findViewById(R.id.check_sub_35);
        ImageView check_sub_36 = findViewById(R.id.check_sub_36);


        // 프로토콜 1
        changeEditTextCheckImage(check_sub_1,viewModel.getPoorScore());
        if(viewModel.getWaterTankNum() != -1) changeCheckImage(check_sub_2);
        if(viewModel.getWaterTankClean() != -1) changeCheckImage(check_sub_3);
        if(viewModel.getWaterDrink() != -1) changeCheckImage(check_sub_4);
        if(viewModel.getProtocolOneScore() != -1)changeCheckImage(check_total_1);

        // 프로토콜 2
        if(viewModel.getStrawScore() != -1) changeCheckImage(check_sub_5);
        if(viewModel.getOutWardScore() != -1) changeCheckImage(check_sub_6);
        if(viewModel.getShadeScore() != -1) changeCheckImage(check_sub_7);
        if(viewModel.getSummerVentilatingScore() != -1) changeCheckImage(check_sub_8);
        if(viewModel.getMistSprayScore() != -1) changeCheckImage(check_sub_9);
        if(viewModel.getWindBlockScore() != -1) changeCheckImage(check_sub_10);
        if(viewModel.getWinterVentilatingScore() != -1) changeCheckImage(check_sub_11);
        if(viewModel.getCalfShadeScore() != -1) changeCheckImage(check_sub_12);
        if(viewModel.getCalfSummerVentilatingScore() != -1) changeCheckImage(check_sub_13);
        if(viewModel.getCalfMistSprayScore() != -1) changeCheckImage(check_sub_14);
        if(viewModel.getCalfStrawScore() != -1) changeCheckImage(check_sub_15);
        if(viewModel.getCalfWarmScore() != -1) changeCheckImage(check_sub_16);
        if(viewModel.getCalfWindBlockScore() != -1) changeCheckImage(check_sub_17);
        if(viewModel.getProtocolTwoScore() != -1) changeCheckImage(check_total_2);

        //프로토콜 3
        if(viewModel.getLimpScore() != -1) changeCheckImage(check_sub_18);
        changeEditTextCheckImage(check_sub_19,(int)viewModel.getSlightHairLoss());
        changeEditTextCheckImage(check_sub_20,(int)viewModel.getCriticalHairLoss());
        if(viewModel.getCough() != -1) changeCheckImage(check_sub_21);
        changeEditTextCheckImage(check_sub_22,(int)viewModel.getRunnyNoseRatio());
        changeEditTextCheckImage(check_sub_23,(int)viewModel.getOphthalmicRatio());
        changeEditTextCheckImage(check_sub_24,(int)viewModel.getBreathRatio());
        changeEditTextCheckImage(check_sub_25,(int)viewModel.getDiarrheaRatio());
        changeEditTextCheckImage(check_sub_26,(int)viewModel.getRuminantRatio());
        changeEditTextCheckImage(check_sub_27,(int)viewModel.getFallDeadRatio());
        if(viewModel.getHornRemoval() != -1) changeCheckImage(check_sub_28);
        if(viewModel.getAnesthesia() != -1) changeCheckImage(check_sub_29);
        if(viewModel.getPainkiller() != -1) changeCheckImage(check_sub_30);
        if(viewModel.getCastration() != -1) changeCheckImage(check_sub_31);
        if(viewModel.getCastrationAnesthesia() != -1) changeCheckImage(check_sub_32);
        if(viewModel.getCastrationPainkiller() != -1) changeCheckImage(check_sub_33);
        if(viewModel.getProtocolThreeScore() != -1) changeCheckImage(check_total_3);


        //프로토콜 4
        if(viewModel.getStruggle() != -1) changeCheckImage(check_sub_34);
        if(viewModel.getHarmony() != -1)changeCheckImage(check_sub_35);
        if(viewModel.getAvoidDistanceScore() != -1) changeCheckImage(check_sub_36);
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
                "정보 입력 화면으로 돌아가시겠습니까?");
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


}
