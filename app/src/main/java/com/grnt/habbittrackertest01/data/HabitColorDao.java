package com.grnt.habbittrackertest01.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface HabitColorDao {

    @Query("SELECT * FROM habit_colors_table")
    List<HabitColorData> getHabitColors();

    @Insert
    void insertHabitColor(HabitColorData data);

    @Query("DELETE FROM habit_colors_table")
    void clearAllData();
}
