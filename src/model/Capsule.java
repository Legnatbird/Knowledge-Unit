package model;

import java.util.GregorianCalendar;
import utils.Utils;

/**
 * Capsule class
 */
public class Capsule {

  private boolean approved = false;
  private final String collaboratorName;
  private final String collaboratorPost;
  private GregorianCalendar date;
  private final String description;
  private final String type;
  private final String learning;
  private int id;

  /**
   * Constructor of the class
   * @param collaboratorName name of the collaborator
   * @param collaboratorPost position of the collaborator
   * @param description description of the capsule
   * @param learning learning of the capsule
   * @param type type of the capsule
   */
  public Capsule(String collaboratorName, String collaboratorPost, String description, String learning, String type) {
    this.collaboratorName = collaboratorName;
    this.collaboratorPost = collaboratorPost;
    this.description = description;
    this.learning = learning;
    this.type = type;
    this.date = new GregorianCalendar();
    this.id = (int) (Math.random() * 1000000);
    Utils.print("Capsule created");
  }
  /**
   * Generate HTML
   */
  public void generateHTML() {
    if (this.approved) {
      Utils.print("Generating HTML...");
      Utils.print("Capsule published!");
    } else {
      Utils.print("Capsule not approved");
    }
  }
  /**
   * Set capsule as approved
   */
  public void setApproved() {
    this.approved = true;
    this.date = new GregorianCalendar();
    Utils.print("Capsule approved");
  }
  /**
   * Set capsule id
   * @param id capsule id
   */
  public void setId(int id) {
    this.id = id;
  }
  /**
   * Get capsule keywords
   * @return keywords
   */
  public String getKeywords() {
    return this.learning.substring(0, this.learning.lastIndexOf('#'));
  }
  /**
   * Get capsule id
   * @return id
   */
  public int getId() {
    return id;
  }

  /**
   * Get capsule type
   * @return type
   */
  public String getType() {
    return type;
  }

  /**
   * Get capsule learning
   * @return learning
   */
  public String getLearning() {
    return this.learning.substring(this.learning.indexOf('#', this.learning.indexOf('#') + 1) + 1);
  }

  /**
   * Get capsule collaborator name
   * @return collaborator name
   */
  public String getCollabName() {
    return collaboratorName;
  }

  /**
   * Get capsule approve status
   * @return approve status
   */
  public boolean getApproved() {
    return approved;
  }

  /**
   * Get capsule collaborator post
   * @return collaborator post
   */
  public String getCollaboratorPost() {
    return collaboratorPost;
  }

  /**
   * Get capsule description
   * @return description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Get capsule date
   * @return date
   */
  public GregorianCalendar getDate() {
    return date;
  }
}
