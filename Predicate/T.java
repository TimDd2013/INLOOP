import junit.framework.Test;
import junit.textui.TestRunner;
import junit.framework.JUnit4TestAdapter;
// by FYICenter.com
public class T {
 public static void main (String[] args) {
   Test PredicateTest = new JUnit4TestAdapter(PredicateTest.class);
   System.out.println("PredicateTest");
   TestRunner.run(PredicateTest);
   Test PredicateEndsWithTest = new JUnit4TestAdapter(PredicateEndsWithTest.class);
   System.out.println("PredicateEndsWithTest");
   TestRunner.run(PredicateEndsWithTest);
   Test PredicateStartsWithTest = new JUnit4TestAdapter(PredicateStartsWithTest.class);
   System.out.println("PredicateStartsWithTest");
   TestRunner.run(PredicateStartsWithTest);
   Test PredicateLengthTest = new JUnit4TestAdapter(PredicateLengthTest.class);
   System.out.println("PredicateLengthTest");
   TestRunner.run(PredicateLengthTest);
   Test PredicateIteratorTest = new JUnit4TestAdapter(PredicateIteratorTest.class);
   System.out.println("PredicateIteratorTest");
   TestRunner.run(PredicateIteratorTest);
 }
}