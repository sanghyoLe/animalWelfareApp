package com.example.animal_project.BreedBatchQuestion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.animal_project.R;

public class Breed_q5 extends AppCompatActivity {
    private int dong_size;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breed_q5);

        Intent intent = getIntent();
        dong_size = intent.getExtras().getInt("dong_count");

        LinearLayout dong_1 = findViewById(R.id.breed_dong_q5_1);
        LinearLayout dong_2 = findViewById(R.id.breed_dong_q5_2);
        LinearLayout dong_3 = findViewById(R.id.breed_dong_q5_3);
        LinearLayout dong_4 = findViewById(R.id.breed_dong_q5_4);
        LinearLayout dong_5 = findViewById(R.id.breed_dong_q5_5);
        LinearLayout dong_6 = findViewById(R.id.breed_dong_q5_6);
        LinearLayout dong_7 = findViewById(R.id.breed_dong_q5_7);
        LinearLayout dong_8 = findViewById(R.id.breed_dong_q5_8);
        LinearLayout dong_9 = findViewById(R.id.breed_dong_q5_9);
        LinearLayout dong_10 = findViewById(R.id.breed_dong_q5_10);
        LinearLayout dong_11 = findViewById(R.id.breed_dong_q5_11);
        LinearLayout dong_12 = findViewById(R.id.breed_dong_q5_12);
        LinearLayout dong_13 = findViewById(R.id.breed_dong_q5_13);
        LinearLayout dong_14 = findViewById(R.id.breed_dong_q5_14);
        LinearLayout dong_15 = findViewById(R.id.breed_dong_q5_15);
        LinearLayout dong_16 = findViewById(R.id.breed_dong_q5_16);
        LinearLayout dong_17 = findViewById(R.id.breed_dong_q5_17);
        LinearLayout dong_18 = findViewById(R.id.breed_dong_q5_18);
        LinearLayout dong_19 = findViewById(R.id.breed_dong_q5_19);
        LinearLayout dong_20 = findViewById(R.id.breed_dong_q5_20);
        LinearLayout[] dong = {dong_1,dong_2,dong_3,dong_4,dong_5,dong_6,dong_7,dong_8,dong_9,dong_10,dong_11
                ,dong_12,dong_13,dong_14,dong_15,dong_16,dong_17,dong_18,dong_19,dong_20};

        for(int idx = 0 ; idx < dong_size ; idx++)
        {
            dong[idx].setVisibility(View.VISIBLE);
        }

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


   /*     RadioGroup[] group1 = new RadioGroup[20];
        RadioGroup[] group2 = new RadioGroup[20];
        RadioGroup[] group3 = new RadioGroup[20];
        TextView[] tvGroup = new TextView[20];

        for( int i=1; i<= 20; i++){
            int k = getResources().getIdentifier("rdiog_straw_feed_tank_"+i, "id", getPackageName());
            int k1 = getResources().getIdentifier("rdiog_straw_normal_"+i, "id", getPackageName());
            int k2 = getResources().getIdentifier("rdiog_straw_resting_place_"+i, "id", getPackageName());
            int k3 = getResources().getIdentifier("breed_straw_score_"+i, "id", getPackageName());
            group1[i] = findViewById(k);
            group2[i] = findViewById(k1);
            group3[i] = findViewById(k2);
            tvGroup[i] = findViewById(k3);
            setStrawScore(group1[i],group2[i],group3[i],tvGroup[i]);
        }*/

      setStrawScore(rdiog_straw_feed_tank_1,rdiog_straw_normal_1,rdiog_straw_resting_place_1,breed_straw_score_1);
        setStrawScore(rdiog_straw_feed_tank_2,rdiog_straw_normal_2,rdiog_straw_resting_place_2,breed_straw_score_2);
        setStrawScore(rdiog_straw_feed_tank_3,rdiog_straw_normal_3,rdiog_straw_resting_place_3,breed_straw_score_3);
        setStrawScore(rdiog_straw_feed_tank_4,rdiog_straw_normal_4,rdiog_straw_resting_place_4,breed_straw_score_4);
        setStrawScore(rdiog_straw_feed_tank_5,rdiog_straw_normal_5,rdiog_straw_resting_place_5,breed_straw_score_5);
        setStrawScore(rdiog_straw_feed_tank_6,rdiog_straw_normal_6,rdiog_straw_resting_place_6,breed_straw_score_6);
        setStrawScore(rdiog_straw_feed_tank_7,rdiog_straw_normal_7,rdiog_straw_resting_place_7,breed_straw_score_7);
        setStrawScore(rdiog_straw_feed_tank_8,rdiog_straw_normal_8,rdiog_straw_resting_place_8,breed_straw_score_8);
        setStrawScore(rdiog_straw_feed_tank_9,rdiog_straw_normal_9,rdiog_straw_resting_place_9,breed_straw_score_9);
        setStrawScore(rdiog_straw_feed_tank_10,rdiog_straw_normal_10,rdiog_straw_resting_place_10,breed_straw_score_10);
        setStrawScore(rdiog_straw_feed_tank_11,rdiog_straw_normal_11,rdiog_straw_resting_place_11,breed_straw_score_11);
        setStrawScore(rdiog_straw_feed_tank_12,rdiog_straw_normal_12,rdiog_straw_resting_place_12,breed_straw_score_12);
        setStrawScore(rdiog_straw_feed_tank_13,rdiog_straw_normal_13,rdiog_straw_resting_place_13,breed_straw_score_13);
        setStrawScore(rdiog_straw_feed_tank_14,rdiog_straw_normal_14,rdiog_straw_resting_place_14,breed_straw_score_14);
        setStrawScore(rdiog_straw_feed_tank_15,rdiog_straw_normal_15,rdiog_straw_resting_place_15,breed_straw_score_15);
        setStrawScore(rdiog_straw_feed_tank_16,rdiog_straw_normal_16,rdiog_straw_resting_place_16,breed_straw_score_16);
        setStrawScore(rdiog_straw_feed_tank_17,rdiog_straw_normal_17,rdiog_straw_resting_place_17,breed_straw_score_17);
        setStrawScore(rdiog_straw_feed_tank_18,rdiog_straw_normal_18,rdiog_straw_resting_place_18,breed_straw_score_18);
        setStrawScore(rdiog_straw_feed_tank_19,rdiog_straw_normal_19,rdiog_straw_resting_place_19,breed_straw_score_19);
        setStrawScore(rdiog_straw_feed_tank_20,rdiog_straw_normal_20,rdiog_straw_resting_place_20,breed_straw_score_20);

    }

    // Q. 60 /  10 / 40인 경우에는?
    public int getTotalStrawScore(int feedTank, int normal, int restingPlace){
        int StrawScore = 0;
        if(feedTank <= 2  && normal < 2 && restingPlace <  2) {
            StrawScore = 100;
        } else if(feedTank <= 2 && feedTank <= 2 && restingPlace < 2){
            StrawScore = 80;
        } else if(feedTank <= 3 && feedTank <= 3 && restingPlace <= 2){
            StrawScore = 60;
        } else if(feedTank <= 4 && feedTank <= 4 && restingPlace <= 3){
            StrawScore = 40;
        } else if(feedTank <= 4 && feedTank <= 4 && restingPlace <= 4) {
            StrawScore = 20;
        }
        return StrawScore;
    }
    public void setStrawScore(RadioGroup group1, RadioGroup group2, RadioGroup group3, TextView view){
        final int[] straw_feed_tank = {0};
        final int[] straw_normal = {0};
        final int[] straw_resting_place = {0};
        final int[] totalScore = {0};
        group1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override

            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View radioButton = group.findViewById(checkedId);
                int index = group.indexOfChild(radioButton);
                switch (index) {
                    case 0:
                        straw_feed_tank[0] = 1;
                        totalScore[0] = getTotalStrawScore(straw_feed_tank[0],straw_normal[0],straw_resting_place[0]);
                        view.setText(String.valueOf(totalScore[0]));
                        break;
                    case 1:
                        straw_feed_tank[0] = 2;
                        totalScore[0] = getTotalStrawScore(straw_feed_tank[0],straw_normal[0],straw_resting_place[0]);
                        view.setText(String.valueOf(totalScore[0]));
                        break;
                    case 2:
                        straw_feed_tank[0] = 3;
                        totalScore[0] = getTotalStrawScore(straw_feed_tank[0],straw_normal[0],straw_resting_place[0]);
                        view.setText(String.valueOf(totalScore[0]));
                        break;
                    case 3:
                        straw_feed_tank[0] = 4;
                        totalScore[0] = getTotalStrawScore(straw_feed_tank[0],straw_normal[0],straw_resting_place[0]);
                        view.setText(String.valueOf(totalScore[0]));
                        break;
                }
            }
        });
        group2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View radioButton = group.findViewById(checkedId);
                int index = group.indexOfChild(radioButton);
                switch (index) {
                    case 0:
                        straw_normal[0] = 1;
                        totalScore[0] = getTotalStrawScore(straw_feed_tank[0],straw_normal[0],straw_resting_place[0]);
                        view.setText(String.valueOf(totalScore[0]));
                        break;
                    case 1:
                        straw_normal[0] = 2;
                        totalScore[0] = getTotalStrawScore(straw_feed_tank[0],straw_normal[0],straw_resting_place[0]);
                        view.setText(String.valueOf(totalScore[0]));
                        break;
                    case 2:
                        straw_normal[0] = 3;
                        totalScore[0] = getTotalStrawScore(straw_feed_tank[0],straw_normal[0],straw_resting_place[0]);
                        view.setText(String.valueOf(totalScore[0]));
                        break;
                    case 3:
                        straw_normal[0] = 4;
                        totalScore[0] = getTotalStrawScore(straw_feed_tank[0],straw_normal[0],straw_resting_place[0]);
                        view.setText(String.valueOf(totalScore[0]));
                        break;
                }
            }
        });
        group3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View radioButton = group.findViewById(checkedId);
                int index = group.indexOfChild(radioButton);
                switch (index) {
                    case 0:
                        straw_resting_place[0] = 1;
                        totalScore[0] = getTotalStrawScore(straw_feed_tank[0],straw_normal[0],straw_resting_place[0]);
                        view.setText(String.valueOf(totalScore[0]));
                        break;
                    case 1:
                        straw_resting_place[0] = 2;
                        totalScore[0] = getTotalStrawScore(straw_feed_tank[0],straw_normal[0],straw_resting_place[0]);
                        view.setText(String.valueOf(totalScore[0]));
                        break;
                    case 2:
                        straw_resting_place[0] = 3;
                        totalScore[0] = getTotalStrawScore(straw_feed_tank[0],straw_normal[0],straw_resting_place[0]);
                        view.setText(String.valueOf(totalScore[0]));
                        break;
                    case 3:
                        straw_resting_place[0] = 4;
                        totalScore[0] = getTotalStrawScore(straw_feed_tank[0],straw_normal[0],straw_resting_place[0]);
                        view.setText(String.valueOf(totalScore[0]));
                        break;
                }
            }
        });

    }

}