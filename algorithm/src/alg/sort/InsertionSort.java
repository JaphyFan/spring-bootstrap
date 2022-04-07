package alg.sort;

import edu.princeton.cs.introcs.StdRandom;
import java.util.Arrays;
import java.util.stream.IntStream;
import org.apache.commons.lang3.time.StopWatch;


/**
 * 插入排序.
 *
 * <p>将数组分为有序和无序的两个部分，将无序部分的元素插入到有序部分的适当位置.</p>
 *
 * <pre>
  |     | 有序   |  倒序 |
  |-----|-------|-------|
  | 比较 | N-1   | N方/2 |
  | 交换 | 0     | N方/2 |
 * </pre>
 * <p>平均比较次数～N方/4, 平均交换次数N方/4</p>
 *
 * <p> 输入模型为 规模为N的int[] nums.</p>
 *
 *
 * @author Japhy
 * @since 2022/2/18 14:10
 */
public class InsertionSort {

    /**
     * 使用插入后直接后移全部元素的方式.
     *
     */
    public static int[] sort1(int[] nums) {
        int N = nums.length;
        // 外层循环
        for (int i = 1; i < N; i++) {
            // 有序部分
            for (int j = 0; j < i; j++) {
                if (nums[i] <= nums[j]) {
                    int mid = nums[i];
                    // 倒过来处理, 实现移位交换
                    for (int k = i; k > j; k--) {
                        nums[k] = nums[k - 1];
                    }
                    nums[j] = mid;
                    break;
                }
            }
        }
        return nums;
    }

    /**
     * 使用纯交换来完成 插入步骤.
     *
     */
    public static int[] sort2(int[] nums) {
        int N = nums.length;
        // 外层循环
        for (int i = 1; i < N; i++) {
            // 有序部分
            for (int j = i; j > 0 && nums[j] < nums[j - 1]; j--) {
                int mid = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = mid;
            }
        }
        return nums;
    }


    public static void main(String[] args) {

        System.out.println(5210 % 6);
        int[] nums = new int[] {2, 5, 1, 6, 4, 3};
        sort1(nums);
        System.out.println(Arrays.toString(nums));

        int[] nums2 = new int[] {2, 5, 1, 6, 4, 3};
        sort2(nums2);
        System.out.println(Arrays.toString(nums2));

        int[] ints = IntStream.range(1, 200000).toArray();
        StdRandom.shuffle(ints);
        StopWatch started = StopWatch.createStarted();
        sort2(ints);
        started.stop();
        // System.out.println(Arrays.toString(ints));
        System.out.println(started.formatTime());
    }


}
