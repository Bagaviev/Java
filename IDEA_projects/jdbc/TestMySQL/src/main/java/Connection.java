import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Properties;

public class Connection {
    static String PROPERTIES_PATH = "src/main/resources/props.properties";
    static Properties props;
    static String url;
    static String username;
    static String password;

    // JDBC variables for opening and managing connection
    private static Statement stmt;
    private static ResultSet rs;
    private static java.sql.Connection con;

    static {
        props = new Properties();
        try (InputStream in = Files.newInputStream(Paths.get(PROPERTIES_PATH))) {
            props.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        url = props.getProperty("url");
        username = props.getProperty("user");
        password = props.getProperty("password");
    }

    public Connection() {
    }

    public static void getCount() throws ClassNotFoundException {
        String query = "select count(*) from city";
        Class.forName("com.mysql.cj.jdbc.Driver");

        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, username, password);

            // getting Statement object to execute query
            stmt = con.createStatement();

            // executing SELECT query
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                int count = rs.getInt(1);
                System.out.println("Total number of books in the table : " + count);
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    public static void getRows() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, username, password);

            // getting Statement object to execute query
            // TODO: разобраться с SQL Inject protected queries
            PreparedStatement stmt = con.prepareStatement("select * from city where id > ? order by id desc limit 5");
            stmt.setInt(1, 4076);
            // TODO: Done!

            // executing SELECT query
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String countryCode = rs.getString(3);
                String district = rs.getString(4);
                int population = rs.getInt(5);
                System.out.printf("id: %d, name: %s, countryCode: %s, district: %s, population: %d"
                        , id, name, countryCode, district, population);
                System.out.println();
            }

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    private static void insertRow() throws ClassNotFoundException {
        String query = "insert into city values (6666, 'bebis', 'rus', 'parashka', 9999999)";
        Class.forName("com.mysql.cj.jdbc.Driver");

        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, username, password);
            // getting Statement object to execute query
            stmt = con.createStatement();

            // do INSERT query
            stmt.executeUpdate(query);

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    private static void removeRow(int id) throws ClassNotFoundException {
        String query = String.format("delete from city where id = %d", id);       // Nablus
        Class.forName("com.mysql.cj.jdbc.Driver");

        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, username, password);

            // getting Statement object to execute query
            stmt = con.createStatement();

            // do INSERT query
            stmt.executeUpdate(query);

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    private static void updateRows(int id, String name) throws ClassNotFoundException {
        String query = String.format("UPDATE city SET name = '%s' WHERE id = %d", name, id);       // Nablus
        Class.forName("com.mysql.cj.jdbc.Driver");

        try {
            // opening database connection to MySQL server
            con = DriverManager.getConnection(url, username, password);

            // getting Statement object to execute query
            stmt = con.createStatement();

            // do INSERT query
            stmt.executeUpdate(query);

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    public static void main(String args[]) throws ClassNotFoundException {
        getCount();
//        insertRow();
//        removeRow(4078);
//        updateRows(6666, "bulat");
        getRows();
    }
}
