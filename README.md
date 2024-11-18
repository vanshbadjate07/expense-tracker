# Expense Tracker App

A simple Java-based Expense Tracker app that allows users to add, view, and manage their daily expenses. The app stores data in a CSV file (`expense.csv`) to keep track of the user's expenses, including the date, category, and amount.

---

## Features

- **Add Expense**: Allows the user to add an expense by entering the date, category, and amount. The expense is stored in a CSV file.
- **View Expense**: Displays all the stored expenses, showing the date, category, and amount for each expense.
- **Persistent Storage**: Expenses are saved in a CSV file (`expense.csv`), ensuring data persistence even after the app is closed.

---

## Code Structure

- **app.java**: Contains the main logic of the expense tracker. It handles adding, viewing expenses, and file operations.
  - **add_expense()**: Method to add a new expense to the CSV file.
  - **view_expense()**: Method to display all stored expenses from the CSV file.
  - **main()**: Main method to display the menu and interact with the user.

---

- **expense.csv**: The file where all expenses are saved in a CSV format. Each line represents an expense with the date, category, and amount.

---

## License

This project is open-source and available under the MIT License.
