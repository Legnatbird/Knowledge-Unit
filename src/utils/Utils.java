package utils;

import java.util.GregorianCalendar;
import java.util.Scanner;
import java.io.Console;

/*
 * Utils class
 */
public class Utils {

  /*
   * This class contains all repeated methods and variables in the project
   */
  public static Scanner inputNumbers = new Scanner(System.in);

  public static Console inputString = System.console();
  /*
   * Print method
   */
  public static void print(Object uwu){
    System.out.println(uwu);
  }
  /*
   * Set a date with year, month and day
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
    print("7. Exit");
  }
  /*
   * Validate if the input has a keyword with # # format and return it
   * @return String
   */
  public static String validateLearning(){
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
   * @return type
   */
  public static String validateType() {
    String type = inputString.readLine();
    if (type.equals("Technician") || type.equals("Management") || type.equals("Domain") || type.equals("Experience")) {
      return type;
    } else {
      print("Type must be Technician, Management, Domain or Experience");
      return validateType();
    }
  }
}
