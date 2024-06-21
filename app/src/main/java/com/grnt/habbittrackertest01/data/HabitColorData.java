package com.grnt.habbittrackertest01.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "habit_colors_table")
public class HabitColorData {

    @PrimaryKey(autoGenerate = true)
    public int uid;
    @ColumnInfo(name = "hexcolor")
    public String color;

    public HabitColorData() {
    }
}
