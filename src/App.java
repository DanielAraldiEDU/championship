import java.util.Date;

public class App {
  public static void main(String[] args) throws Exception {
    Team team = new Team(0, "Mercedes");

    Racetrack racetrack = new Racetrack("Interlagos");

    Organizer organizer = new Organizer("FIA");

    int championshipIndex = organizer.createChampionship(2023, "F1");
    organizer.subscribe(team, championshipIndex);
    organizer.addRace(racetrack, new Date(), championshipIndex);
  }
}
