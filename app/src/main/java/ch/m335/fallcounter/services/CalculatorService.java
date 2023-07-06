package ch.m335.fallcounter.services;

import java.time.LocalDate;
import java.util.List;

import ch.m335.fallcounter.model.DailyEntry;

public class CalculatorService {
    DataHandler dataHandler;
    public CalculatorService() {
        dataHandler = DataHandler.getDataHandler();
    }

    public int getSum(LocalDate date1, LocalDate date2){
        List<DailyEntry> entries = dataHandler.readAllEntries();
        int sum=0;
        int indexFirst=0;
        int indexLast=entries.size();
        for (int i = 0; i < entries.size(); i++) {
            if (date1.equals(entries.get(i).getDate())){
                indexFirst=i;
            }
            if (date2.equals(entries.get(i).getDate())){
                indexLast=i;
            }
        }

        for (int i = indexLast; i < indexLast; i++) {
            sum+=entries.get(i).getCounter();
        }
        return sum;
    }
}
