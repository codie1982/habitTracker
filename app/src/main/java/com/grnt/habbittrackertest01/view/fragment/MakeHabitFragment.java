package com.grnt.habbittrackertest01.view.fragment;

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

import com.grnt.habbittrackertest01.R;
import com.grnt.habbittrackertest01.data.HabitData;
import com.grnt.habbittrackertest01.db.HabitDatabase;
import com.grnt.habbittrackertest01.features.TimeIntervals.TimeIntevalFeature;
import com.grnt.habbittrackertest01.features.advanceSettingsSection.AdvanceSettingsFeature;
import com.grnt.habbittrackertest01.features.colorSection.HabitColorFeature;
import com.grnt.habbittrackertest01.features.dailyGoalsSection.DailyGoalsFeature;
import com.grnt.habbittrackertest01.features.dayofhabitsSection.DayOfHabitsFeature;
import com.grnt.habbittrackertest01.features.endOfHabitSection.EndOfHabitFeature;
import com.grnt.habbittrackertest01.features.habittypeSection.HabitTypeFeature;
import com.grnt.habbittrackertest01.features.notificationAlarmSection.NotificationAlarmFeature;
import com.grnt.habbittrackertest01.features.textSection.TextSectionFeature;

public class MakeHabitFragment extends Fragment {
    Button btnClose,btnSaveHabit;
    TextSectionFeature sectionText;
    HabitTypeFeature sectionHabitType;
    HabitColorFeature sectionHabitColor;
    DayOfHabitsFeature sectionDayOfHabits;
    TimeIntevalFeature sectionTimeIntervals;
    DailyGoalsFeature sectionDailyGoals;
    AdvanceSettingsFeature sectionAdvanceSettings;
    NotificationAlarmFeature sectionNotificationAlarm;
    EndOfHabitFeature sectionEndOfHabit;
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
        btnClose = view.findViewById(R.id.btnClose);
        btnSaveHabit = view.findViewById(R.id.btnSaveHabit);

        sectionText = view.findViewById(R.id.sectionText);
        sectionHabitType = view.findViewById(R.id.sectionHabitType);
        sectionHabitColor = view.findViewById(R.id.sectionHabitColor);
        sectionTimeIntervals = view.findViewById(R.id.sectionTimeIntervals);
        sectionDayOfHabits = view.findViewById(R.id.sectionDayOfHabits);
        sectionDailyGoals = view.findViewById(R.id.sectionDailyGoals);
        sectionAdvanceSettings = view.findViewById(R.id.sectionAdvanceSettings);
        sectionNotificationAlarm = view.findViewById(R.id.sectionNotificationAlarm);
        sectionEndOfHabit = view.findViewById(R.id.sectionEndOfHabit);

        NavController navController = Navigation.findNavController(view);

        btnClose.setOnClickListener(v -> navController.navigate(R.id.action_makeHabitFragment_to_habitListFragment));


/*      btnClose = view.findViewById(R.id.btnClose);
        btnSaveHabit = view.findViewById(R.id.btnSaveHabit);
        edtHabitName = view.findViewById(R.id.edtHabitName);
        edHabitDescription = view.findViewById(R.id.edtHabitDescription);
        rcHabitColor = view.findViewById(R.id.rcHabitColor);
        lytDaysOfHabit = view.findViewById(R.id.lytDaysOfHabit);
        lytTargetHabit = view.findViewById(R.id.lytTargetHabit);

        btnOneHabit = view.findViewById(R.id.btnOneHabit);
        btnNegativeHabit = view.findViewById(R.id.btnNegativeHabit);
        btnRegularHabit = view.findViewById(R.id.btnRegulareHabit);
        txthabitTypeTitle = view.findViewById(R.id.txthabitTypeTitle);

        lytDaysOfHabit.setOnClickListener(v->navController.navigate(R.id.action_makeHabitFragment_to_habitDaysFragment));
        lytTargetHabit.setOnClickListener(v->navController.navigate(R.id.action_makeHabitFragment_to_habitTargetFragment));

        initTypeButtons();
        initColorAdapter();*/

        btnSaveHabit.setOnClickListener(v-> {
            String habitName = sectionText.getHabitName();
            String habitDescription = sectionText.getHabitDescription();
            String habitColor = sectionHabitColor.getSelectedHabitcolorID();
            HabitData dt = new HabitData();
            dt.name = habitName;
            dt.description = habitDescription;

            HabitDatabase.getInstance(getContext()).habitDao().insertNewHabit(dt);
            navController.navigate(R.id.action_makeHabitFragment_to_mainFragment);

        });

        init();
    }

    private void init() {
        sectionText.init();
        sectionHabitColor.init();
        sectionHabitType.init();
    }

    @Override
    public void onResume() {
        super.onResume();
        init();
    }
}