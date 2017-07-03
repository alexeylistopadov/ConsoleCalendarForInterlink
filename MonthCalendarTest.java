public class MonthCalendarTest {

    public static void main(String[] args) {
        try {
            if (args.length == 0) {
                CalendarConsoleWriter calendarConsoleWriter = new CalendarConsoleWriter();
                calendarConsoleWriter.writeCalendar(new MonthCalendar());
            } else {
                CalendarConsoleWriter calendarConsoleWriter = new CalendarConsoleWriter();
                calendarConsoleWriter.writeCalendar(new MonthCalendar(Integer.parseInt(args[0])));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
