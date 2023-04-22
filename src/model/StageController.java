package model;

import utils.Utils;

/**
 * Stage class
 */
public class StageController {

  private final Stage[] stages = new Stage[6];
  private short activeStage = 0;
  /**
   * Constructor
   * Create all stages
   */
  public StageController() {
    createStages();
  }
  /**
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
  /**
   * Set active stage
   */
  public void setStageActive() {
    if (activeStage == 5) {
      Utils.print("The project is already finished");
      return;
    }
    stages[activeStage].setApproved();
    stages[activeStage].setInactive();
    stages[activeStage + 1].setActive();
    activeStage = (short) (activeStage + 1);
  }
  /**
   * Get active stage
   * @return active stage
   */
  public Stage getActiveStage() {
    return stages[activeStage];
  }

  public short getActiveStageNumber() {
    return activeStage;
  }

  /**
   * Get stage by number
   * @param stage number
   * @return stage by index
   */
  public Stage getStage(int stage) {
    return stages[stage - 1];
  }
  /**
   * Get all stages
   * @return stages
   */
  public Stage[] getStages() {
    return stages;
  }
}