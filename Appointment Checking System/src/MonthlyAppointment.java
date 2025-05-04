class MonthlyAppointment extends Appointment {
  private int day;
   /** 
      * initialize OneTimeAppointment description, year, month and day 
      * @param description the title of the appointment
      * @param day the day of the appointment
      */ 


  public MonthlyAppointment(String description, int day) {
      super(description);
      this.day = day;
  }
  
 public int getDay() {
    return day;
  }

 /**
     * Check if \ day matches with the created MonthlyAppointment
     */
  @Override
  public boolean occursOn(int year, int month, int day) {
    if (this.day == day) { 
      return true;
    } else { 
      return false;
    }
  }
}