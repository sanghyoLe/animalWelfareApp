package com.example.animal_project;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EvaAnswerAdapter extends RecyclerView.Adapter<EvaAnswerAdapter.CustomViewHolder>{

    private ArrayList<EvaAnswerData> mList = null;
    private Activity context = null;

    public EvaAnswerAdapter(Activity context,ArrayList<EvaAnswerData> list){
        this.context = context;
        this.mList = list;
    }
    class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView answer;
        protected TextView questionName;
        protected TextView questionNumber;

        public CustomViewHolder(View view){
            super(view);
            this.answer = (TextView) view.findViewById(R.id.answer_tv);
            this.questionName = (TextView) view.findViewById(R.id.question_name_tv);
            this.questionNumber = (TextView) view.findViewById(R.id.question_number_tv);

        }
    }
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.eva_answer_item_list,null,false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        CustomViewHolder viewHolder = new CustomViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull EvaAnswerAdapter.CustomViewHolder viewHolder, @SuppressLint("RecyclerView") int position) {


        viewHolder.questionNumber.setText(String.valueOf(position+1));
        viewHolder.answer.setText(mList.get(position).getAnswer());
        viewHolder.questionName.setText(mList.get(position).getQuestionName());

    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }
}
