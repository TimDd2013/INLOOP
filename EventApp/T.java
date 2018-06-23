import junit.framework.Test;
import junit.textui.TestRunner;
import junit.framework.JUnit4TestAdapter;
// by FYICenter.com
public class T {
 public static void main (String[] args) {
   Test TimeTest = new JUnit4TestAdapter(TimeTest.class);
   System.out.println("TimeTest");
   TestRunner.run(TimeTest);
   Test EventCategoryTest = new JUnit4TestAdapter(EventCategoryTest.class);
   System.out.println("EventCategoryTest");
   TestRunner.run(EventCategoryTest);
   Test EventTest = new JUnit4TestAdapter(EventTest.class);
   System.out.println("EventTest");
   TestRunner.run(EventTest);
   Test EventCatalogTest = new JUnit4TestAdapter(EventCatalogTest.class);
   System.out.println("EventCatalogTest");
   TestRunner.run(EventCatalogTest);
   Test EventCatalogImplTest = new JUnit4TestAdapter(EventCatalogImplTest.class);
   System.out.println("EventCatalogImplTest");
   TestRunner.run(EventCatalogImplTest);
 }
}