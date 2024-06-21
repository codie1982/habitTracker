package com.grnt.habbittrackertest01.features.colorSection.adapter;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.grnt.habbittrackertest01.R;
import com.grnt.habbittrackertest01.data.HabitColorData;
import com.grnt.habbittrackertest01.features.colorSection.listener.HabitColorListener;

import java.util.List;


public class HabitColorAdapter extends RecyclerView.Adapter<HabitColorAdapter.HCViewHolder> {

    HabitColorListener listener;
    List<HabitColorData> colorList;

    int selectedPosition;
    public HabitColorAdapter(List<HabitColorData> colorList, HabitColorListener listener) {
        this.colorList = colorList;
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
            holder.habitColorItem.setStrokeColor(Color.BLACK);
            holder.habitColorItem.setStrokeWidth(5);
            holder.habitColorItem.setCardElevation(10f);
        }else {
            holder.habitColorItem.setStrokeColor(Color.BLACK);
            holder.habitColorItem.setStrokeWidth(0);
        }

        holder.habitColorItem.getBackground().setTint(Color.parseColor(colorList.get(position).color));
        holder.habitColorItem.setOnClickListener(v -> listener.onClick(position));
    }

    @Override
    public int getItemCount() {
        return this.colorList.size();
    }

    @SuppressLint("NotifyDataSetChanged")
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
