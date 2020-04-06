import org.apache.derby.client.am.DateTime;

import java.util.ArrayList;

public class New {
  private String titre;
  private String contenu;
  private DateTime date;
  private Integer idJournaliste;
  private ArrayList<Tag> tag;

  public New(String titre, String contenu, DateTime date, Integer idJournaliste, ArrayList<Tag> tag) {
    this.titre = titre;
    this.contenu = contenu;
    this.date = date;
    this.idJournaliste = idJournaliste;
    this.tag = tag;
  }

  public String getTitre() {
    return titre;
  }

  public String getContenu() {
    return contenu;
  }

  public DateTime getDate() {
    return date;
  }

  public Integer getIdJournaliste() {
    return idJournaliste;
  }

  public ArrayList<Tag> getTag() {
    return tag;
  }
}
