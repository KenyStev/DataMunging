
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;
import sun.reflect.generics.tree.Tree;

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
    private String delimiters;

    public DataMunging(RowSelector rowSelector) {
        this.delimiters = " ";
        this.rowSelector = rowSelector;
    }
    
    void setDelimiters(String deliliters) {
        this.delimiters = delimiters;
    }

    public int[] weather(String pathfile) throws FileNotFoundException {
        return parse(pathfile,1,2,3);
    }

    private int[] parse(String pathfile, int getCol, int max, int min) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(pathfile));
        String row;
        TreeSet<Day> days = new TreeSet<>();
        while (scan.hasNext()) {
            row = scan.nextLine();
            String []parsedRow = row.split("["+delimiters+"]+");
            try {
                Integer.parseInt(parsedRow[1]);
            } catch (NumberFormatException e) {
                continue;
            }catch(ArrayIndexOutOfBoundsException e){
                continue;
            }
            for (String col : parsedRow) {
                System.out.println(col);
            }
            if(rowSelector.isRowValid(row)){
                Day day = Day.generateDay(row,getCol,max,min);
                days.add(day);
            }
        }
        
        
        return new int[]{2};
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        DataMunging dm = new DataMunging(null);
//        dm.parse("weather.dat", 1, 2, 3);
        dm.parse("football.dat", 1, 2, 3);
    }
    
}
