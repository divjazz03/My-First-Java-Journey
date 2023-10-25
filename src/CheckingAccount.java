import javax.swing.plaf.basic.BasicLookAndFeel;

public class CheckingAccount implements BankAccount, Comparable<BankAccount> {


    private int acctNum;

    private int balance = 0;
    private boolean isForeign = false;

    public CheckingAccount(int acctNum) {
        this.acctNum = acctNum;
    }

    @Override
    public int getAcctNum() {
        return acctNum;
    }

    @Override
    public int getBalance() {
        return balance;
    }

    @Override
    public boolean isForeign() {
        return isForeign;
    }

    @Override
    public void setForeign(boolean isForeign) {
        this.isForeign = isForeign;
    }

    @Override
    public void deposit(int amt) {
        balance += amt;
    }

    @Override
    public boolean hasEnoughCollateral(int loanAmt) {
        return balance >= 2 * (loanAmt /3);
    }

    @Override
    public String toString(){
        return "Checking account " + acctNum + ": balance="
                + balance + ", is "
                + (isForeign ? "foreign" : "domestic");
    }

    @Override
    public void addInterest() {

    }

    @Override
    public int compareTo(BankAccount o) {
        int bal1 = this.getBalance();
        int bal2 = o.getBalance();
        if (bal1 == bal2)
            return getAcctNum() - o.getAcctNum();
        else
            return bal1 - bal2;
    }
}
