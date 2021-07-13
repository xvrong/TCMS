/*
 * @Author: xv_rong
 * @Date: 2021-07-10 20:50:34
 * @LastEditors: xv_rong
 * @LastEditTime: 2021-07-13 14:40:36
 * @Description: CourseManager
 * @FilePath: \TCMS\src\serivice\CourseManagerService.java
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

public interface CourseManagerService {
    GetInput get = new GetInputImpl();
    Query qy = new QueryImpl();
    Print pt = new PrintImpl();
    Update up = new UpdateImpl();

    /**
     * @description: showAllCourse
     * @param none
     * @return none
     */
    void showAllTCourse();

    /**
     * @description: show all class in a certain Course
     * @param none
     * @return none
     */
    void showAllTClassCertainCourse();

    /**
     * @description: add a Course
     * @param none
     * @return none
     */
    void addCourse();

    /**
     * @description: add a Course
     * @param none
     * @return none
     */
    void deleteCourse();

    /**
     * @description: setCoursePrice
     * @param none
     * @return none
     */
    void setCoursePrice();

    /**
     * @description: run
     * @param none
     * @return none
     */
    void run();
}
