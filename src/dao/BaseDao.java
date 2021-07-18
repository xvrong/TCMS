package dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 
 * 
 */

public class BaseDao {
    public static String DRIVER;
    public static String URL;
    public static String DBNAME;
    public static String DBPASSWROD;
    public static ComboPooledDataSource ds = null;
    static {
        try {
            init();
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }

    public static void init() throws PropertyVetoException {
        Properties params = new Properties();
        ds = new ComboPooledDataSource(); // 建立连接池
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

        ds.setDriverClass(DRIVER);
        ds.setJdbcUrl(URL);
        ds.setUser(DBNAME);
        ds.setPassword(DBPASSWROD);
        ds.setMaxPoolSize(40);
        ds.setMinPoolSize(2);
        ds.setInitialPoolSize(2); // 初始连接池内连接数
        ds.setMaxStatements(50); // 设置连接池内最大的statement
    }

    public Connection getConn() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        try {
            conn = ds.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
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
                    pstmt.setObject(i + 1, param[i]);
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
