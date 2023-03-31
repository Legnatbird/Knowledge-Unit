package model;

// import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
/*
 * IntervalTime class
 */
public class IntervalTime {

  private final GregorianCalendar startDate;
  private final GregorianCalendar endDate;
  /*
   * Constructor
   * @param startDate
   * @param endDate
   */
  public IntervalTime(GregorianCalendar startDate, GregorianCalendar endDate) {
    this.startDate = startDate;
    this.endDate = endDate;
  }
  /*
   * Get start date
   * @return startDate
   */
  public GregorianCalendar getStartDate() {
    //SimpleDateFormat("dd-MM-yyyy").format(startDate.getTime());
    return startDate;
  }
  /*
   * Get end date
   * @return endDate
   */
  public GregorianCalendar getEndDate() {
    return endDate;
  }
  /*
   * Get full time
   * @return full time from start date to end date
   */
  public String getFullTime() {
    return "Start date: " + startDate.getTime() + " End date: " + endDate.getTime();
  }
}
