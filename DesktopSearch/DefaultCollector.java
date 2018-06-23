import java.util.*;

/**
 * DefaultCollector
 */
public class DefaultCollector implements KeywordCollector{
    @Override
    public Set<String> getKeywords(Resource res) {
        Set<String> result=new HashSet<String>();
        result.add(res.getName());
        return result;
    }
}