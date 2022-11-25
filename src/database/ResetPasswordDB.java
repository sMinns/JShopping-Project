package database;

import java.sql.SQLException;
import java.sql.Statement;

public class ResetPasswordDB {
    public static boolean updatePassword(String pw, int num) {
        Statement s = null;
        try {
            s = Database.con.createStatement();
            String sql = String.format("update Customer set customer_pw = '%s' " +
                    "where customer_num = '%d'", pw, num);
            int i = s.executeUpdate(sql);
            if(i == 1) {
                return true;
            }else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                s.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
