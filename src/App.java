import java.util.Date;
import java.util.Scanner;

public class App {
  public static void main(String[] args) throws Exception {
    Organizer organizer = null;
    int championshipIndex = -1;
    int choice;

    do {
      Scanner scanner = new Scanner(System.in);
      String name;

      System.out.print(
          "\n1. Criar Organizador\n2. Criar Campeonato\n3. Criar e Inscrever Time\n4. Adicionar Corrida\n0. Sair\n\nOpcao: ");
      choice = scanner.nextInt();

      switch (choice) {
        case 1:
          scanner.nextLine();

          System.out.print("Digite o nome: ");
          name = scanner.nextLine();

          organizer = new Organizer(name);
          System.out.println("Organizador criado!");
          break;
        case 2:
          if (organizer == null) {
            System.out.println("Organizador não foi criado!");
            break;
          }

          scanner.nextLine();
          System.out.print("\nDigite o ano: ");
          int year = scanner.nextInt();

          scanner.nextLine();
          System.out.print("Digite o nome do campeonato: ");
          name = scanner.nextLine();
          System.out.println("Campeonato criado: " + name);

          championshipIndex = organizer.createChampionship(year, name);
          break;
        case 3:
          scanner.nextLine();
          System.out.print("\nDigite o nome: ");
          name = scanner.nextLine();

          System.out.print("Digite o número do Time: ");
          int number = scanner.nextInt();
          Team team = new Team(number, name);

          for (int i = 0; i < team.cars.length; i++) {
            scanner.nextLine();
            System.out.print("Digite um nome para o Piloto: ");
            name = scanner.nextLine();

            System.out.print("Digite a licença: ");
            int license = scanner.nextInt();
            Pilot pilot = new Pilot(license, name);

            System.out.println("Carro deste Piloto: ");

            scanner.nextLine();
            System.out.print("Número de chassi do Carro: ");
            int chassiNumber = scanner.nextInt();
            Car car = new Car(chassiNumber, pilot);

            team.addCar(car, pilot);
            System.out.println("Piloto e Carro criado!");
          }

          boolean addNewMechanic = true;

          while (addNewMechanic || team.mechanics.length == 0) {
            System.out.print("Digite um nome para o Mecânico: ");
            name = scanner.nextLine();
            Mechanic mechanic = new Mechanic(name);

            team.addMechanic(mechanic);

            scanner.nextLine();
            System.out.print("Deseja adicionar outro mecânico? (true/false): ");
            addNewMechanic = scanner.nextBoolean();
          }

          if (organizer == null || championshipIndex == -1) {
            System.out.println((organizer == null ? "\nOrganizador" : "\nCampeonato") + " não foi criado!");
            break;
          }

          System.out.println();
          for (int i = 0; i < organizer.championships.length; i++) {
            if (organizer.championships[i] != null) {
              System.out.println(i + " - " + organizer.championships[i].getName());
            } else {
              break;
            }
          }

          do {
            scanner.nextLine();
            System.out.print("Digite o número do campeonato: ");
            championshipIndex = scanner.nextInt();

            if (championshipIndex >= 0 && championshipIndex < organizer.championships.length) {
              if (organizer.championships[championshipIndex] != null) {
                organizer.subscribe(team, championshipIndex);
                break;
              }
            } else {
              System.out.println("Campeonato inexistente. Tente novamente!");
            }
          } while (championshipIndex < 0 || championshipIndex >= organizer.championships.length
              || organizer.championships[number] == null);

          System.out.println("Time criado e inscrito!");

          break;
        case 4:
          if (organizer == null || championshipIndex == -1) {
            System.out.println((organizer == null ? "\nOrganizador" : "\nCampeonato") + " não foi criado!");
            break;
          }

          scanner.nextLine();
          System.out.print("Digite o lugar do Autrodomo: ");
          String place = scanner.nextLine();

          Racetrack racetrack = new Racetrack(place);

          for (int i = 0; i < organizer.championships.length; i++) {
            if (organizer.championships[i] != null) {
              System.out.println(i + " - " + organizer.championships[i].getName());
            } else {
              break;
            }
          }

          do {
            System.out.print("Digite o número do campeonato: ");
            championshipIndex = scanner.nextInt();

            if (championshipIndex >= 0 && championshipIndex < organizer.championships.length) {
              if (organizer.championships[championshipIndex] != null) {
                organizer.addRace(racetrack, new Date(), championshipIndex);
                break;
              }
            } else {
              System.out.println("\nCampeonato inexistente. Tente novamente!");
            }
          } while (championshipIndex < 0 || championshipIndex >= organizer.championships.length
              || organizer.championships[championshipIndex] == null);

          break;
        case 0:
          System.out.println("\nVocê saiu do programa!");
          break;
        default:
          System.out.println("\nOpção inválida!");
          break;
      }
    } while (choice != 0);
  }
}
