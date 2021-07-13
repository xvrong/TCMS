/*
 * @Author: xv_rong
 * @Date: 2021-07-12 16:13:06
 * @LastEditors: xv_rong
 * @LastEditTime: 2021-07-13 14:41:41
 * @Description: 
 * @FilePath: \TCMS\src\serivice\StudentService.java
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

public interface StudentService {
    GetInput get = new GetInputImpl();
    Query qy = new QueryImpl();
    Print pt = new PrintImpl();
    Update up = new UpdateImpl();

    /**
     * @description: show student's personal info
     * @param {*}
     * @return {*}
     */
    public void showPersonalInfo();

    /**
     * @description: show this student's all class now
     * @param {*}
     * @return {*}
     */
    public void showPersonalTClass();

    /**
     * @description: show this student's all history class
     * @param {*}
     * @return {*}
     */
    public void showHistoryTClass();

    /**
     * @description: select new class
     * @param {*}
     * @return {*}
     */
    public void selectCourse();

    /**
     * @description: start student service
     * @param {*}
     * @return {*}
     */
    public void run(int studentID);
}
