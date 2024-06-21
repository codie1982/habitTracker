package com.grnt.habbittrackertest01.features.TimeIntervals;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.grnt.habbittrackertest01.R;
import com.grnt.habbittrackertest01.data.TimeIntervalsData;
import com.grnt.habbittrackertest01.db.HabitDatabase;
import com.grnt.habbittrackertest01.features.TimeIntervals.adapter.RcTimeIntervalsAdapter;

import java.util.ArrayList;
import java.util.List;

public class TimeIntevalFeature extends ConstraintLayout implements ITimeIntervalsClick {
    RecyclerView rcTimeTravels;
    TextView tvTimeIntervals;
    private RcTimeIntervalsAdapter adapter;
    List<TimeIntervalsData> timeIntervals;
    List<TimeIntervalsData> selectedTimeIntervals;
    public TimeIntevalFeature(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.TimeIntevalFeature, 0, 0);
        LayoutInflater.from(context).inflate(R.layout.section_time_intervals, this, true);
        rcTimeTravels = findViewById(R.id.rcTimeIntervals);
        tvTimeIntervals = findViewById(R.id.txtTimeTitle);
        initRCTT();
    }
    private void initRCTT() {
        timeIntervals = HabitDatabase.getInstance(getContext()).timeIntervalsDao().getTimeIntervals();
        adapter = new RcTimeIntervalsAdapter(timeIntervals, this);
        rcTimeTravels.setAdapter(adapter);
        rcTimeTravels.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
    }

    @Override
    public void onSelected(int position,TimeIntervalsData data) {
        adapter.setSelected(position,data);
       ArrayList<TimeIntervalsData> selectedList =  adapter.getSelectedlist();
       StringBuilder ttText = new StringBuilder();
       boolean isConnect = false;
       if(selectedList.isEmpty()){
           tvTimeIntervals.setText("Bir zaman aralığı seçiniz");
       }else if(selectedList.size() == 1){
           ttText.append(selectedList.get(0).name);
           ttText.append(" ");
           ttText.append(selectedList.get(0).start_hour);
           ttText.append(":");
           ttText.append(selectedList.get(0).start_minute);
           ttText.append(" ");
           ttText.append("ve");
           ttText.append(" ");
           ttText.append(selectedList.get(0).end_hour);
           ttText.append(":");
           ttText.append(selectedList.get(0).end_minute);
           ttText.append(" arasında.");
           tvTimeIntervals.setText(ttText.toString());
       }else {
           selectedList.size();
           tvTimeIntervals.setText("Çoklu Zaman Aralığı");
       }
    }
}
