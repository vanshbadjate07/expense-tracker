import java.util.*;
import java.io.*;

class app{
    
    Scanner s = new Scanner(System.in);
    File f = new File("expense.csv");

    //created constructor to check if file is exist or not...
    app() throws IOException {
        if (f.createNewFile()) {
            FileWriter fw = new FileWriter(f, true);  
            BufferedWriter bw = new BufferedWriter(fw);// used for append new data to the file in a CSV format.
            bw.write("Date,Category,Amount\n");//new content means expenses will added new line for proper format 
            bw.close();
        }
    }

    void add_expense()throws IOException{
        System.out.println("\nEnter Date (dd-mm-yy): ");
        String date = s.next();

        System.out.println("Enter Category: ");
        String category = s.next();

        System.out.println("Enter Amount: ");
        double amount = s.nextDouble();

        FileWriter fw = new FileWriter(f, true);  
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write(date + "," + category + "," + amount + "\n");//writing into file by using BufferedWriter
        bw.close();

        System.out.println("Expense Added Successfully...");
    }

    void view_expense() throws IOException {
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);

        String line;
        br.readLine();

        boolean presentornot = false;

        System.out.println("Your Expenses are:\n");
        while ((line = br.readLine()) != null) {
            System.out.println(line+"\n");
            presentornot = true;
        }

        
        if (!presentornot) {// If no expenses were found...
            System.out.println("No expenses found.");
        }

        br.close();
    }

    public static void main(String args[])throws IOException{
        System.out.println("\nWelcome To Expense Tracker App...");
        app a = new app();

        while(true){
            
            System.out.println("1. Add Expense");
            System.out.println("2. View Expense");
            System.out.println("3. Exit App");
            System.out.print("Select Task: ");
            int choice = a.s.nextInt();

            if(choice == 1){
                a.add_expense();
            }
            else if(choice == 2){
                a.view_expense();
            }
            else if(choice == 3){
                System.out.println("Exiting... Thank you for using Expense Tracker!");
                break;
            }
            else{
                System.out.println("Enter Valid Choice!!");
            }
        }

        
    }
}