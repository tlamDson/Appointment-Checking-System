import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestOneTimeAppointment {
  
    /**
     * Test for OneTimeAppointment.
     */
    @Test
    public void testoccursOn() {
        OneTimeAppointment oneTimeAppointment = new OneTimeAppointment("Leetcode", 2025, 4, 26);
        assertEquals("Leetcode", oneTimeAppointment.getDescription());
        assertEquals(true, oneTimeAppointment.occursOn(2025, 4, 26));
        assertEquals(false, oneTimeAppointment.occursOn(2025, 4, 25));
    }
     /**
     * Test for the constructor.
     */
    @Test
    public void testOneTimeAppointment() {
        OneTimeAppointment oneTimeAppointment = new OneTimeAppointment("Leetcode", 2025, 4, 26);
        assertEquals("Leetcode", oneTimeAppointment.getDescription());
        assertEquals(2025, oneTimeAppointment.getYear());
        assertEquals(4, oneTimeAppointment.getMonth());
        assertEquals(26, oneTimeAppointment.getDay());


       
    }

}
