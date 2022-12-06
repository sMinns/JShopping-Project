package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShoppingBasketDB {
    public static List<List<String>> shoppingBasketList(int CustomerNum) {
        Statement s = null;
        ResultSet r = null;
        List<List<String>> arr = new ArrayList<>();
        String[] col = { "customer_name", "product_num", "product_name", "product_price", "sb_count"};
        try {
            s = Database.con.createStatement();
            String sql = String.format("select * from Product join ShoppingBasket on (product_num = sb_prnum) " +
                                       "join Customer on (customer_num = product_cunum) " + 
                                       "where sb_cunum = %d order by product_cunum", CustomerNum);
            r = s.executeQuery(sql);
            while (r.next()) {
                List<String> arrRowItems = new ArrayList<>();
                for(int i = 0; i < 5; i++) {
                    if(i == 1 || i == 3 || i == 4) {
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
    public static boolean deleteShoppingBasketList(int CustomerNum, int productNum) {
        Statement s = null;
        int isDeleted;
        try {
            s = Database.con.createStatement();
            String sql = String.format("delete from ShoppingBasket where sb_cunum = %d and sb_prnum = %d", CustomerNum, productNum);
            isDeleted = s.executeUpdate(sql);
            s.close();
            if (isDeleted != 0)
                return true;
            else
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
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

    public static boolean updateCount(int count, int prnum) {
        Statement s = null;
        try {
            s = Database.con.createStatement();
            String sql = String.format("update ShoppingBasket set sb_count = %d " +
                    "where sb_prnum = %d", count, prnum);
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
