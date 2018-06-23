import junit.framework.Test;
import junit.textui.TestRunner;
import junit.framework.JUnit4TestAdapter;
// by FYICenter.com
public class T {
 public static void main (String[] args) {
   Test VehicleTest = new JUnit4TestAdapter(VehicleTest.class);
   System.out.println("VehicleTest");
   TestRunner.run(VehicleTest);
   Test VehicleGeneratorTest = new JUnit4TestAdapter(VehicleGeneratorTest.class);
   System.out.println("VehicleGeneratorTest");
   TestRunner.run(VehicleGeneratorTest);
   Test TimeTest = new JUnit4TestAdapter(TimeTest.class);
   System.out.println("TimeTest");
   TestRunner.run(TimeTest);
   Test VehicleQueueTest = new JUnit4TestAdapter(VehicleQueueTest.class);
   System.out.println("VehicleQueueTest");
   TestRunner.run(VehicleQueueTest);
   /*
   Test SaleTest = new JUnit4TestAdapter(SaleTest.class);
   System.out.println("SaleTest");
   TestRunner.run(SaleTest);
   */
 }
}