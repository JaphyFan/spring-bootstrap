package practice.day3;

import java.util.Arrays;

/**
 * @author Japhy
 * @since 2022/5/7 15:55
 */
public class QuickSort {

    public static void sort(int[] arr, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(arr, lo, hi);
        sort(arr, lo, j - 1);
        sort(arr, j + 1, hi);
    }

    public static int partition(int[] arr, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int h = arr[lo];

        while (true) {
            while (arr[++i] < h) {
                if (i == hi) {
                    break;
                }
            }
            while (arr[--j] > h) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            int mid = arr[i];
            arr[i] = arr[j];
            arr[j] = mid;
        }
        int mid = arr[j];
        arr[j] = arr[lo];
        arr[lo] = mid;
        return j;
    }

    public static void quck3Way(int[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int lt = lo;
        int i = lo + 1;
        int gt = hi;
        int h = a[lo];
        while (i <= gt) {
            if (a[i] < h) {
                int mid = a[i];
                a[i] = a[lt];
                a[lt] = mid;
                i++;
                lt++;
            } else if (a[i] > h) {
                int mid = a[gt];
                a[gt] = a[i];
                a[i] = mid;
                gt--;
            } else {
                i++;
            }
        }
        quck3Way(a, lo, lt - 1);
        quck3Way(a, gt + 1, hi);
    }

    public static void main(String[] args) {
        int[] arr = new int[] {4, 2, 6, 3, 8, 5};
        quck3Way(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

}
