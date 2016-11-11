
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataMunging {
    private RowSelector rowSelector;
    private final Indexes indexes;

    public DataMunging(RowSelector rowSelector,Indexes indexes) {
        this.rowSelector = rowSelector;
        this.indexes = indexes;
    }

    public Object[] smallest(String pathfile, Type type) throws FileNotFoundException {
        ArrayList<String[]> parsed = parse(pathfile);
        ArrayList<FilteredData> dataList = new ArrayList<>();
        for (String[] row : parsed) {
            FilteredData data = FilteredData.generateData(row, indexes,type);
            dataList.add(data);
        }
        
        return FilteredData.mins(dataList);
    }

    private ArrayList<String[]> parse(String pathfile) throws FileNotFoundException { //, int getCol, int max, int min
        ArrayList<String[]> rows = new ArrayList<>();
        Scanner scan = new Scanner(new File(pathfile));
        String row;

        while (scan.hasNext()) {
            row = scan.nextLine();
            String []parsedRow;
            try {
                parsedRow = rowSelector.getRow(row);
                for (String col : parsedRow) {System.out.println(col);}
                rows.add(parsedRow);
            } catch (RowNoValidException ex) {}
        }
        return rows;
    }
    
}
