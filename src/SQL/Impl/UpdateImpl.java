/*
 * @Author: xv_rong
 * @Date: Fri Jul 09 2021 23:47:31
 * @LastEditors: LinXuan
 * @LastEditTime: 2021-07-12 17:00:10
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
    public boolean deleteTaking(int studentId, int tClassId) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addTaking(int studentId, int tClassId) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addTeacher(Teacher teacher, String password) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean deleteTeacher(int teahcerId) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addCourse(Course course) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean deleteCourse(int CourseId) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addTClass(TClass tClass) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean deleteTClass(int TClassId) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean setTeahcer(int TClassId, int TeacherId) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addStudent(Student student, String password) {
        // TODO Auto-generated method stub
        String sql="insert into student\n" + "values(?,?,?,?,?,?,?)";
        Object arr[]=new Object[7];
        // arr[0] ;
        return false;
    }

    @Override
    public boolean deleteStudent(int studentId) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean setTeacherSalary(int teacherId, double salary) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean setCoursePrice(int courseId, double Price) {
        // TODO Auto-generated method stub
        return false;
    }

}
