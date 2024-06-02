package com.grnt.habbittrackertest01.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TimeIntervalsDao {

    @Query("SELECT * FROM time_intervals")
    List<TimeIntervalsData> getTimeIntervals();

    @Insert
    void insertTimeIntervals(TimeIntervalsData data);

    @Query("DELETE FROM time_intervals")
    void clearAllData();
}
