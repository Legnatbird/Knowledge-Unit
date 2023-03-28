package model;

// import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class IntervalTime {

  private GregorianCalendar startDate;
  private GregorianCalendar endDate;

  public IntervalTime(GregorianCalendar startDate, GregorianCalendar endDate) {
    this.startDate = startDate;
    this.endDate = endDate;
  }

  public GregorianCalendar getStartDate() {
    //SimpleDateFormat("dd-MM-yyyy").format(startDate.getTime());
    return startDate;
  }

  public GregorianCalendar getEndDate() {
    return endDate;
  }

  public String getFullTime() {
    return "Start date: " + startDate.getTime() + " End date: " + endDate.getTime();
  }
}
