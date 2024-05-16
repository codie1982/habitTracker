package com.grnt.habbittrackertest01.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.grnt.habbittrackertest01.R;
import com.grnt.habbittrackertest01.data.HabitData;

import java.util.List;

public class HabitListAdapter extends RecyclerView.Adapter<HabitListAdapter.HabitListViewHolder> {
    List<HabitData> _listHabitData;
    public HabitListAdapter(List<HabitData> hbDatas) {
        _listHabitData  = hbDatas;
    }


    @NonNull
    @Override
    public HabitListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rc_habit_item,parent,false);
        return new HabitListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HabitListViewHolder holder, int position) {
            holder.txtHabitName.setText(_listHabitData.get(position).name.toString());
    }

    @Override
    public int getItemCount() {
        return _listHabitData.size();
    }

    public class HabitListViewHolder  extends RecyclerView.ViewHolder{
        TextView txtHabitName;
        public HabitListViewHolder(@NonNull View itemView) {
            super(itemView);
            txtHabitName = itemView.findViewById(R.id.txtHabitName);
        }
    }
}
