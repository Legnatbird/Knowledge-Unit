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
}
