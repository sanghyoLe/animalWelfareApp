package com.example.animal_project;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.animal_project.R;

import java.util.List;

/**
 * Created by Administrator on 2017-08-07.
 */

public class CustomDialog {

    private Context context;
    protected Button okButton;
    protected Button cancelButton;
    protected Dialog dlg;
    public CustomDialog(Context context) {
        this.context = context;

    }



    // 호출할 다이얼로그 함수를 정의한다.
    public void setInputMessage(List<String> inputMessage) {
        dlg = new Dialog(context);
        // 커스텀 다이얼로그를 정의하기위해 Dialog클래스를 생성한다.
        // 액티비티의 타이틀바를 숨긴다.
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);

        // 커스텀 다이얼로그의 레이아웃을 설정한다.
        dlg.setContentView(R.layout.custom_dialog);

        // 커스텀 다이얼로그를 노출한다.
        dlg.show();

        // 커스텀 다이얼로그의 각 위젯들을 정의한다.
        final TextView farm_name_tv = (TextView) dlg.findViewById(R.id.farm_name_tv);
        final TextView zip_code_tv = (TextView) dlg.findViewById(R.id.zip_code_tv);
        final TextView address_tv = (TextView) dlg.findViewById(R.id.address_tv);
        final TextView address_detail_tv = (TextView) dlg.findViewById(R.id.address_detail_tv);
        final TextView rep_name_tv = (TextView) dlg.findViewById(R.id.rep_name_tv);
        final TextView farm_type_tv = (TextView) dlg.findViewById(R.id.farm_type_tv);
        final TextView total_cow_tv = (TextView) dlg.findViewById(R.id.total_cow_tv);
        final TextView adult_cow_tv = (TextView) dlg.findViewById(R.id.adult_cow_tv);
        final TextView child_cow_tv = (TextView) dlg.findViewById(R.id.child_cow_tv);
        final TextView sample_cow_tv = (TextView) dlg.findViewById(R.id.sample_cow_tv);
        final TextView eva_name_tv = (TextView) dlg.findViewById(R.id.eva_name_tv);
        final TextView eva_date_tv = (TextView) dlg.findViewById(R.id.eva_date_tv);
        final TextView milk_cow_tv = (TextView) dlg.findViewById(R.id.milk_cow_tv);
        final TextView dry_milk_cow_tv = (TextView) dlg.findViewById(R.id.dry_milk_cow_tv);
        final TextView pregnant_cow_tv = (TextView) dlg.findViewById(R.id.pregnant_cow_tv);
        final LinearLayout beef_dialog_layout = (LinearLayout) dlg.findViewById(R.id.beef_cow_dialog_layout);
        final LinearLayout milk_cow_dialog_layout = (LinearLayout) dlg.findViewById(R.id.milk_cow_dialog_layout);
        okButton = (Button)dlg.findViewById(R.id.okButton);
        cancelButton = (Button) dlg.findViewById(R.id.cancelButton);
        int inputMessageIndex = 0;
        farm_name_tv.setText(inputMessage.get(inputMessageIndex++));
        zip_code_tv.setText(inputMessage.get(inputMessageIndex++));
        address_tv.setText(inputMessage.get(inputMessageIndex++));
        address_detail_tv.setText(inputMessage.get(inputMessageIndex++));
        rep_name_tv.setText(inputMessage.get(inputMessageIndex++));
        farm_type_tv.setText(inputMessage.get(inputMessageIndex++));
        total_cow_tv.setText(inputMessage.get(inputMessageIndex++));
        child_cow_tv.setText(inputMessage.get(inputMessageIndex++));
        sample_cow_tv.setText(inputMessage.get(inputMessageIndex++));
        eva_name_tv.setText(inputMessage.get(inputMessageIndex++));
        eva_date_tv.setText(inputMessage.get(inputMessageIndex++));
        String stringFarmType = inputMessage.get(inputMessageIndex++);
        int farmType = Integer.parseInt(stringFarmType);
        if(farmType == 1 || farmType == 2 || farmType == 3){
            beef_dialog_layout.setVisibility(View.VISIBLE);
            milk_cow_dialog_layout.setVisibility(View.GONE);
            adult_cow_tv.setText(inputMessage.get(inputMessageIndex));

        } else if(farmType == 4 || farmType == 5) {
            milk_cow_dialog_layout.setVisibility(View.VISIBLE);
            beef_dialog_layout.setVisibility(View.GONE);
            milk_cow_tv.setText(inputMessage.get(inputMessageIndex++));
            dry_milk_cow_tv.setText(inputMessage.get(inputMessageIndex++));
            pregnant_cow_tv.setText(inputMessage.get(inputMessageIndex));
        }


    }

    public void dismiss() {
        dlg.dismiss();
    }
}
