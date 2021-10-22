package oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Japhy
 * @since 2021/4/21 14:56
 */
public class StackDemo {

    static class HeapObj {
    }

    public static void main(String[] args) {
        List<HeapObj> heapObjList = new ArrayList<>();

        while (true) {
            heapObjList.add(new HeapObj());
        }
    }

}
