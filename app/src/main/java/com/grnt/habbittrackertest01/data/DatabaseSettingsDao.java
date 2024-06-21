package com.grnt.habbittrackertest01.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface DatabaseSettingsDao {
    @Query("SELECT * FROM databasesettings ORDER BY uid DESC LIMIT 1")
    DatabaseSettingsData getDBSetup();

    @Insert
    void insertDatabaseSetup(DatabaseSettingsData data);

    @Query("UPDATE databasesettings SET setup = :isSetup")
    void updateDatabaseSetup(Boolean isSetup);
}
