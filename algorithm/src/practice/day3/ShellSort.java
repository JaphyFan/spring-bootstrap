package practice.day3;

import edu.princeton.cs.introcs.StdRandom;
import java.util.Arrays;
import java.util.stream.IntStream;
import org.apache.commons.lang3.time.StopWatch;

/**x
 * why, 针对插入排序对输入模型的波动，最少比较n-1次，交换0次的线性增长数量级，将数据模型部分有序化。
 * 增长数量级为n的2分之3次.
 *
 * @author Japhy
 * @since 2022/4/28 15:01
 */
public class ShellSort {

    private static void sort(int[] arr) {
        int n = arr.length;
        int h = 1;
        // 递增序列设置为3h+1
        while (h < n / 3) {
            h = h * 3 + 1;
        }
        while (h >= 1) {
            for (int i = 0; i < h; i++) {
                for (int j = i + h; j < n; j += h) {
                    for (int k = j; k >= h; k = k - h) {
                        if (arr[k - h] > arr[k]) {
                            int mid = arr[k - h];
                            arr[k - h] = arr[k];
                            arr[k] = mid;
                        }
                    }
                }
            }
            h = h / 3;
        }
    }

    private static void sort2(int[] arr) {
        int n = arr.length;
        int h = 1;
        // 递增序列设置为3h+1
        while (h < n / 3) {
            h = h * 3 + 1;
        }
        while (h >= 1) {
            for (int j = h; j < n; j++) {
                for (int k = j; k >= h; k = k - h) {
                    if (arr[k - h] > arr[k]) {
                        int mid = arr[k - h];
                        arr[k - h] = arr[k];
                        arr[k] = mid;
                    }
                }
            }
            h = h / 3;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {2, 5, 3, 1, 4, 8};

        sort(arr);
        System.out.println(Arrays.toString(arr));

        int[] ints = IntStream.range(1, 10_0000).toArray();
        StdRandom.shuffle(ints);
        var ints2 = Arrays.copyOf(ints, ints.length);

        StopWatch s1 = new StopWatch();
        s1.start();
        sort(ints2);
        s1.stop();
        System.out.printf("s time: %s%n", s1.formatTime());

        StopWatch s2 = new StopWatch();
        s2.start();
        sort2(ints);
        s2.stop();
        System.out.printf("s 2 time : %s %n", s2.formatTime());
    }
}
