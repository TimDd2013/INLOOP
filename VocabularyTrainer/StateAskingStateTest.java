import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class StateAskingStateTest extends StateBaseTest {

    @Test
    public void testInputCorrect() {
        quizProcess.initialize(quizData);
        outStream.reset();
        quizProcess.update();

        boolean containsAVocable = false;
        for(VocabCard vocabCard : vocabCards) {
            if (outStream.toString().contains(vocabCard.getVocable())) {
                write(vocabCard.getTranslation());
                containsAVocable = true;
                break;
            }
        }
        if(!containsAVocable) {
            fail("QuizProcess.update() should trigger printing a message that asks for the translation of a vocable!");
        }

        outStream.reset();
        quizProcess.input();

        assertEquals("AskingState.input() should change the state to SolutionState!", classSolutionState, getState()
                .getClass());
        assertTrue(
                "AskingState.input() should trigger printing a message that contains \"Correct!\" (without quotes, case sensitive) if the given answer is correct!",
                outStream.toString().contains("Correct!"));
    }

    @Test
    public void testInputWrong() {
        quizProcess.initialize(quizData);
        outStream.reset();
        quizProcess.update();

        boolean containsAVocable = false;
        for(VocabCard vocabCard : vocabCards) {
            if (outStream.toString().contains(vocabCard.getVocable())) {
                write("not " + vocabCard.getTranslation());
                containsAVocable = true;
                break;
            }
        }
        if(!containsAVocable) {
            fail("QuizProcess.update() should trigger printing a message that asks for the translation of a vocable!");
        }

        outStream.reset();
        quizProcess.input();

        assertEquals("AskingState.input() should change the state to SolutionState!", classSolutionState, getState()
                .getClass());
        assertTrue(
                "AskingState.input() should trigger printing a message that contains \"Wrong!\" (without quotes, case sensitive) if the given answer is wrong!",
                outStream.toString().contains("Wrong!"));
    }

    @Test
    public void testIllegalStateExceptions() {
        quizProcess.initialize(quizData);
        quizProcess.update();

        try {
            quizProcess.initialize(quizData);
            fail("QuizProcess.initialize() should throw an IllegalStateException if the current state is AskingState!");
        } catch (IllegalStateException e) {
        }

        try {
            quizProcess.update();
            fail("AskingState.update() should throw an IllegalStateException if called!");
        } catch (IllegalStateException e) {
        }
    }
}
