
/**
 * JIdeaPool
 */
import java.util.*;

public class JIdeaPool {
    private Map<JTopic, Set<JIdea>> pool;

    public JIdeaPool() {
        pool = new HashMap<JTopic, Set<JIdea>>();
    }

    public void add(JTopic topic) {
        if (topic == null)
            throw new NullPointerException();
        if (!pool.containsKey(topic))
            pool.put(topic, new HashSet<JIdea>());
    }

    public void add(JIdea idea, JTopic topic) {
        if (topic == null || idea == null)
            throw new NullPointerException();
        Set<JIdea> re = new HashSet<JIdea>();
        re.add(idea);
        for (JTopic key : pool.keySet()) {
            if(pool.get(key).contains(idea)){
                if (pool.containsKey(topic)){
                    pool.get(topic).add(idea);
                    return;
                }
                if(!pool.containsKey(topic)){
                    pool.put(topic, re);
                    return;
                }
            }
        }
        if (null!=getIdea(idea.getTitle())){
            return;
        }
        if (pool.containsKey(topic)){
            pool.get(topic).add(idea);
            return;
        }
        if(!pool.containsKey(topic)){
            pool.put(topic, re);
            return;
        }
        /*
        if (pool.containsKey(topic)) {
            if (getIdea(idea.getTitle())!=null){
                return;
            }
            pool.get(topic).add(idea);
        }
        else if (!pool.containsKey(topic)){
            for (JTopic key : pool.keySet()) {
                for (JIdea i : pool.get(key)) {
                    if (idea.equals(i))
                        pool.put(topic, re);
                        return;
                }
            }
            if (getIdea(idea.getTitle())!=null){
                return;
            }
            pool.put(topic, re);
        }
        */
    }

    public boolean remove(JTopic topic) {
        if (topic == null)
            throw new NullPointerException();
        if (!pool.containsKey(topic))
            return false;
        else {
            pool.remove(topic);
            return true;
        }
    }

    public boolean remove(JIdea idea) {
        boolean result=false;
        if (idea == null)
            throw new NullPointerException();
        for (Set<JIdea> ji : pool.values()) {
            if (ji.contains(idea)){
                ji.remove(idea);
                result=true;
            }
        }
        return result;
    }

    public JIdea getIdea(String title) {
        if (title == null)
            throw new NullPointerException();
        if (title == "")
            throw new IllegalArgumentException();
        for (Set<JIdea> ji : pool.values()) {
            for (JIdea i : ji) {
                if (i.getTitle().equals(title))
                    return i;
            }
        }
        return null;
    }

    public int numberOfTopics() {
        return pool.size();
    }

    public int numberOfIdeas() {
        Set<JIdea> result = new HashSet<JIdea>();
        for (JTopic key: pool.keySet()) {
            for (JIdea i : pool.get(key)) {
                result.add(i);
            }
        }
        return result.size();
    }

    /**
     * @return the pool
     */
    public Map<JTopic, Set<JIdea>> getPool() {
        return pool;
    }

    public void removeDeclined() {
        Map<JTopic, Set<JIdea>> result=new HashMap<JTopic, Set<JIdea>>();
        for (JTopic key : pool.keySet()) {
            Set<JIdea> re=new HashSet<JIdea>();
            for (JIdea i : pool.get(key)) {
                if(!i.isDeclined()){
                    re.add(i);
                }
            }
            result.put(key, re);
        }
        pool=result;
    }

    public void removeReleased() {
        Map<JTopic, Set<JIdea>> result=new HashMap<JTopic, Set<JIdea>>();
        for (JTopic key : pool.keySet()) {
            Set<JIdea> re=new HashSet<JIdea>();
            for (JIdea i : pool.get(key)) {
                if(!i.isReleased()){
                    re.add(i);
                }
            }
            result.put(key, re);
        }
        pool=result;
    }
}