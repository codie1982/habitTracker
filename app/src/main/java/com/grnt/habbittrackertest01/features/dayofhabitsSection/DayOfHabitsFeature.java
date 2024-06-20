package com.grnt.habbittrackertest01.features.dayofhabitsSection;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.grnt.habbittrackertest01.R;

public class DayOfHabitsFeature extends ConstraintLayout {
    public DayOfHabitsFeature(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.section_day_of_habits, this, true);
    }
}
