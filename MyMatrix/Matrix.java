import java.util.Iterator;

/**
 * Matrix
 */
public interface Matrix<T> {
    public int getRowCount();
    public int getColumnCount();
    public int getObjectCount();
    public int getDistinctObjectCount();
    public Iterator<T> iterator();
    public T get(int row,int column);
    public T put(int row,int column,T value);
    public boolean contains(T value);
}