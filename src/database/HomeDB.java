package database;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HomeDB {
    public static List<Integer> homeProductList(int canum) {
        Statement s = null;
        ResultSet r = null;
        List<Integer> arr = new ArrayList<>();
        try {
            s = Database.con.createStatement();
            String sql = String.format("SELECT product_num, COUNT(orpd_count) FROM Product LEFT OUTER JOIN OrderProduct " +
                    "ON orpd_prnum = product_num " +
                    "WHERE product_canum = %d AND " +
                    "product_stat = '판매중' AND " +
                    "product_stock > 0 " +
                    "GROUP BY product_num " +
                    "Order BY COUNT(orpd_count) DESC LIMIT 6", canum);
            r = s.executeQuery(sql);
            for (int i = 0; i < 6; i++) {
                if (r.next()) {
                    arr.add(r.getInt("product_num"));
                } else {
                    arr.add(0);
                }
            }
            return arr;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (r != null)
                    r.close();
                s.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return arr;
    }

    public static String returnHomeProductName(int prnum) {
        Statement s = null;
        ResultSet r = null;
        String list = "";
        try {
            s = Database.con.createStatement();
            String sql = String.format("SELECT product_name from Product " +
                            "where product_num = %d", prnum);
            r = s.executeQuery(sql);
            if (r.next()) {
                return r.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (r != null)
                    r.close();
                s.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static byte[] productImageLoad(int prnum) {
        Statement s = null;
        ResultSet r = null;
        try {
            s = Database.con.createStatement();
            String sql = String.format("select product_image from Product " +
                    "where product_num = %d", prnum);
            r = s.executeQuery(sql);
            if (r.next()) {
                Blob blob = r.getBlob(1);
                byte[] data = blob.getBytes(1L, (int) blob.length());
                return data;
            }
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
        return null;
    }

    public static List<Integer> homeStatistics(int canum) {
        Statement s = null;
        ResultSet r = null;
        List<Integer> arr = new ArrayList<>();
        try {
            s = Database.con.createStatement();
            String sql = String.format("SELECT FLOOR(CEILING((TO_DAYS(NOW()) - (TO_DAYS(customer_birth))) / 365) / 10) * 10 AS age, " +
                    "COUNT(orpd_count) FROM Product LEFT OUTER JOIN OrderProduct " +
                    "ON orpd_prnum = product_num " +
                    "JOIN `Order` ON orpd_ornum = order_num " +
                    "JOIN Customer ON order_cunum = customer_num " +
                    "where product_canum = %d " +
                    "GROUP BY age " +
                    "order by age", canum);
            r = s.executeQuery(sql);
            for (int i = 1; i < 6; i++) {
                if (r.next()) {
                    while(r.getInt("age") != i*10) {
                        arr.add(0);
                        i++;
                    }
                    arr.add(r.getInt("COUNT(orpd_count)"));
                } else {
                    arr.add(0);
                }
            }
            return arr;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (r != null)
                    r.close();
                s.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return arr;
    }
}
