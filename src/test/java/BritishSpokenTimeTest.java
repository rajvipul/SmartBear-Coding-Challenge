import com.smartBear.BritishSpokenTime;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BritishSpokenTimeTest {

    @Test
    void testSpokenForms() {
        assertEquals("one o'clock", BritishSpokenTime.toSpokenForm("01:00"));
        assertEquals("five past two", BritishSpokenTime.toSpokenForm("02:05"));
        assertEquals("ten past three", BritishSpokenTime.toSpokenForm("03:10"));
        assertEquals("quarter past four", BritishSpokenTime.toSpokenForm("04:15"));
        assertEquals("twenty past five", BritishSpokenTime.toSpokenForm("05:20"));
        assertEquals("twenty-five past six", BritishSpokenTime.toSpokenForm("06:25"));
        assertEquals("six thirty-two", BritishSpokenTime.toSpokenForm("06:32"));
        assertEquals("half past seven", BritishSpokenTime.toSpokenForm("07:30"));
        assertEquals("twenty-five to eight", BritishSpokenTime.toSpokenForm("07:35"));
        assertEquals("twenty to nine", BritishSpokenTime.toSpokenForm("08:40"));
        assertEquals("quarter to ten", BritishSpokenTime.toSpokenForm("09:45"));
        assertEquals("ten to eleven", BritishSpokenTime.toSpokenForm("10:50"));
        assertEquals("five to twelve", BritishSpokenTime.toSpokenForm("11:55"));
        assertEquals("midnight", BritishSpokenTime.toSpokenForm("00:00"));
        assertEquals("noon", BritishSpokenTime.toSpokenForm("12:00"));
    }

    @Test
    void testInvalidInputs() {
        try {
           final String output =  BritishSpokenTime.toSpokenForm("invalid");
        } catch(IllegalArgumentException ie) {
            System.out.println("--------");
            System.out.println(ie.getMessage());
            assertEquals("Invalid time format. Use HH:MM.", ie.getMessage());
        }
    }

    @Test
    void testIncorrectFormat() {

        try {
            final String output =  BritishSpokenTime.toSpokenForm("24:00");
        } catch(IllegalArgumentException ie) {
            assertEquals("Time out of range (00:00 to 23:59).", ie.getMessage());
        }
    }

    @Test
    void testIncorrectTimeFormat() {
        try {
            final String output =  BritishSpokenTime.toSpokenForm("-1:32");
        } catch(IllegalArgumentException ie) {
            assertEquals("Time out of range (00:00 to 23:59).", ie.getMessage());
        }
    }

    @Test
    void testNumberFormatInvalid() {
        try {
            final String output =  BritishSpokenTime.toSpokenForm("-ab:05");
        } catch(IllegalArgumentException ie) {
            assertEquals("Invalid numbers in time.Please check the input time.", ie.getMessage());
        }
    }
}