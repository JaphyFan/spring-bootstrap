package basic;

/**
 * @author Japhy
 * @since 2021/4/26 15:58
 */
public class StackFrameDemo3 {

    public static void main(String[] args) {
        int a = 1;
        long b = 2;
        f(a, b);
    }

    public static long f(int a, long b) {
        long c =  a + b;
        return c;
    }

    public static int g() {
        int a = 5;
        int b = 3;
        return a;
    }
}
