/*
 * @Author: xv_rong
 * @Date: 2021-07-10 20:50:34
 * @LastEditors: xv_rong
 * @LastEditTime: 2021-07-12 16:30:28
 * @Description: CourseManager
 * @FilePath: \TCMS\src\serivice\CourseManagerService.java
 */
package serivice;

public interface CourseManagerService {
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
