package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SellerApplicationManagementDB {
    public static List<List<String>> sellerApplicationList() {
        Statement s = null;
        ResultSet r = null;
        List<List<String>> arr = new ArrayList<>();
        String[] c = { "seller_num", "Customer_name", "seller_phone",
                "seller_registnum", "seller_appdate" };
        try {
            s = Database.con.createStatement();
            String sql = String.format("select * from Seller join Customer " +
                    "on seller_num = customer_num " +
                    "where seller_stat = '승인대기'");
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
                r.close();
                s.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return arr;
    }

    public static String[] sellerAppInfo(int num) {
        Statement s = null;
        ResultSet r = null;
        String[] arr = new String[6];
        String[] col = { "seller_name", "seller_represent", "seller_phone",
                "seller_email", "seller_registnum", "seller_appdate"};
        try {
            s = Database.con.createStatement();
            String sql = String.format("select * from Seller " +
                    "where seller_num = %d", num);
            r = s.executeQuery(sql);
            if(r.next()) {
                for (int i = 0; i < 6; i++) {
                    arr[i] = r.getString(col[i]);
                }
            }
            return arr;
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
        return arr;
    }

    public static String[] customerAppInfo(int num) {
        Statement s = null;
        ResultSet r = null;
        String[] arr = new String[6];
        String[] col = { "customer_num", "customer_name", "customer_birth",
                "customer_nick", "customer_email", "customer_date"};
        try {
            s = Database.con.createStatement();
            String sql = String.format("select * from Customer " +
                    "where customer_num = %d", num);
            r = s.executeQuery(sql);
            if(r.next()) {
                for (int i = 0; i < 6; i++) {
                    arr[i] = r.getString(col[i]);
                }
            }
            return arr;
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
        return arr;
    }

    public static boolean deleteApplication(int num) {
        Statement s = null;
        try {
            s = Database.con.createStatement();
            String sql = String.format("delete from Seller " +
                    "where seller_num = %d", num);
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

    public static boolean updatePassword(int num) {
        Statement s = null;
        try {
            s = Database.con.createStatement();
            String sql = String.format("update Seller set seller_stat = '승인완료' " +
                    "where seller_num = '%d'", num);
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
