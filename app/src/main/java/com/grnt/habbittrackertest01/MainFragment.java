package com.grnt.habbittrackertest01;

import static androidx.navigation.Navigation.findNavController;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavArgument;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.grnt.habbittrackertest01.R;
import com.grnt.habbittrackertest01.adapter.HabitListAdapter;
import com.grnt.habbittrackertest01.adapter.RcTimeTravelsAdapter;
import com.grnt.habbittrackertest01.data.HabitData;
import com.grnt.habbittrackertest01.db.HabitDatabase;

import java.util.List;

import javax.inject.Inject;


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
        RcTimeTravelsAdapter adapter = new RcTimeTravelsAdapter();
        rcTimeTravels.setAdapter(adapter);
        rcTimeTravels.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
    }
    private void initHabitList() {
        List<HabitData> hbDatas = HabitDatabase.getInstance(getContext()).habitDao().getAll();
        HabitListAdapter hbtlist = new HabitListAdapter(hbDatas);
        rchbtlist.setAdapter(hbtlist);
        rchbtlist.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
    }
}