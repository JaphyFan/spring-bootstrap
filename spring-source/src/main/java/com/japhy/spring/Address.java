package com.japhy.spring;

/**
 * @author Japhy
 * @since 2021/1/25 02:28
 */
public class Address {

    private String city;

    public Address(String city) {
        this.city = city;
    }

    public Address() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Adress{" +
            "city='" + city + '\'' +
            '}';
    }
}
