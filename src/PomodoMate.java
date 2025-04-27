import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Scanner;

public class PomodoMate {
    public static void main(String[] args) throws InterruptedException, IOException {
        Scanner scanner = new Scanner(System.in);

        // ---- XP Display ----
        int xp = 0;
        Path xpFile = Paths.get("xp.txt");
        if (Files.exists(xpFile)) {
            String content = Files.readAllLines(xpFile).get(0).trim();
            if (!content.isEmpty()) xp = Integer.parseInt(content);
        }

        int level = 0, threshold = 1;
        while (threshold <= xp) {
            level++;
            threshold *= 2;
        }

        System.out.println("Welcome back! You’re at level " + level + " with " + xp + " XP.");
        // ---------------------

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

        // ---- XP Tracking ----
        xp += 1;
        Files.write(xpFile, Collections.singletonList(String.valueOf(xp)));

        level = 0;
        threshold = 1;
        while (threshold <= xp) {
            level++;
            threshold *= 2;
        }

        System.out.println("You earned 1 XP! Total XP: " + xp);
        if (xp == (threshold / 2)) {
            System.out.println("🎉 Level up! You’re now level " + level);
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