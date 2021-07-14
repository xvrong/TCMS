/*
 * @Author: xv_rong
 * @Date: 2021-07-12 10:53:28
 * @LastEditors: xv_rong
 * @LastEditTime: 2021-07-14 10:36:42
 * @Description: 
 * @FilePath: \TCMS\src\test\Main.java
 */
package test;

import SQL.Query;
import SQL.Impl.QueryImpl;
import serivice.ManagerService;
import serivice.StudentService;
import serivice.TeacherService;
import serivice.impl.ManagerServiceImpl;
import serivice.impl.StudentServiceImpl;
import serivice.impl.TeacherServiceImpl;
import windows.impl.GetInputImpl;

public class Main {
    static GetInputImpl gt = new GetInputImpl();

    public static void main(String[] args) {
        System.out.println("-----------------课外辅导管理系统启动----------------");
        while (true) {
            System.out.println("--------------------请选择登录模式-------------------");
            System.out.println("1.学生登录");
            System.out.println("2.老师登录");
            System.out.println("3.管理员登录");
            System.out.println("0.退出");
            int model = 0;
            model = gt.getInputInt("请输入序号: ", 0, 3);
            switch (model) {
                case 1:
                    studentLogin();
                    break;
                case 2:
                    teacherLogin();
                    break;
                case 3:
                    managerLogin();
                    break;
                default:
                    return; // 程序退出
            }
        }
    }

    static void studentLogin() {
        Query qy = new QueryImpl();
        do {
            int studentId = gt.getInputInt("请输入学生Id:", -1, -1);
            String password = gt.getInputHideString("请输入密码: ");
            if (qy.isExistStudent(studentId, password, true)) {
                System.out.println("登录成功");
                StudentService studentService = new StudentServiceImpl();
                studentService.run(studentId);
                break;
            } else {
                System.out.println("登录失败，用户Id或密码错误，请重试!");
            }
        } while (true);
    }

    static void teacherLogin() {
        Query qy = new QueryImpl();
        do {
            int teacherId = gt.getInputInt("请输入老师Id:", -1, -1);
            String password = gt.getInputHideString("请输入密码: ");
            if (qy.isExistTeacher(teacherId, password, true)) {
                System.out.println("登录成功");
                TeacherService teacherService = new TeacherServiceImpl();
                teacherService.run(teacherId);
                break;
            } else {
                System.out.println("登录失败，用户Id或密码错误");
                System.out.println("请重新输入");
            }
        } while (true);
    }

    static void managerLogin() {
        Query qy = new QueryImpl();
        do {
            String managerId = gt.getInputString("请输入管理员ID: ");
            String password = gt.getInputHideString("请输入密码: ");
            if (qy.isExistManager(managerId, password)) {
                System.out.println("登录成功");
                ManagerService managerService = new ManagerServiceImpl();
                managerService.run();
                break;
            } else {
                System.out.println("登录失败，用户Id或密码错误");
                System.out.println("请重新输入");
            }
        } while (true);
    }
}
