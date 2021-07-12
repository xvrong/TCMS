/*
 * @Author: xv_rong
 * @Date: 2021-07-09 20:06:45
 * @LastEditors: xv_rong
 * @LastEditTime: 2021-07-12 15:04:22
 * @Description: 
 * @FilePath: \TCMS\src\dao\impl\TClassDaoImpl.java
 */
package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Tool.Education;
import dao.BaseDao;
import dao.TClassDao;
import entity.TClass.TClass;

public class TClassDaoImpl extends BaseDao implements TClassDao {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    @Override
    public int updateTClass(String sql, Object[] param) {
        int count = executeSQL(sql, param);
        return count;
    }

    @Override
    public ArrayList<TClass> selectTClass(String sql, Object[] param) {
        ArrayList<TClass> tClassList = new ArrayList<TClass>();
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
                TClass temp = new TClass();
                temp.setClassID(rs.getInt(1));
                temp.setCourseID(rs.getInt(2));
                temp.setTeacherID(rs.getInt(3));
                temp.setStudentNum(rs.getInt(4));
                // TODO: int convert to Education
                temp.setEducation((Education) rs.getObject(5));
                temp.setGrade(rs.getInt(6));
                temp.setStartYear(rs.getInt(7));
                temp.setOrderNumber(rs.getInt(8));
                temp.setMaxStudentNum(rs.getInt(9));
                temp.setState(rs.getBoolean(10));
                tClassList.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            this.closeAll(conn, pstmt, rs);
        }
        return tClassList;
    }

}
