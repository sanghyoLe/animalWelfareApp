package com.example.animal_project.MilkCow;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.animal_project.QuestionTemplateViewModel;
import com.example.animal_project.R;

import org.w3c.dom.Text;


public class MovementStability extends Fragment {
    private View view;
    private QuestionTemplateViewModel viewModel;
    private MilkCowScoreCalculator mc;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_movement_stability, container, false);
        viewModel = new ViewModelProvider(getActivity()).get(QuestionTemplateViewModel.class);
        mc = new MilkCowScoreCalculator();
        EditText accessTroubleEd = view.findViewById(R.id.access_trouble_ed);
        EditText exitTroubleEd = view.findViewById(R.id.exit_trouble_ed);
        TextView accessTroubleRatioTv = view.findViewById(R.id.access_trouble_ratio_tv);
        TextView exitTroubleRatioTv = view.findViewById(R.id.exit_trouble_ratio_tv);
        TextView totalRatioTv = view.findViewById(R.id.total_access_ratio_tv);
        TextView movementStabilityScoreTv = view.findViewById(R.id.movement_stability_score_tv);
        TextView milkCowProtocolTwoTv = view.findViewById(R.id.milk_cow_protocol_two_tv);
        if(viewModel.getProtocolTwoScore() != -1){
            milkCowProtocolTwoTv.setText(String.valueOf(
                    viewModel.getProtocolTwoScore()
            ));
        }
        accessTroubleEd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(TextUtils.isEmpty(accessTroubleEd.getText())){
                    accessTroubleRatioTv.setText("문항을 완료하세요");
                    ((QuestionTemplateViewModel.MovementStability)viewModel.MovementStability).setScore(-1);
                }else if(Integer.parseInt(accessTroubleEd.getText().toString()) > viewModel.getMilkCowSize()){
                    accessTroubleRatioTv.setText("표본 착유우 규모보다 큽니다.");
                    ((QuestionTemplateViewModel.MovementStability)viewModel.MovementStability).setScore(-1);
                }else {
                    float ratio = (Float.parseFloat(accessTroubleEd.getText().toString()) / viewModel.getMilkCowSize()) * 100;
                    ratio = viewModel.cutDecimal(ratio);
                    accessTroubleRatioTv.setText(String.valueOf(ratio) + "%");
                    ((QuestionTemplateViewModel.MovementStability)viewModel.MovementStability).setAccessTroubleRatio(ratio);
                    ((QuestionTemplateViewModel.MovementStability)viewModel.MovementStability).setAccessTroubleCowCount(
                            Integer.parseInt(accessTroubleEd.getText().toString())
                    );
                }
                if(TextUtils.isEmpty(accessTroubleEd.getText()) || TextUtils.isEmpty(exitTroubleEd.getText())){
                    totalRatioTv.setText("두 문항을 모두 완료하세요");
                    ((QuestionTemplateViewModel.MovementStability)viewModel.MovementStability).setScore(-1);
                } else if (Integer.parseInt(accessTroubleEd.getText().toString()) > viewModel.getMilkCowSize()) {
                    totalRatioTv.setText("접근통로 개체가 표본 착유우 규모보다 큽니다.");
                    ((QuestionTemplateViewModel.MovementStability)viewModel.MovementStability).setScore(-1);
                } else if(Integer.parseInt(exitTroubleEd.getText().toString()) > viewModel.getMilkCowSize()){
                    totalRatioTv.setText("퇴장통로 개체가 표본 착유우 규모보다 큽니다.");
                    ((QuestionTemplateViewModel.MovementStability)viewModel.MovementStability).setScore(-1);
                } else {
                    ((QuestionTemplateViewModel.MovementStability)viewModel.MovementStability).setTotalRatio(
                            ((QuestionTemplateViewModel.MovementStability)viewModel.MovementStability).calculatorTotalRatio(
                                    ((QuestionTemplateViewModel.MovementStability)viewModel.MovementStability).getAccessTroubleRatio(),
                                    ((QuestionTemplateViewModel.MovementStability)viewModel.MovementStability).getExitTroubleRatio()
                            )
                    );
                    totalRatioTv.setText(
                            String.valueOf(
                                    ((QuestionTemplateViewModel.MovementStability)viewModel.MovementStability).getTotalRatio()
                            )
                    );
                    ((QuestionTemplateViewModel.MovementStability)viewModel.MovementStability).setScore(
                            ((QuestionTemplateViewModel.MovementStability)viewModel.MovementStability).calculatorScore(
                                    ((QuestionTemplateViewModel.MovementStability)viewModel.MovementStability).getTotalRatio()
                            )
                    );
                    movementStabilityScoreTv.setText(
                            String.valueOf(
                                    ((QuestionTemplateViewModel.MovementStability)viewModel.MovementStability).getScore()
                            )
                    );

                }
            }
        });
        exitTroubleEd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(TextUtils.isEmpty(exitTroubleEd.getText())){
                    exitTroubleRatioTv.setText("문항을 완료하세요");
                    ((QuestionTemplateViewModel.MovementStability)viewModel.MovementStability).setScore(-1);
                }else if(Integer.parseInt(exitTroubleEd.getText().toString()) > viewModel.getMilkCowSize()){
                    exitTroubleRatioTv.setText("표본 착유우 규모보다 큽니다.");
                    ((QuestionTemplateViewModel.MovementStability)viewModel.MovementStability).setScore(-1);
                }else {
                    float ratio = (Float.parseFloat(exitTroubleEd.getText().toString()) / viewModel.getMilkCowSize()) * 100;
                    ratio = viewModel.cutDecimal(ratio);
                    exitTroubleRatioTv.setText(String.valueOf(ratio));
                    ((QuestionTemplateViewModel.MovementStability)viewModel.MovementStability).setExitTroubleRatio(ratio);
                    ((QuestionTemplateViewModel.MovementStability)viewModel.MovementStability).setExitTroubleCowCount(
                            Integer.parseInt(exitTroubleEd.getText().toString())
                    );
                }

                if(TextUtils.isEmpty(accessTroubleEd.getText()) || TextUtils.isEmpty(exitTroubleEd.getText())){
                    totalRatioTv.setText("두 문항을 모두 완료하세요");
                    ((QuestionTemplateViewModel.MovementStability)viewModel.MovementStability).setScore(-1);
                }else if (Integer.parseInt(accessTroubleEd.getText().toString()) > viewModel.getMilkCowSize()) {
                    totalRatioTv.setText("접근통로 개체가 표본 착유우 규모보다 큽니다.");
                    ((QuestionTemplateViewModel.MovementStability)viewModel.MovementStability).setScore(-1);
                } else if(Integer.parseInt(exitTroubleEd.getText().toString()) > viewModel.getMilkCowSize()){
                    totalRatioTv.setText("퇴장통로 개체가 표본 착유우 규모보다 큽니다.");
                    ((QuestionTemplateViewModel.MovementStability)viewModel.MovementStability).setScore(-1);
                }
                else {
                    ((QuestionTemplateViewModel.MovementStability)viewModel.MovementStability).setTotalRatio(
                            ((QuestionTemplateViewModel.MovementStability)viewModel.MovementStability).calculatorTotalRatio(
                                    ((QuestionTemplateViewModel.MovementStability)viewModel.MovementStability).getAccessTroubleRatio(),
                                    ((QuestionTemplateViewModel.MovementStability)viewModel.MovementStability).getExitTroubleRatio()
                            )
                    );
                    totalRatioTv.setText(
                            String.valueOf(
                                    ((QuestionTemplateViewModel.MovementStability)viewModel.MovementStability).getTotalRatio()
                            )
                    );
                    ((QuestionTemplateViewModel.MovementStability)viewModel.MovementStability).setScore(
                            ((QuestionTemplateViewModel.MovementStability)viewModel.MovementStability).calculatorScore(
                                    ((QuestionTemplateViewModel.MovementStability)viewModel.MovementStability).getTotalRatio()
                            )
                    );
                    movementStabilityScoreTv.setText(
                            String.valueOf(
                                    ((QuestionTemplateViewModel.MovementStability)viewModel.MovementStability).getScore()
                            )
                    );



                            viewModel.setProtocolTwoScore(
                                    mc.calculatorProtocolTwoScore(
                                            viewModel.getRestScore(),
                                            viewModel.getTotalWarmVentilatingScore(),
                                            ((QuestionTemplateViewModel.MovementStability)viewModel.MovementStability).getScore()
                                    )
                            );
                            milkCowProtocolTwoTv.setText(String.valueOf(viewModel.getProtocolTwoScore()));



                }
            }
        });

        return view;
    }

}