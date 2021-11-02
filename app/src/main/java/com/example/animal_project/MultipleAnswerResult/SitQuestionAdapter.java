package com.example.animal_project.MultipleAnswerResult;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animal_project.R;

import java.util.ArrayList;

public class SitQuestionAdapter extends RecyclerView.Adapter<SitQuestionAdapter.CustomViewHolder>{

    private ArrayList<SitQuestionData> mList = null;
    private Activity context = null;


    public SitQuestionAdapter(Activity context, ArrayList<SitQuestionData> list){
        this.context = context;
        this.mList = list;

    }
    class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView sitNumber;
        protected TextView answer;


        public CustomViewHolder(View view){
            super(view);

            this.sitNumber = (TextView) view.findViewById(R.id.sit_number_tv);
            this.answer = (TextView) view.findViewById(R.id.answer_tv);



        }
    }
    public SitQuestionAdapter.CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
        SitQuestionAdapter.CustomViewHolder viewHolder = null;

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sit_question_item_list,null,false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        viewHolder = new SitQuestionAdapter.CustomViewHolder(view);



        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SitQuestionAdapter.CustomViewHolder viewHolder, @SuppressLint("RecyclerView") int position) {
        viewHolder.sitNumber.setText(String.valueOf(position+1));
        viewHolder.answer.setText(mList.get(position).getAnswer());


    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }
}

