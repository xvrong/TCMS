/*
 * @Author: xv_rong
 * @Date: 2021-07-06 15:12:03
 * @LastEditors: xv_rong
 * @LastEditTime: 2021-07-10 21:31:56
 * @Description: TClassManagerService
 * @FilePath: \TCMS\src\serivice\TClassManagerService.java
 */
package serivice;

public interface TClassManagerService {
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
}
