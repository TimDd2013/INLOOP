import java.util.Map;
import java.util.Set;

/**
 * EventCatalogImpl
 */
import java.util.*;

public class EventCatalogImpl extends TreeMap<Event, Set<Time>> implements EventCatalog {
    @Override
    public boolean addCatalogEntry(Event e, Set<Time> tSet) {
        if (e == null || tSet.contains(null) || tSet == null)
            throw new NullPointerException();
        if (super.containsKey(e))
            return false;
        super.put(e, tSet);
        return true;
    }

    @Override
    public boolean addTimeToEvent(Event e, Time t) {
        if (e == null || t == null)
            throw new NullPointerException();
        if (super.containsKey(e)) {
            if (super.get(e).contains(t)) {
                return false;
            }
            ;
            super.get(e).add(t);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Set<Event> getAllEvents() {
        return super.keySet();
    }

    @Override
    public Set<Time> getTimesOfEvent(Event e) {
        if (e == null)
            throw new NullPointerException();
        return super.get(e);
    }

    @Override
    public Map<Event, Set<Time>> filterByEventCategory(EventCategory category) {
        if (category==null) throw new NullPointerException();
        Map<Event, Set<Time>> result=new HashMap<Event, Set<Time>>();
        for(Event key:this.keySet()){
            if (key.getCategory().equals(category)){
                result.put(key,this.get(key));
            }
        }
        return result;
    }

    @Override
    public Set<Time> deleteEvent(Event e) {
        if (e == null)
            throw new NullPointerException();
        return super.remove(e);
    }

    @Override
    public boolean deleteTime(Event e, Time t) {
        if (e == null || t == null)
            throw new NullPointerException();
        if (super.containsKey(e)) {
            if (super.get(e).contains(t)) {
                super.get(e).remove(t);
                return true;
            }
            return false;
        } else {
            return false;
        }
    }
}
