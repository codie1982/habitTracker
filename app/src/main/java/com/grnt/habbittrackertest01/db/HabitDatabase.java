package com.grnt.habbittrackertest01.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.grnt.habbittrackertest01.data.HabitDao;
import com.grnt.habbittrackertest01.data.HabitData;

@Database(entities = {HabitData.class}, version = 1)
public abstract class HabitDatabase extends RoomDatabase {
    public abstract HabitDao habitDao();
}
