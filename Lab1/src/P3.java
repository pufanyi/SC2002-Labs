import java.util.Scanner;

public class P3 {
    public static double usToSgd(int us) {
        final double RATE = 1.82;
        return us * RATE;
    }

    private static void creatingTableUsingFor(int starting, int ending, int increment) {
        System.out.println("US$          S$");
        System.out.println("---------------");
        for (int now = starting; now <= ending; now += increment) {
            System.out.printf("%-13d%2f\n", now, usToSgd(now));
        }
    }


    private static void creatingTableUsingWhile(int starting, int ending, int increment) {
        System.out.println("US$          S$");
        System.out.println("---------------");
        int now = starting;
        while (now <= ending) {
            System.out.printf("%-13d%2f\n", now, usToSgd(now));
            now += increment;
        }
    }


    private static void creatingTableUsingDoWhile(int starting, int ending, int increment) {
        System.out.println("US$          S$");
        System.out.println("---------------");
        int now = starting;
        do {
            System.out.printf("%-13d%2f\n", now, usToSgd(now));
            now += increment;
        } while (now < ending);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int starting, ending, increment;
        System.out.print("Starting: ");
        starting = scanner.nextInt();
        System.out.print("Ending: ");
        ending = scanner.nextInt();
        System.out.print("Increment: ");
        increment = scanner.nextInt();
        System.out.println();
        System.out.println("Using For:");
        creatingTableUsingFor(starting, ending, increment);
        System.out.println();
        System.out.println("Using While:");
        creatingTableUsingWhile(starting, ending, increment);
        System.out.println();
        System.out.println("Using Do-While:");
        creatingTableUsingDoWhile(starting, ending, increment);
    }

}
