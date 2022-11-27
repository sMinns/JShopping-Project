package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FindIDDB {
    public static String idFind(String name, String date) {
        Statement s = null;
        ResultSet r = null;
        try {
            s = Database.con.createStatement();
            String sql = String.format("select customer_id from Customer " +
                    "where customer_name = '%s' " +
                    "AND customer_birth = '%s'", name, date);
            r = s.executeQuery(sql);
            if (r.next()) {
                return r.getString(1);
            }else {
                return null;
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
}
