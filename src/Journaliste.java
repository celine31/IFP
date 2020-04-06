public class Journaliste {
  private String nom;
  private Integer credit;

  public Journaliste(String nom, Integer credit) {
    this.nom = nom;
    this.credit = credit;
  }

  public String getNom() {
    return nom;
  }

  public Integer getCredit() {
    return credit;
  }
}
