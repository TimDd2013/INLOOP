import junit.framework.Test;
import junit.textui.TestRunner;
import junit.framework.JUnit4TestAdapter;
// by FYICenter.com
public class T {
 public static void main (String[] args) {
   Test MaterialTest = new JUnit4TestAdapter(MaterialTest.class);
   System.out.println("MaterialTest");
   TestRunner.run(MaterialTest);
   Test PaintTest = new JUnit4TestAdapter(PaintTest.class);
   System.out.println("PaintTest");
   TestRunner.run(PaintTest);
   Test FlooringTest = new JUnit4TestAdapter(FlooringTest.class);
   System.out.println("FlooringTest");
   TestRunner.run(FlooringTest);
   Test RenovationObjectTest = new JUnit4TestAdapter(RenovationObjectTest.class);
   System.out.println("RenovationObjectTest");
   TestRunner.run(RenovationObjectTest);
   Test SurfaceTest = new JUnit4TestAdapter(SurfaceTest.class);
   System.out.println("SurfaceTest");
   TestRunner.run(SurfaceTest);
   Test StructuredObjectTest = new JUnit4TestAdapter(StructuredObjectTest.class);
   System.out.println("StructuredObjectTest");
   TestRunner.run(StructuredObjectTest);
 }
}