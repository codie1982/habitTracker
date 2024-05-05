package com.grnt.habbittrackertest01.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.grnt.habbittrackertest01.R;

public class RcTimeTravelsAdapter extends RecyclerView.Adapter<RcTimeTravelsAdapter.RCTTVH> {
    public RcTimeTravelsAdapter(){

    }
    @NonNull
    @Override
    public RCTTVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rc_time_intervals_item,parent,false);
        return new RCTTVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RCTTVH holder, int position) {
        holder.txtTimeIntervals.setText("Deneme");
    }

    @Override
    public int getItemCount() {
        return 15;
    }
    class RCTTVH extends RecyclerView.ViewHolder{
        public   TextView txtTimeIntervals;
        public RCTTVH(@NonNull View itemView) {
            super(itemView);
            txtTimeIntervals =   itemView.findViewById(R.id.txt_time_intervals);
        }
    }
}
