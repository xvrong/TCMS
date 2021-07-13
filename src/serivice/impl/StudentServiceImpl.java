/*
 * @Author: LinXuan
 * @Date: 2021-07-12 16:58:57
 * @Description: 
 * @LastEditors: LinXuan
 * @LastEditTime: 2021-07-13 11:04:58
 * @FilePath: \TCMS\src\serivice\impl\StudentServiceImpl.java
 */
package serivice.impl;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import SQL.Impl.QueryImpl;
import SQL.Impl.UpdateImpl;
import entity.Course.Course;
import entity.Person.Student;
import entity.TClass.TClass;
import serivice.StudentService;
import windows.impl.GetInputImpl;
import windows.impl.PrintImpl;

public class StudentServiceImpl implements StudentService {
    final static PrintStream jout = System.out;
    Student student = null;

    @Override
    public void showPersonalInfo() {
        ArrayList<Student> studentList = new ArrayList<Student>();
        studentList.add(student);
        PrintImpl pt = new PrintImpl();
        pt.printStudentAllInformation(studentList);
    }

    @Override
    public void showPersonalTClass() {
        QueryImpl qy = new QueryImpl();
        ArrayList<TClass> tClassList = qy.queryTClassByStudent(student.getStudentID(), true);
        PrintImpl pt = new PrintImpl();
        pt.printTClassBasicInfomation(tClassList);
    }

    @Override
    public void showHistoryTClass() {
        QueryImpl qy = new QueryImpl();
        ArrayList<TClass> tClassList = qy.queryTClassByStudent(student.getStudentID(), false);
        PrintImpl pt = new PrintImpl();
        pt.printTClassBasicInfomation(tClassList);

    }

    @Override
    public void selectCourse() {
        // 得到学生合法的选课列表
        QueryImpl qy = new QueryImpl();
        ArrayList<Course> allCourseList = qy.queryCourse(student.getEdu(), true);
        ArrayList<TClass> nowTClassList = qy.queryTClassByStudent(student.getStudentID(), true); // 学生已经在修的课程班级
        ArrayList<Course> LegalCourseList = new ArrayList<Course>(); // 合法的课程列表
        ArrayList<Integer> LegalCourseTclassNumList = new ArrayList<Integer>(); // 可发课程对应的班级列表
        HashSet<Integer> nowTCassSet = new HashSet<Integer>(); // 学生已经在修的课程ID集合
        for (TClass tcl : nowTClassList) {
            nowTCassSet.add(tcl.getCourseID());
        }

        // 刷选出可以选择的课程列表及对应班级
        for (Course cour : allCourseList) {
            boolean canChose = false;
            ArrayList<TClass> courseTclassList = qy.queryTClass(cour.getCourseId(), true);
            int tClassNum = -1;
            for (TClass tcl : courseTclassList) { // 课程有一年级开课班级、且班级有剩余空间
                if (tcl.getGrade() == 1 && tcl.getStudentNum() < tcl.getMaxStudentNum()) {
                    canChose = true;
                    tClassNum = tcl.getStudentNum();
                    break;
                }
            }
            if (nowTCassSet.contains(cour.getCourseId()) == false && canChose == true) {
                LegalCourseList.add(cour);
                LegalCourseTclassNumList.add(tClassNum);
            }
        }

        // 选课操作
        if (LegalCourseList.size() == 0) { // 当前没有可选班级
            jout.println("当前没有可选课程, 请联系管理员了解详情");
        } else {
            GetInputImpl gt = new GetInputImpl();
            int courseID = gt.getInputCourse(LegalCourseList);
            int index = 0;
            for (Course cour : LegalCourseList) {
                if (cour.getCourseId() != courseID)
                    index++;
                else
                    break;
            }
            UpdateImpl up = new UpdateImpl();
            Boolean success = up.addTaking(student.getStudentID(), LegalCourseTclassNumList.get(index));
            if (success == true) {
                jout.println("选课成功");
            } else {
                jout.println("选课失败");
            }
        }

    }

    @Override
    public void run(int studentID) {
        // 初始化学生
        QueryImpl qy = new QueryImpl();
        student = qy.queryStudentByStudentID(studentID, true);

        // 界面部分
        jout.println("-----------------学生界面----------------");
        jout.println("1.查看个人信息");
        jout.println("2.查询自己的班级");
        jout.println("3.查询历史班级");
        jout.println("4.进行选课");
        jout.println("0.退出登录");

        int func = -1;
        Scanner input = new Scanner(System.in);
        while (func != 0) {
            do {
                jout.print("请输入选择: ");
                func = input.nextInt();
                if (func < 0 || func > 4) {
                    System.out.print("输入错误，请重新输入:");
                }
            } while (func < 0 || func > 4);
            switch (func) {
                case 1:
                    showPersonalInfo();
                    break;
                case 2:
                    showPersonalTClass();
                    break;
                case 3:
                    showHistoryTClass();
                    break;
                case 4:
                    selectCourse();
                    break;
                case 0:
                    return;
                default:
                    break;
            }
        }
    }
}