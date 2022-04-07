package structure;

import java.util.Iterator;

/**
 * @author Japhy
 * @since 2022/3/3 15:51
 */
public class Queue implements Iterable<Item> {

    public Queue() {
    }

    public void enqueue(Item t) {

    }

    public Item dequeue() {
        return new Item(1L, "3");
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    public boolean isEmpty() {
        return true;
    }

    public int size() {
        return 1;
    }
}
