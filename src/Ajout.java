import java.sql.*;


public class Ajout {
  public void ajouterNews(String titre, String contenu)  {
    try {
      String url = "jdbc:derby:db/ifp_db";
      Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
      System.out.println("driver ok");
      var cx = DriverManager.getConnection(url);
      System.out.println("connecté");

      //PreparedStatement statement = cx.prepareStatement("INSERT INTO News (titre, contenu) VALUES (' "+ titre + "','" + contenu + "')");
      String sql = "INSERT INTO News (titre, contenu) VALUES ('"+ titre +" ',' "+ contenu + " ')";
      PreparedStatement statement = cx.prepareStatement(sql);
      statement.executeUpdate();
      System.out.println("ajouté en base de donnée  ");

      PreparedStatement statement2 = cx.prepareStatement("SELECT * FROM News");
      ResultSet rs =statement2.executeQuery();

      while(rs.next()){
        System.out.print( "titre de l'article : " + rs.getString("titre") + ", contenu de l'article : " + rs.getString ("contenu") );
      }
    } catch (SQLException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
  public void ajouterNewsJournaliste(String titre, String contenu)  {
    try {
      String url = "jdbc:derby:db/ifp_db";
      Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
      System.out.println("driver ok");
      var cx = DriverManager.getConnection(url);
      System.out.println("connecté");

      //PreparedStatement statement = cx.prepareStatement("INSERT INTO News (titre, contenu) VALUES (' "+ titre + "','" + contenu + "')");
      String sql = "INSERT INTO News (titre, contenu) VALUES ('"+ titre +" ',' "+ contenu + " ')";
      PreparedStatement statement = cx.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      statement.executeUpdate();
      System.out.println("ajouté en base de donnée  ");

      PreparedStatement statement2 = cx.prepareStatement("SELECT * FROM News");
      ResultSet rs =statement2.executeQuery();

      while(rs.next()){
        System.out.print( "titre de l'article : " + rs.getString("titre") + ", contenu de l'article : " + rs.getString ("contenu") );
      }
    } catch (SQLException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}
