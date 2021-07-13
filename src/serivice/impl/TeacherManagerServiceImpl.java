/*
 * @Author: xv_rong
 * @Date: 2021-07-09 21:49:31
 * @LastEditors: xv_rong
 * @LastEditTime: 2021-07-13 14:48:17
 * @Description: TeacherManagerService
 * @FilePath: \TCMS\src\serivice\impl\TeacherManagerServiceImpl.java
 */
package serivice.impl;

import java.util.ArrayList;

import Tool.Education;
import entity.Course.Course;
import entity.Person.Teacher;
import entity.TClass.TClass;
import serivice.TeacherManagerService;

public class TeacherManagerServiceImpl implements TeacherManagerService {

    @Override
    public void showAllTeacher() {
        ArrayList<Teacher> TeacherList = qy.queryTeacher(true);
        pt.printTeacherBasicInfomation(TeacherList);
    }

    @Override
    public void showCertainClassTeacher() {
        Education edu = get.getInputEducation();
        ArrayList<Course> courseList = qy.queryCourse(edu, true);
        int courseId = get.getInputCourse(courseList);
        ArrayList<TClass> tClassList = qy.queryTClass(courseId, true);
        int tClassId = get.getInputClass(tClassList);
        Teacher teacher = qy.queryTeacher(tClassId, true);
        ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
        teacherList.add(teacher);
        pt.printTeacherBasicInfomation(teacherList);
    }

    @Override
    public void showCertainTeacher() {
        int teacherId = get.getInputInt("请选择ID: ", -1, -1);
        qy.queryTeacherByTeacherId(teacherId, true);
        if (qy.IsExistTeacher(teacherId, true)) {
            Teacher teacher = qy.queryTeacherByTeacherId(teacherId, true);
            ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
            teacherList.add(teacher);
            pt.printTeacherAllInformation(teacherList);
        } else {
            System.out.println("不存在此老师");
        }

    }

    @Override
    public void showTeacherNowClass() {
        int teacherId = get.getInputInt("请选择ID: ", -1, -1);
        qy.queryTeacherByTeacherId(teacherId, true);
        if (qy.IsExistTeacher(teacherId, true)) {
            ArrayList<TClass> tClassList = qy.queryTClassByTeacherId(teacherId, true);
            pt.printTClassBasicInfomation(tClassList);
        } else {
            System.out.println("不存在此老师");
        }

    }

    @Override
    public void showTeacherHistoryClass() {
        int teacherId = get.getInputInt("请选择ID: ", -1, -1);
        qy.queryTeacherByTeacherId(teacherId, true);
        if (qy.IsExistTeacher(teacherId, true)) {
            ArrayList<TClass> tClassList = qy.queryTClassByTeacherId(teacherId, false);
            pt.printTClassBasicInfomation(tClassList);
        } else {
            System.out.println("不存在此老师");
        }
    }

    @Override
    public void addTeacher() {
        Teacher teacher = new Teacher();
        String name = get.getInputName();
        teacher.setName(name);
        String birthday = get.getInputBirthday();
        teacher.setBirthday(birthday);
        String sex = get.getInputSex();
        teacher.setSex(sex);
        double salary = get.getInputSalary();
        teacher.setSalary(salary);
        String password = get.getInputPassword();
        ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
        teacherList.add(teacher);
        pt.printTeacherAllInformation(teacherList);
        if (get.getInputYN()) {
            if (up.addTeacher(teacher, password))
                System.out.println("添加成功");
            else
                System.out.println("添加失败");
        }

    }

    @Override
    public void deleteTeacher() {
        int teacherId = get.getInputInt("请选择ID: ", -1, -1);
        if (qy.IsExistTeacher(teacherId, true)) {
            Teacher teacher = qy.queryTeacherByTeacherId(teacherId, true);
            ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
            teacherList.add(teacher);
            pt.printTeacherAllInformation(teacherList);
            ArrayList<TClass> tClassList = qy.queryTClassByTeacherId(teacherId, true);
            if (tClassList.size() == 0) {
                if (get.getInputYN()) {
                    if (up.deleteTeacher(teacherId))
                        System.out.println("删除成功");
                    else
                        System.out.println("删除失败");
                }
            } else {
                System.out.println("此老师正在授课，无法删除");
            }
        } else {
            System.out.println("无此老师");
        }
    }

    @Override
    public void setSalary() {
        int teacherId = get.getInputInt("请选择ID: ", -1, -1);
        if (qy.IsExistTeacher(teacherId, true)) {
            Teacher teacher = qy.queryTeacherByTeacherId(teacherId, true);
            System.out.println("原来的工资为：" + teacher.getSalary());
            double salary = get.getInputSalary();
            boolean flag = up.setTeacherSalary(teacherId, salary);
            if (flag) {
                System.out.println("设置成功");
            } else {
                System.out.println("设置失败");
            }
        } else {
            System.out.println("无此老师");
        }

    }

    @Override
    public void run() {

        int func = -1;
        while (func != 0) {
            System.out.println("-----------------教师管理----------------");
            System.out.println("1.查询当前存在的所有老师");
            System.out.println("2.查询某个班级的所有老师");
            System.out.println("3.查询一个老师的详细信息");
            System.out.println("4.查询一个老师所教的现存班级");
            System.out.println("5.查询一个老师所教的历史班级");
            System.out.println("6.增加一个老师");
            System.out.println("7.删除一个老师");
            System.out.println("8.设置一个老师的工资");
            System.out.println("0.退出");
            func = get.getInputInt("请选择序号: ", 0, 8);
            switch (func) {
                case 1:
                    showAllTeacher();
                    get.getInputEnter();
                    break;
                case 2:
                    showCertainClassTeacher();
                    get.getInputEnter();
                    break;
                case 3:
                    showCertainTeacher();
                    get.getInputEnter();
                    break;
                case 4:
                    showTeacherNowClass();
                    get.getInputEnter();
                    break;
                case 5:
                    showTeacherHistoryClass();
                    get.getInputEnter();
                    break;
                case 6:
                    addTeacher();
                    get.getInputEnter();
                    break;
                case 7:
                    deleteTeacher();
                    get.getInputEnter();
                    break;
                case 8:
                    setSalary();
                    get.getInputEnter();
                    break;
                default:
                    break;
            }
        }

    }

}
