package com.grnt.habbittrackertest01.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "time_intervals")
public class TimeIntervalsData {

    @PrimaryKey(autoGenerate = true)
    public int uid;
    @ColumnInfo(name = "time_interval_name")
    public String name;
    @ColumnInfo(name = "start_hour")
    public long start_hour;
    @ColumnInfo(name = "start_minute")
    public long start_minute;
    @ColumnInfo(name = "end_hour")
    public long end_hour;

    @ColumnInfo(name = "end_minute")
    public long end_minute;

    public TimeIntervalsData() {
    }





}
