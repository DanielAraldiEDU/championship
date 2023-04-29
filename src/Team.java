public class Team {
  private int number;
  private String name;
  public Mechanic[] mechanics;
  public Car[] cars;
  public Pilot[] pilots;

  public Team(int number, String name, Mechanic[] mechanics, Car[] cars, Pilot[] pilots) {
    this.number = number;
    this.name = name;
    this.mechanics = mechanics;
    this.cars = cars;
    this.pilots = pilots;
  }
}
