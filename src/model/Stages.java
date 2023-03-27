package model;

// import java.util.GregorianCalendar;

public class Stages {

  private Stage[] stages = new Stage[6];
  public Stages() {
    createStages();
    setStageActive(0);
  }

  private void createStages() {
    stages[0] = new Stage("Start");
    stages[1] = new Stage("Analysis");
    stages[2] = new Stage("Design");
    stages[3] = new Stage("Execution");
    stages[4] = new Stage("Closure");
    stages[5] = new Stage("Monitoring and Control");
  }

  public void setStageActive(int stage) {
    for (int i = 0; i < stages.length; i++) {
      stages[i].setInactive();
    }
    stages[stage - 1].setActive();
  }

  public String getActiveStage() {
    String activeStage = "";
    for (int i = 0; i < stages.length; i++) {
      if (stages[i].isActive()) {
        activeStage = stages[i].getStageName();
        break;
      }
    }
    return activeStage;
  }
}
