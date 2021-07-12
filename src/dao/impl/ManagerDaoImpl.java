/*
 * @Author: xv_rong
 * @Date: 2021-07-12 15:40:29
 * @LastEditors: xv_rong
 * @LastEditTime: 2021-07-12 15:47:11
 * @Description: 
 * @FilePath: \TCMS\src\dao\impl\ManagerDaoImpl.java
 */
package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.BaseDao;
import dao.ManagerDao;
import entity.Manager;

public class ManagerDaoImpl extends BaseDao implements ManagerDao {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    @Override
    public int updateManager(String sql, Object[] param) {
        int count = executeSQL(sql, param);
        return count;
    }

    @Override
    public ArrayList<Manager> selectManager(String sql, Object[] param) {
        ArrayList<Manager> managerList = new ArrayList<Manager>();
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
                Manager tmp = new Manager();
                tmp.setUsername(rs.getString(1));
                tmp.setPassword(rs.getString(2));
                managerList.add(tmp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            this.closeAll(conn, pstmt, rs);
        }
        return managerList;
    }
}
