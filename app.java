import java.util.*;
import java.io.*;

class app {
    Scanner s = new Scanner(System.in);
    File f = new File("expense.csv");

    // Constructor to check if the file exists or not
    app() throws IOException {
        if (f.createNewFile()) {
            FileWriter fw = new FileWriter(f, true);
            BufferedWriter bw = new BufferedWriter(fw); // used to append new data to the file in CSV format

            bw.write("Date,Category,Amount\n"); // add a header to the file
            bw.close();
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
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write(date + "," + category + "," + amount + "\n"); // writing into the file
        bw.close();

        System.out.println("Expense Added Successfully!");
    }

    void view_expense() throws IOException {
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);

        String line = br.readLine(); // Skip the header for printing only expenses
        boolean found = false;

        System.out.println("\n----------------------------");
        System.out.println("Your Expenses:");
        System.out.println("----------------------------");

        while ((line = br.readLine()) != null) {
            String[] detail = line.split(",");
            System.out.println("Date: " + detail[0] + " | Category: " + detail[1] + " | Amount: ₹" + detail[2]);
            found = true;
        }

        if (!found) {
            System.out.println("No expenses found.");
        }

        System.out.println("----------------------------");
        br.close();
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
