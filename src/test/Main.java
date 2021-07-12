package test;

import java.util.Scanner;

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

        }
    }
}
