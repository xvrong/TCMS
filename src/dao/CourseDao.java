package dao;

import java.util.*;

import entity.Course.Course;
import entity.Course.Course.*;

public interface CourseDao {
    public int updateCourse(String sql, Object[] param);

    public ArrayList<Course> selectCourse(String sql, Object[] param);
}
