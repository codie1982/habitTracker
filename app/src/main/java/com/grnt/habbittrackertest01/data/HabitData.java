package com.grnt.habbittrackertest01.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.PrimaryKey;

@Entity(tableName = "habit")
public class HabitData {

    @PrimaryKey(autoGenerate = true)
    public int uid;
    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "description")
    public String description;
    @ColumnInfo(name = "habit_type")
    public Integer habitType;
    @ColumnInfo(name = "habit_color")
    public String habitColor;
    @ColumnInfo(name = "date_created")
    public Long dateCreated;
    @ColumnInfo(name = "date_updated")
    public Long dateUpdated;
    @ColumnInfo(name = "date_completed")
    public Long dateCompleted;
    @ColumnInfo(name="deleted")
    public Boolean deleted;
    @ColumnInfo(name = "date_deleted")
    public Long dateDeleted;

    public HabitData() {
    }





}
