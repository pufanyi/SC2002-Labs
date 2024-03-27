import java.util.Scanner;

public class P4 {
    public static void main(String[] args) {
        int height;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input height: ");
        height = scanner.nextInt();
        if (height <= 0) {
            System.out.println("Error input!!");
            return;
        }
        for (int nowHeight = 1; nowHeight <= height; ++nowHeight) {
            String nowString;
            if (nowHeight % 2 == 1) {
                nowString = "AA";
            } else {
                nowString = "BB";
            }
            for (int column = 1; column <= nowHeight; ++column) {
                System.out.print(nowString);
                if (nowString.equals("AA")) {
                    nowString = "BB";
                } else {
                    nowString = "AA";
                }
            }
            System.out.println();
        }
    }
}
