package com.grnt.habbittrackertest01.data;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface HabitDao {
    @Query("SELECT * FROM habit_tracker")
    List<HabitData> getAll();
}
