import junit.framework.Test;
import junit.textui.TestRunner;
import junit.framework.JUnit4TestAdapter;
// by FYICenter.com
public class T {
 public static void main (String[] args) {
   Test ComponentsTest = new JUnit4TestAdapter(ComponentsTest.class);
   System.out.println("ComponentsTest");
   TestRunner.run(ComponentsTest);
   Test FactoryTest = new JUnit4TestAdapter(FactoryTest.class);
   System.out.println("FactoryTest");
   TestRunner.run(FactoryTest);
   Test ObservationTest = new JUnit4TestAdapter(ObservationTest.class);
   System.out.println("ObservationTest");
   TestRunner.run(ObservationTest);
   Test PartTest = new JUnit4TestAdapter(PartTest.class);
   System.out.println("PartTest");
   TestRunner.run(PartTest);
   Test PartTypeTest = new JUnit4TestAdapter(PartTypeTest.class);
   System.out.println("PartTypeTest");
   TestRunner.run(PartTypeTest);
   Test PurchasingTest = new JUnit4TestAdapter(PurchasingTest.class);
   System.out.println("PurchasingTest");
   TestRunner.run(PurchasingTest);
   Test ReceivingStockTest = new JUnit4TestAdapter(ReceivingStockTest.class);
   System.out.println("ReceivingStockTest");
   TestRunner.run(ReceivingStockTest);
   Test ResourceTest = new JUnit4TestAdapter(ResourceTest.class);
   System.out.println("ResourceTest");
   TestRunner.run(ResourceTest);
   Test SingleComponentTest = new JUnit4TestAdapter(SingleComponentTest.class);
   System.out.println("SingleComponentTest");
   TestRunner.run(ResourceTest);
   Test StockTest = new JUnit4TestAdapter(StockTest.class);
   System.out.println("StockTest");
   TestRunner.run(StockTest);
 }
}