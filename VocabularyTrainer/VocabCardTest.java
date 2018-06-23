import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class VocabCardTest {
    private static final String vocable = "house";
    private static final String translation = "Haus";

    private VocabCard vocabCard;

    @Before
    public void setUp() {
        vocabCard = new VocabCard(vocable, translation);
    }

    @Test
    public void testConstructorNullArgument() {
        try {
            new VocabCard(null, translation);
            fail("VocabCard.VocabCard() should throw a NullPointerException if the vocable argument is null!");
        } catch (NullPointerException e) {
        }

        try {
            new VocabCard(vocable, null);
            fail("VocabCard.VocabCard() should throw a NullPointerException if the translation argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testConstructorIllegalArgument() {
        try {
            new VocabCard("", translation);
            fail("VocabCard.VocabCard() should throw an IllegalArgumentException if the vocable argument is empty!");
        } catch (IllegalArgumentException e) {
        }

        try {
            new VocabCard(vocable, "");
            fail("VocabCard.VocabCard() should throw an IllegalArgumentException if the translation argument is empty!");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void testGetLang1() {
        assertEquals(
                "VocabCard.getVocable() should return the vocable that was passed to the VocabCard constructor as first parameter!",
                vocable, vocabCard.getVocable());
    }

    @Test
    public void testGetLang2() {
        assertEquals(
                "VocabCard.getTranslation() should return the translation that was passed to the VocabCard constructor as second parameter!",
                translation, vocabCard.getTranslation());
    }

    @Test
    public void testEquals() {
        assertTrue(
                "VocabCard.equals() should return true if the object is a VocabCard and has the same values for vocable and translation!",
                vocabCard.equals(new VocabCard(vocable, translation)));
        assertFalse(
                "VocabCard.equals() should return false if the object is a VocabCard but does not have the same values for vocable and translation!",
                vocabCard.equals(new VocabCard(translation, vocable)));
        assertFalse(
                "VocabCard.equals() should return false if the object is a VocabCard but does not have the same values for vocable and translation!",
                vocabCard.equals(new VocabCard(vocable, translation.substring(0, translation.length() - 1))));
        assertFalse(
                "VocabCard.equals() should return false if the object is a VocabCard but does not have the same values for vocable and translation!",
                vocabCard.equals(new VocabCard(vocable.substring(0, vocable.length() - 1), translation)));
        assertFalse("VocabCard.equals() should return false if the object is not a VocabCard!",
                vocabCard.equals(new Object()));
        assertFalse("VocabCard.equals() should return false if the object is not a VocabCard!", vocabCard.equals(null));
    }
}
