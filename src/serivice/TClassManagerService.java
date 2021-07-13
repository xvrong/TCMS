/*
 * @Author: xv_rong
 * @Date: 2021-07-06 15:12:03
 * @LastEditors: xv_rong
 * @LastEditTime: 2021-07-13 14:41:52
 * @Description: TClassManagerService
 * @FilePath: \TCMS\src\serivice\TClassManagerService.java
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

public interface TClassManagerService {
    GetInput get = new GetInputImpl();
    Query qy = new QueryImpl();
    Print pt = new PrintImpl();
    Update up = new UpdateImpl();

    /**
     * @description: show all class
     * @param none
     * @return none
     */
    void showAllTClass();

    /**
     * @description: show all student infomation in a class, ID + name
     * @param none
     * @return none
     */
    void showCertainTClassStudent();

    /**
     * @description: show all teacher infomation in a class, ID + name
     * @param none
     * @return none
     */
    void showCertainTClassTeacher();

    /**
     * @description:add a class
     * @param none
     * @return none
     */
    void addTClass();

    /**
     * @description:delete a class
     * @param none
     * @return none
     */
    void deleteTClass();

    /**
     * @description:change teacher of a Class
     * @param none
     * @return none
     */
    void ChangeTeacher();

    /**
     * @description:delete a Student in a class
     * @param none
     * @return none
     */
    void deleteStudent();

    /**
     * @description:delete a Student in a class
     * @param none
     * @return none
     */
    void addStudent();

    /**
     * @description: run
     * @param none
     * @return none
     */
    void run();
}
