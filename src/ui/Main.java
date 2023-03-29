package ui;

import model.Capsule;
import model.Project;
import utils.Utils;

public class Main {

    private static Project[] projects = new Project[10];
    private static int projectCount = 0;
    private static int option;

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
                    Utils.print("Project number: ");
                    int project = Utils.inputNumbers.nextInt();
                    Utils.print("Stage number: ");
                    int stage = Utils.inputNumbers.nextInt();
                    projects[project - 1].getStages().setStageActive(stage);
                    break;
                case 3:
                    String collabName = Utils.inputString.readLine();
                    String collabPost = Utils.inputString.readLine();
                    String description = Utils.inputString.readLine();
                    String learning = Utils.validateLearning();
                    String type = Utils.validateType();
                    Capsule capsule = new Capsule(collabName, collabPost, description, learning, type);
                    capsule.printCapsule();
                    break;
                case 7:
                    Utils.print("Exit.");
                default:
                    Utils.print("Invalid option");
                    break;
            }
        } while (option != 7);
    }
}