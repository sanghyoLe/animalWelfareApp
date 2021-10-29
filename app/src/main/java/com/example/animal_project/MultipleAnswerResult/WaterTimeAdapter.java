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
import com.example.animal_project.Result.EvaAnswerData;

import java.util.ArrayList;

public class WaterTimeAdapter extends RecyclerView.Adapter<WaterTimeAdapter.CustomViewHolder>{

    private ArrayList<WaterTimeData> mList = null;
    private Activity context = null;


    public WaterTimeAdapter(Activity context,ArrayList<WaterTimeData> list){
        this.context = context;
        this.mList = list;

    }
    class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView dongNumber;
        protected TextView dongTotalCowSize;
        protected TextView penLocation;
        protected TextView answerCowSize;
        protected TextView answer;
        protected TextView score;
        protected TextView ratio;

        protected TextView questionName;
        protected TextView questionNumber;

        public CustomViewHolder(View view){
            super(view);

            this.answer = (TextView) view.findViewById(R.id.answer_tv);
            this.dongNumber = (TextView) view.findViewById(R.id.dong_number_tv);
            this.penLocation = (TextView) view.findViewById(R.id.pen_location_tv);
            this.dongTotalCowSize = (TextView) view.findViewById(R.id.dong_total_cow_size_tv);
            this.answerCowSize = (TextView) view.findViewById(R.id.answer_cow_size_tv);
            this.score = (TextView) view.findViewById(R.id.score_tv);
            this.ratio = (TextView) view.findViewById(R.id.ratio_tv);



        }
    }
    public WaterTimeAdapter.CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
        WaterTimeAdapter.CustomViewHolder viewHolder = null;

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.water_time_item_list,null,false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        viewHolder = new WaterTimeAdapter.CustomViewHolder(view);



        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull WaterTimeAdapter.CustomViewHolder viewHolder, @SuppressLint("RecyclerView") int position) {
        viewHolder.dongNumber.setText(String.valueOf(position+1));
        viewHolder.penLocation.setText(String.valueOf(mList.get(position).getPenLocation()));
        viewHolder.answer.setText(String.valueOf(mList.get(position).getAnswer()));
        viewHolder.dongTotalCowSize.setText(String.valueOf(mList.get(position).getDongTotalCowSize()));
        viewHolder.answerCowSize.setText(String.valueOf(mList.get(position).getAnswerCowSize()));
        viewHolder.score.setText(String.valueOf(mList.get(position).getScore()));
        viewHolder.ratio.setText(String.valueOf(mList.get(position).getRatio()));


    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }
}
