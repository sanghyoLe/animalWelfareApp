package com.example.animal_project;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Build;
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
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.example.animal_project.R;
import com.example.animal_project.SearchActivity;
import com.google.android.material.datepicker.MaterialDatePicker;

import java.io.BufferedReader;
import java.io.DataInput;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import uk.co.senab.photoview.PhotoViewAttacher;



public class CustomDialog {
    private static String IP_ADDRESS = "218.151.112.65";
    private String searchCowKind;
    private String searchWord;
    private Context context;
    protected Dialog dlg;
    private String searchFilterString;
    private Boolean isAdminMember;
    private DatePickerDialog afterDatePicker;
    private DatePickerDialog beforeDatePicker;
    private Calendar beforeCalendar;
    private Calendar afterCalendar;
    private long beforeTime;
    private long afterTime;

    private String searchBeforeDate;
    private String searchAfterDate;


    public CustomDialog(Context context) {
        this.context = context;

    }
    public void setImage(int drawResId){

        dlg = new Dialog(context);
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dlg.setContentView(R.layout.m_custom_dialog);
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
    public boolean agreePrivacyDialog(){
        boolean agree = false;
        dlg = new Dialog(context);
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dlg.setContentView(R.layout.agree_privacy_dialog_layout);
        dlg.show();



        return agree;


    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void searchDialog(){
        dlg = new Dialog(context);
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dlg.setContentView(R.layout.m_custom_dialog);
        dlg.show();
        final ImageView dialogCloseBtn = (ImageButton) dlg.findViewById(R.id.dialog_close_btn);
        View searchView = dlg.findViewById(R.id.search_layout);
        TextView normalMemberTv = searchView.findViewById(R.id.normal_member);
        TextView adminMemberTv = searchView.findViewById(R.id.admin_member);
        Spinner searchFilterSpinner = searchView.findViewById(R.id.search_filter_spinner);
        EditText searchEd = searchView.findViewById(R.id.search_ed);
        LinearLayout datePickerLayout = searchView.findViewById(R.id.date_picker_layout);
        TextView beforeDateTv = searchView.findViewById(R.id.before_date_picker_tv);
        TextView afterDateTv = searchView.findViewById(R.id.after_date_picker);
        Button searchBtn = searchView.findViewById(R.id.search_btn);
        RadioGroup cowKindRg = searchView.findViewById(R.id.cow_kind_rg);
        LinearLayout normalMemberLayout = searchView.findViewById(R.id.normal_member_layout);
        LinearLayout adminMemberLayout = searchView.findViewById(R.id.admin_member_layout);
        EditText adminMemberIdEd = searchView.findViewById(R.id.admin_member_id);
        EditText adminMemberPasswordEd = searchView.findViewById(R.id.admin_member_password);
        Button adminMemberLoginBtn = searchView.findViewById(R.id.admin_member_login_btn);
        isAdminMember = false;
        String currentDateTimeString = DateFormat.getDateInstance().format(new Date());
        Date dt = new Date();

        SimpleDateFormat currentDateTime = new SimpleDateFormat("yyyy-MM-dd");

        afterDateTv.setText(currentDateTime.format(dt).toString());






        searchView.setVisibility(View.VISIBLE);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context,
                R.array.search_filter_normal_member,R.layout.spinner_item);
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
                isAdminMember = false;
                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context,
                        R.array.search_filter_normal_member,R.layout.spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                searchFilterSpinner.setAdapter(adapter);

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
                isAdminMember = true;


            }
        });
        adminMemberLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(adminMemberIdEd.getText().toString().equals("1") && adminMemberPasswordEd.getText().toString().equals("1")){
                    adminMemberLayout.setVisibility(View.GONE);
                    normalMemberLayout.setVisibility(View.VISIBLE);
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context,
                            R.array.search_filter_admin_member,R.layout.spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    searchFilterSpinner.setAdapter(adapter);
                } else {
                    Toast.makeText(context, "아이디 또는 비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                }
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

                if(searchFilterString.equals("전체")){
                    searchEd.setVisibility(View.GONE);
                    datePickerLayout.setVisibility(View.GONE);
                }else if(searchFilterString.equals("평가일")){
                    searchEd.setVisibility(View.GONE);
                    datePickerLayout.setVisibility(View.VISIBLE);
                }else {
                    searchEd.setVisibility(View.VISIBLE);
                    datePickerLayout.setVisibility(View.GONE);
                }
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
                    if(searchCowKind == null ){
                        Toast.makeText(context, "농장 종류를 선택하세요", Toast.LENGTH_SHORT).show();
                    } else {
                        // 전체일 경우
                        if (searchFilterString.equals("전체")) {
                            CheckData task = new CheckData();
                            task.execute("http://" + IP_ADDRESS + "/getSearchResultJson.php", searchWord, searchFilterString, searchCowKind);
                        } else if(searchFilterString.equals("평가일")){
                            searchBeforeDate = beforeDateTv.getText().toString();
                            searchAfterDate = afterDateTv.getText().toString();
                            CheckData task = new CheckData();
                            task.execute("http://" +IP_ADDRESS + "/getSearchResultJson.php",searchWord,searchFilterString,searchCowKind,searchBeforeDate,searchAfterDate);
                        }
                        else {
                            if (TextUtils.isEmpty(searchEd.getText().toString())) {
                                Toast.makeText(context, "검색어를 입력하세요", Toast.LENGTH_SHORT).show();
                            } else {
                                    searchWord = searchEd.getText().toString();
                                    CheckData task = new CheckData();
                                    task.execute("http://" + IP_ADDRESS + "/getSearchResultJson.php", searchWord, searchFilterString, searchCowKind);
                            }
                        }
                    }
                }
            }
        });


        long currentTime = new Date().getTime();

        afterDatePicker = new DatePickerDialog(context);
        beforeDatePicker = new DatePickerDialog(context);
        afterDatePicker.getDatePicker().setMaxDate(currentTime);
        beforeDatePicker.getDatePicker().setMaxDate(currentTime);




        beforeDatePicker.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {


                beforeDateTv.setText(year + "-" + (month+1) + "-" + dayOfMonth);
                if(beforeCalendar != null){
                    beforeCalendar.set(year, month, dayOfMonth);
                    afterDatePicker.getDatePicker().setMinDate(beforeCalendar.getTimeInMillis());
                    afterDatePicker.show();
                }

            }

        });
        afterDatePicker.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                afterDateTv.setText(year + "-" + (month+1) + "-" + dayOfMonth);
            }
        });



        beforeDateTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                beforeCalendar = Calendar.getInstance();
                afterDatePicker.getDatePicker().setMinDate(new Date().getTime()-2000000000);
                if (beforeDateTv.isClickable()) {
                    beforeDatePicker.show();
                }
            }
        });
        afterDateTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (beforeDateTv.isClickable()) {
                    beforeDatePicker.show();
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
                if(searchFilterString.equals("평가일")){
                    bundle.putString("searchBeforeDate",searchBeforeDate);
                    bundle.putString("searchAfterDate",searchAfterDate);
                }
                bundle.putBoolean("isAdminMember",isAdminMember);
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
            if(searchFilterString.equals("평가일")){
                String searchBeforeDate = params[4];
                String searchAfterDate = params[5];

            }

            String postParameters =
                    "searchWord=" + searchWord
                            +"&searchFilterString=" + searchFilterString
                            +"&searchCowKind=" + searchCowKind
                            +"&searchBeforeDate=" + searchBeforeDate
                            +"&searchAfterDate=" + searchAfterDate;


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
    // 기간을 선택하기 위한 datePicker

}
