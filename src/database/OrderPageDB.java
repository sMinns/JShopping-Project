package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderPageDB {
    public static List<List<String>> orderProductList(int CustomerNum, List<Integer> prnum) {
        Statement s = null;
        ResultSet r = null;
        List<List<String>> arr = new ArrayList<>();
        String[] col = { "product_num", "product_name", "seller_name", "sb_count", "product_price"};
        String list = "";
        try {
            s = Database.con.createStatement();
            for(int i = 0; i < prnum.size(); i++) {
                list += prnum.get(i);
                if(i != prnum.size()-1) { list += ", "; }
            }
            String sql = String.format("select * from Product join ShoppingBasket " +
                    "on product_num = sb_prnum join Seller " +
                    "on product_cunum = seller_num " +
                    "where sb_cunum = %d AND " +
                    "product_num in (%s)", CustomerNum, list);
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
            sql = String.format("insert into `Order` (order_num, order_orderer, order_phonenum, order_address, " +
                            "order_desireddate, order_cunum, order_date) values " +
                            "(%d, '%s', '%s', '%s', '%s', '%s', '%s')",
                    Info[0], Info[1], Info[2], Info[3], Info[5], Info[6], Info[7]);
        }else {
            sql = String.format("insert into `Order` (order_num, order_orderer, order_phonenum, order_address, " +
                            "order_request, order_desireddate, order_cunum, order_date) values " +
                            "(%s, '%s', '%s', '%s', '%s', '%s', '%s', '%s')",
                    Info[0], Info[1], Info[2], Info[3], Info[4], Info[5], Info[6], Info[7]);
        }
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
    public static int returnOrderNum(String date) {
        Statement s = null;
        ResultSet r = null;
        try {
            s = Database.con.createStatement();
            String sql = String.format("select count(*) from `Order` " +
                    "where order_date = '%s'", date);
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
    public static boolean InsertOrderProduct(List<List<String>> str, String ornum) {
        Statement s = null;
        String sql = "insert into OrderProduct (orpd_ornum, orpd_count, orpd_stat, orpd_prnum) values ";
        String temp;
        try {
            for(int i = 0; i < str.size(); i++) {
                temp = String.format("(%s, %d, '결제완료', %d)", ornum, Integer.parseInt(str.get(i).get(3)), Integer.parseInt(str.get(i).get(0)));
                if(i != str.size()-1) { temp += ", "; }
                sql += temp;
            }
            s = Database.con.createStatement();
            int u = s.executeUpdate(sql);
            s.close();
            if(u == str.size())
                return true;
            else
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean clearShoppingBasket(int cunum, List<Integer> prnum) {
        Statement s = null;
        String list = "";
        for(int i = 0; i < prnum.size(); i++) {
            list += prnum.get(i);
            if(i != prnum.size()-1) { list += ", "; }
        }
        try {
            s = Database.con.createStatement();
            String sql = String.format("delete from ShoppingBasket " +
                    "where sb_cunum = %d AND " +
                    "sb_prnum in (%s)", cunum, list);
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
