import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class MonthCalendar {

    private LocalDate currentDate;
    private LocalDate selectedDate;

    public MonthCalendar() {
        this.currentDate = LocalDate.now();
        this.selectedDate = currentDate;
    }

    public MonthCalendar(int numberOfMonth) {
        this();
        this.selectedDate = LocalDate.of(currentDate.getYear(), numberOfMonth, 1);
    }

    public LocalDate getCurrentDate() {
        return currentDate;
    }

    public LocalDate getSelectedDate() {
        return selectedDate;
    }

    public void setMonth(int numberOfMonth) {
        if (numberOfMonth > 12 || numberOfMonth < 1) {
            return;
        } else {
            selectedDate = LocalDate.of(currentDate.getYear(), numberOfMonth, 1);
        }
    }

    public String[][] getCalendarTable() {
        int numberOfWeeks = getNumberOfWeek(selectedDate.lengthOfMonth());
        String[][] calendarTable = createCalendarTable(numberOfWeeks);
        setDays(calendarTable);
        fillEmptyCells(calendarTable);
        return calendarTable;
    }

    private void fillEmptyCells(String[][] calendar) {
        for (int i = 0; i < calendar.length; i++) {
            for (int j = 0; j < calendar[i].length; j++) {
                if (calendar[i][j] == null) {
                    calendar[i][j] = " ";
                }
            }
        }
    }

    private void setDays(String[][] calendarTable) {
        for (int i = 1; i <= selectedDate.lengthOfMonth(); i++) {
            LocalDate day = LocalDate.of(selectedDate.getYear(), selectedDate.getMonth(), i);
            int weekNumber = getNumberOfWeek(day.getDayOfMonth());
            calendarTable[weekNumber][day.getDayOfWeek().getValue() - 1] = Integer.toString(day.getDayOfMonth());
        }
    }

    private int getNumberOfWeek(int day) {
        DateTimeFormatter weekFormatter = DateTimeFormatter.ofPattern("W");
        return Integer.parseInt(weekFormatter.format(LocalDate.of(selectedDate.getYear(), selectedDate.getMonth(), day)));
    }

    private String[][] createCalendarTable(int numberOfWeeks) {
        String[][] calendar = new String[numberOfWeeks + 1][7];
        Locale locale = Locale.getDefault();
        for (int i = 0; i < 7; i++) {
            calendar[0][i] = DayOfWeek.of(i + 1).getDisplayName(TextStyle.SHORT, locale);
        }
        return calendar;
    }
}