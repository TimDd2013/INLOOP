/**
 * Predicate
 */
public interface Predicate<T extends String> {
    public boolean predicate(T element,T argument);
}