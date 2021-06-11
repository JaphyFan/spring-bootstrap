package basic;

/**
 * @author Japhy
 * @since 2021/4/23 14:30
 */
public class StackFrameDemo2 {

    public static void main(String[] args) {
        int a = 1;
        long b = 2;
        f(a, b);
    }

    public static long f(int a, long b) {
        long c =  a + b;
        return c;
    }

}
