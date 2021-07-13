/*
 * @Author: xv_rong
 * @Date: 2021-07-13 09:28:37
 * @LastEditors: xv_rong
 * @LastEditTime: 2021-07-13 14:20:14
 * @Description: 
 * @FilePath: \TCMS\src\dao\CourseDao.java
 */
package dao;

import java.util.ArrayList;

import entity.Course.Course;

public interface CourseDao {
    public int updateCourse(String sql, Object[] param);

    public ArrayList<Course> selectCourse(String sql, Object[] param);
}
