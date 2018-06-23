import junit.framework.Test;
import junit.textui.TestRunner;
import junit.framework.JUnit4TestAdapter;
// by FYICenter.com
public class T {
 public static void main (String[] args) {
   Test CardDrawingTest = new JUnit4TestAdapter(CardDrawingTest.class);
   System.out.println("CardDrawingTest");
   TestRunner.run(CardDrawingTest);
   Test VocabCardTest = new JUnit4TestAdapter(VocabCardTest.class);
   System.out.println("VocabCardTest");
   TestRunner.run(VocabCardTest);
   Test QuizDataTest = new JUnit4TestAdapter(QuizDataTest.class);
   System.out.println("QuizDataTest");
   TestRunner.run(QuizDataTest);
   Test QuizProcessTest = new JUnit4TestAdapter(QuizProcessTest.class);
   System.out.println("QuizProcessTest");
   TestRunner.run(QuizProcessTest);
   Test StateStartStateTest = new JUnit4TestAdapter(StateStartStateTest.class);
   System.out.println("StateStartStateTest");
   TestRunner.run(StateStartStateTest);
   Test StateAskingStateTest = new JUnit4TestAdapter(StateAskingStateTest.class);
   System.out.println("StateAskingStateTest");
   TestRunner.run(StateAskingStateTest);
   Test StateSolutionStateTest = new JUnit4TestAdapter(StateSolutionStateTest.class);
   System.out.println("StateSolutionStateTest");
   TestRunner.run(StateSolutionStateTest);
   Test StateBaseTest = new JUnit4TestAdapter(StateBaseTest.class);
   System.out.println("StateBaseTest");
   TestRunner.run(StateBaseTest);
   Test VocabReaderTest = new JUnit4TestAdapter(VocabReaderTest.class);
   System.out.println("VocabReaderTest");
   TestRunner.run(VocabReaderTest);
  }
}