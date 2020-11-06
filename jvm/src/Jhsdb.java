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
