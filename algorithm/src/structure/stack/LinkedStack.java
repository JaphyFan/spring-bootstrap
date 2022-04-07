package structure.stack;

import java.util.Iterator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import structure.Item;
import structure.Node;
import structure.Stack;

/**
 * @author Japhy
 * @since 2022/3/4 16:48
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class LinkedStack implements Stack<Item> {

    private Node first;

    private int index = 0;

    @Override
    public void push(Item item) {
        first = new Node(item, first);
        index++;
    }

    @Override
    public Item pop() {
        Node oldFirst = first;
        Node second = first.getNode();
        oldFirst.setNode(null);
        first = second;
        index--;
        return oldFirst.getItem();
    }

    @Override
    public int size() {
        return index;
    }

    @Override
    public boolean isEmpty() {
        return index == 0;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReversedIt();
    }

    //TODO:  japhy 2022/3/8
    class ReversedIt implements Iterator<Item> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Item next() {
            return null;
        }

        @Override
        public void remove() {
            Iterator.super.remove();
        }
    }

    public static void main(String[] args) {
        Item node3 = new Item(3L, "3");
        Item node2 = new Item(2L, "2");
        Item node1 = new Item(1L, "1");

        LinkedStack stack = new LinkedStack();
        stack.push(node1);
        stack.push(node2);
        stack.push(node3);
        System.out.println(stack);

        stack.pop();
        System.out.println(stack);

    }

}
