package structure.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/**
 * 最好为线性，最坏为n的平方.
 *
 * @author Japhy
 * @since 2022/4/25 17:45
 */
public class QuickUnion implements UFAbstract {

    private int[] id;
    private int count;

    public QuickUnion(int n) {
        this.id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    @Override
    public boolean connected(int p, int q) {
        return find(q) == find(p);
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        count--;
        id[pRoot] = qRoot;
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public int find(int x) {
        while (id[x] != x) {
            x = id[x];
        }
        return x;
    }

    @Override
    public int[] getId() {
        return id;
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
