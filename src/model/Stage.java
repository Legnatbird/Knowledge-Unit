package model;

import java.util.GregorianCalendar;
import utils.Utils;

public class Stage {

  private Capsule[] capsules = new Capsule[50];
  private GregorianCalendar startDate;
  private GregorianCalendar endDate;
  private IntervalTime plannedTime;
  private boolean approved = false;
  private boolean active = false;
  private final String stageName;
  private IntervalTime realTime;
  private int capsuleCount = 0;

  public Stage(String name) {
    this.stageName = name;
    this.startDate = new GregorianCalendar();
  }

  public void addCapsule(Capsule capsule) {
    if (this.capsuleCount == 50) {
      Utils.print("You can't add more than 50 capsules to a stage");
      return;
    }
    this.capsules[capsuleCount] = capsule;
    for (int i = 0; i < this.capsuleCount; i++) {
      if (this.capsules[i].getId() == capsule.getId()) {
        capsule.setId((int) (Math.random() * 1000000));
        i = 0;
      }
    }
    this.capsuleCount++;
  }

  public void searchCapsuleByKeyword(String keyword) {
    for (int i = 0; i < this.capsuleCount; i++) {
      if (this.capsules[i].getKeyWords().contains(keyword)) {
        this.capsules[i].printCapsule();
      }
    }
  }

  public boolean isActive() {
    return this.active;
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
  
  public Capsule[] getCapsules() {
    return this.capsules;
  }
  
  public String getRealIntervalTime() {
    this.setRealIntervalTime(new IntervalTime(this.startDate, this.endDate));
    return this.realTime.toString();
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

  private void setRealIntervalTime(IntervalTime time) {
    this.realTime = new IntervalTime(time.getStartDate(), time.getEndDate());
  }

}
