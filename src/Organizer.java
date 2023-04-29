import java.util.Date;

public class Organizer {
  private String name;
  public Championship championships;

  public Organizer(String name) {
    this.name = name;
  }

  public void createChampionship(int year, String name) {
    this.championships = new Championship(2023, "F1");
    this.championships.createRace(new Racetrack("United States"), new Date());
  }

  public boolean subscribe(Team team) {
    if (this.championships == null) {
      System.out.println("There is no championship. Try create one.");
      return false;
    } else {
      Team[] teams = this.championships.getTeams();
      if (teams == null) {
        teams = new Team[12];
        teams[0] = team;
        this.championships.setTeams(teams);
        return true;
      } else {
        for (int i = 0; i < teams.length; i++) {
          if (teams.length == 12) {
            System.out.println("The championship is full.");
            return false;
          }

          if (teams[i] == null) {
            teams[i] = team;
            this.championships.setTeams(teams);
            return true;
          }
        }

        return false;
      }
    }
  }
}