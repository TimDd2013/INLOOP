import junit.framework.Test;
import junit.textui.TestRunner;
import junit.framework.JUnit4TestAdapter;
// by FYICenter.com

public class T {
 public static void main (String[] args) {

   Test JContentTest = new JUnit4TestAdapter(JContentTest.class);
   System.out.println("JContentTest");
   TestRunner.run(JContentTest);
   Test JValuationTest = new JUnit4TestAdapter(JValuationTest.class);
   System.out.println("JValuationTest");
   TestRunner.run(JValuationTest);
   Test JAttachmentTest = new JUnit4TestAdapter(JAttachmentTest.class);
   System.out.println("JAttachmentTest");
   TestRunner.run(JAttachmentTest);
   Test JTopicTest = new JUnit4TestAdapter(JTopicTest.class);
   System.out.println("JTopicTest");
   TestRunner.run(JTopicTest);
   Test JIdeaTest = new JUnit4TestAdapter(JIdeaTest.class);
   System.out.println("JIdeaTest");
   TestRunner.run(JIdeaTest);   
   Test JStateBaseTest = new JUnit4TestAdapter(JStateBaseTest.class);
   System.out.println("JStateBaseTest");
   TestRunner.run(JStateBaseTest);
   Test StateDraftTest = new JUnit4TestAdapter(StateDraftTest.class);
   System.out.println("StateDraftTest");
   TestRunner.run(StateDraftTest);   
   Test StateDeclinedIdeaTest = new JUnit4TestAdapter(StateDeclinedIdeaTest.class);
   System.out.println("StateDeclinedIdeaTest");
   TestRunner.run(StateDeclinedIdeaTest);   
   Test StateApprovedIdeaTest = new JUnit4TestAdapter(StateApprovedIdeaTest.class);
   System.out.println("StateApprovedIdeaTest");
   TestRunner.run(StateApprovedIdeaTest);   
   Test StateReleasedIdeaTest = new JUnit4TestAdapter(StateReleasedIdeaTest.class);
   System.out.println("StateReleasedIdeaTest");
   TestRunner.run(StateReleasedIdeaTest);   
   Test StateOpenDraftTest = new JUnit4TestAdapter(StateOpenDraftTest.class);
   System.out.println("StateOpenDraftTest");
   TestRunner.run(StateOpenDraftTest);   
   Test StatePatternTest = new JUnit4TestAdapter(StatePatternTest.class);
   System.out.println("StatePatternTest");
   TestRunner.run(StatePatternTest);   
   Test ObserverTest = new JUnit4TestAdapter(ObserverTest.class);
   System.out.println("ObserverTest");
   TestRunner.run(ObserverTest);
   Test JIdeaPoolTest = new JUnit4TestAdapter(JIdeaPoolTest.class);
   System.out.println("JIdeaPoolTest");
   TestRunner.run(JIdeaPoolTest);   
   /*
   */
 }
}