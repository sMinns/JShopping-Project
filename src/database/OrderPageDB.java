package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderPageDB {
    public static List<List<String>> orderProductList(int CustomerNum) {
        Statement s = null;
        ResultSet r = null;
        List<List<String>> arr = new ArrayList<>();
        String[] col = { "product_num", "product_name", "seller_name", "sb_count", "product_price"};
        try {
            s = Database.con.createStatement();
            String sql = String.format("select * from Product join ShoppingBasket " +
                    "on product_num = sb_prnum join Seller " +
                    "on product_cunum = seller_num " +
                    "where sb_cunum = %d", CustomerNum);
            r = s.executeQuery(sql);
            while (r.next()) {
                List<String> arrRowItems = new ArrayList<>();
                for(int i = 0; i < 4; i++) {
                    if(i == 0) {
                        arrRowItems.add(String.valueOf(r.getInt(col[i])));
                    }else if(i == 3) {
                        arrRowItems.add(String.valueOf(r.getInt(col[3])));
                        arrRowItems.add(String.valueOf(r.getInt(col[3]) * r.getInt(col[4])));
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

    public static boolean InsertOrder(String[] Info) {
        Statement s = null;
        String sql;
        if(Info[3].equals("")) {
            sql = String.format("insert into `Order` (order_orderer, order_phonenum, order_address, " +
                            "order_desireddate, order_cunum, order_date) values " +
                            "('%s', '%s', '%s', '%s', '%s', '%s')",
                    Info[0], Info[1], Info[2], Info[4], Info[5], Info[6]);
        }else {
            sql = String.format("insert into `Order` (order_orderer, order_phonenum, order_address, " +
                            "order_request, order_desireddate, order_cunum, order_date) values " +
                            "('%s', '%s', '%s', '%s', '%s', '%s', '%s')",
                    Info[0], Info[1], Info[2], Info[3], Info[4], Info[5], Info[6]);
        }
        System.out.println(sql);
        try {
            s = Database.con.createStatement();
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
