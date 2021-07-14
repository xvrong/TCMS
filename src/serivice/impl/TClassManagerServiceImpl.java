/*
 * @Author: xv_rong
 * @Date: 2021-07-09 21:48:17
 * @LastEditors: xv_rong
 * @LastEditTime: 2021-07-14 15:50:51
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
        if (tClassList.isEmpty()) {
            System.out.println("本补习班暂无班级");
            return;
        }
        pt.printTClassInfomation(tClassList);
    }

    @Override
    public void showCertainTClassStudent() {
        Education edu = get.getInputEducation();
        ArrayList<Course> courseList = qy.queryCourse(edu, true);
        if (courseList.isEmpty()) {
            System.out.println("本学历暂无课程");
            return;
        }
        int courseId = get.getInputCourse(courseList);
        ArrayList<TClass> tClassList = qy.queryTClass(courseId, true);
        if (tClassList.isEmpty()) {
            System.out.println("本课程暂无班级");
            return;
        }
        int tClassId = get.getInputTClass(tClassList);
        ArrayList<Student> studentList = qy.queryStudent(tClassId, true);
        if (studentList.isEmpty()) {
            System.out.println("本班级暂无学生");
            return;
        }
        pt.printStudentBasicInfomation(studentList);
    }

    @Override
    public void showCertainTClassTeacher() {
        Education edu = get.getInputEducation();
        ArrayList<Course> courseList = qy.queryCourse(edu, true);
        if (courseList.isEmpty()) {
            System.out.println("本学历暂无课程");
            return;
        }
        int courseId = get.getInputCourse(courseList);
        ArrayList<TClass> tClassList = qy.queryTClass(courseId, true);
        if (tClassList.isEmpty()) {
            System.out.println("本课程暂无班级");
            return;
        }
        int tClassId = get.getInputTClass(tClassList);
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
        if (courseList.isEmpty()) {
            System.out.println("本学历暂无课程");
            return;
        }
        int courseId = get.getInputCourse(courseList);
        tClass.setCourseID(courseId);
        for (Course course : courseList) {
            if (course.getCourseId() == courseId) {
                tClass.setCourseName(course.getName());
            }
        }
        tClass.setStudentNum(0);
        tClass.setGrade(1);
        ArrayList<TClass> tClassList = qy.queryTClass(courseId, true);
        int num = 1;
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        for (TClass tcl : tClassList) {
            tmp.add(tcl.getOrderNumber());
        }
        tmp.sort(null);
        for (Integer i : tmp) {
            if (i.equals((Integer) num)) {
                ++num;
                continue;
            } else {
                break;
            }
        }
        tClass.setOrderNumber(num);
        System.out.println("选择对应老师");
        int teacherId = get.getInputInt("请选择ID: ", -1, -1);
        if (!qy.IsExistTeacher(teacherId, true)) {
            System.out.println("此ID无对应老师");
            return;
        }
        tClass.setTeacherID(teacherId);
        tClass.setTeacherName(qy.queryTeacherByTeacherId(teacherId, true).getName());
        int maxNum = get.getInputInt("请输入本班最大人数: ", 1, -1);
        tClass.setMaxStudentNum(maxNum);
        int year = cal.get(Calendar.YEAR);
        tClass.setStartYear(year);
        tClass.setState(true);
        ArrayList<TClass> tmpTClass = qy.queryMaxTClassId();
        tClass.setClassID(tmpTClass.get(0).getClassID() + 1);
        ArrayList<TClass> showTClassList = new ArrayList<TClass>();
        showTClassList.add(tClass);
        pt.printTClassInfomation(showTClassList);
        if (get.getInputYN()) {
            if (up.addTClass(tClass)) {
                System.out.println("增加班级成功");
            } else {
                System.out.println("增加班级失败");
            }
        }
    }

    @Override
    public void ChangeTeacher() {
        Education edu = get.getInputEducation();
        ArrayList<Course> courseList = qy.queryCourse(edu, true);
        if (courseList.isEmpty()) {
            System.out.println("本学历暂无课程");
            return;
        }
        int courseId = get.getInputCourse(courseList);
        ArrayList<TClass> tClassList = qy.queryTClass(courseId, true);
        if (tClassList.isEmpty()) {
            System.out.println("本课程暂无班级");
            return;
        }
        int tClassId = get.getInputTClass(tClassList);
        int teacherId = get.getInputInt("请输入老师ID: ", -1, -1);
        if (qy.IsExistTeacher(teacherId, true)) {
            boolean flag = up.setTeahcer(tClassId, teacherId);
            if (flag) {
                System.out.println("修改老师成功");
            } else {
                System.out.println("修改老师失败");
            }
        } else {
            System.err.println("此ID无对应老师");
        }
    }

    @Override
    public void deleteStudent() {
        Education edu = get.getInputEducation();
        ArrayList<Course> courseList = qy.queryCourse(edu, true);
        if (courseList.isEmpty()) {
            System.out.println("本学历暂无课程");
            return;
        }
        int courseId = get.getInputCourse(courseList);
        ArrayList<TClass> tClassList = qy.queryTClass(courseId, true);
        if (tClassList.isEmpty()) {
            System.out.println("本课程暂无班级");
            return;
        }
        int tClassId = get.getInputTClass(tClassList);
        ArrayList<Student> studentList = qy.queryStudent(tClassId, true);
        if (studentList.isEmpty()) {
            System.out.println("此班级暂无学生");
        }
        int studentId = get.getInputStudent(studentList);
        boolean flag = up.deleteTaking(studentId, tClassId);
        if (flag) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }

    @Override
    public void addStudent() {
        Education edu = get.getInputEducation();
        ArrayList<Course> courseList = qy.queryCourse(edu, true);
        if (courseList.isEmpty()) {
            System.out.println("本学历暂无课程");
            return;
        }
        int courseId = get.getInputCourse(courseList);
        ArrayList<TClass> tClassList = qy.queryTClass(courseId, true);
        if (tClassList.isEmpty()) {
            System.out.println("本课程暂无班级");
            return;
        }
        int tClassId = get.getInputTClass(tClassList);
        boolean isFull = true;
        for (TClass tcl : tClassList) {
            if (tcl.getClassID() == tClassId) {
                if (tcl.getStudentNum() < tcl.getMaxStudentNum()) {
                    isFull = false;
                }
                break;
            }
        }
        if (isFull) {
            System.out.println("班级已满，无法调入");
            return;
        }
        int studentId = get.getInputInt("请输入学生ID: ", -1, -1);
        if (qy.IsExistStudent(studentId, true)) {
            ArrayList<Student> studentList = qy.queryStudent(tClassId, true);
            boolean hasExist = false;
            for (Student student : studentList) {
                if (student.getStudentID() == studentId) {
                    hasExist = true;
                    break;
                }
            }
            if (hasExist) {
                System.out.println("此学生已在此班级");
                return;
            }
            boolean flag = up.addTaking(studentId, tClassId);
            if (flag) {
                System.out.println("增加学生成功");
            } else {
                System.out.println("增加学生失败");
            }
        } else {
            System.out.println("此ID无对应学生");
        }
    }

    @Override
    public void deleteTClass() {
        Education edu = get.getInputEducation();
        ArrayList<Course> courseList = qy.queryCourse(edu, true);
        if (courseList.isEmpty()) {
            System.out.println("本学历暂无课程");
            return;
        }
        int courseId = get.getInputCourse(courseList);
        ArrayList<TClass> tClassList = qy.queryTClass(courseId, true);
        if (tClassList.isEmpty()) {
            System.out.println("本课程暂无班级");
            return;
        }
        int tClassId = get.getInputTClass(tClassList);
        ArrayList<Student> studentList = qy.queryStudent(tClassId, true);
        if (!studentList.isEmpty()) {
            System.out.println("此班级存在学生，无法删除");
            return;
        }
        if (up.deleteTClass(tClassId)) {
            System.out.println("删除班级成功");
        } else {
            System.out.println("删除班级失败");
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
            System.out.println("7.在一个班级里增加一个学生");
            System.out.println("8.在一个班级里删除一个学生");
            System.out.println("0.退出");
            func = get.getInputInt("请选择序号: ", 0, 8);
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
