public class InstanceOf {
    public static void main(String[] args) {
        Object o = "aiueo";

        if (o instanceof String s) {
            for (final char c : s.toCharArray()) {
                System.out.println(c);
            }
        }
    }
}
