package com.grnt.habbittrackertest01.features.colorSection;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.grnt.habbittrackertest01.R;
import com.grnt.habbittrackertest01.features.colorSection.adapter.HabitColorAdapter;
import com.grnt.habbittrackertest01.features.colorSection.listener.HabitColorListener;
import com.grnt.habbittrackertest01.data.HabitColorData;
import com.grnt.habbittrackertest01.db.HabitDatabase;

import java.util.List;

public class HabitColorFeature extends ConstraintLayout implements HabitColorListener {
    HabitColorAdapter habitColorAdapter;
    RecyclerView rcHabitColor;
    int selectedPosition;
    List<HabitColorData> habitColors;

    public HabitColorFeature(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.section_habit_color, this, true);
        rcHabitColor = findViewById(R.id.rcHabitColor);
    }
    public void init() {
        habitColors = HabitDatabase.getInstance(getContext()).habitColorDao().getHabitColors();
        habitColorAdapter = new HabitColorAdapter(habitColors,this);
        rcHabitColor.setAdapter(habitColorAdapter);
        rcHabitColor.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
    }

    @Override
    public void onClick(int position) {
        selectedPosition = position;
        habitColorAdapter.setSelectedPosition(selectedPosition);
    }
    public String getSelectedHabitcolorID(){
        return habitColors.get(selectedPosition).color;
    }


}
