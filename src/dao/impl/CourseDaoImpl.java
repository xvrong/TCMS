/*
 * @Author: xv_rong
 * @Date: 2021-07-09 20:08:50
 * @LastEditors: LinXuan
 * @LastEditTime: 2021-07-13 09:26:54
 * @Description: 
 * @FilePath: \TCMS\src\dao\impl\CourseDaoImpl.java
 */
package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Tool.Education;
import dao.BaseDao;
import dao.CourseDao;
import entity.Course.Course;

public class CourseDaoImpl extends BaseDao implements CourseDao {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    static Education[] invert = new Education[]{Education.PRIMARY, Education.JUNIOR, Education.HIGH};

    @Override
    public int updateCourse(String sql, Object[] param) {
        return executeSQL(sql, param);
    }

    @Override
    public ArrayList<Course> selectCourse(String sql, Object[] param) {
        ArrayList<Course> courseList = new ArrayList<Course>();
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
                Course temp = new Course();
                temp.setName(rs.getString(2));
                temp.setPrice(rs.getDouble(4));
                temp.setCourseId(rs.getInt(1));
                temp.setEdu(invert[rs.getInt(3)]);
                temp.setState(rs.getBoolean(5));
                courseList.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            this.closeAll(conn, pstmt, rs);
        }
        return courseList;
    }

}
