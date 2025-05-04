import org.junit.Test;
import static org.junit.Assert.*;

public class TestDailyAppointment {
     /**
     * Test for DailyAppointment.
     */
    @Test
    public void testoccursOn() {
        DailyAppointment dailyAppointment = new DailyAppointment("Sleeping for 8 hours");
        assertEquals("Sleeping for 8 hours", dailyAppointment.getDescription());
        assertEquals(true, dailyAppointment.occursOn(2025, 4, 5));
        assertEquals(true, dailyAppointment.occursOn(2025, 4, 25));
    }
     /**
     * Test for constructor.
     */
    @Test
    public void testDailyAppointment() {
        DailyAppointment dailyAppointment = new DailyAppointment("Sleeping for 10 hours");
        assertEquals("Sleeping for 10 hours", dailyAppointment.getDescription());
        
    }
  
}
