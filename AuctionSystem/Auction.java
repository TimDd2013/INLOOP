/**
 * Auction
 */
import java.util.*;
public class Auction {
    private int nextItem=1;
    private boolean closed=false;
    private List<Person> bidders;
    private List<Item> allItems;
    public Auction(){
        bidders=new ArrayList<Person>();
        allItems=new ArrayList<Item>();
    }
    public void addBid(String itemName,String nameOfBidder,long price){
        boolean onoff=false;
        if(closed==true) throw new IllegalStateException();
        if(itemName==null||nameOfBidder==null) throw new NullPointerException();
        if(price<=0||itemName==""||nameOfBidder=="") throw new IllegalArgumentException();
        for(Item i:allItems){
            if(i.getName().equals(itemName)){
                onoff=true;
                i.addBid(new Person(nameOfBidder), price);
            }
        }
        if (onoff==false) throw new NoSuchElementException();
        bidders.add(new Person(nameOfBidder));
    }
    public String closeAuction(){
        if (closed==true) throw new IllegalStateException();
        closed=true;
        return generateItemListString();
    }
    public String generateAllBidsString(Item item){
        if (item==null) throw new NullPointerException();
        String a="All bids:";
        for(Bid b:item.getAllBids()){
            a+="\n"+b.toString();
        }
        return a;
    }
    public String generateItemListString(){
        return allItems.toString();
    }
    public void registerItem(Item item){
        if (item==null) throw new NullPointerException();
        if(closed==true) throw new IllegalStateException();
        for(Item i:allItems){ if(item.getName().equals(i.getName())) throw new IllegalArgumentException();}
        allItems.add(item);
    }
    public String generateItemString(Item item){
        return item.toString();
    }
    public List<Item> getAllItems(){
        return allItems;
    }
    
}