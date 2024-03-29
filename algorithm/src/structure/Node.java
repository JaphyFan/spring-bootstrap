package structure;

import com.google.common.base.Objects;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode
public class Node {

    private Item item;

    private Node node;

}
