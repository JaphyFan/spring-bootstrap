package structure;

import java.util.Iterator;

/**
 *
 * 不支持删除
 * @author Japhy
 * @since 2022/3/3 15:48
 */
public class Bag implements Iterable<Item> {

    private Item[] itmes;

    public Bag() {
    }

    public void add(Item t) {

    }

    public boolean isEmpty() {
        return true;
    }

    public int size() {
        return 1;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }
}
