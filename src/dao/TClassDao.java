/*
 * @Author: xv_rong
 * @Date: 2021-07-09 19:30:10
 * @LastEditors: xv_rong
 * @LastEditTime: 2021-07-12 15:05:19
 * @Description: 
 * @FilePath: \TCMS\src\dao\TClassDao.java
 */
package dao;

import java.util.ArrayList;

import entity.TClass.TClass;

public interface TClassDao {
    public int updateTClass(String sql, Object[] param);

    public ArrayList<TClass> selectTClass(String sql, Object[] param);
}
