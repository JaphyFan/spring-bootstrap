package structure.queue;

import java.util.Arrays;
import java.util.StringJoiner;

/**
 * 优先队列
 * @author Japhy
 * @since 2022/2/25 16:57
 */
public class PriorityQ {

    private int[] pq;

    private int n;

    public PriorityQ() {
        pq = new int[33];
    }

    public PriorityQ(int max) {
        pq = new int[max + 1];
    }

    public PriorityQ(int[] a) {

    }

    /**
     * 不超过 lgN +1 次比较
     * @param i
     */
    public void insert(int i) {
        pq[++n] = i;
        swim(n);
    }

    public int max() {
        return 1;
    }

    /**
     * 不超过2lgN次比较
     * @return
     */
    public int delMax() {
        int max = pq[1];
        pq[1] = pq[n--];
        sink(pq[1]);
        return max;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    private boolean less(int i, int j) {
        return pq[i] < pq[j];
    }

    private void exec(int i, int j) {
        int k = pq[i];
        pq[i] = pq[j];
        pq[j] = k;
    }

    /**
     * 节点上浮
     * @param k
     */
    private void swim(int k) {

        while (k > 1 && less(k / 2, k)) {
            exec(k / 2, k);
            k = k / 2;
        }
    }

    /**
     * 节点下沉
     * @param k
     */
    private void sink2(int k) {

        while (k < pq.length - 1) {

            if (2 * k < pq.length - 1 && less(k, 2 * k)) {
                exec(k, 2 * k);
                k = 2 * k;
                continue;
            }
            if (2 * k + 1 < pq.length - 1 && less(k, 2 * k + 1)) {
                exec(k, 2 * k + 1);
                k = 2 * k + 1;
            }
        }
    }

    private void sink(int k) {

        while (2 * k < pq.length - 1) {

            int j = 2 * k;
            // 取左右两边较大的值
            if (j < pq.length - 2 && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exec(k, j);
            k = j;
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", PriorityQ.class.getSimpleName() + "[", "]")
                .add("pq=" + Arrays.toString(pq))
                .add("n=" + n)
                .toString();
    }

    public static void main(String[] args) {
        PriorityQ priorityQ = new PriorityQ(6);
        priorityQ.insert(5);
        priorityQ.insert(2);
        priorityQ.insert(1);
        priorityQ.insert(6);
        priorityQ.insert(3);
        priorityQ.insert(4);
        System.out.println(priorityQ);
    }

}
