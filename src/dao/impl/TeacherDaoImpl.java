package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.TeacherDao;
import entity.Person.Teacher;

public class TeacherDaoImpl extends BaseDao implements TeacherDao {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    @Override
    public int updateTeacher(String sql, Object[] param) {
        int count = executeSQL(sql, param);
        return count;
    }

    @Override
    public List<Teacher> selectTeacher(String sql, Object[] param) {
        List<Teacher> teacherList = new ArrayList<Teacher>();
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
        return teacherList;
    }
}
