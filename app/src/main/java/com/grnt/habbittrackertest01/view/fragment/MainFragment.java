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
import androidx.recyclerview.widget.RecyclerView;

import com.grnt.habbittrackertest01.R;


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
       return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final NavController navController = Navigation.findNavController(view);
        rcTimeTravels = view.findViewById(R.id.rc_time_intervals);
        rchbtlist = view.findViewById(R.id.rc_habit_list);
        btnAddHabit = view.findViewById(R.id.btnAddHabit);
        btnAddHabit.setOnClickListener(v -> navController.navigate(R.id.action_mainFragment_to_habitListFragment));
        initHabitList();
    }

    private void initHabitList() {
        //List<HabitData> hbDatas = HabitDatabase.getInstance(getContext()).habitDao().getAll();
        //HabitListAdapter hbtlist = new HabitListAdapter(hbDatas);
        //rchbtlist.setAdapter(hbtlist);
        //rchbtlist.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
    }
}