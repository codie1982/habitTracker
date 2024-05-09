package com.grnt.habbittrackertest01;

import static androidx.navigation.Navigation.findNavController;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.grnt.habbittrackertest01.data.HabitData;
import com.grnt.habbittrackertest01.db.HabitDatabase;

public class MakeHabitFragment extends Fragment {
    Button btnClose,btnSaveHabit;
    EditText edtHabitName;
    LinearLayout lytDaysOfHabit,lytTargetHabit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_make_habit, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NavController navController = Navigation.findNavController(view);
        btnClose = view.findViewById(R.id.btnClose);
        btnSaveHabit = view.findViewById(R.id.btnSaveHabit);
        edtHabitName = view.findViewById(R.id.edtHabitName);
        lytDaysOfHabit = view.findViewById(R.id.lytDaysOfHabit);
        lytTargetHabit = view.findViewById(R.id.lytTargetHabit);
        btnClose.setOnClickListener(v -> navController.navigate(R.id.action_makeHabitFragment_to_habitListFragment));
        btnSaveHabit.setOnClickListener(v-> {
            String habitName = edtHabitName.getText().toString();
            HabitData dt = new HabitData(habitName,"Alışkanlık Açıklama");
            HabitDatabase.getInstance(getContext()).habitDao().insertNewHabit(dt);
            navController.navigate(R.id.action_makeHabitFragment_to_mainFragment);

        });
        lytDaysOfHabit.setOnClickListener(v->navController.navigate(R.id.action_makeHabitFragment_to_habitDaysFragment));
        lytTargetHabit.setOnClickListener(v->navController.navigate(R.id.action_makeHabitFragment_to_habitTargetFragment));
    }
}