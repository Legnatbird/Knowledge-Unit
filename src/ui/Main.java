package ui;

import model.ProjectController;
import model.CapsuleController;
import utils.Utils;

/**
 * Main class
 */
public class Main {
  private static final ProjectController projects = new ProjectController();
  private static final CapsuleController capsules = new CapsuleController();
  /**
   * Main method
   * @param args console args but not used in this case
   */
  public static void main(String[] args) {
    int option, capsuleId, projectId, stage;
    String collabName;
    do {
      Utils.menu();
      option = Utils.inputNumbers.nextInt();
      switch (option) {
        case 1 -> projects.createProject();
        case 2 -> {
          projectId = projects.validateProject();
          Utils.print("Stage number: ");
          stage = Utils.inputNumbers.nextInt();
          if (stage <= 0 || stage > projects.getProject(projectId - 1).getStages().length) {
            Utils.print("Invalid stage number");
          } else {
            projects.getProject(projectId - 1).setActiveStage(stage);
          }
        }
        case 3 -> {
          projectId = projects.validateProject();
          projects.getProject(projectId - 1).getStage().addCapsule(capsules.createCapsule());
        }
        case 4 -> {
          projectId = projects.validateProject();
          Utils.print("Insert capsule number: ");
          capsuleId = Utils.inputNumbers.nextInt();
          if (capsuleId > projects.getProject(projectId - 1).getStage().getCapsules().length) {
            Utils.print("The capsule number you entered is not valid. Please try again.");
            break;
          }
          projects.getProject(projectId - 1).getStage().getCapsules()[capsuleId - 1].setApproved();
        }
        case 5 -> {
          projectId = projects.validateProject();
          Utils.print("Insert capsule number: ");
          capsuleId = Utils.inputNumbers.nextInt();
          projects.getProject(projectId - 1).getStage().getCapsules()[capsuleId - 1].generateHTML();
        }
        case 6 -> {
          if (projects.projectExistence()) break;
          capsules.printCapsulesByType();
        }
        case 7 -> {
          Utils.print("Insert stage number: ");
          stage = Utils.inputNumbers.nextInt();
          for (int i = 0; i < projects.getProjectCount(); i++) {
            projects.getProject(i).showLearnings(stage);
          }
        }
        case 8 -> {
          if (projects.projectExistence()) break;
          int maxCapsules = Utils.projectWithMostCapsules(projects.getAllProjects(), projects.getProjectCount());
          if (maxCapsules != -1) {
            Utils.print("The project with most capsules is: " + projects.getProject(maxCapsules).getProjectName());
          } else {
            Utils.print("No projects found");
          }
        }
        case 9 -> {
          if (projects.projectExistence()) break;
          Utils.print("Insert collaborator name: ");
          collabName = Utils.inputString.readLine();
          Utils.checkCollabCapsules(projects.getAllProjects(), collabName, projects.getProjectCount());
        }
        case 10 -> {
          if (projects.projectExistence()) break;
          Utils.print("Insert keyword: ");
          String keyword = Utils.inputString.readLine();
          Utils.print(Utils.checkLearningByKeyword(projects.getAllProjects(), keyword, projects.getProjectCount()));
        }
        case 11 -> Utils.print("Exit.");
        default -> Utils.print("Invalid option");
      }
    } while (option != 10);
  }
}