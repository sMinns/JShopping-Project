package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDB {
    public static int loginPwCheck(String id, String pw) {
        Statement s = null;
        ResultSet r = null;
        try {
            s = Database.con.createStatement();
            String sql = String.format("select customer_num from Customer " +
                    "where customer_id = '%s' " +
                    "AND customer_pw = '%s'", id, pw);
            r = s.executeQuery(sql);
            if (r.next()) {
                int n = r.getInt(1);
                return n;
            }else {
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                r.close();
                s.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public static String returnNickname(int num) {
        Statement s = null;
        ResultSet r = null;
        try {
            s = Database.con.createStatement();
            String sql = String.format("select customer_nick from Customer " +
                    "where customer_num = '%d'", num);
            r = s.executeQuery(sql);
            if (r.next()) {
                return r.getString(1);
            }else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                r.close();
                s.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static boolean sellerCheck(int num) {
        Statement s = null;
        ResultSet r = null;
        try {
            s = Database.con.createStatement();
            String sql = String.format("select seller_stat from Seller " +
                    "where seller_num = %d", num);
            r = s.executeQuery(sql);
            if (r.next()) {
                if (r.getString(1).equals("승인완료")) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                r.close();
                s.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
