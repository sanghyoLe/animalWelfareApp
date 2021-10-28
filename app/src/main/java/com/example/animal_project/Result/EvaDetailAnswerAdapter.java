package com.example.animal_project.Result;



import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animal_project.R;

import java.util.ArrayList;

public class EvaDetailAnswerAdapter extends RecyclerView.Adapter<EvaDetailAnswerAdapter.CustomViewHolder>{

    private ArrayList<EvaAnswerData> mList = null;
    private Activity context = null;


    public EvaDetailAnswerAdapter(Activity context,ArrayList<EvaAnswerData> list){
        this.context = context;
        this.mList = list;

    }
    class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView answer;
        protected TextView questionName;
        protected TextView questionNumber;
        protected Button detailSearchBtn;

        public CustomViewHolder(View view){
            super(view);

            this.answer = (TextView) view.findViewById(R.id.answer_tv);
            this.questionName = (TextView) view.findViewById(R.id.question_name_tv);
            this.questionNumber = (TextView) view.findViewById(R.id.question_number_tv);
            this.detailSearchBtn = (Button) view.findViewById(R.id.detail_search_btn);


        }
    }
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
        CustomViewHolder viewHolder = null;

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.eva_detail_answer_item_list,null,false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        viewHolder = new CustomViewHolder(view);



        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull EvaDetailAnswerAdapter.CustomViewHolder viewHolder, @SuppressLint("RecyclerView") int position) {

        viewHolder.questionNumber.setText(String.valueOf(position+1));
        viewHolder.answer.setText(mList.get(position).getAnswer());
        viewHolder.questionName.setText(mList.get(position).getQuestionName());
        viewHolder.detailSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("questionName",mList.get(position).getQuestionName());
            }
        });


    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }
}
