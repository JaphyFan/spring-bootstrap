package structure.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/**
 * 两个点.
 *
 * @author Japhy
 * @since 2022/4/25 15:46
 */
public class QuickFind implements UFAbstract {

    private int[] id;

    private int count;

    public QuickFind(int n) {
        count = n;
        id = new int[n];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int[] getId() {
        return id;
    }

    /**
     * 基础实现，find 访问2次，比较访问N次，赋值访问1 - N-1 次， N+3 到 2N +1.
     */
    @Override
    public void union(int a, int b) {
        int aId = find(a);
        int bId = find(b);
        if (aId == bId) {
            return;
        }
        for (int i = 0; i < id.length; i++) {
            if (id[i] == aId) {
                id[i] = bId;
            }
        }
    }
    @Override
    public int count() {
        return count;
    }

    @Override
    public int find(int p) {
        return id[p];
    }

    public static void main(String[] args) throws IOException {
        List<String> strings = Files.readAllLines(
                Paths.get("/Users/japhy/Documents/code/bootstrap/algorithm/uftest"));
        QuickFind quickFind = new QuickFind(strings.size() * 2);

        for (String string : strings) {
            Object[] s = Arrays.stream(StringUtils.split(string, " ")).toArray();
            quickFind.union(Integer.parseInt(StringUtils.trim(String.valueOf(s[0]))),
                    Integer.parseInt(StringUtils.trim(String.valueOf(s[1]))));
            System.out.println(Arrays.toString(quickFind.getId()));
        }

    }

}
