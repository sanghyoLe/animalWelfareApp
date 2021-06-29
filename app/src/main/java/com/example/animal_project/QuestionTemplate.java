package com.example.animal_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.animal_project.BreedBatch.BreedPoor;
import com.example.animal_project.BreedBatch.BreedStraw;
import com.example.animal_project.BreedBatch.BreedWaterQ1;
import com.example.animal_project.BreedBatch.BreedWaterQ2;
import com.example.animal_project.BreedBatch.BreedWaterQ3;
import com.example.animal_project.Farm_Activity.Fatten_1;
import com.example.animal_project.Farm_Activity.Freestall_1;
import com.example.animal_project.Farm_Activity.MilkCow_1;


public class QuestionTemplate extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private BreedPoor breed_poor;
    private BreedWaterQ1 breed_water_q1;
    private BreedWaterQ2 breed_water_q2;
    private BreedWaterQ3 breed_water_q3;
    private BreedStraw breed_straw;
    private TextView current_page;
    private TextView total_page;
    private int inputCheck = 0;
    private ImageButton prev_btn;
    private ImageButton next_btn;
    public int total_cow;
    private Fragment[] breed_frag_arr = new Fragment[10];
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

        Intent intent = getIntent();
        Bundle BeforeBundle = intent.getExtras();
        inputCheck = BeforeBundle.getInt("inputChecked");

        total_cow = BeforeBundle.getInt("totalCow");

        breed_frag_arr = new Fragment[]{breed_poor, breed_water_q1,breed_water_q2,breed_water_q3,
                                        breed_straw};



        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_paper, breed_poor).commitAllowingStateLoss();

        // 마지막 페이지 개수 지정
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

        switch(view.getId())
        {
            // 다음 버튼 누를 시 이어질 페이지 지정
            case R.id.next_btn:
                if (inputCheck == 1) {

                }
                else if (inputCheck == 2 || inputCheck == 3) {
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
                    transaction.replace(R.id.fragment_paper, breed_frag_arr[--count]).commitAllowingStateLoss();
                }
                else if (inputCheck == 4) {
                }
                else if (inputCheck == 5) {

                }
                current_page.setText(String.valueOf(count+1));
                break;
        }
    }

    public int getTotalCow() { return total_cow; }
}