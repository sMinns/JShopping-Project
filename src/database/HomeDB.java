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

    public static List<String> returnHomeProductName(List<Integer> prnums) {
        Statement s = null;
        ResultSet r = null;
        List<String> arr = new ArrayList<>();
        String list = "";
        try {
            s = Database.con.createStatement();
            for (int i = 0; i < prnums.size(); i++) {
                list += prnums.get(i);
                if (i != prnums.size() - 1) {
                    list += ", ";
                }
            }
            String sql = String.format("SELECT product_name from Product " +
                            "where product_num in (%s)", list);
            r = s.executeQuery(sql);
            for (int i = 0; i < 6; i++) {
                if (r.next()) {
                    arr.add(r.getString("product_name"));
                } else {
                    arr.add("상품이 부족합니다.");
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
}
