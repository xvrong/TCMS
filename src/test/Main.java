/*
 * @Author: xv_rong
 * @Date: 2021-07-12 10:53:28
 * @LastEditors: xv_rong
 * @LastEditTime: 2021-07-12 20:16:53
 * @Description: 
 * @FilePath: \TCMS\src\test\Main.java
 */
package test;

import java.util.Scanner;

import SQL.Query;
import SQL.Impl.QueryImpl;
import serivice.ManagerService;
import serivice.StudentService;
import serivice.TeacherService;
import serivice.impl.ManagerServiceImpl;
import serivice.impl.StudentServiceImpl;
import serivice.impl.TeacherServiceImpl;

public class Main {
    public static void main(String[] args) {
        System.out.println("-----------------课外辅导管理系统启动----------------");
        System.out.println("--------------------请选择登录模式-------------------");
        System.out.println("1.学生登录");
        System.out.println("2.老师登录");
        System.out.println("3.管理员登录");
        System.out.println("0.退出");
        System.out.print("请输入序号:");
        int model = 0;
        Scanner input = new Scanner(System.in);
        do {
            model = input.nextInt();
            if (model < 0 || model > 3) {
                System.out.print("输入错误，请重新输入:");
            }
        } while (model < 0 || model > 3);
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
                break;
        }
    }

    static void studentLogin() {
        Query qy = new QueryImpl();
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("请输入学生Id");
            int studentId = input.nextInt();
            System.out.println("请输入密码");
            String password = input.next();
            if (qy.isExistStudent(studentId, password, true)) {
                System.out.println("登录成功");
                StudentService studentService = new StudentServiceImpl();
                studentService.run(studentId);
                break;
            } else {
                System.out.println("登录失败，用户Id或密码错误");
                System.out.println("请重新输入");
            }
        } while (true);
    }

    static void teacherLogin() {
        Query qy = new QueryImpl();
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("请输入老师Id");
            int teacherId = input.nextInt();
            System.out.println("请输入密码");
            String password = input.next();
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
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("请输入管理员Id");
            String managerId = input.next();
            System.out.println("请输入密码");
            String password = input.next();
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
