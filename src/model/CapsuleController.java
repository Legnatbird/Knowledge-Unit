package model;

import utils.Utils;

/**
 * CapsuleController class
 */
public class CapsuleController {

  private final int[] capsuleCount = new int[4];

  /**
   * CapsuleController constructor
   */
  public CapsuleController() {

  }

  /**
   * Creates a capsule
   * @return the capsule created
   */
  public Capsule createCapsule() {
    Utils.print("Insert collaborator name: ");
    String collabName = Utils.inputString.readLine();
    Utils.print("Insert collaborator post: ");
    String collabPost = Utils.inputString.readLine();
    Utils.print("Insert description: ");
    String description = Utils.inputString.readLine();
    Utils.print("Insert learning: ");
    String learning = Utils.validateLearning();
    Utils.print("Insert type (Technician, Management, Domain, Experience): ");
    String type = Utils.validateType();
    switch (Utils.validateCapsule(type)) {
      case 0 -> capsuleCount[0]++;
      case 1 -> capsuleCount[1]++;
      case 2 -> capsuleCount[2]++;
      case 3 -> capsuleCount[3]++;
    }
    return new Capsule(collabName, collabPost, description, learning, type);
  }

  /**
   * Prints the number of capsules by type
   */
  public void printCapsulesByType(){
    Utils.print("The number of capsules by type is: ");
    Utils.print("1. " + capsuleCount[0] + " capsules of type Technician");
    Utils.print("2. " + capsuleCount[1] + " capsules of type Management");
    Utils.print("3. " + capsuleCount[2] + " capsules of type Domain");
    Utils.print("4. " + capsuleCount[3] + " capsules of type Experience");
  }
}
