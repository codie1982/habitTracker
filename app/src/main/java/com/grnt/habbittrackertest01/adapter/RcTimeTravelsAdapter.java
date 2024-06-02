package com.grnt.habbittrackertest01.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.grnt.habbittrackertest01.R;
import com.grnt.habbittrackertest01.data.TimeIntervalsData;

import java.util.ArrayList;
import java.util.List;

public class RcTimeTravelsAdapter extends RecyclerView.Adapter<RcTimeTravelsAdapter.RCTTVH> {
    List<TimeIntervalsData> _timeIntervals;
    public RcTimeTravelsAdapter(List<TimeIntervalsData> arTimeIntervals){
        _timeIntervals = (arTimeIntervals);
    }
    @NonNull
    @Override
    public RCTTVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rc_time_intervals_item,parent,false);
        return new RCTTVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RCTTVH holder, int position) {
        holder.btnTimeIntervals.setText(_timeIntervals.get(position).name);
    }

    @Override
    public int getItemCount() {
        return _timeIntervals.size();
    }
    class RCTTVH extends RecyclerView.ViewHolder{
        public Button btnTimeIntervals;
        public RCTTVH(@NonNull View itemView) {
            super(itemView);
            btnTimeIntervals =   itemView.findViewById(R.id.btnTimeIntervals);
        }
    }
}
