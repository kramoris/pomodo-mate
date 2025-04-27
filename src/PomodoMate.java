import java.util.Scanner;

public class PomodoMate {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        // --- Get times ---
        System.out.print("Focus minutes (default 25): ");
        String f = scanner.nextLine().trim();
        int focus = f.isEmpty() ? 25 : Integer.parseInt(f);

        System.out.print("Break minutes (default 5): ");
        String b = scanner.nextLine().trim();
        int brk = b.isEmpty() ? 5 : Integer.parseInt(b);

        // --- Focus session ---
        System.out.println("\nStarting focus session...");
        for (int i = 1; i <= focus; i++) {
            Thread.sleep(60 * 1000);
            System.out.println("  ✔ " + i + " minute(s) done");
        }

        // --- Break session ---
        System.out.println("\nTime for a break!");
        for (int i = 1; i <= brk; i++) {
            Thread.sleep(60 * 1000);
            System.out.println("  ✔ " + i + " minute(s) done");
        }

        System.out.println("\nAll done—nice work!");
        scanner.close();
    }
}