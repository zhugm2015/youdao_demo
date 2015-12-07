package util;

import com.mysql.jdbc.Driver;

import java.sql.*;

/**
 * Created by BH00350 on 2015/12/7.
 */
public class DB {
    private static final String URL = "jdbc:mysql:///test";
    //private static final String URL = "jdbc:mysql://localhost:3306/test";     // URL指向要访问的数据库名    （静态变量引用，不需要实例化）
    private static final String USER = "root";          //MySQL配置时的用户名    ctrl + shif + u 大小写转换
    private static final String PASSWORD = "";          // MySQL配置时的密码

    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {      //ctrl + alt + t  补全
            try {
                new Driver();           //加载驱动程序  抛出异常：先不加分号，alt+enter，抛出后，再写分号
                connection=DriverManager.getConnection(URL,USER,PASSWORD); //连接数据库
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
    // statement用来执行SQL语句   resultSet结果集
    public static void close(ResultSet resultSet,PreparedStatement preparedStatement){
        if (resultSet != null) {
            try {
                resultSet.close();  //抛异常
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (preparedStatement!=null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
