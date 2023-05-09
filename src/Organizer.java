import java.util.Date;

public class Organizer {
  private String name;
  public Championship[] championships;

  public Organizer(String name) {
    this.name = name;
    this.championships = new Championship[12];
  }

  public int createChampionship(int year, String name) {
    for(int index = 0; index < this.championships.length; index++) {
      if (this.championships[index] != null) {
        this.championships[index] = new Championship(year, name);
        return index;
      }
    }

    System.out.println("Championship doesn't created.");
    return -1;
  }

  public boolean subscribe(Team team, int championshipNumber) {
    if (this.championships[championshipNumber] == null) {
      System.out.println("Championship doesn't exists!");
      return false;
    } else {
      this.championships[championshipNumber].addTeam(team);
      System.out.println("Team subscribed.");
      return true;
    }
  }

  public void addRace(Racetrack racetrack, Date date, int championshipNumber) {
    if (this.championships[championshipNumber] == null) {
      System.out.println("Championship doesn't exists!");
    } else {
      this.championships[championshipNumber].createRace(racetrack, date);;
      System.out.println("Race added.");
    }
  }
}