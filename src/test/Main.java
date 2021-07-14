/*
 * @Author: xv_rong
 * @Date: 2021-07-12 10:53:28
 * @LastEditors: xv_rong
 * @LastEditTime: 2021-07-14 13:48:19
 * @Description: 
 * @FilePath: \TCMS\src\test\Main.java
 */
package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import SQL.Query;
import SQL.Impl.QueryImpl;
import dao.BaseDao;
import serivice.ManagerService;
import serivice.StudentService;
import serivice.TeacherService;
import serivice.impl.ManagerServiceImpl;
import serivice.impl.StudentServiceImpl;
import serivice.impl.TeacherServiceImpl;
import windows.impl.GetInputImpl;

public class Main {
    static GetInputImpl gt = new GetInputImpl();

    static {
        checkYear();
    }

    public static void main(String[] args) {
        System.out.println("-----------------课外辅导管理系统启动----------------");
        while (true) {
            System.out.println("--------------------请选择登录模式-------------------");
            System.out.println("1.学生登录");
            System.out.println("2.老师登录");
            System.out.println("3.管理员登录");
            System.out.println("4.模拟增加年份");
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
                case 4:
                    simulationAddYear();
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

    static void updateSystem(int systemYear, int year) {
        BaseDao bd = new BaseDao();
        Object[] tmp = new Object[1];
        tmp[0] = systemYear - year;
        bd.executeSQL("update class SET grade = grade + ? WHERE state = TRUE", tmp);
        bd.executeSQL("UPDATE class SET state=FALSE WHERE CASE education WHEN 0 THEN grade> 6 ELSE grade> 3 END", null);
        bd.executeSQL(
                "UPDATE taking SET state=FALSE WHERE taking.classID IN (SELECT classID FROM class WHERE state=FALSE)",
                null);
        bd.executeSQL(
                "UPDATE class SET grade=CASE WHEN education=0 AND grade> 6 THEN 6 WHEN (education=1 OR education=2) AND grade> 3 THEN 3 ELSE grade END",
                null);
        tmp[0] = systemYear;
        bd.executeSQL("insert into allyear VALUES(?)", tmp);
    }

    static void checkYear() {
        BaseDao bd = new BaseDao();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int year = 0;
        try {
            // 数据库上一次更新的时间
            String sql = "select max(yearId) from allyear where state = true";
            conn = bd.getConn();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                year = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            bd.closeAll(conn, pstmt, rs);
        }
        Calendar c1 = Calendar.getInstance();
        int systemYear = c1.get(Calendar.YEAR);
        if (systemYear > year) {
            updateSystem(systemYear, year);
        }
    }

    static void simulationAddYear() {
        BaseDao bd = new BaseDao();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int year = 0;
        try {
            String sql = "select max(yearId) from allyear where state = true";
            conn = bd.getConn();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                year = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            bd.closeAll(conn, pstmt, rs);
        }
        updateSystem(year + 1, year);
    }
}
