package utils;

import java.util.GregorianCalendar;
import java.util.Scanner;
import java.io.Console;
import model.Project;

/*
 * Utils class
 */
public class Utils {

  /*
   * This class contains all repeated methods and variables in the project
   */
  public static Scanner inputNumbers = new Scanner(System.in);

  public static Console inputString = System.console();

  private static final String[] types = { "Technician", "Management", "Domain", "Experience" };

  /*
   * Print method
   */
  public static void print(Object uwu) {
    System.out.println(uwu);
  }

  /*
   * Set a date with year, month and day
   * 
   * @return GregorianCalendar
   */
  public static GregorianCalendar getGregorianCalendar(int year, int month, int day) {
    GregorianCalendar date = new GregorianCalendar();
    date.set(year, month, day);
    return date;
  }

  /*
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
    print("9. Exit");
  }

  /*
   * Validate if the input has a keyword with # # format and return it
   * 
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

  /*
   * Validate if the input is a type of capsule and return it
   * 
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
  /*
   * Validate the index of the type of capsule
   * 
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

  /*
   * Return the index of the project with most capsules
   * 
   * @return index of the project
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

}