package ui;

import model.Capsule;
import model.Project;
import utils.Utils;

public class Main {

    private static final Project[] projects = new Project[10];
    private static int option, projectId, capsuleId;
    private static int projectCount = 0;


    private static int validateProject(){
        Utils.print("Insert project number: ");
        projectId = Utils.inputNumbers.nextInt();
        if (projectId > projectCount || projectId < 1) {
            Utils.print("Invalid project number");
            validateProject();
        }
        return projectId;
    }

    public static void main(String[] args) {
        do {
            Utils.menu();
            option = Utils.inputNumbers.nextInt();
            switch (option) {
                case 1:
                    projects[projectCount] = new Project();
                    projectCount++;
                    break;
                case 2:
                    validateProject();
                    Utils.print("Stage number: ");
                    int stage = Utils.inputNumbers.nextInt();
                    projects[projectId - 1].getStages().setStageActive(stage);
                    break;
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
                    break;
                case 4:
                    validateProject();
                    Utils.print("Insert capsule id: ");
                    capsuleId = Utils.inputNumbers.nextInt();
                    projects[projectId - 1].getStage().getCapsules()[capsuleId - 1].setApproved();
                    break;
                case 5:
                    validateProject();
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