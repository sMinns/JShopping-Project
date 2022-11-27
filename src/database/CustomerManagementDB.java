package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerManagementDB {
    public static List<List<String>> customerList(String str) {
        Statement s = null;
        ResultSet r = null;
        List<List<String>> arr = new ArrayList<>();
        String[] c = { "customer_num", "customer_id", "customer_nick",
                "customer_name", "customer_birth", "customer_email", "customer_date" };
        try {
            s = Database.con.createStatement();
            String sql = "select * from Customer where customer_num like '%" + str + "%' or " +
                    "customer_id like '%" + str + "%' or " +
                    "customer_name like '%" + str + "%'";
            r = s.executeQuery(sql);
            while (r.next()) {
                List<String> arrRowItems = new ArrayList<>();
                for(String col : c) {
                    arrRowItems.add(r.getString(col));
                }
                arr.add(arrRowItems);
            }
            return arr;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(r != null)
                    r.close();
                s.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return arr;
    }

    public static boolean deleteCustomer(int num) {
        Statement s = null;
        try {
            s = Database.con.createStatement();
            String sql = String.format("delete from Customer " +
                    "where customer_num = %d", num);
            int i = s.executeUpdate(sql);
            s.close();
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
