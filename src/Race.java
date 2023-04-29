import java.util.Date;

public class Race {
  private Date date;
  public Racetrack racetrack;

  public Race(Racetrack racetrack, Date date) {
    this.racetrack = racetrack;
    this.date = date;
  }
}
