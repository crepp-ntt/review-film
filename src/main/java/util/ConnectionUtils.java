package util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import constant.Constant;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtils {
    private static  ComboPooledDataSource cpds = new ComboPooledDataSource();

    static {
        try {
            cpds.setDriverClass(Constant.DRIVE_NAME);
            cpds.setJdbcUrl(Constant.DB_URL);
            cpds.setUser(Constant.ID);
            cpds.setPassword(Constant.PASSWORD);
            cpds.setMinPoolSize(Constant.DB_MIN_CONNECTIONS);
            cpds.setInitialPoolSize(Constant.DB_MIN_CONNECTIONS);
            cpds.setMaxPoolSize(Constant.DB_MAX_CONNECTIONS);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }



    }
    public static Connection getConnection() throws SQLException {
        Connection conn =  cpds.getConnection();
        return conn;
    }


}
