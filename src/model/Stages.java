package model;

// import java.util.GregorianCalendar;

public class Stages {

  private Stage[] stages = new Stage[6];

  public Stages() {
    createStages();
  }

  private void createStages() {
    stages[0] = new Stage("Start");
    stages[1] = new Stage("Analysis");
    stages[2] = new Stage("Design");
    stages[3] = new Stage("Execution");
    stages[4] = new Stage("Closure");
    stages[5] = new Stage("Monitoring and control of the project");
  }

}
