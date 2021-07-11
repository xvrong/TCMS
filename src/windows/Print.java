/*
 * @Author: xv_rong
 * @Date: Thu Jul 08 2021 20:40:06
 * @LastEditors: xv_rong
 * @LastEditTime: 2021-07-11 11:53:54
 * @Description: All print method
 * @FilePath: \TCMS\src\windows\Print.java
 */

package windows;

import java.util.ArrayList;

import entity.Person.Student;
import entity.Person.Teacher;

public interface Print {
    /**
     * @description: print Student basic informathion, No.+ Id + name
     * @param {ArrayList<Student>} studentList
     * @return none
     */
    public void printStudentBasicInfomation(ArrayList<Student> studentList);

    /**
     * @description: print Student basic informathion, No.+ Id + name
     * @param {ArrayList<Teacher>} TeacherList
     * @return none
     */
    public void printTeacherBasicInfomation(ArrayList<Teacher> TeacherList);

    /**
     * @description: print Course basic information No.+ education + name
     * @param {ArrayList<String>} cousrseList
     * @return none
     */
    public void printCourseBasicInfomation(ArrayList<String> cousrseList);

    /**
     * @description:print class basic information No.+ year + education + course +
     *                    num
     * @param {ArrayList<String>} classList
     * @return none
     */
    public void printTClassBasicInfomation(ArrayList<String> tClassList);

    /**
     * @description:print Student all information No. + Id + name + sex + education
     *                    + birthday + age
     * @param {ArrayList<Student>} studentList
     * @return none
     */
    public void printStudentAllInformation(ArrayList<Student> studentList);

    /**
     * @description:print Teacher all information No.+ Id + name + sex + birthday +
     *                    age + salary
     * @param {ArrayList<Teacher>} teacherList
     * @return none
     */
    public void printTeacherAllInformation(ArrayList<Teacher> teacherList);
}