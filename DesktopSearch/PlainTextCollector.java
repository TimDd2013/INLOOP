import java.util.*;

/**
 * PlainTextCollector
 */
public class PlainTextCollector implements KeywordCollector{
    @Override
    public Set<String> getKeywords(Resource res) {
        Set<String> result=new HashSet<String>();
        TextFileIterator a=new TextFileIterator(res);
        while (a.hasNext()){
            result.add(a.next());
        }
        return result;
    }
}