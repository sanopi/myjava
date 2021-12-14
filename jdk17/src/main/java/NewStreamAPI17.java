import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class NewStreamAPI17 {
    public static void main(String[] args) {
//        test1();
        test2();
    }
    private static void test1() {
        final Runtime runtime = Runtime.getRuntime();
        final List<List<Integer>> listList = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            listList.add(new ArrayList<>());
            for (int j = 0; j < 10; j++) {
                listList.get(i).add(j);
            }
        }

        final long s1 = System.nanoTime();
        List<Integer> flatten = listList.stream()
            .flatMap(list -> list.stream())
            .filter(i -> i % 3 == 0)
            .toList();
        System.out.println("time passed : " + (System.nanoTime() - s1));

        final long s2 = System.nanoTime();
        listList.stream()
            .mapMulti((list, consumer) -> list.forEach(i -> {
                if (i % 3 == 0)
                    consumer.accept(i);
                consumer.accept((long) i);
            }))
            .toList();
        System.out.println("time passed : " + (System.nanoTime() - s2));
    }

    private static void test2() {
        RootNode root = new RootNode(
            0,
            List.of(
                new LeafNode(1),
                new InternalNode(
                    2,
                    List.of(
                        new LeafNode(3),
                        new InternalNode(4, List.of(new LeafNode(5))),
                        new InternalNode(6, List.of(new LeafNode(7), new LeafNode(8)))
                    )
                )
            )
        );
        final List<Node> result = root.childNodes().stream()
            .mapMulti(Extractor::extractLeaf)
            .toList();
        System.out.println(result.stream().map(Node::num).toList());

        final List<Node> result2 = root.childNodes().stream()
            .flatMap(Extractor::extractLeaf2)
            .toList();
        System.out.println(result2.stream().map(Node::num).toList());

        final List<Node> result3 = root.childNodes().stream()
            .flatMap(Extractor::extractLeaf3)
            .toList();
        System.out.println(result3.stream().map(Node::num).toList());
    }

    private static class Extractor {
        private static void extractLeaf(Node node, Consumer<Node> consumer) {
            if (node instanceof LeafNode leafNode) {
                consumer.accept(leafNode);
            }
            if (node instanceof InternalNode internalNode) {
                internalNode.childNodes().forEach(nextNode -> extractLeaf(nextNode, consumer));
            }
        }
        private static Stream<Node> extractLeaf2(Node node) {
            Stream<Node> response = Stream.of();
            if (node instanceof LeafNode leafNode) {
                response = Stream.concat(response, Stream.of(leafNode));
            }
            if (node instanceof InternalNode internalNode) {
                for (final Node childNode : internalNode.childNodes()) {
                    response = Stream.concat(response, extractLeaf2(childNode));
                }
            }
            return response;
        }

        private static Stream<Node> extractLeaf3(Node node) {
            return doExtract(node).stream();
        }

        private static Collection<Node> doExtract(Node node) {
            Collection<Node> response = new ArrayList<>();
            if (node instanceof LeafNode leafNode) {
                response.add(leafNode);
            }
            if (node instanceof InternalNode internalNode) {
                internalNode.childNodes().forEach(childNode -> response.addAll(doExtract(childNode)));
            }
            return response;
        }
    }

    interface Node {
        int num();
    }

    private record LeafNode(int num) implements Node {}

    private record InternalNode(int num, Collection<Node> childNodes) implements Node {}

    private record RootNode(int num, Collection<Node> childNodes) implements Node {}
}
