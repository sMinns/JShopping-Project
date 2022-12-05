package database;

import system.Setup;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

public class SubProductDetailDB {
    public static void addToShoppingBasket(int productNum) {
        ResultSet r = null;
        Statement s = null;
        try {
            s = Database.con.createStatement();
            String sql = String.format("select sb_prnum, sb_count from ShoppingBasket where sb_cunum = %d", Setup.CustomerNum, productNum);
            r = s.executeQuery(sql);
            while(r.next()) {
                if(r.getInt("sb_prnum") == productNum) {
                    sql = String.format("update ShoppingBasket set sb_count = %d " +
                            "where sb_prnum = %d", r.getInt("sb_count") + 1, productNum);
                    s.executeUpdate(sql);
                    return;
                }
            }
            sql = String.format("insert into ShoppingBasket values(%d, %d, %d)", Setup.CustomerNum, 1, productNum);
            s.executeUpdate(sql);
        } 
        catch (SQLException e) {
            e.printStackTrace();
        } 
        finally {
            try {
                s.close();
            } 
            catch (SQLException e) {
                e.printStackTrace();
            }
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
    public static List<List<String>> reviewListLoad(int productNum) {
        Statement s = null;
        ResultSet r = null;
        List<List<String>> arr = new ArrayList<>();
        String[] col = {"review_num", "review_post", "review_date", "review_star", "review_prnum", "review_cunum", "customer_nick"};
        try {
            s = Database.con.createStatement();
            String sql = String.format("select review_num, review_post, review_date, review_star, review_prnum, review_cunum, "
                                        + "customer_nick from Review, Customer where customer_num = review_cunum and review_prnum = %d "
                                        + "order by review_date desc", productNum);
            r = s.executeQuery(sql);
            while (r.next()) {
                List<String> arrRowItems = new ArrayList<>();
                for(int i = 0; i < 7; i++) {
                    if(i == 0 || i == 3 || i == 4 || i == 5) {
                        arrRowItems.add(String.valueOf(r.getInt(col[i])));
                    }else {
                        arrRowItems.add(r.getString(col[i]));
                    }
                }
                arr.add(arrRowItems);
            }
            return arr;
        } 
        catch (SQLException e) {
            e.printStackTrace();
        } 
        finally {
            try {
                s.close();
            } 
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}

