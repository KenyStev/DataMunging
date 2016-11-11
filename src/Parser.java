
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser {

    private String delimiters;

    public Parser(String delimiters) {
        this.delimiters=delimiters;
    }

    public ArrayList<String[]> parseTable(String pathfile) throws FileNotFoundException {
        ArrayList<String[]> rows = new ArrayList<>();
        Scanner scan = new Scanner(new File(pathfile));
        String row;

        while (scan.hasNext()) {
            row = scan.nextLine();
            String []parsedRow;
            try {
                parsedRow = parseRow(row);
                for (String col : parsedRow) {System.out.println(col);}
                rows.add(parsedRow);
            } catch (RowNoValidException ex) {}
        }
        return rows;
    }
    
    public String[] parseRow(String row) throws RowNoValidException {
        String []parsedRow = row.split("["+delimiters+"]+");
        try {
            Integer.parseInt(parsedRow[1]);
        } catch (NumberFormatException e) {
            throw new RowNoValidException(row);
        }catch(ArrayIndexOutOfBoundsException e){
            throw new RowNoValidException(row);
        }
        return parsedRow;
    }
    
}
