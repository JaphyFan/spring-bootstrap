package day2;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，
 * 返回它将会被按顺序插入的位置。
 *
 * @author Japhy
 * @since 2020/6/11 13:40
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 */
public class ArrayIndex {

    static int binarySearch(int[] nums, int target, int left, int right) {
        if (left > right) {
            return left;
        }
        int middle = (left + right) >>> 1;
        int com = nums[middle];
        if (com == target) {
            return middle;
        }
        if (target < com) {
            return binarySearch(nums, target, left, middle - 1);
        }
        if (target > com) {
            return binarySearch(nums, target, middle + 1, right);
        }
        return -1;
    }

    static int index(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 3, 5, 6};
        System.out.println(index(nums, 0));
    }
}
