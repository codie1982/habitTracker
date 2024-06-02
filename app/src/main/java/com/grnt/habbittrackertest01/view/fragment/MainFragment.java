package com.grnt.habbittrackertest01.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.grnt.habbittrackertest01.R;
import com.grnt.habbittrackertest01.adapter.RcTimeTravelsAdapter;
import com.grnt.habbittrackertest01.data.TimeIntervalsData;
import com.grnt.habbittrackertest01.db.HabitDatabase;

import java.util.List;


public class MainFragment extends Fragment {
RecyclerView rcTimeTravels,rchbtlist;
Button btnAddHabit;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
       return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final NavController navController = Navigation.findNavController(view);
        rcTimeTravels = view.findViewById(R.id.rc_time_intervals);
        rchbtlist = view.findViewById(R.id.rc_habit_list);
        btnAddHabit = view.findViewById(R.id.btnAddHabit);
        btnAddHabit.setOnClickListener(v -> navController.navigate(R.id.action_mainFragment_to_habitListFragment));
        initRCTT(); //Zaman aralıkları için gereken liste
        initHabitList();

    }

    private void initRCTT() {
        List<TimeIntervalsData> timeIntervals = HabitDatabase.getInstance(getContext()).timeIntervalsDao().getTimeIntervals();
        RcTimeTravelsAdapter adapter = new RcTimeTravelsAdapter(timeIntervals);
        rcTimeTravels.setAdapter(adapter);
        rcTimeTravels.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
    }
    private void initHabitList() {
        //List<HabitData> hbDatas = HabitDatabase.getInstance(getContext()).habitDao().getAll();
        //HabitListAdapter hbtlist = new HabitListAdapter(hbDatas);
        //rchbtlist.setAdapter(hbtlist);
        //rchbtlist.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
    }
}