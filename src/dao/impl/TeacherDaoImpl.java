/*
 * @Author: xv_rong
 * @Date: 2021-07-09 20:01:38
 * @LastEditors: xv_rong
 * @LastEditTime: 2021-07-12 15:05:11
 * @Description: 
 * @FilePath: \TCMS\src\dao\impl\TeacherDaoImpl.java
 */
package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
    public ArrayList<Teacher> selectTeacher(String sql, Object[] param) {
        ArrayList<Teacher> teacherList = new ArrayList<Teacher>();
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
                Teacher temp = new Teacher();
                temp.setName(rs.getString(1));
                temp.setSex(rs.getString(2));
                // TODO: Teacher age
                temp.setAge(rs.getInt(3));
                temp.setBirthday(rs.getString(4));
                temp.setTeacherID(rs.getInt(5));
                temp.setSalary(rs.getDouble(6));
                temp.setState(rs.getBoolean(7));
                teacherList.add(temp);
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
