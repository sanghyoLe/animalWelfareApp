
package com.example.animal_project.BreedBatch.ProtocolThree;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;


public class BreedHornQ3 extends Fragment {
    private View view;
    private int painkiller;
    private TextView breed_horn_removal_score_tv;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_breed_horn_q3, container, false);
        RadioGroup breed_horn_q3_rg = (RadioGroup) view.findViewById(R.id.breed_horn_q3_rg);
        breed_horn_removal_score_tv = view.findViewById(R.id.breed_horn_removal_score_tv);
        QuestionTemplateViewModel viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);
        breed_horn_q3_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.breed_horn_q3_1) {
                    painkiller = 1;
                } else if (checkedId == R.id.breed_horn_q3_2) {
                    painkiller = 2;
                }
                viewModel.setPainkiller(painkiller);
                if(viewModel.getHornRemoval() == -1){
                    breed_horn_removal_score_tv.setText("28번 문항을 완료하세요");
                } else if(viewModel.getAnesthesia() == -1){
                    breed_horn_removal_score_tv.setText("29번 문항을 완료하세요");
                } else {
                    viewModel.setHornRemovalScore(
                            viewModel.calculatorHornRemovalScore(
                                    viewModel.getHornRemoval(),
                                    viewModel.getAnesthesia(),
                                    viewModel.getPainkiller()
                            )
                    );
                    breed_horn_removal_score_tv.setText(String.valueOf(viewModel.getHornRemovalScore()));
                }
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}