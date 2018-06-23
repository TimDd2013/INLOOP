/**
 * AllPayAuction
 */
public class AllPayAuction extends Auction{
    @Override
    public String generateItemListString() {
        String result="";
        for (Item i:super.getAllItems()){
            result+=i.toString()+"\n";
            if(i.getAllBids().size()==0){
                result+="No bids placed\n";
            }else{
                result+="Highest bid: "+i.getHighestBid().toString()+"\nAll bids:\n";
                for(Bid b:i.getAllBids()){
                    result+=b.toString()+"\n";
                }
            }
        }
        return result; 
    }
    @Override
    public String generateItemString(Item item) {
        String result="";
        result+=item.toString()+"\n";
        if(item.getAllBids().size()==0){
            result+="No bids placed";
        }else{
            result+="Highest bid: "+item.getHighestBid().toString()+"\nAll bids:\n";
            for(Bid b:item.getAllBids()){
                result+=b.toString();
            }
        }
        return result;
    }
}