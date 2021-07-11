package com.example.animal_project.BreedBatch.ProtocolTwo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;

import java.util.Arrays;

public class BreedStrawDong extends AppCompatActivity {
    private int dong_size;
    private ImageButton prev_dong_btn;
    private ImageButton next_dong_btn;
    private ImageButton home_btn;
    private Button breed_dong_straw_btn;

    private TextView current_dong;
    private TextView total_dong;
    private LinearLayout[] dong = new LinearLayout[20];
    private int currentDong = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breed_straw_dong);

        QuestionTemplateViewModel viewModel = new ViewModelProvider(this).get(QuestionTemplateViewModel.class);
        Intent intent = getIntent();
        dong_size = intent.getExtras().getInt("dong_count");
        
        prev_dong_btn = findViewById(R.id.prev_dong_straw_btn);
        next_dong_btn = findViewById(R.id.next_dong_straw_btn);
        breed_dong_straw_btn  = findViewById(R.id.breed_dong_straw_btn);
        home_btn = findViewById(R.id.dong_straw_home_btn);
        current_dong = findViewById(R.id.current_dong_straw);
        total_dong = findViewById(R.id.total_dong_straw);



        LinearLayout dong_1 = findViewById(R.id.breed_dong_straw_1);
        LinearLayout dong_2 = findViewById(R.id.breed_dong_straw_2);
        LinearLayout dong_3 = findViewById(R.id.breed_dong_straw_3);
        LinearLayout dong_4 = findViewById(R.id.breed_dong_straw_4);
        LinearLayout dong_5 = findViewById(R.id.breed_dong_straw_5);
        LinearLayout dong_6 = findViewById(R.id.breed_dong_straw_6);
        LinearLayout dong_7 = findViewById(R.id.breed_dong_straw_7);
        LinearLayout dong_8 = findViewById(R.id.breed_dong_straw_8);
        LinearLayout dong_9 = findViewById(R.id.breed_dong_straw_9);
        LinearLayout dong_10 = findViewById(R.id.breed_dong_straw_10);
        LinearLayout dong_11 = findViewById(R.id.breed_dong_straw_11);
        LinearLayout dong_12 = findViewById(R.id.breed_dong_straw_12);
        LinearLayout dong_13 = findViewById(R.id.breed_dong_straw_13);
        LinearLayout dong_14 = findViewById(R.id.breed_dong_straw_14);
        LinearLayout dong_15 = findViewById(R.id.breed_dong_straw_15);
        LinearLayout dong_16 = findViewById(R.id.breed_dong_straw_16);
        LinearLayout dong_17 = findViewById(R.id.breed_dong_straw_17);
        LinearLayout dong_18 = findViewById(R.id.breed_dong_straw_18);
        LinearLayout dong_19 = findViewById(R.id.breed_dong_straw_19);
        LinearLayout dong_20 = findViewById(R.id.breed_dong_straw_20);
        LinearLayout[] dong = {dong_1,dong_2,dong_3,dong_4,dong_5,dong_6,dong_7,dong_8,dong_9,dong_10,dong_11
                ,dong_12,dong_13,dong_14,dong_15,dong_16,dong_17,dong_18,dong_19,dong_20};


        RadioGroup rdiog_straw_feed_tank_1 = findViewById(R.id.rdiog_straw_feed_tank_1);
        RadioGroup rdiog_straw_normal_1 = findViewById(R.id.rdiog_straw_normal_1) ;
        RadioGroup rdiog_straw_resting_place_1= findViewById(R.id.rdiog_straw_resting_place_1);
        TextView breed_straw_score_1 = findViewById(R.id.breed_straw_score_1);

        RadioGroup rdiog_straw_feed_tank_2 = findViewById(R.id.rdiog_straw_feed_tank_2);
        RadioGroup rdiog_straw_normal_2 = findViewById(R.id.rdiog_straw_normal_2) ;
        RadioGroup rdiog_straw_resting_place_2= findViewById(R.id.rdiog_straw_resting_place_2);
        TextView breed_straw_score_2 = findViewById(R.id.breed_straw_score_2);

        RadioGroup rdiog_straw_feed_tank_3 = findViewById(R.id.rdiog_straw_feed_tank_3);
        RadioGroup rdiog_straw_normal_3 = findViewById(R.id.rdiog_straw_normal_3) ;
        RadioGroup rdiog_straw_resting_place_3= findViewById(R.id.rdiog_straw_resting_place_3);
        TextView breed_straw_score_3 = findViewById(R.id.breed_straw_score_3);

        RadioGroup rdiog_straw_feed_tank_4 = findViewById(R.id.rdiog_straw_feed_tank_4);
        RadioGroup rdiog_straw_normal_4 = findViewById(R.id.rdiog_straw_normal_4) ;
        RadioGroup rdiog_straw_resting_place_4= findViewById(R.id.rdiog_straw_resting_place_4);
        TextView breed_straw_score_4 = findViewById(R.id.breed_straw_score_4);

        RadioGroup rdiog_straw_feed_tank_5 = findViewById(R.id.rdiog_straw_feed_tank_5);
        RadioGroup rdiog_straw_normal_5 = findViewById(R.id.rdiog_straw_normal_5) ;
        RadioGroup rdiog_straw_resting_place_5= findViewById(R.id.rdiog_straw_resting_place_5);
        TextView breed_straw_score_5 = findViewById(R.id.breed_straw_score_5);

        RadioGroup rdiog_straw_feed_tank_6 = findViewById(R.id.rdiog_straw_feed_tank_6);
        RadioGroup rdiog_straw_normal_6 = findViewById(R.id.rdiog_straw_normal_6) ;
        RadioGroup rdiog_straw_resting_place_6= findViewById(R.id.rdiog_straw_resting_place_6);
        TextView breed_straw_score_6 = findViewById(R.id.breed_straw_score_6);

        RadioGroup rdiog_straw_feed_tank_7 = findViewById(R.id.rdiog_straw_feed_tank_7);
        RadioGroup rdiog_straw_normal_7 = findViewById(R.id.rdiog_straw_normal_7) ;
        RadioGroup rdiog_straw_resting_place_7= findViewById(R.id.rdiog_straw_resting_place_1);
        TextView breed_straw_score_7 = findViewById(R.id.breed_straw_score_7);

        RadioGroup rdiog_straw_feed_tank_8 = findViewById(R.id.rdiog_straw_feed_tank_8);
        RadioGroup rdiog_straw_normal_8 = findViewById(R.id.rdiog_straw_normal_8) ;
        RadioGroup rdiog_straw_resting_place_8= findViewById(R.id.rdiog_straw_resting_place_8);
        TextView breed_straw_score_8 = findViewById(R.id.breed_straw_score_8);

        RadioGroup rdiog_straw_feed_tank_9 = findViewById(R.id.rdiog_straw_feed_tank_9);
        RadioGroup rdiog_straw_normal_9 = findViewById(R.id.rdiog_straw_normal_9) ;
        RadioGroup rdiog_straw_resting_place_9= findViewById(R.id.rdiog_straw_resting_place_9);
        TextView breed_straw_score_9 = findViewById(R.id.breed_straw_score_9);

        RadioGroup rdiog_straw_feed_tank_10 = findViewById(R.id.rdiog_straw_feed_tank_10);
        RadioGroup rdiog_straw_normal_10 = findViewById(R.id.rdiog_straw_normal_10) ;
        RadioGroup rdiog_straw_resting_place_10= findViewById(R.id.rdiog_straw_resting_place_10);
        TextView breed_straw_score_10 = findViewById(R.id.breed_straw_score_10);

        RadioGroup rdiog_straw_feed_tank_11 = findViewById(R.id.rdiog_straw_feed_tank_11);
        RadioGroup rdiog_straw_normal_11 = findViewById(R.id.rdiog_straw_normal_11) ;
        RadioGroup rdiog_straw_resting_place_11= findViewById(R.id.rdiog_straw_resting_place_11);
        TextView breed_straw_score_11 = findViewById(R.id.breed_straw_score_11);

        RadioGroup rdiog_straw_feed_tank_12 = findViewById(R.id.rdiog_straw_feed_tank_12);
        RadioGroup rdiog_straw_normal_12 = findViewById(R.id.rdiog_straw_normal_12) ;
        RadioGroup rdiog_straw_resting_place_12= findViewById(R.id.rdiog_straw_resting_place_12);
        TextView breed_straw_score_12 = findViewById(R.id.breed_straw_score_12);

        RadioGroup rdiog_straw_feed_tank_13 = findViewById(R.id.rdiog_straw_feed_tank_13);
        RadioGroup rdiog_straw_normal_13 = findViewById(R.id.rdiog_straw_normal_13) ;
        RadioGroup rdiog_straw_resting_place_13= findViewById(R.id.rdiog_straw_resting_place_13);
        TextView breed_straw_score_13 = findViewById(R.id.breed_straw_score_13);

        RadioGroup rdiog_straw_feed_tank_14 = findViewById(R.id.rdiog_straw_feed_tank_14);
        RadioGroup rdiog_straw_normal_14 = findViewById(R.id.rdiog_straw_normal_14) ;
        RadioGroup rdiog_straw_resting_place_14= findViewById(R.id.rdiog_straw_resting_place_14);
        TextView breed_straw_score_14 = findViewById(R.id.breed_straw_score_14);

        RadioGroup rdiog_straw_feed_tank_15 = findViewById(R.id.rdiog_straw_feed_tank_15);
        RadioGroup rdiog_straw_normal_15 = findViewById(R.id.rdiog_straw_normal_15) ;
        RadioGroup rdiog_straw_resting_place_15= findViewById(R.id.rdiog_straw_resting_place_15);
        TextView breed_straw_score_15 = findViewById(R.id.breed_straw_score_15);

        RadioGroup rdiog_straw_feed_tank_16 = findViewById(R.id.rdiog_straw_feed_tank_16);
        RadioGroup rdiog_straw_normal_16 = findViewById(R.id.rdiog_straw_normal_16) ;
        RadioGroup rdiog_straw_resting_place_16= findViewById(R.id.rdiog_straw_resting_place_16);
        TextView breed_straw_score_16 = findViewById(R.id.breed_straw_score_16);

        RadioGroup rdiog_straw_feed_tank_17 = findViewById(R.id.rdiog_straw_feed_tank_17);
        RadioGroup rdiog_straw_normal_17 = findViewById(R.id.rdiog_straw_normal_17) ;
        RadioGroup rdiog_straw_resting_place_17= findViewById(R.id.rdiog_straw_resting_place_17);
        TextView breed_straw_score_17 = findViewById(R.id.breed_straw_score_17);

        RadioGroup rdiog_straw_feed_tank_18 = findViewById(R.id.rdiog_straw_feed_tank_18);
        RadioGroup rdiog_straw_normal_18 = findViewById(R.id.rdiog_straw_normal_18) ;
        RadioGroup rdiog_straw_resting_place_18= findViewById(R.id.rdiog_straw_resting_place_18);
        TextView breed_straw_score_18 = findViewById(R.id.breed_straw_score_18);

        RadioGroup rdiog_straw_feed_tank_19 = findViewById(R.id.rdiog_straw_feed_tank_19);
        RadioGroup rdiog_straw_normal_19 = findViewById(R.id.rdiog_straw_normal_19) ;
        RadioGroup rdiog_straw_resting_place_19= findViewById(R.id.rdiog_straw_resting_place_19);
        TextView breed_straw_score_19 = findViewById(R.id.breed_straw_score_19);

        RadioGroup rdiog_straw_feed_tank_20 = findViewById(R.id.rdiog_straw_feed_tank_20);
        RadioGroup rdiog_straw_normal_20 = findViewById(R.id.rdiog_straw_normal_20) ;
        RadioGroup rdiog_straw_resting_place_20= findViewById(R.id.rdiog_straw_resting_place_20);
        TextView breed_straw_score_20 = findViewById(R.id.breed_straw_score_20);

        total_dong.setText(String.valueOf(dong_size));
        if(dong_size == 1){
            next_dong_btn.setVisibility(View.INVISIBLE);
            prev_dong_btn.setVisibility(View.INVISIBLE);
            breed_dong_straw_btn.setVisibility(View.VISIBLE);
        }


    viewModel.clickDongHandler(next_dong_btn,prev_dong_btn,breed_dong_straw_btn,dong,current_dong,dong_size);
        home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        viewModel.setDongStrawScore(rdiog_straw_feed_tank_1,rdiog_straw_normal_1,rdiog_straw_resting_place_1,breed_straw_score_1);
        viewModel.setDongStrawScore(rdiog_straw_feed_tank_2,rdiog_straw_normal_2,rdiog_straw_resting_place_2,breed_straw_score_2);
        viewModel.setDongStrawScore(rdiog_straw_feed_tank_3,rdiog_straw_normal_3,rdiog_straw_resting_place_3,breed_straw_score_3);
        viewModel.setDongStrawScore(rdiog_straw_feed_tank_4,rdiog_straw_normal_4,rdiog_straw_resting_place_4,breed_straw_score_4);
        viewModel.setDongStrawScore(rdiog_straw_feed_tank_5,rdiog_straw_normal_5,rdiog_straw_resting_place_5,breed_straw_score_5);
        viewModel.setDongStrawScore(rdiog_straw_feed_tank_6,rdiog_straw_normal_6,rdiog_straw_resting_place_6,breed_straw_score_6);
        viewModel.setDongStrawScore(rdiog_straw_feed_tank_7,rdiog_straw_normal_7,rdiog_straw_resting_place_7,breed_straw_score_7);
        viewModel.setDongStrawScore(rdiog_straw_feed_tank_8,rdiog_straw_normal_8,rdiog_straw_resting_place_8,breed_straw_score_8);
        viewModel.setDongStrawScore(rdiog_straw_feed_tank_9,rdiog_straw_normal_9,rdiog_straw_resting_place_9,breed_straw_score_9);
        viewModel.setDongStrawScore(rdiog_straw_feed_tank_10,rdiog_straw_normal_10,rdiog_straw_resting_place_10,breed_straw_score_10);
        viewModel.setDongStrawScore(rdiog_straw_feed_tank_11,rdiog_straw_normal_11,rdiog_straw_resting_place_11,breed_straw_score_11);
        viewModel.setDongStrawScore(rdiog_straw_feed_tank_12,rdiog_straw_normal_12,rdiog_straw_resting_place_12,breed_straw_score_12);
        viewModel.setDongStrawScore(rdiog_straw_feed_tank_13,rdiog_straw_normal_13,rdiog_straw_resting_place_13,breed_straw_score_13);
        viewModel.setDongStrawScore(rdiog_straw_feed_tank_14,rdiog_straw_normal_14,rdiog_straw_resting_place_14,breed_straw_score_14);
        viewModel.setDongStrawScore(rdiog_straw_feed_tank_15,rdiog_straw_normal_15,rdiog_straw_resting_place_15,breed_straw_score_15);
        viewModel.setDongStrawScore(rdiog_straw_feed_tank_16,rdiog_straw_normal_16,rdiog_straw_resting_place_16,breed_straw_score_16);
        viewModel.setDongStrawScore(rdiog_straw_feed_tank_17,rdiog_straw_normal_17,rdiog_straw_resting_place_17,breed_straw_score_17);
        viewModel.setDongStrawScore(rdiog_straw_feed_tank_18,rdiog_straw_normal_18,rdiog_straw_resting_place_18,breed_straw_score_18);
        viewModel.setDongStrawScore(rdiog_straw_feed_tank_19,rdiog_straw_normal_19,rdiog_straw_resting_place_19,breed_straw_score_19);
        viewModel.setDongStrawScore(rdiog_straw_feed_tank_20,rdiog_straw_normal_20,rdiog_straw_resting_place_20,breed_straw_score_20);

        TextView[] strawScoreTvArr = {breed_straw_score_1,breed_straw_score_2,breed_straw_score_3,breed_straw_score_4,breed_straw_score_5,
                breed_straw_score_6,breed_straw_score_7,breed_straw_score_8,breed_straw_score_9,breed_straw_score_10,
                breed_straw_score_11,breed_straw_score_12,breed_straw_score_13,breed_straw_score_14,breed_straw_score_15,
                breed_straw_score_16,breed_straw_score_17,breed_straw_score_18,breed_straw_score_19,breed_straw_score_20,};


        breed_dong_straw_btn.setOnClickListener(new View.OnClickListener() {
            int [] strawScoreArr = new int[dong_size];
            @Override
            public void onClick(View view) {

                for (int idx = 0; idx < dong_size; idx++) {
                    strawScoreArr[idx] = Integer.parseInt((String) strawScoreTvArr[idx].getText());
                    Log.d("str[idx]",String.valueOf(strawScoreArr[idx]));
                }

                Arrays.sort(strawScoreArr);

                int minStrawScore = strawScoreArr[0];
                Intent intent = new Intent();
                intent.putExtra("minStrawScore", minStrawScore);
                setResult(1, intent);
                finish();
                }
            });
        }
    }
