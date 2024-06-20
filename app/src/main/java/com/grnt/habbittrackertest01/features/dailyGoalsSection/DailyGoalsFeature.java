package com.grnt.habbittrackertest01.features.dailyGoalsSection;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.grnt.habbittrackertest01.R;

public class DailyGoalsFeature extends ConstraintLayout {
    public DailyGoalsFeature(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.section_daily_goals, this, true);
    }
}
