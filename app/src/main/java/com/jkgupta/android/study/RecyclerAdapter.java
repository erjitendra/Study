package com.jkgupta.android.study;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jindal on 2/4/2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    ArrayList<String> arrayList=new ArrayList<String>();
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
        RecyclerViewHolder viewHolder=new RecyclerViewHolder(view);
        return viewHolder;
    }
    public RecyclerAdapter(ArrayList<String> arrayList)
    {
        this.arrayList=arrayList;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
holder.subjects.setText(arrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView subjects;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            subjects=itemView.findViewById(R.id.tv_subjects);
        }
    }
}
