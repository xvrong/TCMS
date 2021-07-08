package Course;

import Tool.ShowInfoInterface;

public abstract class Course implements ShowInfoInterface {
    private String name;
    private double price;

    public Course() {
    }

    public Course(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void showInfo() {
        // TODO: Lx 展示信息

    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
