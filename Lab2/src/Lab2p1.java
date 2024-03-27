import java.util.Scanner;

public class Lab2p1 {
    public static void main(String[] args) {
        int choice;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Perform the following methods:");
            System.out.println("1:multiplication test");
            System.out.println("2:quotient using division by subtraction");
            System.out.println("3:remainder using division by subtraction");
            System.out.println("4:count the number of digits");
            System.out.println("5:position of a digit");
            System.out.println("6:extract all odd digits");
            System.out.println("7:quit");
            choice = sc.nextInt();
            int m, n;
            switch (choice) {
                case 1:
                    mulTest();
                    break;
                case 2:
                    System.out.print("Please enter two positive integers m and n: ");
                    m = sc.nextInt();
                    n = sc.nextInt();
                    System.out.println(m + " / " + n + " = " + divide(m, n));
                    break;
                case 3:
                    System.out.print("Please enter two positive integers m and n: ");
                    m = sc.nextInt();
                    n = sc.nextInt();
                    System.out.println(m + " % " + n + " = " + modulus(m, n));
                    break;
                case 4:
                    System.out.print("Please enter a positive integer n: ");
                    n = sc.nextInt();
                    try {
                        System.out.println("There are " + countDigits(n) + " digits in " + n);
                    } catch (ArithmeticException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.print("Please enter two positive integers n and digit: ");
                    System.out.println("position = " + position(sc.nextInt(), sc.nextInt()));
                    break;
                case 6:
                    System.out.print("Please enter a positive integer n: ");
                    try {
                        System.out.println("oddDigits = " + extractOddDigits(sc.nextLong()));
                    } catch (ArithmeticException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    System.out.println("Program terminating....");
            }
        } while (choice < 7);
    }

    public static int getOneDigitInt() {
        return (int) (Math.random() * 9) + 1;
    }

    public static void mulTest() {
        final int NUM_OF_TEST_CASE = 5;
        int numOfCorrect = 0;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < NUM_OF_TEST_CASE; ++i) {
            int x = getOneDigitInt(), y = getOneDigitInt();
            System.out.println("How much is " + x + " times " + y + "?");
            int studentAnswer = scanner.nextInt();
            if (studentAnswer == x * y) {
                numOfCorrect++;
            }
        }
        System.out.println(numOfCorrect + " answers out of " + NUM_OF_TEST_CASE + " are correct.");
    }

    public static int divide(int m, int n) {
        if (m < n) {
            return 0;
        }
        return 1 + divide(m - n, n);
    }

    public static int modulus(int m, int n) {
        return m - n * divide(m, n);
    }

    public static int countDigits(int n) throws ArithmeticException {
        if (n < 0) {
            throw new ArithmeticException("Error input!!");
        }
        int ans = 0;
        do {
            n /= 10;
            ans++;
        } while (n != 0);
        return ans;
    }

    public static int position(int n, int digit) {
        int ans = 0;
        do {
            ans++;
            if (n % 10 == digit) {
                return ans;
            }
            n /= 10;
        } while (n != 0);
        return -1;
    }

    public static long extractOddDigits(long n) throws ArithmeticException {
        if (n < 0) {
            throw new ArithmeticException("Error input!!");
        }
        long ans = 0;
        long nowBin = 1;
        do {
            if (n % 2 == 1) {
                ans += n % 10 * nowBin;
                nowBin *= 10;
            }
            n /= 10;
        } while (n != 0);
        if (ans == 0) {
            return -1;
        }
        return ans;
    }
}