package model;

import java.util.GregorianCalendar;

import utils.Utils;

public class Project {

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
  
  
  public Project() {
    this.state = State.WAITING_FOR_APPROVAL;
  }
  
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
  }
  
  private GregorianCalendar getDate() {
    Utils.print("Insert year:");
    int year = Utils.inputNumbers.nextInt();
    Utils.print("Insert month:");
    int month = Utils.inputNumbers.nextInt();
    Utils.print("Insert day:");
    int day = Utils.inputNumbers.nextInt();
    return Utils.getGregorianCalendar(year, month, day);
  }

  public void reject() {
    this.state = State.REJECTED;
    Utils.print("Project rejected");
  }

  public void getState(){
    switch (this.state) {
      case WAITING_FOR_APPROVAL:
        Utils.print("Waiting for approval");
        break;
      case APPROVED:
        Utils.print("Approved");
        break;
      case REJECTED:
        Utils.print("Rejected");
        break;
    }
  }
  public void getProjectManagersName() {
    for (int i = 0; i < this.projectManagersName.length; i++) {
      Utils.print(this.projectManagersName[i]);
    }
  }

  public void getProjectManagersPhone() {
    for (int i = 0; i < this.projectManagersPhone.length; i++) {
      Utils.print(this.projectManagersPhone[i]);
    }
  }

  public void getProjectName() {
    Utils.print(this.projectName);
  }

  public void getClientName() {
    Utils.print(this.clientName);
  }

  public void getBudget() {
    Utils.print(this.budget);
  }

  public void getStages() {
    Utils.print(this.stages.getActiveStage());
  }

  public void getPlannedDateOfStart() {
    Utils.print(this.plannedDateOfStart);
  }

  public void getPlannedDateOfEnd() {
    Utils.print(this.plannedDateOfEnd);
  }
} 
