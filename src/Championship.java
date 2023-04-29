import java.util.Date;

public class Championship {
  private int year;
  private String name;
  public Race[] races;
  public Team[] teams;

  public Championship(int year, String name) {
    this.name = name;
    this.year = year;
    this.races = new Race[20];
  }

  public void createRace(Racetrack racetrack, Date date) {
    if (this.races.length == 20 && this.races[19] != null) {
      System.out.println("The championship is full.");
      return;
    } else {
      for (int i = 0; i < this.races.length; i++) {
        if (this.races[i] == null) {
          this.races[i] = new Race(racetrack, date);
          System.out.println("Race created.");
          return;
        }
      }
    }
  }

  public Team[] getTeams() {
    return this.teams;
  }

  public void setTeams(Team[] teams) {
    this.teams = teams;
  }
}