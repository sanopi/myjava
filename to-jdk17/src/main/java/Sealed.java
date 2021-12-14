public class Sealed {
    public static void main(String[] args) {
    }
}

sealed interface A permits A.B, A.C {
    final class B implements A {

    }
    non-sealed class C implements A {
        private static class D extends C {

        }

    }
}
