package ui;

import model.Capsule;
import model.Project;

public class Main {

    public static void main(String[] args) {
        Project project = new Project();
        project.approve();
        Capsule capsule = new Capsule("Alejandro","Gerente","Hola mundo","#OOP#", "Technician");
        project.getStage().addCapsule(capsule);
        for (int i = 0; i < project.getStage().getCapsules().length; i++) {
            project.getStage().getCapsules()[i].printCapsule();
        }
    }
}