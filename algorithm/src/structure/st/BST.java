package structure.st;

import java.util.Objects;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import structure.ST.Key;
import structure.ST.Value;
import structure.SortedST;

/**
 * @author Japhy
 * @since 2022/5/16 17:05
 */
public class BST extends SortedST<Key, Value> {

    private Node root;

    @Getter
    @Setter
    @EqualsAndHashCode
    private class Node {

        private Key key;

        private Value value;

        private Node left, right;

        private int size;

    }
    @Override
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node node, Key key) {
        Node res = null;
        for (Node x = root; x != null; ) {
            if (key.compareTo(node.getKey()) > 0) {
                x = x.getRight();
            } else if (key.compareTo(node.getKey()) < 0) {
                x = x.getLeft();
            } else {
                x = node;
                res = node;
            }
        }
        if (Objects.isNull(res)) {
            return null;
        }
        return res.getValue();
    }

    @Override
    public void put(Key key, Value value) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterable<Key> keys() {
        return null;
    }

    @Override
    public void delete(Key key) {
        super.delete(key);
    }

    @Override
    public boolean contain(Key key) {
        return super.contain(key);
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public Key min() {
        return null;
    }

    @Override
    public Key max() {
        return null;
    }

    @Override
    public int rank(Key key) {
        return 0;
    }

    @Override
    public Key select(int k) {
        return null;
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        return null;
    }
}
