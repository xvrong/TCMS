package dao;

import entity.Person.*;
import java.util.*;

public interface TeacherDao {
    public int updateTeacher(String sql, Object[] param);

    public List<Teacher> selectTeacher(String sql, Object[] param);
}
