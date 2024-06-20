package com.grnt.habbittrackertest01.features.endOfHabitSection;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.grnt.habbittrackertest01.R;

public class EndOfHabitFeature extends ConstraintLayout {
    public EndOfHabitFeature(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.section_end_of_habit, this, true);
    }
}
