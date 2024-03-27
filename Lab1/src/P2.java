import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input the person's salary: $");
        int salary = scanner.nextInt();
        System.out.print("Input the person's merit: ");
        int merit = scanner.nextInt();
        char grade;
        if (500 <= salary && salary <= 599) {
            grade = 'C';
        } else if (600 <= salary && salary <= 649) {
            if (merit < 10) {
                grade = 'C';
            } else {
                grade = 'B';
            }
        } else if (700 <= salary && salary <= 799) {
            if (merit < 20) {
                grade = 'B';
            } else {
                grade = 'A';
            }
        } else {
            grade = 'A';
        }
        System.out.println("Grade " + grade);
    }
}
