package structure;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * K,v对node.
 *
 * @author Japhy
 * @since 2022/5/12 17:22
 */
@ToString
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class KVNode<K, V> {

    private K key;

    private V value;

    private KVNode<K, V> next;
}
