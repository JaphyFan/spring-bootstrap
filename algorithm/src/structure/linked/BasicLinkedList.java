package structure.linked;

import java.util.Iterator;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;
import structure.Item;
import structure.LinkedList;
import structure.Node;

/**
 * @author Japhy
 * @since 2022/3/4 11:17
 */
@Getter
@Setter
public class BasicLinkedList implements LinkedList<Node>, Iterable<Node> {

    private Node first;

    private Node last;

    // 节点数量
    private int num = 0;

    @Override
    public Iterator<Node> iterator() {
        return new LinkedIt();
    }

    @Override
    public Node removeFirst() {
        Node oldFirst = first;
        Node second = oldFirst.getNode();
        oldFirst.setNode(null);
        first = second;
        num--;
        return oldFirst;
    }

    @Override
    public int size() {
        return num;
    }

    @Override
    public boolean isEmpty() {
        return num == 0;
    }

    @Override
    public void addFirst(Node node) {
        Node oldFirst = first;
        first = node;
        node.setNode(oldFirst);
        num++;
    }

    @Override
    public void addLast(Node node) {
        if (Objects.isNull(last)) {
            last = node;
            first.setNode(last);
        } else {
            last.setNode(node);
        }
        num++;
    }

    // 应该实现为Item的迭代器
    private class LinkedIt implements Iterator<Node> {

        private int cursor = 1;

        @Override
        public boolean hasNext() {
            return cursor <= num;
        }

        @Override
        public Node next() {
            Node node = null;
            if (cursor == 1) {
                cursor++;
                return first;
            }
            int i = 2;
            for (Node x = first; i <= cursor && i <= num; i++) {
                node = x = x.getNode();
            }
            cursor++;
            return node;
        }
    }

    public static void main(String[] args) {

        Node node3 = new Node(new Item(3L, "3"), null);
        Node node2 = new Node(new Item(2L, "2"), null);
        Node node1 = new Node(new Item(1L, "1"), null);

        BasicLinkedList basicLinkedList = new BasicLinkedList();
        basicLinkedList.addFirst(node1);
        basicLinkedList.addLast(node2);
        basicLinkedList.addLast(node3);

        System.out.println("list size is" + basicLinkedList.size());

        for (Node x = basicLinkedList.first; x != null; x = x.getNode()) {
            System.out.println(x);
        }

        for (Node node : basicLinkedList) {
            System.out.println(node);
        }

    }
}
