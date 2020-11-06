package day2;

/**
 * 给定一个整数类型的数组 nums，请编写一个能够返回数组“中心索引”的方法.
 *
 * @author Japhy
 * @since 2020/6/10 15:11
 *
 * 输入:
 * nums = [1, 7, 3, 6, 5, 6]
 * 输出: 3
 * 解释:
 * 索引3 (nums[3] = 6) 的左侧数之和(1 + 7 + 3 = 11)，与右侧数之和(5 + 6 = 11)相等。
 * 同时, 3 也是第一个符合要求的中心索引。
 * 时间复杂度 O(n).
 *
 */
public class PivotIndex {

    public static void main(String[] args) {
        int[] nums = new int[]{-1,-1,-1,-1,-1,-1};
        System.out.println(pivotIndex(nums));
        System.out.println(demo(nums));
    }

    static int demo(int[] nums) {
        for (int num : nums) {
            System.out.println(num);
            for (int i : nums) {
                if (i == -1) {
                    System.out.println(0);
                    return -9;
                }
            }
        }
        return 0;
    }

    public static int pivotIndex(int[] nums) {

        if (nums.length == 0) {
            return -1;
        }
        // 计算 数组和
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // 中心索引左边和为总和的一半
        int sumLeft = 0;
        for (int i = 0; i < nums.length; i++) {
            if (2 * sumLeft == (sum - nums[i])) {
                return i;
            }
            sumLeft += nums[i];
        }
        return -1;
    }

}
