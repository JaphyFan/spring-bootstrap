package practice.day1;

import java.util.Arrays;

/**
 * @author Japhy
 * @since 2020/4/23 17:01
 */
public class PlusOne {

    public static void main(String[] args) {
        int[] arr = {9,9,9,9};
        int[] ints = plusOne(arr);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * [4,3,2,1] 输出4322.
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        // 递归判断是否为9
        int[] recursive = recursive(digits.length - 1, digits);
        return recursive;
    }

    public static int[] recursive(int n, int[] arr) {
        // 为 9 向前进位
        if (arr[n] == 9) {
            // 当递归到最高位时，要扩充数组容量，拷贝数组，最高位置1
            if (n == 0) {
                int[] newArr = new int[arr.length + 1];
                newArr[0] = 1;
                arr[0] = 0;
                for (int i = 0; i < arr.length; i++) {
                    newArr[i+1] = arr[i];
                }
                return newArr;
            }
            arr[n] = 0;
            recursive(n - 1, arr);
        } else {
            // 不为9直接加1返回
            arr[n] = arr[n] + 1;
        }
        return arr;
    }
}
