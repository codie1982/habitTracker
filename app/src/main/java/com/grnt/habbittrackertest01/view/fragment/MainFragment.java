package com.grnt.habbittrackertest01.view.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.grnt.habbittrackertest01.R;
import com.grnt.habbittrackertest01.adapter.HabitListAdapter;
import com.grnt.habbittrackertest01.adapter.RcTimeTravelsAdapter;


public class MainFragment extends Fragment {
RecyclerView rcTimeTravels,rchbtlist;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        rcTimeTravels = view.findViewById(R.id.rc_time_intervals);
        rchbtlist = view.findViewById(R.id.rc_habit_list);
        initRCTT();//Zaman aralıkları için gereken liste
        initHabitList();
        return view;
    }

    private void initRCTT() {
        RcTimeTravelsAdapter adapter = new RcTimeTravelsAdapter();
        rcTimeTravels.setAdapter(adapter);
        rcTimeTravels.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
    }
    private void initHabitList() {
        HabitListAdapter hbtlist = new HabitListAdapter();
        rchbtlist.setAdapter(hbtlist);
        rchbtlist.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
    }
}