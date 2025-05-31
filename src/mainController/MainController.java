package mainController;

import entity.Management;
import enums.ManageStatus;
import mainService.MainService;

import java.util.Scanner;

public class MainController {
    Scanner intScanner = new Scanner(System.in);
    Scanner strScanner = new Scanner(System.in);

    MainService mainService = new MainService();

    public void start() {
        while (true) {
            System.out.println("""
                1. ADD THE PROFIT
                2. ADD EXPENSES
                3. PROFIT'S LIST
                4. EXPENSE'S LIST
                5. TOTAL PROFITS PRICE
                6. TOTAL EXPENSES PRICE
                7. OVERALL
                """);

            System.out.print("Choose an option: ");

            int option = intScanner.nextInt();

            switch (option) {
                case 1 -> {
                    addProfit();
                }
                case 2 -> {
                    addExpenses();
                }
                case 3 -> {
                    profitsList();
                }
                case 4 -> {
                    expensesList();
                }
                case 5 -> {
                    totalProfitsReport();
                }
                case 6 -> {
                    totalExpensesReport();
                }
                case 7 -> {
                    overAllReport();
                }

            }
        }
    }

    private void addProfit() {
        System.out.println("Add the profit");

        System.out.print("Where did your profits come from: ");
        strScanner.nextLine();
        String title = strScanner.nextLine();

        System.out.print("How much money $ has come to you: ");
        double money = strScanner.nextDouble();

        if (mainService.addTransactionValue(title, money, ManageStatus.MONEY_PROFIT)) {
            System.out.println("Profits successfully added");
        }else {
            System.out.println("Error occured during transaction!!!");
        }
    }

    private void addExpenses() {
        System.out.println("Add the expenses: ");

        System.out.print("Where did you spend your money $ ?: ");

        strScanner.nextLine();
        String title = strScanner.nextLine();

        System.out.print("How much money $ did you spend?: ");
        double money = strScanner.nextDouble();

        mainService.addTransactionValue(title, money, ManageStatus.FLOW_OF_MONEY);
        System.out.println("Profits successfully added");
    }

    public void profitsList() {
        System.out.println("Profits list");

        Management [] profitsList = mainService.getTransactionList(ManageStatus.MONEY_PROFIT);

        for (Management data: profitsList) {
            System.out.println("------------------------------------------------------------------");

            System.out.println("Title: " + data.getTitle());
            System.out.println("Money: " + data.getPrice() + " $ ");
            System.out.println("Status: " + data.getManageStatus());

            System.out.println("------------------------------------------------------------------");
        }

        System.out.println("Profits fetched!");
    }

    private void expensesList() {
        System.out.println("Expenses list");

        Management [] expenseList = mainService.getTransactionList(ManageStatus.FLOW_OF_MONEY);

        for (Management data: expenseList) {
            System.out.println("------------------------------------------------------------------");

            System.out.println("Title: " + data.getTitle());
            System.out.println("Money: " + data.getPrice() + " $ ");
            System.out.println("Status: " + data.getManageStatus());

            System.out.println("------------------------------------------------------------------");
        }

        System.out.println("Expenses fetched!");
    }

    private void totalProfitsReport() {
        System.out.println("Profits overall price: ");
        double profitOverAll = mainService.totalTransactionValue(ManageStatus.MONEY_PROFIT);
        System.out.println("Total profit price: " + profitOverAll + " $ " );
    }

    private void totalExpensesReport() {
        System.out.println("Expenses overall price: ");
        double expensesOverAll = mainService.totalTransactionValue(ManageStatus.FLOW_OF_MONEY);
        System.out.println("Total expenses price: " + expensesOverAll + " $ " );
    }

    private void overAllReport() {
        System.out.println("Overall report");

        double profits = mainService.totalTransactionValue(ManageStatus.MONEY_PROFIT);
        double expenses = mainService.totalTransactionValue(ManageStatus.FLOW_OF_MONEY);

        double overAll = profits - expenses;

        if (overAll < 0) {
            System.out.println("Your debt is " + overAll + " $");
        }else {
            System.out.println("Congratulations! Your state: " + overAll );
        }
    }
}
