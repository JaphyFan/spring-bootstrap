package practice.day3;

import edu.princeton.cs.introcs.StdRandom;
import java.util.Arrays;
import java.util.stream.IntStream;
import org.apache.commons.lang3.time.StopWatch;
import org.checkerframework.common.value.qual.IntRange;

/**
 * 比较为1/2NlgN到 NlgN之间，访问数组次数6NlgN.
 *
 * @author Japhy
 * @since 2022/5/7 10:10
 */
public class MergeSort {

    private int[] aux;

    public MergeSort(int[] arr) {
        aux = new int[arr.length];
    }

    public void merge(int[] a, int lo, int hi, int mid) {
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) {
             if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (aux[i] > aux[j]) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    public void insertionSort(int[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            for (int j = i; j > 0 && a[j] < a[j - 1]; j--) {
                int mid = a[j];
                a[j] = a[j - 1];
                a[j - 1] = mid;
            }
        }
    }

    public void sort(int[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        // 1. 子数组规模小于5时使用插入排序, 1.5s 较少了0.1s
        if (hi - lo <= 5) {
            insertionSort(a, lo, hi);
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        // 2.增加判断, 如果子数组有序，不用归并
        if (a[mid + 1] < a[mid]) {
            merge(a, lo, hi, mid);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[] {3, 5, 1, 2, 9, 6};
        MergeSort mergeSort = new MergeSort(a);
        mergeSort.sort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));

        int[] ints = IntStream.range(1, 1000_0000).toArray();
        StdRandom.shuffle(ints);
        MergeSort mergeSort1 = new MergeSort(ints);
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        mergeSort1.sort(ints, 0, ints.length - 1);
        stopWatch.stop();
        System.out.println(String.format("used time: %s", stopWatch.formatTime()));
    }
}
