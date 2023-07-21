import java.util.Scanner;

public class Main {
    private static int minIncome = 5000;
    private static int maxIncome = 20000;

    private static int officeRentCharge = 4000;
    private static int telephonyCharge = 900;
    private static int internetAccessCharge = 300;

    private static int assistantSalary = 2000;
    private static int financeManagerSalary = 3000;

    private static double mainTaxPercent = 0.6;
    private static double managerPercent = 0.3;

    private static double minInvestmentsAmount = 3000;

    public static void main(String[] args) {
        while (true) {
            System.out.println("enter the company's monthly income " +
                "(from 5 to 20 thousand dollars): ");
            int income = (new Scanner(System.in)).nextInt();

            if (!checkIncomeRange(income)) {
                continue;
            }

            double managerSalary = income * managerPercent;
            double pureIncome = income - managerSalary -
                calculateFixedCharges();
            double taxAmount = mainTaxPercent * pureIncome;
            double pureIncomeAfterTax = pureIncome - taxAmount;

            boolean canMakeInvestments = pureIncomeAfterTax >=
                minInvestmentsAmount;

            System.out.println("Manager salary: " + managerSalary);
            System.out.println("Total amount of taxes: " +
                (taxAmount > 0 ? taxAmount : 0));
            System.out.println("Company can invest: " +
                (canMakeInvestments ? "yes" : "no"));
            if (pureIncome < 0) {
                System.out.println("Budget down! Need to make money fast!");
            }
        }
    }

    private static boolean checkIncomeRange(int income) {
        if (income < minIncome) {
            System.out.println("Income below the upper limit");
            return false;
        }
        if (income > maxIncome) {
            System.out.println("Income above the upper limit");
            return false;
        }
        return true;
    }

    private static int calculateFixedCharges() {
        return officeRentCharge +
            telephonyCharge +
            internetAccessCharge +
            assistantSalary +
            financeManagerSalary;
    }
}
