package model;

import java.util.GregorianCalendar;

public class IntervalTime {

  private GregorianCalendar startDate;
  private GregorianCalendar endDate;

  public IntervalTime(GregorianCalendar startDate, GregorianCalendar endDate) {
    this.startDate = startDate;
    this.endDate = endDate;
  }

  public GregorianCalendar getStartDate() {
    return startDate;
  }

  public GregorianCalendar getEndDate() {
    return endDate;
  }
}
