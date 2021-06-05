package com.example.animal_project;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.animal_project.Result.Result_1;
import com.example.animal_project.Result.Result_2;
import com.example.animal_project.Result.Result_3;
import com.example.animal_project.Result.Result_4;
import com.example.animal_project.Result.Result_5;
import com.google.android.material.tabs.TabLayout;

public class Result_View extends AppCompatActivity {
    private double protocolFourScore;
    private double[] protocolScores;

    Result_1 result1;
    Result_2 result2;
    Result_3 result3;
    Result_4 result4;
    Result_5 result5;
    TabLayout tabs;
    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        result1 = new Result_1();
        result2 = new Result_2();
        result3 = new Result_3();
        result4 = new Result_4();
        result5 = new Result_5();

        getSupportFragmentManager().beginTransaction().add(R.id.container, result1).commit();
        tabs = findViewById(R.id.tab_layout);
        tabs.addTab(tabs.newTab().setText("종합"));
        tabs.addTab(tabs.newTab().setText("사료"));
        tabs.addTab(tabs.newTab().setText("환경"));
        tabs.addTab(tabs.newTab().setText("건강"));
        tabs.addTab(tabs.newTab().setText("행동"));


        Intent intent = getIntent();
        bundle = intent.getExtras();




        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Fragment selected = null;
                if(position == 0)
                    selected = result1;
                else if(position == 1)
                    selected = result2;
                else if(position == 2)
                    selected = result3;
                else if(position == 3)
                    selected = result4;
                else if(position == 4)
                    selected = result5;
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



    public Bundle getProtocolScoreBundle( ) {
        return bundle;
    }
}