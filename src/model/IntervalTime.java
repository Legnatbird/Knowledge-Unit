package model;

// import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/*
 * IntervalTime class
 */
public record IntervalTime(GregorianCalendar startDate, GregorianCalendar endDate) { }