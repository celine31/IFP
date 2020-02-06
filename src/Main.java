import java.sql.*;

public class Main {


  public static void main(String[] args ) {
    connecter();
  }
  public static Connection connecter(){
    try{
      String url="jdbc:derby:db/ifp_db";
      Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
      System.out.println("driver ok");
      var cx= DriverManager.getConnection(url);
      //var reponse = cx.prepareStatement("SELECT nom FROM Journaliste");
      System.out.println("connecté");

      Statement statement=cx.createStatement();
      //recuperation et affichage en fonction de l'id du journaliste
      ResultSet resultset= statement.executeQuery("SELECT * FROM Journaliste WHERE id=1");
      ResultSetMetaData resultSetMetaData= resultset.getMetaData();

      //On affiche le nom des colonnes
     /* for(int i = 1; i <= resultSetMetaData.getColumnCount(); i++)
        System.out.print("\t" + resultSetMetaData.getColumnName(i).toUpperCase() + "\t " + "\n");*/

      while(resultset.next()){
        for(int i = 1; i <= resultSetMetaData.getColumnCount(); i++)
          System.out.print("\t" + resultset.getObject(i).toString() + "\t |");
         }

      resultset.close();
      statement.close();
///////////////////////////////////////
    /*  Statement statement2=cx.createStatement();
      //recuperation et affichage du journaliste en fonction de son id
      ResultSet resultset2= statement2.executeQuery("SELECT * FROM Journaliste WHERE id=1");
      ResultSetMetaData resultSetMetaData2= resultset2.getMetaData();

      //On affiche le nom des colonnes
      for(int i = 1; i <= resultSetMetaData2.getColumnCount(); i++)
        System.out.print("\t" + resultSetMetaData2.getColumnName(i).toUpperCase() + "\t " + "\n");

      while(resultset2.next()){
        for(int i = 1; i <= resultSetMetaData2.getColumnCount(); i++)
          System.out.print("\t" + resultset2.getObject(i).toString() + "\t |");
      }
      resultset2.close();
      statement2.close();

*/

    } catch (ClassNotFoundException | SQLException e) {
      e.printStackTrace();
      return null;
    }
  return null;
  }
}
