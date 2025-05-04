class OneTimeAppointment extends Appointment {
  private int year;
  private int month;
  private int day;
  
    /** 
      * initialize OneTimeAppointment description, year, month and day 
      * @param description the title of the appointment
      * @param year the year of the appointment
      * @param month the month of the appointment
      * @param day the day of the appointment
      */ 

  public OneTimeAppointment(String description, int year, int month, int day) {
      super(description);
      this.year = year;
      this.month = month;
      this.day = day;
  }
  

  public int getYear() {
      return year;
    }


    public int getMonth() {
      return month;
    }


    public int getDay() {
      return day;
    }


  /**
     * Check if the year, month, day match with the created OneTimeAppointment
     */

  @Override
  public boolean occursOn(int year, int month, int day) {
      if ( this.year == year && this.month == month && this.day == day) { 
        return true;
      } else { 
        return false;
      }
  }
}