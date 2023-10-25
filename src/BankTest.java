import java.util.HashMap;

public class BankTest {

        private static HashMap<Integer, BankAccount> accts = new HashMap<Integer, BankAccount>();


      private static final  Bank bank = new Bank(accts, 0);
        private static int acct = bank.newAccount(BankAccountType.SAVINGS,true);


    public static void main(String[] args) {
        verifyBalance("initial amount", 0);
        bank.deposit(acct, 10);
        verifyBalance("after deposit", 10);
        verifyLoan("authorize bad loan", 22, false);
        verifyLoan("authorize good loan", 20, false);
    }

    public static void verifyBalance(String msg, int expectedVal){
        int bal = bank.getBalance(acct);
        boolean ok = (bal == expectedVal);
        String result = ok ? "Good! " : "Bad!";
        System.out.println(msg + ": " + result);
    }

    private static void verifyLoan(String msg, int loanAmt, boolean expectedVal){
        boolean answer= bank.authorizeLoan(acct, loanAmt);
        boolean ok = answer == expectedVal;
        String result = ok ? "Good" : "Bad";
        System.out.println(msg + ": " + result);
    }
}
