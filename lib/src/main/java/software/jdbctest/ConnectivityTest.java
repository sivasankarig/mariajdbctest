package software.jdbctest;

import java.sql.*;

public class ConnectivityTest {


    public static void main(String[] args) {

        String url=args[0];
        String username=args[1];
        String password=args[2];
        String tablename=args[3];
        String sql="describe "+tablename;
        System.out.print("FieldName");
        System.out.print("," + "FieldType");
        System.out.println();
        // Open a connection
        try(Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                // Retrieve by column name
                System.out.print(rs.getString(1));
                System.out.print("," + rs.getString(2));
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
