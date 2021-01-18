package com.japhy.basic.lamda;

/**
 * @author Japhy
 * @since 2020/4/25 16:33
 */
public class StringCombiner {

    private String prefix;

    private String delim;

    private String sufix;

    private StringBuilder builder;

    public StringCombiner(String prefix, String delim, String sufix) {
        this.prefix = prefix;
        this.delim = delim;
        this.sufix = sufix;
        this.builder = new StringBuilder();
    }

    public void add(String element) {
        builder.append(element);
    }

    public StringCombiner merge(StringCombiner other) {
        builder.append(other.builder);
        return this;
    }

    @Override
    public String toString() {
        return this.builder.toString();
    }
}
