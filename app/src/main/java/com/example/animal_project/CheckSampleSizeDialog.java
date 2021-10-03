package com.example.animal_project;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.lifecycle.ViewModelProvider;

import java.util.List;

public class CheckSampleSizeDialog {
    private QuestionTemplateViewModel viewModel;
    private Context context;
    protected Button okButton;
    protected Button cancelButton;
    protected Dialog dlg;
    public CheckSampleSizeDialog(Context context) {
        this.context = context;

    }



    // 호출할 다이얼로그 함수를 정의한다.
    public void viewSampleSize(List<String> inputMessage) {
        dlg = new Dialog(context);
        // 커스텀 다이얼로그를 정의하기위해 Dialog클래스를 생성한다.
        // 액티비티의 타이틀바를 숨긴다.
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);

        // 커스텀 다이얼로그의 레이아웃을 설정한다.
        dlg.setContentView(R.layout.check_sample_size_dialog);

        // 커스텀 다이얼로그를 노출한다.
        dlg.show();

        final TextView farm_type_tv = (TextView) dlg.findViewById(R.id.farm_type_tv);
        final TextView total_cow_tv = (TextView) dlg.findViewById(R.id.total_cow_tv);
        final TextView adult_cow_tv = (TextView) dlg.findViewById(R.id.adult_cow_tv);
        final TextView child_cow_tv = (TextView) dlg.findViewById(R.id.child_cow_tv);
        final TextView sample_cow_tv = (TextView) dlg.findViewById(R.id.sample_cow_tv);
        final TextView milk_cow_tv = (TextView) dlg.findViewById(R.id.milk_cow_tv);
        final TextView dry_milk_cow_tv = (TextView) dlg.findViewById(R.id.dry_milk_cow_tv);
        final TextView pregnant_cow_tv = (TextView) dlg.findViewById(R.id.pregnant_cow_tv);
        final ImageButton dialogCloseBtn = (ImageButton) dlg.findViewById(R.id.check_sample_size_close_btn);
        final LinearLayout beef_dialog_layout = (LinearLayout) dlg.findViewById(R.id.beef_cow_dialog_layout);
        final LinearLayout milk_cow_dialog_layout = (LinearLayout) dlg.findViewById(R.id.milk_cow_dialog_layout);

        int inputMessageIndex = 0;
        farm_type_tv.setText(inputMessage.get(inputMessageIndex++));
        total_cow_tv.setText(inputMessage.get(inputMessageIndex++));
        child_cow_tv.setText(inputMessage.get(inputMessageIndex++));
        sample_cow_tv.setText(inputMessage.get(inputMessageIndex++));
        int farmType = Integer.parseInt(inputMessage.get(inputMessageIndex++));
        if(farmType == 1 || farmType == 2 || farmType == 3){
            milk_cow_dialog_layout.setVisibility(View.GONE);
            beef_dialog_layout.setVisibility(View.VISIBLE);
            adult_cow_tv.setText(String.valueOf(inputMessage.get(inputMessageIndex++)));

        } else {
            milk_cow_dialog_layout.setVisibility(View.VISIBLE);
            beef_dialog_layout.setVisibility(View.GONE);
            milk_cow_tv.setText(String.valueOf(inputMessage.get(inputMessageIndex++)));
            dry_milk_cow_tv.setText(String.valueOf(inputMessage.get(inputMessageIndex++)));
            pregnant_cow_tv.setText(String.valueOf(inputMessage.get(inputMessageIndex++)));

        }
        Display display = ((WindowManager)context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();

        Point size = new Point();
        display.getSize(size);

        Window window = dlg.getWindow();

        int x = (int) (size.x * 0.9f);
        int y = (int)(size.y * 0.9f);

        window.setLayout(x,y);
        dialogCloseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dlg.dismiss();
            }
        });
    }


}
