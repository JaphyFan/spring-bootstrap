package com.japhy.spring;

/**
 * @author Japhy
 * @since 2021/1/25 01:24
 */
public class User {

    private int id;

    private String name;

    private Address address;

    public User() {
    }

    public User(Address address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void myInit() {
        System.out.println("my init method ------");
    }

    public void myDestroy() {
        System.out.println(" my destroy");
    }

    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", address=" + address +
            '}';
    }
}
