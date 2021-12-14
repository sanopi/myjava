import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsTeeing {


    public static void main(String[] args) {
        Map.Entry<String, Long> result = Stream.of("a", "b", "c", "d")
            .collect(Collectors.teeing(
                Collectors.joining(","),
                Collectors.counting(),
                Map::entry
            ));
        System.out.println(result.getKey()); // => a,b,c,d
        System.out.println(result.getValue()); // => 4

        String result1 = Stream.of("a", "b", "c", "d")
            .collect(Collectors.joining(","));
        Long result2 = Stream.of("a", "b", "c", "d")
            .collect(Collectors.counting());
//        Map.Entry<String, Long> result = Map.entry(result1, result2);
//
//        var result1 = getStream().collect(downstream1);
//        var result2 = getStream().collect(downstream2);
//        var result = merger.apply(result1, result2);

    }
}
