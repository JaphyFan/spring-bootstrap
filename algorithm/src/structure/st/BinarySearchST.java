package structure.st;

import java.util.Iterator;
import structure.ST.Key;
import structure.ST.Value;
import structure.SortedST;

/**
 * 基于数组实现的有序字符表，使用二分查找
 * @author Japhy
 * @since 2022/5/16 15:51
 */
public class BinarySearchST extends SortedST<Key, Value> {

    private Key[] keys;

    private Value[] values;

    private int size;

    public BinarySearchST() {
        keys = new Key[16];
        values = new Value[16];
    }

    @Override
    public Value get(Key key) {
        return get(key, 0, size - 1);
    }

    private Value get(Key key, int lo, int hi) {

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key.compareTo(keys[mid]) > 0) {
                lo = mid + 1;
            } else if (key.compareTo(keys[mid]) < 0) {
                hi = mid - 1;
            } else {
                return values[lo];
            }
        }
        return values[lo];
    }

    @Override
    public void put(Key key, Value value) {

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
    public Iterable<Key> keys(Key lo, Key hi) {
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
    public int rank(Key key)  {
        return 0;
    }

    @Override
    public Key select(int k) {
        return null;
    }

}
