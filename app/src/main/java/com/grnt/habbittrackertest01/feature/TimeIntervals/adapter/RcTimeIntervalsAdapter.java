package com.grnt.habbittrackertest01.feature.TimeIntervals.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.grnt.habbittrackertest01.R;
import com.grnt.habbittrackertest01.data.TimeIntervalsData;
import com.grnt.habbittrackertest01.feature.TimeIntervals.ITimeIntervalsClick;

import java.util.List;

public class RcTimeIntervalsAdapter extends RecyclerView.Adapter<RcTimeIntervalsAdapter.RCTTVH> {
    List<TimeIntervalsData> _timeIntervals;
    int selectedPosition = -1;
    ITimeIntervalsClick timeIntervalsClick;
    boolean isSelected;
    public RcTimeIntervalsAdapter(List<TimeIntervalsData> arTimeIntervals,ITimeIntervalsClick timeIntervalsClick){
        this.timeIntervalsClick = timeIntervalsClick;
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
        if(isSelected){
            if(selectedPosition == position){
                setButtonState(holder,true);
            }else {
                setButtonState(holder,false);
            }
        }else {
            setButtonState(holder,false);
        }

        holder.btnTimeIntervals.setText(_timeIntervals.get(position).name);
        holder.btnTimeIntervals.setOnClickListener(v->timeIntervalsClick.onSelected(position));

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
    public void isSelected(int position){
        if(selectedPosition == position){
            isSelected=!isSelected;
        }else {
            isSelected = true;
        }
        selectedPosition = position;
        notifyDataSetChanged();
    }

    private void setButtonState(RCTTVH holder,boolean isActive){
        if(isActive){
            holder.btnTimeIntervals.setBackgroundColor(holder.itemView.getContext().getColor(R.color.active_color));
        }else {
            holder.btnTimeIntervals.setBackgroundColor(holder.itemView.getContext().getColor(R.color.passive_color));
        }
    }
}
