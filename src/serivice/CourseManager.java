/*
 * @Author: xv_rong
 * @Date: 2021-07-10 20:50:34
 * @LastEditors: xv_rong
 * @LastEditTime: 2021-07-10 21:18:36
 * @Description: CourseManager
 * @FilePath: \TCMS\src\serivice\CourseManager.java
 */
package serivice;

public interface CourseManager {
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
     * @description: setCoursePrice
     * @param none
     * @return none
     */
    void setCoursePrice();
}
