package ui;

import model.Capsule;
import model.Project;
// import utils.Utils;

public class Main {

    public static void main(String[] args) {
        // Create a new project and into the first stage add 2 capsules
        Project project = new Project();
        project.approve();
        Capsule capsule = new Capsule("Alejandro","Gerente","Hola mundo","#OOP#", "Technician");
        project.getStage().addCapsule(capsule);
    }
}