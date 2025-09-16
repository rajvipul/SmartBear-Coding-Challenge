package com.smartBear;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BritishSpokenTime {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java BritishSpokenTime <HH:MM>");
            return;
        }

        String input = args[0].trim();
        try {
            System.out.println(toSpokenForm(input));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static String toSpokenForm(String timeStr) {
        String[] parts = timeStr.split(":");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid time format. Use HH:MM.");
        }
        int hour;
        int min;
        try {
            hour = Integer.parseInt(parts[0]);
            min = Integer.parseInt(parts[1]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid numbers in time.");
        }
        if (hour < 0 || hour > 23 || min < 0 || min > 59) {
            throw new IllegalArgumentException("Time out of range (00:00 to 23:59).");
        }

        if (hour == 0 && min == 0) {
            return "midnight";
        }
        if (hour == 12 && min == 0) {
            return "noon";
        }

        int displayHour = hour % 12;
        if (displayHour == 0) {
            displayHour = 12;
        }
        String hourWord = numberToWord(displayHour);

        if (min == 0) {
            return hourWord + " o'clock";
        }

        // Special minutes for past/to: 5,10,15,20,25,30
        Set<Integer> specialMins = new HashSet<>(Arrays.asList(5, 10, 15, 20, 25, 30));

        boolean usePastTo = false;
        String connector = "";
        String minWord = "";
        int useMin;
        int targetHour = displayHour;

        if (min <= 30 && specialMins.contains(min)) {
            usePastTo = true;
            connector = " past ";
            if (min == 15) {
                minWord = "quarter";
            } else if (min == 30) {
                minWord = "half";
            } else {
                minWord = numberToWord(min);
            }
        } else if (min > 30 && specialMins.contains(60 - min)) {
            usePastTo = true;
            connector = " to ";
            useMin = 60 - min;
            targetHour = (displayHour % 12) + 1;
            if (useMin == 15) {
                minWord = "quarter";
            } else {
                minWord = numberToWord(useMin);
            }
        }

        if (usePastTo) {
            String targetHourWord = numberToWord(targetHour);
            return minWord + connector + targetHourWord;
        } else {
            String minStr;
            if (min < 10) {
                minStr = "oh " + numberToWord(min);
            } else {
                minStr = numberToWord(min);
            }
            return hourWord + " " + minStr;
        }
    }

    private static String numberToWord(int num) {
        String[] below20 = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] tens = {"", "", "twenty", "thirty", "forty", "fifty"};
        if (num == 0) {
            return "zero";
        }
        if (num < 20) {
            return below20[num];
        }
        int tenDigit = num / 10;
        int oneDigit = num % 10;
        String word = tens[tenDigit];
        if (oneDigit > 0) {
            word += "-" + below20[oneDigit];
        }
        return word;
    }
}
