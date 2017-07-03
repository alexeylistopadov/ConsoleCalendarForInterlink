public class CalendarConsoleWriter {

    public void writeCalendar(MonthCalendar monthCalendar) {
        String[][] days = monthCalendar.getCalendarTable();
        for (String[] week : days) {
            for (int i = 0; i < week.length; i++) {
                System.out.print(getTextColor(monthCalendar, week[i], i) + week[i] + "\t");
            }
            System.out.println();
        }
    }

    public String getTextColor(MonthCalendar monthCalendar, String day, int i) {
        if (day.equals(Integer.toString(monthCalendar.getCurrentDate().getDayOfMonth()))
                && monthCalendar.getCurrentDate().getMonth() == monthCalendar.getSelectedDate().getMonth()) {
            return "\u001B[34m";
        } else if (i >= 5) {
            return "\u001B[31m";
        } else {
            return "\u001B[0m";
        }
    }

}
