package basic;

/**
 * -verbose: gc
 * 获取当前classpath System.out.println(ClassLoader.getSystemResource(""));
 * System.getProperties()获取所有参数.
 * @author Japhy
 * @since 2021/4/19 15:04
 */
public class StackFrameDemo {

    public static void main(String[] args) {
        {
            byte[] placeholder = new byte[64 * 1024 * 1024];
        }
        int a = 0;
        System.gc();
    }


    static class LocalVariable {

        public static void main(String[] args) {
            int a;
            System.out.println("its ok in jvm ");
        }
    }
}
