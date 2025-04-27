import java.util.Scanner;

public class PomodoMate {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter focus time in minutes (default 25): ");
        String focusInput = scanner.nextLine().trim();
        int focusMinutes = focusInput.isEmpty() ? 25 : Integer.parseInt(focusInput);

        System.out.print("Enter break time in minutes (default 5): ");
        String breakInput = scanner.nextLine().trim();
        int breakMinutes = breakInput.isEmpty() ? 5 : Integer.parseInt(breakInput);

        System.out.println("Starting focus session for " + focusMinutes + " minutes...");
        Thread.sleep(focusMinutes * 60 * 1000);

        System.out.println("Time's up! Break for " + breakMinutes + " minutes...");
        Thread.sleep(breakMinutes * 60 * 1000);

        System.out.println("Session complete!");

        scanner.close();
    }
}