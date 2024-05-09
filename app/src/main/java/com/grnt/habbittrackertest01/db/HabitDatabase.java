package com.grnt.habbittrackertest01.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.grnt.habbittrackertest01.data.HabitDao;
import com.grnt.habbittrackertest01.data.HabitData;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Database(entities = {HabitData.class}, version = 1)
public abstract class HabitDatabase extends RoomDatabase {
    public abstract HabitDao habitDao();
    private static volatile HabitDatabase INSTANCE;
    public static HabitDatabase getInstance(Context context){
        if(INSTANCE == null){
            synchronized (HabitDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context,
                            HabitDatabase.class, "habit-traker-db").allowMainThreadQueries().build();
                }
            }
        }
        return INSTANCE;
    }
}
