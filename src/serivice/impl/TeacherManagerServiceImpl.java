/*
 * @Author: xv_rong
 * @Date: 2021-07-09 21:49:31
 * @LastEditors: xv_rong
 * @LastEditTime: 2021-07-14 09:20:08
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
        if (TeacherList.isEmpty()) {
            System.out.println("本补习班没有老师");
        } else {
            pt.printTeacherBasicInfomation(TeacherList);
        }
    }

    @Override
    public void showCertainClassTeacher() {
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
    public void showCertainTeacher() {
        int teacherId = get.getInputInt("请选择ID: ", -1, -1);
        if (qy.IsExistTeacher(teacherId, true)) {
            Teacher teacher = qy.queryTeacherByTeacherId(teacherId, true);
            ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
            teacherList.add(teacher);
            pt.printTeacherAllInformation(teacherList);
        } else {
            System.out.println("此ID无对应老师");
        }

    }

    @Override
    public void showTeacherNowClass() {
        int teacherId = get.getInputInt("请选择ID: ", -1, -1);
        if (qy.IsExistTeacher(teacherId, true)) {
            ArrayList<TClass> tClassList = qy.queryTClassByTeacherId(teacherId, true);
            if (tClassList.isEmpty()) {
                System.out.println("此老师暂无班级");
            } else {
                pt.printTClassInfomation(tClassList);
            }
        } else {
            System.out.println("此ID无对应老师");
        }
    }

    @Override
    public void showTeacherHistoryClass() {
        int teacherId = get.getInputInt("请选择ID: ", -1, -1);
        if (qy.IsExistTeacher(teacherId, true)) {
            ArrayList<TClass> tClassList = qy.queryTClassByTeacherId(teacherId, false);
            if (tClassList.isEmpty()) {
                System.out.println("此老师暂无班级");
            } else {
                pt.printTClassInfomation(tClassList);
            }
        } else {
            System.out.println("此ID无对应老师");
        }
    }

    @Override
    public void addTeacher() {
        Teacher teacher = new Teacher();
        String name = get.getInputString("请输入老师姓名: ");
        teacher.setName(name);
        String birthday = get.getInputBirthday();
        teacher.setBirthday(birthday);
        String sex = get.getInputSex();
        teacher.setSex(sex);
        double salary = get.getInputSalary();
        teacher.setSalary(salary);
        teacher.setState(true);
        String password = get.getInputPassword();

        ArrayList<Teacher> tmp = qy.queryMaxTeacherId();
        teacher.setTeacherID(tmp.get(0).getTeacherID() + 1);

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
            ArrayList<TClass> tClassList = qy.queryTClassByTeacherId(teacherId, true);
            if (tClassList.size() == 0) {
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
                System.out.println("此老师正在授课，无法删除");
            }
        } else {
            System.out.println("此ID无对应老师");
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
            System.out.println("此ID无对应老师");
        }

    }

    @Override
    public void run() {

        int func = -1;
        while (func != 0) {
            System.out.println("-----------------教师管理----------------");
            System.out.println("1.查询当前存在的所有老师");
            System.out.println("2.查询某个班级的老师");
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
