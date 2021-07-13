/*
 * @Author: xv_rong
 * @Date: 2021-07-12 16:21:58
 * @LastEditors: LinXuan
 * @LastEditTime: 2021-07-13 12:17:05
 * @Description: 
 * @FilePath: \TCMS\src\serivice\impl\ManagerServiceImpl.java
 */
package serivice.impl;

import java.util.Scanner;

import serivice.ManagerService;

public class ManagerServiceImpl implements ManagerService {

    @Override
    public void run() {
        System.out.println("-----------------管理员模式启动----------------");
        int model = -1;
        while (model != 0) {
            System.out.println("1.学生管理");
            System.out.println("2.老师管理");
            System.out.println("3.班级管理");
            System.out.println("4.课程管理");
            System.out.println("0.退出");
            System.out.print("请输入序号:");
            Scanner input = new Scanner(System.in);
            do {
                model = input.nextInt();
                if (model < 0 || model > 4) {
                    System.out.print("输入错误!");
                }
            } while (model < 0 || model > 4);
            switch (model) {
                case 1:
                    studentManager.run();
                    break;
                case 2:
                    teacherManager.run();
                    break;
                case 3:
                    tClassManager.run();
                    break;
                case 4:
                    courseManager.run();
                    break;
                default:
                    break;
            }
        }
    }
}