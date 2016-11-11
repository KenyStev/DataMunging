public class Day implements Comparable<Day>{

    public final int colDay;
    public final int diference;
    
    public static Day generateDay(String[] parsedRow, int colVal, int max, int min) {
        int dif = Integer.parseInt(parsedRow[max]) - Integer.parseInt(parsedRow[min]);
        return new Day(Integer.parseInt(parsedRow[colVal]),dif);
    }

    public Day(int colDay, int diff) {
        this.colDay=colDay;
        this.diference=diff;
    }

    @Override
    public int compareTo(Day o) {
        return (diference<o.diference)?-1:(diference==o.diference)?0:1;
    }
    
}
