package com.example.animal_project.Beef.ProtocolThree;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

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
        TextView breed_slight_hair_loss_tv = view.findViewById(R.id.breed_slight_hair_loss_tv);
        EditText penLocationOne = view.findViewById(R.id.pen_location_ed_1);
        EditText penLocationTwo = view.findViewById(R.id.pen_location_ed_2);
        TextView sample_size_tv = view.findViewById(R.id.sample_size_tv);
        breedSlightHairLossEd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                viewModel.penQuestionAfterTextChanged(breedSlightHairLossEd,breed_slight_hair_loss_tv,sample_size_tv,
                        penLocationOne,penLocationTwo,((QuestionTemplateViewModel.PenQuestion)viewModel.BreedSlightHairLoss));
            }
        });
     return view;
    }
}