package org.example;

public class Study3 {
    public final int JANUARY = 0;
    public final int FEBRUARY = 1;
    public final int MARCH = 2;
    public final int APRIL = 3;
    public final int MAY = 4;
    public final int JUNE = 5;
    public final int JULY = 6;
    public final int AUGUST = 7;
    public final int SEPTEMBER = 8;
    public final int OCTOBER = 9;
    public final int NOVEMBER = 10;
    public final int DECEMBER = 11;

    public final int[] LENGTH_OF_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public final int ZERO_YEAR = 1900;

    public String main(int day, int month, int year) {
        // Is the year valid?
        boolean isValidYear = year >= ZERO_YEAR;
        // Is the month valid?
        boolean isValidMonth = JANUARY <= month && month <= DECEMBER;
        int monthLength = -1;
        if (isValidMonth) {
            monthLength = LENGTH_OF_MONTH[month];
        }
        // Is the year a leap year?
        boolean isLeapYear = !(year % 4 != 0 || (year % 100 == 0 && year % 400 != 0));
        if (month == FEBRUARY && isLeapYear) {
            monthLength += 1;
        }
        // Is the day in the month valid?
        boolean isValidDay = day > 0 && day <= monthLength;
        // Is the given date valid?
        if (isValidDay && isValidMonth && isValidYear) {
            int days = 0;
            // Days before the year.
            for (int aYear = ZERO_YEAR; aYear < year; aYear++) {
                days += 365;
                isLeapYear = !(aYear % 4 != 0 || (aYear % 100 == 0 && aYear % 400 != 0));
                if (isLeapYear) {
                    days += 1;
                }
            }
            // Days before the month
            for (int aMonth = JANUARY; aMonth < month; aMonth++) {
                days += LENGTH_OF_MONTH[aMonth];
                isLeapYear = !(year % 4 != 0 || (year % 100 == 0 && year % 400 != 0));
                if (aMonth == FEBRUARY && isLeapYear) {
                    days += 1;
                }
            }
            days += day;
            return String.valueOf(days);
        } else {
            return "Invalid date";
        }
    }
}
