public record MyClass(String s, int i) {
    public MyClass {
        if (s == null) {
            throw new RuntimeException();
        }
    }

    public String repeatString() {
        return this.s.repeat(i);
    }
}
