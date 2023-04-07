package model;

import java.util.GregorianCalendar;
import utils.Utils;

/* 
 * Capsule class
 */
public class Capsule {

  private boolean approved = false;
  private final String[] collaboratorName;
  private final String[] collaboratorPost;
  private GregorianCalendar date;
  private final String description;
  private final String type;
  private final String learning;
  private int id;

  /*
   * Constructor
   * @param collaboratorName
   * @param collaboratorPost
   * @param description
   * @param learning
   * @param type
   */
  public Capsule(String collaboratorName, String collaboratorPost, String description, String learning, String type) {
    this.collaboratorName = collaboratorName.split(",");
    this.collaboratorPost = collaboratorPost.split(",");
    this.description = description;
    this.learning = learning;
    this.type = type;
    this.date = new GregorianCalendar();
    this.id = (int) (Math.random() * 1000000);
    Utils.print("Capsule created");
  }
  /*
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
  /*
   * Print capsule information
   */
  public void printCapsule() {
    for (int i = 0; i < this.collaboratorName.length; i++) {
      Utils.print("Collaborator: " + this.collaboratorName[i] + " " + this.collaboratorPost[i]);
    }
    Utils.print("Description: " + this.description);
    Utils.print("Type: " + this.type);
    Utils.print("Learning: " + this.learning);
    Utils.print("Id: " + this.id);
    Utils.print("Date: " + this.date);
    Utils.print("Approved: " + this.approved);
  }
  /*
   * Set capsule as approved
   */
  public void setApproved() {
    this.approved = true;
    this.date = new GregorianCalendar();
    Utils.print("Capsule approved");
  }
  /*
   * Set capsule id
   */
  public void setId(int id) {
    this.id = id;
  }
  /*
   * Get capsule keywords
   * @return keywords
   */
  public String getKeyWords() {
    String keywords = "";
    for (int i = 0; i < this.learning.length(); i++) {
      if (this.learning.charAt(i) == '#') {
        keywords = this.learning.substring(i + 1, this.learning.indexOf('#', i + 1));
      }
    }
    return keywords;
    /*
    I really not test the code up, but I think it's better than the code below
    String keyword = "";
    for (int i = 0; i < this.learning.length(); i++) {
      if (this.learning.charAt(i) == '#') {
        for (int j = i + 1; j < this.learning.length(); j++) {
          if (this.learning.charAt(j) == '#') {
            return keyword;
          }
          keyword += this.learning.charAt(j);
        }
      }
    }
    return keyword;
    */
  }
  /*
   * Get capsule id
   * @return id
   */
  public int getId() {
    return id;
  }

  public String getType() {
    return type;
  }

  public String getLearning() {
    String learning = "";
    for (int i = 0; i < this.learning.length(); i++) {
      if (this.learning.charAt(i) == '#') {
        for (int j = i + 1; j < this.learning.length(); j++) {
          if (this.learning.charAt(j) == '#') {
            i = j;
            break;
          }
        }
      }
      learning += this.learning.charAt(i);
    }
    return learning;
  }
}
