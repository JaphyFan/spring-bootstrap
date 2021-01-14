package com.japhy.design.command;

/**
 * @author Japhy
 * @since 2020/11/20 14:38
 */
public abstract class Target {

    private Visibility visibility;

    private Size size;

    public Visibility getVisibility() {
        return visibility;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    protected void printStatus() {
        System.out.println(toString());
    }

    protected void changeVisibility() {
        Visibility visibility =
            this.visibility == Visibility.VISIBLE ? Visibility.INVISIBLE : Visibility.VISIBLE;
        setVisibility(visibility);
    }

    protected void changeSize() {
        Size size = this.size == Size.BIG ? Size.SMALL : Size.BIG;
        setSize(size);
    }

    @Override
    public String toString() {
        return "Target{" +
            "visibility=" + visibility +
            ", size=" + size +
            '}';
    }
}
