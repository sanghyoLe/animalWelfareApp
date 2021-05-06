package com.example.animal_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.animal_project.Farm_Activity.Breed_batch_1;
import com.example.animal_project.Farm_Activity.Fatten_1;
import com.example.animal_project.Farm_Activity.Freestall_1;
import com.example.animal_project.Farm_Activity.MilkCow_1;

public class Category extends AppCompatActivity {

    Button btn_move;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        Intent intent = getIntent();
        int input_checked = intent.getExtras().getInt("input_checked");

        if (input_checked == 1) {
            Intent intent_Fatten = new Intent(Category.this, Fatten_1.class);
            startActivity(intent_Fatten);
        }
        else if (input_checked == 2 || input_checked == 3) {
            Intent intent_Breed_Batch = new Intent(Category.this, Breed_batch_1.class);
            startActivity(intent_Breed_Batch);
        }
        else if (input_checked == 4) {
            Intent intent_Freestall = new Intent(Category.this, Freestall_1.class);
            startActivity(intent_Freestall);
        }
        else if (input_checked == 5) {
            Intent intent_MilkCow = new Intent(Category.this, MilkCow_1.class);
            startActivity(intent_MilkCow);
        }

        btn_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}