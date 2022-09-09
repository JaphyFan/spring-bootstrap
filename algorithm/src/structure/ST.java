package structure;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 符号表抽象实现
 * 1。增/改
 * 2。删
 * 3。查
 * 4。contain
 * 5. isEmpty
 * 6. size
 * 7. keys
 * @author Japhy
 * @since 2022/5/12 16:48
 */
public abstract class ST<K, V> {

    public abstract V get(K key);

    public abstract void put(K key, V value);

    public abstract int size();

    public abstract Iterable<K> keys();

    public void delete(K key) {
        put(key, null);
    }

    public boolean contain(K key) {
        return get(key) != null;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    @ToString
    @Getter
    @Setter
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class Key implements Comparable<Key> {

        private String name;


        @Override
        public int compareTo(Key o) {
            return name.compareTo(o.getName());
        }
    }

    @ToString
    @Getter
    @Setter
    @AllArgsConstructor
    public static class Value {

        private String value;
    }

}
