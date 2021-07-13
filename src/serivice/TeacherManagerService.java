/*
 * @Author: xv_rong
 * @Date: 2021-07-06 15:14:47
 * @LastEditors: xv_rong
 * @LastEditTime: 2021-07-13 14:42:02
 * @Description: Student Manager method
 * @FilePath: \TCMS\src\serivice\TeacherManagerService.java
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

public interface TeacherManagerService {
    GetInput get = new GetInputImpl();
    Query qy = new QueryImpl();
    Print pt = new PrintImpl();
    Update up = new UpdateImpl();

    /**
     * @description: show all teacher infomation, ID + name
     * @param none
     * @return none
     */
    void showAllTeacher();

    /**
     * @description: show all teacher infomation in a class, ID + name
     * @param none
     * @return none
     */
    void showCertainClassTeacher();

    /**
     * @description: show Teacher all fromation
     * @param none
     * @return none
     */
    void showCertainTeacher();

    /**
     * @description: show now class of certain teacher
     * @param none
     * @return none
     */
    void showTeacherNowClass();

    /**
     * @description: show history class of certain teacher
     * @param none
     * @return none
     */
    void showTeacherHistoryClass();

    /**
     * @description: add a teacher
     * @param none
     * @return none
     */
    void addTeacher();

    /**
     * @description: delete teacher
     * @param none
     * @return none
     */
    void deleteTeacher();

    /**
     * @description: setsalary
     * @param none
     * @return none
     */
    void setSalary();

    /**
     * @description: run
     * @param none
     * @return none
     */
    void run();
}
