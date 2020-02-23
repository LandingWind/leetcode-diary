import java.time.LocalDate;
class Solution {
    public int daysBetweenDates(String date1, String date2) {
        LocalDate dateTime1 = LocalDate.parse(date1);
        LocalDate dateTime2 = LocalDate.parse(date2);
        int diff = (int)(dateTime1.toEpochDay()-dateTime2.toEpochDay());

        return Math.abs(diff);
    }
}