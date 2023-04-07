package utils;

import java.util.GregorianCalendar;
import java.util.Scanner;
import java.io.Console;
import model.Project;

/**
 * Utils class
 */
public class Utils {

  /**
   * This class contains all repeated methods and variables in the project
   */
  public static Scanner inputNumbers = new Scanner(System.in);

  /**
   * Reading of strings with spaces and special characters utf-8
   */
  public static Console inputString = System.console();

  private static final String[] types = { "Technician", "Management", "Domain", "Experience" };

  /**
   * Print method
   * @param uwu object to be printed
   */
  public static void print(Object uwu) {
    System.out.println(uwu);
  }

  /**
   * Set a date with year, month and day
   * @param year of the date
   * @param month of the date
   * @param day of the date
   * @return GregorianCalendar date
   */
  public static GregorianCalendar getGregorianCalendar(int year, int month, int day) {
    GregorianCalendar date = new GregorianCalendar();
    date.set(year, month, day);
    return date;
  }

  /**
   * Print menu
   */
  public static void menu() {
    print("1. Create project");
    print("2. End actual project stage");
    print("3. Create capsule");
    print("4. Approve capsule");
    print("5. Publish capsule");
    print("6. Show capsules by type");
    print("7. Show learnings by stage");
    print("8. Check project with most capsules");
    print("9. Check if a collaborator do a capsule");
    print("10. Check learnings of approved capsules by keyword");
    print("11. Exit");
  }

  /**
   * Validate if the input has a keyword with # # format and return it
   * @return String
   */
  public static String validateLearning() {
    String learning = inputString.readLine();
    if (learning.contains("#") && learning.lastIndexOf("#") != 0) {
      return learning;
    } else {
      print("Learning must contain a keyword with # at the beginning and at the end");
      return validateLearning();
    }
  }

  /**
   * Validate if the input is a type of capsule and return it
   * @return type
   */
  public static String validateType() {
    String type = inputString.readLine();
    for (String s : types) {
      if (type.equals(s)) {
        return type;
      }
    }
    print("Type must be Technician, Management, Domain or Experience");
    return validateType();
  }
  /**
   * Validate the index of the type of capsule
   * @param type of capsule
   * @return index of the type
   */
  public static int validateCapsule(String type) {
    for (int i = 0; i < types.length; i++) {
      if (type.equals(types[i])) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Return the index of the project with most capsules
   * @param projects array
   * @param projectCount of the array
   * @return index of the project with most capsules
   */
  public static int projectWithMostCapsules(Project[] projects, int projectCount) {
    if (projects == null || projectCount < 1) {
      return -1;
    }
    int max = 0;
    int index = 0;
    for (int i = 0; i < projectCount; i++) {
      if (projects[i] == null) {
        return -1;
      }
      if (projects[i].capsulesLength() > max) {
        max = projects[i].capsulesLength();
        index = i;
      }
    }
    return index;
  }

  /**
   * Check if a collaborator do a capsule
   * @param collabName of the collaborator
   * @param projects array
   * @param projectCount of the array
   */
  public static void checkCollabCapsules(Project[] projects, String collabName, int projectCount) {
    if (projects == null || projectCount < 1) {
      return;
    }
    print("Enter the collaborator name");
    for (int i = 0; i < projectCount; i++) {
      int length = projects[i].getCapsules().length;
      for (int j = 0; j < length; j++) {
        String validate = projects[i].getCapsules()[j].getCollabName();
        if (validate.equals(collabName)) {
          Utils.print("The collaborator " + collabName + " do a capsule in the project: " + projects[i].getProjectName());
        }
      }
    }
  }

  /**
   * Check learnings of approved capsules by keyword
   * @param projects array
   * @param keyword to be searched
   * @param projectCount of the array
   * @return learning of the capsule
   */
  public static String checkLearningByKeyword(Project[] projects, String keyword, int projectCount) {
    if (projects == null || projectCount < 1) {
      Utils.print("There are no projects");
      return null;
    }
    for (int i = 0; i < projectCount; i++) {
      int length = projects[i].getCapsules().length;
      for (int j = 0; j < length; j++) {
        if (!projects[i].getCapsules()[j].getApproved()) {
          continue;
        }
        String validate = projects[i].getCapsules()[j].getLearning();
        if (validate.contains(keyword)) {
          return validate;
        }
      }
    }
    Utils.print("There are no learnings with the keyword " + keyword);
    return null;
  }
}