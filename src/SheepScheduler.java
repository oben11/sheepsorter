// Oliver Benjamin CSE 146



import java.io.*;
import java.util.Scanner;

public class SheepScheduler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter file name: ");
            String fileName = scanner.nextLine();

            try {
                SheepSchedulerProgram scheduler = new SheepSchedulerProgram(fileName);
                scheduler.simulateShearing();
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Current directory: " + System.getProperty("user.dir"));
            }

            System.out.print("Would you like to run the simulation again? (yes/no): ");
        } while (scanner.nextLine().equalsIgnoreCase("yes"));
        scanner.close();
    }
}
