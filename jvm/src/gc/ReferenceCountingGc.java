package gc;

/**
 * @author Japhy
 * @since 2021/5/6 15:42
 */
public class ReferenceCountingGc {

    private Object instance = null;

    private static final int _1MB = 1024 * 1024;

    private byte[] bigSize = new byte[2 * _1MB];

    public static void testGc() {
        ReferenceCountingGc oA = new ReferenceCountingGc();
        ReferenceCountingGc oB = new ReferenceCountingGc();
        oA.instance = oB;
        oB.instance = oA;

        oA = null;
        oB = null;

    }

    public static void main(String[] args) {
        testGc();
    }


}
