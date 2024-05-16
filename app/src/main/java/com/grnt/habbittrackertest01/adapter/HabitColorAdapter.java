package com.grnt.habbittrackertest01.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.grnt.habbittrackertest01.R;

import java.util.ArrayList;


public class HabitColorAdapter extends RecyclerView.Adapter<HabitColorAdapter.HCViewHolder> {

    ArrayList<Integer> colorList;
    Context context ;
    public HabitColorAdapter(Context context, ArrayList<Integer> colorList) {
        this.colorList = colorList;
        this.context = context;
    }

    @NonNull
    @Override
    public HabitColorAdapter.HCViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rc_habir_color_item, parent, false);
        return new HCViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HabitColorAdapter.HCViewHolder holder, int position) {
        holder.habitColorItem.getBackground().setTint(context.getColor(colorList.get(position)));
    }

    @Override
    public int getItemCount() {
        return this.colorList.size();
    }

    class HCViewHolder extends RecyclerView.ViewHolder {
        MaterialCardView habitColorItem;
        public HCViewHolder(View view){
            super(view);
            habitColorItem = view.findViewById(R.id.habitColorItem);
        }
    }
}
