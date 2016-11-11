
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kenystev
 */
public class DataMunging {
    RowSelector rowSelector;

    public DataMunging(RowSelector rowSelector) {
        this.rowSelector = rowSelector;
    }

    public Object[] weather(String pathfile) throws FileNotFoundException {
        return parse(pathfile,1,2,3);
    }

    private Object[] parse(String pathfile, int getCol, int max, int min) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(pathfile));
        String row;
        ArrayList<Day> days = new ArrayList<>();
        while (scan.hasNext()) {
            row = scan.nextLine();
            String []parsedRow;
            try {
                parsedRow = rowSelector.getRow(row);
                for (String col : parsedRow) {
                    System.out.println(col);
                }
                Day day = Day.generateDay(parsedRow,getCol,max,min);
                days.add(day);
            } catch (RowNoValidException ex) {}
        }
        Collections.sort(days);
        ArrayList<Integer> dayNums = new ArrayList<>();
        
        for (Day day : days) {
            if(days.get(0).colDay==day.colDay)
                dayNums.add(day.colDay);
        }
        return dayNums.toArray();
    }

    public Object[] football(String footballdat) throws FileNotFoundException {
        return parse(footballdat, 2, 0, 0);
    }
    
}
