public class RecordExample {
    public static void main(String[] args) {
        final MyClass myClass = new MyClass("abc", 10);
        System.out.println(myClass.s());
        System.out.println(myClass.i());
        System.out.println(myClass.repeatString());
        System.out.println(myClass.hashCode());
        System.out.println(myClass.equals(new MyClass("abc", 10)));
        System.out.println(myClass.equals(new MyClass("abc", 9)));
        System.out.println(myClass.toString());
    }

//    private static record MyClass(String s, int i) {
//        public String repeatString() {
//            return this.s.repeat(i);
//        }
//    }
}
