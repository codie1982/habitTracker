package com.grnt.habbittrackertest01.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "habit_tracker")
public class HabitData {

    @PrimaryKey(autoGenerate = true)
    private int uid;
    @ColumnInfo(name = "habit_name")
    private String habit_name;

}
