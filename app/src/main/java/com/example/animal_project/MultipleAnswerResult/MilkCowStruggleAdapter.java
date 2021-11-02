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

public class MilkCowStruggleAdapter extends RecyclerView.Adapter<MilkCowStruggleAdapter.CustomViewHolder>{

    private ArrayList<MilkCowStruggleData> mList = null;
    private Activity context = null;


    public MilkCowStruggleAdapter(Activity context, ArrayList<MilkCowStruggleData> list){
        this.context = context;
        this.mList = list;

    }
    class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView dongNumber;
        protected TextView penLocation;
        protected TextView cowSize;
        protected TextView headBangCount;
        protected TextView headBangPerOne;
        protected TextView headBangExceptStruggleCount;
        protected TextView headBangExceptStrugglePerOne;
        protected TextView struggleIndex;
        protected TextView score;



        public CustomViewHolder(View view){
            super(view);


            this.dongNumber = (TextView) view.findViewById(R.id.dong_number_tv);
            this.penLocation = (TextView) view.findViewById(R.id.pen_location_tv);
            this.cowSize = (TextView) view.findViewById(R.id.cow_size_tv);
            this.headBangCount = (TextView) view.findViewById(R.id.head_bang_count_tv);
            this.headBangPerOne = (TextView) view.findViewById(R.id.head_bang_per_one_tv) ;
            this.headBangExceptStruggleCount = (TextView) view.findViewById(R.id.head_bang_except_count_tv);
            this.headBangExceptStrugglePerOne = (TextView) view.findViewById(R.id.head_bang_except_per_one_tv);
            this.struggleIndex = (TextView) view.findViewById(R.id.struggle_index_tv);
            this.score = (TextView) view.findViewById(R.id.score_tv);




        }
    }
    public MilkCowStruggleAdapter.CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
        MilkCowStruggleAdapter.CustomViewHolder viewHolder = null;

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.milk_cow_struggle_item_list,null,false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        viewHolder = new MilkCowStruggleAdapter.CustomViewHolder(view);



        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MilkCowStruggleAdapter.CustomViewHolder viewHolder, @SuppressLint("RecyclerView") int position) {
        viewHolder.dongNumber.setText(String.valueOf(position+1));
        viewHolder.penLocation.setText(mList.get(position).getPenLocation());
        viewHolder.cowSize.setText(mList.get(position).getCowSize());
        viewHolder.headBangCount.setText(mList.get(position).getHeadBangCount());
        viewHolder.headBangPerOne.setText(mList.get(position).getHeadBangPerOne());
        viewHolder.headBangExceptStruggleCount.setText(mList.get(position).getHeadBandExceptStruggleCount());
        viewHolder.headBangExceptStrugglePerOne.setText(mList.get(position).getHeadBangExceptStringPerOne());
        viewHolder.struggleIndex.setText(mList.get(position).getStruggleIndex());
        viewHolder.score.setText(mList.get(position).getScore());



    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }
}

