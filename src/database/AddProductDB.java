package database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddProductDB {
    public static boolean addProduct(String[] productStringInfo, int[] productIntInfo) {
        PreparedStatement s = null;
        try {
            String sql = String.format("insert into Product (product_name, product_image, product_canum, " +
                        "product_price, product_stock, product_stat, product_date, product_cunum) values " +
                        "('%s', ?, %d, %d, %d, '%s', '%s', %d)",
                    productStringInfo[0], productIntInfo[0], productIntInfo[1], productIntInfo[2],
                    productStringInfo[2], productStringInfo[3], productIntInfo[3]);
            s = Database.con.prepareStatement(sql);
            File image = new File(productStringInfo[1]);
            FileInputStream fis = new FileInputStream(image);
            s.setBinaryStream(1, fis, (int)image.length());
            int i = s.executeUpdate();
            s.close();
            if(i == 1)
                return true;
            else
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}
