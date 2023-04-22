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
   * @param stage to be set active
   */
  public void setStageActive(short stage) {
    if (stage > 0 && stage < 7) {
      stages[activeStage].setApproved();
      stages[activeStage].setInactive();
      stages[stage - 1].setActive();
      activeStage = (short) (stage - 1);
    } else {
      Utils.print("Stage number is out of range");
    }
  }
  /**
   * Get active stage
   * @return active stage
   */
  public Stage getActiveStage() {
    return stages[activeStage];
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