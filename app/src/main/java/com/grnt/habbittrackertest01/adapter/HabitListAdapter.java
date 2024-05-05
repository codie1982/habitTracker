package com.grnt.habbittrackertest01.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.grnt.habbittrackertest01.R;

public class HabitListAdapter extends RecyclerView.Adapter<HabitListAdapter.HabitListViewHolder> {
    public HabitListAdapter() {

    }


    @NonNull
    @Override
    public HabitListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rc_habit_item,parent,false);
        return new HabitListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HabitListViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class HabitListViewHolder  extends RecyclerView.ViewHolder{
        public HabitListViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
