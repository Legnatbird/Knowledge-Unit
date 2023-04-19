package model;

import utils.Utils;

public class ProjectController {
  private final Project[] projects = new Project[10];
  private short projectCount = 0;
  public ProjectController() {

  }

  public void createProject() {
    short MAX_PROJECTS = 10;
    if (projectCount == MAX_PROJECTS) {
      Utils.print("ERROR: Maximum number of projects reached.");
      return;
    }
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

  public short getProjectCount() {
    return projectCount;
  }

  public Project getProject(int projectNumber) {
    return projects[projectNumber - 1];
  }
  public Project[] getAllProjects() {
    return projects;
  }

  public void setActiveStage(int projectNumber, int stageNumber) {
    projects[projectNumber - 1].setActiveStage(stageNumber);
  }

  /**
   * Check if there are projects created
   * @return true if there are no projects, false if there are projects
   */
  public boolean projectExistence() {
    if (this.projectCount == 0) {
      Utils.print("No projects found, please create a project first.");
      return true;
    }
    return false;
  }

  /**
   * Validate project number and return it if valid
   * @return projectId
   */
  public int validateProject(){
    Utils.print("Insert project number: ");
    int projectId = Utils.inputNumbers.nextInt();
    if (projectId > projectCount || projectId < 1) {
      Utils.print("Invalid project number");
      return validateProject();
    }
    return projectId;
  }
}
