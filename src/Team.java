public class Team {
  private int number;
  private String name;
  public Mechanic[] mechanics;
  public Car[] cars;
  public Pilot[] pilots;

  public Team(int number, String name) {
    this.number = number;
    this.name = name;
    this.mechanics = new Mechanic[999];
    this.cars = new Car[2];
    this.pilots = new Pilot[2];
  }

  public void addCar(Car car, Pilot pilot) {
    for (int i = 0; i < this.cars.length; i++) {
      if (this.cars[i] == null) {
        this.cars[i] = car;
        this.pilots[i] = pilot;
        break;
      }
    }

  }

  public void addMechanic(Mechanic mechanic) {
    for (int i = 0; i < this.mechanics.length; i++) {
      if (this.mechanics[i] == null) {
        this.mechanics[i] = mechanic;
        break;
      }
    }
  }
}
