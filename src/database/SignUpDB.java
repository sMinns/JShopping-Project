package database;

import system.Setup;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SignUpDB {
    public static boolean idDuplicateCheck(String id) {
        try {
            Statement s = Setup.con.createStatement();
            String sql = String.format("select count(*) from Customer " +
                    "where customer_id = '%s'", id);
            ResultSet r = s.executeQuery(sql);
            if (r.next()) {
                if(r.getInt(1) == 0) {
                    return true;
                }else {
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean insertCustomer(String[] customerInfo) {
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
            Statement s = Setup.con.createStatement();
            int i = s.executeUpdate(sql);
            if(i == 1)
                return true;
            else
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
