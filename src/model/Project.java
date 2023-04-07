package model;

import java.util.GregorianCalendar;
import utils.Utils;

/*
 * Project class
 */
public class Project {
  /*
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
  private Stages stages;
  private float budget;
  private State state;

  /*
   * Constructor
   */
  public Project() {
    this.state = State.WAITING_FOR_APPROVAL;
  }
  /*
   * Approve project
   */
  public void approve() {
    this.state = State.APPROVED;
    Utils.print("Project approved");
    Utils.print("Insert project name:");
    this.projectName = Utils.inputString.readLine();
    Utils.print("Insert client name:");
    this.clientName = Utils.inputString.readLine();
    Utils.print("Insert planned date of start:");
    this.plannedDateOfStart = this.getDate();
    Utils.print("Insert planned date of end:");
    this.plannedDateOfEnd = this.getDate();
    Utils.print("Insert budget:");
    this.budget = Utils.inputNumbers.nextFloat();
    Utils.print("Insert project managers name:");
    this.projectManagersName = Utils.inputString.readLine().split(",");
    Utils.print("Insert project managers phone:");
    this.projectManagersPhone = Utils.inputString.readLine().split(",");
    this.stages = new Stages();
    Utils.print("Setups completed");
  }
  /*
   * Get date
   * @return GregorianCalendar
   */
  private GregorianCalendar getDate() {
    Utils.print("Insert year:");
    int year = Utils.inputNumbers.nextInt();
    Utils.print("Insert month:");
    int month = Utils.inputNumbers.nextInt();
    Utils.print("Insert day:");
    int day = Utils.inputNumbers.nextInt();
    return Utils.getGregorianCalendar(year, month, day);
  }
  /*
   * Reject project
   */
  public void reject() {
    this.state = State.REJECTED;
    Utils.print("Project rejected");
  }
  /*
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
  /*
   * Get project managers name
   */
  public void getProjectManagersName() {
    for (String name : this.projectManagersName) {
      Utils.print(name);
    }
  }
  /*
   * Get project managers phone
   */
  public void getProjectManagersPhone() {
    for (String phone : this.projectManagersPhone) {
      Utils.print(phone);
    }
  }
  /*
   * Get project name
   */
  public String getProjectName() {
    return this.projectName;
  }
  /*
   * Get client name
   */
  public String getClientName() {
    return this.clientName;
  }
  /*
   * Get budget
   */
  public float getBudget() {
    return this.budget;
  }
  /*
   * Get stages
   * @return Stages
   */
  public Stages getStages() {
    return this.stages;
  }
  /*
   * Get stage
   * @return Stage
   */
  public Stage getStage() {
    return this.stages.getActiveStage();
  }
  /*
   * Get planned date of start
   */
  public void getPlannedDateOfStart() {
    Utils.print(this.plannedDateOfStart);
  }
  /*
   * Get planned date of end
   */
  public void getPlannedDateOfEnd() {
    Utils.print(this.plannedDateOfEnd);
  }

  public void showLearnings(int stage) {
    for (Capsule capsule : stages.getStage(stage).getCapsules()) {
      capsule.getLearning();
    }
  }

  public int capsulesLenght() {
    for (Stage stage : stages.getStages()) {
      return stage.getCapsules().length;
    }
    return 0;
  }
}
