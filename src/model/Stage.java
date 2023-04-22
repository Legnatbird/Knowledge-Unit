package model;

import java.util.GregorianCalendar;
import utils.Utils;
/**
 * Stage class
 */
public class Stage {

  private final Capsule[] capsules = new Capsule[50];
  private GregorianCalendar startDate;
  private GregorianCalendar endDate;
  private IntervalTime plannedTime;
  private boolean approved = false;
  private boolean active = false;
  private final String stageName;
  private IntervalTime realTime;
  private int capsuleCount = 0;

  /**
   * Constructor
   * @param name of the stage
   */
  public Stage(String name) {
    this.stageName = name;
    this.startDate = new GregorianCalendar();
  }
  /**
   * Set stage as active
   * @param capsule to be added
   */
  public void addCapsule(Capsule capsule) {
    // Check if the number of capsules is less than 50
    if (50 == this.capsuleCount) {
      Utils.print("You can't add more than 50 capsules to a stage");
      return;
    }
    this.capsules[this.capsuleCount] = capsule;
    // Check if the capsule id is already in use and generate a new one if it is
    for (int i = 0; i < this.capsuleCount; i++) {
      if (this.capsules[i].getId() == capsule.getId()) {
        capsule.setId((int) (Math.random() * 1000000));
        i = 0;
      }
    }
    this.capsuleCount++;
  }
  /**
   * Return if the stage is active
   * @return active
   */
  public boolean isActive() {
    return this.active;
  }
  /**
   * Return stage name
   * @return stageName
   */
  public String getStageName() {
    return this.stageName;
  }
  /**
   * Return planned start time
   * @return plannedTime
   */
  public IntervalTime getPlannedStartIntervalTime() {
    return plannedTime;
  }
  /**
   * Return if the stage is approved
   * @return approved
   */
  public boolean getApprovedStatus() {
    return this.approved;
  }
  /**
   * Return capsules
   * @return capsules
   */
  public Capsule[] getCapsules() {
    // return capsules without null values
    Capsule[] capsules = new Capsule[this.capsuleCount];
    System.arraycopy(this.capsules, 0, capsules, 0, this.capsuleCount);
    return capsules;
  }
  /**
   * Show real interval time
   * @return realTime
   */
  public String getRealIntervalTime() {
    this.setRealIntervalTime(new IntervalTime(this.startDate, this.endDate));
    return this.realTime.toString();
  }
  /**
   * Set planned interval time
   * @param plannedTime of the stage
   */
  public void setPlannedIntervalTime(IntervalTime plannedTime) {
    this.plannedTime = plannedTime;
  }
  /**
   * Set stage as active
   */
  public void setActive() {
    this.active = true;
    this.startDate = new GregorianCalendar();
  }
  /**
   * Set stage as inactive
   */
  public void setInactive() {
    this.active = false;
    this.endDate = new GregorianCalendar();
  }
  /**
   * Set stage as approved
   */
  public void setApproved() {
    this.approved = true;
  }
  /**
   * Set real interval time
   */
  private void setRealIntervalTime(IntervalTime time) {
    this.realTime = new IntervalTime(time.startDate(), time.endDate());
  }

}
