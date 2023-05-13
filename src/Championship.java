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
    this.teams = new Team[12];
  }

  public void createRace(Racetrack racetrack, Date date) {
    for (int index = 0; index < this.races.length; index++) {
      if (this.races[this.races.length - 1] != null) {
        System.out.println("O Campeonato já está cheio!");
        return;
      }

      if (this.races[index] == null) {
        this.races[index] = new Race(racetrack, date);
        System.out.println("Corrida adicionada!");
        return;
      }
    }
  }

  public void addTeam(Team team) {
    for (int i = 0; i < this.teams.length; i++) {
      if (this.teams[i] == null) {
        this.teams[i] = team;
        System.out.println("Time adicionado!");
        return;
      }
    }
  }

  public String getName() {
    return this.name;
  }
}