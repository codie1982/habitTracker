package com.grnt.habbittrackertest01.features.textSection;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.grnt.habbittrackertest01.R;


public class TextSectionFeature extends ConstraintLayout {
    EditText edtHabitName,edtHabitDescription;
    private final String NONTEXT = "";
    public TextSectionFeature(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.section_text, this, true);
        edtHabitName = findViewById(R.id.edtHabitName);
        edtHabitName.setHint(getContext().getString(R.string.habit_name_text));
        edtHabitDescription = findViewById(R.id.edtHabitDescription);
        edtHabitDescription.setHint(getContext().getString(R.string.habit_description));
    }

    public void init() {
        edtHabitName.setText(NONTEXT);
        edtHabitDescription.setText(NONTEXT);
    }

    public String getHabitName(){
        return edtHabitName.getText().toString().trim();
    }
    public String getHabitDescription(){
        return edtHabitDescription.getText().toString().trim();
    }
}
