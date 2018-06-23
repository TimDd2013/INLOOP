import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.Before;
import org.junit.Test;

public class QuizProcessTest {
    private QuizProcess qp;

    @Before
    public void setUp() {
        qp = new QuizProcess(System.in, System.out);
    }

    @Test
    public void testStateClass() throws IllegalAccessException {
        try {
            Field field = QuizProcess.class.getDeclaredField("currentState");
            assertEquals(
                    "QuizProcess.currentState should be of type State which must be an inner class of QuizProcess!",
                    "QuizProcess.State", field.getType().getCanonicalName());
            assertTrue("QuizProcess.State should be an abstract class!",
                    Modifier.isAbstract(field.getType().getModifiers()));
            field.setAccessible(true);
            assertNull("QuizProcess.currentState should be null when the QuizProcess is still in the initial state!",
                    field.get(qp));
        } catch (NoSuchFieldException e) {
            fail("QuizProcess should have an attribute named currentState!");
        }
    }

    public void testConcreteStateClasses() {
        searchForStateClass("StartState");
        searchForStateClass("AskingState");
        searchForStateClass("SolutionState");
    }

    @Test
    public void testInitializeNullArgument() {
        try {
            qp.initialize(null);
            fail("QuizProcess.initialize() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException e) {
        }
    }

    private void searchForStateClass(String className) {
        for (Class<?> c : QuizProcess.class.getDeclaredClasses()) {
            if (c.getSimpleName().equals(className)) {
                assertTrue("QuizProcess." + className + " should be a direct subclass of QuizProcess.State!", c
                        .getSuperclass().getCanonicalName().equals("QuizProcess.State"));
                return;
            }
        }
        fail("QuizProcess should have a private inner class named " + className);
    }
}
