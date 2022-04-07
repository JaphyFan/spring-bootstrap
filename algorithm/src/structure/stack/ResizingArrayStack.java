package structure.stack;

import java.util.Arrays;
import java.util.Iterator;
import structure.Item;
import structure.Stack;

/**
 * @author Japhy
 * @since 2022/3/3 16:34
 */
public class ResizingArrayStack implements Stack<Item> {

    private Object[] objects;

    private int index = 0;

    public ResizingArrayStack(int capacity) {
        this.objects = new Object[capacity];
    }

    @Override
    public Iterator<Item> iterator() {
        return new ResizingArrayStackIt();
    }

    @Override
    public void push(Item item) {
        if (index == objects.length) {
            resize();
        }
        objects[index++] = item;
    }

    @Override
    public Item pop() {
        Item item =  (Item) objects[--index];
        objects[index] = null;
        return item;
    }

    @Override
    public int size() {
        return objects.length;
    }

    @Override
    public boolean isEmpty() {
        return objects.length == 0;
    }

    private void resize() {
        if (this.objects.length == index) {
            Object[] newArr = new Object[this.objects.length * 2];
            for (int i = 0; i < objects.length; i++) {
                newArr[i] = this.objects[i];
            }
            this.objects = newArr;
        }
    }

    private class ResizingArrayStackIt implements Iterator<Item> {

        private int i = index;

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Stack not support remove operation from iterator.");
        }

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return (Item) objects[--i];
        }
    }

    public static void main(String[] args) {
        ResizingArrayStack items = new ResizingArrayStack(2);
        items.push(new Item(1L, "f"));
        items.push(new Item(2L, "j"));
        System.out.println(Arrays.toString(items.objects));
        items.push(new Item(3L, "h"));
        System.out.println(Arrays.toString(items.objects));
        System.out.println(items.pop());
        items.forEach(System.out::println);
    }

}
