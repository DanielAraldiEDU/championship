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
    for (int index = 0; index < this.races.length; index++) {
      if (this.races[index] == null) {
        this.races[index] = new Race(racetrack, date);
        System.out.println("Race " + (index + 1) + " created.");
        if (index == this.races.length - 1) {
          System.out.println("The championship is full.");
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