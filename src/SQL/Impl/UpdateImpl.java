/*
 * @Author: xv_rong
 * @Date: Fri Jul 09 2021 23:47:31
 * @LastEditors: xv_rong
 * @LastEditTime: 2021-07-13 17:58:14
 * @Description: 
 * @FilePath: \TCMS\src\SQL\Impl\UpdateImpl.java
 */
package SQL.Impl;

import SQL.Update;
import dao.BaseDao;
import dao.impl.CourseDaoImpl;
import dao.impl.StudentDaoImpl;
import dao.impl.TClassDaoImpl;
import dao.impl.TeacherDaoImpl;
import entity.Course.Course;
import entity.Person.Student;
import entity.Person.Teacher;
import entity.TClass.TClass;

public class UpdateImpl implements Update {

    @Override
    public boolean deleteTaking(int studentId, int tClassId) {
        BaseDao tmp = new BaseDao();
        String sql = "update taking set state=false where studentID=? and classID=? and state=true";
        Object arr[] = new Object[2];
        arr[0] = studentId;
        arr[1] = tClassId;
        Object brr[] = new Object[1];
        brr[0] = arr[1];
        if (tmp.updateTaking(sql, arr) > 0) {
            String sql2 = "update class set studentnum=studentnum-1 where classID=?";
            new TClassDaoImpl().updateTClass(sql2, brr);
            return true;
        } else
            return false;
    }

    @Override
    public boolean addTaking(int studentId, int tClassId) {
        BaseDao tmp = new BaseDao();
        String sql = "insert into taking values(0,?,?,true)";
        Object arr[] = new Object[2];
        arr[0] = tClassId;
        arr[1] = studentId;
        if (tmp.updateTaking(sql, arr) > 0) {
            Object brr[] = new Object[1];
            brr[0] = arr[0];
            String sql2 = "update class set studentnum=studentnum+1 where classID=?";
            new TClassDaoImpl().updateTClass(sql2, brr);
            return true;
        } else
            return false;
    }

    @Override
    public boolean addTeacher(Teacher teacher, String password) {
        String sql = "insert into teacher values(?,?,?,?,?,?,?)";
        Object arr[] = new Object[7];
        arr[0] = teacher.getTeacherID();
        arr[1] = teacher.getBirthday();
        arr[2] = teacher.getName();
        arr[3] = teacher.getSex();
        arr[4] = teacher.getSalary();
        arr[5] = teacher.getClass();
        arr[6] = password;
        TeacherDaoImpl tmp = new TeacherDaoImpl();
        if (tmp.updateTeacher(sql, arr) > 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean deleteTeacher(int teahcerId) {
        String sql = "update teacher set state=false where teacherID=?";
        QueryImpl a = new QueryImpl();
        if (!a.IsExistTeacher(teahcerId, true) || a.queryTClassByTeacherId(teahcerId, true).isEmpty() != true)
            return false;
        Object arr[] = new Object[1];
        arr[0] = teahcerId;
        TeacherDaoImpl tmp = new TeacherDaoImpl();
        if (tmp.updateTeacher(sql, arr) > 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean addCourse(Course course) {
        String sql = "insert into course values(?,?,?,?,?)";
        Object arr[] = new Object[5];
        arr[0] = course.getCourseId();
        arr[1] = course.getName();
        arr[2] = course.getEdu().ordinal();
        arr[3] = course.getPrice();
        arr[4] = course.isState();
        CourseDaoImpl tmp = new CourseDaoImpl();
        if (tmp.updateCourse(sql, arr) > 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean deleteCourse(int CourseId) {
        String sql = "update course set state=false where courseID=?";
        QueryImpl a = new QueryImpl();
        if (!a.IsExistCourse(CourseId, true) || !a.queryTClass(CourseId, true).isEmpty())
            return false;
        Object arr[] = new Object[1];
        arr[0] = CourseId;
        CourseDaoImpl tmp = new CourseDaoImpl();
        if (tmp.updateCourse(sql, arr) > 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean addTClass(TClass tClass) {
        String sql = "insert into class values(?,?,?,?,?,?,?,?,?,?)";
        Object arr[] = new Object[10];
        arr[0] = tClass.getClassID();
        arr[1] = tClass.getCourseID();
        arr[2] = tClass.getTeacherID();
        arr[3] = tClass.getStudentNum();
        arr[4] = tClass.getEducation().ordinal();
        arr[5] = tClass.getGrade();
        arr[6] = tClass.getStartYear();
        arr[7] = tClass.isState();
        arr[8] = tClass.getOrderNumber();
        arr[9] = tClass.getMaxStudentNum();
        CourseDaoImpl tmp = new CourseDaoImpl();
        if (tmp.updateCourse(sql, arr) > 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean deleteTClass(int TClassId) {
        String sql = "update class set state=false where classID=?";
        QueryImpl a = new QueryImpl();
        if (!a.IsExistTClass(TClassId, true) || !a.queryStudent(TClassId, true).isEmpty())
            return false;
        Object arr[] = new Object[1];
        arr[0] = TClassId;
        TeacherDaoImpl tmp = new TeacherDaoImpl();
        if (tmp.updateTeacher(sql, arr) > 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean setTeahcer(int TClassId, int TeacherId) {
        String sql = "update class set teacherID=? where classID=?";
        Object[] arr = new Object[2];
        arr[0] = TeacherId;
        arr[1] = TClassId;
        TClassDaoImpl tmp = new TClassDaoImpl();
        if (tmp.updateTClass(sql, arr) > 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean addStudent(Student student, String password) {
        String sql = "insert into student values(?,?,?,?,?,?,?)";
        Object arr[] = new Object[7];
        arr[0] = student.getStudentID();
        arr[1] = student.getName();
        arr[2] = student.getEdu().ordinal();
        arr[3] = student.getBirthday();
        arr[4] = student.getSex();
        arr[5] = student.isState();
        arr[6] = password;
        StudentDaoImpl tmp = new StudentDaoImpl();
        if (tmp.updateStudent(sql, arr) > 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean deleteStudent(int studentId) {
        String sql = "update student set state=false where studentID=?";
        QueryImpl a = new QueryImpl();
        if (!a.IsExistStudent(studentId, true) || !a.queryTClassByStudent(studentId, true).isEmpty())
            return false;
        Object arr[] = new Object[1];
        arr[0] = studentId;
        StudentDaoImpl tmp = new StudentDaoImpl();
        if (tmp.updateStudent(sql, arr) > 0) {
            return true;
        } else
            return false;
    }

    @Override
    public boolean setTeacherSalary(int teacherId, double salary) {
        String sql = "update teacher set salary=? where teacherID=?";
        Object[] arr = new Object[2];
        arr[0] = salary;
        arr[1] = teacherId;
        TeacherDaoImpl tmp = new TeacherDaoImpl();
        if (tmp.updateTeacher(sql, arr) > 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean setCoursePrice(int courseId, double Price) {
        String sql = "update course set price=? where courseID=?";
        Object[] arr = new Object[2];
        arr[0] = Price;
        arr[1] = courseId;
        CourseDaoImpl tmp = new CourseDaoImpl();
        if (tmp.updateCourse(sql, arr) > 0)
            return true;
        else
            return false;
    }

}
