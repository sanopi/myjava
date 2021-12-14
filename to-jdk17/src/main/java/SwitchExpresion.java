import java.time.DayOfWeek;
import java.time.LocalDate;

public class SwitchExpresion {

    public static void main(String[] args) {
        final DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
        statement(dayOfWeek);
        expression(dayOfWeek);
    }

    private static void statement(DayOfWeek dayOfWeek) {
        String japanese;
        switch (dayOfWeek) {
            case MONDAY:
                japanese = "月曜日";
                break;
            case TUESDAY:
                japanese = "火曜日";
                break;
            case WEDNESDAY:
                japanese = "水曜日";
                break;
            case THURSDAY:
                japanese = "木曜日";
                break;
            case FRIDAY:
                japanese = "金曜日";
                break;
            case SATURDAY:
                japanese = "土曜日";
                break;
            case SUNDAY:
                japanese = "日曜日";
                break;
            default:
                throw new IllegalStateException("想定されないエラー: " + dayOfWeek);
        }
        System.out.println(japanese);
    }

    private static void expression(DayOfWeek dayOfWeek) {
        String japanese = switch (dayOfWeek) {
            case MONDAY -> "月曜日";
            case TUESDAY -> "火曜日";
            case WEDNESDAY -> "水曜日";
            case THURSDAY -> "木曜日";
            case FRIDAY -> "金曜日";
            case SATURDAY -> "土曜日";
            case SUNDAY -> "日曜日";
        };
        System.out.println(japanese);
    }
}
