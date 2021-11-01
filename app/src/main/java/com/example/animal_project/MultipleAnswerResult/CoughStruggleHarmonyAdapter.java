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

public class CoughStruggleHarmonyAdapter extends RecyclerView.Adapter<CoughStruggleHarmonyAdapter.CustomViewHolder>{

    private ArrayList<CoughStruggleHarmonyData> mList = null;
    private Activity context = null;


    public CoughStruggleHarmonyAdapter(Activity context, ArrayList<CoughStruggleHarmonyData> list){
        this.context = context;
        this.mList = list;

    }
    class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView dongNumber;
        protected TextView dongTotalCowSize;
        protected TextView penLocation;
        protected TextView answer;
        protected TextView answerPerOne;


        public CustomViewHolder(View view){
            super(view);

            this.answer = (TextView) view.findViewById(R.id.answer_tv);
            this.dongNumber = (TextView) view.findViewById(R.id.dong_number_tv);
            this.penLocation = (TextView) view.findViewById(R.id.pen_location_tv);
            this.dongTotalCowSize = (TextView) view.findViewById(R.id.dong_total_cow_size_tv);
            this.answerPerOne = (TextView) view.findViewById(R.id.answer_per_one_tv);



        }
    }
    public CoughStruggleHarmonyAdapter.CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
        CoughStruggleHarmonyAdapter.CustomViewHolder viewHolder = null;

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cough_beef_behavior_item_list,null,false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        viewHolder = new CoughStruggleHarmonyAdapter.CustomViewHolder(view);



        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CoughStruggleHarmonyAdapter.CustomViewHolder viewHolder, @SuppressLint("RecyclerView") int position) {
        viewHolder.dongNumber.setText(String.valueOf(position+1));
        viewHolder.penLocation.setText(String.valueOf(mList.get(position).getPenLocation()));
        viewHolder.answer.setText(String.valueOf(mList.get(position).getAnswer()));
        viewHolder.dongTotalCowSize.setText(String.valueOf(mList.get(position).getDongTotalCowSize()));
        viewHolder.answerPerOne.setText(String.valueOf(mList.get(position).getAnswerPenOne()));


    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }
}
