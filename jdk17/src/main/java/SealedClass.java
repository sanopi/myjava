import java.util.Collection;
import java.util.Objects;

public class SealedClass {
}

sealed interface Hoge {}

sealed interface DDD extends Hoge {}

final class AAA implements DDD {}

abstract sealed class Node permits AdditionalNode, InternalNode, LeafNode, RootNode {
    abstract int num();
}

final class LeafNode extends Node {
    private final int num;
    LeafNode(int num) {
        this.num = num;
    }
    @Override
    public int num() {
        return num;
    }
}

final class InternalNode extends Node {
    private final int num;
    private final Collection<Node> childNodes;
    InternalNode(int num, Collection<Node> childNodes) {
        this.num = num;
        this.childNodes = childNodes;
    }
    @Override
    public int num() {
        return num;
    }
}

final class RootNode extends Node {
    private final int num;
    private final Collection<Node> childNodes;
    RootNode(int num, Collection<Node> childNodes) {
        this.num = num;
        this.childNodes = childNodes;
    }
    @Override
    public int num() {
        return num;
    }
    public Collection<Node> childNodes() {
        return childNodes;
    }
}

non-sealed class AdditionalNode extends Node {
    private final int num;
    AdditionalNode(int num) {
        this.num = num;
    }
    @Override
    public int num() {
        return num;
    }
}


class AdditionalNode2 extends AdditionalNode {
    AdditionalNode2(int num) {
        super(num);
    }
    @Override
    public int num() {
        return super.num();
    }

}


