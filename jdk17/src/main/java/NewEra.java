import java.time.chrono.JapaneseChronology;
import java.time.chrono.JapaneseDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class NewEra {

    public static void main(String[] args) {
        final String gggGy年M月d日 = DateTimeFormatter.ofPattern("GGGGy年M月d日").
            withChronology(JapaneseChronology.INSTANCE).
            withLocale(Locale.JAPAN).
            format(JapaneseDate.of(2020, 2, 1));
        System.out.println(gggGy年M月d日);
    }
}
