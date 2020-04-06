
import org.junit.platform.commons.function.Try;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionManager {

  private static String url = "jdbc:derby:db/ifp_db";

  public Connection getConnection() throws SQLException {
    try {
      Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
      System.out.println("driver ok");
      Connection cx = DriverManager.getConnection(url);
      return cx;
    } catch (ClassNotFoundException e) {
      throw new SQLException(e);

    }
  }
}
