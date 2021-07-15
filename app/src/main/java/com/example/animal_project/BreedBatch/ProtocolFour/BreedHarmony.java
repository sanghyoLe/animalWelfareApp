package com.example.animal_project.BreedBatch.ProtocolFour;

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


public class BreedHarmony extends Fragment {
    private View view;
    private int dong_size;
    private double harmony;
    private TextView breed_harmony_tv;
    private TextView breed_social_behavior_tv;
    private QuestionTemplateViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_breed_harmony, container, false);
        viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);


        breed_social_behavior_tv = view.findViewById(R.id.breed_social_behavior_score_tv);
        breed_harmony_tv = view.findViewById(R.id.breed_harmony_tv);

        // 화합 평가 항목 점수 설정
        if(viewModel.getHarmony() == -1){
            breed_harmony_tv.setText("평가를 완료하세요");
        } else {
            breed_harmony_tv.setText(String.valueOf(viewModel.getHarmony()));
        }
        // 사회적 평가 항목 점수 설정
        if(viewModel.getStruggle() == -1){
            breed_social_behavior_tv.setText("투쟁(서열) 행동 평가를 완료하세요");
        }else if(viewModel.getHarmony() == -1){
            breed_social_behavior_tv.setText("화합 행동 평가를 완료하세요");
        }else {
            viewModel.setSocialBehaviorScore(
                    viewModel.calculatorSocialBehaviorScore(
                            viewModel.getStruggle(),
                            viewModel.getHarmony()
                    )
            );
            breed_social_behavior_tv.setText(String.valueOf(viewModel.getSocialBehaviorScore()));

        }


        ArrayAdapter spinnerAdapter = ArrayAdapter.createFromResource(getActivity().getApplicationContext(),
                R.array.dong_size_12,
                android.R.layout.simple_dropdown_item_1line);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner mSpinner = view.findViewById(R.id.spinner_breed_harmony);


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
        Button breed_btn_harmony = view.findViewById(R.id.breed_harmony_btn);


        breed_btn_harmony.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String dong_count = Integer.toString(selectedItemIndex[0]);
                if(Integer.parseInt(dong_count) == 0){
                    String msg = "축사 동 수를 선택해주세요";
                    Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
                }else{
                    dong_size = Integer.parseInt(dong_count);
                    Intent intent = new Intent(getActivity(), BreedHarmonyDong.class);
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
                harmony = data.getExtras().getDouble("sum");
                breed_harmony_tv.setText(String.valueOf(harmony));
                viewModel.setHarmony(harmony);
                if(viewModel.getStruggle() == -1){
                    breed_social_behavior_tv.setText("투쟁(서열) 행동 평가를 완료하세요");
                }else if(viewModel.getHarmony() == -1){
                    breed_social_behavior_tv.setText("화합 행동 평가를 완료하세요");
                }else {
                    viewModel.setSocialBehaviorScore(
                            viewModel.calculatorSocialBehaviorScore(
                                    viewModel.getStruggle(),
                                    viewModel.getHarmony()
                            )
                    );
                    breed_social_behavior_tv.setText(String.valueOf(viewModel.getSocialBehaviorScore()));

                }
                break;
            default:
                break;
        }
    }

}
