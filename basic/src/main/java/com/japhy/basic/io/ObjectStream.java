package com.japhy.basic.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author Japhy
 * @since 2020/10/21 17:16
 */
public class ObjectStream {


    public static void main(String[] args) throws FileNotFoundException {
        Obj2 obj2 = new Obj2();
        obj2.setaDouble(1.44);
        DemoObj demoObj = new DemoObj();
        demoObj.setId(1);
        demoObj.setName("fan");
        demoObj.setObj2(obj2);

        try (ObjectOutputStream output = new ObjectOutputStream(
            new BufferedOutputStream(
                new FileOutputStream("/Users/japhy/Documents/code/bootstrap/basic/d.txt")))) {
            output.writeObject(demoObj);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (ObjectInputStream inputStream = new ObjectInputStream(new BufferedInputStream(
            new FileInputStream("/Users/japhy/Documents/code/bootstrap/basic/d.txt")))) {
            DemoObj o = (DemoObj) inputStream.readObject();
            System.out.println(o.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static class Obj2 implements Serializable {

        private static final long serialVersionUID = 7390531281231803435L;
        private double aDouble;

        public double getaDouble() {
            return aDouble;
        }

        public void setaDouble(double aDouble) {
            this.aDouble = aDouble;
        }

        @Override
        public String toString() {
            return "Obj2{" +
                "aDouble=" + aDouble +
                '}';
        }
    }
    static class DemoObj implements Serializable{

        private static final long serialVersionUID = -5784572779923441789L;
        private int id;

        private Obj2 obj2;

        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Obj2 getObj2() {
            return obj2;
        }

        public void setObj2(Obj2 obj2) {
            this.obj2 = obj2;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "DemoObj{" +
                "id=" + id +
                ", obj2=" + obj2 +
                ", name='" + name + '\'' +
                '}';
        }
    }


}
