/**
 * Bid
 */

import java.util.*;
public class Bid {
    private Person bidder;
    private long price;
    public Bid(Person bidder,long price){
        if(bidder==null) throw new NullPointerException();
        if (price<=0) throw new IllegalArgumentException();
        this.price=price;
        this.bidder=bidder;
    }
    /**
     * @return the bidder
     */
    public Person getBidder() {
        return bidder;
    }
    /**
     * @return the price
     */
    public long getPrice() {
        return price;
    }
    @Override
    public String toString() {
        return price+" EUR by "+bidder.getName();
    }
    
}