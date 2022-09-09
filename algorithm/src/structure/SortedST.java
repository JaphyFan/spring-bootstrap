package structure;

import structure.ST.Key;

/**
 * 有序符号表.
 *
 * @author Japhy
 * @since 2022/5/12 16:56
 */
public abstract class SortedST<K extends Comparable<Key>, V> extends ST<K, V> {

    public abstract K min();

    public abstract K max();

    public abstract int rank(K key);

    public abstract K select(int k);

    public abstract Iterable<Key> keys(K lo, K hi);

}
