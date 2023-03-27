package model;

public class Stage {

  private IntervalTime plannedTime;
  private boolean active = false;
  private String stageName;

  public Stage(String name) {
    this.stageName = name;
  }

  public String getStageName() {
    return this.stageName;
  }

  public IntervalTime getPlannedStartIntervalTime() {
    return plannedTime;
  }

  public void setPlannedIntervalTime(IntervalTime plannedTime) {
    this.plannedTime = plannedTime;
  }
  
  public void setActive() {
    this.active = true;
  }

  public void setInactive() {
    this.active = false;
  }

  public boolean isActive() {
    return this.active;
  }
}
