package model;

import java.util.GregorianCalendar;
import utils.Utils;

public class Capsule {

  private boolean approved = false;
  private String[] collaboratorName;
  private String[] collaboratorPost;
  private GregorianCalendar date;
  private String description;
  private String type;
  private String learning;
  private int id;

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

  public void generateHTML() {
    if (this.approved) {
      Utils.print("Generating HTML");
    } else {
      Utils.print("Capsule not approved");
    }
  }

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

  public void setApproved() {
    this.approved = true;
    this.date = new GregorianCalendar();
  }

  public void setId(int id) {
    this.id = id;
  }
  
  public String getKeyWords() {
    String keywords = "";
    for (int i = 0; i < this.learning.length(); i++) {
      if (this.learning.charAt(i) == '#') {
        keywords = this.learning.substring(i + 1, this.learning.indexOf('#', i + 1));
      }
    }
    return keywords;
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
    return date;
  }

  public boolean getApproved() {
    return approved;
  }

  public String getDescription() {
    return description;
  }

  public String getType() {
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
