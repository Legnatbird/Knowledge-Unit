package ui;

import model.Capsule;
import model.Project;
import utils.Utils;

public class Main {
  private static final Project[] projects = new Project[10];
  private static final int[] capsuleCount = new int[4];
  private static final int MAX_PROJECTS = 10;
  private static int projectCount = 0;
  private static int projectId;

  /*
   * Validate project number and return it if valid
   * @return projectId
   */
  private static int validateProject(){
    Utils.print("Insert project number: ");
    projectId = Utils.inputNumbers.nextInt();
    if (projectId > projectCount || projectId < 1) {
      Utils.print("Invalid project number");
      return validateProject();
    }
    return projectId;
  }
  /*
   * Main method
   * @param args but not used
   */
  public static void main(String[] args) {
    int option;
    int capsuleId;
    do {
      Utils.menu();
      option = Utils.inputNumbers.nextInt();
      switch (option) {
        case 1:
          if (projectCount == MAX_PROJECTS) {
            System.out.println("ERROR: Maximum number of projects reached.");
          } else {
            projects[projectCount] = new Project();
            projects[projectCount].approve();
            projectCount++;
          }
          break;
        case 2:
          validateProject();
          Utils.print("Stage number: ");
          int stage = Utils.inputNumbers.nextInt();
          if (stage <= 0 || stage > projects[projectId - 1].getStages().getStages().length) {
            Utils.print("Invalid stage number");
          } else {
            projects[projectId - 1].getStages().setStageActive(stage);
          }
        case 3:
          validateProject();
          Utils.print("Insert collaborator name: ");
          String collabName = Utils.inputString.readLine();
          Utils.print("Insert collaborator post: ");
          String collabPost = Utils.inputString.readLine();
          Utils.print("Insert description: ");
          String description = Utils.inputString.readLine();
          Utils.print("Insert learning: ");
          String learning = Utils.validateLearning();
          Utils.print("Insert type: ");
          String type = Utils.validateType();
          Capsule capsule = new Capsule(collabName, collabPost, description, learning, type);
          projects[projectId - 1].getStage().addCapsule(capsule);
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
          if(capsuleId > projects[projectId - 1].getStage().getCapsules().length){
            Utils.print("The capsule number you entered is not valid. Please try again.");
            break;
          }
          projects[projectId - 1].getStage().getCapsules()[capsuleId - 1].setApproved();
          break;
        case 5:
          try {
            validateProject();
            Utils.print("Insert capsule number: ");
            capsuleId = Utils.inputNumbers.nextInt();
            projects[projectId - 1].getStage().getCapsules()[capsuleId - 1].generateHTML();
          } catch (Exception e) {
            Utils.print("Error: " + e);
          }
        case 6:
          Utils.print("Insert type: ");
          String type1 = Utils.validateType();
          Utils.print("The number of capsules of type " + type1 + " is: " + capsuleCount[Utils.validateCapsule(type1)]);
          break;
        case 7:
          Utils.print("Insert stage number: ");
          int stage1 = Utils.inputNumbers.nextInt();
          for (int i = 0; i < projectCount; i++) {
            projects[i].showLearnings(stage1);
          }
        case 8:
          int maxCapsules = Utils.projectWithMostCapsules(projects, projectCount);
          if (maxCapsules != -1) {
            Utils.print("The project with most capsules is: " + projects[maxCapsules].getProjectName());
          } else {
            Utils.print("No projects found");
          }
        case 9:
          Utils.print("Exit.");
          break;
        default:
          Utils.print("Invalid option");
          break;
      }
    } while (option != 8);
  }
}