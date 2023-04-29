import java.util.Date;

public class App {
  public static void main(String[] args) throws Exception {
    // Create Cars
    Car firstCar = new Car(123);
    Car secondCar = new Car(456);
    Car[] cars = new Car[2];
    cars[0] = firstCar;
    cars[1] = secondCar;

    // Create Pilots
    Pilot firstPilot = new Pilot(123, "David Doe", firstCar);
    Pilot secondPilot = new Pilot(456, "Joseph Doe", secondCar);
    Pilot[] pilots = new Pilot[2];
    pilots[0] = firstPilot;
    pilots[1] = secondPilot;

    // Create Mechanics
    Mechanic firstMechanic = new Mechanic("John Doe");
    Mechanic secondMechanic = new Mechanic("Jane Doe");
    Mechanic[] mechanics = new Mechanic[2];
    mechanics[0] = firstMechanic;
    mechanics[1] = secondMechanic;

    // Create Team
    Team team = new Team(123456, "Bug Team", mechanics, cars, pilots);

    // Create Organizer
    Organizer organizer = new Organizer("FIA");
    organizer.createChampionship(2023, "F1");
    organizer.subscribe(team);
  }
}
