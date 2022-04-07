package structure.queue;

/**
 * @author Japhy
 * @since 2022/3/3 14:55
 */
public class Array2 {

    public static void main(String[] args) {
        int[][] ints = new int[10][10];
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

}
