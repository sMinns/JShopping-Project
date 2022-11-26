package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SellerApplicationDB {
    public static boolean sellerAppDuplicateCheck(int num) {
        Statement s = null;
        ResultSet r = null;
        try {
            s = Database.con.createStatement();
            String sql = String.format("select count(*) from Seller " +
                    "where seller_num = '%s'", num);
            r = s.executeQuery(sql);
            if (r.next()) {
                if(r.getInt(1) == 0) {
                    return true;
                }else {
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                r.close();
                s.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean insertSellerApp(int num, String[] sellerAppInfo) {
        Statement s = null;
        try {
            s = Database.con.createStatement();
            String sql = String.format("insert into Seller (seller_num, seller_name, seller_represent, seller_phone, " +
                            "seller_email, seller_registnum, seller_stat, seller_appdate) values " +
                            "(%d, '%s', '%s', '%s', '%s', '%s', '%s', '%s')",
                    num, sellerAppInfo[0], sellerAppInfo[1], sellerAppInfo[2], sellerAppInfo[3],
                    sellerAppInfo[4], sellerAppInfo[5], sellerAppInfo[6]);
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
