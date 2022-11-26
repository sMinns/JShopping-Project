package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SellerManagementDB {
    public static List<List<String>> sellerList() {
        Statement s = null;
        ResultSet r = null;
        List<List<String>> arr = new ArrayList<>();
        String[] c = { "seller_num", "seller_name", "seller_represent", "seller_phone",
            "seller_email", "seller_registnum" };
        try {
            s = Database.con.createStatement();
            String sql = String.format("select * from Seller");
            r = s.executeQuery(sql);
            while (r.next()) {
                if(!r.getString("seller_stat").equals("승인대기")) {
                    List<String> arrRowItems = new ArrayList<>();
                    for (String col : c) {
                        arrRowItems.add(r.getString(col));
                    }
                    arr.add(arrRowItems);
                }
            }
            return arr;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                r.close();
                s.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return arr;
    }

    public static boolean deleteData(int num) {
        Statement s = null;
        try {
            s = Database.con.createStatement();
            String sql = String.format("delete from Seller " +
                            "where seller_num = %d", num);
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
