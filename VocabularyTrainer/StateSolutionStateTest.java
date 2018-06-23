import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class StateSolutionStateTest extends StateBaseTest {
    @Test
    public void testUpdate() {
        quizProcess.initialize(quizData);
        quizProcess.update();
        write("laufen");
        quizProcess.input();
        outStream.reset();
        quizProcess.update();

        assertEquals("SolutionState.update() should change the state to AskingState!", classAskingState, getState()
                .getClass());
        for (VocabCard vocabCard : vocabCards) {
            if (outStream.toString().contains(vocabCard.getVocable())) {
                return;
            }
        }
        fail("SolutionState.update() should trigger printing a message that asks for the translation of a vocable!");
    }

    @Test
    public void testIllegalStateExceptions() {
        quizProcess.initialize(quizData);
        quizProcess.update();
        write("laufen");
        quizProcess.input();

        try {
            quizProcess.initialize(quizData);
            fail("QuizProcess.initialize() should throw an IllegalStateException if the current state is SolutionState!");
        } catch (IllegalStateException e) {
        }

        write("laufen");

        try {
            quizProcess.input();
            fail("SolutionState.input() should throw an IllegalStateException if called!");
        } catch (IllegalStateException e) {
        }
    }
}
