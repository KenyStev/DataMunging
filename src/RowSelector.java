public class RowSelector {

    private String delimiters;

    public RowSelector(String delimiters) {
        this.delimiters=delimiters;
    }

    public String[] getRow(String row) throws RowNoValidException {
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
