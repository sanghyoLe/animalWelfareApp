package com.example.animal_project.Beef.ProtocolTwo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;

public class BreedWindBlock extends Fragment {
    private View view;
    Integer windBlock = 0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_breed_wind_block, container, false);
        QuestionTemplateViewModel viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);
        RadioGroup windBlockRg = view.findViewById(R.id.breed_wind_block_rg);

        windBlockRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.breed_wind_block_1){
                    windBlock = 1;
                }else if(checkedId == R.id.breed_wind_block_2){
                    windBlock = 2;
                }
                ((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedWindBlock).setSelectedItem(windBlock);
                int selectedItem =  ((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedWindBlock).getSelectedItem();
                ((QuestionTemplateViewModel.RadioQuestion)viewModel.BreedWindBlock).setAnswer(windBlockRg,selectedItem);


            }
        });


        return view;
    }
}