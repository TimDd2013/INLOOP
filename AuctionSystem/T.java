import junit.framework.Test;
import junit.textui.TestRunner;
import junit.framework.JUnit4TestAdapter;
// by FYICenter.com
public class T {
 public static void main (String[] args) {
   Test BidTest = new JUnit4TestAdapter(BidTest.class);
   System.out.println("BidTest");
   TestRunner.run(BidTest);
   Test ItemTest = new JUnit4TestAdapter(ItemTest.class);
   System.out.println("ItemTest");
   TestRunner.run(ItemTest);
   Test PersonTest = new JUnit4TestAdapter(PersonTest.class);
   System.out.println("PersonTest");
   TestRunner.run(PersonTest);
   Test AuctionTest = new JUnit4TestAdapter(AuctionTest.class);
   System.out.println("AuctionTest");
   TestRunner.run(AuctionTest);
   Test AllPayAuctionTest = new JUnit4TestAdapter(AllPayAuctionTest.class);
   System.out.println("AllPayAuctionTest");
   TestRunner.run(AllPayAuctionTest);
   Test EnglishAuctionTest = new JUnit4TestAdapter(EnglishAuctionTest.class);
   System.out.println("EnglishAuctionTest");
   TestRunner.run(EnglishAuctionTest);
  }
}