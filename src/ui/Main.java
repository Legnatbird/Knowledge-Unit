package ui;

import model.ProjectController;
import model.CapsuleController;
import utils.Utils;

/**
 * Main class
 */
public class Main {
  // Project controller
  private static final ProjectController projects = new ProjectController();
  /**
    Capsule controller, this is tricky because every project has a stage and every stage has capsules
    so for handle this we need to create a capsule controller and use it in the main class
    with this we optimize the code, and we don't need to create a capsule controller in every project
    and when we need to create a capsule we just call the capsule controller and create a capsule,
    the most interesting thing is we store all the capsules in the capsule controller, and we can
    access to them from every project and stage for example if we want to know how many capsules
    we have we just call the capsule controller and ask for the capsule count or if we want to
    know the capsule type we just call the capsule controller and ask for the capsule type.
  */
  private static final CapsuleController capsules = new CapsuleController();
  /**
   * Main method
   * @param args console args but not used in this case
   */
  public static void main(String[] args) {
    /*
      This is the main menu, here we have a switch case with all the options
      and, we use a do while loop to keep the menu until the user choose the exit option
    */
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
            projects.getProject(projectId - 1).setActiveStage((short) stage);
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
        case 11 -> Utils.print("Bye, bye ^^");
        default -> Utils.print("Invalid option");
      }
    } while (option != 10);
  }
}