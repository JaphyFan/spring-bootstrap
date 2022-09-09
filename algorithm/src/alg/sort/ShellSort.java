package alg.sort;

import edu.princeton.cs.introcs.StdRandom;
import java.util.Arrays;
import java.util.stream.IntStream;
import org.apache.commons.lang3.time.StopWatch;

/**
 * 希尔排序.
 * <p></p>
 * 希尔排序是在插入排序基础之上，先使数组部分有序，在用插入排序最终排序。
 * 高效原因：权衡了子数组的规模和有序性。
 * 比插入排序快百倍
 * <p></p>
 * 递增序列h的选择 最坏情况，N的2分之3次
 *
 * @author Japhy
 * @since 2022/2/24 09:37
 */
public class ShellSort {

    public static void sort(int[] nums) {

        int n = nums.length;
        int h = 1;
        while (h < n / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && nums[j] < nums[j - h]; j -= h) {
                    int mid = nums[j];
                    nums[j] = nums[j - h];
                    nums[j - h] = mid;
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

    public static void main(String[] args) {
        int[] nums = new int[] {2, 5, 1, 6, 4, 3};
        sort(nums);
        System.out.println(Arrays.toString(nums));

        int[] ints = IntStream.range(1, 200000).toArray();
        StdRandom.shuffle(ints);
        StopWatch started = StopWatch.createStarted();
        sort(ints);
        started.stop();
        System.out.println(started.formatTime());
    }

}
