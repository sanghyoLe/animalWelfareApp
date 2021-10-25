package com.example.animal_project;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EvaPenLocationAdapter extends RecyclerView.Adapter<EvaPenLocationAdapter.CustomViewHolder>{

    private ArrayList<EvaPenLocationData> mList = null;
    private Activity context = null;

    public EvaPenLocationAdapter(Activity context,ArrayList<EvaPenLocationData> list){
        this.context = context;
        this.mList = list;
    }
    class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView penLocation;
        protected TextView questionName;
        protected TextView questionNumber;

        public CustomViewHolder(View view){
            super(view);
            this.penLocation = (TextView) view.findViewById(R.id.pen_location_tv);
            this.questionName = (TextView) view.findViewById(R.id.question_name_tv);
            this.questionNumber = (TextView) view.findViewById(R.id.question_number_tv);

        }
    }
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.eva_pen_location_item_list,null,false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        CustomViewHolder viewHolder = new CustomViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull EvaPenLocationAdapter.CustomViewHolder viewHolder, @SuppressLint("RecyclerView") int position) {
        viewHolder.questionNumber.setText(mList.get(position).getQuestionNumber());
        viewHolder.penLocation.setText(mList.get(position).getPenLocation());
        viewHolder.questionName.setText(mList.get(position).getQuestionName());

    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }
}
