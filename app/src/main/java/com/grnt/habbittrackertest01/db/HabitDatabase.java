package com.grnt.habbittrackertest01.db;

import androidx.room.RoomDatabase;

import com.grnt.habbittrackertest01.data.HabitDao;

public abstract class HabitDatabase extends RoomDatabase {
    public abstract HabitDao habitDao();
}
