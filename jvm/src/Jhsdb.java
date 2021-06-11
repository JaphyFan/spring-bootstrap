/**
 * @author Japhy
 * @since 2020/8/3 11:34
 */
public class Jhsdb {
    static class JhsdbTest {

        static ObjectHolder staticObj = new ObjectHolder(3);
        final ObjectHolder finalObj = new ObjectHolder(2);

        ObjectHolder instanceObj = new ObjectHolder(1);

        void foo() {
            ObjectHolder paramObj = new ObjectHolder(4);
            System.out.println("done");
        }
    }

    private static class ObjectHolder{
        private int id;

        public ObjectHolder(int id) {
            this.id = id;
        }
    }

    public static void main(String[] args) {
        JhsdbTest test = new JhsdbTest();
        test.foo();
    }
}

//    Heap Parameters:
//        Gen 0:   eden [0x000000010a800000,0x000000010a927b78,0x000000010a9a0000) space capacity = 1703936, 71.0857684795673 used
//        from [0x000000010a9d0000,0x000000010aa00000,0x000000010aa00000) space capacity = 196608, 100.0 used
//        to   [0x000000010a9a0000,0x000000010a9a0000,0x000000010a9d0000) space capacity = 196608, 0.0 usedInvocations: 1
//
//        Gen 1:   old  [0x000000010aa00000,0x000000010aa8c368,0x000000010ae00000) space capacity = 4194304, 13.692665100097656 usedInvocations: 0

//scanoops 0x000000010a800000 0x000000010a9d0000 Jhsdb$ObjectHolder
//        0x000000010a9200c0 Jhsdb$ObjectHolder
//        0x000000010a9200f8 Jhsdb$ObjectHolder
//        0x000000010a920110 Jhsdb$ObjectHolder
//        0x000000010a920128 Jhsdb$ObjectHolder


