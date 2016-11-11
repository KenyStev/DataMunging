
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DataMunging {
    private Parser parser;
    private final Indexes indexes;

    public DataMunging(Parser rowSelector,Indexes indexes) {
        this.parser = rowSelector;
        this.indexes = indexes;
    }

    public Object[] smallest(String pathfile, Type type) throws FileNotFoundException {
        ArrayList<String[]> parsed = parser.parseTable(pathfile);
        ArrayList<FilteredData> dataList = new ArrayList<>();
        for (String[] row : parsed) {
            FilteredData data = FilteredData.generateData(row, indexes,type);
            dataList.add(data);
        }
        
        return FilteredData.mins(dataList);
    }
    
}
