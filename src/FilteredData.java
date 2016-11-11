
import java.util.ArrayList;
import java.util.Collections;

public class FilteredData implements Comparable<FilteredData>{

    public final Object colDay;
    public final int diference;
    
    public FilteredData(Object colDay, int diff) {
        this.colDay=colDay;
        this.diference=diff;
    }
    
    public static FilteredData generateData(String[] row, Indexes indexes, Type type) {
        return new FilteredData(type.getValue(row[indexes.colVal]),dif(row,indexes));
    }
    
    private static int dif(String[] row, Indexes indexes) {
        return Integer.parseInt(row[indexes.max]) - Integer.parseInt(row[indexes.min]);
    }
    
    public static Object[] mins(ArrayList<FilteredData> data) {
        Collections.sort(data);
        
        ArrayList<Object> mins = new ArrayList<>();
        
        for (FilteredData day : data) {
            if(data.get(0).colDay.equals(day.colDay))
                mins.add(day.colDay);
        }
        return mins.toArray();
    }

    @Override
    public int compareTo(FilteredData o) {
        return (diference<o.diference)?-1:(diference==o.diference)?0:1;
    }
    
}
