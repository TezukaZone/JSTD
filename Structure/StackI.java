package JSTD.Structure;

/**
 *
 * @author Philip
 */
public interface StackI<E> {
    
    E Top();
    
    void push(E value);
    
    E pop();
    
    boolean isEmpty();
    
    void clear();
    
    @Override
    public String toString();
    
    public StackI<E> clone();
    
    public java.util.List<E> toArray();
}
