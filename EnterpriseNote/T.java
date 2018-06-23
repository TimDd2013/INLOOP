import junit.framework.Test;
import junit.textui.TestRunner;
import junit.framework.JUnit4TestAdapter;
// by FYICenter.com
public class T {
 public static void main (String[] args) {
   Test AbstractUnitTest = new JUnit4TestAdapter(AbstractUnitTest.class);
   System.out.println("AbstractUnitTest");
   TestRunner.run(AbstractUnitTest);
   Test AbstractEnterpriseUnitTest = new JUnit4TestAdapter(AbstractEnterpriseUnitTest.class);
   System.out.println("AbstractEnterpriseUnitTest");
   TestRunner.run(AbstractEnterpriseUnitTest);
   Test StaffMemberTest = new JUnit4TestAdapter(StaffMemberTest.class);
   System.out.println("StaffMemberTest");
   TestRunner.run(StaffMemberTest);
   Test StaffMemberIteratorTest = new JUnit4TestAdapter(StaffMemberIteratorTest.class);
   System.out.println("StaffMemberIteratorTest");
   TestRunner.run(StaffMemberIteratorTest);
   Test TeamTest = new JUnit4TestAdapter(TeamTest.class);
   System.out.println("TeamTest");
   TestRunner.run(TeamTest);
 }
}