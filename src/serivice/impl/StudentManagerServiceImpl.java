/*
 * @Author: xv_rong
 * @Date: Fri Jul 09 2021 21:44:53
 * @LastEditors: xv_rong
 * @LastEditTime: 2021-07-14 08:38:13
 * @Description: 
 * @FilePath: \TCMS\src\serivice\impl\StudentManagerServiceImpl.java
 */

package serivice.impl;

import java.util.ArrayList;
import Tool.Education;
import entity.Course.Course;
import entity.Person.Student;
import entity.TClass.TClass;
import serivice.StudentManagerService;

public class StudentManagerServiceImpl implements StudentManagerService {
    @Override
    public void showCertainClassStudent() {
        Education edu = get.getInputEducation();
        ArrayList<Course> courseList = qy.queryCourse(edu, true);
        if (courseList.size() != 0) {
            int courseId = get.getInputCourse(courseList);
            ArrayList<TClass> tClassList = qy.queryTClass(courseId, true);
            if (tClassList.size() != 0) {
                int tClassId = get.getInputTClass(tClassList);
                ArrayList<Student> studentList = qy.queryStudent(tClassId, true);
                if (studentList.size() != 0) {
                    pt.printStudentBasicInfomation(studentList);
                } else {
                    System.out.println("此班级暂无学生");
                }
            } else {
                System.out.println("此课程暂无学生");
            }
        } else {
            System.out.println("此学历下暂无课程");
        }
    }

    @Override
    public void showAllStudent() {
        ArrayList<Student> studentList = qy.queryStudent(true);
        if (studentList.size() != 0) {
            pt.printStudentBasicInfomation(studentList);
        } else {
            System.out.println("本补课班无学生");
        }
    }

    @Override
    public void showCertainTeacherStudent() {
        int teacherId = get.getInputInt("请选择ID: ", -1, -1);
        if (qy.IsExistTeacher(teacherId, true)) {
            ArrayList<Student> studentList = qy.queryStudentByTeacher(teacherId, true);
            if (studentList.size() != 0) {
                pt.printStudentBasicInfomation(studentList);
            } else {
                System.out.println("此老师暂无学生");
            }
        } else {
            System.out.println("此ID无对应老师");
        }
    }

    @Override
    public void showCertainStudent() {
        int studentId = get.getInputInt("请选择ID: ", -1, -1);
        if (qy.IsExistStudent(studentId, true)) {
            Student student = qy.queryStudentByStudentID(studentId, true);
            ArrayList<Student> studentList = new ArrayList<Student>();
            studentList.add(student);
            pt.printStudentAllInformation(studentList);
        } else {
            System.out.println("此ID无对应学生");
        }
    }

    @Override
    public void addStudent() {
        Student student = new Student();
        String name = get.getInputString("请输入学生姓名: ");
        student.setName(name);
        Education edu = get.getInputEducation();
        student.setEdu(edu);
        String birthday = get.getInputBirthday();
        student.setBirthday(birthday);
        String sex = get.getInputSex();
        student.setSex(sex);
        student.setState(true);
        String password = get.getInputPassword();
        ArrayList<Student> studentList = new ArrayList<Student>();
        studentList.add(student);
        // TODO: 无法正确显示ID
        pt.printStudentAllInformation(studentList);
        if (get.getInputYN()) {
            if (up.addStudent(student, password))
                System.out.println("添加成功");
            else
                System.out.println("添加失败");
        }
    }

    @Override
    public void deleteStudent() {
        int studentId = get.getInputInt("请选择ID: ", -1, -1);
        if (qy.IsExistStudent(studentId, true)) {
            Student student = qy.queryStudentByStudentID(studentId, true);
            ArrayList<Student> studentList = new ArrayList<Student>();
            studentList.add(student);
            pt.printStudentAllInformation(studentList);
            if (get.getInputYN()) {
                if (up.deleteStudent(studentId))
                    System.out.println("删除成功");
                else
                    System.out.println("删除失败");
            }
        } else {
            System.out.println("此ID无对应学生");
        }
    }

