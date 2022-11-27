package database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductManagementDB {
    public static List<List<String>> productList(int cunum, String text) {
        Statement s = null;
        ResultSet r = null;
        List<List<String>> arr = new ArrayList<>();
        String[] col = { "product_num", "category_name", "product_name",
                "product_price", "product_stat", "product_stock" };
        try {
            s = Database.con.createStatement();
            String sql = String.format("select * from Product join Category " +
                    "on product_canum = category_num " +
                    "where product_cunum = %d AND " +
                    "product_name like '%%%s%%'", cunum, text);
            r = s.executeQuery(sql);
            while (r.next()) {
                List<String> arrRowItems = new ArrayList<>();
                for(int i = 0; i < 6; i++) {
                    if(i == 0 || i == 3 || i == 5) {
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

    public static List<String> changeInfo(int prnum) {
        Statement s = null;
        ResultSet r = null;
        List<String> arr = new ArrayList<>();
        String[] col = { "product_name", "category_name",
                "product_price", "product_stock", "product_stat" };
        try {
            s = Database.con.createStatement();
            String sql = String.format("select * from Product join Category " +
                    "on product_canum = category_num " +
                    "where product_num = %d", prnum);
            r = s.executeQuery(sql);
            if (r.next()) {
                List<String> arrRowItems = new ArrayList<>();
                for(int i = 0; i < 5; i++) {
                    if(i == 2 || i == 3) {
                        arr.add(String.valueOf(r.getInt(col[i])));
                    }else {
                        arr.add(r.getString(col[i]));
                    }
                }
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

    public static boolean updateProductInfo(String[] info, String prnum) {
        PreparedStatement s = null;
        try {
            if (info[0] == null) {
                String sql = String.format("update Product set product_name = '%s', " +
                                "product_canum = %d, " +
                                "product_price = %d, " +
                                "product_stock = %d, " +
                                "product_stat = '%s' " +
                                "where product_num = '%d'", info[1], Integer.parseInt(info[2]), Integer.parseInt(info[3]),
                        Integer.parseInt(info[4]), info[5], Integer.parseInt(prnum));
                s = Database.con.prepareStatement(sql);
            }else {
                String sql = String.format("update Product set product_image = ?, " +
                                "product_name = '%s', " +
                                "product_canum = %d, " +
                                "product_price = %d, " +
                                "product_stock = %d, " +
                                "product_stat = '%s' " +
                                "where product_num = '%d'", info[1], Integer.parseInt(info[2]), Integer.parseInt(info[3]),
                        Integer.parseInt(info[4]), info[5], Integer.parseInt(prnum));
                s = Database.con.prepareStatement(sql);
                File image = new File(info[0]);
                FileInputStream fis = new FileInputStream(image);
                s.setBinaryStream(1, fis, (int) image.length());
            }
            int i = s.executeUpdate();
            if(i == 1) {
                return true;
            }else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                s.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean deleteProduct(int num) {
        Statement s = null;
        try {
            s = Database.con.createStatement();
            String sql = String.format("delete from Product " +
                    "where product_num = %d", num);
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
