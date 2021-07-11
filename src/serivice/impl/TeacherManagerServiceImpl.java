/*
 * @Author: xv_rong
 * @Date: 2021-07-09 21:49:31
 * @LastEditors: xv_rong
 * @LastEditTime: 2021-07-11 20:03:46
 * @Description: TeacherManagerService
 * @FilePath: \TCMS\src\serivice\impl\TeacherManagerServiceImpl.java
 */
package serivice.impl;

import java.util.ArrayList;

import SQL.Query;
import SQL.Update;
import SQL.Impl.QueryImpl;
import SQL.Impl.UpdateImpl;
import Tool.Education;
import entity.Course.Course;
import entity.Person.Teacher;
import entity.TClass.TClass;
import serivice.TeacherManagerService;
import windows.GetInput;
import windows.Print;
import windows.impl.GetInputImpl;
import windows.impl.PrintImpl;

public class TeacherManagerServiceImpl implements TeacherManagerService {

    @Override
    public void showAllTeacher() {
        Query qy = new QueryImpl();
        Print pt = new PrintImpl();
        ArrayList<Teacher> TeacherList = qy.queryTeacher(true);
        pt.printTeacherBasicInfomation(TeacherList);
    }

    @Override
    public void showCertainClassTeacher() {
        GetInput get = new GetInputImpl();
        Query qy = new QueryImpl();
        Print pt = new PrintImpl();
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
    public void showCertainTeacher() {
        GetInput get = new GetInputImpl();
        Query qy = new QueryImpl();
        Print pt = new PrintImpl();
        int teacherId = get.getInputId();
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
        GetInput get = new GetInputImpl();
        Query qy = new QueryImpl();
        Print pt = new PrintImpl();
        int teacherId = get.getInputId();
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
        GetInput get = new GetInputImpl();
        Query qy = new QueryImpl();
        Print pt = new PrintImpl();
        int teacherId = get.getInputId();
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
        GetInput get = new GetInputImpl();
        Update up = new UpdateImpl();
        Print pt = new PrintImpl();
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
        GetInput get = new GetInputImpl();
        Update up = new UpdateImpl();
        Print pt = new PrintImpl();
        Query qy = new QueryImpl();
        int teacherId = get.getInputId();
        if (qy.IsExistTeacher(teacherId, true)) {
            Teacher teacher = qy.queryTeacherByTeacherId(teacherId, true);
            ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
            teacherList.add(teacher);
            pt.printTeacherAllInformation(teacherList);
            if (get.getInputYN()) {
                if (up.deleteTeacher(teacherId))
                    System.out.println("删除成功");
                else
                    System.out.println("删除失败");
            }
        } else {
            System.out.println("无此老师");
        }
    }

    @Override
    public void setSalary() {
        GetInput get = new GetInputImpl();
        Update up = new UpdateImpl();
        Print pt = new PrintImpl();
        Query qy = new QueryImpl();
        int teacherId = get.getInputId();
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

}
