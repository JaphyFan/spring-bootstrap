package practice.day3;

/**
 * @author Japhy
 * @since 2022/5/7 14:48
 */
public class MergeBu {

    public void merge(int[] a, int lo, int hi, int mid) {
        int[] aux = new int[a.length];
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (aux[i] > aux[j]) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }
    public void sort(int[] ints) {
        for (int sz = 1; sz < ints.length; sz = sz + sz) {
            for (int lo = 0; lo < ints.length - sz; lo = lo + sz + sz ) {
                merge(ints, lo, Math.min(lo + sz + sz - 1, ints.length - 1), lo + sz - 1);
            }
        }
    }

}
