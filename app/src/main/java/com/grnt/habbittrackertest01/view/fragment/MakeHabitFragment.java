package com.grnt.habbittrackertest01.view.fragment;

import static androidx.navigation.Navigation.findNavController;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.grnt.habbittrackertest01.R;
import com.grnt.habbittrackertest01.adapter.HabitColorAdapter;
import com.grnt.habbittrackertest01.adapter.HabitColorListener;
import com.grnt.habbittrackertest01.data.HabitData;
import com.grnt.habbittrackertest01.db.HabitDatabase;
import com.grnt.habbittrackertest01.model.HabitType;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MakeHabitFragment extends Fragment {
    Button btnClose,btnSaveHabit;
    Button btnOneHabit,btnNegativeHabit,btnRegularHabit;
    EditText edtHabitName,edHabitDescription;
    LinearLayout lytDaysOfHabit,lytTargetHabit;
    RecyclerView rcHabitColor;
    HabitType selectedHabitType;

    TextView txthabitTypeTitle;
    HabitColorAdapter hba;
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
        edHabitDescription = view.findViewById(R.id.edtHabitDescription);
        rcHabitColor = view.findViewById(R.id.rcHabitColor);
        lytDaysOfHabit = view.findViewById(R.id.lytDaysOfHabit);
        lytTargetHabit = view.findViewById(R.id.lytTargetHabit);

        btnOneHabit = view.findViewById(R.id.btnOneHabit);
        btnNegativeHabit = view.findViewById(R.id.btnNegativeHabit);
        btnRegularHabit = view.findViewById(R.id.btnRegulareHabit);
        txthabitTypeTitle = view.findViewById(R.id.txthabitTypeTitle);
        btnClose.setOnClickListener(v -> navController.navigate(R.id.action_makeHabitFragment_to_habitListFragment));
        btnSaveHabit.setOnClickListener(v-> {
            String habitName = edtHabitName.getText().toString();
            String habitDescription = edHabitDescription.getText().toString();
            HabitData dt = new HabitData();
            dt.name = habitName;
            dt.description = habitDescription;

            HabitDatabase.getInstance(getContext()).habitDao().insertNewHabit(dt);
            navController.navigate(R.id.action_makeHabitFragment_to_mainFragment);

        });
        lytDaysOfHabit.setOnClickListener(v->navController.navigate(R.id.action_makeHabitFragment_to_habitDaysFragment));
        lytTargetHabit.setOnClickListener(v->navController.navigate(R.id.action_makeHabitFragment_to_habitTargetFragment));

        initTypeButtons();
        initColorAdapter();
    }

    private void initTypeButtons() {
        firstTypeState();
        btnOneHabit.setOnClickListener(v-> {
            firstTypeState();
        });
        btnNegativeHabit.setOnClickListener(v-> {
            selectedHabitType = HabitType.NEGATIVE;
            btnNegativeHabit.getBackground().setTint(getContext().getColor(R.color.button_select_color));
            //Unselected Buttons
            btnOneHabit.getBackground().setTint(getContext().getColor(R.color.button_color));
            btnRegularHabit.getBackground().setTint(getContext().getColor(R.color.button_color));
            String typeText = getString(R.string.habit_type_negative_button_text);
            txthabitTypeTitle.setText(getString(R.string.habit_type_text,typeText));
        });
        btnRegularHabit.setOnClickListener(v-> {
            selectedHabitType = HabitType.REGULAR;
            btnRegularHabit.getBackground().setTint(getContext().getColor(R.color.button_select_color));
            //Unselected Buttons
            btnOneHabit.getBackground().setTint(getContext().getColor(R.color.button_color));
            btnNegativeHabit.getBackground().setTint(getContext().getColor(R.color.button_color));

            String typeText = getString(R.string.habit_type_regular_button_text);
            txthabitTypeTitle.setText(getString(R.string.habit_type_text,typeText));
        });
    }

    void firstTypeState() {
        selectedHabitType = HabitType.ONE;
        btnOneHabit.getBackground().setTint(getContext().getColor(R.color.button_select_color));
        //Unselected Buttons
        btnNegativeHabit.getBackground().setTint(getContext().getColor(R.color.button_color));
        btnRegularHabit.getBackground().setTint(getContext().getColor(R.color.button_color));
        String typeText = getString(R.string.habit_type_one_button_text);
        txthabitTypeTitle.setText(getString(R.string.habit_type_text,typeText));
    }

    private void initColorAdapter() {
        ArrayList<Integer> habit_colors = new ArrayList<>();
        habit_colors.add(R.color.habit_color_one);
        habit_colors.add(R.color.habit_color_two);
        habit_colors.add(R.color.habit_color_three);
        habit_colors.add(R.color.habit_color_four);
        habit_colors.add(R.color.habit_color_five);
        habit_colors.add(R.color.habit_color_six);
        habit_colors.add(R.color.habit_color_seven);
        habit_colors.add(R.color.habit_color_eight);
        habit_colors.add(R.color.habit_color_nine);
        habit_colors.add(R.color.habit_color_ten);

        hba = new HabitColorAdapter(getContext(), habit_colors, position -> hba.setSelectedPosition(position));
        rcHabitColor.setAdapter(hba);
        rcHabitColor.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
    }

    @Override
    public void onResume() {
        super.onResume();
        firstTypeState();
    }
}