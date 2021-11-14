package com.example.animal_project.Beef.ProtocolOne;



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

public class WaterTime extends Fragment {
    private View view;
    private QuestionTemplateViewModel viewModel;
    private TextView protocolOneTv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);

        view = inflater.inflate(R.layout.fragment_breed_water_q3, container, false);
        protocolOneTv = view.findViewById(R.id.breed_protocol_score_1);
        TextView breed_drink_water_score = view.findViewById(R.id.breed_drink_water_score);
        TextView breed_total_water_score = view.findViewById(R.id.breed_total_water_score);

        if(viewModel.getWaterTimeQuestion().getMaxWaterTimeScore() != -1){
            breed_drink_water_score.setText(String.valueOf(
                    viewModel.getWaterTimeQuestion().getMaxWaterTimeScore()
            ));
        }
        if(viewModel.getWaterScore() != -1){
            breed_total_water_score.setText(String.valueOf(
                    viewModel.getWaterScore()
                    ));
        }
        if(viewModel.getProtocolOneScore() != -1){
            protocolOneTv.setText(String.valueOf(
                    viewModel.getProtocolOneScore()
            ));
        }


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
                    Intent intent = new Intent(getActivity(), WaterTimeDong.class);
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
        protocolOneTv = view.findViewById(R.id.breed_protocol_score_1);

        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case 1:
                QuestionTemplateViewModel.WaterTimeQuestion waterTimeQuestion = (QuestionTemplateViewModel.WaterTimeQuestion)
                        data.getExtras().getSerializable("waterTimeQuestion");
                waterTimeQuestion.setFarmType(viewModel.getFarmType());
                viewModel.setWaterTimeQuestion(waterTimeQuestion);

                breed_drink_water_score.setText(
                        String.valueOf(
                                viewModel.getWaterTimeQuestion().getMaxWaterTimeScore()
                        ));
                // 프로토콜 1 점수



                    viewModel.setWaterScore(
                            viewModel.calculatorWaterScore(
                                    ((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedWaterTankNum).getSelectedItem(),
                                    ((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedWaterTankClean).getSelectedItem(),
                                    viewModel.getWaterTimeQuestion().getMaxWaterTimeScore()
                            )
                    );
                    breed_total_water_score.setText(
                            String.valueOf(
                                    viewModel.getWaterScore()
                            )
                    );

                    viewModel.setProtocolOneScore(
                            viewModel.calculatorProtocolOneResult(viewModel.getFarmType(),
                                    viewModel.getPoorScore(),
                                    viewModel.getWaterScore()
                            )
                    );

                    protocolOneTv.setText(String.valueOf(viewModel.getProtocolOneScore()));


                break;
            default:
                break;
        }
    }




}