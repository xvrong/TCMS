/*
 * @Author: xv_rong
 * @Date: 2021-07-09 19:24:31
 * @LastEditors: xv_rong
 * @LastEditTime: 2021-07-12 15:03:30
 * @Description: 
 * @FilePath: \TCMS\src\dao\StudentDao.java
 */
package dao;

import java.util.ArrayList;

import entity.Person.Student;

public interface StudentDao {
    public int updateStudent(String sql, Object[] param);

    public ArrayList<Student> selectStudent(String sql, Object[] param);
}
