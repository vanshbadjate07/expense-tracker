import java.util.*;
import java.io.*;

class app {
    Scanner s = new Scanner(System.in);
    File f = new File("expense.csv");

    // Constructor to check if the file exists or not
    app() throws IOException {
        if (f.createNewFile()) {
            FileWriter fw = new FileWriter(f, true);
            fw.write("Date,Category,Amount\n"); // add a header to the file
            fw.close();
        }
    }

    void add_expense() throws IOException {
        System.out.println("\nEnter Date (dd-mm-yy): ");
        String date = s.next();

        System.out.println("Enter Category: ");
        String category = s.next();

        System.out.println("Enter Amount: ");
        double amount = s.nextDouble();

        FileWriter fw = new FileWriter(f, true);
        fw.write(date + "," + category + "," + amount + "\n"); // writing into the file
        fw.close();

        System.out.println("Expense Added Successfully!");
    }

    void view_expense() throws IOException {
        FileReader fr = new FileReader(f);
        StringBuilder sb = new StringBuilder();
        int i;

        // Reading the file character by character
        while ((i = fr.read()) != -1) {
            sb.append((char) i);
        }
        fr.close();

        String[] lines = sb.toString().split("\n");
        boolean found = false;

        System.out.println("\n----------------------------");
        System.out.println("Your Expenses:");
        System.out.println("----------------------------");

        for (int j = 1; j < lines.length; j++) { // Start from 1 to skip the header
            String[] detail = lines[j].split(",");
            System.out.println("Date: " + detail[0] + " | Category: " + detail[1] + " | Amount: ₹" + detail[2]);
            found = true;
        }

        if (!found) {
            System.out.println("No expenses found.");
        }

        System.out.println("----------------------------");
    }

    public static void main(String args[]) throws IOException {
        System.out.println("\n----------------------------");
        System.out.println("Welcome To Expense Tracker!");
        System.out.println("----------------------------");
        app a = new app();

        while (true) {
            System.out.println("\n1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Exit App");
            System.out.print("Select an option: ");
            int choice = a.s.nextInt();

            if (choice == 1) {
                a.add_expense();
            } else if (choice == 2) {
                a.view_expense();
            } else if (choice == 3) {
                System.out.println("Exiting... Byee!");
                break;
            } else {
                System.out.println("Enter a valid choice!");
            }
        }
    }
}
