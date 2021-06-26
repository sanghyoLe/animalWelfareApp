package com.example.animal_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.animal_project.BreedBatch.BreedPoor;
import com.example.animal_project.BreedBatch.BreedWaterQ1;
import com.example.animal_project.BreedBatch.BreedWaterQ2;
import com.example.animal_project.BreedBatch.BreedWaterQ3;
import com.example.animal_project.R;

public class QuestionTemplate extends AppCompatActivity {
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private BreedPoor breed_poor;
    private BreedWaterQ1 breed_water_q1;
    private BreedWaterQ2 breed_water_q2;
    private BreedWaterQ3 breed_water_q3;
    private TextView breed_current_count_tv;
    private ImageButton prev_btn;
    public int total_cow;
    private Fragment[] breed_frag_arr = new Fragment[10];
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_template);

        fragmentManager = getSupportFragmentManager();

        prev_btn = findViewById(R.id.previous_btn);
        breed_current_count_tv = findViewById(R.id.breed_current_count_tv);

        breed_poor = new BreedPoor();
        breed_water_q1 = new BreedWaterQ1();
        breed_water_q2 = new BreedWaterQ2();
        breed_water_q3 = new BreedWaterQ3();

        Intent intent = getIntent();
        Bundle BeforeBundle = intent.getExtras();
        int inputCheck = BeforeBundle.getInt("inputChecked");
        total_cow = BeforeBundle.getInt("totalCow");

        breed_frag_arr = new Fragment[]{breed_poor, breed_water_q1,breed_water_q2,breed_water_q3};
        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_paper, breed_poor).commitAllowingStateLoss();

    }
    public void clickHandler(View view)
    {
        transaction = fragmentManager.beginTransaction();

        switch(view.getId())
        {
            case R.id.next_btn:
                if(count == 0){
                    prev_btn.setVisibility(View.VISIBLE);
                }
                transaction.replace(R.id.fragment_paper,breed_frag_arr[++count]).commitAllowingStateLoss();
                breed_current_count_tv.setText(String.valueOf(count+1));
                break;
            case R.id.previous_btn:
                transaction.replace(R.id.fragment_paper, breed_frag_arr[--count]).commitAllowingStateLoss();
                breed_current_count_tv.setText(String.valueOf(count+1));
                break;
        }
    }

    public int getTotalCow() { return total_cow; }
}