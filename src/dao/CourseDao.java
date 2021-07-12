package dao;

import entity.Course.*;
import java.util.*;

public interface CourseDao {
    public int updateCourse(String sql, Object[] param);

    public ArrayList<Course> selectCourse(String sql, Object[] param);
}
