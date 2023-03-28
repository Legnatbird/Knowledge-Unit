package model;

import java.util.GregorianCalendar;

public class Stage {

  private GregorianCalendar startDate;
  private GregorianCalendar endDate;
  private IntervalTime plannedTime;
  private boolean approved = false;
  private boolean active = false;
  private IntervalTime realTime;
  private String stageName;

  public Stage(String name) {
    this.stageName = name;
    this.startDate = new GregorianCalendar();
  }

  public String getStageName() {
    return this.stageName;
  }

  public IntervalTime getPlannedStartIntervalTime() {
    return plannedTime;
  }

  public boolean getApprovedStatus() {
    return this.approved;
  }

  public void setPlannedIntervalTime(IntervalTime plannedTime) {
    this.plannedTime = plannedTime;
  }
  
  public void setActive() {
    this.active = true;
    this.startDate = new GregorianCalendar();
  }

  public void setInactive() {
    this.active = false;
    this.endDate = new GregorianCalendar();
  }

  public void setApproved() {
    this.approved = true;
  }

  public boolean isActive() {
    return this.active;
  }

  private void setRealIntervalTime(IntervalTime time) {
    this.realTime = new IntervalTime(time.getStartDate(), time.getEndDate());
  }

  public String getRealIntervalTime() {
    this.setRealIntervalTime(new IntervalTime(this.startDate, this.endDate));
    return this.realTime.toString();
  }
}
