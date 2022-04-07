package practice.day1;

/**
 * @author Japhy
 * @since 2020/4/23 13:46
 */
public class MiddleIndex {

    public static int pivotIndex(int[] nums) {
        if (nums.length == 0) return -1;
        for (int i = 0; i < nums.length; i++) {
            int left = 0;
            int right = 0;
            for (int j = 0; j < i; j++) {
                left += nums[j];
            }
            for (int n = i + 1; n < nums.length; n++) {
                right += nums[n];
            }
            if (left == right) {
                return i;
            }
        }
        return -1;
    }

    public static int pivotIndex2(int[] nums) {
        if (nums.length == 1) return 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (res * 2 == sum - nums[i]) {
                return i;
            }
            res += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1,7,3,6,5,6};
        System.out.println(pivotIndex2(array));
    }
}
