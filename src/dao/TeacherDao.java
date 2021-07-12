package dao;

import java.util.ArrayList;

import entity.Person.Teacher;

public interface TeacherDao {
    public int updateTeacher(String sql, Object[] param);

    public ArrayList<Teacher> selectTeacher(String sql, Object[] param);
}
