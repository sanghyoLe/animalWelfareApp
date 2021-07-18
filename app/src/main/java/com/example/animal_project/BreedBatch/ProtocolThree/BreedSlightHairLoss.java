package com.example.animal_project.BreedBatch.ProtocolThree;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;

public class BreedSlightHairLoss extends Fragment {
    private View view;
    private QuestionTemplateViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_breed_slight_hair_loss, container, false);
        viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);
        EditText breedSlightHairLossEd = view.findViewById(R.id.breed_slight_hair_loss_ed);


        breedSlightHairLossEd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(TextUtils.isEmpty(breedSlightHairLossEd.getText().toString())){
                    ((QuestionTemplateViewModel.PenQuestion)viewModel.BreedSlightHairLoss).setNumberOfCow(-1);
                    viewModel.setSlightHairLoss(-1);
                } else {
                    float slightHairLoss = 0;
                    slightHairLoss = Float.parseFloat(breedSlightHairLossEd.getText().toString());
                    ((QuestionTemplateViewModel.PenQuestion)viewModel.BreedSlightHairLoss).setNumberOfCow((int)slightHairLoss);
                    ((QuestionTemplateViewModel.PenQuestion)viewModel.BreedSlightHairLoss).setPenLocation(
                            viewModel.makePenLocation(
                                    view.findViewById(R.id.pen_location_ed_1),
                                    view.findViewById(R.id.pen_location_ed_2)
                            )
                    );
                }
            }
        });
     return view;
    }
}