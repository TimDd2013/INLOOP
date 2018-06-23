import java.awt.Point;
import java.util.*;

/**
 * MyMatrix
 */
public class MyMatrix<T> implements Matrix<T>{
    private Map<Point,T> matrixEntries;
    private int numberRows;
    private int numberColumns;
    public MyMatrix(){
        matrixEntries=new HashMap<Point,T>();
        numberColumns=0;
        numberRows=0;
    }
    @Override
    public int getRowCount() {
        return numberRows;
    }
    @Override
    public int getColumnCount() {
        return numberColumns;
    }
    @Override
    public int getObjectCount() {
        return matrixEntries.size();
    }
    @Override
    public int getDistinctObjectCount() {
        //>>>to do
        Set s=new HashSet(matrixEntries.values());
        return s.size();
    }
    @Override
    public T get(int row, int column) {
        if (row>numberRows-1||column>numberColumns-1) throw new IllegalArgumentException();
        if (!matrixEntries.containsKey(new Point(row,column)))  return null;
        return matrixEntries.get(new Point(row, column));
    }
    @Override
    public boolean contains(T value) {
        return matrixEntries.values().contains(value);
    }
    @Override
    public T put(int row, int column, T value) {
        if (row>=this.numberRows-1) this.numberRows=row+1;
        if (column>=this.numberColumns-1) this.numberColumns=column+1;
        T a=this.get(row, column);
        matrixEntries.put(new Point(row,column), value);
        return a;
    }
    public Iterator<T> iterator(){
        return new DepthFirstIterator();
    }
    class DepthFirstIterator implements Iterator<T>{
        int x,y;
        T next;
        public DepthFirstIterator(){
            x=0;
            y=0;
            next=null;
        }
        public void remove(){
            throw new UnsupportedOperationException();
        }
        public T next(){
            if (hasNext()==false) throw new NoSuchElementException();
            x++;
            return next;
        }
        public boolean hasNext(){
            List<Point> li=new ArrayList<Point>();
            for(int i=0;i<numberColumns;i++){
                for(int j=0;j<numberRows;j++){
                    if(get(j, i)!=null){
                        li.add(new Point(j,i));
                        //System.out.println("x="+j+" y="+i);
                    }
                }
            }
            if (x<li.size()){
                next=get(li.get(x).x,li.get(x).y);
                return true;
            }
            return false;
        }
    }
}