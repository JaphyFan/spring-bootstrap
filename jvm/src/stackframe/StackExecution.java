package stackframe;

import java.util.concurrent.TimeUnit;

/**
 * @author Japhy
 * @since 2021/4/19 16:42
 */
public class StackExecution {

    public static void main(String[] args) {
        add();
        while (true) {
        }
    }

    public static int add() {
        int a = 1;
        int b = 2;
        int c = 3;
        return (a + b) * c;
    }

}
