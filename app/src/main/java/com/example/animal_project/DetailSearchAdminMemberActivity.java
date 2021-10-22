package com.example.animal_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DetailSearchAdminMemberActivity extends AppCompatActivity {
    private String evaInfoId;
    private String searchCowKind;
    private View basicInformationView;
    private ImageButton basicInformationBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_search_admin_member);
        basicInformationView = findViewById(R.id.basic_information_table);
        basicInformationBtn = findViewById(R.id.basic_information_btn);
        
        Intent beforeIntent = getIntent();
        evaInfoId = beforeIntent.getStringExtra("evaInfoId");
        searchCowKind = beforeIntent.getStringExtra("searchCowKind");
        
        final TextView farm_name_tv = (TextView) basicInformationView.findViewById(R.id.farm_name_tv);
        final TextView zip_code_tv = (TextView) basicInformationView.findViewById(R.id.zip_code_tv);
        final TextView address_tv = (TextView) basicInformationView.findViewById(R.id.address_tv);
        final TextView address_detail_tv = (TextView) basicInformationView.findViewById(R.id.address_detail_tv);
        final TextView rep_name_tv = (TextView) basicInformationView.findViewById(R.id.rep_name_tv);
        final TextView farm_type_tv = (TextView) basicInformationView.findViewById(R.id.farm_type_tv);
        final TextView total_cow_tv = (TextView) basicInformationView.findViewById(R.id.total_cow_tv);
        final TextView adult_cow_tv = (TextView) basicInformationView.findViewById(R.id.adult_cow_tv);
        final TextView child_cow_tv = (TextView) basicInformationView.findViewById(R.id.child_cow_tv);
        final TextView sample_cow_tv = (TextView) basicInformationView.findViewById(R.id.sample_cow_tv);
        final TextView eva_name_tv = (TextView) basicInformationView.findViewById(R.id.eva_name_tv);
        final TextView eva_date_tv = (TextView) basicInformationView.findViewById(R.id.eva_date_tv);
        final TextView milk_cow_tv = (TextView) basicInformationView.findViewById(R.id.milk_cow_tv);
        final TextView dry_milk_cow_tv = (TextView) basicInformationView.findViewById(R.id.dry_milk_cow_tv);
        final TextView pregnant_cow_tv = (TextView) basicInformationView.findViewById(R.id.pregnant_cow_tv);
        final LinearLayout beef_dialog_layout = (LinearLayout) basicInformationView.findViewById(R.id.beef_cow_dialog_layout);
        final LinearLayout milk_cow_dialog_layout = (LinearLayout) basicInformationView.findViewById(R.id.milk_cow_dialog_layout);

        if(searchCowKind.equals("beef")){
            beef_dialog_layout.setVisibility(View.VISIBLE);
            milk_cow_dialog_layout.setVisibility(View.GONE);
//            adult_cow_tv.setText(inputMessage.get(inputMessageIndex));

        } else if(searchCowKind.equals("milkCow")) {
            milk_cow_dialog_layout.setVisibility(View.VISIBLE);
            beef_dialog_layout.setVisibility(View.GONE);
//            milk_cow_tv.setText(inputMessage.get(inputMessageIndex++));
//            dry_milk_cow_tv.setText(inputMessage.get(inputMessageIndex++));
//            pregnant_cow_tv.setText(inputMessage.get(inputMessageIndex));
        }
        Animation slide_down = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_down);

        Animation slide_up = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_up);
        slide_down.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                basicInformationView.setVisibility(View.VISIBLE);
            }
            @Override
            public void onAnimationEnd(Animation animation) {

                basicInformationBtn.setImageResource(R.drawable.outline_arrow_drop_up_24);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        slide_up.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                basicInformationView.setVisibility(View.GONE);
                basicInformationBtn.setImageResource(R.drawable.outline_arrow_drop_down_24);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        basicInformationBtn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                if(basicInformationView.getVisibility() == View.GONE){
                    basicInformationView.startAnimation(slide_down);

                } else {
                    basicInformationView.startAnimation(slide_up);

                }

            }
        });
    }
}
