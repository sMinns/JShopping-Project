package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public static Connection con;
    public static Connection makeConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이버 적재 성공");
            con = DriverManager.getConnection("jdbc:mysql://localhost/jshopping", "root", "1234");
            System.out.println("데이터베이스 연결 성공");
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버를 찾을 수 없습니다.");
        } catch (SQLException e) {
            System.out.println("연결에 실패하였습니다.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
