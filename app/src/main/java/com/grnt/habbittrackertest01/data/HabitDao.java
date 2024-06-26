package com.grnt.habbittrackertest01.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface HabitDao {
    @Query("SELECT * FROM habit")
    List<HabitData> getAll();

    @Insert
    void insertNewHabit(HabitData data);
}
