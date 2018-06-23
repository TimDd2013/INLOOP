/**
 * PredicateLength
 */
public class PredicateLength<T extends String> implements Predicate<T> {
    @Override
    public boolean predicate(T element, T argument) {
        if (argument==null||element==null) return false;
        return (element.length()==Integer.parseInt(argument));
    }
}