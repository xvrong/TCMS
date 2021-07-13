/*
 * @Author: xv_rong
 * @Date: 2021-07-09 19:48:10
 * @LastEditors: LinXuan
 * @LastEditTime: 2021-07-13 09:27:13
 * @Description: 
 * @FilePath: \TCMS\src\dao\impl\StudentDaoImpl.java
 */
package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import Tool.Education;
import dao.BaseDao;
import dao.StudentDao;
import entity.Person.Student;
import Tool.calAge;

public class StudentDaoImpl extends BaseDao implements StudentDao {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    Education[] invert = new Education[] { Education.PRIMARY, Education.JUNIOR, Education.HIGH };

    @Override
    public int updateStudent(String sql, Object[] param) {
        return executeSQL(sql, param);
    }

    @Override
    public ArrayList<Student> selectStudent(String sql, Object[] param) {
        ArrayList<Student> studentList = new ArrayList<Student>();
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
                Student temp = new Student();
                temp.setName(rs.getString(2));
                temp.setSex(rs.getString(5));
                // temp.setAge(rs.getInt(3));

                // temp.setAge();
                temp.setBirthday(rs.getString(4));
                temp.setStudentID(rs.getInt(1));
                temp.setEdu(invert[rs.getInt(3)]);
                temp.setState(rs.getBoolean(6));
                temp.setAge(calAge.getAge(temp.getBirthday()));
                studentList.add(temp);
            }
        } catch (SQLException | ParseException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            this.closeAll(conn, pstmt, rs);
        }
        return studentList;
    }
}
