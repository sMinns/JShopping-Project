package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class SubOrderListDB {

    public static boolean deleteReview(int review_num) {
        Statement s = null;
        int isDeleted;
        try {
            s = Database.con.createStatement();
            String sql = String.format("delete from Review where review_num = %d", review_num);
            isDeleted = s.executeUpdate(sql);
            s.close();
            if (isDeleted != 0)
                return true;
            else
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static boolean insertReview(String text,int star,int cu_num,int pr_num) {
        Statement s = null;
        int isinserted;
        Date now = Calendar.getInstance().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String nowdate = formatter.format(now);
        int date = Integer.parseInt(nowdate);
        int nextnum=0;

        nextnum = SubOrderListDB.searchReviewmaxnum();

        try {
            s = Database.con.createStatement();
            String sql = String.format("insert into Review values (%d,'%s',%d,%d,%d,%d)", nextnum,text,date,star,pr_num,cu_num);
            isinserted = s.executeUpdate(sql);

            s.close();
            if (isinserted != 0)
                return true;
            else
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static int searchReviewmaxnum() {
        Statement s = null;
        ResultSet r = null;
        int nextnum=0;
        try {
            s = Database.con.createStatement();


            String sql = String.format("select max(review_num) from Review");
            r = s.executeQuery(sql);
            while (r.next()) {
                nextnum = r.getInt(1);
            }
            return nextnum+1;
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
        return nextnum;
    }

    public static String[] myreview(int cu_num,int pr_num) {
        Statement s = null;
        ResultSet r = null;
        String[] result= {"","","",""};

        String[] col = { "review_num","review_post", "review_date","review_star"};

        try {
            s = Database.con.createStatement();
            String sql = String.format("select * from Review where review_cunum = %d AND review_prnum = %d", cu_num, pr_num);
            r = s.executeQuery(sql);
            while (r.next()) {
                for(int i = 0; i < 4; i++) {
                    if(i == 3) {
                        result[i] = r.getInt(col[i])+"";
                    }else {
                        result[i] = r.getString(col[i]);
                    }
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
    public static int searchReviewnum(int pr_num, int cu_num) {
        Statement s = null;
        ResultSet r = null;
        int nextnum=0;
        try {
            s = Database.con.createStatement();


            String sql = String.format("select review_num from Review where review_prnum = %d AND review_cunum = %d",pr_num,cu_num);
            r = s.executeQuery(sql);
            while (r.next()) {
                nextnum = r.getInt(1);
            }
            return nextnum;
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
        return nextnum;
    }



}