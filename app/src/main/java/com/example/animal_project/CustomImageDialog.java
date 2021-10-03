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

public class CustomImageDialog {

    private Context context;
    protected Dialog dlg;
    public CustomImageDialog(Context context) {
        this.context = context;

    }
    public void setImage(int drawResId){
        dlg = new Dialog(context);
        // 커스텀 다이얼로그를 정의하기위해 Dialog클래스를 생성한다.
        // 액티비티의 타이틀바를 숨긴다.
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 커스텀 다이얼로그의 레이아웃을 설정한다.
        dlg.setContentView(R.layout.custom_imageview_dialog);
        // 커스텀 다이얼로그를 노출한다.
        dlg.show();
        final ImageView dialogImageView = (ImageView) dlg.findViewById(R.id.dialog_imageview);
        final ImageView dialogCloseBtn = (ImageButton) dlg.findViewById(R.id.dialog_close_btn);
        dialogImageView.setImageResource(drawResId);

        Display display = ((WindowManager)context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();

        Point size = new Point();
        display.getSize(size);

        Window window = dlg.getWindow();

        int x = (int) (size.x * 0.9f);
        int y = (int)(size.y * 0.9f);

        window.setLayout(x,y);

        dialogCloseBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            dlg.dismiss();
        }
    });
    }


}
