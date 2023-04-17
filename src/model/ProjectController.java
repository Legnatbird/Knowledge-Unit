package model;

import utils.Utils;

public class ProjectController {
  private final Project[] projects = new Project[10];
  private int projectCount = 0;
  public ProjectController() {

  }

  public void createProject() {
    projects[projectCount] = new Project();
    projects[projectCount].setState("Waiting for approval");
    Utils.print("Until the project is approved, you can only wait for approval or reject it");
    projectCount++;
  }

  public void approveProject(int projectNumber) {
    projects[projectNumber - 1].setState("Approved");
    Utils.print("Project approved");
    Utils.print("Insert project name:");
    projects[projectNumber - 1].setProjectName(Utils.inputString.readLine());
    projects[projectNumber - 1].setClientName(Utils.inputString.readLine());
    Utils.print("Insert project start date:");
    projects[projectNumber - 1].setPlannedDateOfStart(Utils.getGregorianCalendar());
    Utils.print("Insert project end date:");
    projects[projectNumber - 1].setPlannedDateOfEnd(Utils.getGregorianCalendar());
    Utils.print("Insert budget:");
    float budget = Utils.inputNumbers.nextFloat();
    projects[projectNumber - 1].setBudget(budget);
    String[] managersName = Utils.inputString.readLine().split(" ");
    projects[projectNumber - 1].setProjectManagersName(managersName);
    String[] managersPhone = Utils.inputString.readLine().split(" ");
    projects[projectNumber - 1].setProjectManagersPhone(managersPhone);
    projects[projectNumber - 1].approve();
    Utils.print("Setups completed");
  }

  public void getProjectState(int projectNumber) {
    projects[projectNumber - 1].getState();
  }
}
