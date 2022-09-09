package structure;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * 基于链表实现的bag.
 *
 * @author Japhy
 * @since 2022/5/17 16:33
 */
public class LinkedBag<T> implements Bag<T> {

    private Node<T> first;

    private int size;

    private static class Node<T> {

        private Node<T> next;

        private T t;

        public Node() {
        }
    }

    public LinkedBag() {
        this.size = 0;
        this.first = null;
    }

    @Override
    public void add(T t) {
        if (Objects.isNull(t)) {
            throw new NullPointerException();
        }
        Node<T> old = first;
        first = new Node<>();
        first.t = t;
        first.next = old;
        size++;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedBagIT();
    }

    private class LinkedBagIT implements Iterator<T> {

        private Node<T> current;

        public LinkedBagIT() {
            current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T t = current.t;
            current = current.next;
            return t;
        }
    }

    public static void main(String[] args) {
        LinkedBag<Integer> linkedBag = new LinkedBag<>();
        linkedBag.add(1);
        linkedBag.add(2);
        Iterator<Integer> iterator = linkedBag.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
        }
    }
}
