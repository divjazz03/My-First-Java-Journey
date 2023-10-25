import java.util.HashMap;
import java.util.Set;

public class Bank {
    private final HashMap<Integer, BankAccount> accounts;

    private  int nextAcct;

    private BankAccountType bankAccountType;

    public Bank(HashMap<Integer, BankAccount> accounts, int n){
        this.accounts = accounts;
        nextAcct = n;
    }

    public int newAccount(BankAccountType bankAccountType, boolean isForeign){
        this.bankAccountType = bankAccountType;
        int acctNum = nextAcct++;
        BankAccount ba = null ;
        switch (bankAccountType){
            case SAVINGS -> ba = new SavingsAccount(acctNum);
            case CHECKING -> ba = new CheckingAccount(acctNum);
            default -> throw new IllegalArgumentException("Account type Does not exist");
        }
        ba.setForeign(isForeign);
        accounts.put(acctNum, ba);
        return acctNum;
    }
    public int getBalance(int acctNum){

        BankAccount ba = accounts.get(acctNum);
        return ba.getBalance();
    }

    public void deposit(int acctNum, int amt){
        BankAccount ba = accounts.get(acctNum);
        ba.deposit(amt);
    }

    public boolean authorizeLoan(int acctNum, int loanAmt){
        BankAccount ba = accounts.get(acctNum);
        return ba.hasEnoughCollateral(loanAmt);
    }

    @Override
    public String toString(){
       String result = "The bank has " + accounts.size() + " accounts.";
       for (BankAccount ba : accounts.values()){
           result += "\n\t" + ba.toString();
       }
       return result;
    }

    public void addInterest(){
        for (BankAccount ba : accounts.values()){
            ba.addInterest();
        }
    }

    public void setForeign(int acctNum, boolean isForeign){
        BankAccount ba = accounts.get(acctNum);
        ba.setForeign(isForeign);
    }
}
