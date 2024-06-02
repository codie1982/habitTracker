package com.grnt.habbittrackertest01.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.grnt.habbittrackertest01.R;

import java.util.ArrayList;


public class HabitColorAdapter extends RecyclerView.Adapter<HabitColorAdapter.HCViewHolder> {

    HabitColorListener listener;
    ArrayList<Integer> colorList;
    Context context ;
    int selectedPosition;
    public HabitColorAdapter(Context context, ArrayList<Integer> colorList,HabitColorListener listener) {
        this.colorList = colorList;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public HabitColorAdapter.HCViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rc_habir_color_item, parent, false);
        return new HCViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HabitColorAdapter.HCViewHolder holder, int position) {
        if(selectedPosition == position){
            holder.habitColorItem.setStrokeColor(context.getColor(R.color.black));
            holder.habitColorItem.setStrokeWidth(5);
            holder.habitColorItem.setCardElevation(10f);
        }else {
            holder.habitColorItem.setStrokeColor(context.getColor(R.color.black));
            holder.habitColorItem.setStrokeWidth(0);
        }

        holder.habitColorItem.getBackground().setTint(context.getColor(colorList.get(position)));
        holder.habitColorItem.setOnClickListener(v -> listener.onClick(position));
    }

    @Override
    public int getItemCount() {
        return this.colorList.size();
    }

    public void setSelectedPosition(int position){
        this.selectedPosition = position;
        notifyDataSetChanged();
    }
    class HCViewHolder extends RecyclerView.ViewHolder {
        MaterialCardView habitColorItem;
        public HCViewHolder(View view){
            super(view);
            habitColorItem = view.findViewById(R.id.habitColorItem);
        }
    }
}
