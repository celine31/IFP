import java.sql.*;

public class JournalisteDao {

  private ConnectionManager cm;
  //reporter vide


  public JournalisteDao() {
    this.cm = new ConnectionManager();
  }
 // public journaliste readById(int reporterId) {}

  public void connecter() {
    try {
      var cx = cm.getConnection();
      System.out.println("connecté");
      System.out.println("lire journaliste à partir de son ID");
      Statement statement = cx.createStatement();
      //recuperation et affichage en fonction de l'id du journaliste
      ResultSet resultset = statement.executeQuery("SELECT nom, credit FROM Journaliste WHERE id=1");
      ResultSetMetaData resultSetMetaData = resultset.getMetaData();

        if (resultset.getRow() == 1) {
          System.out.print("\t" + resultset.getRowId(1).toString() + "\t |");
        }
     resultset.close();
     statement.close();

///////////////////////////////////////
      System.out.println(" \n lire une news à partir de son ID : ");
      Statement statement2=cx.createStatement();
      //recuperation et affichage du journaliste en fonction de son id
      ResultSet resultset2= statement2.executeQuery("SELECT titre, contenu FROM News WHERE id=1");
      ResultSetMetaData resultSetMetaData2= resultset2.getMetaData();

      while(resultset2.next()){
        for(int i = 1; i <= resultSetMetaData2.getColumnCount(); i++)
          System.out.print("\t" + resultset2.getObject(i).toString() + "\t |");
      }
      resultset2.close();
      statement2.close();

      ///////////////////////////////////////
      System.out.println(" \n lire une news à partir de son ID et en affichant le nom du journaliste : ");
      Statement statement3=cx.createStatement();
      //recuperation et affichage du journaliste en fonction de son id
      ResultSet resultset3= statement3.executeQuery("SELECT News.titre, News.contenu , Journaliste.nom FROM News INNER JOIN Journaliste ON News.journaliste=Journaliste.Id WHERE News.Id=1");
      ResultSetMetaData resultSetMetaData3= resultset3.getMetaData();

      while(resultset3.next()){
        for(int i = 1; i <= resultSetMetaData3.getColumnCount(); i++)
          System.out.print("\t" + resultset3.getObject(i).toString() + "\t |");
      }
      resultset3.close();
      statement3.close();
      ///////////////////////////////////////////
      System.out.println("\n lire une news en récupérant ses tags");
      PreparedStatement statement4 = cx.prepareStatement("SELECT News.titre, News.contenu, Tag.nom FROM News INNER JOIN NewsTag ON News.Id= NewsTag.IdNews INNER JOIN Tag ON NewsTag.IdTag = Tag.Id WHERE News.Id=1");
      ResultSet rs =statement4.executeQuery();

      while(rs.next()){
        System.out.print( "titre de l'article : " + rs.getString("titre") + ", contenu de l'article : " + rs.getString ("contenu") + ", nom du tag : " + rs.getString("nom"));
      }
      statement4.close();
    } catch (SQLException e) {
      e.printStackTrace();

    }

  }

}
