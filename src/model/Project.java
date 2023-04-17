package model;

import java.util.GregorianCalendar;
import utils.Utils;

/**
 * Project class
 */
public class Project {
  /**
   * Stages enum
   */
  enum State {
    WAITING_FOR_APPROVAL, APPROVED, REJECTED
  }

  private GregorianCalendar plannedDateOfStart;
  private GregorianCalendar plannedDateOfEnd;
  private String[] projectManagersPhone;
  private String[] projectManagersName;
  private String projectName;
  private String clientName;
  private StageController stages;
  private float budget;
  private State state;

  /**
   * Constructor
   */
  public Project() {
    this.state = State.WAITING_FOR_APPROVAL;
  }
  /**
   * Approve project
   */
  public void approve() {
    this.stages = new StageController();
  }
  /**
   * Reject project
   */
  public void reject() {
    this.state = State.REJECTED;
    Utils.print("Project rejected");
  }
  /**
   * Get state
   */
  public void getState() {
    switch (this.state) {
      case WAITING_FOR_APPROVAL:
        Utils.print("Waiting for approval");
      case APPROVED:
        Utils.print("Approved");
      case REJECTED:
        Utils.print("Rejected");
    }
  }
  /**
   * Get project managers name
   * @return String project managers name
   */
  public String getProjectManagersName() {
    StringBuilder name = new StringBuilder();
    for (String manager : this.projectManagersName) {
      name.append(manager).append(", ");
    }
    return name.toString();
  }
  /**
   * Get project managers phone
   * @return String project managers phone
   */
  public String getProjectManagersPhone() {
    StringBuilder phone = new StringBuilder();
    for (String number : this.projectManagersPhone) {
      phone.append(number).append(", ");
    }
    return phone.toString();
  }
  /**
   * Get project name
   * @return String project name
   */
  public String getProjectName() {
    return this.projectName;
  }
  /**
   * Get client name
   * @return String client name
   */
  public String getClientName() {
    return this.clientName;
  }
  /**
   * Get budget
   * @return float budget
   */
  public float getBudget() {
    return this.budget;
  }
  /**
   * Get stages
   * @return Stages
   */
  public StageController getStages() {
    return this.stages;
  }

  /**
   * Get stage
   * @return Stage active stage
   */
  public Stage getStage() {
    return this.stages.getActiveStage();
  }
  /**
   * Get planned date of start
   * @return GregorianCalendar planned date of start
   */
  public GregorianCalendar getPlannedDateOfStart() {
    return this.plannedDateOfStart;
  }
  /**
   * Get planned date of end
   * @return GregorianCalendar planned date of end
   */
  public GregorianCalendar getPlannedDateOfEnd() {
    return this.plannedDateOfEnd;
  }

  /**
   * Show learnings
   * @param stage integer
   */
  public void showLearnings(int stage) {
    for (Capsule capsule : stages.getStage(stage).getCapsules()) {
      Utils.print(capsule.getLearning());
    }
  }

  /**
   * Show learnings
   * @return capsules length
   */
  public int capsulesLength() {
    for (Stage stage : stages.getStages()) {
      return stage.getCapsules().length;
    }
    return 0;
  }

  /**
   * Get capsules
   * @return capsules
   */
  public Capsule[] getCapsules() {
    Capsule[] capsules = new Capsule[capsulesLength()];
    int i = 0;
    for (Stage stage : stages.getStages()) {
      for (Capsule capsule : stage.getCapsules()) {
        capsules[i] = capsule;
        i++;
      }
    }
    return capsules;
  }

  public void setState(String state) {
    this.state = State.valueOf(state);
  }

  public void setProjectName(String name) {
    this.projectName = name;
  }

  public void setClientName(String name) {
    this.clientName = name;
  }

  public void setBudget(float budget) {
    this.budget = budget;
  }

  public void setProjectManagersName(String[] name) {
    this.projectManagersName = name;
  }

  public void setProjectManagersPhone(String[] phone) {
    this.projectManagersPhone = phone;
  }

  public void setPlannedDateOfStart(GregorianCalendar date) {
    this.plannedDateOfStart = date;
  }

  public void setPlannedDateOfEnd(GregorianCalendar date) {
    this.plannedDateOfEnd = date;
  }
}
