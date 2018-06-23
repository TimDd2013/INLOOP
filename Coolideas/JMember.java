/**
 * JMember
 */
import java.util.*;
import java.util.concurrent.Flow.Subscriber;
public class JMember implements Observer{
    private Set<JTopic> topics=new HashSet<JTopic>();
    public void subscribe(JTopic topic){
        if (topic==null) throw new NullPointerException();
        topics.add(topic);
        topic.addObserver(this);
    }
    public void unsubscribe(JTopic topic){
        if (topic==null) throw new NullPointerException();
        topic.deleteObserver(this);
        topics.remove(topic);
    }
    @Override
    public void update(Observable arg0, Object arg1) {
        System.out.println("The topic "+arg1.toString()+" has been updated!");
    }
    /**
     * @return the topics
     */
    public Set<JTopic> getSubscribedTopics() {
        return topics;
    }
}