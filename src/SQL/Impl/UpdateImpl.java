/*
 * @Author: xv_rong
 * @Date: Fri Jul 09 2021 23:47:31
 * @LastEditors: xv_rong
 * @LastEditTime: 2021-07-10 21:35:11
 * @Description: 
 * @FilePath: \TCMS\src\SQL\Impl\UpdateImpl.java
 */
package SQL.Impl;

import SQL.Update;
import entity.Course.Course;
import entity.Person.Student;
import entity.Person.Teacher;
import entity.TClass.TClass;

public class UpdateImpl implements Update {

    @Override
    public void addStudent(Student student) {
        // TODO Auto-generated method stub

    }

    @Override
    public Boolean deleteStudent(int studentId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Boolean deleteTaking(int studentId, int tClassId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void addTaking(Student studetn, TClass tClass) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addTeacher(Teacher teacher) {
        // TODO Auto-generated method stub

    }

    @Override
    public Boolean deleteTeacher(int teahcerId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setTeacherSalary(int teacherId, int salary) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addCourse(Course course) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean deleteCourse(int CourseId) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void setCoursePrice(int courseId, int salary) {
        // TODO Auto-generated method stub

    }

    @Override
    public void addTClass(TClass tClass) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean deleteTClass(int TClassId) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void setTeahcer(int TClassId, int TeacherId) {
        // TODO Auto-generated method stub

    }

}
