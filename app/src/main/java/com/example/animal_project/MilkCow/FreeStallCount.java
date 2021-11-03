package com.example.animal_project.MilkCow;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;

public class FreeStallCount extends Fragment {

    private View view;
    private int dong_size;
    private double freeStallNum;
    TextView freeStallCountScoreTv;
    TextView freeStallCountRatioTv;
    private QuestionTemplateViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_freestall_count, container, false);
        viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);

        if((((QuestionTemplateViewModel.FreeStallCountQuestion)viewModel.FreeStallCountQuestion).getLowestRatio()) != -1){
                freeStallCountRatioTv.setText(String.valueOf(
                        ((QuestionTemplateViewModel.FreeStallCountQuestion)viewModel.FreeStallCountQuestion).getLowestRatio()
                ));
        }
        if((((QuestionTemplateViewModel.FreeStallCountQuestion)viewModel.FreeStallCountQuestion).getLowestScore()) != -1){
            freeStallCountScoreTv.setText(String.valueOf(
                    ((QuestionTemplateViewModel.FreeStallCountQuestion)viewModel.FreeStallCountQuestion).getLowestScore()
            ));
        }


        freeStallCountScoreTv = view.findViewById(R.id.free_stall_count_score);
        freeStallCountRatioTv = view.findViewById(R.id.free_stall_count_ratio);

        ArrayAdapter spinnerAdapter = ArrayAdapter.createFromResource(getActivity().getApplicationContext(),
                R.array.dong_size,
                android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner mSpinner = view.findViewById(R.id.spinner_freestall_count);


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
        Button freeStallCountDongBtn = view.findViewById(R.id.freestall_count_btn);


        freeStallCountDongBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String dong_count = Integer.toString(selectedItemIndex[0]);
                if(Integer.parseInt(dong_count) == 0){
                    String msg = "축사 동 수를 선택해주세요";
                    Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
                }else{
                    dong_size = Integer.parseInt(dong_count);
                    Intent intent = new Intent(getActivity(), FreeStallCountDong.class);
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
                QuestionTemplateViewModel.FreeStallCountQuestion freeStallCountQuestion = (QuestionTemplateViewModel.FreeStallCountQuestion)data.getExtras().getSerializable("freeStallCountQuestion");
                viewModel.setFreeStallCountQuestion(freeStallCountQuestion);
                freeStallCountScoreTv.setText(String.valueOf(freeStallCountQuestion.getLowestScore()));
                freeStallCountRatioTv.setText(String.valueOf(freeStallCountQuestion.getLowestRatio()));

                
                break;
            default:
                break;
        }
    }
}