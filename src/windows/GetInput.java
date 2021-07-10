/*
 * @Author: xv_rong
 * @Date: 2021-07-08 20:45:56
 * @LastEditors: xv_rong
 * @LastEditTime: 2021-07-10 21:02:08
 * @Description: 
 * @FilePath: \TCMS\src\windows\GetInput.java
 */
package windows;

import java.util.ArrayList;

import Tool.Education;
import entity.Course.Course;
import entity.TClass.TClass;

public interface GetInput {
    /**
     * @description: print 1.小学 2.初中 3.高中 then get user input Education by no, check
     *               input, until input right num, provid a method to input -1 to
     *               back to menu without right input(return -1)
     * @param none
     * @return Education
     */
    public Education getInputEducation();

    /**
     * @description: use method printCourseBasicList then get user input Education
     *               by num, check input, until input right num, provid a method to
     *               input -1 to back to menu without right input(return -1)
     * @param none
     * @return courseId
     */
    public int getInputCourse(ArrayList<Course> courseList);

    /**
     * @description: use method printTClassBasicInformation then get user input
     *               Education by num, check input, until input right num, provid a
     *               method to input -1 to back to menu without right input(return
     *               -1)
     * @param none
     * @return courseId
     */

    public int getInputClass(ArrayList<TClass> classList);

    /**
     * @description: use method printTeacherBasicInformationthen get user input
     *               Education by num, check input, until input right num, provid a
     *               method to input -1 to back to menu without right input(return
     *               -1)
     * @param none
     * @return classId
     */
    public int getInputTeacher();

    /**
     * @description: get studentName, check input, until input right name, provid a
     *               method to input -1 to back to menu without right input(return
     *               -1)
     * @param none
     * @return id
     */
    public String getInputName();

    /**
     * @description: get birthday, check input, until input right birthday
     *               yyyy-mm-dd, provid a method to input -1 to back to menu without
     *               right input(return null)
     * @param none
     * @return name
     */

    public String getInputBirthday();

    /**
     * @description: get sex, check input, until input right birthday, provid a
     *               method to input -1 to back to menu without right input(return
     *               null)
     * @param none
     * @returnsex
     */
    public String getInputSex();

    /**
     * @description: get Id, check input > 0, until input right Id, provid a method
     *               to input -1 to back to menu without right input(return -1)
     * @param none
     * @return id
     */
    public int getInputId();

    /**
     * @description: get yeaer, check input > 0, until input right year, provid a
     *               method to input -1 to back to menu without right input(return
     *               -1)
     * @param none
     * @return year
     */
    public int getInputYear();

    /**
     * @description: get salary, check input > 0, until input right salary, provid a
     *               method to input -1 to back to menu without right input(return
     *               -1)
     * @param none
     * @return salary
     */
    public int getInputSalary();

    /**
     * @description: get Password
     * @param none
     * @return password
     */
    public int getInputPassword();

    /**
     * @description: get CourseName, consider exixs same name Course in database
     * @param none
     * @return courseName
     */
    public String getInputCourseName(Education education);

}