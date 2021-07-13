/*
 * @Author: LinXuan
 * @Date: 2021-07-12 16:58:57
 * @Description: 
 * @LastEditors: xv_rong
 * @LastEditTime: 2021-07-13 14:42:20
 * @FilePath: \TCMS\src\serivice\TeacherService.java
 */
package serivice;

import SQL.Query;
import SQL.Update;
import SQL.Impl.QueryImpl;
import SQL.Impl.UpdateImpl;
import windows.GetInput;
import windows.Print;
import windows.impl.GetInputImpl;
import windows.impl.PrintImpl;

public interface TeacherService {
    GetInput get = new GetInputImpl();
    Query qy = new QueryImpl();
    Print pt = new PrintImpl();
    Update up = new UpdateImpl();

    /**
     * @description: show personal information
     * @param {*}
     * @return {*}
     */
    public void showPersonalInfo();

    /**
     * @description: show teaching class now
     * @param {*}
     * @return {*}
     */
    public void showTeachingClass();

    /**
     * @description: 查询所教授的所有学生
     * @param {*}
     * @return {*}
     */
    public void searchTeachingStudent();

    /**
     * @description: 展示所有交过的班级基本信息
     * @param {*}
     * @return {*}
     */
    public void showHistoryTeachingClass();

    /**
     * @description: 查询自己某个学生的信息(只能查询自己正在教授的学生的信息)
     * @param {int} studentID
     * @return {*}
     */
    public void searchTeachingStudentInfo();

    /**
     * @description: 教师服务的程序入口
     * @param {*}
     * @return {*}
     */
    public void run(int TeacherID);

}