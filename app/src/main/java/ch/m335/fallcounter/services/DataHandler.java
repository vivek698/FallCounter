package ch.m335.fallcounter.services;

import android.content.SharedPreferences;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ch.m335.fallcounter.model.DailyEntry;


public class DataHandler {
    private static DataHandler dataHandler;
    SharedPreferences sharedPreferences;

    public DataHandler(SharedPreferences sharedP) {
        sharedPreferences = sharedP;
    }

    public static DataHandler getDataHandler(){
        return dataHandler;
    }

    public DataHandler getDataHandler(SharedPreferences sharedP){
        return dataHandler;
    }

    public void incrementCounter(){
        String date = LocalDate.now().toString();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (!sharedPreferences.contains(date)){
            editor.putInt(date,0);
            editor.apply();
        }else {
            int counter = sharedPreferences.getInt(date, 0);
            editor.putInt(date,counter + 1);
            editor.apply();
        }
    }

    public List<DailyEntry> readAllEntries(){
        Map<String, ?> allData= sharedPreferences.getAll();
        List<DailyEntry> entryList = new ArrayList();

        for (Map.Entry <String,?> entry: allData.entrySet()) {
            int counter = (int)entry.getValue();
            LocalDate date = LocalDate.parse(entry.getKey());

            entryList.add(new DailyEntry(counter, date));
        }

        return entryList;
    }
}
