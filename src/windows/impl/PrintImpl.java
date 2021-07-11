/*
 * @Author: xv_rong
 * @Date: 2021-07 21:36:58
 * @LastEditors: xv_rong
 * @LastEditTime: 2021-07-11 8:38:31
 * @Description: 
 * @FilePath: \tCMS\src\windows\impl\PrintImpl.java
 */
package windows.impl;

import java.io.PrintStream;
import java.util.ArrayList;

import Tool.Education;
import entity.Course.Course;
import entity.Person.Student;
import entity.Person.Teacher;
import entity.TClass.TClass;
import windows.Print;

public class PrintImpl implements Print {
    private static PrintStream jout = System.out; // 全局的输出

    private static Student createStudent(String id, String name, String sex, Education edu, String birthday, int age) {
        // 生成调试用的学生
        Student stu = new Student();
        stu.setStudentID(id);
        stu.setName(name);
        stu.setSex(sex);
        stu.setEdu(edu);
        stu.setBirthday(birthday);
        stu.setAge(age);
        return stu;
    }
    private static Teacher createTeacher(String id, String name, String sex, String birthday, int age, double salary) {
        // 生成调试用的老师
        Teacher tch = new Teacher();
        tch.setTeacherID(id);
        tch.setName(name);
        tch.setSex(sex);
        tch.setBirthday(birthday);
        tch.setAge(age);
        tch.setSalary(salary);
        return tch;
    }
    private static Course createCourse(Education edu, String name) {
        // 生成调试用的课程
        Course cour = new Course();
        cour.setEdu(edu);
        cour.setName(name);
        return cour;
    }
    private static TClass createTClass(int year, Education edu, int courseId, int studentNum) {
        // 生成调试用的班级
        TClass tcl = new TClass();
        tcl.setStartYear(year);
        tcl.setEducation(edu);
        tcl.setCourseID(courseId);
        tcl.setStudentNum(studentNum);
        return tcl;
    }

    @Override
    public void printStudentBasicInfomation(ArrayList<Student> studentList) {
        jout.println("学生的基本信息：");
        jout.println("--------------------------------------------------------");
        jout.printf("%-8s\t%-8s\t%-8s\n", "序号", "学生ID", "姓名");
        jout.println("--------------------------------------------------------");
        int number = 0;
        for(Student stu : studentList) {
            jout.printf("%-8d\t%-8s\t%-8s\n", 
                number, stu.getStudentID(), stu.getName());
            number++;
        }
        jout.println("---------------------------------------------------------");
    }

    @Override
    public void printTeacherBasicInfomation(ArrayList<Teacher> teacherList) {
        jout.println("老师的基本信息：");
        jout.println("--------------------------------------------------------------------------------");
        jout.printf("%-8s\t%-8s\t%-8s\n", "序号", "老师ID", "姓名");
        jout.println("--------------------------------------------------------------------------------");
        int number = 0;
        for(Teacher tch : teacherList) {
            jout.printf("%-8d\t%-8s\t%-8s\n", 
                number, tch.getTeacherID(), tch.getName());
            number++;
        }
        jout.println("--------------------------------------------------------------------------------");
    }

    @Override
    public void printCourseBasicInfomation(ArrayList<Course> courseList) {
        jout.println("课程的基本信息：");
        jout.println("--------------------------------------------------------------------------------");
        jout.printf("%-8s\t%-8s\t%-8s\n", "序号", "学历", "课程名称");
        jout.println("--------------------------------------------------------------------------------");
        int number = 0;
        for(Course cour : courseList) {
            jout.printf("%-8d\t%-8s\t%-8s\n",
                number, cour.getEdu(), cour.getName());
            number++;
        }
        jout.println("--------------------------------------------------------------------------------");

    }

    @Override
    public void printTClassBasicInfomation(ArrayList<TClass> tClassList) {
        jout.println("班级的基本信息：");
        jout.println("--------------------------------------------------------------------------------");
        jout.printf("%-8s\t%-8s\t%-8s\t%-8s\t%-8s\n", "序号", "开始时间", "学历", "课程ID", "学生人数");
        jout.println("--------------------------------------------------------------------------------");
        int number = 0;
        for(TClass tcs : tClassList) {
            jout.printf("%-8d\t%-8d\t%-8s\t%-8d\t%-8d\n",
                number, tcs.getStartYear(), tcs.getEducation(), tcs.getCourseID(), tcs.getStudentNum());
            number++;
        }
        jout.println("--------------------------------------------------------------------------------");

    }

    @Override
    public void printStudentAllInformation(ArrayList<Student> studentList) {
        jout.println("学生的详细信息：");
        jout.println("--------------------------------------------------------------------------------------------------------------");
        jout.printf("%-8s\t%-8s\t%-8s\t%-8s\t%-8s\t%-8s\t%-8s\n", "序号", "学生ID", "姓名", "性别", "学历", "生日", "年龄");
        jout.println("--------------------------------------------------------------------------------------------------------------");
        int number = 0;
        for(Student stu : studentList) {
            jout.printf("%-8d\t%-8s\t%-8s\t%-8s\t%-8s\t%-8s\t%-8d\n",
                number, stu.getStudentID(), stu.getName(), stu.getSex(), stu.getEdu(), stu.getBirthday(), stu.getAge());
            number++;
        }
        jout.println("--------------------------------------------------------------------------------------------------------------");
    }

    @Override
    public void printTeacherAllInformation(ArrayList<Teacher> teacherList) {
        jout.println("老师的详细信息：");
        jout.println("--------------------------------------------------------------------------------------------------------------");
        jout.printf("%-8s\t%-8s\t%-8s\t%-8s\t%-8s\t%-8s\t%-8s\n", "序号", "老师ID", "姓名", "性别", "生日", "年龄", "工资");
        jout.println("--------------------------------------------------------------------------------------------------------------");
        int number = 0;
        for(Teacher tch : teacherList) {
            jout.printf("%-8s\t%-8s\t%-8s\t%-8s\t%-8s\t%-8d\t%-8.2f\n",
                number, tch.getTeacherID(), tch.getName(), tch.getSex(), tch.getBirthday(), tch.getAge(), tch.getSalary());
            number++;
        }
        jout.println("--------------------------------------------------------------------------------------------------------------");

    }
    public static void main(String[] args) {
        PrintImpl Test = new PrintImpl();
        ArrayList<Student> studentList = new ArrayList<Student>();
        studentList.add(createStudent("001", "松本", "无", Education.HIGH, "2085-11-17", 45));
        studentList.add(createStudent("002", "vivy", "女", Education.PRIMARY, "2008-06-01", 34));
        Test.printStudentBasicInfomation(studentList);
        Test.printStudentAllInformation(studentList);
        ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
        teacherList.add(createTeacher("001", "奥菲利亚", "女", "2045-11-17", 23, 180000.5));
        teacherList.add(createTeacher("002", "navy", "女", "2008-06-01", 34, 84521.0));
        Test.printTeacherBasicInfomation(teacherList);
        Test.printTeacherAllInformation(teacherList);

        ArrayList<Course> courseList = new ArrayList<Course>();
        courseList.add(createCourse(Education.HIGH, "人工智能基础"));
        courseList.add(createCourse(Education.HIGH, "毛泽东思想与中国特色社会主义理论体系概论"));
        Test.printCourseBasicInfomation(courseList);

        ArrayList<TClass> tClassList = new ArrayList<TClass>();
        tClassList.add(createTClass(2021, Education.JUNIOR, 996, 101));
        tClassList.add(createTClass(1998, Education.PRIMARY, 007, 97));
        Test.printTClassBasicInfomation(tClassList);
    }
}
