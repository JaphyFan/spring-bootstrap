package alg.sort;

import java.util.Arrays;

/**
 * 先构造堆，在每次删除最小元素，获得排序
 * 最优的利用时间和空间的方法
 * <p></p>
 * 增长数量级： NlogN
 * 少于2NlgN +2N次比较 和一半次数的交换
 * 无需任何额外空间
 * 缺点：数组元素无法和相邻元素进行比较，无法利用缓存
 *
 * @author Japhy
 * @since 2022/3/2 15:16
 */
public class  HeapSort {

    public static void sort(int[] nums) {
        int n = nums.length;
        for (int i = n / 2; i >= 1; i--) {
            sink(nums, i, n);
        }
        while (n > 1) {
            int k = nums[0];
            nums[0] = nums[n - 1];
            nums[n - 1] = k;
            n--;
            sink(nums, 1, n);
        }
    }

    private static void sink(int[] nums, int i, int n) {

        while (2 * i < n - 1) {
            int j = 2 * i;
            if (j < n  && nums[j] < nums[j + 1]) {
                j++;
            }
            if (nums[j] < nums[i]) {
                break;
            }
            int mid = nums[j];
            nums[j] = nums[i];
            nums[i] = mid;
            i = j;
        }
    }

    static int demo(int i) {
        System.out.println("inner:" + i);
        return i;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2, 5, 1, 3, 4, 3};
        sort(nums);
        System.out.println(Arrays.toString(nums));

        // int++ 在方法参数中会等方法执行完再执行
        int i = 0;
        System.out.println(demo(i--));
        System.out.println(demo(i));
    }
}
