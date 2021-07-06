package Class;

public abstract class Class { 
    private ClassAttribute attribute; // 学历、年级、班级基本属性
    private String classHeader; // 班主任
    
    public Class(){}
    public Class(final String education, final int grade, final int classNumber, final String classHeader) {
        this.attribute = new ClassAttribute(education, grade, classNumber);
        this.classHeader = classHeader;
    }
    
    public void showInfo() {
        // TODO: Lx 展示教室的所有属性
    }
    
    public String getClassHeader() {
        return classHeader;
    }
    public void setClassHeader(String classHeader) {
        this.classHeader = classHeader;
    }

    public String getEducation() {
        return attribute.getEducation();
    }


    public void setEducation(final String education) {
        attribute.setEducation(education);
    }

    public int getGrade() {
        return attribute.getGrade();
    }

    public void setGrade(final int grade) {
        attribute.setGrade(grade);
    }

    public int getClassNumber() {
        return attribute.getClassNumber();
    }

    public void setClassNumber(final int classNumber) {
        attribute.setClassNumber(classNumber);
    }

}
