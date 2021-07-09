package dao.impl;

import dao.BaseDao;
import dao.StudentDao;
import entity.Person.Student;
import java.sql.*;
import java.util.*;

public class StudentDaoImpl extends BaseDao implements StudentDao {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    @Override
    public int updateStudent(String sql, Object[] param) {
        int count = executeSQL(sql, param);
        return count;
    }

    @Override
    public List<Student> selectStudent(String sql, Object[] param) {
        List<Student> studentList = new ArrayList<Student>();
        try {
            conn = getConn();
            pstmt = conn.prepareStatement(sql);
            if (param != null) {
                for (int i = 0; i < param.length; i++) {
                    pstmt.setObject(i + 1, param[i]);
                }
            }
            rs = pstmt.executeQuery();
            while (rs.next()) {
                // TODO receive data
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            this.closeAll(conn, pstmt, rs);
        }
        return studentList;
    }
}
