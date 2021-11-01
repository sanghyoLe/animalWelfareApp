package com.example.animal_project.MultipleAnswerResult;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.animal_project.R;

import java.util.ArrayList;

public class AvoidDistanceDetailAdapter extends RecyclerView.Adapter<AvoidDistanceDetailAdapter.CustomViewHolder>{

    private ArrayList<AvoidDistanceData> mList = null;
    private Activity context = null;


    public AvoidDistanceDetailAdapter(Activity context,ArrayList<AvoidDistanceData> list){
        this.context = context;
        this.mList = list;

    }
    class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView cowNumber;
        protected TextView avoidDistanceLevel;






        public CustomViewHolder(View view){
            super(view);




            this.cowNumber = (TextView) view.findViewById(R.id.cow_number_tv);
            this.avoidDistanceLevel = (TextView) view.findViewById(R.id.avoid_distance_level_tv);





        }
    }
    public AvoidDistanceDetailAdapter.CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
        AvoidDistanceDetailAdapter.CustomViewHolder viewHolder = null;

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.avoid_distance_detail_item_list,null,false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        viewHolder = new AvoidDistanceDetailAdapter.CustomViewHolder(view);



        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AvoidDistanceDetailAdapter.CustomViewHolder viewHolder, @SuppressLint("RecyclerView") int position) {
        viewHolder.cowNumber.setText(mList.get(position).getCowNumber());
        viewHolder.avoidDistanceLevel.setText(mList.get(position).getAvoidDistanceLevel());







    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }
}
