package alg.sort;

import edu.princeton.cs.introcs.StdRandom;
import java.util.Arrays;
import java.util.stream.IntStream;
import org.apache.commons.lang3.time.StopWatch;

/**
 * 归并排序： 时间复杂度为NlgN，空间复杂度为N,最多访问数组6NlgN次。 使用分治思想，可处理百万级数据.
 * 渐进最优的比较排序算法。
 * <ol>
 *     <li>1. 原地归并排序</li>
 *     <li>2. 自顶向下的归并</li>
 *     <li>3. 自底向上的归并</li>
 * </ol>
 *
 * 当子数组规模小于15时可使用插入或选择排序， 提高百分之10
 * @author Japhy
 * @since 2022/2/24 15:05
 */
public class MergeSort {

    /**
     * 可比较2数，例 nums[1]
     * mid = 0, 左边nums[0,0], 右边nums[1,1]
     *
     */
    public static int[] merge(int[] nums, int lo, int mid, int hi) {
        int[] aux = new int[nums.length];
        int l = lo;
        int r = mid + 1;
        for (int i = lo; i <= hi; i++) {
            aux[i] = nums[i];
        }
        for (int i = lo; i <= hi; i++) {
            // 四种情况
            // 左边无值可取
            if (l > mid) {
                nums[i] = aux[r++];
            }
            // 右边无值可取
            else if (r > hi) {
                nums[i] = aux[l++];
            }
            // 左边大于右边，取右边
            else if (aux[l] > aux[r]) {
                nums[i] = aux[r++];
            }
            // 右边大于左边，取左
            else {
                nums[i] = aux[l++];
            }
        }
        return nums;
    }

    /**
     * 自顶向下的归并排序方式.
     */
    public static void topMerge(int[] nums, int lo, int hi) {

        if (lo >= hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        topMerge(nums, lo, mid);
        topMerge(nums, mid + 1, hi);
        merge(nums, lo, mid, hi);
    }

    /**
     * 适合链表结构.
     *
     */
    public static int[] buttonMerge(int[] nums) {
        int n = nums.length;
        for (int sz = 1; sz < n; sz = sz + sz) {
            for (int lo = 0; lo < n - sz; lo += sz + sz) {
                merge(nums, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, n - 1));
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 3, 6, 2, 5, 8};
        merge(nums, 0, 0 + (nums.length - 1 - 0) / 2, nums.length - 1);
        System.out.println(Arrays.toString(nums));

        int[] topNums = new int[] {4, 3, 6, 2, 9, 5, 1};
        // 第一次，mid = 2 sort(nums, 0, 2) sort(nums, 3, 5)
        //  左边 mid = 1 sort(nums, 0, 1) sort(nums, 2, 2) merge()
        //  右边 mid = 4 sort(nums, 3, 4) sort(nums, 4, 5) merge()
        // merge()
        topMerge(topNums, 0, topNums.length - 1);
        System.out.println(Arrays.toString(topNums));

        // sz = 1
        //    merge[nums, 0, 0, 1]
        //    merge[nums, 2, 2, 3]
        //    merge[nums, 4, 4, 5]
        //    merge[mums, 6, 6, 6]
        // sz = 2
        //   merge[nums, 0, 1, 3]
        //   merge[nums, 4, 5, 6]
        // sz = 4
        //    merge[nums, 0, 3, 6]
        buttonMerge(topNums);
        System.out.println(Arrays.toString(topNums));

        int[] ints = IntStream.range(1, 200000).toArray();
        StdRandom.shuffle(ints);
        StopWatch started = StopWatch.createStarted();
        topMerge(ints, 0, ints.length - 1);
        started.stop();
        System.out.println(started.formatTime());

    }
}
