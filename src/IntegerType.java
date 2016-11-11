public class IntegerType implements Type {

    @Override
    public Object getValue(String value) {
        return Integer.parseInt(value);
    }
    
}
