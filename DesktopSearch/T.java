import junit.framework.Test;
import junit.textui.TestRunner;
import junit.framework.JUnit4TestAdapter;
// by FYICenter.com

public class T {
 public static void main (String[] args) {
   Test DesktopSearchTest = new JUnit4TestAdapter(DesktopSearchTest.class);
   Test IndexTest = new JUnit4TestAdapter(IndexTest.class);
   Test KeywordCollectorTest = new JUnit4TestAdapter(KeywordCollectorTest.class);
   Test ResourceTest = new JUnit4TestAdapter(ResourceTest.class);
   Test ResourceTypeTest = new JUnit4TestAdapter(ResourceTypeTest.class);
   Test TextFileIteratorTest = new JUnit4TestAdapter(TextFileIteratorTest.class);
   System.out.println("DesktopSearchTest");
   TestRunner.run(DesktopSearchTest);
   System.out.println("IndexTest");
   TestRunner.run(IndexTest);
   System.out.println("KeywordCollectorTest");
   TestRunner.run(KeywordCollectorTest);
   System.out.println("ResourceTest");
   TestRunner.run(ResourceTest);
   System.out.println("ResourceTypeTest");
   TestRunner.run(ResourceTypeTest);
   System.out.println("TextFileIteratorTest");
   TestRunner.run(TextFileIteratorTest);
 }
}