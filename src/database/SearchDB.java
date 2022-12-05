package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SearchDB {
    //정렬이 포함된 검색
    public static List<List<String>> productList(String text, int orderType, String categoryName) {
        Statement s = null;
        ResultSet r = null;
        String order = null;
        String category = "";

        List<List<String>> arr = new ArrayList<>();
        String[] col = { "product_num", "product_name", "category_name",
                         "product_date", "product_price"};
        try {
            s = Database.con.createStatement();
        
            if (orderType == 0)
            order = "count(*) desc";
        else if (orderType == 1)
            order = "product_price desc";
        else if (orderType == 2)
            order = "product_price asc";
        else if (orderType == 3)
            order = "product_date desc";
        if (!categoryName.equals("전체"))
            category = String.format(" and category_name = '%s'", categoryName);
            String sql = String.format("select product_num, product_name, category_name, "+
                                        "product_date, product_price from Product " + 
                                        "left outer join Review on (product_num = Review.review_prnum) left outer join Category on (product_canum = category_num) " +
                                        "where product_name like '%%%s%%' and product_stat = '판매중' %s" + 
                                        "group by product_num order by %s", text, category, order);
            r = s.executeQuery(sql);
            while (r.next()) {
                List<String> arrRowItems = new ArrayList<>();
                for(int i = 0; i < 5; i++) {
                    if(i == 4) {
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
}

