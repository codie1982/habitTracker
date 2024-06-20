package com.grnt.habbittrackertest01.features.textSection;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.grnt.habbittrackertest01.R;

public class TextSectionFeature extends ConstraintLayout {
    public TextSectionFeature(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.section_text, this, true);
    }
}
