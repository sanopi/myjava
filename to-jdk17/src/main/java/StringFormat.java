public class StringFormat {

    public static void main(String[] args) {
        // 今まで
        StringFormat.transformer2(StringFormat.transformer1(" my string "));
        // これから
        " my string ".transform(StringFormat::transformer1).transform(StringFormat::transformer2);
    }

    private static String transformer1(String base) {
        return base.repeat(2);
    }

    private static String transformer2(String base) {
        return base.repeat(3).strip();
    }
}
