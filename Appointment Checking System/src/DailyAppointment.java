class DailyAppointment extends Appointment {
   /** 
      * initialize OneTimeAppointment description, year, month and day 
      * @param description the title of the appointment
     
      */ 
  public DailyAppointment(String description) {
      super(description);
  }
   /**
     * Always return true because this is the DailyAppointment
     */
  @Override
  public boolean occursOn(int year, int month, int day) {
      return true; 
  }
}