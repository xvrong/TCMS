package dao;

import entity.Person.*;
import java.util.*;

public interface StudentDao {
    public int updateStudent(String sql, Object[] param);

    public List<Student> selectStudent(String sql, Object[] param);
}
