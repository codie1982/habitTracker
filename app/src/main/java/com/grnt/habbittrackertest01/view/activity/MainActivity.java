package com.grnt.habbittrackertest01.view.activity;

import android.os.Bundle;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentContainer;

import com.grnt.habbittrackertest01.BaseActivity;
import com.grnt.habbittrackertest01.R;
import com.grnt.habbittrackertest01.data.HabitDao;
import com.grnt.habbittrackertest01.data.HabitData;
import com.grnt.habbittrackertest01.view.fragment.MainFragment;

import java.util.List;

public class MainActivity extends BaseActivity {

    FragmentContainer fc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragmentContainerView, MainFragment.class, null)
                    .commit();
        }

        HabitDao habitDao = db.habitDao();
        List<HabitData> dt =  habitDao.getAll();
    }
}