package database;

import java.sql.*;
import system.Setup;

public class SubProductDetailDB {
    public static void addToShoppingBasket(int productNum) {
        ResultSet r = null;
        Statement s = null;
        try {
            s = Database.con.createStatement();
            String sql = String.format("select * from ShoppingBasket where sb_cunum = %d and sb_prnum = %d", Setup.CustomerNum, productNum);
            r = s.executeQuery(sql);
            if (!r.next()) {
                sql = String.format("insert into ShoppingBasket values(%d, %d, %d)", Setup.CustomerNum, 1, productNum);
                s.executeUpdate(sql);
            }
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
}

