package model;

import java.util.GregorianCalendar;

public class Capsule {

  enum capsuleType {
    TECHNICIAN, MANAGEMENT, DOMAIN, EXPERIENCE
  }

  private String colaboratorName;
  private String colaboratorPost;
  private GregorianCalendar date;
  private String description;
  private capsuleType type;
  private String learning;
  private int id;

  public Capsule() {
    System.out.println("Capsule created");
  }

  public void setColaboratorName(String name) {
    this.colaboratorName = name;
  }

  public void setColaboratorPost(String post) {
    this.colaboratorPost = post;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setType(capsuleType type) {
    this.type = type;
  }

  public void setLearning(String learning) {
    this.learning = learning;
  }
  
  
  public void setId(int id) {
    this.id = id;
  }
  
  public void setDate() {
    this.date = new GregorianCalendar();
  }

  public String getColaboratorName() {
    return colaboratorName;
  }

  public String getColaboratorPost() {
    return colaboratorPost;
  }

  public String getDescription() {
    return description;
  }

  public capsuleType getType() {
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
