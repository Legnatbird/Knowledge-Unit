package model;

public class Proyect {

  enum State {
    WAITING_FOR_APPROVAL, APPROVED, REJECTED
  }

  private String name;
  private String client;
  private int budget;
  private String[] projectManagersName;
  private String[] projectManagersPhone;
  private State state = State.WAITING_FOR_APPROVAL;
  private Stages stages = new Stages();


  public Proyect(String name, String client, int budget, String[] projectManagersName, String[] projectManagersPhone) {
    this.name = name;
    this.client = client;
    this.budget = budget;
    this.projectManagersName = projectManagersName;
    this.projectManagersPhone = projectManagersPhone;
  }

  private void approve() {
    this.state = State.APPROVED;
  }

  private void reject() {
    state = State.REJECTED;
  }
} 
