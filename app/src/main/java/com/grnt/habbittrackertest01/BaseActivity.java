package com.grnt.habbittrackertest01;

import android.app.Activity;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.grnt.habbittrackertest01.data.DatabaseSettingsData;
import com.grnt.habbittrackertest01.data.HabitData;
import com.grnt.habbittrackertest01.data.TimeIntervalsData;
import com.grnt.habbittrackertest01.db.HabitDatabase;

import java.util.ArrayList;
import java.util.List;

public class BaseActivity  extends AppCompatActivity {
    public static final String TAG = BaseActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        initApp();
    }

    private void initApp() {
        HabitDatabase.getInstance(this).initDatabase(this,true);
    }


}
