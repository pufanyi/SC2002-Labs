import java.util.Scanner;

public class PlaneApp {
    public static void printMenu() {
        System.out.println("(1) Show number of empty seats");
        System.out.println("(2) Show the list of empty seats");
        System.out.println("(3) Show the list of seat assignments by seat ID");
        System.out.println("(4) Show the list of seat assignments by customer ID");
        System.out.println("(5) Assign a customer to a seat");
        System.out.println("(6) Remove a seat assignment");
        System.out.println("(7) Exit");
    }

    public static void main(String[] args) {
        Plane plane = new Plane();
        printMenu();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println();
            System.out.print("Enter the number of your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    plane.showNumEmptySeats();
                    break;
                case 2:
                    System.out.println("The following seats are empty:");
                    plane.showEmptySeats();
                    break;
                case 3:
                    System.out.println("The seat assignments are as follow:");
                    plane.showAssignedSeats(true);
                    break;
                case 4:
                    System.out.println("The seat assignments are as follow:");
                    plane.showAssignedSeats(false);
                    break;
                case 5:
                    System.out.println("Assigning Seat ..");
                    System.out.print("Please enter SeatID: ");
                    int seatId = scanner.nextInt();
                    System.out.print("Please enter Customer ID: ");
                    int customerId = scanner.nextInt();
                    plane.assignSeat(seatId, customerId);
                    break;
                case 6:
                    System.out.print("Enter seatID to unassign customer from: ");
                    seatId = scanner.nextInt();
                    plane.unAssignSeat(seatId);
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 7);
    }
}
