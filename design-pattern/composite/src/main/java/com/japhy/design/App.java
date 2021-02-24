package com.japhy.design;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Japhy
 * @since 2021/2/23 10:44
 */
public class App {

    public static void main(String[] args) {
        List<LetterComposite> helloList = new ArrayList<>();
        helloList.add(new Letter('h'));
        helloList.add(new Letter('e'));
        helloList.add(new Letter('l'));
        helloList.add(new Letter('l'));
        helloList.add(new Letter('o'));
        Word hello = new Word(helloList);

        List<LetterComposite> worldList = new ArrayList<>();

        worldList.add(new Letter('w'));
        worldList.add(new Letter('o'));
        worldList.add(new Letter('r'));
        worldList.add(new Letter('l'));
        worldList.add(new Letter('d'));
        Word world = new Word(worldList);
        List<LetterComposite> se = new ArrayList<>();
        se.add(hello);
        se.add(world);
        Sentence sentence = new Sentence(se);
        sentence.print();
        System.out.println(sentence.count());
    }

}
