package com.example.animal_project.BreedBatch.ProtocolThree;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;


public class BreedCough extends Fragment {
    private View view;
    private int dong_size;
    private double cough;
    private TextView breed_cough_tv;
    private TextView breed_cough_ratio_tv;
    private QuestionTemplateViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_breed_cough, container, false);
        viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);



        breed_cough_tv = view.findViewById(R.id.breed_cough_tv);
        breed_cough_ratio_tv = view.findViewById(R.id.breed_cough_ratio_tv);
        if(viewModel.getCoughRatio() == -1){
            breed_cough_tv.setText("평가를 완료하세요");
        } else {
            breed_cough_tv.setText(String.valueOf(viewModel.getCough()));
            breed_cough_ratio_tv.setText(String.valueOf(viewModel.getCoughRatio()));
        }


                ArrayAdapter spinnerAdapter = ArrayAdapter.createFromResource(getActivity().getApplicationContext(),
                R.array.dong_size,
                android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner mSpinner = view.findViewById(R.id.spinner_breed_cough);


        mSpinner.setAdapter( spinnerAdapter );
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
        Button breed_btn_cough = view.findViewById(R.id.breed_cough_btn);


        breed_btn_cough.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String dong_count = Integer.toString(selectedItemIndex[0]);
                if(Integer.parseInt(dong_count) == 0){
                    String msg = "축사 동 수를 선택해주세요";
                    Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
                }else{
                    dong_size = Integer.parseInt(dong_count);
                    Intent intent = new Intent(getActivity(), BreedCoughDong.class);
                    intent.putExtra("dong_count",dong_size); /*송신*/
                    startActivityForResult(intent, 0);
                }
            }
        });

        return view;
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case 1:
                cough = data.getExtras().getDouble("key");
                cough = cough / dong_size;
                breed_cough_tv.setText(String.valueOf(cough));
                viewModel.setCough(cough);
                float coughRatio;
                coughRatio = ((float)cough / viewModel.getSampleCowSize()) * 100;
                coughRatio = Math.round(coughRatio);
                viewModel.setCoughRatio(coughRatio);
                breed_cough_ratio_tv.setText(String.valueOf(coughRatio));
                break;
            default:
                break;
        }
    }
}
