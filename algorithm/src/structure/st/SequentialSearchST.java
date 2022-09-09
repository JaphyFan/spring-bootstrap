package structure.st;

import java.util.Iterator;
import structure.KVNode;
import structure.ST;
import structure.ST.Key;
import structure.ST.Value;

/**
 * 基于无序链表实现的符号表.
 *
 * @author Japhy
 * @since 2022/5/12 17:12
 */
public class SequentialSearchST extends ST<Key, Value> {

    private KVNode<Key, Value> first;

    private int size;

    @Override
    public Value get(Key key) {
        for (KVNode<Key, Value> node = first; node != null; node = node.getNext()) {
            if (node.getKey().equals(key)) {
                return node.getValue();
            }
        }
        return null;
    }

    @Override
    public void put(Key key, Value value) {
        for (KVNode<Key, Value> node = first; node != null; node = node.getNext()) {
            if (node.getKey().equals(key)) {
                node.setValue(value);
                return;
            }
        }
        this.first = new KVNode<>(key, value, first);
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterable<Key> keys() {
        return null;
    }

    @Override
    public void delete(Key key) {
        if (!contain(key)) {
            return;
        }
        super.delete(key);
    }

    @Override
    public boolean contain(Key key) {
        if (key == null) {
            return false;
        }
        for (KVNode<Key, Value> node = first; node.getNext() != null; node = node.getNext()) {
            if (node.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    private class KeyIt implements Iterator<Key> {

        private KVNode<Key, Value> curr = first;

        @Override
        public boolean hasNext() {
            return curr.getNext() != null;
        }

        @Override
        public Key next() {
            curr = curr.getNext();
            return curr.getKey();
        }
    }

    public static void main(String[] args) {
        SequentialSearchST st = new SequentialSearchST();
        st.put(new Key("f"), new Value("v"));
        st.put(new Key("j"), new Value("s"));
        System.out.println(st.get(new Key("f")));
    }
}
