/*
 * @Author: LinXuan
 * @Description: 
 * @Date: 2021-07-11 20:22:51
 * @LastEditors: LinXuan
 * @LastEditTime: 2021-07-11 20:48:23
 * @FilePath: \TCMS\src\Tool\Debug.java
 */
package Tool;

import entity.Course.Course;
import entity.Person.Student;
import entity.Person.Teacher;
import entity.TClass.TClass;

public class Debug {

    public static Student createStudent(int id, String name, String sex, Education edu, String birthday, int age) {
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

    public static Teacher createTeacher(int id, String name, String sex, String birthday, int age, double salary) {
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

    public static Course createCourse(Education edu, String name) {
        // 生成调试用的课程
        Course cour = new Course();
        cour.setEdu(edu);
        cour.setName(name);
        return cour;
    }

    public static TClass createTClass(int year, Education edu, int courseId, int studentNum) {
        // 生成调试用的班级
        TClass tcl = new TClass();
        tcl.setStartYear(year);
        tcl.setEducation(edu);
        tcl.setCourseID(courseId);
        tcl.setStudentNum(studentNum);
        return tcl;
    }
}
