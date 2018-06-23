import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * PredicateIterator
 */
public class PredicateIterator<T extends String> implements Iterator<T> {
    private Predicate<T> pred;
    private Iterator<T> iter;
    private T argument;
    private boolean onoff;
    private T next;

    public PredicateIterator(Iterator<T> iter, Predicate<T> pred, T argument) {
        this.pred = pred;
        this.iter = iter;
        this.argument = argument;
        onoff = false;
    }

    public boolean hasNext() {
        if (onoff == false) {
            while(iter.hasNext()) {
                next = iter.next();
                if (pred.predicate(next, argument)) {
                    onoff = true;
                    return true;
                }
            }
            return false;
        } else {
            return true;
        }
    }

    public T next() {
        if (hasNext() == true && onoff == true) {
            onoff = false;
            return next;
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}