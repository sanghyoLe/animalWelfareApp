package com.example.animal_project.Beef.ProtocolFour;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.animal_project.MilkCow.MilkCowStruggleDong;
import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;


public class BreedStruggle extends Fragment {
    private View view;
    private int dong_size;
    private double struggle;
    private TextView breed_struggle_tv;
    private TextView breed_struggle_ratio_tv;
    private TextView milk_cow_struggle_tv;
    private TextView milk_cow_struggle_score_tv;
    private QuestionTemplateViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_breed_struggle, container, false);
        viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);


        LinearLayout beefStruggleScoreLayout = view.findViewById(R.id.beef_struggle_score_layout);
        LinearLayout milkCowStruggleScoreLayout = view.findViewById(R.id.milk_cow_struggle_score_layout);
        if(viewModel.isBeef(viewModel.getFarmType())){
            beefStruggleScoreLayout.setVisibility(View.VISIBLE);
            milkCowStruggleScoreLayout.setVisibility(View.GONE);
        } else {
            milkCowStruggleScoreLayout.setVisibility(View.VISIBLE);
            beefStruggleScoreLayout.setVisibility(View.GONE);
        }
        breed_struggle_tv = view.findViewById(R.id.breed_struggle_tv);
        milk_cow_struggle_tv = view.findViewById(R.id.milk_cow_struggle_tv);
        milk_cow_struggle_score_tv = view.findViewById(R.id.milk_cow_struggle_score);


        if(((QuestionTemplateViewModel.BehaviorQuestion)viewModel.StruggleQuestion).getBehaviorPerOneAvg() == -1){
            breed_struggle_tv.setText("평가를 완료하세요");
        } else {
            breed_struggle_tv.setText(String.valueOf(((QuestionTemplateViewModel.BehaviorQuestion)viewModel.StruggleQuestion).getBehaviorPerOneAvg()));
        }


        ArrayAdapter spinnerAdapter = ArrayAdapter.createFromResource(getActivity().getApplicationContext(),
                R.array.dong_size_12,
                android.R.layout.simple_dropdown_item_1line);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner mSpinner = view.findViewById(R.id.spinner_breed_struggle);


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
        Button breed_btn_struggle = view.findViewById(R.id.breed_struggle_btn);


        breed_btn_struggle.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String dong_count = Integer.toString(selectedItemIndex[0]);
                if(Integer.parseInt(dong_count) == 0){
                    String msg = "축사 동 수를 선택해주세요";
                    Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
                }else{
                    dong_size = Integer.parseInt(dong_count);
                    if(viewModel.isBeef(viewModel.getFarmType())) {
                        Intent intent = new Intent(getActivity(), BreedStruggleDong.class);
                        intent.putExtra("dong_count", dong_size); /*송신*/
                        startActivityForResult(intent, 0);
                    } else {
                        Intent intent = new Intent(getActivity(), MilkCowStruggleDong.class);
                        intent.putExtra("dong_count",dong_size);
                        startActivityForResult(intent, 0);
                    }

                }
            }
        });

        return view;
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case 1:
                // 한육우
                QuestionTemplateViewModel.BehaviorQuestion struggleQuestion = (QuestionTemplateViewModel.BehaviorQuestion)
                    data.getExtras().getSerializable("struggleQuestion");
                viewModel.setStruggleQuestion(struggleQuestion);
                breed_struggle_tv.setText(String.valueOf(
                        ((QuestionTemplateViewModel.BehaviorQuestion)viewModel.StruggleQuestion).getBehaviorPerOneAvg()
                ));
                break;
            case 2:
                QuestionTemplateViewModel.MilkCowStruggleQuestion milkCowStruggleQuestion = (QuestionTemplateViewModel.MilkCowStruggleQuestion)
                        data.getExtras().getSerializable("milkCowStruggleQuestion");
                viewModel.setMilkCowStruggle(milkCowStruggleQuestion);
                milk_cow_struggle_tv.setText(String.valueOf(milkCowStruggleQuestion.getStruggleIndexAvg()));
                milkCowStruggleQuestion.setRepScore(milkCowStruggleQuestion.calculatorScore(milkCowStruggleQuestion.getStruggleIndexAvg()));
                milk_cow_struggle_score_tv.setText(String.valueOf(milkCowStruggleQuestion.getRepScore()));
            default:
                break;
        }
    }
}
