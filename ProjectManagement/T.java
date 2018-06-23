import junit.framework.Test;
import junit.textui.TestRunner;
import junit.framework.JUnit4TestAdapter;
// by FYICenter.com
public class T {
 public static void main (String[] args) {
   Test DeliverableTest = new JUnit4TestAdapter(DeliverableTest.class);
   System.out.println("DeliverableTest");
   TestRunner.run(DeliverableTest);
   Test TaskTest = new JUnit4TestAdapter(TaskTest.class);
   System.out.println("TaskTest");
   TestRunner.run(TaskTest);
   Test ProjectItemTest = new JUnit4TestAdapter(ProjectItemTest.class);
   System.out.println("ProjectItemTest");
   TestRunner.run(ProjectItemTest);
   Test ProjectTest = new JUnit4TestAdapter(ProjectTest.class);
   System.out.println("ProjectTest");
   TestRunner.run(ProjectTest);
   Test IProjectTest = new JUnit4TestAdapter(IProjectTest.class);
   System.out.println("IProjectTest");
   TestRunner.run(IProjectTest);
   Test AdapterTest = new JUnit4TestAdapter(AdapterTest.class);
   System.out.println("AdapterTest");
   TestRunner.run(AdapterTest);
   /*
   */
 }
}