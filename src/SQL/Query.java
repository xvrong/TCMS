/*
 * @Author: xv_rong
 * @Date: Thu Jul 08 2021 21:16:12
 * @LastEditors: xv_rong
 * @LastEditTime: 2021-07-11 16:56:59
 * @Description: use Dao method to query datebase
 * @FilePath: \TCMS\src\SQL\Query.java
 */
package SQL;

import java.util.ArrayList;

import Tool.Education;
import entity.Course.Course;
import entity.Person.Student;
import entity.Person.Teacher;
import entity.TClass.TClass;

public interface Query {
    /**
     * @description: use edu to select course
     * @param {Education} edu
     * @param {boolean}   courseState
     * @return ArrayList<Course>
     */
    public ArrayList<Course> queryCourse(Education edu, boolean courseState);

    /**
     * @description: use edu course to select class
     * @param {int}     courseId
     * @param {boolean} tClassState
     * @return ArrayList<TClass>
     */
    public ArrayList<TClass> queryTClass(int courseId, boolean tClassState);

    /**
     * @description: use studentId to select class state = state
     * @param {int}     courseId
     * @param {boolean} tClassState
     * @return ArrayList<TClass>
     */
    public ArrayList<TClass> queryTClassByStudent(int studentId, boolean tClassState);

    /**
     * @description: use class to select student by class
     * @param {int}     tClassId
     * @param {boolean} studentState
     * @return ArrayList<Student>
     */
    public ArrayList<Student> queryStudent(int tClassId, boolean studentState);

    /**
     * @description: select student by class
     * @param {int}     tClassId
     * @param {boolean} teacherState
     * @return Teacher
     */
    public Teacher queryTeacher(int tClassId, boolean teacherState);

    /**
     * @description: select teacher state = state
     * @param {boolean} teacherState
     * @return ArrayList<Teacher>
     */
    public ArrayList<Teacher> queryTeacher(boolean teacherState);

    /**
     * @description: use teacherId to select student
     * @param {int} teacherId
     * @return ArrayList<Student>
     */
    public ArrayList<Student> queryStudentByTeacher(int teacherId, boolean studentState);

    /**
     * @description: use studentId to select student
     * @param {int} studentId
     * @return ArrayList<Student>
     */
    public Student queryStudentByStudentID(int studentId, boolean studentState);

    /**
     * @description: queryTClass where state = state
     * @param {boolean} state
     * @return ArrayList<TClass>
     */
    public ArrayList<TClass> queryTClass(boolean tClassState);

    /**
     * @description: If there is a Course exist
     * @param {Education} education
     * @param {String}    CourseName
     * @return boolean
     */
    public boolean IsExistCourse(Education education, String courseName, boolean courseState);

    /**
     * @description: queryTCourse is or not exist
     * @param {boolean} state
     * @return ArrayList<Course>
     */
    public ArrayList<Course> queryCourse(boolean CourseState);

    /**
     * @description: queryStudent where state = state
     * @param {boolean} state
     * @return ArrayList<Course>
     */
    public ArrayList<Student> queryStudent(boolean StudentState);

    /**
     * @description:If there is a Student exist
     * @param {int}     studentId
     * @param {boolean} state
     * @return boolean
     */
    public boolean IsExistStudent(int studentId, boolean state);

    /**
     * @description:If there is a Course exist
     * @param {int}     studentId
     * @param {boolean} state
     * @return boolean
     */
    public boolean IsExistCourse(int courseId, boolean state);

    /**
     * @description:If there is a Class exist
     * @param {int}     tClassId
     * @param {boolean} state
     * @return boolean
     */
    public boolean IsExistTClass(int tClassId, boolean state);

    /**
     * @description:If there is a Class exist
     * @param {int}     teacherId
     * @param {boolean} state
     * @return boolean
     */
    public boolean IsExistTeacher(int teacherId, boolean state);

    /**
     * @description: queryTClassByTClassId
     * @param {int}     tClassId
     * @param {boolean} state
     * @return TClass
     */
    public TClass queryTClassByTClassId(int tClassId, boolean state);

    /**
     * @description: queryTClass
     * @param {int}     courseId
     * @param {int}     StudentId
     * @param {boolean} state
     * @return TClass
     */
    public TClass queryTClass(int courseId, int StudentId, boolean state);

    /**
     * @description: queryTeacherByTeacherId
     * @param {int}     TeacherId
     * @param {boolean} state
     * @return TClass
     */
    public Teacher queryTeacherByTeacherId(int teacherId, boolean state);

    /**
     * @description: queryTeacherByTeacherId
     * @param {int}     teacherId
     * @param {boolean} state
     * @return TClass
     */
    public ArrayList<TClass> queryTClassByTeacherId(int teacherId, boolean stete);

}
