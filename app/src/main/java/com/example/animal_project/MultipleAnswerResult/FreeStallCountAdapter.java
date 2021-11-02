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

public class FreeStallCountAdapter extends RecyclerView.Adapter<FreeStallCountAdapter.CustomViewHolder>{

    private ArrayList<FreeStallCountData> mList = null;
    private Activity context = null;


    public FreeStallCountAdapter(Activity context, ArrayList<FreeStallCountData> list){
        this.context = context;
        this.mList = list;

    }
    class CustomViewHolder extends RecyclerView.ViewHolder {
            protected TextView dongNumber;
            protected TextView cowSize;
            protected TextView freeStallCount;
            protected TextView score;
            protected TextView ratio;

        public CustomViewHolder(View view){
            super(view);


            this.dongNumber = (TextView) view.findViewById(R.id.dong_number_tv);
            this.cowSize = (TextView) view.findViewById(R.id.cow_size_tv);
            this.freeStallCount = (TextView) view.findViewById(R.id.free_stall_count_tv);
            this.score = (TextView) view.findViewById(R.id.score_tv);
            this.ratio = (TextView) view.findViewById(R.id.ratio_tv);



        }
    }
    public FreeStallCountAdapter.CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
        FreeStallCountAdapter.CustomViewHolder viewHolder = null;

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.free_stall_count_item_list,null,false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        viewHolder = new FreeStallCountAdapter.CustomViewHolder(view);



        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FreeStallCountAdapter.CustomViewHolder viewHolder, @SuppressLint("RecyclerView") int position) {
        viewHolder.dongNumber.setText(String.valueOf(position+1));
        viewHolder.cowSize.setText(mList.get(position).getCowSize());
        viewHolder.freeStallCount.setText(mList.get(position).getFreeStallCount());
        viewHolder.score.setText(mList.get(position).getScore());
        viewHolder.ratio.setText(mList.get(position).getRatio());

    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }
}

