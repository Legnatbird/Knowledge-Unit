package utils;

import java.util.GregorianCalendar;
import java.util.Scanner;
import java.io.Console;

public class Utils {

  public static Scanner inputNumbers = new Scanner(System.in);

  public static Console inputString = System.console();

  public static void print(Object uwu){
    System.out.println(uwu);
  }
  public static GregorianCalendar getGregorianCalendar(int year, int month, int day) {
    GregorianCalendar date = new GregorianCalendar();
    date.set(year, month, day);
    return date;
  }

  public static void menu() {
    print("1. Create project");
    print("2. End a project stage");
    print("3. Create capsule");
    print("4. Approve capsule");
    print("5. Publish capsule");
  }

  public static String validateLearning(){
    String learning = inputString.readLine();
    if (learning.contains("#") && learning.lastIndexOf("#") != 0) {
      return learning;
    } else {
      print("Learning must contain a keyword with # at the beginning and at the end");
      return validateLearning();
    }
  }

  public static String validateType() {
    String type = inputString.readLine();
    if (type.equals("Technician") || type.equals("Management") || type.equals("Domain") || type.equals("Experience")) {
      return type;
    } else {
      print("Type must be technician, management, domain or experience");
      return validateType();
    }
  }
}
