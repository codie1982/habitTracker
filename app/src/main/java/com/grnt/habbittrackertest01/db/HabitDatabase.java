package com.grnt.habbittrackertest01.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.grnt.habbittrackertest01.R;
import com.grnt.habbittrackertest01.data.DatabaseSettingsDao;
import com.grnt.habbittrackertest01.data.DatabaseSettingsData;
import com.grnt.habbittrackertest01.data.HabitDao;
import com.grnt.habbittrackertest01.data.HabitData;
import com.grnt.habbittrackertest01.data.TimeIntervalsDao;
import com.grnt.habbittrackertest01.data.TimeIntervalsData;
import com.grnt.habbittrackertest01.view.fragment.MainFragment;

import java.util.ArrayList;
import java.util.List;
@Database(entities = {HabitData.class, TimeIntervalsData.class, DatabaseSettingsData.class}, version = 1)
public abstract class HabitDatabase extends RoomDatabase {

    public abstract HabitDao habitDao();
    public abstract TimeIntervalsDao timeIntervalsDao();
    public abstract DatabaseSettingsDao dbSettingsDao();
    private static volatile HabitDatabase INSTANCE;
    public static HabitDatabase getInstance(Context context){
        if(INSTANCE == null){
            synchronized (HabitDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context,
                            HabitDatabase.class, "habit-traker-db").allowMainThreadQueries().build();
                }
            }
        }
        return INSTANCE;
    }

    public void initDatabase(Context context,Boolean isRestart) {
        if(isRestart){
            timeIntervalsDao().clearAllData();
            dbSettingsDao().updateDatabaseSetup(false);
        }
        DatabaseSettingsData _ds =dbSettingsDao().getDBSetup();

        if(_ds == null || _ds.isSetup == null || _ds.isSetup == false){
            List<TimeIntervalsData> _ls = new ArrayList<>();
            TimeIntervalsData _dtMorning = new TimeIntervalsData();
            _dtMorning.name = context.getString(R.string.morning);
            _dtMorning.start_hour = 6L;
            _dtMorning.start_minute = 0L;
            _dtMorning.end_hour = 8L;
            _dtMorning.end_minute = 59L;
            _ls.add(_dtMorning);

            TimeIntervalsData _dtNoon = new TimeIntervalsData();
            _dtNoon.name =context.getString(R.string.noon);
            _dtNoon.start_hour = 9L;
            _dtNoon.start_minute = 0L;
            _dtNoon.end_hour = 17L;
            _dtNoon.end_minute = 59L;
            _ls.add(_dtNoon);

            TimeIntervalsData _dtEvening = new TimeIntervalsData();
            _dtEvening.name = context.getString(R.string.evening);
            _dtEvening.start_hour = 18L;
            _dtEvening.start_minute = 0L;
            _dtEvening.end_hour = 23L;
            _dtEvening.end_minute = 59L;
            _ls.add(_dtEvening);

            TimeIntervalsData _dtNight = new TimeIntervalsData();
            _dtNight.name =context.getString(R.string.night);
            _dtNight.start_hour = 0L;
            _dtNight.start_minute = 0L;
            _dtNight.end_hour = 5L;
            _dtNight.end_minute = 59L;
            _ls.add(_dtNight);
            _ls.forEach(x->timeIntervalsDao().insertTimeIntervals(x));

            DatabaseSettingsData  nds = new DatabaseSettingsData();
            nds.isSetup = true;
            dbSettingsDao().insertDatabaseSetup(nds);
        }
    }
}
