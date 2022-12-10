import javax.xml.crypto.Data;
import java.io.*;
import java.sql.*;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class Database {
    public static Connection con = null;
    public static void main(String[] args) {
        new Progress();
        int random;
        for (int i = 0; i < 100; i++) {
            Progress.percent++;
            Progress.prog.repaint();
            if(i == 30) {
                makeConnection();
            }else if (i == 50) {
                createTables();
            }else if(i == 80) {
                insertCategory();
                insertData();
            }
            random = (int) (Math.random() * 100);
            if(random < 50) { random = 50; }
            try {
                if(i == 99) {
                    Thread.sleep(2000);
                    System.exit(0);
                }
                Thread.sleep(random);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static Connection makeConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이버 적재 성공");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/?useSSL=false&user=root&password=1234");
            createDatabase();
            con = DriverManager.getConnection("jdbc:mysql://localhost/jshopping", "root", "1234");
            System.out.println("데이터베이스 연결 성공");
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버를 찾을 수 없습니다.");
        } catch (SQLException e) {
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public static void createDatabase() {
        Statement s = null;
        String sql = "";
        String l = "";
        BufferedReader inputStreamLine = null;
        try {
            inputStreamLine = new BufferedReader(new InputStreamReader(Database.class.getResourceAsStream("/sql/create_database.sql")));
            s = con.createStatement();
            while ((l = inputStreamLine.readLine()) != null) {
                sql += l;
            }

            StringTokenizer st = new StringTokenizer(sql, ";");
            String sa = st.nextToken();
            while (sa != null) {
                int i = s.executeUpdate(sa);
                sa = st.nextToken();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchElementException e) {
            try {
                s.close();
            } catch (SQLException ex) {
                System.exit(0);
            }
            System.out.println("데이터베이스 생성 완료");
        }
    }

    public static void createTables() {
        Statement s = null;
        String sql = "";
        String l = "";
        BufferedReader inputStreamLine = null;
        try {
            inputStreamLine = new BufferedReader(new InputStreamReader(Database.class.getResourceAsStream("/sql/shopping_db.sql")));
            s = con.createStatement();
            while ((l = inputStreamLine.readLine()) != null) {
                sql += l;
            }

            StringTokenizer st = new StringTokenizer(sql, ";");
            String sa = st.nextToken();
            while (sa != null) {
                int i = s.executeUpdate(sa);
                sa = st.nextToken();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchElementException e) {
            try {
                s.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            System.out.println("테이블 생성 완료");
        }
    }

    public static void insertCategory() {
        Statement s = null;
        String sql = "";
        String l = "";
        BufferedReader inputStreamLine = null;
        try {
            inputStreamLine = new BufferedReader(new InputStreamReader(Database.class.getResourceAsStream("/sql/insert_category.sql")));
            s = con.createStatement();
            while ((l = inputStreamLine.readLine()) != null) {
                sql += l;
            }
            StringTokenizer st = new StringTokenizer(sql, ";");
            String sa = st.nextToken();
            while (sa != null) {
                int i = s.executeUpdate(sa);
                sa = st.nextToken();
            }
            s.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchElementException e) {
            try {
                s.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            System.out.println("카테고리 추가 완료");
        }
    }

    public static void insertData() {
        Statement s = null;
        String sql = "";
        String l = "";
        BufferedReader inputStreamLine = null;
        try {
            inputStreamLine = new BufferedReader(new InputStreamReader(Database.class.getResourceAsStream("/sql/InsertData.sql")));
            inputStreamLine = new BufferedReader(new FileReader("/sql/InsertData"));
            s = con.createStatement();
            while ((l = inputStreamLine.readLine()) != null) {
                sql += l;
            }
            StringTokenizer st = new StringTokenizer(sql, ";");
            String sa = st.nextToken();
            while (sa != null) {
                int i = s.executeUpdate(sa);
                sa = st.nextToken();
            }
            s.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchElementException e) {
            try {
                s.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            System.out.println("데이터 추가 완료");
        }
    }
}
