package com.example.animal_project.BreedBatch;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.animal_project.Input_userinfo;
import com.example.animal_project.QuestionTemplate;
import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;
import com.example.animal_project.Result_View;


public class BreedStraw extends Fragment {


    private View view;
    private QuestionTemplateViewModel viewModel;
    private TextView straw_score_tv;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);
        view = inflater.inflate(R.layout.fragment_breed_straw, container, false);
        straw_score_tv = view.findViewById(R.id.breed_straw_score);

        QuestionTemplate activity = (QuestionTemplate) getActivity();
        int total_cow_count = activity.getTotalCow();

        ArrayAdapter spinnerAdapter = ArrayAdapter.createFromResource(getActivity().getApplicationContext(),
                R.array.dong_size,
                android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner mSpinner = view.findViewById(R.id.spinner_breed_straw);
        mSpinner.setAdapter(spinnerAdapter);
        final int[] selectedItemIndex = new int[1];
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // 선택된 데이터 값
                String selectedItem = parent.getSelectedItem().toString();

                // 선택된 데이터 위치( 0 부터 )
                selectedItemIndex[0] = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        Button breed_straw_btn = view.findViewById(R.id.breed_straw_btn);
        breed_straw_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dong_count = Integer.toString(selectedItemIndex[0]);
                if (Integer.parseInt(dong_count) == 0) {
                    String msg = "축사 동 수를 선택해주세요";
                    Toast.makeText(getActivity().getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                } else {

                    int dong_size = Integer.parseInt(dong_count);
                    Intent intent = new Intent(getActivity(), BreedStrawDong.class);
                    intent.putExtra("dong_count", dong_size); /*송신*/

                    startActivityForResult(intent, 0);


                }

            }
        });
        // Inflate the layout for this fragment
        straw_score_tv.setText(String.valueOf(viewModel.getStrawScore()));

        return view;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {



        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case 1:
                int minStrawScore = data.getExtras().getInt("minStrawScore");
                Log.d("after",String.valueOf(minStrawScore));
                straw_score_tv.setText(String.valueOf(minStrawScore));
                viewModel.setStrawScore(minStrawScore);
                // 프로토콜 1 점수

                break;
            default:
                break;
        }
    }
}