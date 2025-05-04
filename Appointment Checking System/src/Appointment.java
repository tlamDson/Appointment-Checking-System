abstract class Appointment {

  protected String description;

  /**
   * Initializes the appointment with a specific description.
   * @param description the text describing the appointment
   */
  public Appointment(String description) {
      this.description = description;
  }

  /**
   * Returns the description of the appointment.
   *
   * @return the appointment description
   */
  public String getDescription() {
      return description;
  }

  /**
   * Determines if the appointment occurs on a specific date.
   */
  public abstract boolean occursOn(int year, int month, int day);
}
