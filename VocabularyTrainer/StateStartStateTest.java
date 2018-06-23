import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import org.junit.Test;

public class StateStartStateTest extends StateBaseTest {
    @Test
    public void testInitialStateIllegalStateExceptions() {
        try {
            quizProcess.update();
            fail("QuizProcess.update() should throw an IllegalStateException if the current state is the initial state!");
        } catch (IllegalStateException e) {
        }

        write("laufen");

        try {
            quizProcess.input();
            fail("QuizProcess.input() should throw an IllegalStateException if the current state is the initial state!");
        } catch (IllegalStateException e) {
        }
    }

    @Test
    public void testInitialize() {
        quizProcess.initialize(quizData);

        assertEquals("QuizProcess.initialize() should change the state to StartState!", classStartState, getState()
                .getClass());
        assertFalse("QuizProcess.initialize() should trigger printing a welcome message!", outStream.toString().trim()
                .isEmpty());
    }

    @Test
    public void testUpdate() {
        quizProcess.initialize(quizData);
        quizProcess.update();

        assertEquals("StartProcess.update() should change the state to AskingState!", classAskingState, getState()
                .getClass());
        for (VocabCard vocabCard : vocabCards) {
            if (outStream.toString().contains(vocabCard.getVocable())) {
                return;
            }
        }
        fail("StartProcess.update() should trigger printing a message that asks for the translation of a vocable!");
    }

    @Test
    public void testIllegalStateExceptions() {
        quizProcess.initialize(quizData);

        try {
            quizProcess.initialize(quizData);
            fail("QuizProcess.initialize() should throw an IllegalStateException if the current state is StartState!");
        } catch (IllegalStateException e) {
        }

        write("laufen");

        try {
            quizProcess.input();
            fail("StartState.input() should throw an IllegalStateException if called!");
        } catch (IllegalStateException e) {
        }
    }
}