    @Override
    public void changeStudentClass() {
        int studentId = get.getInputInt("请输入学生ID: ", -1, -1);
        if (qy.IsExistStudent(studentId, true)) {
            ArrayList<Course> courseList = qy.queryCourseByStudentId(studentId, true);
            if (courseList.size() != 0) {
                int courseId = get.getInputCourse(courseList);
                ArrayList<TClass> tClassList = qy.queryTClass(courseId, true);
                ArrayList<TClass> legalTClassList = new ArrayList<TClass>(); // 人数未满的班级列表
                for (TClass tcl : tClassList) {
                    if (tcl.getStudentNum() < tcl.getMaxStudentNum()) {
                        legalTClassList.add(tcl);
                    }
                }
                if (legalTClassList.size() != 0) {
                    TClass nowTClass = qy.queryTClass(courseId, studentId, true);
                    System.out.println("此学生当前年级为: " + nowTClass.getGrade() + " 班号为: " + nowTClass.getOrderNumber());
                    int tClassId = get.getInputTClass(legalTClassList);
                    if (tClassId != nowTClass.getClassID()) {
                        if (up.deleteTaking(studentId, nowTClass.getClassID())) {
                            if (up.addTaking(studentId, tClassId)) {
                                System.out.println("调整成功");
                            } else {
                                System.out.println("调整失败");
                                up.addTaking(studentId, nowTClass.getClassID());
                            }
                        } else {
                            System.out.println("调整失败");
                        }
                    } else {
                        System.out.println("不能选择当前班级");
                    }
                } else {
                    System.out.println("此课程无其他班级可供调入");
                }
            } else {
                System.out.println("此学生无课程");
            }
        } else {
            System.out.println("补课班无此学生");
        }
    }

    @Override
    public void showCertainStudentNowClass() {
        int studentId = get.getInputInt("请输入学生ID: ", -1, -1);
        if (qy.IsExistStudent(studentId, true)) {
            ArrayList<TClass> tClassList = qy.queryTClassByStudent(studentId, true);
            if (tClassList.size() != 0) {
                pt.printTClassInfomation(tClassList);
            } else {
                System.out.println("此学生暂无班级");
            }
        } else {
            System.out.println("补课班无此学生");
        }
    }

    @Override
    public void showCertainStudentHistoryClass() {
        int studentId = get.getInputInt("请输入学生ID: ", -1, -1);
        if (qy.IsExistStudent(studentId, true)) {
            ArrayList<TClass> tClassList = qy.queryTClassByStudent(studentId, false);
            if (tClassList.size() != 0) {
                pt.printTClassInfomation(tClassList);
            } else {
                System.out.println("此学生暂无历史班级");
            }
        } else {
            System.out.println("补课班无此学生");
        }

    }

    @Override
    public void run() {
        int func = -1;
        while (func != 0) {
            System.out.println("-----------------学生管理----------------");
            System.out.println("1.显示当前存在的所有学生");
            System.out.println("2.显示某个班级的所有学生");
            System.out.println("3.显示一个老师的所有学生");
            System.out.println("4.显示一个学生的详细信息");
            System.out.println("5.显示一个学生的当前班级");
            System.out.println("6.显示一个学生的历史班级");
            System.out.println("7.添加一个学生");
            System.out.println("8.删除一个学生");
            System.out.println("9.更改学生班级");
            System.out.println("0.退出");
            func = get.getInputInt("请选择序号: ", 0, 9);
            switch (func) {
                case 1:
                    showAllStudent();
                    get.getInputEnter();
                    break;
                case 2:
                    showCertainClassStudent();
                    get.getInputEnter();
                    break;
                case 3:
                    showCertainTeacherStudent();
                    get.getInputEnter();
                    break;
                case 4:
                    showCertainStudent();
                    get.getInputEnter();
                    break;
                case 5:
                    showCertainStudentNowClass();
                    get.getInputEnter();
                    break;
                case 6:
                    showCertainStudentHistoryClass();
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
                case 9:
                    changeStudentClass();
                    get.getInputEnter();
                    break;
                default:
                    break;
            }
        }
    }
}
