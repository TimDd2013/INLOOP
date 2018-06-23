import junit.framework.Test;
import junit.textui.TestRunner;
import junit.framework.JUnit4TestAdapter;
// by FYICenter.com
public class T {
 public static void main (String[] args) {
   Test MatrixTest = new JUnit4TestAdapter(MatrixTest.class);
   System.out.println("MatrixTest");
   TestRunner.run(MatrixTest);
   Test MyMatrixTest = new JUnit4TestAdapter(MyMatrixTest.class);
   System.out.println("MyMatrixTest");
   TestRunner.run(MyMatrixTest);
 }
}