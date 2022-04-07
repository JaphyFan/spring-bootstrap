package alg.sort;

import java.util.Arrays;
import java.util.stream.IntStream;
import org.apache.commons.lang3.time.StopWatch;

/**
 * 选择排序.
 *
 * <p>给定数量为N 的 int[] nums,遍历所有元素，将最小的和最左边的元素互换，依次进行到最后。
 * 比较次数 ～N的平方/2, 交换次数 N
 * 优点：
 * <ol>
 *     <li>移动次数最少，和输入成线性关系</li>
 *     <li>运行时间和输入无关，输入为有序和无序都需要同等时间</li>
 * </ol>
 *
 * 输入模型
 * 内循环
 * 成本模型
 * 执行频率和算法分析
 * @author Japhy
 * @since 2022/2/17 13:12
 */
public class SelectSort {

    public static int[] selectSort(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] >= nums[j]) {
                    int f = nums[i];
                    nums[i] = nums[j];
                    nums[j] = f;
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2, 5, 1, 3, 4, 3};
        selectSort(nums);
        System.out.println(Arrays.toString(nums));

        int[] ints = IntStream.range(1, 20000000).toArray();
        StopWatch started = StopWatch.createStarted();
        selectSort(ints);
        started.stop();
        System.out.println(started.formatTime());
    }

}
