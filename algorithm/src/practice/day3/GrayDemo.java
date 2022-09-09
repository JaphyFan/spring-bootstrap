package practice.day3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.util.CollectionUtils;

/**
 * @author Japhy
 * @since 2022/5/12 14:45
 */
public class GrayDemo {

    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);

        double max = Math.pow(2, n);
        Set<Integer> source = new HashSet<>();
        for (int i = 1; i <= max; i++) {
            source.add(i);
        }

        for (int i = 1; i <= max; i++) {
            Integer pre = res.get(i - 1);
            for (Integer v : source) {
                if (i < max && oneDiffer1(Integer.toBinaryString(pre), Integer.toBinaryString(v))) {
                    res.add(v);
                    source.remove(v);
                    break;
                }
                if (i == max && oneDiffer1(Integer.toBinaryString(pre), Integer.toBinaryString(v))
                        && oneDiffer1(Integer.toBinaryString(res.get(0)),
                        Integer.toBinaryString(v))) {
                    res.add(v);
                    break;
                }
            }
        }
        return res;

    }

    public boolean oneDiffer1(String a, String b) {
        if (b.length() != a.length()) {
            String d = "0" + a;
            return oneDiffer(d, b);
        } else {
            return oneDiffer(a, b);
        }
    }

    public boolean oneDiffer(String a, String b) {
        if (b.length() != a.length()) {
            return false;
        }
        char[] aArr = a.toCharArray();
        char[] bArr = b.toCharArray();
        int falseCount = 0;
        for (int i = 0; i < aArr.length; i++) {
            if (aArr[i] != bArr[i]) {
                falseCount++;
            }
            if (falseCount > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 3;
        List<Integer> ret = new ArrayList<>();
        for(int i = 1; i < 1; ++i)
            System.out.println(1);
    }
}
