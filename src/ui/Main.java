package ui;

import model.Capsule;
import model.ProjectController;
import utils.Utils;

/**
 * Main class
 */
public class Main {
  private static final int[] capsuleCount = new int[4];
  private static final ProjectController projects = new ProjectController();
  private static int projectId;

  /**
   * Validate project number and return it if valid
   * @return projectId
   */
  private static int validateProject(){
    Utils.print("Insert project number: ");
    projectId = Utils.inputNumbers.nextInt();
    if (projectId > projects.getProjectCount() || projectId < 1) {
      Utils.print("Invalid project number");
      return validateProject();
    }
    return projectId;
  }

  /**
   * Check if there are projects created
   * @return true if there are no projects, false if there are projects
   */
  private static boolean projectExistence() {
    if (projects.getProjectCount() == 0) {
      Utils.print("No projects found, please create a project first.");
      return true;
    }
    return false;
  }
  /**
   * Main method
   * @param args console args but not used in this case
   */
  public static void main(String[] args) {
    int option, capsuleId;
    String collabName, type;
    do {
      Utils.menu();
      option = Utils.inputNumbers.nextInt();
      switch (option) {
        case 1:
          projects.createProject();
          break;
        case 2:
          validateProject();
          Utils.print("Stage number: ");
          int stage = Utils.inputNumbers.nextInt();
          if (stage <= 0 || stage > projects.getProject(projectId - 1).getStages().length) {
            Utils.print("Invalid stage number");
          } else {
            projects.getProject(projectId - 1).setActiveStage(stage);
          }
        case 3:
          validateProject();
          Utils.print("Insert collaborator name: ");
          collabName = Utils.inputString.readLine();
          Utils.print("Insert collaborator post: ");
          String collabPost = Utils.inputString.readLine();
          Utils.print("Insert description: ");
          String description = Utils.inputString.readLine();
          Utils.print("Insert learning: ");
          String learning = Utils.validateLearning();
          Utils.print("Insert type: ");
          type = Utils.validateType();
          Capsule capsule = new Capsule(collabName, collabPost, description, learning, type);
          projects.getProject(projectId - 1).getStage().addCapsule(capsule);
          switch (Utils.validateCapsule(type)) {
            case 0 -> capsuleCount[0]++;
            case 1 -> capsuleCount[1]++;
            case 2 -> capsuleCount[2]++;
            case 3 -> capsuleCount[3]++;
          }
          break;
        case 4:
          validateProject();
          Utils.print("Insert capsule number: ");
          capsuleId = Utils.inputNumbers.nextInt();
          if(capsuleId > projects.getProject(projectId - 1).getStage().getCapsules().length){
            Utils.print("The capsule number you entered is not valid. Please try again.");
            break;
          }
          projects.getProject(projectId - 1).getStage().getCapsules()[capsuleId - 1].setApproved();
          break;
        case 5:
          try {
            validateProject();
            Utils.print("Insert capsule number: ");
            capsuleId = Utils.inputNumbers.nextInt();
            projects.getProject(projectId - 1).getStage().getCapsules()[capsuleId - 1].generateHTML();
          } catch (Exception e) {
            Utils.print("Error: " + e);
          }
        case 6:
          if (projectExistence()) break;
          Utils.print("The number of capsules by type is: ");
          Utils.print("1. " + capsuleCount[0] + " capsules of type Technician");
          Utils.print("2. " + capsuleCount[1] + " capsules of type Management");
          Utils.print("3. " + capsuleCount[2] + " capsules of type Domain");
          Utils.print("4. " + capsuleCount[3] + " capsules of type Experience");
          break;
        case 7:
          Utils.print("Insert stage number: ");
          int stage1 = Utils.inputNumbers.nextInt();
          for (int i = 0; i < projects.getProjectCount(); i++) {
            projects.getProject(i).showLearnings(stage1);
          }
          break;
        case 8:
          if (projectExistence()) break;
          int maxCapsules = Utils.projectWithMostCapsules(projects.getAllProjects(), projects.getProjectCount());
          if (maxCapsules != -1) {
            Utils.print("The project with most capsules is: " + projects.getProject(maxCapsules).getProjectName());
          } else {
            Utils.print("No projects found");
          }
          break;
        case 9:
          if (projectExistence()) break;
          Utils.print("Insert collaborator name: ");
          collabName = Utils.inputString.readLine();
          Utils.checkCollabCapsules(projects.getAllProjects(), collabName, projects.getProjectCount());
          break;
        case 10:
          if (projectExistence()) break;
          Utils.print("Insert keyword: ");
          String keyword = Utils.inputString.readLine();
          Utils.print(Utils.checkLearningByKeyword(projects.getAllProjects(), keyword, projects.getProjectCount()));
          break;
        case 11:
          Utils.print("Exit.");
          break;
        default:
          Utils.print("Invalid option");
          break;
      }
    } while (option != 10);
  }
}