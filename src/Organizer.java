import java.util.Date;

public class Organizer {
  private String name;
  public Championship[] championships;

  public Organizer(String name) {
    this.name = name;
    this.championships = new Championship[12];
  }

  public int createChampionship(int year, String name) {
    for (int index = 0; index < this.championships.length; index++) {
      if (this.championships[index] == null) {
        this.championships[index] = new Championship(year, name);
        return index;
      }
    }

    System.out.println("Campeonato não foi criado!");
    return -1;
  }

  public boolean subscribe(Team team, int championshipNumber) {
    if (this.championships[championshipNumber] == null) {
      System.out.println("O Campeonato informado não existe!");
      return false;
    } else {
      this.championships[championshipNumber].addTeam(team);
      return true;
    }
  }

  public void addRace(Racetrack racetrack, Date date, int championshipNumber) {
    if (this.championships[championshipNumber] == null) {
      System.out.println("O Campeonato informado não existe!");
    } else {
      this.championships[championshipNumber].createRace(racetrack, date);
    }
  }
}