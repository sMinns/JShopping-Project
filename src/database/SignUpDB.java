package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SignUpDB {
    public static boolean idDuplicateCheck(String id) {
        Statement s = null;
        ResultSet r = null;
        try {
            s = Database.con.createStatement();
            String sql = String.format("select count(*) from Customer " +
                    "where customer_id = '%s'", id);
            r = s.executeQuery(sql);
            if (r.next()) {
                if(r.getInt(1) == 0) {
                    return true;
                }else {
                    return false;
                }
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
        return false;
    }

    public static boolean insertCustomer(String[] customerInfo) {
        Statement s = null;
        String sql;
        if(customerInfo[5].equals("user@jshopping.com")) {
            sql = String.format("insert into Customer (customer_id, customer_pw, customer_nick, " +
                            "customer_name, customer_birth, customer_date) values " +
                            "('%s', '%s', '%s', '%s', '%s', '%s')",
                    customerInfo[0], customerInfo[1], customerInfo[2], customerInfo[3],
                    customerInfo[4], customerInfo[6]);
        }else {
            sql = String.format("insert into Customer (customer_id, customer_pw, customer_nick, " +
                            "customer_name, customer_birth, customer_email, customer_date) values " +
                            "('%s', '%s', '%s', '%s', '%s', '%s', '%s')",
                    customerInfo[0], customerInfo[1], customerInfo[2], customerInfo[3],
                    customerInfo[4], customerInfo[5], customerInfo[6]);
        }
        try {
            s = Database.con.createStatement();
            int i = s.executeUpdate(sql);
            s.close();
            if(i == 1)
                return true;
            else
                return false;
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
