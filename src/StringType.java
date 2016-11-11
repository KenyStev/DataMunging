public class StringType implements Type {

    @Override
    public Object getValue(String value) {
        return value;
    }
    
}
