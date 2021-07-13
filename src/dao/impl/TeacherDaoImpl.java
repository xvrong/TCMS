/*
 * @Author: xv_rong
 * @Date: 2021-07-09 20:01:38
 * @LastEditors: xv_rong
 * @LastEditTime: 2021-07-13 14:20:21
 * @Description: 
 * @FilePath: \TCMS\src\dao\impl\TeacherDaoImpl.java
 */
package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import Tool.calAge;
import dao.BaseDao;
import dao.TeacherDao;
import entity.Person.Teacher;

public class TeacherDaoImpl extends BaseDao implements TeacherDao {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    @Override
    public int updateTeacher(String sql, Object[] param) {
        return executeSQL(sql, param);
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
                temp.setName(rs.getString(2));
                temp.setSex(rs.getString(5));
                temp.setBirthday(rs.getString(6));
                temp.setTeacherID(rs.getInt(1));
                temp.setSalary(rs.getDouble(3));
                temp.setState(rs.getBoolean(4));
                temp.setAge(calAge.getAge(temp.getBirthday()));
                teacherList.add(temp);
            }
        } catch (SQLException | ClassNotFoundException | ParseException e) {
            e.printStackTrace();
        } finally {
            this.closeAll(conn, pstmt, rs);
        }
        return teacherList;
    }
}
