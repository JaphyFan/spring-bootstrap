package structure.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/**
 * 在最坏情况下 find(), connected()和union()的成本增长数量级都为logN.
 * 处理N个触点和M条连接最多访问数组MlogN次.
 *
 * @author Japhy
 * @since 2022/4/27 14:55
 */
public class weightedQuickUnion implements UFAbstract {

    private int[] ids;

    private int count;

    private int[] weight;

    public weightedQuickUnion(int n) {
        this.ids = new int[n];
        this.weight = new int[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
            weight[i] = 1;
        }

    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(q);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        if (weight[pRoot] >= weight[qRoot]) {
            ids[qRoot] = pRoot;
            weight[pRoot] += weight[qRoot];
        } else {
            ids[pRoot] = qRoot;
            weight[qRoot] += weight[pRoot];
        }
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public int find(int x) {
        while (ids[x] != x) {
            x = ids[x];
        }
        return x;
    }

    @Override
    public int[] getId() {
        return new int[0];
    }

    public static void main(String[] args) throws IOException {
        List<String> strings = Files.readAllLines(
                Paths.get("/Users/japhy/Documents/code/bootstrap/algorithm/uftest"));
        QuickUnion quickFind = new QuickUnion(strings.size() * 2);

        for (String string : strings) {
            Object[] s = Arrays.stream(StringUtils.split(string, " ")).toArray();
            quickFind.union(Integer.parseInt(StringUtils.trim(String.valueOf(s[0]))),
                    Integer.parseInt(StringUtils.trim(String.valueOf(s[1]))));
            System.out.println(Arrays.toString(quickFind.getId()));
        }
    }
}
