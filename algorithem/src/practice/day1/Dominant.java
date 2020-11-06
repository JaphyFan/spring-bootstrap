package day1;


/**
 * @author Japhy
 * @since 2020/4/23 15:39
 */
public class Dominant {

    public static void main(String[] args) {
        int[] array = {0, 0, 3, 2};
        int i = dominantIndex(array);
        System.out.println(i);
    }

    /**
     * nums = 3, 6, 1, 0
     * 1
     * @param nums
     * @return
     */
    public static int dominantIndex(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return 0;// 题目定义的答案
        int index = 0;
        int max = nums[index] > nums[index + 1] ?  nums[index] : nums[index + 1];
        int sec = nums[index] < nums[index + 1] ?  nums[index] : nums[index + 1];
        for (int i = 2; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
                index = i;
            }
            if (sec < nums[i]) {
                sec = nums[i];
            }
        }
        if (max >= 2 * sec) {
            return index;
        }
        return -1;
    }
}
