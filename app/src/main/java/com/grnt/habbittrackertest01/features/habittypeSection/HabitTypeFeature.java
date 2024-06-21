package com.grnt.habbittrackertest01.features.habittypeSection;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.grnt.habbittrackertest01.R;
import com.grnt.habbittrackertest01.model.HabitType;

public class HabitTypeFeature extends ConstraintLayout {
    Button btnOneHabit,btnNegativeHabit,btnRegularHabit;
    TextView txthabitTypeTitle;
    HabitType selectedHabitType;
    public HabitTypeFeature(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.section_habit_type, this, true);
        btnOneHabit = findViewById(R.id.btnOneHabit);
        btnNegativeHabit = findViewById(R.id.btnNegativeHabit);
        btnRegularHabit = findViewById(R.id.btnRegularHabit);
        txthabitTypeTitle = findViewById(R.id.txthabitTypeTitle);
        initTypeButtons();
    }
    public void init(){
        selectedHabitType = HabitType.ONE;
        btnOneHabit.getBackground().setTint(getContext().getColor(R.color.active_color));
        //Unselected Buttons
        btnNegativeHabit.getBackground().setTint(getContext().getColor(R.color.passive_color));
        btnRegularHabit.getBackground().setTint(getContext().getColor(R.color.passive_color));
        String typeText = getContext().getString(R.string.habit_type_one_button_text);
        txthabitTypeTitle.setText(getContext().getString(R.string.habit_type_text,typeText));
    }

     private void initTypeButtons() {
        btnOneHabit.setOnClickListener(v-> {
            init();
        });
        btnNegativeHabit.setOnClickListener(v-> {
            selectedHabitType = HabitType.NEGATIVE;
            btnNegativeHabit.getBackground().setTint(getContext().getColor(R.color.active_color));
            //Unselected Buttons
            btnOneHabit.getBackground().setTint(getContext().getColor(R.color.passive_color));
            btnRegularHabit.getBackground().setTint(getContext().getColor(R.color.passive_color));
            String typeText = getContext().getString(R.string.habit_type_negative_button_text);
            txthabitTypeTitle.setText(getContext().getString(R.string.habit_type_text,typeText));
        });
        btnRegularHabit.setOnClickListener(v-> {
            selectedHabitType = HabitType.REGULAR;
            btnRegularHabit.getBackground().setTint(getContext().getColor(R.color.active_color));
            //Unselected Buttons
            btnOneHabit.getBackground().setTint(getContext().getColor(R.color.passive_color));
            btnNegativeHabit.getBackground().setTint(getContext().getColor(R.color.passive_color));

            String typeText = getContext().getString(R.string.habit_type_regular_button_text);
            txthabitTypeTitle.setText(getContext().getString(R.string.habit_type_text,typeText));
        });
    }

}
