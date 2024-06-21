package com.grnt.habbittrackertest01.features.TimeIntervals.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.grnt.habbittrackertest01.R;
import com.grnt.habbittrackertest01.data.TimeIntervalsData;
import com.grnt.habbittrackertest01.features.TimeIntervals.ITimeIntervalsClick;

import java.util.ArrayList;
import java.util.List;

public class RcTimeIntervalsAdapter extends RecyclerView.Adapter<RcTimeIntervalsAdapter.RCTTVH> {
    List<TimeIntervalsData> _timeIntervals;
    ArrayList<TimeIntervalsData> _selectedTimeIntervals = new ArrayList<>();
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
        boolean isActive = false;
        setButtonState(holder,false);
        TimeIntervalsData tempdata = _timeIntervals.get(position);
        for(int i=0;i<_selectedTimeIntervals.size();i++){
            if(_selectedTimeIntervals.get(i).uid == tempdata.uid){
                setButtonState(holder,true);
                break;
            }
        }
        holder.btnTimeIntervals.setText(_timeIntervals.get(position).name);
        holder.btnTimeIntervals.setOnClickListener(v->timeIntervalsClick.onSelected(position,_timeIntervals.get(position)));

    }

    @Override
    public int getItemCount() {
        return _timeIntervals.size();
    }

    public ArrayList<TimeIntervalsData> getSelectedlist() {
        return _selectedTimeIntervals;
    }

    class RCTTVH extends RecyclerView.ViewHolder{
        public Button btnTimeIntervals;
        public RCTTVH(@NonNull View itemView) {
            super(itemView);
            btnTimeIntervals =   itemView.findViewById(R.id.btnTimeIntervals);
        }
    }
    public void setSelected(int position,TimeIntervalsData data){
        boolean isAdd = true;
        int selectedIndex = -1;
        TimeIntervalsData tempData = _timeIntervals.get(position);
        for(int i=0;i<_selectedTimeIntervals.size();i++){
            if(_selectedTimeIntervals.get(i).uid == tempData.uid){
                isAdd = false;
                selectedIndex = i;
                break;
            }
        }

        if(isAdd){
            _selectedTimeIntervals.add(data);
        }else{
            _selectedTimeIntervals.remove(selectedIndex);
        }
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
