/**
 * PredicateEndsWith
 */
public class PredicateEndsWith<T extends String> implements Predicate<T> {
    @Override
    public boolean predicate(T element, T argument) {
        if (argument==null||element==null) return false;
        return element.endsWith(argument);
    }
}