package dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 
 * 
 */

public class BaseDao {
    public static String DRIVER;
    public static String URL;
    public static String DBNAME;
    public static String DBPASSWROD;
    static {
        init();
    }

    public static void init() {
        Properties params = new Properties();
        String config = "datebase.properties";
        InputStream is = BaseDao.class.getClassLoader().getResourceAsStream(config);
        try {
            params.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        DRIVER = params.getProperty("driver");
        URL = params.getProperty("url");
        DBNAME = params.getProperty("user");
        DBPASSWROD = params.getProperty("password");
    }

    public Connection getConn() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, DBNAME, DBPASSWROD);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 释放资源
     * 
     * @param conn
     * @param pstmt
     * @param rs
     */
    public void closeAll(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 执行增删改
     * 
     * @param preparedSql
     * @param param
     * @return
     */
    public int executeSQL(String preparedSql, Object[] param) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int num = 0;
        try {
            conn = getConn();
            pstmt = conn.prepareStatement(preparedSql);
            if (param != null) {
                for (int i = 0; i < param.length; i++) {
                    pstmt.setObject(i + 1, param[1]);
                }
            }
            num = pstmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(conn, pstmt, null);
        }
        return num;
    }
    public int updateTaking(String sql, Object[] param) {
        return executeSQL(sql, param);
    }
}
