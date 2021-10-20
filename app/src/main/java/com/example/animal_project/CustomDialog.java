package com.example.animal_project;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import uk.co.senab.photoview.PhotoViewAttacher;



public class CustomDialog {
    private static String IP_ADDRESS = "218.151.112.65";
    private String searchCowKind;
    private String searchWord;
    private Context context;
    protected Dialog dlg;
    private String searchFilterString;

    public CustomDialog(Context context) {
        this.context = context;

    }
    public void setImage(int drawResId){

        dlg = new Dialog(context);
        // 커스텀 다이얼로그를 정의하기위해 Dialog클래스를 생성한다.
        // 액티비티의 타이틀바를 숨긴다.
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 커스텀 다이얼로그의 레이아웃을 설정한다.
        dlg.setContentView(R.layout.m_custom_dialog);
        // 커스텀 다이얼로그를 노출한다.
        dlg.show();
        final ImageView dialogImageView = (ImageView) dlg.findViewById(R.id.dialog_imageview);
        dialogImageView.setVisibility(View.VISIBLE);
        final ImageView dialogCloseBtn = (ImageButton) dlg.findViewById(R.id.dialog_close_btn);
        dialogImageView.setImageResource(drawResId);
        Display display = ((WindowManager)context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();

        Point size = new Point();
        display.getSize(size);

        Window window = dlg.getWindow();


        int x = (int) (size.x * 0.9f);
        int y = (int)(size.y * 0.9f);


        window.setLayout(x,y);
        PhotoViewAttacher attacher;
        attacher = new PhotoViewAttacher(dialogImageView);

        dialogCloseBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            dlg.dismiss();
        }
    });
    }
    public void searchDialog(){
        dlg = new Dialog(context);
        // 커스텀 다이얼로그를 정의하기위해 Dialog클래스를 생성한다.
        // 액티비티의 타이틀바를 숨긴다.
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 커스텀 다이얼로그의 레이아웃을 설정한다.
        dlg.setContentView(R.layout.m_custom_dialog);
        // 커스텀 다이얼로그를 노출한다.
        dlg.show();
        final ImageView dialogCloseBtn = (ImageButton) dlg.findViewById(R.id.dialog_close_btn);
        View searchView = dlg.findViewById(R.id.search_layout);
        TextView normalMemberTv = searchView.findViewById(R.id.normal_member);
        TextView adminMemberTv = searchView.findViewById(R.id.admin_member);
        Spinner searchFilterSpinner = searchView.findViewById(R.id.search_filter_spinner);
        EditText searchEd = searchView.findViewById(R.id.search_ed);
        Button searchBtn = searchView.findViewById(R.id.search_btn);
        RadioGroup cowKindRg = searchView.findViewById(R.id.cow_kind_rg);
        LinearLayout normalMemberLayout = searchView.findViewById(R.id.normal_member_layout);
        LinearLayout adminMemberLayout = searchView.findViewById(R.id.admin_member_layout);
        searchView.setVisibility(View.VISIBLE);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context,
                R.array.search_filter_string_array,R.layout.spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        searchFilterSpinner.setAdapter(adapter);

        Display display = ((WindowManager)context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        Window window = dlg.getWindow();

        searchCowKind = null;


        normalMemberTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                normalMemberTv.setBackgroundResource(R.drawable.edge_bottom);
                normalMemberTv.setTypeface(Typeface.DEFAULT_BOLD);
                adminMemberTv.setBackground(null);
                adminMemberTv.setTypeface(Typeface.DEFAULT);
                adminMemberLayout.setVisibility(View.GONE);
                normalMemberLayout.setVisibility(View.VISIBLE);



            }
        });
        adminMemberTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adminMemberTv.setBackgroundResource(R.drawable.edge_bottom);
                adminMemberTv.setTypeface(Typeface.DEFAULT_BOLD);
                normalMemberTv.setBackground(null);
                normalMemberTv.setTypeface(Typeface.DEFAULT);
                normalMemberLayout.setVisibility(View.GONE);
                adminMemberLayout.setVisibility(View.VISIBLE);


            }
        });

        cowKindRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if( checkedId == R.id.cow_kind_beef){
                    searchCowKind = "beef";
                } else if(checkedId == R.id.cow_kind_milk_cow) {
                    searchCowKind = "milkCow";
                }
            }
        });
        searchFilterSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getSelectedItem().toString();
                searchFilterString = selectedItem;

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isNetworkConnected() == false){
                    Toast.makeText(context,"인터넷 연결을 확인하세요",Toast.LENGTH_SHORT).show();     
                }else {
                    if(TextUtils.isEmpty(searchEd.getText().toString())){
                        Toast.makeText(context, "검색어를 입력하세요", Toast.LENGTH_SHORT).show();
                    }else if(searchCowKind == null ){
                        Toast.makeText(context, "농장 종류를 선택하세요", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        searchWord = searchEd.getText().toString();
                        CheckData task = new CheckData();
                        task.execute("http://" + IP_ADDRESS + "/getjson.php",searchWord,searchFilterString,searchCowKind);

                    }
                }
            }
        });





        int x = (int) (size.x * 0.95f);
        int y = (int)(size.y * 0.65f);
        window.setLayout(x,y);

        dialogCloseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dlg.dismiss();
            }

        });
    }
    private class CheckData extends AsyncTask<String, Void, String> {

        ProgressDialog progressDialog;
        String errorString = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(context,
                    "Please Wait", null, true, true);
        }


        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            progressDialog.dismiss();

//            Log.d(TAG, "response - " + result);

            if (result.equals("searchNothing")){
                Toast.makeText(context, "검색결과가 없습니다", Toast.LENGTH_SHORT).show();
            }
            else {
                Intent intent = new Intent(context, SearchActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("searchWord",searchWord);
                bundle.putString("searchCowKind",searchCowKind);
                bundle.putString("searchFilterString",searchFilterString);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        }


        @Override
        protected String doInBackground(String... params) {

            String serverURL = params[0];
            String searchWord = params[1];
            String searchFilterString = params[2];
            String searchCowKind = params[3];
            String postParameters =
                    "searchWord=" + searchWord
                            +"&searchFilterString=" + searchFilterString
                            +"&searchCowKind=" + searchCowKind;


            try {

                URL url = new URL(serverURL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();


                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.connect();


                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(postParameters.getBytes("UTF-8"));
                outputStream.flush();
                outputStream.close();


                int responseStatusCode = httpURLConnection.getResponseCode();
                Log.d("CheckData", "response code - " + responseStatusCode);

                InputStream inputStream;
                if(responseStatusCode == HttpURLConnection.HTTP_OK) {
                    inputStream = httpURLConnection.getInputStream();
                }
                else{
                    inputStream = httpURLConnection.getErrorStream();
                }


                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                StringBuilder sb = new StringBuilder();
                String line;

                while((line = bufferedReader.readLine()) != null){
                    sb.append(line);
                }

                bufferedReader.close();

                return sb.toString().trim();


            } catch (Exception e) {

                Log.d("CheckData", "CheckData : Error ", e);
                errorString = e.toString();

                return null;
            }

        }
    }
    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }
}
