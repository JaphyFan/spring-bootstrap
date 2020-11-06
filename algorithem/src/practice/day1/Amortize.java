package day1;

import com.google.common.collect.Lists;
import java.util.Arrays;

/**
 * @author Japhy
 * @since 2020/4/22 20:47
 */
public class Amortize {

    private static int n = 10;
    private static int[] array = new int[n];
    private static int count = 0;
    public static void main(String[] args) {
        amortize(10);
        amortize(1);
        amortize(2);
        amortize(3);
        amortize(4);
        System.out.println(Arrays.toString(array));



    }

    private static void amortize(int val) {
        if (count == array.length) {
            int sum = 0;
            for (int i = 0; i < array.length; i++) {
                sum = sum + array[i];
            }
            array[0] = sum;
            count = 1;
        }
        array[count] = val;
        ++count;
    }

    private static int len = 10;
    private static int j = 0;

    private static void practice(int el) {
        if (j >=len) {
            int newArray[] = new int[len * 2];
            for (int i = 0; i < len; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
            len = 2 * len;
        }
    }

    private static void wrapper() {
    }


}
