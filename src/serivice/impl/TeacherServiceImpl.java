/*
 * @Author: LinXuan
 * @Date: 2021-07-12 16:58:57
 * @Description: 
 * @LastEditors: LinXuan
 * @LastEditTime: 2021-07-15 09:20:24
 * @FilePath: \TCMS\src\serivice\impl\TeacherServiceImpl.java
 */
package serivice.impl;

import java.io.PrintStream;
import java.util.ArrayList;
import entity.Person.Student;
import entity.Person.Teacher;
import entity.TClass.TClass;
import serivice.TeacherService;

public class TeacherServiceImpl implements TeacherService {
    final static PrintStream jout = System.out;
    Teacher teacher = null;

    @Override
    public void showPersonalInfo() {
        ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
        teacherList.add(teacher);

        pt.printTeacherAllInformation(teacherList);
    }

    @Override
    public void showTeachingClass() {
        ArrayList<TClass> courseList = qy.queryTClassByTeacherId(teacher.getTeacherID(), true);
        pt.printTClassInfomation(courseList);
    }

    @Override
    public void searchTeachingStudent() {
        ArrayList<Student> studentList = qy.queryStudentByTeacher(teacher.getTeacherID(), true);
        pt.printStudentBasicInfomation(studentList);
    }

    @Override
    public void showHistoryTeachingClass() {
        ArrayList<TClass> courseList = qy.queryTClassByTeacherId(teacher.getTeacherID(), false);
        pt.printTClassInfomation(courseList);
    }

    @Override
    public void searchTeachingStudentInfo() {
        ArrayList<Student> studentList = qy.queryStudentByTeacher(teacher.getTeacherID(), true);
        int studentID = get.getInputStudent(studentList);
        ArrayList<Student> searchStudent = new ArrayList<Student>();
        for (Student stu : studentList) {
            if (stu.getStudentID() == studentID) {
                searchStudent.add((stu));
                break;
            }
        }
        pt.printStudentAllInformation(searchStudent);
    }

    @Override
    public void run(int teacherID) {
        teacher = qy.queryTeacherByTeacherId(teacherID, true);
        int func = -1;
        while (func != 0) {
            // ????????????
            jout.println("-----------------????????????----------------");
            jout.println("1.??????????????????");
            jout.println("2.???????????????????????????");
            jout.println("3.????????????????????????");
            jout.println("4.?????????????????????????????????");
            jout.println("5.?????????????????????????????????????????????");
            jout.println("0.????????????");
            func = get.getInputInt("???????????????: ", 0, 5);
            switch (func) {
                case 1:
                    showPersonalInfo();
                    get.getInputEnter();
                    break;
                case 2:
                    showTeachingClass();
                    get.getInputEnter();
                    break;
                case 3:
                    showHistoryTeachingClass();
                    get.getInputEnter();
                    break;
                case 4:
                    searchTeachingStudent();
                    get.getInputEnter();
                    break;
                case 5:
                    searchTeachingStudentInfo();
                    get.getInputEnter();
                    break;
                default:
                    break;
            }
        }

    }

}
