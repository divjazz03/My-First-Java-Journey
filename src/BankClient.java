import java.util.Scanner;
import java.util.Set;

public class BankClient {
    private int current = -1;
    private Scanner scanner;

    private boolean done = false;

    private Bank bank;

    public BankClient(Scanner scanner, Bank bank){
        this.scanner = scanner;
        this.bank = bank;
    }

    public void run(){
        scanner = new Scanner(System.in);
        while (!done){
            System.out.println("Enter command (0=quit, 1=new, 2=select," +
                    " 3=deposit, 4=loan, 5=show, 6=interest, 7=setForeign): ");
            int cmd = scanner.nextInt();
            processCommand(cmd);
        }
        scanner.close();
    }

    private void processCommand(int cmd){
        switch (cmd){
            case 0 -> quit();
            case 1 -> newAccount();
            case 2 -> select();
            case 3 -> deposit();
            case 4 -> authorizeLoan();
            case 5 -> showAll();
            case 6 -> addInterest();
            case 7 -> setForeign();
            default -> System.out.println("illegal command");
        }
    }

    private void select() {
        System.out.print("Enter account#: ");
        current = scanner.nextInt();
        int balance = bank.getBalance(current);
        System.out.println("The balance of account " + current + "is " + balance);
    }

    private void setForeign(){
        bank.setForeign(current, requestForeign());
    }

    private boolean requestForeign(){
        System.out.println("Enter 1 for foreign, " +
                "2 for domestic: ");
        int val = scanner.nextInt();
        return val==1;
    }
    private void deposit() {
        System.out.println("Enter deposit amount: ");
        int amt = scanner.nextInt();
        bank.deposit(current, amt);

    }

    private void addInterest() {
        bank.addInterest();
    }

    private void showAll() {
        System.out.println(bank.toString());
    }

    private void authorizeLoan() {
        System.out.println("Enter loan amount: ");
        int loanAmt = scanner.nextInt();
        if (bank.authorizeLoan(current, loanAmt)){
            System.out.println("Your loan is approved");
            return;
        }
        System.out.println("Your loan is denied");

    }

    private void newAccount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter type of Account SAVINGS OR CHECKING");
        String typeOfAccount = sc.nextLine().toUpperCase().trim();
        current = bank.newAccount(BankAccountType.valueOf(typeOfAccount), requestForeign());
        System.out.println("Your new account number is " + current);
    }

    private void quit() {
        done = true;
        System.out.println("Goodbye!");
    }
}
