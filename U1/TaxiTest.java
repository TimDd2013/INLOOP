import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

// Checking-code for io-streams is from:
// https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println

public class TaxiTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    private static final String result0 = "This is the taxi of Juergen Staub. He takes nobody along.";
    private static final String result1 = "This is the taxi of Juergen Staub. He takes Andrea Bora along.";
    private static final String result2 = "This is the taxi of Juergen Staub. He takes Andrea Bora and Franzi Ada along.";
    private static final String result3 = "This is the taxi of Juergen Staub. He takes Andrea Bora, Franzi Ada and Leah Posh along.";
    private static final String result4 = "This is the taxi of Juergen Staub. He takes Andrea Bora, Franzi Ada, Leah Posh and Susi Fresh along.";

    private Human h1, h2, h3, h4, h5, driver;
    private Taxi taxi;

    @Before
    public void setUp() {
        driver = new Human("Juergen", "Staub");
        h1 = new Human("Andrea", "Bora");
        h2 = new Human("Franzi", "Ada");
        h3 = new Human("Leah", "Posh");
        h4 = new Human("Susi", "Fresh");
        h5 = new Human("Lucky", "Fuke");
        taxi = new Taxi(driver);
    }

    @Test
    public void testHuman() {
        assertEquals("Human.getName() should return the correct surname.", "Ada", h2.getName());
        assertEquals("Human.getForename() should return the correct forename.", "Franzi", h2.getForename());
        assertEquals(
                "Human.toString() should return the complete name as a String, containing forename and surname, seperated by a space character.",
                "Franzi Ada", h2.toString());
    }

    @Test
    public void testTaxiDriverAssigned() {
        /* Added this test to catch the error returning the Human instead of a String */
        assertEquals("Taxi.getDriverName() should return a String.", String.class, taxi.getDriverName().getClass());
        assertEquals("Taxi.getDriverName() should return the complete name of the Human driver.", "Juergen Staub",
                taxi.getDriverName());
    }

    @Test
    public void testTaxiAdd() {
        assertEquals("Taxi.toString() should return the correct value if the taxi has no passengers!", result0,
                taxi.toString());
        taxi.add(h1);
        assertEquals("Taxi.toString() should return the correct value if the taxi has one passenger!", result1,
                taxi.toString());
        taxi.add(h2);
        assertEquals("Taxi.toString() should return the correct value if the taxi has two passengers!", result2,
                taxi.toString());
        taxi.add(h3);
        assertEquals("Taxi.toString() should return the correct value if the taxi has three passengers!", result3,
                taxi.toString());
        taxi.add(h4);
        assertEquals("Taxi.toString() should return the correct value if the taxi has four passengers!", result4,
                taxi.toString());
        taxi.add(h5);
        assertTrue("It should not be possible to add more than four concurrent passengers to a taxi!",
                taxi.allGetOut().length <= 4);
        assertEquals("Taxi.toString() should return the correct value after the taxi's passengers got out!", result0,
                taxi.toString());
    }

    @Test
    public void testTaxiAllGetOutEmptyTaxi() {
        Human[] actualPassengers = null;

        try {
            actualPassengers = taxi.allGetOut();
        } catch (ClassCastException c) {
            fail("The return type of Taxi.allGetOut() should be Human[].");
        }
        assertNotNull("Taxi.allGetOut() should never return null!", actualPassengers);
        assertEquals("Taxi.allGetOut() should return an empty array of type Human if the taxi is empty!", 0,
                actualPassengers.length);
    }

    @Test
    public void taxiAllGetOutTaxiNotEmpty() {
        List<Human> passengers = Arrays.asList(new Human[] { h1, h2, h3, h4 });
        taxi.add(h1);
        taxi.add(h2);
        taxi.add(h3);
        taxi.add(h4);
        Human[] actualPassengers = taxi.allGetOut();

        assertEquals("Taxi.allGetOut() should return four passengers if the taxi had four passengers!", 4,
                actualPassengers.length);
        for (int i = 0; i < actualPassengers.length; i++) {
            assertNotNull(
                    "Taxi.allGetOut() returned an array that contains null instead of a proper Human object for one of the passengers!",
                    actualPassengers[i]);
            assertTrue("Taxi.allGetOut() should return an array that contains every passenger of the taxi!",
                    passengers.contains(actualPassengers[i]));
        }

        assertTrue("Taxi.toString() should return the proper message after Taxi.allGetOut() has been called!",
                taxi.toString().equals(result0));
        taxi.add(h1);
        assertTrue(
                "Re-adding passengers after calling Taxi.allGetOut() may not work because Taxi.toString() does not return the proper message.",
                taxi.toString().equals(result1));
    }

    @Test
    public void testRightConsoleOutput() {
        PrintStream backOut, backErr;

        backOut = System.out;
        backErr = System.err;

        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));

        try {
            taxi.add(h1);
            testStreams("Taxi.add() should print the correct message when someone gets into the taxi!",
                    "Andrea Bora gets in.");

            taxi.add(h2);
            testStreams("Taxi.add() should print the correct message when someone gets into the taxi!",
                    "Franzi Ada gets in.");

            taxi.add(h3);
            testStreams("Taxi.add() should print the correct message when someone gets into the taxi!",
                    "Leah Posh gets in.");

            taxi.add(h4);
            testStreams("Taxi.add() should print the correct message when someone gets into the taxi!",
                    "Susi Fresh gets in.");

            taxi.add(h5);
            testStreams("Taxi.add() should print the correct message when someone tries to get into a full taxi!",
                    "We are sorry, Lucky Fuke. The taxi is full.");
        } finally {
            System.setOut(backOut);
            System.setErr(backErr);
        }
    }

    // A method comparing the String streamOutput with the actual streams
    private void testStreams(String message, String streamOutput) {
        assertEquals(message, streamOutput + System.lineSeparator(), outContent.toString());
        assertEquals("Your program should not print into the error stream (System.err)!", "", errContent.toString());
        outContent.reset();
        errContent.reset();
    }
}
