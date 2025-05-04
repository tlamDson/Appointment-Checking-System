import org.junit.Test;
import static org.junit.Assert.*;

public class TestMonthlyAppointment {
  /**
     * Test for MonthlyAppointment.
     */
    @Test
    public void testoccursOn() {
        MonthlyAppointment monthlyAppointment = new MonthlyAppointment("Practise coding", 5);
        assertEquals("Practise coding", monthlyAppointment.getDescription());
        assertEquals(true, monthlyAppointment.occursOn(2025, 4, 5));
        assertEquals(false, monthlyAppointment.occursOn(2025, 4, 25));
    
    }
     /**
     * Test for constructor.
     */
    @Test
    public void testMonthlyTimeAppointment() {
        MonthlyAppointment monthlyAppointment = new MonthlyAppointment("Practise coding", 5);
        assertEquals("Practise coding", monthlyAppointment.getDescription());
        assertEquals(5, monthlyAppointment.getDay());

       
    
    }
}
