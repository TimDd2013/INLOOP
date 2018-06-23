import junit.framework.Test;
import junit.textui.TestRunner;
import junit.framework.JUnit4TestAdapter;
// by FYICenter.com
public class T {
 public static void main (String[] args) {
   Test AppointeeTest = new JUnit4TestAdapter(AppointeeTest.class);
   System.out.println("AppointeeTest");
   TestRunner.run(AppointeeTest);
   Test EmployeeTest = new JUnit4TestAdapter(EmployeeTest.class);
   System.out.println("EmployeeTest");
   TestRunner.run(EmployeeTest);
   Test PayrollDBTest = new JUnit4TestAdapter(PayrollDBTest.class);
   System.out.println("PayrollDBTest");
   TestRunner.run(PayrollDBTest);
   Test PayrollDispositionImplTest = new JUnit4TestAdapter(PayrollDispositionImplTest.class);
   System.out.println("PayrollDispositionImplTest");
   TestRunner.run(PayrollDispositionImplTest);
   Test PayrollDispositionTest = new JUnit4TestAdapter(PayrollDispositionTest.class);
   System.out.println("PayrollDispositionTest");
   TestRunner.run(PayrollDispositionTest);
   Test UnpayableEmployeeExceptionTest = new JUnit4TestAdapter(UnpayableEmployeeExceptionTest.class);
   System.out.println("UnpayableEmployeeExceptionTest");
   TestRunner.run(UnpayableEmployeeExceptionTest);
   Test VolunteerTest = new JUnit4TestAdapter(VolunteerTest.class);
   System.out.println("VolunteerTest");
   TestRunner.run(VolunteerTest);
   Test PayrollTest = new JUnit4TestAdapter(PayrollTest.class);
   System.out.println("PayrollTest");
   TestRunner.run(PayrollTest);
 }
}