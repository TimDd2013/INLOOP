import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class CardDrawingTest {
    private static final int sizeVocab = 5;

    private Set<Integer> generatedNumbers;
    private CardDrawing cardDrawing;
    private int next;

    private class CardDrawingDummy extends CardDrawing {
        @Override
        public int getNextVocabCardPosition(int sizeVocab) {
            return 0;
        }

    }

    @Before
    public void setUp() {
        generatedNumbers = new HashSet<Integer>();
    }

    @Test
    public void testCardDrawingRandomIllegalArgument() {
        try {
            new CardDrawingDummy().random(-1);
            fail("CardDrawing.random() should throw an IllegalArgumentException if the argument is negative!");
        } catch (IllegalArgumentException e) {
        }

        try {
            new CardDrawingDummy().random(0);
            fail("CardDrawing.random() should throw an IllegalArgumentException if the argument is zero!");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testCardDrawingRandom() {
        cardDrawing = new CardDrawingDummy();

        /*
         * This loop assumes that 200 random numbers are enough to get each number from 1 to (currently) 5 at least
         * once. (The probability that one of five numbers does not appear is ~4.15e-20, this should be low enough.)
         */
        for (int i = 0; i < 200; i++) {
            next = cardDrawing.random(sizeVocab);
            if ((next < 0) || (next >= sizeVocab)) {
                fail("CardDrawing.random() should only generate integers from 0 to sizeVocab (exclusive)!");
            }
            generatedNumbers.add(next);
        }
        assertTrue("CardDrawing.random() should be able to provide every single number in the given range!",
                generatedNumbers.size() == sizeVocab);
    }

    @Test
    public void testCompletelyRandomGetNextVocabCardIdIllegalArgument() {
        try {
            new CompletelyRandom().getNextVocabCardPosition(-1);
            fail("CompletelyRandom.getNextVocabCardPosition() should throw an IllegalArgumentException if the argument is negative!");
        } catch (IllegalArgumentException e) {
        }

        try {
            new CompletelyRandom().getNextVocabCardPosition(0);
            fail("CompletelyRandom.getNextVocabCardPosition() should throw an IllegalArgumentException if the argument is zero!");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testCompletelyRandom() {
        cardDrawing = new CompletelyRandom();

        /*
         * This loop assumes that 200 random numbers are enough to get each number from 1 to (currently) 5 at least
         * once. (The probability that one of five numbers does not appear is ~4.15e-20, this should be low enough.)
         */
        for (int i = 0; i < 200; i++) {
            next = cardDrawing.getNextVocabCardPosition(sizeVocab);
            if ((next < 0) || (next >= sizeVocab)) {
                fail("CompletelyRandom.getNextVocabCardPosition() should only provide VocabCard positions from 0 to sizeVocab (exclusive)!");
            }
            generatedNumbers.add(next);
        }
        assertTrue(
                "CompletelyRandom.getNextVocabCardPosition() should be able to provide every single number in the given range!",
                generatedNumbers.size() == sizeVocab);
    }

    @Test
    public void testCycleRandomGetNextVocabCardIdIllegalArgument() {
        try {
            new CycleRandom().getNextVocabCardPosition(-1);
            fail("CycleRandom.getNextVocabCardPosition() should throw an IllegalArgumentException if the argument is negative!");
        } catch (IllegalArgumentException e) {
        }

        try {
            new CycleRandom().getNextVocabCardPosition(0);
            fail("CycleRandom.getNextVocabCardPosition() should throw an IllegalArgumentException if the argument is zero!");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testCycleRandom() {
        cardDrawing = new CycleRandom();

        /* Tests CycleRandom 3 times */
        for (int cycle = 0; cycle < 3; cycle++) {
            /* Implicitly tests if every single position is provided at least once */
            for (int i = 1; i <= sizeVocab; i++) {
                next = cardDrawing.getNextVocabCardPosition(sizeVocab);
                if ((next < 0) || (next >= sizeVocab)) {
                    fail("CycleRandom.getNextVocabCardPosition() should only provide VocabCard position from 0 to sizeVocab (exclusive)!");
                }
                assertTrue(
                        "CycleRandom.getNextVocabCardPosition() should not return a VocabCard position more than once per cycle!",
                        generatedNumbers.add(next));
            }
            generatedNumbers.clear();
        }
    }
}
