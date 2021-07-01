package com.example.animal_project.BreedBatch;



import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
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

public class BreedWaterQ3 extends Fragment {
    private View view;
    private QuestionTemplateViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);

        view = inflater.inflate(R.layout.fragment_breed_water_q3, container, false);

        TextView breed_drink_water_score = view.findViewById(R.id.breed_drink_water_score);
        TextView breed_total_water_score = view.findViewById(R.id.breed_total_water_score);

        breed_drink_water_score.setText(String.valueOf(viewModel.getWaterDrink()));
        breed_total_water_score.setText(String.valueOf(viewModel.getWaterScore()));

        ArrayAdapter spinnerAdapter = ArrayAdapter.createFromResource(getActivity().getApplicationContext(),
                R.array.dong_size,
                android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner mSpinner = view.findViewById(R.id.spinner_breed_water_q3);
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
        Button breed_water_q3_btn = view.findViewById(R.id.breed_water_q3_btn);


        breed_water_q3_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String dong_count = Integer.toString(selectedItemIndex[0]);
                if(Integer.parseInt(dong_count) == 0){
                    String msg = "축사 동 수를 선택해주세요";
                    Toast.makeText(getActivity().getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                }else{

                    int dong_size = Integer.parseInt(dong_count);
                    Intent intent = new Intent(getActivity(), BreedWaterDongQ3.class);
                    intent.putExtra("dong_count",dong_size); /*송신*/

                   startActivityForResult(intent, 0);


                }

            }
        });


        return view;
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        TextView breed_drink_water_score = view.findViewById(R.id.breed_drink_water_score);
        TextView breed_total_water_score = view.findViewById(R.id.breed_total_water_score);
        int waterTankNum = viewModel.getWaterTankNum();
        int waterTankClean = viewModel.getWaterTankClean();
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case 1:
                int key = data.getExtras().getInt("key");
                breed_drink_water_score.setText(String.valueOf(key));
                viewModel.setWaterDrink(key);
                // 프로토콜 1 점수
                int waterScore = getWaterScore(waterTankNum,waterTankClean,key);
                breed_total_water_score.setText(String.valueOf(waterScore));
                viewModel.setWaterScore(waterScore);
                Log.d("protocolOneScore",String.valueOf(setProtocolOneResult(viewModel.getPoorScore(),viewModel.getWaterScore())));

                /*protocolOneScore = setProtocolOneResult(breed_poor_rate_score,getWaterScore(water_Tank_Num,water_Tank_Clean,key));
                Log.d("1",String.valueOf(protocolOneScore));*/
                break;
            default:
                break;
        }
    }

    public int getWaterScore(int waterTankNum, int waterTankClean, int waterTankTime)
    {
        int waterScore = 0;
        // 음수조 수 기준 합격
        if (waterTankNum == 1) {
            // 음수조 위생 청결 or 보통
            if (waterTankClean <= 2) {
                // 음수 행동 매우 양호 or 보통
                if (waterTankTime < 2) {
                    waterScore = 100;
                } else {
                    waterScore = 80;
                }
            }
            // 음수조 위생 더러움
            else {
                if (waterTankTime < 2) {
                    waterScore = 60;
                } else {
                    waterScore = 45;
                }
            }
        }
        // 음수조 수 기준 초과
        else {
            // 음수조 위생 청결 or 보통
            if (waterTankClean <= 2) {
                if (waterTankTime < 2) {
                    waterScore = 55;
                } else {
                    waterScore = 40;
                }
            }
            // 음수조 위생 더러움
            else {
                if (waterTankTime < 2) {
                    waterScore = 35;
                } else {
                    waterScore = 20;
                }
            }
        }
        return waterScore;
    }
    private double setProtocolOneResult(int PoorScore, int WaterScore){
        return (PoorScore * 0.7) + (WaterScore * 0.3);
    }

}