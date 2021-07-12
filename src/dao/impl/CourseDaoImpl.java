/*
 * @Author: xv_rong
 * @Date: 2021-07-09 20:08:50
 * @LastEditors: xv_rong
 * @LastEditTime: 2021-07-12 15:05:03
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

    @Override
    public int updateCourse(String sql, Object[] param) {
        int count = executeSQL(sql, param);
        return count;
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
                temp.setEdu((Education) rs.getObject(3));
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
