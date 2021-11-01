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

import org.w3c.dom.Text;

import java.util.ArrayList;

public class StrawAdapter extends RecyclerView.Adapter<StrawAdapter.CustomViewHolder>{

    private ArrayList<StrawData> mList = null;
    private Activity context = null;


    public StrawAdapter(Activity context,ArrayList<StrawData> list){
        this.context = context;
        this.mList = list;

    }
    class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView dongNumber;
        protected TextView penLocation;
        protected TextView answerOne;
        protected TextView answerTwo;
        protected TextView answerThree;
        protected TextView score;


        public CustomViewHolder(View view){
            super(view);


            this.dongNumber = (TextView) view.findViewById(R.id.dong_number_tv);
            this.penLocation = (TextView) view.findViewById(R.id.pen_location_tv);
            this.answerOne = (TextView) view.findViewById(R.id.answer_one_tv);
            this.answerTwo = (TextView) view.findViewById(R.id.answer_two_tv);
            this.answerThree = (TextView) view.findViewById(R.id.answer_three_tv);
            this.score = (TextView) view.findViewById(R.id.score_tv);




        }
    }
    public StrawAdapter.CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
        StrawAdapter.CustomViewHolder viewHolder = null;

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.straw_item_list,null,false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        viewHolder = new StrawAdapter.CustomViewHolder(view);



        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StrawAdapter.CustomViewHolder viewHolder, @SuppressLint("RecyclerView") int position) {
        viewHolder.dongNumber.setText(String.valueOf(position+1));
        viewHolder.penLocation.setText(String.valueOf(mList.get(position).getPenLocation()));
        viewHolder.answerOne.setText(String.valueOf(mList.get(position).getAnswerOne()));
        viewHolder.answerTwo.setText(String.valueOf(mList.get(position).getAnswerTwo()));
        viewHolder.answerThree.setText(String.valueOf(mList.get(position).getAnswerThree()));
        viewHolder.score.setText(String.valueOf(mList.get(position).getScore()));



    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }
}
