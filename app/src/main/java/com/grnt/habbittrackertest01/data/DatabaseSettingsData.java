package com.grnt.habbittrackertest01.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "databasesettings")
public class DatabaseSettingsData {

    @PrimaryKey(autoGenerate = true)
    public int uid;
    @ColumnInfo(name = "setup", defaultValue = "false")
    public Boolean isSetup;
}
