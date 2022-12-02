package database;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderManagementDB {
    public static List<List<String>> productList(int cunum, String text, boolean checkBox, String combo) {
        Statement s = null;
        ResultSet r = null;
        String stat = null;
        List<List<String>> arr = new ArrayList<>();
        String[] col = { "orpd_ornum", "product_num", "product_name",
                "order_orderer", "order_phonenum", "orpd_count", "product_price",
                "order_desireddate", "orpd_stat" };
        try {
            s = Database.con.createStatement();
                String sql = String.format("select * from `Order` join OrderProduct " +
                        "on order_num = orpd_ornum " +
                        "join Product " +
                        "on orpd_prnum = product_num " +
                        "where product_cunum = %d", cunum);
            if(!checkBox)
                sql += " AND not orpd_stat = '배송완료'";
            if(!text.equals("") || !text.equals(" "))
                sql += " AND " + combo + " like '%" + text + "%'";
            r = s.executeQuery(sql);
            while (r.next()) {
                List<String> arrRowItems = new ArrayList<>();
                for(int i = 0; i < 9; i++) {
                    if(i == 5 || i == 6) {
                        arrRowItems.add(String.valueOf(r.getInt(col[i])));
                    }else {
                        arrRowItems.add(r.getString(col[i]));
                    }
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

    public static String returnOrderAddress(String ornum) {
        Statement s = null;
        ResultSet r = null;
        try {
            s = Database.con.createStatement();
            String sql = String.format("select order_address from `Order` " +
                    "where order_num = '%s'", ornum);
            r = s.executeQuery(sql);
            if (r.next()) {
                return r.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
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

    public static void updateOrderProductStat(String stat, int prnum, String ornum) {
        Statement s = null;
        try {
            s = Database.con.createStatement();
            String sql = String.format("update OrderProduct set orpd_stat = '%s' " +
                    "where orpd_prnum = %d AND " +
                    "orpd_ornum = '%s'", stat, prnum, ornum);
            s.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                s.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static int ordercount(int cunum) {
        Statement s = null;
        ResultSet r = null;
        try {
            s = Database.con.createStatement();
                String sql = String.format("select count(order_num) from `Order` join OrderProduct " +
                        "on order_num = orpd_ornum join Product " +
                        "on product_num = orpd_prnum join Customer " +
                        "on product_cunum = customer_num " +
                        "where customer_num = %d ", cunum);
            r = s.executeQuery(sql);
            if (r.next()) {
                return r.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(r != null)
                    r.close();
                s.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }
}
