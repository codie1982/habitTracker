package com.grnt.habbittrackertest01.feature.TimeIntervals;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.grnt.habbittrackertest01.R;
import com.grnt.habbittrackertest01.data.TimeIntervalsData;
import com.grnt.habbittrackertest01.db.HabitDatabase;
import com.grnt.habbittrackertest01.feature.TimeIntervals.adapter.RcTimeIntervalsAdapter;

import java.util.List;

public class TimeIntevalFeature extends LinearLayout implements ITimeIntervalsClick {
    RecyclerView rcTimeTravels;
    private RcTimeIntervalsAdapter adapter;
    public TimeIntevalFeature(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.TimeIntevalFeature, 0, 0);;
        LayoutInflater.from(getContext()).inflate(R.layout.time_intervals_layout, this, true);
        initRCTT();
    }
    private void initRCTT() {
        List<TimeIntervalsData> timeIntervals = HabitDatabase.getInstance(getContext()).timeIntervalsDao().getTimeIntervals();
        adapter = new RcTimeIntervalsAdapter(timeIntervals, this);
        rcTimeTravels.setAdapter(adapter);
        rcTimeTravels.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
    }

    @Override
    public void onSelected(int position) {
        adapter.isSelected(position);
    }
}
