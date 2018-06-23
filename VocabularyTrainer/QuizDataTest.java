import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class QuizDataTest {
    private QuizData quizData;
    private List<VocabCard> vocabCards;
    @Before
    public void setUp() {
        vocabCards = Arrays.asList(new VocabCard("go", "gehen"),
                new VocabCard("lift", "heben"),
                new VocabCard("fall", "fallen"),
                new VocabCard("play", "spielen"),
                new VocabCard("walk", "laufen"));

        quizData = new QuizData(vocabCards, false);
    }

    @Test
    public void testConstructorNullArgument() {
        try {
            new QuizData(null, false);
            fail("QuizData.QuizData() should throw a NullPointerException if the vocabCards argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testConstructorIllegalArgumentEmptyList() {
        try {
            new QuizData(Collections.emptyList(), false);
            fail("QuizData.QuizData() should throw an IllegalArgumentException if the vocabCards argument is empty!");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testConstructorIllegalArgumentNullValue() {
        try {
            new QuizData(Collections.singletonList(null), false);
            fail("QuizData.QuizData() should throw a NullPointerException if the vocabCards argument contains a null entry!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testSizeVocab() {
        assertEquals("QuizData.sizeVocab() should return the number of VocabCards in the QuizData object!", 5,
                quizData.sizeVocab());
    }

    @Test
    public void testGetCurrentVocabCardCompletelyRandom() {
        Set<VocabCard> generatedVocabCards = new HashSet<VocabCard>();
        /*
         * This loop assumes that 200 random numbers are enough to get each of the 5 VocabCards at least once. (The
         * probability that one of five cards does not appear is ~4.15e-20, this should be low enough.)
         */
        generatedVocabCards.clear();
        for (int i = 0; i < 200; i++) {
            quizData.drawNext();
            assertTrue("QuizData.getCurrentVocabCard() should only return VocabCards contained in QuizData.vocabCards!",
                    vocabCards.contains(quizData.getCurrentVocabCard()));
            generatedVocabCards.add(quizData.getCurrentVocabCard());
        }
        assertEquals(
                "QuizData.getCurrentVocabCard() should provide every single VocabCard when using a CompletelyRandom CardDrawing!",
                new HashSet<>(vocabCards), new HashSet<>(generatedVocabCards));
    }

    @Test
    public void testGetCurrentVocabCardCycleRandom() {
        quizData = new QuizData(vocabCards, true);
        Set<VocabCard> generatedVocabCards = new HashSet<VocabCard>();

        /* Tests CycleRandom 3 times */
        for (int i = 0; i < 3; i++) {
            /* Implicitly tests if every single card is provided at least once */
            for (int j = 0; j < vocabCards.size(); j++) {
                quizData.drawNext();
                assertTrue(
                        "QuizData.getCurrentVocabCard() should only provide VocabCards that were passed as the constructor's vocabCards argument!",
                        vocabCards.contains(quizData.getCurrentVocabCard()));
                assertTrue(
                        "QuizData.getCurrentVocabCard() should not provide a VocabCard more than once per cycle when using a CycleRandom CardDrawing!",
                        generatedVocabCards.add(quizData.getCurrentVocabCard()));
            }
            generatedVocabCards.clear();
        }
    }
}
