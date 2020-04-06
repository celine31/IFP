import java.sql.*;

public class Main {


  public static void main(String[] args ) throws SQLException {
   JournalisteDao journaliste = new JournalisteDao();
   journaliste.connecter();
  //Ajout ajout=new Ajout();
  //ajout.ajouterNews("test", "le monde merveilleux des tests ");
 // ajout.ajouterNewsJournaliste("ordinateur", "blablablabla", "Paul");

  }

}
