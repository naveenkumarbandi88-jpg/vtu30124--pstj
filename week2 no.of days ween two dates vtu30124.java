class Solution {
    public int daysBetweenDates(String date1, String date2) {
        return Math.abs(toDays(date1) - toDays(date2));
    }

    private int toDays(String date) {
        String[] parts = date.split("-");

        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);

        int total = 0;

        // Days in all previous years
        for (int y = 1971; y < year; y++) {
            total += isLeapYear(y) ? 366 : 365;
        }

        // Days in previous months of current year
        int[] daysInMonth = {
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
        };

        for (int m = 1; m < month; m++) {
            total += daysInMonth[m - 1];

            if (m == 2 && isLeapYear(year)) {
                total++;
            }
        }

        // Days in current month
        total += day;

        return total;
    }

    private boolean isLeapYear(int year) {
        return (year % 400 == 0) ||
               (year % 4 == 0 && year % 100 != 0);
    }
}


Input
date1 =
"2019-06-29"
date2 =
"2019-06-30"
Output
1
Expected
1



