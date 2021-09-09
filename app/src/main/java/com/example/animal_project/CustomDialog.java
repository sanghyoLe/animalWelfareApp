package com.example.animal_project;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.animal_project.R;

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
    public void setInputMessage(String[] inputMessage) {
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
        okButton = (Button)dlg.findViewById(R.id.okButton);
        cancelButton = (Button) dlg.findViewById(R.id.cancelButton);
        farm_name_tv.setText(inputMessage[0]);
        zip_code_tv.setText(inputMessage[1]);
        address_tv.setText(inputMessage[2]);
        address_detail_tv.setText(inputMessage[3]);
        rep_name_tv.setText(inputMessage[4]);
        farm_type_tv.setText(inputMessage[5]);
        total_cow_tv.setText(inputMessage[6]);
        adult_cow_tv.setText(inputMessage[7]);
        child_cow_tv.setText(inputMessage[8]);
        sample_cow_tv.setText(inputMessage[9]);
        eva_name_tv.setText(inputMessage[10]);
        eva_date_tv.setText(inputMessage[11]);


    }

    public void dismiss() {
        dlg.dismiss();
    }
}
