package com.example.animal_project;

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

import java.util.ArrayList;

public class EvaInfoAdapter extends RecyclerView.Adapter<EvaInfoAdapter.CustomViewHolder> {

    private ArrayList<EvaInfoData> mList = null;
    private Activity context = null;


    public EvaInfoAdapter(Activity context, ArrayList<EvaInfoData> list) {
        this.context = context;
        this.mList = list;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        protected Button detailSearchBtn;
        protected TextView farmName;
        protected TextView repName;
        protected TextView farmType;
        protected TextView evaDay;




        public CustomViewHolder(View view) {
            super(view);
            this.detailSearchBtn = (Button) view.findViewById(R.id.detail_search_btn);
            this.farmName = (TextView) view.findViewById(R.id.farm_name_tv);
            this.repName = (TextView) view.findViewById(R.id.rep_name_tv);
            this.evaDay = (TextView) view.findViewById(R.id.eva_day_tv);
            this.farmType = (TextView) view.findViewById(R.id.farm_type_tv);

        }
    }


    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.eva_info_item_list, null,false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        CustomViewHolder viewHolder = new CustomViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder viewHolder, @SuppressLint("RecyclerView") int position) {

        viewHolder.detailSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DetailSearchActivity.class);
                intent.putExtra("searchCowKind",mList.get(position).getSearchCowKind());
                intent.putExtra("evaInfoId",mList.get(position).getEvaInfoId());


                context.startActivity(intent);

            }
        });
        viewHolder.farmName.setText(mList.get(position).getFarmName());
        viewHolder.farmType.setText(mList.get(position).getFarmType());
        viewHolder.repName.setText(mList.get(position).getRepName());
        viewHolder.evaDay.setText(mList.get(position).getEvaDay());

    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }

}

