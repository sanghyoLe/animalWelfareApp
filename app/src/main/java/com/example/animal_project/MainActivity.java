package com.example.animal_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ScrollView;


public class MainActivity extends AppCompatActivity {
    public static Context mContext;
    private onKeyBackPressedListener OnKeyBackPressedListener;
    private Button evaStartBtn;
    private Button searchStartBtn;
    private Button searchBeefBtn;
    private Button searchMilkCowBtn;
    private ImageButton searchBackBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;


        evaStartBtn = (Button) findViewById(R.id.eva_start_btn);
        searchStartBtn = (Button) findViewById(R.id.search_start_btn);


        evaStartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InputUserInfo.class);
                startActivity(intent);

            }
        });

        searchStartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CustomDialog customDialog = new CustomDialog(MainActivity.this);
                customDialog.searchDialog();


            }
        });
//        searchBeefBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
//                intent.putExtra("searchCowKind","beef");
//                startActivity(intent);
//            }
//        });
//        searchMilkCowBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, SearchActivity.class);
//                intent.putExtra("searchCowKind","milkCow");
//                startActivity(intent);
//            }
//        });

    }


    // ?????? ????????? ??? ?????? ????????? ??????
    public static void scrollToView(View view, final ScrollView scrollView, int count) {
        if (view != null && view != scrollView) {
            count += view.getTop();
            scrollToView((View) view.getParent(), scrollView, count);
        } else if (scrollView != null) {
            final int finalCount = count;
            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    scrollView.smoothScrollTo(0, finalCount);
                }
            }, 200);
        }
    }


    public interface onKeyBackPressedListener{
        void onBackKey();
    }
    public void setOnKeyBackPressedListener(onKeyBackPressedListener listener){
        OnKeyBackPressedListener = listener;
        //Fragment ??? ???????????? callback ??????????????? ??????
        if (OnKeyBackPressedListener != null) {
            OnKeyBackPressedListener.onBackKey();
        }else{
            super.onBackPressed();
        }
    }
    // ????????? ????????????, ???????????? ?????? ????????? ??? ????????? ?????? ????????? ???????????? ??????
    public void addButtonScroll(EditText editText, Button button, ScrollView scrollView, View view){
        editText.addTextChangedListener(new TextWatcher(){
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                button.setVisibility(view.VISIBLE);
            }
            @Override
            public void afterTextChanged(Editable arg0) {
                // ????????? ????????? ??? ??????
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ???????????? ?????? ??????
            }
        });
/*
        // ?????? ???????????? ??? ?????? ?????????
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ((MainActivity)MainActivity.mContext).scrollToView(view,scrollView,0);
            }
        });
*/

        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                switch (actionId) {
                    case EditorInfo.IME_ACTION_NEXT:
                        ((MainActivity)MainActivity.mContext).scrollToView(view,scrollView,0);

                        break;
                    default:
                        ((MainActivity)MainActivity.mContext).scrollToView(view,scrollView,0);

                        return false;
                }
                return true;
            }
        });

    };
}



