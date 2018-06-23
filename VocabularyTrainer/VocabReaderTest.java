import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import org.junit.After;
import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class VocabReaderTest {
    private static final String vocabFileString1 = "go:gehen\nlift:heben\nfall:fallen\n#play:spielen\n#walk:laufen\ntime:Zeit\nhouse:Haus\n#fly:fliegen\n";
    private static final String vocabFileString2 = "play:spielen\nwalk:laufen\nfly:fliegen\n";

    private InputStream vocabFileStream;

    @BeforeClass
    public static void test() {
        try {
            Class.forName("VocabReader");
        } catch (ClassNotFoundException e) {
            Assume.assumeNoException(e);
        }
    }

    @Before
    public void setUp() {
        vocabFileStream = new ByteArrayInputStream(vocabFileString1.getBytes());
    }

    @Test
    public void testConstructorNullArgument() {
        try {
            new VocabReader(null);
            fail("VocabReader.VocabReader() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testSetNullArgument() {
        try {
            new VocabReader(vocabFileStream).setVocabFileStream(null);
            fail("VocabReader.setVocabFileStream() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void testRead() throws IOException {
        VocabReader vocabReader = new VocabReader(vocabFileStream);
        List<VocabCard> vocabReaderCards;
        List<VocabCard> expectedCards = new ArrayList<>();
        expectedCards.add(new VocabCard("go", "gehen"));
        expectedCards.add(new VocabCard("lift", "heben"));
        expectedCards.add(new VocabCard("fall", "fallen"));
        expectedCards.add(new VocabCard("time", "Zeit"));
        expectedCards.add(new VocabCard("house", "Haus"));

        vocabReaderCards = vocabReader.read();
        assertNotNull("VocabReader.read() should not return null!", vocabReaderCards);

        assertEquals(
                "VocabReader.read() should process all vocable lines from the vocab file stream (and nothing more)!",
                expectedCards, vocabReaderCards);

        expectedCards.clear();
        expectedCards.add(new VocabCard("play", "spielen"));
        expectedCards.add(new VocabCard("walk", "laufen"));
        expectedCards.add(new VocabCard("fly", "fliegen"));
        vocabReader.setVocabFileStream(new ByteArrayInputStream(vocabFileString2.getBytes()));
        vocabReaderCards = vocabReader.read();

        assertEquals(
                "VocabReader.read() should process all vocable lines from the vocab file stream (and nothing more)!",
                expectedCards, vocabReaderCards);

        vocabReader.setVocabFileStream(new ByteArrayInputStream(new byte[0]));
        vocabReaderCards = vocabReader.read();
        assertTrue(
                "VocabReader.read() should return an empty List if the given InputStream did not provide any vocab file lines!",
                vocabReaderCards.isEmpty());
    }

    @Test
    public void testCreate() {
        try {
            new VocabReader(vocabFileStream).setVocabFileStream(null);
            fail("VocabReader.setVocabFileStream() should throw a NullPointerException if the argument is null!");
        } catch (NullPointerException e) {
        }
    }

    @After
    public void tearDown() throws IOException {
        vocabFileStream.close();
    }
}
