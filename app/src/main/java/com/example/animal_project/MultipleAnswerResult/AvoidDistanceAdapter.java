package com.example.animal_project.MultipleAnswerResult;

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

import com.example.animal_project.R;

import java.util.ArrayList;

public class AvoidDistanceAdapter extends RecyclerView.Adapter<AvoidDistanceAdapter.CustomViewHolder>{

    private ArrayList<AvoidDistanceData> mList = null;
    private Activity context = null;
    private String searchCowKind;

    public AvoidDistanceAdapter(Activity context,ArrayList<AvoidDistanceData> list,String searchCowKind){
        this.context = context;
        this.mList = list;
        this.searchCowKind = searchCowKind;

    }
    class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView dongNumber;
        protected TextView penLocation;
        protected TextView cowSize;
        protected Button detailBtn;





        public CustomViewHolder(View view){
            super(view);


            this.dongNumber = (TextView) view.findViewById(R.id.dong_number_tv);
            this.penLocation = (TextView) view.findViewById(R.id.pen_location_tv);
            this.cowSize = (TextView) view.findViewById(R.id.cow_size_tv);
            this.detailBtn = (Button) view.findViewById(R.id.avoid_distance_detail_btn);





        }
    }
    public AvoidDistanceAdapter.CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
        AvoidDistanceAdapter.CustomViewHolder viewHolder = null;

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.avoid_distance_item_list,null,false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        viewHolder = new AvoidDistanceAdapter.CustomViewHolder(view);



        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AvoidDistanceAdapter.CustomViewHolder viewHolder, @SuppressLint("RecyclerView") int position) {
        viewHolder.dongNumber.setText(String.valueOf(position+1));
        viewHolder.penLocation.setText(String.valueOf(mList.get(position).getPenLocation()));
        viewHolder.cowSize.setText(String.valueOf(mList.get(position).getCowSize()));
        viewHolder.detailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AvoidDistanceDetailSearchResult.class);
                intent.putExtra("id",String.valueOf(mList.get(position).getId()));
                intent.putExtra("penLocation",mList.get(position).getPenLocation());
                intent.putExtra("cowSize",mList.get(position).getCowSize());
                intent.putExtra("searchCowKind",searchCowKind);

                context.startActivity(intent);
            }
        });






    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }
}
