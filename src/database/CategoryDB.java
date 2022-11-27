package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDB {
    public static List<String> categoryList() {
        Statement s = null;
        ResultSet r = null;
        List<String> items = new ArrayList<>();
        try {
            s = Database.con.createStatement();
            String sql = String.format("select category_name from Category");
            r = s.executeQuery(sql);
            while (r.next()) {
                items.add(r.getString("category_name"));
            }
            return items;
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

    public static int returnCategoryNum(String name) {
        Statement s = null;
        ResultSet r = null;
        try {
            s = Database.con.createStatement();
            String sql = String.format("select category_num from Category " +
                    "where category_name = '%s'", name);
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
}
