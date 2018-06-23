/**
 * Item
 */
import java.util.*;
public class Item {
    private String name;
    private String description;
    private long minPrice;
    private List<Bid> allBids;
    private Bid highestBid;
    public Item(String name,String description,long minPrice){
        if (name==null||description==null) throw new NullPointerException();
        if (minPrice<=0||name==""||description=="") throw new IllegalArgumentException();
        this.name=name;
        this.description=description;
        this.minPrice=minPrice;
        allBids=new ArrayList<Bid>();
    }
    public void addBid(Person bidder,long price){
        if (bidder==null) throw new NullPointerException();
        if (price<=0) throw new IllegalArgumentException();
        if (price<minPrice) return;
        if (highestBid==null){
            highestBid=new Bid(bidder, price);
            allBids.add(highestBid);
        }else if(price>highestBid.getPrice()){
            highestBid=new Bid(bidder, price);   
            allBids.add(highestBid);
        }
        
    }
    /**
     * @return the allBids
     */
    public List<Bid> getAllBids() {
        return allBids;
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }
    /**
     * @return the highestBid
     */
    public Bid getHighestBid() {
        return highestBid;
    }
    @Override
    public String toString() {
        return name+": "+description+" (minimum bidding price: "+minPrice+" EUR)";
    }
}