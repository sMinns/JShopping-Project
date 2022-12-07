package database;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderListDB {
    public static List<List<String>> OrderList(int cunum) {
        Statement s = null;
        ResultSet r = null;
        String stat = null;
        List<List<String>> arr = new ArrayList<>();
        String[] col = { "order_num", "product_image", "product_name",
                "orpd_count", "product_price", "order_desireddate", "orpd_stat","product_num"};
        try {

            s = Database.con.createStatement();
            String sql = String.format("select order_num,product_image,product_name,orpd_count,product_price,order_desireddate,orpd_stat,product_num from `Order` join OrderProduct on order_num = orpd_ornum join "
                    + "Product on orpd_prnum = product_num join Seller on product_cunum = seller_num join Customer on order_cunum = customer_num where customer_num = %d", cunum);

            r = s.executeQuery(sql);
            while (r.next()) {
                List<String> arrRowItems = new ArrayList<>();
                for(int i = 0; i < 8; i++) {
                    if(i == 3 || i == 4) {
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

    public static boolean ismyReview(int cu_num,int pr_num) {
        Statement s = null;
        ResultSet r = null;
        boolean result = false;
        try {
            s = Database.con.createStatement();


            String sql = String.format("select count(*) from Review where review_cunum = %d AND review_prnum = %d",cu_num,pr_num);
            r = s.executeQuery(sql);
            if (r.next()) {
                if(r.getInt(1)>0) {
                    result = true;
                }
            }
            return result;
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
        return result;
    }

    public static String sllername(int pr_num) {
        Statement s = null;
        ResultSet r = null;
        String result = "";
        try {
            s = Database.con.createStatement();

            String sql = String.format("select seller_name from Seller join Product on product_cunum = seller_num where product_num = %d;",pr_num);
            r = s.executeQuery(sql);
            while (r.next()) {
                result = r.getString(1);
            }
            return result;
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
        return result;
    }
}

