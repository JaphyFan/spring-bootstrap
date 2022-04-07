package alg.sort;

import edu.princeton.cs.introcs.StdRandom;
import java.util.Arrays;
import java.util.stream.IntStream;
import org.apache.commons.lang3.time.StopWatch;

/**
 * 基于分治思想，NlgN，原地排序,偏爱随机性
 * <p></p>
 * 最多需要N的平方/2 次比较，平均为2NlnN， 平均交换次数为1/3NlnN次交换，对比归并排序，交换次数更少
 * 分区位置很关键，为保证效率，在排序前先随机处理。
 * 缺点：切分不平衡时性能大大降低.
 * <p></p>
 * 三向切分能在有大量重复元素的情况下将性能提高到线性.
 *
 * @author Japhy
 * @since 2022/2/25 13:56
 */
public class QuickSort {

    public static void sort(int[] nums, int lo, int hi) {

        if (hi <= lo) {
            return;
        }
        int j = partition(nums, lo, hi);
        sort(nums, lo, j - 1);
        sort(nums, j + 1, hi);
    }

    private static int partition(int[] nums, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int v = nums[lo]; // 初始元素
        while (true) {
            while (nums[++i] < v) {
                if (i == hi) {
                    break;
                }
            }
            while (nums[--j] > v) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            int mid = nums[i];
            nums[i] = nums[j];
            nums[j] = mid;
        }
        nums[lo] = nums[j];
        nums[j] = v;
        return j;
    }

    public static void quick3Way(int[] nums, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int lt = lo;
        int i = lo + 1;
        int gt = hi;
        int v = nums[lo];
        while (i <= gt) {
            if (nums[i] < v) {
                int newLt = lt++;
                int newI = i++;
                int mid = nums[newLt];
                nums[newLt] = nums[newI];
                nums[newI] = mid;
            } else if (nums[i] > v) {
                int newGt = gt--;
                int mid = nums[i];
                nums[i] = nums[newGt];
                nums[newGt] = mid;
            } else {
                i++;
            }
        }
        quick3Way(nums, lo, lt - 1);
        quick3Way(nums, gt + 1, hi);
    }

    public static void main(String[] args) {
        int[] ints = IntStream.range(1, 200000).toArray();
        StopWatch started = StopWatch.createStarted();
        // int[] ints = new int[] {1, 5, 4, 5};
        StdRandom.shuffle(ints);
        sort(ints, 0, ints.length - 1);
        started.stop();
        System.out.println(started.formatTime());
        // System.out.println(Arrays.toString(ints));

        int[] ints2 = new int[] {1, 5, 4, 5, 2, 7};
        StdRandom.shuffle(ints2);
        quick3Way(ints2, 0, ints2.length - 1);
        System.out.println(Arrays.toString(ints2));
    }

}
