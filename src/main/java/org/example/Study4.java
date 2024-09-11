package org.example;

public class Study4 {
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
        if (isValidDate(day, month, year)) {
            return String.valueOf(totalDays(day, month, year));
        } else {
            return "Invalid date";
        }
    }

    private boolean isValidDate(int day, int month, int year) {
        return isValidYear(year) && isValidMonth(month) && isValidDayInMonth(day, month, year);
    }

    private boolean isValidYear(int year) {
        return year >= ZERO_YEAR;
    }

    private boolean isValidMonth(int month) {
        return JANUARY <= month && month <= DECEMBER;
    }

    private boolean isValidDayInMonth(int day, int month, int year) {
        int monthLength = LENGTH_OF_MONTH[month];
        if (month == FEBRUARY && isLeapYear(year)) {
            monthLength += 1;
        }
        return day > 0 && day <= monthLength;
    }

    private boolean isLeapYear(int year) {
        return !(year % 4 != 0 || (year % 100 == 0 && year % 400 != 0));
    }

    private int totalDays(int day, int month, int year) {
        return daysBeforeYear(year) + daysBeforeMonth(month, year) + day;
    }

    private int daysBeforeYear(int endYear) {
        int days = 0;
        for (int year = ZERO_YEAR; year < endYear; year++) {
            days += daysInYear(year);
        }
        return days;
    }

    private int daysInYear(int year) {
        int days = 365;
        if (isLeapYear(year)) {
            days += 1;
        }
        return days;
    }

    private int daysBeforeMonth(int endMonth, int year) {
        int days = 0;
        for (int month = JANUARY; month < endMonth; month++) {
            days += LENGTH_OF_MONTH[month];
            if (month == FEBRUARY && isLeapYear(year)) {
                days += 1;
            }
        }
        return days;
    }
}
