import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.fail;

@Ignore
public class StateBaseTest {
    protected static Class<?> classStartState;
    protected static Class<?> classAskingState;
    protected static Class<?> classSolutionState;

    protected QuizProcess quizProcess;
    protected PipedOutputStream inputSteamData;
    protected ByteArrayOutputStream outStream;
    protected QuizData quizData;
    protected List<VocabCard> vocabCards;

    @BeforeClass
    public static void setUpStateClassVariables() {
        searchForInnerClass("State");
        classStartState = searchForInnerClass("StartState");
        classAskingState = searchForInnerClass("AskingState");
        classSolutionState = searchForInnerClass("SolutionState");
    }

    @Before
    public void setUp() throws IOException {
        vocabCards = Arrays.asList(new VocabCard("go", "gehen"),
                new VocabCard("lift", "heben"),
                new VocabCard("fall", "fallen"),
                new VocabCard("play", "spielen"),
                new VocabCard("walk", "laufen"));
        quizData = new QuizData(vocabCards, true);
        inputSteamData = new PipedOutputStream();
        outStream = new ByteArrayOutputStream();
        quizProcess = new QuizProcess(new PipedInputStream(inputSteamData), outStream);
    }

    protected Object getState() {
        try {
            Field myField = QuizProcess.class.getDeclaredField("currentState");
            myField.setAccessible(true);
            return myField.get(quizProcess);
        } catch (NoSuchFieldException e) {
            fail("QuizProcess should have an attribute named currentState!");
        } catch (IllegalAccessException e) {
            fail("An unexpected error occurred!");
        }
        throw new AssertionError("An unexpected error occurred!");
    }

    private static Class<?> searchForInnerClass(String name) {
        for (Class<?> c : QuizProcess.class.getDeclaredClasses()) {
            if (name.equals(c.getSimpleName())) {
                return c;
            }
        }
        throw new AssertionError("QuizProcess should have an inner class named " + name + "!");
    }

    protected void write(String s) {
        try {
            inputSteamData.write((s + "\n").getBytes());
        } catch (IOException e) {
            fail("An unexpected error occurred!");
        }
    }

    @After
    public void tearDown() throws IOException {
        quizProcess = null;
        outStream.close();
        inputSteamData.close();
    }
}
