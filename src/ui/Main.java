package ui;

import model.Capsule;
import model.Project;
import utils.Utils;

public class Main {

    private static final Project[] projects = new Project[10];
    private static int projectCount = 0;

    public static void main(String[] args) {
        int option, projectId, capsuleId;
        do {
            Utils.menu();
            option = Utils.inputNumbers.nextInt();
            switch (option) {
                case 1:
                    projects[projectCount] = new Project();
                    projectCount++;
                    break;
                case 2:
                    Utils.print("Number of project");
                    int project = Utils.inputNumbers.nextInt();
                    Utils.print("Stage number: ");
                    int stage = Utils.inputNumbers.nextInt();
                    projects[project - 1].getStages().setStageActive(stage);
                    break;
                case 3:
                    Utils.print("Insert project number: ");
                    projectId = Utils.inputNumbers.nextInt();
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
                    break;
                case 4:
                    Utils.print("Insert project number: ");
                    projectId = Utils.inputNumbers.nextInt();
                    Utils.print("Insert capsule id: ");
                    capsuleId = Utils.inputNumbers.nextInt();
                    projects[projectId - 1].getStage().getCapsules()[capsuleId - 1].setApproved();
                    break;
                case 5:
                    Utils.print("Insert project number: ");
                    projectId = Utils.inputNumbers.nextInt();
                    Utils.print("Insert capsule id: ");
                    capsuleId = Utils.inputNumbers.nextInt();
                    projects[projectId - 1].getStage().getCapsules()[capsuleId - 1].generateHTML();
                case 7:
                    Utils.print("Exit.");
                default:
                    Utils.print("Invalid option");
                    break;
            }
        } while (option != 7);
    }
}