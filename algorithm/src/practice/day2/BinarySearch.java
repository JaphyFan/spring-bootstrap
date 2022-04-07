package practice.day2;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

/**
 * @author Japhy
 * @since 2020/6/11 14:34
 */
public class BinarySearch implements Search{
    @Override
    public <T extends Comparable<T>> int find(T[] arr, T key) {
        return search(arr, key, 0, arr.length - 1);
    }

    <T extends Comparable<T>> int search(T[] array, T key, int left, int right) {
        if (left > right) {
            return -1;
        }
        int middle = (left + right) >>> 1;
        int com = key.compareTo(array[middle]);
        if (com == 0) {
            return middle;
        }
        if (com > 0) {
            return search(array, key, middle + 1, right);
        }
        return search(array, key, left, middle - 1);
    }

    public static void main(String[] args) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        Integer[] integers =
            Stream.generate(() -> random.nextInt(100)).limit(40).sorted().toArray(Integer[]::new);
        System.out.println(Arrays.toString(integers));

        Search search = new BinarySearch();
        System.out.println(search.find(integers, 10));
    }
}
