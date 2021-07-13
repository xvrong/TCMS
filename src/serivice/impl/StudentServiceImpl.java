/*
 * @Author: LinXuan
 * @Date: 2021-07-12 16:58:57
 * @Description: 
 * @LastEditors: xv_rong
 * @LastEditTime: 2021-07-13 14:44:30
 * @FilePath: \TCMS\src\serivice\impl\StudentServiceImpl.java
 */
package serivice.impl;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import entity.Course.Course;
import entity.Person.Student;
import entity.TClass.TClass;
import serivice.StudentService;

public class StudentServiceImpl implements StudentService {
    final static PrintStream jout = System.out;
    Student student = null;

    @Override
    public void showPersonalInfo() {
        ArrayList<Student> studentList = new ArrayList<Student>();
        studentList.add(student);
        pt.printStudentAllInformation(studentList);
    }

    @Override
    public void showPersonalTClass() {
        ArrayList<TClass> tClassList = qy.queryTClassByStudent(student.getStudentID(), true);
        pt.printTClassInfomation(tClassList);
    }

    @Override
    public void showHistoryTClass() {
        ArrayList<TClass> tClassList = qy.queryTClassByStudent(student.getStudentID(), false);
        pt.printTClassInfomation(tClassList);

    }

    @Override
    public void selectCourse() {
        // 得到学生合法的选课列表
        ArrayList<Course> allCourseList = qy.queryCourse(student.getEdu(), true);
        ArrayList<TClass> nowTClassList = qy.queryTClassByStudent(student.getStudentID(), true); // 学生已经在修的课程班级
        ArrayList<Course> LegalCourseList = new ArrayList<Course>(); // 合法的课程列表
        ArrayList<TClass> LegalCourseTclassList = new ArrayList<TClass>(); // 合法课程对应的班级列表
        HashSet<Integer> nowTCassSet = new HashSet<Integer>(); // 学生已经在修的课程ID集合
        for (TClass tcl : nowTClassList) {
            nowTCassSet.add(tcl.getCourseID());
        }

        // 刷选出可以选择的课程列表及对应班级
        for (Course cour : allCourseList) {
            boolean canChose = false;
            ArrayList<TClass> courseTclassList = qy.queryTClass(cour.getCourseId(), true);
            TClass tClass = null;
            for (TClass tcl : courseTclassList) { // 课程有一年级开课班级、且班级有剩余空间
                if (tcl.getGrade() == 1 && tcl.getStudentNum() < tcl.getMaxStudentNum()) {
                    canChose = true;
                    tClass = tcl;
                    break;
                }
            }
            if (nowTCassSet.contains(cour.getCourseId()) == false && canChose == true) {
                LegalCourseList.add(cour);
                LegalCourseTclassList.add(tClass);
            }
        }

        // 选课操作
        if (LegalCourseList.size() == 0) { // 当前没有可选班级
            jout.println("当前没有可选课程, 请联系管理员了解详情");
        } else {
            int courseID = get.getInputCourse(LegalCourseList);
            int index = 0;
            for (Course cour : LegalCourseList) {
                if (cour.getCourseId() != courseID)
                    index++;
                else
                    break;
            }
            Boolean success = up.addTaking(student.getStudentID(), LegalCourseTclassList.get(index).getClassID());
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
        student = qy.queryStudentByStudentID(studentID, true);
        int func = -1;
        while (func != 0) {
            // 界面部分
            jout.println("-----------------学生界面----------------");
            jout.println("1.查看个人信息");
            jout.println("2.查询自己的班级");
            jout.println("3.查询历史班级");
            jout.println("4.进行选课");
            jout.println("0.退出登录");
            func = get.getInputInt("请选择序号: ", 0, 4);
            switch (func) {
                case 1:
                    showPersonalInfo();
                    get.getInputEnter();
                    break;
                case 2:
                    showPersonalTClass();
                    get.getInputEnter();
                    break;
                case 3:
                    showHistoryTClass();
                    get.getInputEnter();
                    break;
                case 4:
                    selectCourse();
                    get.getInputEnter();
                    break;
                default:
                    break;
            }
        }
    }
}