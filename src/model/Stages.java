package model;

import utils.Utils;

public class Stages {

  private final Stage[] stages = new Stage[6];
  private int activeStage = 0;
  /*
   * Constructor
   * Create all stages
   */
  public Stages() {
    createStages();
  }
  /*
   * Create all stages
   */
  private void createStages() {
    stages[0] = new Stage("Start");
    stages[1] = new Stage("Analysis");
    stages[2] = new Stage("Design");
    stages[3] = new Stage("Execution");
    stages[4] = new Stage("Closure");
    stages[5] = new Stage("Monitoring and Control");
  }
  /*
   * Set active stage
   * @param stage
   */
  public void setStageActive(int stage) {
    if (stage > 0 && stage < 7) {
      stages[activeStage].setApproved();
      stages[activeStage].setInactive();
      stages[stage - 1].setActive();
      activeStage = stage - 1;
    } else {
      Utils.print("Stage number is out of range");
    }
  }
  /*
   * Get active stage
   * @return active stage
   */
  public Stage getActiveStage() {
    return stages[activeStage];
  }

  public Stage getStage(int stage) {
    return stages[stage];
  }

  public Stage[] getStages() {
    return stages;
  }
}