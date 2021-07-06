package Course;

import Tool.ShowInfoInterface;

public abstract class Course implements ShowInfoInterface{
    private String name;
    private String teacher;
    private double price;

    public Course(){}
    public Course(String name, String teacher, double price) {
        this.name = name;
        this.teacher = teacher;
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
    public String getTeacher() {
        return teacher;
    }
    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
