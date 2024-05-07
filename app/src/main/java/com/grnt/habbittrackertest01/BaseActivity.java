package com.grnt.habbittrackertest01;

import android.app.Activity;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.grnt.habbittrackertest01.db.HabitDatabase;

public class BaseActivity  extends AppCompatActivity {
    public static final String TAG = BaseActivity.class.getSimpleName();

    protected HabitDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        db = Room.databaseBuilder(getApplicationContext(),
                HabitDatabase.class, "habit-traker-db").build();
    }


}
