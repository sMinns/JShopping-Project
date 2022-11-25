package database;

import system.Setup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public static Connection con;
    public static Connection makeConnection() {
        Connection con = null;
        try {
            Class.forName(Setup.foP7wX0hEKw("ij+ggejVu5V1ruMDivbqD0KXrPueLpxPfpxk0pguefg="));
            System.out.println("드라이버 적재 성공");
            con = DriverManager.getConnection(Setup.foP7wX0hEKw("U08ug63CSejIEXAKA6LSf5C/zK4l9eLcM/WYg9nlBpep2g53GYW6BMzAlqmv1fcx"),
                    Setup.foP7wX0hEKw("ONub+h2w+E+NvRlL/p7wKA=="), Setup.foP7wX0hEKw("d/ImdnWl9rRNnyLWrJN+Bg=="));
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
