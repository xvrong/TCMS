/*
 * @Author: xv_rong
 * @Date: 2021-07-12 15:39:07
 * @LastEditors: xv_rong
 * @LastEditTime: 2021-07-12 15:42:56
 * @Description: 
 * @FilePath: \TCMS\src\dao\ManagerDao.java
 */
package dao;

import java.util.ArrayList;

import entity.Manager;

public interface ManagerDao {
    public int updateManager(String sql, Object[] param);

    public ArrayList<Manager> selectManager(String sql, Object[] param);
}
