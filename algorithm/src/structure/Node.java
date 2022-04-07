package structure;

import com.google.common.base.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Japhy
 * @since 2022/3/3 17:34
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Node {

    private Item item;

    private Node node;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Node node1 = (Node) o;
        return Objects.equal(item, node1.item)
                && Objects.equal(node, node1.node);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(item, node);
    }
}
