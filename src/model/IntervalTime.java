package model;

// import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

/**
 * IntervalTime class
 * @param startDate of the interval
 * @param endDate of the interval
 */
public record IntervalTime(GregorianCalendar startDate, GregorianCalendar endDate) { }