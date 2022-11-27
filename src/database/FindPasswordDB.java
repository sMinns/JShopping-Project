package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FindPasswordDB {
    public static int findPasswordCheck(String id, String name, String date) {
        Statement s = null;
        ResultSet r = null;
        try {
            s = Database.con.createStatement();
            String sql = String.format("select customer_num from Customer " +
                    "where customer_id = '%s' " +
                    "AND customer_name = '%s' " +
                    "AND customer_birth = '%s'", id, name, date);
            r = s.executeQuery(sql);
            if (r.next()) {
                return r.getInt(1);
            }else {
                return 0;
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
}
