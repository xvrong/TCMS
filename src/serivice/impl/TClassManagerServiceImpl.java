/*
 * @Author: xv_rong
 * @Date: 2021-07-09 21:48:17
 * @LastEditors: xv_rong
 * @LastEditTime: 2021-07-13 14:47:33
 * @Description: TClassManagerServiceImpl
 * @FilePath: \TCMS\src\serivice\impl\TClassManagerServiceImpl.java
 */
package serivice.impl;

import java.util.ArrayList;
import java.util.Calendar;
import Tool.Education;
import entity.Course.Course;
import entity.Person.Student;
import entity.Person.Teacher;
import entity.TClass.TClass;
import serivice.TClassManagerService;

public class TClassManagerServiceImpl implements TClassManagerService {

    @Override
    public void showAllTClass() {
        ArrayList<TClass> tClassList = qy.queryTClass(true);
        pt.printTClassBasicInfomation(tClassList);
    }

    @Override
    public void showCertainTClassStudent() {
        Education edu = get.getInputEducation();
        ArrayList<Course> courseList = qy.queryCourse(edu, true);
        int courseId = get.getInputCourse(courseList);
        ArrayList<TClass> classList = qy.queryTClass(courseId, true);
        int tClassId = get.getInputClass(classList);
        ArrayList<Student> studentList = qy.queryStudent(tClassId, true);
        pt.printStudentBasicInfomation(studentList);
    }

    @Override
    public void showCertainTClassTeacher() {
        Education edu = get.getInputEducation();
        ArrayList<Course> courseList = qy.queryCourse(edu, true);
        int courseId = get.getInputCourse(courseList);
        ArrayList<TClass> classList = qy.queryTClass(courseId, true);
        int tClassId = get.getInputClass(classList);
        Teacher teacher = qy.queryTeacher(tClassId, true);
        ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
        teacherList.add(teacher);
        pt.printTeacherBasicInfomation(teacherList);

    }

    @Override
    public void addTClass() {
        TClass tClass = new TClass();
        Calendar cal = Calendar.getInstance();
        Education edu = get.getInputEducation();
        tClass.setEducation(edu);
        ArrayList<Course> courseList = qy.queryCourse(edu, true);
        int courseId = get.getInputCourse(courseList);
        tClass.setCourseID(courseId);
        tClass.setGrade(1);
        ArrayList<TClass> tClassList = qy.queryTClass(courseId, true);
        int num = tClassList.size() + 1;
        tClass.setOrderNumber(num);
        System.out.println("选择对应老师");
        int teacherId = get.getInputId();
        get.getInputClassMaxNum();
        tClass.setTeacherID(teacherId);
        int year = cal.get(Calendar.YEAR);
        tClass.setStartYear(year);
        tClass.setState(true);
        boolean flag = up.addTClass(tClass);
        if (flag) {
            System.out.println("增加班级成功");
        } else {
            System.out.println("增加班级失败");
        }
    }

    @Override
    public void ChangeTeacher() {
        Education edu = get.getInputEducation();
        ArrayList<Course> courseList = qy.queryCourse(edu, true);
        int courseId = get.getInputCourse(courseList);
        ArrayList<TClass> tClassList = qy.queryTClass(courseId, true);
        int tClassId = get.getInputClass(tClassList);
        qy.queryTClassByTClassId(tClassId, true);
        pt.printTClassBasicInfomation(tClassList);
        System.out.println("选择老师");
        int teacherId = get.getInputId();
        if (qy.IsExistTeacher(teacherId, true)) {
            boolean flag = up.setTeahcer(tClassId, teacherId);
            if (flag) {
                System.out.println("修改老师成功");
            } else {
                System.out.println("修改老师失败");
            }
        } else {
            System.err.println("此老师不存在");
        }
    }

    @Override
    public void deleteStudent() {
        Education edu = get.getInputEducation();
        ArrayList<Course> courseList = qy.queryCourse(edu, true);
        int courseId = get.getInputCourse(courseList);
        ArrayList<TClass> tClassList = qy.queryTClass(courseId, true);
        int tClassId = get.getInputClass(tClassList);
        ArrayList<Student> studentList = qy.queryStudent(tClassId, true);
        int studentId = get.getInputStudent(studentList);
        boolean flag = up.deleteTaking(studentId, tClassId);
        if (flag) {
            System.out.println("在班级里删除成功");
        } else {
            System.out.println("在班级里删除失败");
        }
    }

    @Override
    public void addStudent() {
        Education edu = get.getInputEducation();
        ArrayList<Course> courseList = qy.queryCourse(edu, true);
        int courseId = get.getInputCourse(courseList);
        ArrayList<TClass> tClassList = qy.queryTClass(courseId, true);
        int tClassId = get.getInputClass(tClassList);
        int studentId = get.getInputId();
        if (qy.IsExistStudent(studentId, true)) {
            boolean flag = up.addTaking(studentId, tClassId);
            if (flag) {
                System.out.println("增加学生成功");
            } else {
                System.out.println("增加学生失败");
            }
        } else {
            System.out.println("此学生不存在");
        }
    }

    @Override
    public void deleteTClass() {
        Education edu = get.getInputEducation();
        ArrayList<Course> courseList = qy.queryCourse(edu, true);
        int courseId = get.getInputCourse(courseList);
        ArrayList<TClass> classList = qy.queryTClass(courseId, true);
        int tClassId = get.getInputClass(classList);
        boolean flag = false;
        for (TClass tClass : classList) {
            if (tClassId == tClass.getClassID()) {
                if (tClass.getStudentNum() == 0)
                    flag = true;
            }
        }
        if (flag) {
            flag = up.deleteTClass(tClassId);
            if (flag) {
                System.out.println("删除课程成功");
            } else {
                System.out.println("删除课程失败");
            }
        } else {
            System.out.println("此班级中有学生存在，不能删除");
        }
    }

    public void run() {
        int func = -1;
        while (func != 0) {
            System.out.println("-----------------班级管理----------------");
            System.out.println("1.查询当前存在的所有班级");
            System.out.println("2.查询某个班级的所有学生");
            System.out.println("3.查询一个班级的老师");
            System.out.println("4.增加一个班级");
            System.out.println("5.删除一个班级");
            System.out.println("6.更改一个班级的老师");
            System.out.println("7.在一个班级里删除一个学生");
            System.out.println("8.在一个班级里增加一个学生");
            System.out.println("0.退出");
            func = get.getInputFunction(8);
            switch (func) {
                case 1:
                    showAllTClass();
                    get.getInputEnter();
                    break;
                case 2:
                    showCertainTClassStudent();
                    get.getInputEnter();
                    break;
                case 3:
                    showCertainTClassTeacher();
                    get.getInputEnter();
                    break;
                case 4:
                    addTClass();
                    get.getInputEnter();
                    break;
                case 5:
                    deleteTClass();
                    get.getInputEnter();
                    break;
                case 6:
                    ChangeTeacher();
                    get.getInputEnter();
                    break;
                case 7:
                    addStudent();
                    get.getInputEnter();
                    break;
                case 8:
                    deleteStudent();
                    get.getInputEnter();
                    break;
                default:
                    break;
            }
        }
    }

}
