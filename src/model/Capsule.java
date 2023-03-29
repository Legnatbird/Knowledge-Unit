package model;

import java.util.GregorianCalendar;
import utils.Utils;

public class Capsule {

  enum CapsuleType {
    TECHNICIAN, MANAGEMENT, DOMAIN, EXPERIENCE
  }

  private GregorianCalendar endDate;
  private String collaboratorName;
  private String collaboratorPost;
  private GregorianCalendar date;
  private String description;
  private boolean approved;
  private CapsuleType type;
  private String learning;
  private int id;

  public Capsule() {
    Utils.print("Capsule created");
    this.id = (int) (Math.random() * 1000000);

  }

  public void generateHTML() {
    if (this.approved) {
      Utils.print("Generating HTML");
    } else {
      Utils.print("Capsule not approved");
    }
  }

  public void printCapsule() {
    Utils.print("Collaborator name: " + this.collaboratorName);
    Utils.print("Collaborator post: " + this.collaboratorPost);
    Utils.print("Description: " + this.description);
    Utils.print("Type: " + this.type);
    Utils.print("Learning: " + this.learning);
    Utils.print("Id: " + this.id);
    Utils.print("Date: " + this.date);
    Utils.print("Approved: " + this.approved);
  }

  public void setCollaboratorName(String name) {
    this.collaboratorName = name;
  }

  public void setCollaboratorPost(String post) {
    this.collaboratorPost = post;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setType(CapsuleType type) {
    this.type = type;
  }

  public void setLearning(String learning) {
    if (this.learning.contains("#") && this.learning.lastIndexOf("#") != 0) {
      this.learning = learning;
    } else {
      Utils.print("Learning must contain a keyword with # at the beginning and at the end");
    }
  }

  
  public void setId(int id) {
    this.id = id;
  }

  public void setDate() {
    this.date = new GregorianCalendar();
  }

  public void setApproved() {
    this.approved = true;
    this.endDate = new GregorianCalendar();
  }

  public String getKeyWords() {
    for (int i = 0; i < this.learning.length(); i++) {
      if (this.learning.charAt(i) == '#') {
        return this.learning.substring(i + 1, this.learning.indexOf('#', i + 1));
      }
    }
    return "";
    /*
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

  public GregorianCalendar getEndDate() {
    return endDate;
  }

  public boolean getApproved() {
    return approved;
  }

  public String getCollaboratorName() {
    return collaboratorName;
  }

  public String getCollaboratorPost() {
    return collaboratorPost;
  }

  public String getDescription() {
    return description;
  }

  public CapsuleType getType() {
    return type;
  }

  public String getLearning() {
    return learning;
  }

  public int getId() {
    return id;
  }

  public GregorianCalendar getDate() {
    return date;
  }
}
