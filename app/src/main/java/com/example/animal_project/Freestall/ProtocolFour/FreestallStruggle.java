package com.example.animal_project.Freestall.ProtocolFour;

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

import com.example.animal_project.MilkCowViewModel;
import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;


public class FreestallStruggle extends Fragment {
    private View view;
    private int dong_size;
    private double struggle;
    private TextView breed_struggle_tv;
    private TextView breed_struggle_ratio_tv;
    private QuestionTemplateViewModel viewModel;
    private MilkCowViewModel viewModelMilk;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_freestall_struggle, container, false);
        viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);
        viewModelMilk = new ViewModelProvider(getActivity()).get(MilkCowViewModel.class);



        breed_struggle_tv = view.findViewById(R.id.breed_struggle_tv);


        if(viewModelMilk.getStruggle() == -1){
            breed_struggle_tv.setText("평가를 완료하세요");
        } else {
            viewModelMilk.setSocialBehaviorScore(
                    viewModelMilk.calculatorSocialBehaviorScore(viewModelMilk.getStruggle())
            );
            breed_struggle_tv.setText(String.valueOf(viewModelMilk.getSocialBehaviorScore()));
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
                    Intent intent = new Intent(getActivity(), FreestallStruggleDong.class);
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
                struggle = data.getExtras().getDouble("ratioAvg");
//                breed_struggle_tv.setText(String.valueOf(struggle));
                viewModelMilk.setStruggle(struggle);
                if(viewModelMilk.getStruggle() == -1){
                    breed_struggle_tv.setText("평가를 완료하세요");
                } else {
                    viewModelMilk.setSocialBehaviorScore(
                            viewModelMilk.calculatorSocialBehaviorScore(viewModelMilk.getStruggle())
                    );
                    breed_struggle_tv.setText(String.valueOf(viewModelMilk.getSocialBehaviorScore()));
                }
                break;
            default:
                break;
        }
    }
}
