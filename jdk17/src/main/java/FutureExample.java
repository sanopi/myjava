import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class FutureExample {

    public static void main(String[] args) throws Exception {
        final Future<String> future = Executors.newCachedThreadPool().submit(() -> Thread.currentThread().toString());

        System.out.println(future.get());
        System.out.println(Thread.currentThread().toString());
    }

}
