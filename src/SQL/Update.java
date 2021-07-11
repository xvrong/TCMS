/*
 * @Author: xv_rong
 * @Date: 2021-07-09 23:01:40
 * @LastEditors: xv_rong
 * @LastEditTime: 2021-07-11 12:31:06
 * @Description: use Dao method to Update DateBase
 * @FilePath: \TCMS\src\SQL\Update.java
 */
package SQL;

import entity.Course.Course;
import entity.Person.Student;
import entity.Person.Teacher;
import entity.TClass.TClass;

public interface Update {

    /**
     * @description: delete a taking item
     * @param {int} studentId
     * @param {int} tClassId
     * @return boolean if can't delete return false
     */
    Boolean deleteTaking(int studentId, int tClassId);

    /**
     * @description: add a taking item
     * @param {Student} studetn
     * @param {TClass}  tClass
     * @return none
     */
    void addTaking(Student studetn, TClass tClass);

    /**
     * @description: add a Teacher
     * @param {Teacher} teacher
     * @return void
     */
    void addTeacher(Teacher teacher, String password);

    /**
     * @description: delete a teacher if it has no class
     * @param {int} teacherId
     * @return boolean if can't delete return false
     */
    Boolean deleteTeacher(int teahcerId);

    /**
     * @description: set a teacher salary
     * @param {int} teacherId
     * @param {int} salary
     * @return none
     */
    void setTeacherSalary(int teacherId, int salary);

    /**
     * @description: add a Course
     * @param {Course} course
     * @return none
     */
    void addCourse(Course course);

    /**
     * @description: deleteCourse if there is no class of it.
     * @param {int} CourseId
     * @return boolean
     */
    boolean deleteCourse(int CourseId);

    /**
     * @description: setCoursePrice
     * @param {int} courseId
     * @param {int} salary
     * @return none
     */
    void setCoursePrice(int courseId, int salary);

    /**
     * @description: add a Class
     * @param {TClass} tClass
     * @return {*}
     */
    void addTClass(TClass tClass);

    /**
     * @description: delete class if there is no student of it.
     * @param {int} TClassId
     * @return boolean
     */
    boolean deleteTClass(int TClassId);

    /**
     * @description: set teacher of a class
     * @param {int} TClassId
     * @param {int} TeacherId
     * @return none
     */
    void setTeahcer(int TClassId, int TeacherId);

    /**
     * @description: add a Student if the num of student not over the maxnum, class
     *               num + 1,
     * @param {Student} student
     * @return none
     */
    void addStudent(Student student, String password);

    /**
     * @description: delete a Student , class num - 1
     * @param {int} student
     * @return boolean if can't delete return false
     */
    Boolean deleteStudent(int studentId);
}
